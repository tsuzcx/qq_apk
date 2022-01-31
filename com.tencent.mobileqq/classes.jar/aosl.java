import com.tencent.kwstudio.office.preview.IHostInterface.IWebClient;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

public final class aosl
  extends WebChromeClient
{
  private final IHostInterface.IWebClient a;
  
  private aosl(IHostInterface.IWebClient paramIWebClient)
  {
    this.a = paramIWebClient;
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if ((this.a == null) || (!this.a.onConsoleMessage(paramConsoleMessage.message(), paramConsoleMessage.lineNumber(), paramConsoleMessage.sourceId()))) {
      return super.onConsoleMessage(paramConsoleMessage);
    }
    return true;
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    if ((this.a == null) || (!this.a.onJsPrompt(paramWebView, paramString1, paramString2, paramString3))) {
      return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
    }
    if (paramJsPromptResult != null) {
      paramJsPromptResult.cancel();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosl
 * JD-Core Version:    0.7.0.1
 */