import android.graphics.Bitmap;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.webbundle.sdk.IWebBundleWebView.OnPageFinishedListener;
import cooperation.comic.webbundle.WebBundleWebView;

public class blsu
  extends WebViewClient
{
  public blsu(WebBundleWebView paramWebBundleWebView, IWebBundleWebView.OnPageFinishedListener paramOnPageFinishedListener) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.jdField_a_of_type_ComTencentWebbundleSdkIWebBundleWebView$OnPageFinishedListener.onPageFinished(this.jdField_a_of_type_CooperationComicWebbundleWebBundleWebView, paramString);
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blsu
 * JD-Core Version:    0.7.0.1
 */