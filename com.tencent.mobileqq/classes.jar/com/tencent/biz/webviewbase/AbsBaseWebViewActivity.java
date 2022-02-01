package com.tencent.biz.webviewbase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.FileChooserHelper;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserSetting;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.injector.AbsBaseWebViewActivityInjectorUtil;
import com.tencent.mobileqq.webview.swift.injector.IAbsBaseWebViewActivityInjector;
import com.tencent.mobileqq.webview.swift.utils.BaseOpenWebMonitor;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.util.WebViewComUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.sonic.sdk.SonicSession;
import com.tencent.sonic.sdk.SonicSessionConfig.Builder;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public abstract class AbsBaseWebViewActivity
  extends QIphoneTitleBarActivity
  implements View.OnClickListener, View.OnTouchListener, WebViewPluginContainer, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter
{
  public static final String ACTION_SELECT_PICTURE = "actionSelectPicture";
  public static final String EXTRA_ACTION = "keyAction";
  static final String TAG = "WebLog_WebViewBase";
  public static final String WEBVIEW_ADJUST_SETTINGS = "Web_AdjustSettings";
  public static final String WEBVIEW_BROWSER_INIT_WEBVIEW = "Web_qqbrowser_init_only_webview";
  public static final String WEBVIEW_SET_USER_AGENT = "Web_SetUserAgent";
  protected AuthorizeConfig authConfig;
  public FrameLayout customContainer;
  private IAbsBaseWebViewActivityInjector injector;
  public boolean isDestroyed;
  private boolean isRecordTitleLeftDrawable;
  private boolean isRecordTitleRightDrawable;
  boolean isVideoPlaying;
  public volatile AppInterface mApp;
  public CustomWebChromeClient mChromeClient;
  public final SwiftBrowserComponentsProvider mComponentsProvider = createComponentsProvider();
  protected FileChooserHelper mFileChooserHelper;
  public long mFloatBarRulesFromUrl = 5L;
  protected final Handler mHandler = new Handler(Looper.getMainLooper());
  protected long mLastTouchTime = 0L;
  protected boolean mNightMode = false;
  protected volatile WebViewPluginEngine mPluginEngine;
  public String mRedirect302Url = "";
  protected String mRightButtonCallback = null;
  protected JsBridgeListener mRightButtonListener = null;
  private ImageView mRightCornerIcon;
  public long mRulesFromUrl = 4L;
  protected final SwiftBrowserSetting mSetting = (SwiftBrowserSetting)this.mComponentsProvider.a(-1);
  public final SwiftBrowserStatistics mStatistics = (SwiftBrowserStatistics)this.mComponentsProvider.a(-2);
  public SwiftIphoneTitleBarUI mSwiftTitleUI = null;
  private Drawable mTitleLeftDrawable;
  public final SwiftBrowserUIStyle mUIStyle = this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
  public final SwiftBrowserUIStyleHandler mUIStyleHandler = (SwiftBrowserUIStyleHandler)this.mComponentsProvider.a(2);
  public long mWWVRulesFromUrl = 0L;
  private WebViewClient mWebViewClient;
  public TouchWebView mWebViewInstance;
  private boolean mX5CoreActive = false;
  protected final Object sInitEngineLock = new Object();
  protected SonicClientImpl sonicClient;
  public String uin;
  
  private void initPluginEngine()
  {
    if (this.mPluginEngine != null) {
      return;
    }
    if ((this.mPluginEngine == null) && (WebViewPluginEngine.a != null))
    {
      this.mPluginEngine = WebViewPluginEngine.a;
      WebViewPluginEngine.a = null;
      WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.mPluginEngine, this.mApp, this);
      return;
    }
    ThreadManager.postImmediately(new AbsBaseWebViewActivity.5(this), null, false);
  }
  
  private void initSonicSession(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initSonicSession url = :");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("WebLog_WebViewBase", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new SonicSessionConfig.Builder();
    ((SonicSessionConfig.Builder)localObject).setSessionMode(1);
    SonicEngine localSonicEngine = WebAccelerateHelper.getSonicEngine();
    if (localSonicEngine != null)
    {
      localObject = localSonicEngine.createSession(paramString, ((SonicSessionConfig.Builder)localObject).build());
      if (localObject != null)
      {
        this.sonicClient = new SonicClientImpl((SonicSession)localObject);
        ((SonicSession)localObject).bindClient(this.sonicClient);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initSonicSession sonicSession = null, url = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("WebLog_WebViewBase", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public static int switchRequestCodeImpl(WebViewPlugin paramWebViewPlugin, byte paramByte)
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
        paramWebViewPlugin.append("switchRequestCode failed: webview index=");
        paramWebViewPlugin.append(0);
        paramWebViewPlugin.append(", pluginIndex=");
        paramWebViewPlugin.append(i);
        QLog.d("WebLog_WebViewBase", 2, paramWebViewPlugin.toString());
      }
      return -1;
    }
    return i << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
  
  public SwiftBrowserComponentsProvider createComponentsProvider()
  {
    return new SwiftBrowserComponentsProvider(this, 127, null);
  }
  
  public final TouchWebView createWebViewInstance(ViewGroup paramViewGroup)
  {
    Util.a("Web_qqbrowser_init_only_webview");
    Object localObject2 = getIntent();
    long l = System.currentTimeMillis();
    if (0L != (this.mWWVRulesFromUrl & 0x40)) {
      localObject1 = SwiftReuseTouchWebView.a(this);
    } else {
      localObject1 = new TouchWebView(this);
    }
    boolean bool;
    if ((localObject1 instanceof SwiftReuseTouchWebView))
    {
      localObject3 = this.mStatistics;
      if (1 == ((SwiftReuseTouchWebView)localObject1).b) {
        bool = true;
      } else {
        bool = false;
      }
      ((SwiftBrowserStatistics)localObject3).r = bool;
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("TouchWebView cost = ");
      ((StringBuilder)localObject3).append(System.currentTimeMillis() - l);
      QLog.d("webviewinit", 2, ((StringBuilder)localObject3).toString());
    }
    ((TouchWebView)localObject1).setIntent((Intent)localObject2);
    Util.b("Web_qqbrowser_init_only_webview");
    if ((this.mApp == null) && (QLog.isColorLevel())) {
      QLog.w("WebLog_WebViewBase", 2, "Caution! AppRuntime is null!");
    }
    this.mPluginEngine.a((CustomWebView)localObject1);
    ((TouchWebView)localObject1).setPluginEngine(this.mPluginEngine);
    localObject2 = this.sonicClient;
    if (localObject2 != null) {
      ((SonicClientImpl)localObject2).bindWebView((CustomWebView)localObject1);
    }
    System.currentTimeMillis();
    if (this.mChromeClient == null) {
      this.mChromeClient = new AbsBaseWebViewActivity.1(this);
    }
    ((TouchWebView)localObject1).setWebChromeClient(this.mChromeClient);
    if (this.mWebViewClient == null) {
      if (Build.VERSION.SDK_INT >= 21) {
        this.mWebViewClient = new AbsBaseWebViewActivity.2(this);
      } else {
        this.mWebViewClient = new AbsBaseWebViewActivity.3(this);
      }
    }
    ((TouchWebView)localObject1).setWebViewClient(this.mWebViewClient);
    ((TouchWebView)localObject1).setScrollBarStyle(0);
    Util.a("Web_AdjustSettings");
    Object localObject3 = ((TouchWebView)localObject1).getSettings();
    Util.a("Web_SetUserAgent");
    localObject2 = ((WebSettings)localObject3).getUserAgentString();
    Object localObject4 = getUAMark();
    if (((TouchWebView)localObject1).getX5WebViewExtension() != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((WebSettings)localObject3).setUserAgentString(SwiftWebViewUtils.a((String)localObject2, (String)localObject4, bool));
    Util.b("Web_SetUserAgent");
    ((WebSettings)localObject3).setSavePassword(false);
    ((WebSettings)localObject3).setSaveFormData(false);
    ((WebSettings)localObject3).setBuiltInZoomControls(true);
    ((WebSettings)localObject3).setUseWideViewPort(true);
    ((WebSettings)localObject3).setLoadWithOverviewMode(true);
    ((WebSettings)localObject3).setPluginState(WebSettings.PluginState.ON);
    localObject2 = getPackageManager();
    try
    {
      if (((PackageManager)localObject2).hasSystemFeature("android.hardware.touchscreen.multitouch")) {
        break label439;
      }
      bool = ((PackageManager)localObject2).hasSystemFeature("android.hardware.faketouch.multitouch.distinct");
      if (!bool) {}
    }
    catch (RuntimeException localRuntimeException)
    {
      try
      {
        int i;
        StringBuilder localStringBuilder;
        ((TouchWebView)localObject1).requestFocus();
        ((TouchWebView)localObject1).setFocusableInTouchMode(true);
        ((TouchWebView)localObject1).setDownloadListener(new AbsBaseWebViewActivity.4(this, (TouchWebView)localObject1));
        CookieSyncManager.createInstance(getApplicationContext());
        if (((TouchWebView)localObject1).getX5WebViewExtension() == null) {
          break label765;
        }
        this.mX5CoreActive = true;
        ((TouchWebView)localObject1).getX5WebViewExtension().setWebViewClientExtension(new AbsBaseWebViewActivity.DownloadQQBrowserExtension(this, (TouchWebView)localObject1));
        BaseOpenWebMonitor.b(getIntent(), "use_x5", "1");
        break label778;
        BaseOpenWebMonitor.b(getIntent(), "use_x5", "2");
        ((TouchWebView)localObject1).getView().setOnTouchListener(this);
        if (!this.mNightMode) {
          break label800;
        }
        ((TouchWebView)localObject1).setMask(true);
        Util.b("Web_AdjustSettings");
        if (paramViewGroup == null) {
          break label815;
        }
        paramViewGroup.addView((View)localObject1);
        return localObject1;
        localRuntimeException = localRuntimeException;
      }
      catch (Exception localException)
      {
        break label687;
      }
    }
    i = 0;
    break label441;
    label439:
    i = 1;
    label441:
    ((WebSettings)localObject3).setDisplayZoomControls(i ^ 0x1);
    ((WebSettings)localObject3).setPluginsEnabled(true);
    ((WebSettings)localObject3).setJavaScriptEnabled(true);
    ((WebSettings)localObject3).setAllowContentAccess(true);
    ((WebSettings)localObject3).setDatabaseEnabled(true);
    ((WebSettings)localObject3).setDomStorageEnabled(true);
    ((WebSettings)localObject3).setAppCacheEnabled(true);
    localObject2 = MobileQQ.getMobileQQ().getQQProcessName();
    if (localObject2 != null)
    {
      i = ((String)localObject2).lastIndexOf(':');
      if (i > -1)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("_");
        ((StringBuilder)localObject4).append(((String)localObject2).substring(i + 1));
        localObject2 = ((StringBuilder)localObject4).toString();
        break label557;
      }
    }
    localObject2 = "";
    label557:
    localObject4 = getApplicationContext();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("database");
    localStringBuilder.append((String)localObject2);
    ((WebSettings)localObject3).setDatabasePath(((Context)localObject4).getDir(localStringBuilder.toString(), 0).getPath());
    localObject4 = getApplicationContext();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("appcache");
    localStringBuilder.append((String)localObject2);
    ((WebSettings)localObject3).setAppCachePath(((Context)localObject4).getDir(localStringBuilder.toString(), 0).getPath());
    ((WebSettings)localObject3).setMediaPlaybackRequiresUserGesture(false);
    if (Build.VERSION.SDK_INT >= 11) {
      ((TouchWebView)localObject1).removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  protected boolean dispatchPluginEvent(long paramLong, Map<String, Object> paramMap)
  {
    Object localObject = this.mWebViewInstance;
    if (localObject != null)
    {
      ((TouchWebView)localObject).onResume();
      localObject = this.mWebViewInstance.getPluginEngine();
      if (localObject != null) {
        return ((WebViewPluginEngine)localObject).a(this.mWebViewInstance.getUrl(), paramLong, paramMap);
      }
    }
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult, requestCode=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", resultCode=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("WebLog_WebViewBase", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("requestCode", Integer.valueOf(paramInt1));
    ((Map)localObject).put("resultCode", Integer.valueOf(paramInt2));
    ((Map)localObject).put("data", paramIntent);
    if (dispatchPluginEvent(8589934600L, (Map)localObject)) {
      return;
    }
    int i = paramInt1 >> 8 & 0xFF;
    if (i > 0)
    {
      localObject = this.mWebViewInstance;
      if (localObject != null)
      {
        localObject = ((TouchWebView)localObject).getPluginEngine();
        if (localObject != null)
        {
          localObject = ((WebViewPluginEngine)localObject).a(i, true);
          if (localObject != null)
          {
            ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)(paramInt1 & 0xFF), paramInt2);
            return;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w("WebLog_WebViewBase", 2, "Caution! activity result not handled!");
      }
    }
    else
    {
      localObject = this.mFileChooserHelper;
      if ((localObject != null) && (((FileChooserHelper)localObject).a(paramInt1, paramInt2, paramIntent)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("WebLog_WebViewBase", 2, "Activity result handled by FileChooserHelper.");
        }
      }
      else
      {
        if (paramInt2 == 4660)
        {
          setResult(4660);
          finish();
          return;
        }
        localObject = this.mWebViewInstance;
        if (localObject != null)
        {
          IAbsBaseWebViewActivityInjector localIAbsBaseWebViewActivityInjector = this.injector;
          if (localIAbsBaseWebViewActivityInjector != null) {
            localIAbsBaseWebViewActivityInjector.a(paramInt1, paramInt2, paramIntent, (TouchWebView)localObject);
          }
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "doOnCreate");
    }
    super.doOnCreate(paramBundle);
    paramBundle = getAppRuntime();
    if ((paramBundle instanceof AppInterface)) {
      this.mApp = ((AppInterface)paramBundle);
    }
    if (!VipWebViewReportLog.a()) {
      VipWebViewReportLog.a(this, this.mApp);
    }
    QQBrowserActivity.sQQBrowserActivityCounter += 1;
    this.mNightMode = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    setTheme(2131755316);
    this.authConfig = AuthorizeConfig.a();
    WebAccelerateHelper.isWebViewCache = true;
    QLog.d("WebLog_WebViewBase", 1, "doOnCreate, WebAccelerateHelper.isWebViewCache = true");
    paramBundle = this.mStatistics;
    this.isDestroyed = false;
    paramBundle.k = false;
    this.uin = this.mApp.getAccount();
    this.injector = AbsBaseWebViewActivityInjectorUtil.a();
    paramBundle = this.injector;
    if (paramBundle != null) {
      paramBundle.a(this);
    }
    initPluginEngineOnActivityCreated();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "onDestroy");
    }
    QQBrowserActivity.sQQBrowserActivityCounter -= 1;
    Object localObject = this.mStatistics;
    this.isDestroyed = true;
    ((SwiftBrowserStatistics)localObject).k = true;
    localObject = this.mChromeClient;
    if (localObject != null) {
      ((CustomWebChromeClient)localObject).a();
    }
    localObject = this.mWebViewInstance;
    if (localObject != null)
    {
      localObject = ((TouchWebView)localObject).getPluginEngine();
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).b();
      }
      if (this.mWebViewInstance.getParent() == null) {}
    }
    try
    {
      ((ViewGroup)this.mWebViewInstance.getParent()).removeView(this.mWebViewInstance);
    }
    catch (Exception localException1)
    {
      try
      {
        this.mWebViewInstance.stopLoading();
        this.mWebViewInstance.loadUrlOriginal("about:blank");
        this.mWebViewInstance.clearView();
        this.mWebViewInstance.destroy();
        this.mWebViewInstance = null;
        this.mApp = null;
        return;
        localException1 = localException1;
      }
      catch (Exception localException2)
      {
        break label129;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "remove webview error");
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 24)
    {
      if (paramInt != 25)
      {
        if (paramInt == 82) {
          dispatchPluginEvent(8589934607L, null);
        }
      }
      else {
        dispatchPluginEvent(8589934608L, null);
      }
    }
    else {
      dispatchPluginEvent(8589934609L, null);
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    if ("actionSelectPicture".equals(paramIntent.getStringExtra("keyAction")))
    {
      int i = -1;
      int j = paramIntent.getIntExtra("requestCode", -1);
      int k = j >> 8 & 0xFF;
      if (k > 0)
      {
        localObject = this.mWebViewInstance;
        if (localObject != null)
        {
          localObject = ((TouchWebView)localObject).getPluginEngine();
          if (localObject != null)
          {
            localObject = ((WebViewPluginEngine)localObject).a(k, true);
            if (localObject != null)
            {
              if (!paramIntent.hasExtra("PhotoConst.PHOTO_PATHS")) {
                i = 0;
              }
              ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)(j & 0xFF), i);
              return;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.w("WebLog_WebViewBase", 2, "Caution! activity result not handled!");
        }
      }
    }
    this.uin = this.mApp.getAccount();
    Object localObject = new HashMap();
    ((Map)localObject).put("intent", paramIntent);
    dispatchPluginEvent(128L, (Map)localObject);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "onPause");
    }
    Object localObject = this.mWebViewInstance;
    if (localObject != null) {
      ((TouchWebView)localObject).onPause();
    }
    localObject = this.mChromeClient;
    if ((localObject != null) && (this.isVideoPlaying)) {
      ((CustomWebChromeClient)localObject).onHideCustomView();
    }
    dispatchPluginEvent(8589934597L, null);
    localObject = this.injector;
    if (localObject != null) {
      ((IAbsBaseWebViewActivityInjector)localObject).b(this);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "onResume");
    }
    Object localObject = this.mWebViewInstance;
    if (localObject != null) {
      ((TouchWebView)localObject).onResume();
    }
    dispatchPluginEvent(2L, null);
    localObject = this.injector;
    if (localObject != null) {
      ((IAbsBaseWebViewActivityInjector)localObject).a(this);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if ((this.mRulesFromUrl & 0x2000000) != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewBase", 2, "close on hide by wv param");
      }
      finish();
    }
  }
  
  public void finish()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    super.finish();
    if (getIntent().getBooleanExtra("finish_animation_up_down", false)) {
      overridePendingTransition(0, 2130771992);
    }
  }
  
  public SwiftBrowserComponentsProvider getComponentProvider()
  {
    return this.mComponentsProvider;
  }
  
  public Activity getHostActivity()
  {
    return this;
  }
  
  public WebView getHostWebView()
  {
    throw new UnsupportedOperationException("must override this method getHostWebView()!");
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  protected String getUAMark()
  {
    return null;
  }
  
  public final TouchWebView getWebView(ViewGroup paramViewGroup)
  {
    TouchWebView localTouchWebView = this.mWebViewInstance;
    if (localTouchWebView != null) {
      return localTouchWebView;
    }
    this.mWebViewInstance = createWebViewInstance(paramViewGroup);
    return this.mWebViewInstance;
  }
  
  public WebViewProvider getWebViewProvider()
  {
    return null;
  }
  
  public void gotoSelectPicture(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i = switchRequestCode(paramWebViewPlugin, paramByte);
    paramIntent.putExtra("keyAction", "actionSelectPicture");
    paramIntent.putExtra("requestCode", i);
    startActivity(paramIntent);
  }
  
  public void gotoSelectPicture(WebViewPlugin paramWebViewPlugin, ActivityURIRequest paramActivityURIRequest, byte paramByte)
  {
    int i = switchRequestCode(paramWebViewPlugin, paramByte);
    paramActivityURIRequest.extra().putString("keyAction", "actionSelectPicture");
    paramActivityURIRequest.extra().putInt("requestCode", i);
    QRoute.startUri(paramActivityURIRequest);
  }
  
  public void init(Intent paramIntent)
  {
    super.init(paramIntent);
    if (this.vg != null) {
      this.vg.setOnTouchListener(new AbsBaseWebViewActivity.7(this));
    }
    removeWebViewLayerType();
    this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
    this.mSwiftTitleUI.b = this.centerView;
    this.mSwiftTitleUI.c = this.rightViewText;
    this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView = this.rightViewImg;
    this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup = this.vg;
  }
  
  public final void initPluginEngineOnActivityCreated()
  {
    if ((this.mPluginEngine == null) && (WebViewPluginEngine.a != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbsBaseWebViewActivity", 2, "-->web engine and plugin initialized at process preload!");
      }
      this.mPluginEngine = WebViewPluginEngine.a;
      WebViewPluginEngine.a = null;
      WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.mPluginEngine, this.mApp, this);
      this.mPluginEngine.a();
      return;
    }
    if (this.mPluginEngine == null) {
      synchronized (this.sInitEngineLock)
      {
        if (this.mPluginEngine == null)
        {
          this.mPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.mApp, this, null, null);
          WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.mPluginEngine, this.mApp, this);
        }
        return;
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    Object localObject1 = this.mChromeClient;
    if ((localObject1 != null) && (this.isVideoPlaying))
    {
      ((CustomWebChromeClient)localObject1).onHideCustomView();
      return true;
    }
    localObject1 = this.sonicClient;
    if (localObject1 != null)
    {
      ((SonicClientImpl)localObject1).clearHistory();
      this.sonicClient.destroy();
      this.sonicClient = null;
    }
    localObject1 = new HashMap(1);
    ((Map)localObject1).put("target", Integer.valueOf(3));
    if (dispatchPluginEvent(8589934601L, (Map)localObject1)) {
      return true;
    }
    if ((this.mRulesFromUrl & 0x4) == 0L)
    {
      Object localObject2 = this.mWebViewInstance;
      if ((localObject2 != null) && (((TouchWebView)localObject2).canGoBack()))
      {
        this.mWebViewInstance.stopLoading();
        this.mWebViewInstance.goBack();
        localObject2 = this.mWebViewInstance.getPluginEngine();
        if (localObject2 != null) {
          ((WebViewPluginEngine)localObject2).a(this.mWebViewInstance.getUrl(), 8589934610L, (Map)localObject1);
        }
        return true;
      }
    }
    localObject1 = (InputMethodManager)getSystemService("input_method");
    if ((localObject1 != null) && (getCurrentFocus() != null)) {
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    localObject1 = this.mChromeClient;
    if ((localObject1 != null) && (this.isVideoPlaying))
    {
      ((CustomWebChromeClient)localObject1).onHideCustomView();
      return true;
    }
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.rightViewImg) || (paramView == this.rightHighLView) || (paramView == this.rightViewText)) {
      rightButtonCallBack();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    SwiftWebAccelerator.a().a();
    String str = SwiftWebViewUtils.a(getIntent());
    WebAccelerateHelper.getInstance().preGetKey(str, getIntent(), this.mApp);
    WebAccelerateHelper.getInstance().preCheckOffline(str);
    WebAccelerateHelper.getInstance().preFetchResource(str);
    this.mUIStyleHandler.b();
    this.mSwiftTitleUI = this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI;
    boolean bool = WebAccelerateHelper.isWebViewCache;
    initSonicSession(str);
    ThreadManager.getFileThreadHandler().post(new AbsBaseWebViewActivity.6(this, bool));
    super.onCreate(paramBundle);
    paramBundle = new StringBuilder();
    paramBundle.append("onCreate cache:");
    paramBundle.append(bool);
    QLog.i("WebLog_WebViewBase", 1, paramBundle.toString());
    this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    if (this.mApp != null)
    {
      if ((!bool) && (!VipWebViewReportLog.a())) {
        VipWebViewReportLog.a(this, this.mApp);
      }
      initPluginEngine();
    }
    paramBundle = new StringBuilder();
    paramBundle.append(Build.MANUFACTURER);
    paramBundle.append("_");
    paramBundle.append(Build.MODEL);
    paramBundle = paramBundle.toString();
    if ((Build.VERSION.SDK_INT > 10) && (!WebViewComUtils.a.contains(paramBundle))) {
      getWindow().addFlags(16777216);
    }
    getWindow().setFormat(-3);
  }
  
  protected void onPageFinished(WebView paramWebView, String paramString) {}
  
  protected void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public void onPostThemeChanged()
  {
    if (this.mApp != null)
    {
      this.mNightMode = ThemeUtil.isInNightMode(this.mApp);
      dispatchPluginEvent(8589934604L, null);
    }
    if ((this.mSystemBarComp != null) && (!this.mUIStyle.i))
    {
      int i = getResources().getColor(2131167114);
      this.mSystemBarComp.setStatusColor(i);
      this.mSystemBarComp.setStatusBarColor(i);
    }
  }
  
  protected void onProgressChanged(WebView paramWebView, int paramInt) {}
  
  protected void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  protected void onReceivedTitle(WebView paramWebView, String paramString) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      this.mLastTouchTime = System.currentTimeMillis();
    }
    return false;
  }
  
  protected void onUrlChange(String paramString1, String paramString2) {}
  
  public final int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i = switchRequestCode(paramWebViewPlugin, paramByte);
    if (i == -1)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WebLog_WebViewBase", 2, "pluginStartActivityForResult not handled");
        return i;
      }
    }
    else {
      startActivityForResult(paramIntent, i);
    }
    return i;
  }
  
  protected boolean rightButtonCallBack()
  {
    if (this.mWebViewInstance != null)
    {
      JsBridgeListener localJsBridgeListener = this.mRightButtonListener;
      if ((localJsBridgeListener != null) && (localJsBridgeListener.a))
      {
        this.mWebViewInstance.callJs4OpenApi(this.mRightButtonListener, 0, new String[] { "" });
        return true;
      }
      if (!TextUtils.isEmpty(this.mRightButtonCallback))
      {
        this.mWebViewInstance.callJs(this.mRightButtonCallback, new String[] { "" });
        return true;
      }
    }
    return false;
  }
  
  public void setRightButton(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener)
  {
    int i;
    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.a)) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramBoolean)
    {
      this.mUIStyle.e = true;
      this.rightViewText.setVisibility(8);
      this.rightViewImg.setVisibility(8);
      paramString1 = this.mRightCornerIcon;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      return;
    }
    if (paramInt1 == 0)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        this.rightViewText.setText(paramString2);
        this.rightViewText.setVisibility(0);
        this.rightViewText.bringToFront();
        this.rightViewImg.setImageResource(0);
        this.rightViewImg.setBackgroundColor(0);
        this.rightViewImg.setVisibility(8);
      }
      if ((paramString3 != null) && (paramString3.length() <= 0)) {}
    }
    try
    {
      paramInt1 = Color.parseColor(paramString3);
    }
    catch (Exception paramString2)
    {
      label149:
      RelativeLayout.LayoutParams localLayoutParams;
      label910:
      break label149;
    }
    paramInt1 = 0;
    this.rightViewImg.setBackgroundColor(paramInt1);
    if ((paramString1 != null) && (i == 0))
    {
      this.rightViewImg.setOnClickListener(this);
      this.rightViewText.setOnClickListener(this);
      this.mRightButtonCallback = paramString1.trim();
    }
    else
    {
      this.mRightButtonListener = paramJsBridgeListener;
      this.mRightButtonCallback = null;
      break label910;
      this.rightViewText.setVisibility(8);
      this.rightViewImg.setVisibility(0);
      paramString3 = this.mUIStyle;
      if (paramInt1 != 4) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramString3.e = paramBoolean;
      switch (paramInt1)
      {
      case 6: 
      default: 
        this.rightViewImg.setVisibility(8);
        break;
      case 10: 
        this.mUIStyleHandler.a(this.rightViewImg, false, 2130850663, 2130850663);
        this.rightViewImg.setContentDescription(getResources().getString(2131692634));
        break;
      case 9: 
        this.mUIStyleHandler.a(this.rightViewImg, false, 2130838831, 2130838831);
        this.rightViewImg.setContentDescription(getResources().getString(2131692634));
        break;
      case 8: 
      case 11: 
        this.mUIStyleHandler.a(this.rightViewImg, false, 2130850469, 2130850473);
        this.rightViewImg.setContentDescription(getResources().getString(2131689589));
        break;
      case 7: 
        this.mUIStyleHandler.a(this.rightViewImg, false, 2130842612, 2130842615);
        this.rightViewImg.setContentDescription(getResources().getString(2131689589));
        break;
      case 5: 
        this.rightViewImg.setImageResource(2130844052);
        this.rightViewImg.setContentDescription(getResources().getString(2131692636));
        ((AnimationDrawable)this.rightViewImg.getDrawable()).start();
        break;
      case 4: 
        this.mUIStyleHandler.a(this.rightViewImg, false, 2130839368, 2130839360);
        this.rightViewImg.setContentDescription(getResources().getString(2131692635));
        break;
      case 3: 
        this.mUIStyleHandler.a(this.rightViewImg, false, 2130840351, 2130840347);
        this.rightViewImg.setContentDescription(getResources().getString(2131692633));
        break;
      case 2: 
        this.mUIStyleHandler.a(this.rightViewImg, false, 2130844007, 2130844007);
        this.rightViewImg.setContentDescription(getResources().getString(2131692630));
        break;
      case 1: 
        this.mUIStyleHandler.a(this.rightViewImg, false, 2130844008, 2130844008);
        this.rightViewImg.setContentDescription(getResources().getString(2131692631));
      }
      if (paramInt2 != 0)
      {
        if (this.mRightCornerIcon == null)
        {
          this.mRightCornerIcon = new ImageView(this);
          paramString3 = (RelativeLayout)findViewById(2131376756);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(7, 2131369216);
          localLayoutParams.addRule(6, 2131369216);
          localLayoutParams.setMargins(0, 0, 0, 0);
          this.mRightCornerIcon.setLayoutParams(localLayoutParams);
          paramString3.addView(this.mRightCornerIcon);
        }
        this.mRightCornerIcon.setVisibility(0);
        if (paramInt2 != 6) {
          this.mRightCornerIcon.setVisibility(8);
        } else {
          this.mRightCornerIcon.setImageResource(2130843844);
        }
      }
      else
      {
        paramString3 = this.mRightCornerIcon;
        if (paramString3 != null) {
          paramString3.setVisibility(8);
        }
      }
      if (!TextUtils.isEmpty(paramString2)) {
        this.rightViewImg.setContentDescription(paramString2);
      }
      if (paramOnClickListener != null)
      {
        this.rightViewImg.setOnClickListener(paramOnClickListener);
      }
      else if ((paramString1 != null) && (i == 0))
      {
        this.rightViewImg.setOnClickListener(this);
        this.rightViewText.setOnClickListener(this);
        this.mRightButtonCallback = paramString1.trim();
      }
      else
      {
        this.mRightButtonCallback = null;
        this.mRightButtonListener = paramJsBridgeListener;
      }
      this.isRecordTitleLeftDrawable = false;
      this.isRecordTitleRightDrawable = false;
    }
    if ((this.mUIStyle.a != null) && (this.mUIStyle.a.has("txtclr")))
    {
      paramString2 = this.mUIStyle.a.optString("txtclr", "");
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString2;
        if (!paramString2.startsWith("#"))
        {
          paramString1 = new StringBuilder();
          paramString1.append("#");
          paramString1.append(paramString2);
          paramString1 = paramString1.toString();
        }
        try
        {
          paramInt1 = Color.parseColor(paramString1);
          paramString1 = BaseImageUtil.a(this.rightViewImg.getDrawable(), paramInt1);
          if (paramString1 != null) {
            this.rightViewImg.setImageDrawable(paramString1);
          }
          this.rightViewText.setTextColor(paramInt1);
          return;
        }
        catch (Exception paramString1)
        {
          QLog.e("WebLog_WebViewBase", 1, paramString1, new Object[0]);
        }
      }
    }
  }
  
  public void setRightButton(boolean paramBoolean)
  {
    ImageView localImageView;
    if (paramBoolean)
    {
      this.mUIStyle.e = true;
      if (this.rightViewText != null) {
        this.rightViewText.setVisibility(8);
      }
      if (this.rightViewImg != null) {
        this.rightViewImg.setVisibility(8);
      }
      localImageView = this.mRightCornerIcon;
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
    }
    else
    {
      if ((this.rightViewText != null) && (!TextUtils.isEmpty(this.rightViewText.getText()))) {
        this.rightViewText.setVisibility(0);
      }
      if (this.rightViewImg != null) {
        this.rightViewImg.setVisibility(0);
      }
      localImageView = this.mRightCornerIcon;
      if (localImageView != null) {
        localImageView.setVisibility(0);
      }
    }
  }
  
  protected boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  public boolean showPreview()
  {
    setImmersiveStatus();
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.init();
    }
    overridePendingTransition(0, 0);
    setContentViewNoTitle(2131558724);
    ((TextView)findViewById(2131371534)).setText(2131692119);
    return true;
  }
  
  public void startActivityFromFragment(@NonNull Fragment paramFragment, Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    if (paramInt == -1)
    {
      ActivityCompat.startActivityForResult(this, paramIntent, -1, paramBundle);
      return;
    }
    ActivityCompat.startActivityForResult(this, paramIntent, paramInt, paramBundle);
  }
  
  public void startIntentSenderFromFragment(@NonNull Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, @Nullable Bundle paramBundle)
  {
    if (paramInt1 == -1)
    {
      ActivityCompat.startIntentSenderForResult(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    ActivityCompat.startIntentSenderForResult(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public final int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    return switchRequestCodeImpl(paramWebViewPlugin, paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewbase.AbsBaseWebViewActivity
 * JD-Core Version:    0.7.0.1
 */