package co.edureka.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class launchbrowser {

	
	public static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		//open the web app
		driver.navigate().to("https://amazon.com.br");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		
		if(title.equalsIgnoreCase("Amazon.in"))
			System.out.println("Title matches");
		else
			System.out.println(title);

		
		//locate a web element
		String tagname =" ";
		tagname = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)")).getText();
		System.out.println(tagname);
		
		
		//dropdown
		/*
		WebElement maisvendidos = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)"));
		Actions action = new Actions(driver);
		action.moveToElement(maisvendidos).perform();
		Thread.sleep(2000);
		
		WebElement books = driver.findElement(By.cssSelector(""));
		action.moveToElement(books);
		action.click();
		action.perform();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Fiction books")).click();
		Thread.sleep(2000);
		
		*/
		
		//Typing a text
		WebElement myElement = driver.findElement(By.id("twotabsearchtextbox"));
		myElement.sendKeys("Homo Deus");
		
		WebElement buscar = driver.findElement(By.id("nav-search-submit-button"));
		
		action.moveToElement(buscar);
		action.click();
		action.perform();
		Thread.sleep(3000);
		
		driver.findElement(By.partialLinkText("Homo Deus")).click();
		Thread.sleep(2000);
		
		/*
		//Shit the tab control
		java.util.Set<String> handles = driver.getWindowHandles();
		String winHandle1 = driver.getWindowHandle();
		handles.remove(winHandle1);
		
		String winHandle = handles.iterator().next();
		String winHandle2 = " ";
		if (winHandle != winHandle1) {
			winHandle2 = winHandle;
			
			driver.switchTo().window(winHandle2);
			System.out.println(winHandle2);
		}
		
		Thread.sleep(2000);
		*/
		
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(2000);
		
		//scroll the webpage till end
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		
		
		//iframes
		driver.get("http://demo.automationtesting.in/Frames.html");
		WebElement frame = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		
		WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));
		textbox.sendKeys("apenas automa??o");
		Thread.sleep(3000);
		
		
	}

}
