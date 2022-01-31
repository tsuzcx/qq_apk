import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.widget.InnerWebView;
import com.tencent.qqmini.sdk.runtime.widget.InnerWebView.1.1;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebView;

public class bhje
  extends WebChromeClient
{
  public bhje(InnerWebView paramInnerWebView) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    QMLog.e("ProgressWebView_js", paramConsoleMessage.message());
    return super.onConsoleMessage(paramConsoleMessage);
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    bgow.a(InnerWebView.a(this.a).a(), 230, "", paramString2, 2131694328, 2131694352, new bhjh(this, paramJsResult), new bhji(this, paramJsResult)).show();
    return true;
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    QMLog.d("ProgressWebView", "onProgressChanged : " + paramInt);
    if (InnerWebView.a(this.a) != null) {
      InnerWebView.a(this.a).a(new bhjg(this, paramInt));
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    QMLog.d("ProgressWebView", "onReceivedTitle title : " + paramString);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("about:blank"))) {
      bgor.a(new InnerWebView.1.1(this, paramString));
    }
  }
  
  public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    if (InnerWebView.a(this.a) != null) {
      bgnk.a().a(new bhjj(this));
    }
    return super.onShowFileChooser(paramWebView, paramValueCallback, paramFileChooserParams);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if (InnerWebView.a(this.a) != null)
    {
      bgnk.a().a(new bhjk(this));
      return;
    }
    super.openFileChooser(paramValueCallback, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhje
 * JD-Core Version:    0.7.0.1
 */