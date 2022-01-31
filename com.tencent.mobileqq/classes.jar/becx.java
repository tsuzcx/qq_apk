import android.net.Uri;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

class becx
  extends beda
{
  becx(becv parambecv)
  {
    super(parambecv);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return a(paramWebView, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.getMethod(), paramWebResourceRequest.isForMainFrame());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     becx
 * JD-Core Version:    0.7.0.1
 */