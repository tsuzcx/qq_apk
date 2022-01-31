import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

class bcan
  extends bcar
{
  bcan(bcal parambcal)
  {
    super(parambcal, null);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "new shouldInterceptRequest");
    }
    return a(paramWebView, paramWebResourceRequest.getUrl().toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcan
 * JD-Core Version:    0.7.0.1
 */