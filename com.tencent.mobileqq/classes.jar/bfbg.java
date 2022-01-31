import android.net.Uri;
import android.text.TextUtils;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

class bfbg
  extends WebViewClient
{
  bfbg(bfbf parambfbf) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.a.a(bfbf.a(this.a));
    this.a.d();
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null))
    {
      String str = paramWebResourceRequest.getUrl().toString();
      if ((!TextUtils.isEmpty(str)) && ((str.startsWith("https://appservice.qq.com/")) || (str.startsWith("wxfile://")))) {
        return bfbf.a(this.a, paramWebView, paramWebResourceRequest.getUrl().toString());
      }
    }
    return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfbg
 * JD-Core Version:    0.7.0.1
 */