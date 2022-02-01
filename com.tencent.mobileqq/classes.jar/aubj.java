import com.tencent.kwstudio.office.preview.IHostInterface.IWebClient;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

public final class aubj
  extends WebChromeClient
{
  private final IHostInterface.IWebClient a;
  
  private aubj(IHostInterface.IWebClient paramIWebClient)
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
    if (JsBridgeController.getInstance().shouldIntercept(paramWebView, paramString2, paramString1, paramJsPromptResult)) {}
    do
    {
      return true;
      if ((this.a == null) || (!this.a.onJsPrompt(paramWebView, paramString1, paramString2, paramString3))) {
        return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
      }
    } while (paramJsPromptResult == null);
    paramJsPromptResult.cancel();
    return true;
  }
  
  @Override
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    super.onProgressChanged(paramWebView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubj
 * JD-Core Version:    0.7.0.1
 */