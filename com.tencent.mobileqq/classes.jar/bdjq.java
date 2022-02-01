import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class bdjq
{
  Activity jdField_a_of_type_AndroidAppActivity;
  Intent jdField_a_of_type_AndroidContentIntent;
  private atzf jdField_a_of_type_Atzf;
  bhnj jdField_a_of_type_Bhnj;
  TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  SonicClientImpl jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl;
  nvu jdField_a_of_type_Nvu;
  public boolean a;
  
  public bdjq(AppInterface paramAppInterface, Activity paramActivity, bhnj parambhnj, Intent paramIntent, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Bhnj = parambhnj;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = a(paramAppInterface, paramActivity, paramIntent, paramBoolean);
  }
  
  private void b(TouchWebView paramTouchWebView)
  {
    bdjr localbdjr = new bdjr(this);
    paramTouchWebView.setWebChromeClient(localbdjr);
    this.jdField_a_of_type_Nvu = localbdjr;
  }
  
  public TouchWebView a()
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  public TouchWebView a(AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    nmj.a("Web_qqbrowser_init_only_webview");
    long l1 = System.currentTimeMillis();
    Object localObject1 = null;
    Object localObject2;
    if (bdjm.a(paramActivity, paramIntent.getStringExtra("url")))
    {
      localObject2 = bdjm.a(paramActivity);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        this.jdField_a_of_type_Boolean = true;
        localObject1 = localObject2;
      }
    }
    if (localObject1 == null) {
      if (paramBoolean) {
        localObject1 = SwiftReuseTouchWebView.a(paramActivity);
      }
    }
    for (;;)
    {
      Object localObject3 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
      localObject2 = ((TouchWebView)localObject1).getLayoutParams();
      label108:
      long l2;
      long l3;
      WebSettings localWebSettings;
      label224:
      String str1;
      label266:
      label326:
      int i;
      if (localObject2 == null)
      {
        localObject2 = new ViewGroup.LayoutParams(((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels);
        ((TouchWebView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        l1 = System.currentTimeMillis() - l1;
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewWrapper", 2, "createWebView TouchWebView cost = " + l1);
        }
        ((TouchWebView)localObject1).setIntent(paramIntent);
        nmj.b("Web_qqbrowser_init_only_webview");
        l2 = System.currentTimeMillis();
        a((TouchWebView)localObject1);
        b((TouchWebView)localObject1);
        l3 = System.currentTimeMillis();
        ((TouchWebView)localObject1).setScrollBarStyle(0);
        nmj.a("Web_AdjustSettings");
        localWebSettings = ((TouchWebView)localObject1).getSettings();
        nmj.a("Web_SetUserAgent");
        if (!arbh.a().a()) {
          break label883;
        }
        localObject2 = " _tdocFlag/1";
        localObject3 = new StringBuilder().append("tendocpreload get UA");
        str1 = localWebSettings.getUserAgentString();
        String str2 = a(this.jdField_a_of_type_Bhnj);
        if (((TouchWebView)localObject1).getX5WebViewExtension() == null) {
          break label891;
        }
        paramBoolean = true;
        QLog.i("WebLog_WebViewWrapper", 1, bhre.a(str1, str2, paramBoolean));
        localObject3 = new StringBuilder();
        str1 = localWebSettings.getUserAgentString();
        str2 = a(this.jdField_a_of_type_Bhnj);
        if (((TouchWebView)localObject1).getX5WebViewExtension() == null) {
          break label897;
        }
        paramBoolean = true;
        localWebSettings.setUserAgentString(bhre.a(str1, str2, paramBoolean) + (String)localObject2);
        nmj.b("Web_SetUserAgent");
        localWebSettings.setSavePassword(false);
        localWebSettings.setSaveFormData(false);
        localWebSettings.setBuiltInZoomControls(true);
        localWebSettings.setUseWideViewPort(true);
        localWebSettings.setLoadWithOverviewMode(true);
        localWebSettings.setPluginState(WebSettings.PluginState.ON);
        localObject2 = paramAppInterface.getApplication().getPackageManager();
        i = 0;
      }
      label787:
      label928:
      try
      {
        if (!((PackageManager)localObject2).hasSystemFeature("android.hardware.touchscreen.multitouch"))
        {
          paramBoolean = ((PackageManager)localObject2).hasSystemFeature("android.hardware.faketouch.multitouch.distinct");
          if (!paramBoolean) {
            break label903;
          }
        }
        i = 1;
      }
      catch (RuntimeException localRuntimeException)
      {
        label436:
        label444:
        long l4;
        label685:
        label883:
        label891:
        break label436;
      }
      if (i == 0)
      {
        paramBoolean = true;
        localWebSettings.setDisplayZoomControls(paramBoolean);
        localWebSettings.setPluginsEnabled(true);
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setAllowContentAccess(true);
        localWebSettings.setDatabaseEnabled(true);
        localWebSettings.setDomStorageEnabled(true);
        localWebSettings.setAppCacheEnabled(true);
        str1 = MobileQQ.getMobileQQ().getQQProcessName();
        localObject3 = "";
        localObject2 = localObject3;
        if (str1 != null)
        {
          i = str1.lastIndexOf(':');
          localObject2 = localObject3;
          if (i > -1) {
            localObject2 = "_" + str1.substring(i + 1);
          }
        }
        localWebSettings.setDatabasePath(paramAppInterface.getApplication().getApplicationContext().getDir("database" + (String)localObject2, 0).getPath());
        localWebSettings.setAppCachePath(paramAppInterface.getApplication().getApplicationContext().getDir("appcache" + (String)localObject2, 0).getPath());
        localWebSettings.setMediaPlaybackRequiresUserGesture(false);
        if (Build.VERSION.SDK_INT >= 21) {
          localWebSettings.setMixedContentMode(0);
        }
        l4 = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 11) {
          ((TouchWebView)localObject1).removeJavascriptInterface("searchBoxJavaBridge_");
        }
      }
      try
      {
        ((TouchWebView)localObject1).requestFocus();
        paramBoolean = paramIntent.getBooleanExtra("fromArkAppDownload", false);
        ((TouchWebView)localObject1).setFocusableInTouchMode(true);
        this.jdField_a_of_type_Atzf = new atzf(paramAppInterface, paramActivity, (TouchWebView)localObject1);
        this.jdField_a_of_type_Atzf.a(paramBoolean);
        ((TouchWebView)localObject1).setDownloadListener(this.jdField_a_of_type_Atzf);
        CookieSyncManager.createInstance(paramAppInterface.getApplication().getApplicationContext());
        if (((TouchWebView)localObject1).getX5WebViewExtension() != null)
        {
          ((TouchWebView)localObject1).getX5WebViewExtension().setWebViewClientExtension(new bdju(this, (TouchWebView)localObject1, this.jdField_a_of_type_Bhnj));
          afuh.b(paramIntent, "use_x5", "1");
          nmj.b("Web_AdjustSettings");
          if (bhqc.x) {
            break label928;
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewWrapper", 2, new Object[] { "sReportPerformance:", Boolean.valueOf(bhqc.x), " cost:", Long.valueOf(bhrd.a) });
          }
          return localObject1;
          localObject1 = new TouchWebView(paramActivity);
          break;
          ((ViewGroup.LayoutParams)localObject2).width = ((DisplayMetrics)localObject3).widthPixels;
          ((ViewGroup.LayoutParams)localObject2).height = ((DisplayMetrics)localObject3).heightPixels;
          break label108;
          localObject2 = "";
          break label224;
          paramBoolean = false;
          break label266;
          label897:
          paramBoolean = false;
          break label326;
          label903:
          i = 0;
          break label436;
          paramBoolean = false;
          break label444;
          afuh.b(paramIntent, "use_x5", "2");
          break label787;
          paramAppInterface = new HashMap(5);
          paramAppInterface.put("createWebview", String.valueOf(l1));
          paramAppInterface.put("initWebClient", String.valueOf(l3 - l2));
          paramAppInterface.put("setWebSetting", String.valueOf(l4 - l2));
          paramAppInterface.put("coreInit", String.valueOf(bhrd.a));
          paramAppInterface.put("coldStart", String.valueOf(bhqc.s));
          bctj.a(BaseApplicationImpl.getApplication().getApplicationContext()).a(null, "actWebviewInit", true, 0L, 0L, paramAppInterface, null);
        }
      }
      catch (Exception localException)
      {
        break label685;
      }
    }
  }
  
  String a(bhnj parambhnj)
  {
    if (parambhnj != null) {
      return parambhnj.getUAMark();
    }
    return null;
  }
  
  public nvu a()
  {
    return this.jdField_a_of_type_Nvu;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhnj != null) {
      this.jdField_a_of_type_Bhnj = null;
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
      if (localWebViewPluginEngine != null) {
        localWebViewPluginEngine.b();
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setPluginEngine(null);
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent() == null) {}
    }
    try
    {
      ((ViewGroup)this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    }
    catch (Exception localException1)
    {
      try
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.stopLoading();
        label77:
        if (this.jdField_a_of_type_Boolean) {
          bdjn.a().a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
          if (this.jdField_a_of_type_Nvu != null)
          {
            this.jdField_a_of_type_Nvu.a();
            this.jdField_a_of_type_Nvu = null;
          }
          return;
          localException1 = localException1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("WebLog_WebViewWrapper", 2, "remove webview error");
          break;
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrlOriginal("about:blank");
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.clearView();
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.destroy();
        }
      }
      catch (Exception localException2)
      {
        break label77;
      }
    }
  }
  
  void a(TouchWebView paramTouchWebView)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (Object localObject = new bdjs(this);; localObject = new bdjt(this))
    {
      paramTouchWebView.setWebViewClient((WebViewClient)localObject);
      return;
    }
  }
  
  public void a(SonicClientImpl paramSonicClientImpl)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = paramSonicClientImpl;
    QLog.i("WebLog_WebViewWrapper", 1, "setSonicClient sonicClient = " + paramSonicClientImpl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjq
 * JD-Core Version:    0.7.0.1
 */