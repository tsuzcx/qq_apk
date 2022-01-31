import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.sdk.WebChromeClient;

class bhbk
  extends WebChromeClient
{
  bhbk(bhbi parambhbi) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (paramConsoleMessage != null)
    {
      if (paramConsoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
        break label135;
      }
      QMLog.e("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message() + " line:" + paramConsoleMessage.lineNumber() + "  page:" + bhbi.a(this.a));
      bgyd.a(paramConsoleMessage.lineNumber() + ": " + paramConsoleMessage.message(), bhbi.a(this.a).a(), bhbi.a(this.a));
    }
    for (;;)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      label135:
      if (paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.WARNING) {
        QMLog.w("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message() + " line:" + paramConsoleMessage.lineNumber() + "  page:" + bhbi.a(this.a));
      } else {
        QMLog.i("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhbk
 * JD-Core Version:    0.7.0.1
 */