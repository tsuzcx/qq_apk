import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

class bhfq
  extends WebViewClient
{
  bhfq(bhfp parambhfp) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.a.setCurrState(bhfp.a(this.a));
    this.a.d();
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    QMLog.i("TAG_CHROMIUM", "shouldInterceptRequest: " + paramWebResourceRequest.getUrl());
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null))
    {
      String str = paramWebResourceRequest.getUrl().toString();
      if ((!TextUtils.isEmpty(str)) && ((str.startsWith("https://appservice.qq.com/")) || (str.startsWith("wxfile://")))) {
        return bhfp.a(this.a, paramWebView, paramWebResourceRequest.getUrl().toString());
      }
    }
    return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhfq
 * JD-Core Version:    0.7.0.1
 */