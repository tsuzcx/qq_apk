import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.sdk.WebChromeClient;

class bfbh
  extends WebChromeClient
{
  bfbh(bfbf parambfbf) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (paramConsoleMessage != null)
    {
      if (paramConsoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
        break label135;
      }
      besl.d("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message() + " line:" + paramConsoleMessage.lineNumber() + "  page:" + bfbf.a(this.a));
      beyr.a(paramConsoleMessage.lineNumber() + ": " + paramConsoleMessage.message(), bfbf.a(this.a).a(), bfbf.a(this.a));
    }
    for (;;)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      label135:
      if (paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.WARNING) {
        besl.c("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message() + " line:" + paramConsoleMessage.lineNumber() + "  page:" + bfbf.a(this.a));
      } else {
        besl.b("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfbh
 * JD-Core Version:    0.7.0.1
 */