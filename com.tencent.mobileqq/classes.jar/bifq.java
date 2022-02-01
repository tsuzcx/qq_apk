import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewModule.2;
import com.tencent.mobileqq.webview.swift.WebViewModule.3;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.sonic.sdk.SonicSession;
import com.tencent.sonic.sdk.SonicSessionConfig.Builder;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class bifq
  implements bifc
{
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private Intent jdField_a_of_type_AndroidContentIntent;
  bigb jdField_a_of_type_Bigb;
  protected final biih a;
  public TouchWebView a;
  public volatile AppInterface a;
  public BrowserAppInterface a;
  protected SonicClientImpl a;
  protected volatile WebViewPluginEngine a;
  public String a;
  protected nro a;
  protected volatile boolean a;
  public String b;
  protected boolean b;
  private String c;
  public boolean c;
  boolean d = true;
  
  public bifq(@NotNull Intent paramIntent, Context paramContext)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Biih = new biih(new bifr(this));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  protected int a(Bundle paramBundle)
  {
    i = 1;
    nwo.a("Web_qqbrowser_state_machine_init_data");
    QbSdk.setQQBuildNumber("4875");
    paramBundle = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("options");
    if (paramBundle != null) {}
    try
    {
      paramBundle = new JSONObject(paramBundle);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("url", paramBundle.getString("url"));
      if (!this.jdField_a_of_type_AndroidContentIntent.hasExtra("key_isReadModeEnabled")) {
        this.jdField_a_of_type_AndroidContentIntent.putExtra("key_isReadModeEnabled", true);
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("ba_is_login", paramBundle.optBoolean("ba_is_login", true));
      this.jdField_a_of_type_AndroidContentIntent.putExtra("isShowAd", paramBundle.optBoolean("isShowAd", true));
      this.jdField_a_of_type_AndroidContentIntent.putExtra("avoidLoginWeb", paramBundle.optBoolean("avoidLoginWeb", false));
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        boolean bool;
        int j;
        if (QLog.isColorLevel())
        {
          QLog.d("WebViewModule", 2, paramBundle.toString());
          continue;
          i = 0;
        }
      }
    }
    new StringBuilder().append(Build.MANUFACTURER).append("_").append(Build.MODEL).toString();
    bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("fromNearby", false);
    paramBundle = getClass();
    j = hashCode();
    if (bool)
    {
      bdmb.a(paramBundle, j, i, this.jdField_c_of_type_JavaLangString);
      nwo.b("Web_qqbrowser_state_machine_init_data");
      this.jdField_a_of_type_Int = 4;
      return 0;
    }
  }
  
  public final bigb a()
  {
    this.jdField_a_of_type_Bigb = new bigb(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_AndroidContentContext, false);
    this.jdField_a_of_type_Bigb.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
    TouchWebView localTouchWebView = this.jdField_a_of_type_Bigb.a();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.bindWebView(localTouchWebView);
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(localTouchWebView);
    localTouchWebView.setPluginEngine(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine);
    if (this.jdField_b_of_type_Boolean) {
      localTouchWebView.setMask(true);
    }
    return this.jdField_a_of_type_Bigb;
  }
  
  public String a()
  {
    String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
    String str1 = str2;
    if (str2 == null)
    {
      str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_params_qq");
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
    return str1;
  }
  
  public void a()
  {
    g();
    f();
    if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_is_init_sonic_session", true)) {}
    for (boolean bool = false;; bool = a(a()))
    {
      if (!bool) {
        ThreadManager.post(new WebViewModule.2(this), 5, null, true);
      }
      this.jdField_b_of_type_Boolean = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
      this.jdField_a_of_type_Nro = nro.a();
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 2;
      if ((WebAccelerateHelper.isWebViewCache) || (SwiftReuseTouchWebView.c > 0)) {
        this.jdField_a_of_type_Biih.a();
      }
      WebAccelerateHelper.isWebViewCache = true;
      this.jdField_a_of_type_Biih.a(new Bundle());
      return;
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = SwiftBrowserCookieMonster.b(paramString1);
      String str = SwiftBrowserCookieMonster.b(paramString2);
      if (((paramString1 != null) && (paramString1.contains("ptlogin"))) || ((str != null) && (str.contains("ptlogin")))) {
        this.d = false;
      }
      if (this.d)
      {
        paramString1 = SwiftBrowserCookieMonster.a(paramString2);
        if (paramString1 != null) {
          paramString1.a(paramString2, null, null, this.jdField_a_of_type_AndroidContentIntent);
        }
      }
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("WebViewModule", 1, paramString1, new Object[0]);
    }
  }
  
  protected boolean a(long paramLong, Map<String, Object> paramMap)
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
      if (localWebViewPluginEngine != null) {
        return localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), paramLong, paramMap);
      }
    }
    return false;
  }
  
  boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewModule", 2, "initSonicSession url = :" + paramString);
    }
    for (;;)
    {
      int i;
      try
      {
        SonicSessionConfig.Builder localBuilder = new SonicSessionConfig.Builder();
        localBuilder.setSessionMode(1);
        Object localObject = Uri.parse(paramString);
        if (((Uri)localObject).isHierarchical())
        {
          localObject = ((Uri)localObject).getQueryParameter("_sonic_xv");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            HashMap localHashMap = new HashMap();
            long l = Long.parseLong((String)localObject);
            if ((0x2 & l) == 0L) {
              break label332;
            }
            bool = true;
            localBuilder.setSupportLocalServer(bool);
            if ((0x4 & l) == 0L) {
              break label338;
            }
            i = 1;
            break label320;
            label137:
            localHashMap.put("cache-offline", localObject);
            localBuilder.setCustomResponseHeaders(localHashMap);
            if ((0x8 & l) == 0L) {
              break label351;
            }
            bool = true;
            localBuilder.setSupportCacheControl(bool);
          }
        }
        localObject = WebAccelerateHelper.getSonicEngine();
        if (localObject != null)
        {
          localObject = ((SonicEngine)localObject).createSession(paramString, localBuilder.build());
          if (localObject != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = new SonicClientImpl((SonicSession)localObject);
            ((SonicSession)localObject).bindClient(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
            return true;
          }
          QLog.d("WebViewModule", 1, "initSonicSession sonicSession = null, url = " + paramString);
          return false;
        }
      }
      catch (Exception localException)
      {
        QLog.e("WebViewModule", 1, "initSonicSession exception, url = " + paramString, localException);
        return false;
      }
      QLog.d("WebViewModule", 1, "initSonicSession sonicEngine = null, url = " + paramString);
      return false;
      for (;;)
      {
        label320:
        if (i == 0) {
          break label343;
        }
        str = "store";
        break label137;
        label332:
        bool = false;
        break;
        label338:
        i = 0;
      }
      label343:
      String str = "true";
      continue;
      label351:
      boolean bool = false;
    }
  }
  
  public boolean afterWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  protected int b(Bundle paramBundle)
  {
    nwo.a("Web_qqbrowser_state_machine_init_x5_environment");
    this.jdField_a_of_type_Int = 8;
    if (biis.a())
    {
      nwo.b("Web_qqbrowser_state_machine_init_x5_environment");
      return 0;
    }
    if (biis.b())
    {
      nwo.b("Web_qqbrowser_state_machine_init_x5_environment");
      return 0;
    }
    nwo.b("Web_qqbrowser_state_machine_init_x5_environment");
    return 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onResume();
    }
    a(2L, null);
  }
  
  public boolean beforeWebViewEngineHandleOverrideUrl(WebView paramWebView, String paramString)
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return true;
    }
    nwo.a("urlInterceptManager");
    biit.b(paramString);
    nwo.b("urlInterceptManager");
    return false;
  }
  
  protected int c(Bundle paramBundle)
  {
    nwo.a("Web_qqbrowser_state_machine_init_app_and_webview_engine");
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof BrowserAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    if ((!WebAccelerateHelper.isWebViewCache) && (!VipWebViewReportLog.a())) {
      VipWebViewReportLog.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    h();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.jdField_a_of_type_AndroidContentIntent.getStringArrayExtra("insertPluginsArray"));
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.jdField_c_of_type_JavaLangString, 1L, null);
    }
    this.jdField_a_of_type_Int = 16;
    nwo.b("Web_qqbrowser_state_machine_init_app_and_webview_engine");
    return 1;
  }
  
  public void c()
  {
    if (1 != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Biih.b();
      this.jdField_a_of_type_Int = 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.destroy();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = null;
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();; localObject = null)
    {
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 8589934596L, null);
      }
      new Bundle().putString("url", this.jdField_c_of_type_JavaLangString);
      d();
      if (QQBrowserActivity.d == 0)
      {
        ashz.a().a().doUnbindService(BaseApplicationImpl.getApplication());
        bihx.d = -1;
      }
      localObject = bdmb.a(getClass(), hashCode());
      if (localObject != null) {
        bdla.b(null, "CliOper", "", "", ((bdmc)localObject).jdField_a_of_type_JavaLangString, ((bdmc)localObject).jdField_a_of_type_JavaLangString, ((bdmc)localObject).jdField_a_of_type_Int, 0, Long.toString(SystemClock.elapsedRealtime() - ((bdmc)localObject).b), "", "", "");
      }
      biij.a().a(2);
      return;
    }
  }
  
  protected int d(Bundle paramBundle)
  {
    nwo.a("Web_qqbrowser_state_machine_init_webview");
    i();
    nwo.b("Web_qqbrowser_state_machine_init_webview");
    this.jdField_a_of_type_Int = 32;
    return 0;
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewModule", 2, "onDestroy");
    }
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bigb != null)
    {
      this.jdField_a_of_type_Bigb.a();
      this.jdField_a_of_type_Bigb = null;
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  protected int e(Bundle paramBundle)
  {
    nwo.a("Web_qqbrowser_state_machine_load_url");
    System.currentTimeMillis();
    nwo.a("Web_qqbrowser_init");
    j();
    nwo.b("Web_qqbrowser_init");
    nwo.b("Web_qqbrowser_state_machine_load_url");
    this.jdField_a_of_type_Int = 1024;
    return 0;
  }
  
  public void e()
  {
    a(8589934597L, null);
  }
  
  protected int f(Bundle paramBundle)
  {
    nwo.a("Web_qqbrowser_state_machine_init_FINAL");
    nwo.a("Web_IPCSetup");
    if (!ashz.a().a()) {
      ashz.a().a().doBindService(BaseApplicationImpl.getApplication());
    }
    nwo.b("Web_IPCSetup");
    biij.a().a(new bifs(this, 2));
    nwo.b("Web_qqbrowser_state_machine_init_FINAL");
    nwo.b("Web_qqbrowser_state_machine_all");
    this.jdField_a_of_type_Int = 1;
    return -1;
  }
  
  void f()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
      if (bijv.b(str)) {
        ThreadManager.postImmediately(new WebViewModule.3(this, str), null, false);
      }
    }
  }
  
  void g()
  {
    this.jdField_c_of_type_JavaLangString = a();
  }
  
  public String getUAMark()
  {
    return null;
  }
  
  public View getVideoLoadingProgressView()
  {
    return null;
  }
  
  protected void h()
  {
    synchronized (biiq.a)
    {
      if (WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
        WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebViewModule", 2, "-->web engine and plugin initialized at process preload!");
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.b();
        if (bift.a(this.jdField_a_of_type_AndroidContentIntent) != null)
        {
          ??? = bift.a(this.jdField_a_of_type_AndroidContentIntent);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, null, ((WebAccelerateHelper.CommonJsPluginFactory)???).getCommonJsPlugin());
          WebAccelerateHelper.getInstance().bindFragment(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, null);
        }
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.jdField_a_of_type_ComTencentCommonAppAppInterface, null, null, bift.a(this.jdField_a_of_type_AndroidContentIntent), null);
    WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, this.jdField_a_of_type_ComTencentCommonAppAppInterface, null);
    WebAccelerateHelper.getInstance().bindFragment(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, null);
  }
  
  public void handlePreloadCallback(int paramInt, String paramString) {}
  
  public Object handlerMiscCallback(String paramString, Bundle paramBundle)
  {
    return null;
  }
  
  protected void i()
  {
    int k = -1;
    int j = 0;
    int i;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = a().a();
      System.currentTimeMillis();
      i = k;
      switch (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("reqType", -1))
      {
      default: 
        i = k;
      }
    }
    for (;;)
    {
      if (AppSetting.f) {
        i = 2;
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setCacheMode(i);
      if (QLog.isColorLevel()) {
        QLog.i("WebViewModule", 2, "setCacheMode=" + i);
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setAllowFileAccessFromFileURLs(false);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setAllowUniversalAccessFromFileURLs(false);
      System.currentTimeMillis();
      long l1 = System.currentTimeMillis();
      IX5WebViewExtension localIX5WebViewExtension = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension();
      i = j;
      if (localIX5WebViewExtension != null) {
        i = 1;
      }
      if (i != 0)
      {
        Bundle localBundle = biit.a();
        if (localBundle != null) {
          localIX5WebViewExtension.invokeMiscMethod("setDomainsAndArgumentForImageRequest", localBundle);
        }
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("WebViewModule", 2, "setDomainsAndArgumentForImageRequest, cost=" + (l2 - l1));
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.jdField_c_of_type_JavaLangString, 8589934623L, null);
      return;
      i = 2;
      continue;
      i = 0;
    }
  }
  
  public void j()
  {
    nwo.a("Web_readyToLoadUrl");
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_c_of_type_JavaLangString);
      }
      nwo.b("Web_readyToLoadUrl");
    } while (!this.jdField_a_of_type_ComTencentBizUiTouchWebView.isPaused);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.onResume();
  }
  
  void k()
  {
    if (1 != this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Biih.b();
      this.jdField_a_of_type_Biih.a();
      this.jdField_a_of_type_Biih.a(new Bundle());
    }
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt) {}
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewModule", 2, "onGeolocationPermissionsShowPrompt:" + paramString);
    }
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.indexOf(':') == -1)
      {
        str = paramString;
        if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
        {
          str = paramString;
          if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() != null) {
            str = "https://" + paramString + "/";
          }
        }
      }
    }
    boolean bool2 = this.jdField_a_of_type_Nro.a(str, "publicAccount.getLocation");
    paramString = "";
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      paramString = nwo.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 2);
    }
    boolean bool3 = PublicAccountJavascriptInterface.getLocationPermissionGrant(this.jdField_b_of_type_JavaLangString, paramString);
    if ((bool3) && (bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebViewModule", 2, new Object[] { "onGeolocationPermissionsShowPrompt allow:", Boolean.valueOf(bool2), " granted:", Boolean.valueOf(bool3), " hasRight:", Boolean.valueOf(bool1), " uin:", this.jdField_b_of_type_JavaLangString, " urlHost:", paramString });
      }
      paramGeolocationPermissionsCallback.invoke(str, bool1, false);
      return;
    }
  }
  
  public void onHideCustomView() {}
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {}
    do
    {
      return;
      k();
      this.d = false;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.pageFinish(paramString);
      }
    } while ((Build.VERSION.SDK_INT < 19) || (this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Bigb == null) || (this.jdField_a_of_type_Bigb.a() == null));
    onReceivedTitle(paramWebView, paramWebView.getTitle());
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return;
    }
    k();
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {}
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return;
    }
    k();
  }
  
  public void onReceivedSslError(WebView paramWebView, SslError paramSslError) {}
  
  public void onReceivedTitle(WebView paramWebView, String paramString) {}
  
  public boolean onShowFileChooser(ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    return false;
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WebViewModule", 2, "X5 webkit detect 302 url: " + paramString2);
    }
    this.jdField_a_of_type_JavaLangString = paramString2;
    SwiftBrowserCookieMonster.d();
    a(paramString1, paramString2);
  }
  
  public void onWebViewClientImplPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return true;
    }
    if (((paramString.startsWith("http://")) || (!paramString.startsWith("https://"))) || (((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://"))) && (!paramString.startsWith("http://")) && (paramString.startsWith("https://")))) {}
    String str = biit.b(paramString);
    if (("http".equals(str)) || ("https".equals(str)))
    {
      paramWebView = paramWebView.getHitTestResult();
      if ((paramWebView != null) && (paramWebView.getType() == 0))
      {
        QLog.i("WebViewModule", 1, "shouldOverrideUrlLoading detect 302, url: " + paramString);
        paramWebView = this.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_JavaLangString = paramString;
        SwiftBrowserCookieMonster.d();
        a(paramWebView, this.jdField_a_of_type_JavaLangString);
      }
    }
    return false;
  }
  
  public void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bifq
 * JD-Core Version:    0.7.0.1
 */