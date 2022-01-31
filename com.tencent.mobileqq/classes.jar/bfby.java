import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.sdk.WebChromeClient;

class bfby
  extends WebChromeClient
{
  bfby(bfbw parambfbw) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (paramConsoleMessage != null)
    {
      if (paramConsoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
        break label135;
      }
      betc.d("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message() + " line:" + paramConsoleMessage.lineNumber() + "  page:" + bfbw.a(this.a));
      bezi.a(paramConsoleMessage.lineNumber() + ": " + paramConsoleMessage.message(), bfbw.a(this.a).a(), bfbw.a(this.a));
    }
    for (;;)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      label135:
      if (paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.WARNING) {
        betc.c("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message() + " line:" + paramConsoleMessage.lineNumber() + "  page:" + bfbw.a(this.a));
      } else {
        betc.b("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfby
 * JD-Core Version:    0.7.0.1
 */