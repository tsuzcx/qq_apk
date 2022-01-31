import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.sdk.WebChromeClient;

class bhhi
  extends WebChromeClient
{
  bhhi(bhhh parambhhh) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (paramConsoleMessage != null)
    {
      if (paramConsoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
        break label51;
      }
      QMLog.e("AppBrandWebviewService", "consoleMessage.message()  line:" + paramConsoleMessage.lineNumber());
    }
    for (;;)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      label51:
      QMLog.i("AppBrandWebviewService", "consoleMessage.message() " + paramConsoleMessage.message());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhi
 * JD-Core Version:    0.7.0.1
 */