import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.widget.InnerWebView;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class bhjl
  extends WebViewClient
{
  public bhjl(InnerWebView paramInnerWebView) {}
  
  public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    QMLog.d("ProgressWebView", "doUpdateVisitedHistory " + paramString);
    if ((InnerWebView.a(this.a) != null) && (paramString != null) && (!paramString.equals("about:blank"))) {
      InnerWebView.a(this.a).a(new bhjm(this, paramString));
    }
    super.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    QMLog.d("ProgressWebView", "onPageFinished " + paramString);
    this.a.evaluateJavascript(InnerWebView.a(this.a), new bhjn(this));
    if ((InnerWebView.a(this.a) != null) && (paramString != null) && (!paramString.equals("about:blank"))) {
      InnerWebView.a(this.a).a(new bhjo(this, paramString));
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    QMLog.d("ProgressWebView", "onPageStarted " + paramString);
  }
  
  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
    paramWebResourceRequest = paramWebView.getUrl();
    StringBuilder localStringBuilder = new StringBuilder().append("onReceivedError ").append(paramWebResourceRequest).append("; webResourceError : ");
    if (paramWebResourceError != null) {}
    for (paramWebView = paramWebResourceError.getDescription() + " " + paramWebResourceError.getErrorCode();; paramWebView = null)
    {
      QMLog.d("ProgressWebView", paramWebView);
      if ((InnerWebView.a(this.a) != null) && (paramWebResourceRequest != null) && (!paramWebResourceRequest.equals("about:blank"))) {
        InnerWebView.a(this.a).a(new bhjp(this, paramWebResourceRequest));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhjl
 * JD-Core Version:    0.7.0.1
 */