import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public class aygt
  extends beaa
  implements beay
{
  public aygt(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.mWebview = paramTouchWebView;
  }
  
  public void a()
  {
    super.doOnResume();
  }
  
  public void b()
  {
    super.doOnPause();
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    super.bindJavaScript(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.i("KDSearchResultBuilder", 2, "[bindJavaScript]");
    }
    paramArrayList.add(new sxe());
    paramArrayList.add(new atdu());
    paramArrayList.add(new UiApiPlugin());
    paramArrayList.add(new SensorAPIJavaScript());
    paramArrayList.add(new atcu());
    paramArrayList.add(new MediaApiPlugin());
    paramArrayList.add(new VasCommonJsPlugin());
  }
  
  public void buildBottomBar() {}
  
  public void buildContentView(Bundle paramBundle) {}
  
  public void buildData() {}
  
  public void buildLayout() {}
  
  public void buildTitleBar() {}
  
  public void buildWebView(AppInterface paramAppInterface)
  {
    super.buildBaseWebView(paramAppInterface);
    this.mWebview.setWebViewClient(new aygu(this, this.mWebview.getPluginEngine()));
  }
  
  public void c()
  {
    super.doOnDestroy();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onWebViewReady()
  {
    super.onWebViewReady();
  }
  
  public void preInitWebviewPlugin() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygt
 * JD-Core Version:    0.7.0.1
 */