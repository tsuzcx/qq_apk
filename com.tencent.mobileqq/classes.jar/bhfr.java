import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.sdk.WebChromeClient;

class bhfr
  extends WebChromeClient
{
  bhfr(bhfp parambhfp) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (paramConsoleMessage != null)
    {
      if (paramConsoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
        break label135;
      }
      QMLog.e("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message() + " line:" + paramConsoleMessage.lineNumber() + "  page:" + bhfp.a(this.a));
      bhck.a(paramConsoleMessage.lineNumber() + ": " + paramConsoleMessage.message(), bhfp.a(this.a).a(), bhfp.a(this.a));
    }
    for (;;)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      label135:
      if (paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.WARNING) {
        QMLog.w("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message() + " line:" + paramConsoleMessage.lineNumber() + "  page:" + bhfp.a(this.a));
      } else {
        QMLog.i("TAG_CHROMIUM", "PageWebView: " + paramConsoleMessage.message());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhfr
 * JD-Core Version:    0.7.0.1
 */