import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.webbundle.sdk.IWebBundleWebView.OnPageFinishedListener;
import cooperation.comic.webbundle.WebBundleWebView;

public class biot
  extends WebViewClient
{
  public biot(WebBundleWebView paramWebBundleWebView, IWebBundleWebView.OnPageFinishedListener paramOnPageFinishedListener) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.jdField_a_of_type_ComTencentWebbundleSdkIWebBundleWebView$OnPageFinishedListener.onPageFinished(this.jdField_a_of_type_CooperationComicWebbundleWebBundleWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biot
 * JD-Core Version:    0.7.0.1
 */