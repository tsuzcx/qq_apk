import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.PayJsPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.WadlWebViewJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public class asks
  extends beaa
  implements beay
{
  public asks(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView)
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
    paramArrayList.add(new WadlWebViewJsPlugin());
    paramArrayList.add(new askt());
    paramArrayList.add(new QWalletPayJsPlugin());
    paramArrayList.add(new PayJsPlugin());
    paramArrayList.add(new QWalletCommonJsPlugin());
    paramArrayList.add(new QWalletBluetoothJsPlugin());
    paramArrayList.add(new atdu());
    paramArrayList.add(new UiApiPlugin());
    paramArrayList.add(new SensorAPIJavaScript());
    paramArrayList.add(new atcu());
    paramArrayList.add(new MediaApiPlugin());
    paramArrayList.add(new VasCommonJsPlugin());
    paramArrayList.add(new bdut());
    paramArrayList.add(new QWalletMixJsPlugin());
    paramArrayList.add(new zbe());
  }
  
  public void buildBottomBar() {}
  
  public void buildContentView(Bundle paramBundle) {}
  
  public void buildData() {}
  
  public void buildLayout() {}
  
  public void buildTitleBar() {}
  
  public void buildWebView(AppInterface paramAppInterface)
  {
    super.buildBaseWebView(paramAppInterface);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asks
 * JD-Core Version:    0.7.0.1
 */