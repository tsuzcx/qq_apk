package com.tencent.gdtad.views.videoceiling;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.util.IWebViewBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class GdtWebViewBuilder
  extends AbsWebView
  implements IWebViewBuilder
{
  protected Intent a;
  
  public GdtWebViewBuilder(Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.a = paramIntent;
  }
  
  public void a()
  {
    super.doOnResume();
  }
  
  public void a(Bundle paramBundle)
  {
    super.doOnCreate(this.a);
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    this.mWebview = paramTouchWebView;
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("qZoneShouldOverrideUrlLoading:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("AbsWebView", 1, ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge://"))) {
      return true;
    }
    localObject = ((CustomWebView)paramWebView).getPluginEngine();
    if ((!paramString.startsWith("file://")) && (!paramString.startsWith("data:")) && (!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
    {
      paramString = Uri.parse(paramString);
      localObject = paramString.getScheme();
      if (AuthorizeConfig.a().a(paramWebView.getUrl(), (String)localObject).booleanValue())
      {
        paramWebView = new Intent("android.intent.action.VIEW", paramString);
        paramWebView.addFlags(268435456);
        try
        {
          this.mContext.startActivity(paramWebView);
          return true;
        }
        catch (Exception paramWebView)
        {
          QLog.e("AbsWebView", 1, "startActivity", paramWebView);
        }
      }
      return true;
    }
    return (localObject != null) && (((WebViewPluginEngine)localObject).a(paramString, 16L, null));
  }
  
  public void b()
  {
    super.doOnPause();
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    super.bindJavaScript(paramArrayList);
  }
  
  public void buildBottomBar() {}
  
  public void buildContentView(Bundle paramBundle) {}
  
  public void buildData() {}
  
  public void buildLayout() {}
  
  public void buildTitleBar() {}
  
  public final void buildWebView(AppRuntime paramAppRuntime)
  {
    super.buildBaseWebView(paramAppRuntime);
  }
  
  public void c()
  {
    try
    {
      super.doOnDestroy();
      return;
    }
    catch (Exception localException)
    {
      GdtLog.d("GdtWebViewBuilder", "getVideoComponent error", localException);
    }
  }
  
  public void preInitWebviewPlugin()
  {
    super.preInitPluginEngine();
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge://"))) {
      return true;
    }
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */