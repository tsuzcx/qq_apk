import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

class bail
  extends WebViewClient
{
  bail(baij parambaij) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    QLog.i("TenDocWebViewPool", 1, "tendocpreload onPageFinished = " + paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    QLog.i("TenDocWebViewPool", 1, "tendocpreload onPageStarted = " + paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bail
 * JD-Core Version:    0.7.0.1
 */