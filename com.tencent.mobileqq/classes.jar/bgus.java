import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public class bgus
  extends bidf
{
  public bgus(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    super.preInitPluginEngine();
    this.mWebview = new TouchWebView(this.mContext);
    buildBaseWebView(paramAppInterface);
  }
  
  public void a()
  {
    super.doOnResume();
  }
  
  public void a(Intent paramIntent)
  {
    super.doOnCreate(paramIntent);
  }
  
  public void a(String paramString)
  {
    if (biiw.jdField_a_of_type_Boolean)
    {
      biit.a(this.mWebview, biiw.jdField_a_of_type_JavaLangString);
      biiw.jdField_a_of_type_Boolean = false;
    }
    this.mUrl = paramString;
    this.mWebview.loadUrl(this.mUrl);
  }
  
  public void b()
  {
    super.doOnPause();
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    if (paramArrayList != null) {
      paramArrayList.add(new bikp());
    }
  }
  
  public void c()
  {
    super.doOnDestroy();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    paramWebView.loadUrl("javascript:" + SnapshotService.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgus
 * JD-Core Version:    0.7.0.1
 */