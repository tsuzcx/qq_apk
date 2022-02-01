package com.tencent.biz.webviewbase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.FileChooserHelper;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
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
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.qphone.base.util.BaseApplication;
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
import cooperation.pluginbridge.BridgeHelper;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public abstract class AbsBaseWebViewActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnTouchListener, WebViewPluginContainer, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter
{
  public static final String ACTION_SELECT_PICTURE = "actionSelectPicture";
  public static final String EXTRA_ACTION = "keyAction";
  public static final HashSet<String> HWForbiddenList = new HashSet();
  public static final int REQUEST_CODE_CHOOSE_FILE = 0;
  static final String TAG = "WebLog_WebViewBase";
  public static final String WEBVIEW_ADJUST_SETTINGS = "Web_AdjustSettings";
  public static final String WEBVIEW_BROWSER_INIT_WEBVIEW = "Web_qqbrowser_init_only_webview";
  public static final String WEBVIEW_SET_USER_AGENT = "Web_SetUserAgent";
  protected AuthorizeConfig authConfig;
  public FrameLayout customContainer;
  public boolean isDestroyed;
  private boolean isRecordTitleLeftDrawable;
  private boolean isRecordTitleRightDrawable;
  protected volatile boolean isSendWebSoRequest = false;
  boolean isVideoPlaying;
  public volatile AppInterface mApp;
  public CustomWebChromeClient mChromeClient;
  public final SwiftBrowserComponentsProvider mComponentsProvider = createComponentsProvider();
  protected FileChooserHelper mFileChooserHelper;
  public long mFloatBarRulesFromUrl = 5L;
  protected final Handler mHandler = new Handler(Looper.getMainLooper());
  protected long mLastTouchTime = 0L;
  protected boolean mNightMode = false;
  protected boolean mPayActionSucc = false;
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
  public final SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle mUIStyle = this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
  public final SwiftBrowserUIStyleHandler mUIStyleHandler = (SwiftBrowserUIStyleHandler)this.mComponentsProvider.a(2);
  public long mWWVRulesFromUrl = 0L;
  private WebViewClient mWebViewClient;
  public TouchWebView mWebViewInstance;
  private boolean mX5CoreActive = false;
  protected final Object sInitEngineLock = new Object();
  protected SonicClientImpl sonicClient;
  public String uin;
  
  static
  {
    HWForbiddenList.add("Meizu_M040");
    HWForbiddenList.add("YuLong_Coolpad8720Q");
    HWForbiddenList.add("YuLong_Coolpad 7269");
    HWForbiddenList.add("samsung_SM-G9006W");
  }
  
  private void doWebSoRequest()
  {
    if (!this.isSendWebSoRequest)
    {
      this.isSendWebSoRequest = true;
      String str = getIntent().getStringExtra("url");
      if (WebSoUtils.b(str)) {
        ThreadManager.postImmediately(new AbsBaseWebViewActivity.7(this, str), null, false);
      }
    }
  }
  
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
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "initSonicSession url = :" + paramString);
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
      }
    }
    else
    {
      return;
    }
    QLog.d("WebLog_WebViewBase", 1, "initSonicSession sonicSession = null, url = " + paramString);
  }
  
  public static int switchRequestCodeImpl(WebViewPlugin paramWebViewPlugin, byte paramByte)
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
    QLog.d("WebLog_WebViewBase", 2, "switchRequestCode failed: webview index=" + 0 + ", pluginIndex=" + i);
    return -1;
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
    Object localObject1;
    if (0L != (this.mWWVRulesFromUrl & 0x40)) {
      localObject1 = SwiftReuseTouchWebView.a(this);
    }
    for (;;)
    {
      Object localObject3;
      boolean bool;
      label63:
      label234:
      WebSettings localWebSettings;
      if ((localObject1 instanceof SwiftReuseTouchWebView))
      {
        localObject3 = this.mStatistics;
        if (1 == ((SwiftReuseTouchWebView)localObject1).b)
        {
          bool = true;
          ((SwiftBrowserStatistics)localObject3).u = bool;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("webviewinit", 2, "TouchWebView cost = " + (System.currentTimeMillis() - l));
        }
        ((TouchWebView)localObject1).setIntent((Intent)localObject2);
        Util.b("Web_qqbrowser_init_only_webview");
        if ((this.mApp == null) && (QLog.isColorLevel())) {
          QLog.w("WebLog_WebViewBase", 2, "Caution! AppRuntime is null!");
        }
        this.mPluginEngine.a((CustomWebView)localObject1);
        ((TouchWebView)localObject1).setPluginEngine(this.mPluginEngine);
        if (this.sonicClient != null) {
          this.sonicClient.bindWebView((CustomWebView)localObject1);
        }
        System.currentTimeMillis();
        if (this.mChromeClient == null) {
          this.mChromeClient = new AbsBaseWebViewActivity.1(this);
        }
        ((TouchWebView)localObject1).setWebChromeClient(this.mChromeClient);
        if (this.mWebViewClient == null)
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label734;
          }
          this.mWebViewClient = new AbsBaseWebViewActivity.2(this);
        }
        ((TouchWebView)localObject1).setWebViewClient(this.mWebViewClient);
        ((TouchWebView)localObject1).setScrollBarStyle(0);
        Util.a("Web_AdjustSettings");
        localWebSettings = ((TouchWebView)localObject1).getSettings();
        Util.a("Web_SetUserAgent");
        localObject2 = localWebSettings.getUserAgentString();
        localObject3 = getUAMark();
        if (((TouchWebView)localObject1).getX5WebViewExtension() == null) {
          break label749;
        }
        bool = true;
        label290:
        localWebSettings.setUserAgentString(SwiftWebViewUtils.a((String)localObject2, (String)localObject3, bool));
        Util.b("Web_SetUserAgent");
        localWebSettings.setSavePassword(false);
        localWebSettings.setSaveFormData(false);
        localWebSettings.setBuiltInZoomControls(true);
        localWebSettings.setUseWideViewPort(true);
        localWebSettings.setLoadWithOverviewMode(true);
        localWebSettings.setPluginState(WebSettings.PluginState.ON);
        localObject2 = getPackageManager();
      }
      try
      {
        if (!((PackageManager)localObject2).hasSystemFeature("android.hardware.touchscreen.multitouch"))
        {
          bool = ((PackageManager)localObject2).hasSystemFeature("android.hardware.faketouch.multitouch.distinct");
          if (!bool) {}
        }
        else
        {
          i = 1;
          label381:
          if (i != 0) {
            break label767;
          }
          bool = true;
          label388:
          localWebSettings.setDisplayZoomControls(bool);
          localWebSettings.setPluginsEnabled(true);
          localWebSettings.setJavaScriptEnabled(true);
          localWebSettings.setAllowContentAccess(true);
          localWebSettings.setDatabaseEnabled(true);
          localWebSettings.setDomStorageEnabled(true);
          localWebSettings.setAppCacheEnabled(true);
          String str = MobileQQ.getMobileQQ().getQQProcessName();
          localObject3 = "";
          localObject2 = localObject3;
          if (str != null)
          {
            i = str.lastIndexOf(':');
            localObject2 = localObject3;
            if (i > -1) {
              localObject2 = "_" + str.substring(i + 1);
            }
          }
          localWebSettings.setDatabasePath(getApplicationContext().getDir("database" + (String)localObject2, 0).getPath());
          localWebSettings.setAppCachePath(getApplicationContext().getDir("appcache" + (String)localObject2, 0).getPath());
          localWebSettings.setMediaPlaybackRequiresUserGesture(false);
          if (Build.VERSION.SDK_INT >= 11) {
            ((TouchWebView)localObject1).removeJavascriptInterface("searchBoxJavaBridge_");
          }
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        try
        {
          int i;
          ((TouchWebView)localObject1).requestFocus();
          label600:
          ((TouchWebView)localObject1).setFocusableInTouchMode(true);
          ((TouchWebView)localObject1).setDownloadListener(new AbsBaseWebViewActivity.4(this, (TouchWebView)localObject1));
          CookieSyncManager.createInstance(getApplicationContext());
          if (((TouchWebView)localObject1).getX5WebViewExtension() != null)
          {
            this.mX5CoreActive = true;
            ((TouchWebView)localObject1).getX5WebViewExtension().setWebViewClientExtension(new AbsBaseWebViewActivity.DownloadQQBrowserExtension(this, (TouchWebView)localObject1));
            AIOOpenWebMonitor.b(getIntent(), "use_x5", "1");
          }
          for (;;)
          {
            ((TouchWebView)localObject1).getView().setOnTouchListener(this);
            if (this.mNightMode) {
              ((TouchWebView)localObject1).setMask(true);
            }
            Util.b("Web_AdjustSettings");
            if (paramViewGroup != null) {
              paramViewGroup.addView((View)localObject1);
            }
            return localObject1;
            localObject1 = new TouchWebView(this);
            break;
            bool = false;
            break label63;
            label734:
            this.mWebViewClient = new AbsBaseWebViewActivity.3(this);
            break label234;
            label749:
            bool = false;
            break label290;
            i = 0;
            break label381;
            localRuntimeException = localRuntimeException;
            i = 0;
            break label381;
            label767:
            bool = false;
            break label388;
            AIOOpenWebMonitor.b(getIntent(), "use_x5", "2");
          }
        }
        catch (Exception localException)
        {
          break label600;
        }
      }
    }
  }
  
  protected boolean dispatchPluginEvent(long paramLong, Map<String, Object> paramMap)
  {
    if (this.mWebViewInstance != null)
    {
      this.mWebViewInstance.onResume();
      WebViewPluginEngine localWebViewPluginEngine = this.mWebViewInstance.getPluginEngine();
      if (localWebViewPluginEngine != null) {
        return localWebViewPluginEngine.a(this.mWebViewInstance.getUrl(), paramLong, paramMap);
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "onActivityResult, requestCode=" + paramInt1 + ", resultCode=" + paramInt2);
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("requestCode", Integer.valueOf(paramInt1));
    ((Map)localObject).put("resultCode", Integer.valueOf(paramInt2));
    ((Map)localObject).put("data", paramIntent);
    if (dispatchPluginEvent(8589934600L, (Map)localObject)) {}
    label478:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            int i = paramInt1 >> 8 & 0xFF;
            if (i <= 0) {
              break;
            }
            if (this.mWebViewInstance != null)
            {
              localObject = this.mWebViewInstance.getPluginEngine();
              if (localObject != null)
              {
                if ((paramIntent != null) && (paramIntent.hasExtra("entryId")) && (((WebViewPluginEngine)localObject).a("card") == null)) {
                  ((WebViewPluginEngine)localObject).a(new String[] { "card" });
                }
                localObject = ((WebViewPluginEngine)localObject).a(i, true);
                if (localObject != null)
                {
                  ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)(paramInt1 & 0xFF), paramInt2);
                  return;
                }
              }
            }
          } while (!QLog.isColorLevel());
          QLog.w("WebLog_WebViewBase", 2, "Caution! activity result not handled!");
          return;
          if ((this.mFileChooserHelper == null) || (!this.mFileChooserHelper.a(paramInt1, paramInt2, paramIntent))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("WebLog_WebViewBase", 2, "Activity result handled by FileChooserHelper.");
        return;
        if ((paramInt2 != -1) || (this.mWebViewInstance == null)) {
          break;
        }
        switch (paramInt1)
        {
        default: 
          return;
        }
      } while (paramIntent == null);
      localObject = paramIntent.getStringExtra("callbackSn");
      paramIntent = paramIntent.getStringExtra("result");
      this.mWebViewInstance.loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + (String)localObject + "',{'r':0,'result':" + paramIntent + "});");
      for (;;)
      {
        try
        {
          if (new JSONObject(paramIntent).getInt("resultCode") != 0) {
            break label478;
          }
          this.mPayActionSucc = bool;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("WebLog_WebViewBase", 2, "onActivityResult: mPayActionSucc=" + this.mPayActionSucc);
          return;
        }
        catch (Exception paramIntent) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("WebLog_WebViewBase", 2, "onActivityResult: mPayActionException=" + paramIntent.getMessage());
        return;
        bool = false;
      }
    } while (paramInt2 != 4660);
    setResult(4660);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
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
    setTheme(2131755154);
    this.authConfig = AuthorizeConfig.a();
    WebAccelerateHelper.isWebViewCache = true;
    QLog.d("WebLog_WebViewBase", 1, "doOnCreate, WebAccelerateHelper.isWebViewCache = true");
    paramBundle = this.mStatistics;
    this.isDestroyed = false;
    paramBundle.l = false;
    this.uin = this.mApp.getAccount();
    doWebSoRequest();
    initPluginEngineOnActivityCreated();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "onDestroy");
    }
    QQBrowserActivity.sQQBrowserActivityCounter -= 1;
    Object localObject = this.mStatistics;
    this.isDestroyed = true;
    ((SwiftBrowserStatistics)localObject).l = true;
    if (this.mChromeClient != null) {
      this.mChromeClient.a();
    }
    if (this.mWebViewInstance != null)
    {
      localObject = this.mWebViewInstance.getPluginEngine();
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
        for (;;)
        {
          this.mWebViewInstance.stopLoading();
          label113:
          this.mWebViewInstance.loadUrlOriginal("about:blank");
          this.mWebViewInstance.clearView();
          this.mWebViewInstance.destroy();
          this.mWebViewInstance = null;
          this.mApp = null;
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewBase", 2, "remove webview error");
          }
        }
      }
      catch (Exception localException2)
      {
        break label113;
      }
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
      dispatchPluginEvent(8589934607L, null);
      continue;
      dispatchPluginEvent(8589934608L, null);
      continue;
      dispatchPluginEvent(8589934609L, null);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    int i = -1;
    int j;
    Object localObject;
    if ("actionSelectPicture".equals(paramIntent.getStringExtra("keyAction")))
    {
      j = paramIntent.getIntExtra("requestCode", -1);
      int k = j >> 8 & 0xFF;
      if (k > 0) {
        if (this.mWebViewInstance != null)
        {
          localObject = this.mWebViewInstance.getPluginEngine();
          if (localObject != null)
          {
            localObject = ((WebViewPluginEngine)localObject).a(k, true);
            if (localObject != null) {
              if (!paramIntent.hasExtra("PhotoConst.PHOTO_PATHS")) {
                break label158;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)(j & 0xFF), i);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("WebLog_WebViewBase", 2, "Caution! activity result not handled!");
      }
      this.uin = this.mApp.getAccount();
      localObject = new HashMap();
      ((Map)localObject).put("intent", paramIntent);
      dispatchPluginEvent(128L, (Map)localObject);
      return;
      label158:
      i = 0;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "onPause");
    }
    if (this.mWebViewInstance != null) {
      this.mWebViewInstance.onPause();
    }
    if ((this.mChromeClient != null) && (this.isVideoPlaying)) {
      this.mChromeClient.onHideCustomView();
    }
    dispatchPluginEvent(8589934597L, null);
    String str = BridgeHelper.a(getActivity(), this.uin).a("buscard_registerNFC");
    if ((TextUtils.isEmpty(str)) || ("true".equals(str))) {
      ActivityLifecycle.onPause(getActivity());
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "onResume");
    }
    if (this.mWebViewInstance != null) {
      this.mWebViewInstance.onResume();
    }
    Object localObject = new Intent("tencent.notify.foreground");
    ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
    ((Intent)localObject).putExtra("selfuin", this.uin);
    ((Intent)localObject).putExtra("AccountInfoSync", "mobileqq.web");
    ((Intent)localObject).putExtra("classname", getClass().getName());
    sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    dispatchPluginEvent(2L, null);
    localObject = BridgeHelper.a(getActivity(), this.uin).a("buscard_registerNFC");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || ("true".equals(localObject))) {
      ActivityLifecycle.onResume(getActivity());
    }
  }
  
  public void doOnStop()
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
      overridePendingTransition(0, 2130771980);
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
  
  public View getIphoneTitleContentView()
  {
    return this.mContentView;
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  protected String getUAMark()
  {
    return null;
  }
  
  protected WebAIOController getWebAIOController()
  {
    return null;
  }
  
  public final TouchWebView getWebView(ViewGroup paramViewGroup)
  {
    if (this.mWebViewInstance != null) {
      return this.mWebViewInstance;
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
  
  public void init(Intent paramIntent)
  {
    super.init(paramIntent);
    if (this.vg != null) {
      this.vg.setOnTouchListener(new AbsBaseWebViewActivity.8(this));
    }
    removeWebViewLayerType();
    this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
    this.mSwiftTitleUI.b = this.centerView;
    this.mSwiftTitleUI.c = this.rightViewText;
    this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView = this.rightViewImg;
    this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup = this.vg;
  }
  
  public void initIphoneTitleBySwiftUI(Intent paramIntent)
  {
    init(paramIntent);
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
    }
    while (this.mPluginEngine != null) {
      return;
    }
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
  
  public boolean onBackEvent()
  {
    if ((this.mChromeClient != null) && (this.isVideoPlaying)) {
      this.mChromeClient.onHideCustomView();
    }
    WebViewPluginEngine localWebViewPluginEngine;
    do
    {
      do
      {
        return true;
        if (this.sonicClient != null)
        {
          this.sonicClient.clearHistory();
          this.sonicClient.destroy();
          this.sonicClient = null;
        }
        localObject = new HashMap(1);
        ((Map)localObject).put("target", Integer.valueOf(3));
      } while (dispatchPluginEvent(8589934601L, (Map)localObject));
      if (((this.mRulesFromUrl & 0x4) != 0L) || (this.mWebViewInstance == null) || (!this.mWebViewInstance.canGoBack())) {
        break;
      }
      this.mWebViewInstance.stopLoading();
      this.mWebViewInstance.goBack();
      localWebViewPluginEngine = this.mWebViewInstance.getPluginEngine();
    } while (localWebViewPluginEngine == null);
    localWebViewPluginEngine.a(this.mWebViewInstance.getUrl(), 8589934610L, (Map)localObject);
    return true;
    Object localObject = (InputMethodManager)getSystemService("input_method");
    if ((localObject != null) && (getCurrentFocus() != null)) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    if ((this.mChromeClient != null) && (this.isVideoPlaying))
    {
      this.mChromeClient.onHideCustomView();
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
  
  public void onCreate(Bundle paramBundle)
  {
    doWebSoRequest();
    SwiftWebAccelerator.a().a();
    String str = SwiftWebViewUtils.a(getIntent());
    WebAccelerateHelper.getInstance().preGetKey(str, getIntent(), this.mApp);
    WebAccelerateHelper.getInstance().preCheckOffline(str);
    WebAccelerateHelper.getInstance().preFetchResource(str);
    this.mUIStyleHandler.c();
    this.mSwiftTitleUI = this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI;
    boolean bool = WebAccelerateHelper.isWebViewCache;
    initSonicSession(str);
    ThreadManager.getFileThreadHandler().post(new AbsBaseWebViewActivity.6(this, bool));
    super.onCreate(paramBundle);
    QLog.i("WebLog_WebViewBase", 1, "onCreate cache:" + bool);
    this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    if (this.mApp != null)
    {
      if ((!bool) && (!VipWebViewReportLog.a())) {
        VipWebViewReportLog.a(this, this.mApp);
      }
      initPluginEngine();
    }
    paramBundle = Build.MANUFACTURER + "_" + Build.MODEL;
    if ((Build.VERSION.SDK_INT > 10) && (!HWForbiddenList.contains(paramBundle))) {
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
      int i = getResources().getColor(2131167091);
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
  
  protected void onWebViewClientImplPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public final int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i = switchRequestCode(paramWebViewPlugin, paramByte);
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewBase", 2, "pluginStartActivityForResult not handled");
      }
      return i;
    }
    startActivityForResult(paramIntent, i);
    return i;
  }
  
  public void resetTitleBarTextColor()
  {
    this.leftView.setTextColor(getResources().getColorStateList(2131167027));
    this.rightViewText.setTextColor(getResources().getColorStateList(2131167027));
    this.centerView.setTextColor(getResources().getColor(2131167030));
    if (this.rightViewImg != null)
    {
      Drawable localDrawable = this.rightViewImg.getDrawable();
      if (localDrawable != null)
      {
        localDrawable.clearColorFilter();
        localDrawable.invalidateSelf();
      }
      this.rightViewImg.setImageDrawable(localDrawable);
    }
    this.leftView.setBackgroundDrawable(this.mTitleLeftDrawable);
  }
  
  protected boolean rightButtonCallBack()
  {
    if (this.mWebViewInstance != null)
    {
      if ((this.mRightButtonListener != null) && (this.mRightButtonListener.a))
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
    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.a))
    {
      i = 1;
      if (!paramBoolean) {
        break label70;
      }
      this.mUIStyle.e = true;
      this.rightViewText.setVisibility(8);
      this.rightViewImg.setVisibility(8);
      if (this.mRightCornerIcon != null) {
        this.mRightCornerIcon.setVisibility(8);
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label70:
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
        if (paramString3 != null)
        {
          paramInt1 = 0;
          if (paramString3.length() <= 0) {}
        }
        try
        {
          paramInt1 = Color.parseColor(paramString3);
          this.rightViewImg.setBackgroundColor(paramInt1);
          if ((paramString1 != null) && (i == 0))
          {
            this.rightViewImg.setOnClickListener(this);
            this.rightViewText.setOnClickListener(this);
            this.mRightButtonCallback = paramString1.trim();
            if ((this.mUIStyle.a == null) || (!this.mUIStyle.a.has("txtclr"))) {
              continue;
            }
            paramString2 = this.mUIStyle.a.optString("txtclr", "");
            if (TextUtils.isEmpty(paramString2)) {
              continue;
            }
            paramString1 = paramString2;
            if (!paramString2.startsWith("#")) {
              paramString1 = "#" + paramString2;
            }
            try
            {
              paramInt1 = Color.parseColor(paramString1);
              paramString1 = ImageUtil.a(this.rightViewImg.getDrawable(), paramInt1);
              if (paramString1 != null) {
                this.rightViewImg.setImageDrawable(paramString1);
              }
              this.rightViewText.setTextColor(paramInt1);
              return;
            }
            catch (Exception paramString1)
            {
              QLog.e("WebLog_WebViewBase", 1, paramString1, new Object[0]);
              return;
            }
          }
        }
        catch (Exception paramString2)
        {
          for (;;)
          {
            paramInt1 = 0;
            continue;
            this.mRightButtonListener = paramJsBridgeListener;
            this.mRightButtonCallback = null;
          }
        }
      }
    }
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(0);
    paramString3 = this.mUIStyle;
    if (paramInt1 != 4)
    {
      paramBoolean = true;
      label380:
      paramString3.e = paramBoolean;
      switch (paramInt1)
      {
      case 6: 
      default: 
        this.rightViewImg.setVisibility(8);
        label457:
        if (paramInt2 != 0)
        {
          if (this.mRightCornerIcon == null)
          {
            this.mRightCornerIcon = new ImageView(this);
            paramString3 = (RelativeLayout)findViewById(2131377301);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(7, 2131369501);
            localLayoutParams.addRule(6, 2131369501);
            localLayoutParams.setMargins(0, 0, 0, 0);
            this.mRightCornerIcon.setLayoutParams(localLayoutParams);
            paramString3.addView(this.mRightCornerIcon);
          }
          this.mRightCornerIcon.setVisibility(0);
          switch (paramInt2)
          {
          default: 
            this.mRightCornerIcon.setVisibility(8);
            label589:
            if (!TextUtils.isEmpty(paramString2)) {
              this.rightViewImg.setContentDescription(paramString2);
            }
            if (paramOnClickListener != null) {
              this.rightViewImg.setOnClickListener(paramOnClickListener);
            }
            break;
          }
        }
        break;
      }
    }
    for (;;)
    {
      this.isRecordTitleLeftDrawable = false;
      this.isRecordTitleRightDrawable = false;
      break;
      paramBoolean = false;
      break label380;
      this.mUIStyleHandler.a(this.rightViewImg, false, 2130844104, 2130844104);
      this.rightViewImg.setContentDescription(getResources().getString(2131692674));
      break label457;
      this.mUIStyleHandler.a(this.rightViewImg, false, 2130844103, 2130844103);
      this.rightViewImg.setContentDescription(getResources().getString(2131692673));
      break label457;
      this.mUIStyleHandler.a(this.rightViewImg, false, 2130840482, 2130840478);
      this.rightViewImg.setContentDescription(getResources().getString(2131692676));
      break label457;
      this.mUIStyleHandler.a(this.rightViewImg, false, 2130839512, 2130839504);
      this.rightViewImg.setContentDescription(getResources().getString(2131692678));
      break label457;
      this.rightViewImg.setImageResource(2130844149);
      this.rightViewImg.setContentDescription(getResources().getString(2131692679));
      ((AnimationDrawable)this.rightViewImg.getDrawable()).start();
      break label457;
      this.mUIStyleHandler.a(this.rightViewImg, false, 2130842713, 2130842716);
      this.rightViewImg.setContentDescription(getResources().getString(2131689557));
      break label457;
      this.mUIStyleHandler.a(this.rightViewImg, false, 2130850543, 2130850547);
      this.rightViewImg.setContentDescription(getResources().getString(2131689557));
      break label457;
      this.mUIStyleHandler.a(this.rightViewImg, false, 2130839030, 2130839030);
      this.rightViewImg.setContentDescription(getResources().getString(2131692677));
      break label457;
      this.mUIStyleHandler.a(this.rightViewImg, false, 2130850737, 2130850737);
      this.rightViewImg.setContentDescription(getResources().getString(2131692677));
      break label457;
      this.mRightCornerIcon.setImageResource(2130843924);
      break label589;
      if (this.mRightCornerIcon == null) {
        break label589;
      }
      this.mRightCornerIcon.setVisibility(8);
      break label589;
      if ((paramString1 != null) && (i == 0))
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
    }
  }
  
  public void setRightButton(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mUIStyle.e = true;
      if (this.rightViewText != null) {
        this.rightViewText.setVisibility(8);
      }
      if (this.rightViewImg != null) {
        this.rightViewImg.setVisibility(8);
      }
      if (this.mRightCornerIcon != null) {
        this.mRightCornerIcon.setVisibility(8);
      }
    }
    do
    {
      return;
      if ((this.rightViewText != null) && (!TextUtils.isEmpty(this.rightViewText.getText()))) {
        this.rightViewText.setVisibility(0);
      }
      if (this.rightViewImg != null) {
        this.rightViewImg.setVisibility(0);
      }
    } while (this.mRightCornerIcon == null);
    this.mRightCornerIcon.setVisibility(0);
  }
  
  public void setTitleBarButtonColor(int paramInt)
  {
    this.leftView.setTextColor(paramInt);
    this.rightViewText.setTextColor(paramInt);
    Drawable localDrawable2 = this.leftView.getBackground();
    Drawable localDrawable1 = this.rightViewImg.getDrawable();
    if (localDrawable2 != null)
    {
      if (!this.isRecordTitleLeftDrawable)
      {
        this.mTitleLeftDrawable = localDrawable2;
        this.isRecordTitleLeftDrawable = true;
      }
      localDrawable2 = ImageUtil.a(localDrawable2, paramInt);
      if (localDrawable2 != null) {
        this.leftView.setBackgroundDrawable(localDrawable2);
      }
    }
    if (localDrawable1 != null)
    {
      if (!this.isRecordTitleRightDrawable) {
        this.isRecordTitleRightDrawable = true;
      }
      localDrawable1 = ImageUtil.a(localDrawable1, paramInt);
      if (localDrawable1 != null) {
        this.rightViewImg.setImageDrawable(localDrawable1);
      }
    }
  }
  
  public void setTitleBarTextColor(int paramInt)
  {
    this.centerView.setTextColor(paramInt);
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
    setContentViewNoTitle(2131558826);
    ((TextView)findViewById(2131371913)).setText(2131692193);
    return true;
  }
  
  public final int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    return switchRequestCodeImpl(paramWebViewPlugin, paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewbase.AbsBaseWebViewActivity
 * JD-Core Version:    0.7.0.1
 */