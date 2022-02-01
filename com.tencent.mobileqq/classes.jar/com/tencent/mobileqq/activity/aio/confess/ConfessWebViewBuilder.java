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
  private ConfessShareMenuHandler a;
  
  public ConfessWebViewBuilder(Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    super.preInitPluginEngine();
    this.mWebview = new TouchWebView(paramContext);
    buildBaseWebView(this.mInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessShareMenuHandler = new ConfessShareMenuHandler(paramActivity, this.mWebview);
  }
  
  public TouchWebView a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null) {
      paramViewGroup.addView(this.mWebview);
    }
    return this.mWebview;
  }
  
  public Share a()
  {
    return b();
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
  
  protected Share b()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare == null)
    {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare = new Share(this.mInterface, this.mInActivity);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(this);
    }
    return this.jdField_a_of_type_ComTencentBizWebviewpluginShare;
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
  
  public String getCurrentUrl()
  {
    String str2 = this.mUrl;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (this.mWebview != null)
      {
        if (TextUtils.isEmpty(this.mWebview.getUrl())) {
          break label46;
        }
        str1 = this.mWebview.getUrl();
      }
    }
    return str1;
    label46:
    return this.mInActivity.getIntent().getStringExtra("url");
  }
  
  public Activity getHostActivity()
  {
    return this.mInActivity;
  }
  
  public WebView getHostWebView()
  {
    return this.mWebview;
  }
  
  public CustomWebView getWebView()
  {
    return this.mWebview;
  }
  
  public WebViewProvider getWebViewProvider()
  {
    return null;
  }
  
  public void hideQQBrowserButton() {}
  
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
    if (paramByte == -1) {
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "pluginStartActivityForResult not handled");
      }
    }
    while (this.mInActivity == null) {
      return paramByte;
    }
    this.mInActivity.startActivityForResult(paramIntent, 15001);
    return paramByte;
  }
  
  public void setBottomBarVisible(boolean paramBoolean) {}
  
  public boolean setShareUrl(String paramString)
  {
    return b().a(paramString);
  }
  
  public boolean setSummary(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    return b().a(paramString1, paramString2, paramString3, paramString4, paramBundle);
  }
  
  public void showActionSheet()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessShareMenuHandler.a(b());
  }
  
  public final int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    CustomWebView localCustomWebView = paramWebViewPlugin.mRuntime.a();
    if (localCustomWebView == null) {}
    int i;
    do
    {
      do
      {
        return -1;
      } while (localCustomWebView.getPluginEngine() == null);
      i = WebViewUtil.a(paramWebViewPlugin);
      if (i != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AbsWebView", 2, "switchRequestCode failed: webView index=" + 0 + ", pluginIndex=" + i);
    return -1;
    return i << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */