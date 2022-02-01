package com.tencent.biz.pubaccount.ecshopassit.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.PayJsPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.jsp.DataApiPlugin;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonHbJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.build.IWebViewBuilder;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public class EcshopNewPageWebViewBuilder
  extends AbsWebView
  implements IWebViewBuilder
{
  private String a;
  
  public EcshopNewPageWebViewBuilder(Context paramContext, Activity paramActivity, AppInterface paramAppInterface, TouchWebView paramTouchWebView, String paramString)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.mWebview = paramTouchWebView;
    this.a = paramString;
  }
  
  public void a()
  {
    super.doOnResume();
    QLog.i("EcshopNewPageWebViewBuilder", 2, "[EcshopNewPageWebViewBuilder] onResume");
  }
  
  public void b()
  {
    super.doOnPause();
    QLog.i("EcshopNewPageWebViewBuilder", 2, "[EcshopNewPageWebViewBuilder] onPause");
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    super.bindJavaScript(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.i("EcshopNewPageWebViewBuilder", 2, "[bindJavaScript]");
    }
    paramArrayList.add(new QWalletPayJsPlugin());
    paramArrayList.add(new PayJsPlugin());
    paramArrayList.add(new QWalletCommonJsPlugin());
    paramArrayList.add(new QWalletBluetoothJsPlugin());
    paramArrayList.add(((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).getWebViewPlugin());
    paramArrayList.add(new QQApiPlugin());
    paramArrayList.add(new UiApiPlugin());
    paramArrayList.add(new SensorAPIJavaScript());
    paramArrayList.add(new DataApiPlugin());
    paramArrayList.add(new MediaApiPlugin());
    paramArrayList.add(new VasCommonJsPlugin());
    paramArrayList.add(new QWalletCommonHbJsPlugin());
    paramArrayList.add(new QWalletMixJsPlugin());
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
    QLog.i("EcshopNewPageWebViewBuilder", 2, "[EcshopNewPageWebViewBuilder] onDestroy");
    EcshopWebviewPool.a().a(this.mWebview, this.a);
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
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */