import android.net.Uri;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

class bcdw
  extends bcdz
{
  bcdw(bcdu parambcdu)
  {
    super(parambcdu);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return a(paramWebView, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.getMethod(), paramWebResourceRequest.isForMainFrame());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcdw
 * JD-Core Version:    0.7.0.1
 */