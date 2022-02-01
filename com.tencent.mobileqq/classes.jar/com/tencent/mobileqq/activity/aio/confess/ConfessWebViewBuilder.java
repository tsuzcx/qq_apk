package com.tencent.mobileqq.activity.aio.confess;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.api.IPublicAccountWebviewPlugin;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.webviewplugin.ShareApiPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public class ConfessWebViewBuilder
  extends AbsWebView
  implements WebViewPluginContainer, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext, WebUiUtils.WebShareInterface, WebUiUtils.WebUiMethodInterface
{
  protected Share a;
  private ConfessShareMenuHandler b;
  
  public ConfessWebViewBuilder(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    super.preInitPluginEngine();
    this.mWebview = new TouchWebView(paramContext);
    buildBaseWebView(this.mInterface);
    this.b = new ConfessShareMenuHandler(paramActivity, this.mWebview);
  }
  
  public TouchWebView a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null) {
      paramViewGroup.addView(this.mWebview);
    }
    return this.mWebview;
  }
  
  public void a()
  {
    super.doOnDestroy();
  }
  
  public void a(String paramString)
  {
    this.mUrl = paramString;
    this.mWebview.loadUrl(this.mUrl);
  }
  
  public Share b()
  {
    return c();
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList.add(new WebViewJumpPlugin());
      paramArrayList.add(new ConfessPlugin());
      paramArrayList.add(new UiApiPlugin());
      paramArrayList.add(new QQApiPlugin());
      paramArrayList.add(new ShareApiPlugin());
      paramArrayList.add((WebViewPlugin)QRoute.api(IPublicAccountWebviewPlugin.class));
    }
  }
  
  protected Share c()
  {
    if (this.a == null)
    {
      this.a = new Share(this.mInterface, this.mInActivity);
      this.a.a(this);
    }
    return this.a;
  }
  
  public void destroy()
  {
    Share localShare = this.a;
    if (localShare != null) {
      localShare.destroy();
    }
  }
  
  public String getCurrentUrl()
  {
    String str2 = this.mUrl;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (this.mWebview != null)
      {
        if (!TextUtils.isEmpty(this.mWebview.getUrl())) {
          return this.mWebview.getUrl();
        }
        str1 = this.mInActivity.getIntent().getStringExtra("url");
      }
    }
    return str1;
  }
  
  public Activity getHostActivity()
  {
    return this.mInActivity;
  }
  
  public WebView getHostWebView()
  {
    return this.mWebview;
  }
  
  public String getShareUrl()
  {
    return c().getShareUrl();
  }
  
  public CustomWebView getWebView()
  {
    return this.mWebview;
  }
  
  public WebViewProvider getWebViewProvider()
  {
    return null;
  }
  
  public boolean isActivityResume()
  {
    return false;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public final int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    paramByte = switchRequestCode(paramWebViewPlugin, (byte)1);
    if (paramByte == -1)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("AbsWebView", 2, "pluginStartActivityForResult not handled");
        return paramByte;
      }
    }
    else if (this.mInActivity != null) {
      this.mInActivity.startActivityForResult(paramIntent, 15001);
    }
    return paramByte;
  }
  
  public void reset()
  {
    c().reset();
  }
  
  public boolean setShareUrl(String paramString)
  {
    return c().setShareUrl(paramString);
  }
  
  public boolean setSummary(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    return c().setSummary(paramString1, paramString2, paramString3, paramString4, paramBundle);
  }
  
  public boolean shareStructMsgForH5(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    return false;
  }
  
  public void showActionSheet()
  {
    this.b.a(c());
  }
  
  public final int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    CustomWebView localCustomWebView = paramWebViewPlugin.mRuntime.a();
    if (localCustomWebView == null) {
      return -1;
    }
    if (localCustomWebView.getPluginEngine() == null) {
      return -1;
    }
    int i = WebViewUtil.a(paramWebViewPlugin);
    if (i == -1)
    {
      if (QLog.isColorLevel())
      {
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("switchRequestCode failed: webView index=");
        paramWebViewPlugin.append(0);
        paramWebViewPlugin.append(", pluginIndex=");
        paramWebViewPlugin.append(i);
        QLog.d("AbsWebView", 2, paramWebViewPlugin.toString());
      }
      return -1;
    }
    return i << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */