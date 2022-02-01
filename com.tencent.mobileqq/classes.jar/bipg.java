import android.graphics.Bitmap;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

class bipg
  extends bipi
{
  bipg(bipd parambipd)
  {
    super(parambipd);
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    return a(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bipg
 * JD-Core Version:    0.7.0.1
 */