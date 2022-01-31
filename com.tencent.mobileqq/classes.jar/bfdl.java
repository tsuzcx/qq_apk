import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage.MessageLevel;
import com.tencent.smtt.sdk.WebChromeClient;

class bfdl
  extends WebChromeClient
{
  bfdl(bfdk parambfdk) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (paramConsoleMessage != null)
    {
      if (paramConsoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
        break label51;
      }
      betc.d("AppBrandService", "consoleMessage.message()  line:" + paramConsoleMessage.lineNumber());
    }
    for (;;)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      label51:
      betc.b("AppBrandService", "consoleMessage.message() " + paramConsoleMessage.message());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfdl
 * JD-Core Version:    0.7.0.1
 */