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

public class bipd
{
  public long a;
  Intent jdField_a_of_type_AndroidContentIntent;
  bioe jdField_a_of_type_Bioe;
  TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  SonicClientImpl jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl;
  nxo jdField_a_of_type_Nxo;
  
  public bipd(AppInterface paramAppInterface, bioe parambioe, Intent paramIntent, Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = a(paramContext, paramBoolean);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bioe = parambioe;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, paramAppInterface, paramIntent);
  }
  
  public bipd(AppInterface paramAppInterface, bioe parambioe, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bioe = parambioe;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = paramTouchWebView;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, paramAppInterface, paramIntent);
    }
  }
  
  private void b(TouchWebView paramTouchWebView)
  {
    bipe localbipe = new bipe(this);
    paramTouchWebView.setWebChromeClient(localbipe);
    this.jdField_a_of_type_Nxo = localbipe;
  }
  
  public TouchWebView a()
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  public TouchWebView a(Context paramContext, boolean paramBoolean)
  {
    noe.a("Web_qqbrowser_init_only_webview");
    long l = System.currentTimeMillis();
    DisplayMetrics localDisplayMetrics;
    ViewGroup.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      paramContext = SwiftReuseTouchWebView.a(paramContext);
      localDisplayMetrics = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
      localLayoutParams = paramContext.getLayoutParams();
      if (localLayoutParams != null) {
        break label88;
      }
      localLayoutParams = new ViewGroup.LayoutParams(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    }
    for (;;)
    {
      paramContext.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
      return paramContext;
      paramContext = new TouchWebView(paramContext);
      break;
      label88:
      localLayoutParams.width = localDisplayMetrics.widthPixels;
      localLayoutParams.height = localDisplayMetrics.heightPixels;
    }
  }
  
  public TouchWebView a(TouchWebView paramTouchWebView, AppInterface paramAppInterface, Intent paramIntent)
  {
    long l1 = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewWrapper", 2, "createWebView TouchWebView cost = " + l1);
    }
    paramTouchWebView.setIntent(paramIntent);
    noe.b("Web_qqbrowser_init_only_webview");
    long l2 = System.currentTimeMillis();
    a(paramTouchWebView);
    b(paramTouchWebView);
    long l3 = System.currentTimeMillis();
    paramTouchWebView.setScrollBarStyle(0);
    noe.a("Web_AdjustSettings");
    WebSettings localWebSettings = paramTouchWebView.getSettings();
    noe.a("Web_SetUserAgent");
    Object localObject = localWebSettings.getUserAgentString();
    String str1 = a(this.jdField_a_of_type_Bioe);
    boolean bool;
    if (paramTouchWebView.getX5WebViewExtension() != null) {
      bool = true;
    }
    for (;;)
    {
      localWebSettings.setUserAgentString(birz.a((String)localObject, str1, bool));
      noe.b("Web_SetUserAgent");
      localWebSettings.setSavePassword(false);
      localWebSettings.setSaveFormData(false);
      localWebSettings.setBuiltInZoomControls(true);
      localWebSettings.setUseWideViewPort(true);
      localWebSettings.setLoadWithOverviewMode(true);
      localWebSettings.setPluginState(WebSettings.PluginState.ON);
      localObject = paramAppInterface.getApplication().getPackageManager();
      int i = 0;
      try
      {
        if (!((PackageManager)localObject).hasSystemFeature("android.hardware.touchscreen.multitouch"))
        {
          bool = ((PackageManager)localObject).hasSystemFeature("android.hardware.faketouch.multitouch.distinct");
          if (!bool) {
            break label579;
          }
        }
        i = 1;
      }
      catch (RuntimeException localRuntimeException)
      {
        label212:
        label220:
        String str2;
        long l4;
        break label212;
      }
      if (i == 0)
      {
        bool = true;
        localWebSettings.setDisplayZoomControls(bool);
        localWebSettings.setPluginsEnabled(true);
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setAllowContentAccess(true);
        localWebSettings.setDatabaseEnabled(true);
        localWebSettings.setDomStorageEnabled(true);
        localWebSettings.setAppCacheEnabled(true);
        str2 = MobileQQ.getMobileQQ().getQQProcessName();
        str1 = "";
        localObject = str1;
        if (str2 != null)
        {
          i = str2.lastIndexOf(':');
          localObject = str1;
          if (i > -1) {
            localObject = "_" + str2.substring(i + 1);
          }
        }
        localWebSettings.setDatabasePath(paramAppInterface.getApplication().getApplicationContext().getDir("database" + (String)localObject, 0).getPath());
        localWebSettings.setAppCachePath(paramAppInterface.getApplication().getApplicationContext().getDir("appcache" + (String)localObject, 0).getPath());
        localWebSettings.setMediaPlaybackRequiresUserGesture(false);
        if (Build.VERSION.SDK_INT >= 21) {
          localWebSettings.setMixedContentMode(0);
        }
        l4 = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 11) {
          paramTouchWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        }
      }
      try
      {
        paramTouchWebView.requestFocus();
        label459:
        paramTouchWebView.setFocusableInTouchMode(true);
        CookieSyncManager.createInstance(paramAppInterface.getApplication().getApplicationContext());
        if (paramTouchWebView.getX5WebViewExtension() != null)
        {
          paramTouchWebView.getX5WebViewExtension().setWebViewClientExtension(new biph(this, paramTouchWebView, this.jdField_a_of_type_Bioe));
          agdz.b(paramIntent, "use_x5", "1");
          label514:
          noe.b("Web_AdjustSettings");
          if (biqx.x) {
            break label604;
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewWrapper", 2, new Object[] { "sReportPerformance:", Boolean.valueOf(biqx.x), " cost:", Long.valueOf(biry.jdField_a_of_type_Long) });
          }
          return paramTouchWebView;
          bool = false;
          break;
          label579:
          i = 0;
          break label212;
          bool = false;
          break label220;
          agdz.b(paramIntent, "use_x5", "2");
          break label514;
          label604:
          paramAppInterface = new HashMap(5);
          paramAppInterface.put("createWebview", String.valueOf(l1));
          paramAppInterface.put("initWebClient", String.valueOf(l3 - l2));
          paramAppInterface.put("setWebSetting", String.valueOf(l4 - l2));
          paramAppInterface.put("coreInit", String.valueOf(biry.jdField_a_of_type_Long));
          paramAppInterface.put("coldStart", String.valueOf(biqx.s));
          bdmc.a(BaseApplicationImpl.getApplication().getApplicationContext()).a(null, "actWebviewInit", true, 0L, 0L, paramAppInterface, null);
        }
      }
      catch (Exception localException)
      {
        break label459;
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
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.stopLoading();
          label77:
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrlOriginal("about:blank");
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.clearView();
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.destroy();
          this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
          if (this.jdField_a_of_type_Nxo != null)
          {
            this.jdField_a_of_type_Nxo.a();
            this.jdField_a_of_type_Nxo = null;
          }
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewWrapper", 2, "remove webview error");
          }
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
    for (Object localObject = new bipf(this);; localObject = new bipg(this))
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
  
  protected boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bipd
 * JD-Core Version:    0.7.0.1
 */