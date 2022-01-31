import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.sdk.WebChromeClient;

class bdwh
  extends WebChromeClient
{
  bdwh(bdwg parambdwg) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (paramConsoleMessage != null)
    {
      if (paramConsoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
        break label51;
      }
      bdnw.d("AppBrandService", "consoleMessage.message()  line:" + paramConsoleMessage.lineNumber());
    }
    for (;;)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      label51:
      bdnw.b("AppBrandService", "consoleMessage.message() " + paramConsoleMessage.message());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdwh
 * JD-Core Version:    0.7.0.1
 */