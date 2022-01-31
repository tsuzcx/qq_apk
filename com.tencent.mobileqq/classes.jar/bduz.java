import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.sdk.WebChromeClient;

class bduz
  extends WebChromeClient
{
  bduz(bdux parambdux) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (paramConsoleMessage != null)
    {
      if (paramConsoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
        break label135;
      }
      bdnw.d("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message() + " line:" + paramConsoleMessage.lineNumber() + "  page:" + bdux.a(this.a));
      bdsu.a(paramConsoleMessage.lineNumber() + ": " + paramConsoleMessage.message(), bdux.a(this.a).a(), bdux.a(this.a));
    }
    for (;;)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      label135:
      if (paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.WARNING) {
        bdnw.c("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message() + " line:" + paramConsoleMessage.lineNumber() + "  page:" + bdux.a(this.a));
      } else {
        bdnw.b("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bduz
 * JD-Core Version:    0.7.0.1
 */