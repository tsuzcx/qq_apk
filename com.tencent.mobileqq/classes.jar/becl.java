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

public class becl
{
  Activity jdField_a_of_type_AndroidAppActivity;
  Intent jdField_a_of_type_AndroidContentIntent;
  private aura jdField_a_of_type_Aura;
  bioe jdField_a_of_type_Bioe;
  TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  SonicClientImpl jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl;
  nxo jdField_a_of_type_Nxo;
  public boolean a;
  
  public becl(AppInterface paramAppInterface, Activity paramActivity, bioe parambioe, Intent paramIntent, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Bioe = parambioe;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = a(paramAppInterface, paramActivity, paramIntent, paramBoolean);
  }
  
  private void b(TouchWebView paramTouchWebView)
  {
    becm localbecm = new becm(this);
    paramTouchWebView.setWebChromeClient(localbecm);
    this.jdField_a_of_type_Nxo = localbecm;
  }
  
  public TouchWebView a()
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  public TouchWebView a(AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    noe.a("Web_qqbrowser_init_only_webview");
    long l1 = System.currentTimeMillis();
    Object localObject1 = null;
    Object localObject2;
    if (bech.a(paramActivity, paramIntent.getStringExtra("url")))
    {
      localObject2 = bech.a(paramActivity);
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
        noe.b("Web_qqbrowser_init_only_webview");
        l2 = System.currentTimeMillis();
        a((TouchWebView)localObject1);
        b((TouchWebView)localObject1);
        l3 = System.currentTimeMillis();
        ((TouchWebView)localObject1).setScrollBarStyle(0);
        noe.a("Web_AdjustSettings");
        localWebSettings = ((TouchWebView)localObject1).getSettings();
        noe.a("Web_SetUserAgent");
        if (!arqw.a().a()) {
          break label883;
        }
        localObject2 = " _tdocFlag/1";
        localObject3 = new StringBuilder().append("tendocpreload get UA");
        str1 = localWebSettings.getUserAgentString();
        String str2 = a(this.jdField_a_of_type_Bioe);
        if (((TouchWebView)localObject1).getX5WebViewExtension() == null) {
          break label891;
        }
        paramBoolean = true;
        QLog.i("WebLog_WebViewWrapper", 1, birz.a(str1, str2, paramBoolean));
        localObject3 = new StringBuilder();
        str1 = localWebSettings.getUserAgentString();
        str2 = a(this.jdField_a_of_type_Bioe);
        if (((TouchWebView)localObject1).getX5WebViewExtension() == null) {
          break label897;
        }
        paramBoolean = true;
        localWebSettings.setUserAgentString(birz.a(str1, str2, paramBoolean) + (String)localObject2);
        noe.b("Web_SetUserAgent");
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
        this.jdField_a_of_type_Aura = new aura(paramAppInterface, paramActivity, (TouchWebView)localObject1);
        this.jdField_a_of_type_Aura.a(paramBoolean);
        ((TouchWebView)localObject1).setDownloadListener(this.jdField_a_of_type_Aura);
        CookieSyncManager.createInstance(paramAppInterface.getApplication().getApplicationContext());
        if (((TouchWebView)localObject1).getX5WebViewExtension() != null)
        {
          ((TouchWebView)localObject1).getX5WebViewExtension().setWebViewClientExtension(new becp(this, (TouchWebView)localObject1, this.jdField_a_of_type_Bioe));
          agdz.b(paramIntent, "use_x5", "1");
          noe.b("Web_AdjustSettings");
          if (biqx.x) {
            break label928;
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewWrapper", 2, new Object[] { "sReportPerformance:", Boolean.valueOf(biqx.x), " cost:", Long.valueOf(biry.a) });
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
          agdz.b(paramIntent, "use_x5", "2");
          break label787;
          paramAppInterface = new HashMap(5);
          paramAppInterface.put("createWebview", String.valueOf(l1));
          paramAppInterface.put("initWebClient", String.valueOf(l3 - l2));
          paramAppInterface.put("setWebSetting", String.valueOf(l4 - l2));
          paramAppInterface.put("coreInit", String.valueOf(biry.a));
          paramAppInterface.put("coldStart", String.valueOf(biqx.s));
          bdmc.a(BaseApplicationImpl.getApplication().getApplicationContext()).a(null, "actWebviewInit", true, 0L, 0L, paramAppInterface, null);
        }
      }
      catch (Exception localException)
      {
        break label685;
      }
    }
  }
  
  String a(bioe parambioe)
  {
    if (parambioe != null) {
      return parambioe.getUAMark();
    }
    return null;
  }
  
  public nxo a()
  {
    return this.jdField_a_of_type_Nxo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bioe != null) {
      this.jdField_a_of_type_Bioe = null;
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
          beci.a().a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
          if (this.jdField_a_of_type_Nxo != null)
          {
            this.jdField_a_of_type_Nxo.a();
            this.jdField_a_of_type_Nxo = null;
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
    for (Object localObject = new becn(this);; localObject = new beco(this))
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
 * Qualified Name:     becl
 * JD-Core Version:    0.7.0.1
 */