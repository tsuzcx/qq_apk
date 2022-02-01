package com.tencent.comic.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.comic.VipComicHelper;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.comic.jsp.QQComicJsPlugin;
import com.tencent.comic.jsp.QQComicJsPluginProxy;
import com.tencent.comic.utils.FirstInObservable;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.comic.webbundle.WebBundleFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.IWebViewFragmentInitor;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.LiuHaiUtils;
import com.tencent.webbundle.sdk.IWebBundleRuntime;
import com.tencent.webbundle.sdk.WebBundleManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class QQComicFragment
  extends WebViewFragment
  implements IWebViewFragmentInitor
{
  private long jdField_a_of_type_Long;
  private QQComicJsPlugin jdField_a_of_type_ComTencentComicJspQQComicJsPlugin;
  private Observer jdField_a_of_type_JavaUtilObserver;
  
  public static WebViewFragment a(Intent paramIntent)
  {
    Object localObject;
    if (Boolean.valueOf(paramIntent.getBooleanExtra("openWithWebBundle", false)).booleanValue()) {
      localObject = new WebBundleFragment();
    } else {
      localObject = new QQComicFragment();
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    ((WebViewFragment)localObject).setArguments(localBundle);
    ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).fetchReportInfo(paramIntent, true);
    return localObject;
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    return String.format("%s=%s; PATH=/; DOMAIN=.%s; Max-Age=31556926;", new Object[] { paramString1, paramString2, paramString3 });
  }
  
  private void a() {}
  
  private void b()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = CookieManager.getInstance();
    Object localObject2 = ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).getQimei();
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "the qimei is null");
      }
      return;
    }
    if (localObject1 != null)
    {
      Object localObject3 = ((CookieManager)localObject1).getCookie(this.mUrl);
      if (localObject3 != null)
      {
        if (((String)localObject3).contains("qimei="))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewFragment", 2, "the cookie has qimei!");
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("get qimei cost: ");
          ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
          QLog.i("WebLog_WebViewFragment", 1, ((StringBuilder)localObject1).toString());
          return;
        }
        localObject2 = a("qimei", (String)localObject2, "vip.qq.com");
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("new cookie:");
        ((StringBuilder)localObject3).append((String)localObject2);
        QLog.d("WebLog_WebViewFragment", 4, ((StringBuilder)localObject3).toString());
        if ((this.mUrl != null) && (!this.mUrl.isEmpty())) {
          ((CookieManager)localObject1).setCookie(this.mUrl, (String)localObject2);
        }
        c();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("cookieManager sync after cookie is ");
          ((StringBuilder)localObject2).append(((CookieManager)localObject1).getCookie(this.mUrl));
          QLog.d("WebLog_WebViewFragment", 2, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        QLog.e("WebLog_WebViewFragment", 1, "cookie is null");
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("set qimei cost: ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      QLog.i("WebLog_WebViewFragment", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  private void c()
  {
    try
    {
      QLog.d("WebLog_WebViewFragment", 1, "[cookie] sync cookie.");
      CookieSyncManager.getInstance().sync();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label15;
    }
    catch (Exception localException)
    {
      label15:
      label18:
      label27:
      break label18;
    }
    break label27;
    QLog.e("WebLog_WebViewFragment", 1, "sync failed, encounter unexpected problem! ");
    return;
    if (getAppRuntime().getApp() != null)
    {
      CookieSyncManager.createInstance(getAppRuntime().getApp());
      CookieSyncManager.getInstance().sync();
      QLog.w("WebLog_WebViewFragment", 2, "sync failed, createInstance first");
      return;
    }
    QLog.w("WebLog_WebViewFragment", 2, "application is null");
  }
  
  private void d()
  {
    if (getHostActivity() != null)
    {
      if (this.contentView == null) {
        return;
      }
      LiuHaiUtils.a(getHostActivity());
      LiuHaiUtils.enableNotch(getHostActivity());
      if (LiuHaiUtils.jdField_a_of_type_Boolean)
      {
        int i;
        if ((this.jdField_a_of_type_Long & 1L) == 1L) {
          i = LiuHaiUtils.jdField_a_of_type_Int;
        } else {
          i = 0;
        }
        if (this.contentView.a != null)
        {
          this.contentView.a.setPadding(0, i, 0, 0);
          this.contentView.a.setBackgroundColor(-16777216);
        }
      }
    }
  }
  
  public QQComicJsPlugin a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentComicJspQQComicJsPlugin;
    if (localObject != null) {
      return localObject;
    }
    if ((getWebView() != null) && (getWebView().getPluginEngine() != null))
    {
      localObject = getWebView().getPluginEngine().a("comic");
      if ((localObject instanceof QQComicJsPlugin))
      {
        this.jdField_a_of_type_ComTencentComicJspQQComicJsPlugin = ((QQComicJsPlugin)localObject);
        return this.jdField_a_of_type_ComTencentComicJspQQComicJsPlugin;
      }
    }
    return null;
  }
  
  public void a(Bundle paramBundle, TouchWebView paramTouchWebView, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    try
    {
      if ((this.mUrl != null) && (this.jdField_a_of_type_Long == 0L))
      {
        QLog.d("WebLog_WebViewFragment", 2, new Object[] { "dealWithWvx: url=", this.mUrl });
        String str = Uri.parse(this.mUrl).getQueryParameter("_wvx");
        if (str != null) {
          this.jdField_a_of_type_Long = Long.parseLong(str, 10);
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("WebLog_WebViewFragment", 2, "dealWithWvx: ", localException);
    }
    paramWebViewKernelCallBack.onWebViewInit(paramBundle, paramTouchWebView);
    b();
  }
  
  public void a(Bundle paramBundle, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    d();
    paramWebViewKernelCallBack.onFinalState(paramBundle);
  }
  
  public void a(WebView paramWebView, String paramString, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    paramWebViewKernelCallBack.onPageFinished(paramWebView, paramString);
    QLog.d("WebLog_WebViewFragment", 4, "QQComicFragment onPageFinished ");
    if (QQComicPluginBridge.a != null)
    {
      QLog.d("WebLog_WebViewFragment", 4, "QQComicPluginBridge sFirstInObservable is not null ");
      QQComicPluginBridge.a.a(paramWebView.getContext());
    }
    this.jdField_a_of_type_JavaUtilObserver = new QQComicFragment.1(this, paramWebView);
    QQComicPluginBridge.b(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  public boolean a()
  {
    QQComicJsPlugin localQQComicJsPlugin = a();
    JSONObject localJSONObject;
    if (localQQComicJsPlugin != null)
    {
      localQQComicJsPlugin = (QQComicJsPlugin)localQQComicJsPlugin;
      localJSONObject = new JSONObject();
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("status", localQQComicJsPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      localJSONObject.put("data", localObject);
      label54:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("notifySecretModeChange. status=");
        ((StringBuilder)localObject).append(localQQComicJsPlugin.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        QLog.d("WebLog_WebViewFragment", 2, ((StringBuilder)localObject).toString());
      }
      if (!TextUtils.isEmpty(localQQComicJsPlugin.b)) {
        getWebView().callJs(localQQComicJsPlugin.b, new String[] { localJSONObject.toString() });
      }
      return true;
    }
    catch (Exception localException)
    {
      break label54;
    }
  }
  
  String[] a()
  {
    String[] arrayOfString = new String[5];
    Object localObject = a();
    if ((localObject != null) && (((QQComicJsPlugin)localObject).jdField_a_of_type_ComTencentComicJspQQComicJsPluginProxy != null))
    {
      localObject = ((QQComicJsPlugin)localObject).jdField_a_of_type_ComTencentComicJspQQComicJsPluginProxy.a();
      if (localObject != null)
      {
        arrayOfString[0] = ((String)((HashMap)localObject).get("page_id"));
        arrayOfString[1] = ((String)((HashMap)localObject).get("obj_type"));
        arrayOfString[2] = ((String)((HashMap)localObject).get("ret_id"));
        arrayOfString[3] = ((String)((HashMap)localObject).get("ext2"));
        arrayOfString[4] = ((String)((HashMap)localObject).get("source"));
      }
    }
    return arrayOfString;
  }
  
  public SwiftBrowserComponentsProvider createComponentsProvider()
  {
    return new SwiftBrowserComponentsProvider(this, 511, new QQComicFragment.2(this));
  }
  
  public WebUiUtils.WebTitleBarInterface getWebTitleBarInterface()
  {
    return new QQComicFragment.4(this, this.webViewSurface);
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new QQComicFragment.3(this, this.webViewSurface);
  }
  
  public WebViewFragment newInstance(int paramInt, SwiftWebViewFragmentSupporter paramSwiftWebViewFragmentSupporter, WebViewTabBarData paramWebViewTabBarData, Intent paramIntent)
  {
    paramSwiftWebViewFragmentSupporter = paramIntent.getStringExtra("url");
    if (TextUtils.isEmpty(Uri.parse(paramSwiftWebViewFragmentSupporter).getQueryParameter("_titleBarHeight")))
    {
      paramInt = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168);
      int i = ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ.getApplicationContext());
      paramWebViewTabBarData = (IQQComicUtil)QRoute.api(IQQComicUtil.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("_titleBarHeight=");
      localStringBuilder.append(paramInt + i);
      paramIntent.putExtra("url", paramWebViewTabBarData.addParamToUrl(paramSwiftWebViewFragmentSupporter, localStringBuilder.toString()));
    }
    return a(paramIntent);
  }
  
  public void onClick(View paramView)
  {
    if (((paramView == getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView) || (paramView == getSwiftTitleUI().d)) && (getSwiftTitleUI().jdField_a_of_type_Boolean))
    {
      getSwiftTitleUI().d(false);
      if ((getAppRuntime() != null) && (getAppRuntime().getApp() != null))
      {
        BaseApplication localBaseApplication = getAppRuntime().getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("boodo_");
        localStringBuilder.append(getAppRuntime().getCurrentAccountUin());
        localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("private_read_red_dot", true).apply();
      }
    }
    super.onClick(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.intent.getParcelableExtra("defaultResultData");
    if ((paramBundle instanceof Intent)) {
      getQBaseActivity().setResult(0, (Intent)paramBundle);
    }
    a();
    VipComicHelper.a(getAppRuntime());
    VipComicHelper.a(getHostActivity());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQComicPluginBridge.c(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_JavaUtilObserver = null;
    FragmentActivity localFragmentActivity = getActivity();
    IWebBundleRuntime localIWebBundleRuntime = WebBundleManager.getInstance("comic").getRuntime();
    if ((localFragmentActivity != null) && (localFragmentActivity.isFinishing()) && (localIWebBundleRuntime != null) && (localFragmentActivity == localIWebBundleRuntime.getContext()))
    {
      WebBundleManager.getInstance("comic").destroy();
      QLog.w("WebLog_WebViewFragment", 1, "activity finish and destroy webBundle");
    }
  }
  
  public void onStop()
  {
    super.onStop();
    QQComicJsPlugin localQQComicJsPlugin = a();
    if (localQQComicJsPlugin != null) {
      localQQComicJsPlugin.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicFragment
 * JD-Core Version:    0.7.0.1
 */