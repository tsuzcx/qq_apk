package com.tencent.biz.webviewbase;

import actd;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
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
import bcbv;
import bcdb;
import bcdc;
import bcdq;
import bcdv;
import bcdw;
import bces;
import bcfa;
import bcfj;
import bcfm;
import bcfz;
import bcgc;
import bche;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.BuscardJsPlugin;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import cooperation.buscard.BuscardHelper;
import cooperation.pluginbridge.BridgeHelper;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mvv;
import nae;
import nap;
import nax;
import nke;
import org.json.JSONObject;
import xjo;
import xjp;
import xjq;
import xjr;
import xjs;
import xjt;
import zzs;

public abstract class AbsBaseWebViewActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnTouchListener, bcdc, bcdv, bcdw
{
  public static final HashSet<String> a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public bcbv a;
  public final bcdq a;
  protected final bces a;
  public final bcfa a;
  public final bcfj a;
  public final bcfm a;
  public TouchWebView a;
  public volatile AppInterface a;
  public SonicClientImpl a;
  protected JsBridgeListener a;
  protected volatile WebViewPluginEngine a;
  private WebViewClient jdField_a_of_type_ComTencentSmttSdkWebViewClient;
  protected final Object a;
  public mvv a;
  public nae a;
  public nke a;
  private boolean jdField_a_of_type_Boolean;
  public long b;
  public final Handler b;
  public FrameLayout b;
  protected boolean b;
  public long c;
  public boolean c;
  public long d;
  public String d;
  protected volatile boolean d;
  public long e;
  protected String e;
  public boolean e;
  public String f;
  protected boolean f;
  private boolean g;
  private boolean h;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_JavaUtilHashSet.add("Meizu_M040");
    jdField_a_of_type_JavaUtilHashSet.add("YuLong_Coolpad8720Q");
    jdField_a_of_type_JavaUtilHashSet.add("YuLong_Coolpad 7269");
    jdField_a_of_type_JavaUtilHashSet.add("samsung_SM-G9006W");
  }
  
  public AbsBaseWebViewActivity()
  {
    this.jdField_b_of_type_Long = 4L;
    this.jdField_c_of_type_Long = 5L;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Bcdq = a();
    this.jdField_a_of_type_Bcfj = ((bcfj)this.jdField_a_of_type_Bcdq.a(2));
    this.jdField_a_of_type_Bcfm = this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcfm;
    this.jdField_a_of_type_Bces = ((bces)this.jdField_a_of_type_Bcdq.a(-1));
    this.jdField_a_of_type_Bcfa = ((bcfa)this.jdField_a_of_type_Bcdq.a(-2));
  }
  
  public static int a(WebViewPlugin paramWebViewPlugin, byte paramByte)
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
      i = WebViewPluginEngine.a(paramWebViewPlugin);
      if (i != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebLog_WebViewBase", 2, "switchRequestCode failed: webview index=" + 0 + ", pluginIndex=" + i);
    return -1;
    return i << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
  
  private void a(String paramString)
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
        this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = new SonicClientImpl((SonicSession)localObject);
        ((SonicSession)localObject).bindClient(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
      }
    }
    else
    {
      return;
    }
    QLog.d("WebLog_WebViewBase", 1, "initSonicSession sonicSession = null, url = " + paramString);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine == null) && (WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
      WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = null;
      WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this);
      return;
    }
    ThreadManager.postImmediately(new AbsBaseWebViewActivity.5(this), null, false);
  }
  
  private void c()
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      String str = getIntent().getStringExtra("url");
      if (bche.b(str)) {
        ThreadManager.postImmediately(new AbsBaseWebViewActivity.7(this, str), null, false);
      }
    }
  }
  
  public Activity a()
  {
    return this;
  }
  
  public bcdq a()
  {
    return new bcdq(this, 127, null);
  }
  
  public final TouchWebView a(ViewGroup paramViewGroup)
  {
    nax.a("Web_qqbrowser_init_only_webview");
    Object localObject2 = getIntent();
    long l = System.currentTimeMillis();
    Object localObject1;
    if (0L != (this.jdField_d_of_type_Long & 0x40)) {
      localObject1 = SwiftReuseTouchWebView.a(this);
    }
    for (;;)
    {
      Object localObject3;
      boolean bool;
      label64:
      label236:
      WebSettings localWebSettings;
      if ((localObject1 instanceof SwiftReuseTouchWebView))
      {
        localObject3 = this.jdField_a_of_type_Bcfa;
        if (1 == ((SwiftReuseTouchWebView)localObject1).a)
        {
          bool = true;
          ((bcfa)localObject3).u = bool;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("webviewinit", 2, "TouchWebView cost = " + (System.currentTimeMillis() - l));
        }
        ((TouchWebView)localObject1).setIntent((Intent)localObject2);
        nax.b("Web_qqbrowser_init_only_webview");
        if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) && (QLog.isColorLevel())) {
          QLog.w("WebLog_WebViewBase", 2, "Caution! AppRuntime is null!");
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a((CustomWebView)localObject1);
        ((TouchWebView)localObject1).setPluginEngine(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine);
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.bindWebView((CustomWebView)localObject1);
        }
        System.currentTimeMillis();
        if (this.jdField_a_of_type_Nke == null) {
          this.jdField_a_of_type_Nke = new xjo(this);
        }
        ((TouchWebView)localObject1).setWebChromeClient(this.jdField_a_of_type_Nke);
        if (this.jdField_a_of_type_ComTencentSmttSdkWebViewClient == null)
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label740;
          }
          this.jdField_a_of_type_ComTencentSmttSdkWebViewClient = new xjp(this);
        }
        ((TouchWebView)localObject1).setWebViewClient(this.jdField_a_of_type_ComTencentSmttSdkWebViewClient);
        ((TouchWebView)localObject1).setScrollBarStyle(0);
        nax.a("Web_AdjustSettings");
        localWebSettings = ((TouchWebView)localObject1).getSettings();
        nax.a("Web_SetUserAgent");
        localObject2 = localWebSettings.getUserAgentString();
        localObject3 = a();
        if (((TouchWebView)localObject1).getX5WebViewExtension() == null) {
          break label755;
        }
        bool = true;
        label294:
        localWebSettings.setUserAgentString(bcgc.a((String)localObject2, (String)localObject3, bool));
        nax.b("Web_SetUserAgent");
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
          label386:
          if (i != 0) {
            break label773;
          }
          bool = true;
          label393:
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
          label605:
          ((TouchWebView)localObject1).setFocusableInTouchMode(true);
          ((TouchWebView)localObject1).setDownloadListener(new xjr(this, (TouchWebView)localObject1));
          CookieSyncManager.createInstance(getApplicationContext());
          if (((TouchWebView)localObject1).getX5WebViewExtension() != null)
          {
            this.h = true;
            ((TouchWebView)localObject1).getX5WebViewExtension().setWebViewClientExtension(new xjt(this, (TouchWebView)localObject1));
            actd.b(getIntent(), "use_x5", "1");
          }
          for (;;)
          {
            ((TouchWebView)localObject1).getView().setOnTouchListener(this);
            if (this.jdField_f_of_type_Boolean) {
              ((TouchWebView)localObject1).setMask(true);
            }
            nax.b("Web_AdjustSettings");
            if (paramViewGroup != null) {
              paramViewGroup.addView((View)localObject1);
            }
            return localObject1;
            localObject1 = new TouchWebView(this);
            break;
            bool = false;
            break label64;
            label740:
            this.jdField_a_of_type_ComTencentSmttSdkWebViewClient = new xjq(this);
            break label236;
            label755:
            bool = false;
            break label294;
            i = 0;
            break label386;
            localRuntimeException = localRuntimeException;
            i = 0;
            break label386;
            label773:
            bool = false;
            break label393;
            actd.b(getIntent(), "use_x5", "2");
          }
        }
        catch (Exception localException)
        {
          break label605;
        }
      }
    }
  }
  
  public WebViewFragment a()
  {
    return null;
  }
  
  public WebView a()
  {
    throw new UnsupportedOperationException("must override this method getHostWebView()!");
  }
  
  protected String a()
  {
    return null;
  }
  
  public final void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine == null) && (WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbsBaseWebViewActivity", 2, "-->web engine and plugin initialized at process preload!");
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
      WebViewPluginEngine.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = null;
      WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a();
    }
    while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, null, null);
        WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this);
      }
      return;
    }
  }
  
  public void a(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i = switchRequestCode(paramWebViewPlugin, paramByte);
    paramIntent.putExtra("keyAction", "actionSelectPicture");
    paramIntent.putExtra("requestCode", i);
    startActivity(paramIntent);
  }
  
  public void a(WebView paramWebView, int paramInt) {}
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void a(WebView paramWebView, String paramString) {}
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener)
  {
    int i;
    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.jdField_a_of_type_Boolean))
    {
      i = 1;
      if (!paramBoolean) {
        break label70;
      }
      this.jdField_a_of_type_Bcfm.jdField_e_of_type_Boolean = true;
      this.rightViewText.setVisibility(8);
      this.rightViewImg.setVisibility(8);
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
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
            this.jdField_e_of_type_JavaLangString = paramString1.trim();
            if ((this.jdField_a_of_type_Bcfm.a == null) || (!this.jdField_a_of_type_Bcfm.a.has("txtclr"))) {
              continue;
            }
            paramString2 = this.jdField_a_of_type_Bcfm.a.optString("txtclr", "");
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
              paramString1 = nap.a(this.rightViewImg.getDrawable(), paramInt1);
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
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
            this.jdField_e_of_type_JavaLangString = null;
          }
        }
      }
    }
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(0);
    paramString3 = this.jdField_a_of_type_Bcfm;
    if (paramInt1 != 4)
    {
      paramBoolean = true;
      label380:
      paramString3.jdField_e_of_type_Boolean = paramBoolean;
      switch (paramInt1)
      {
      case 6: 
      default: 
        this.rightViewImg.setVisibility(8);
        label457:
        if (paramInt2 != 0)
        {
          if (this.jdField_a_of_type_AndroidWidgetImageView == null)
          {
            this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this);
            paramString3 = (RelativeLayout)findViewById(2131375449);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(7, 2131368441);
            localLayoutParams.addRule(6, 2131368441);
            localLayoutParams.setMargins(0, 0, 0, 0);
            this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
            paramString3.addView(this.jdField_a_of_type_AndroidWidgetImageView);
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          switch (paramInt2)
          {
          default: 
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
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
      this.jdField_a_of_type_Boolean = false;
      this.g = false;
      break;
      paramBoolean = false;
      break label380;
      this.jdField_a_of_type_Bcfj.a(this.rightViewImg, false, 2130843254, 2130843254);
      this.rightViewImg.setContentDescription(getResources().getString(2131692738));
      break label457;
      this.jdField_a_of_type_Bcfj.a(this.rightViewImg, false, 2130843253, 2130843253);
      this.rightViewImg.setContentDescription(getResources().getString(2131692737));
      break label457;
      this.jdField_a_of_type_Bcfj.a(this.rightViewImg, false, 2130839757, 2130839753);
      this.rightViewImg.setContentDescription(getResources().getString(2131692739));
      break label457;
      this.jdField_a_of_type_Bcfj.a(this.rightViewImg, false, 2130839111, 2130839103);
      this.rightViewImg.setContentDescription(getResources().getString(2131692741));
      break label457;
      this.rightViewImg.setImageResource(2130843299);
      this.rightViewImg.setContentDescription(getResources().getString(2131692743));
      ((AnimationDrawable)this.rightViewImg.getDrawable()).start();
      break label457;
      this.jdField_a_of_type_Bcfj.a(this.rightViewImg, false, 2130842002, 2130842005);
      this.rightViewImg.setContentDescription(getResources().getString(2131689628));
      break label457;
      this.jdField_a_of_type_Bcfj.a(this.rightViewImg, false, 2130849062, 2130849066);
      this.rightViewImg.setContentDescription(getResources().getString(2131689628));
      break label457;
      this.jdField_a_of_type_Bcfj.a(this.rightViewImg, false, 2130838579, 2130838579);
      this.rightViewImg.setContentDescription(getResources().getString(2131692740));
      break label457;
      this.jdField_a_of_type_Bcfj.a(this.rightViewImg, false, 2130849201, 2130849201);
      this.rightViewImg.setContentDescription(getResources().getString(2131692740));
      break label457;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843076);
      break label589;
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        break label589;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label589;
      if ((paramString1 != null) && (i == 0))
      {
        this.rightViewImg.setOnClickListener(this);
        this.rightViewText.setOnClickListener(this);
        this.jdField_e_of_type_JavaLangString = paramString1.trim();
      }
      else
      {
        this.jdField_e_of_type_JavaLangString = null;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
      }
    }
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.callJs4OpenApi(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener, 0, new String[] { "" });
        return true;
      }
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.callJs(this.jdField_e_of_type_JavaLangString, new String[] { "" });
        return true;
      }
    }
    return false;
  }
  
  public boolean a(long paramLong, Map<String, Object> paramMap)
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onResume();
      WebViewPluginEngine localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
      if (localWebViewPluginEngine != null) {
        return localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), paramLong, paramMap);
      }
    }
    return false;
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    return false;
  }
  
  public bcdq b()
  {
    return this.jdField_a_of_type_Bcdq;
  }
  
  public final TouchWebView b(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    }
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = a(paramViewGroup);
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  public void b(WebView paramWebView, String paramString) {}
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
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
    if (a(8589934600L, (Map)localObject)) {}
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
            if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
            {
              localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
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
          if ((this.jdField_a_of_type_Nae == null) || (!this.jdField_a_of_type_Nae.a(paramInt1, paramInt2, paramIntent))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("WebLog_WebViewBase", 2, "Activity result handled by FileChooserHelper.");
        return;
        if ((paramInt2 != -1) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
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
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + (String)localObject + "',{'r':0,'result':" + paramIntent + "});");
      for (;;)
      {
        try
        {
          if (new JSONObject(paramIntent).getInt("resultCode") != 0) {
            break label478;
          }
          this.jdField_b_of_type_Boolean = bool;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("WebLog_WebViewBase", 2, "onActivityResult: mPayActionSucc=" + this.jdField_b_of_type_Boolean);
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
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)paramBundle);
    }
    if (!VipWebViewReportLog.a()) {
      VipWebViewReportLog.a(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    QQBrowserActivity.c += 1;
    this.jdField_f_of_type_Boolean = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    setTheme(2131755146);
    this.jdField_a_of_type_Mvv = mvv.a();
    WebAccelerateHelper.isWebViewCache = true;
    QLog.d("WebLog_WebViewBase", 1, "doOnCreate, WebAccelerateHelper.isWebViewCache = true");
    paramBundle = this.jdField_a_of_type_Bcfa;
    this.jdField_c_of_type_Boolean = false;
    paramBundle.l = false;
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    c();
    a();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "onDestroy");
    }
    QQBrowserActivity.c -= 1;
    Object localObject = this.jdField_a_of_type_Bcfa;
    this.jdField_c_of_type_Boolean = true;
    ((bcfa)localObject).l = true;
    if (this.jdField_a_of_type_Nke != null) {
      this.jdField_a_of_type_Nke.a();
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).b();
      }
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
          label113:
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrlOriginal("about:blank");
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.clearView();
          this.jdField_a_of_type_ComTencentBizUiTouchWebView.destroy();
          this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
          this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
          zzs.a(this);
          zzs.c(this);
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
      a(8589934607L, null);
      continue;
      a(8589934608L, null);
      continue;
      a(8589934609L, null);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    int i = -1;
    int j = 0;
    int k;
    Object localObject;
    if ("actionSelectPicture".equals(paramIntent.getStringExtra("keyAction")))
    {
      k = paramIntent.getIntExtra("requestCode", -1);
      int m = k >> 8 & 0xFF;
      if (m > 0) {
        if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
        {
          localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
          if (localObject != null)
          {
            localObject = ((WebViewPluginEngine)localObject).a(m, true);
            if (localObject != null) {
              if (!paramIntent.hasExtra("PhotoConst.PHOTO_PATHS")) {
                break label257;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)(k & 0xFF), i);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("WebLog_WebViewBase", 2, "Caution! activity result not handled!");
      }
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      if ("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction()))
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
        {
          localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
          i = j;
          if (localObject != null)
          {
            localObject = ((WebViewPluginEngine)localObject).a(120, true);
            i = j;
            if (localObject != null)
            {
              i = j;
              if ((localObject instanceof BuscardJsPlugin))
              {
                ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)120, 0);
                i = 1;
              }
            }
          }
        }
        if (i == 0) {
          BuscardHelper.a(this.jdField_f_of_type_JavaLangString, getActivity(), paramIntent);
        }
      }
      localObject = new HashMap();
      ((Map)localObject).put("intent", paramIntent);
      a(128L, (Map)localObject);
      return;
      label257:
      i = 0;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "onPause");
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onPause();
    }
    if ((this.jdField_a_of_type_Nke != null) && (this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_Nke.onHideCustomView();
    }
    a(8589934597L, null);
    String str = BridgeHelper.a(getActivity(), this.jdField_f_of_type_JavaLangString).a("buscard_registerNFC");
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
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onResume();
    }
    Object localObject = new Intent("tencent.notify.foreground");
    ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
    ((Intent)localObject).putExtra("selfuin", this.jdField_f_of_type_JavaLangString);
    ((Intent)localObject).putExtra("AccountInfoSync", "mobileqq.web");
    ((Intent)localObject).putExtra("classname", getClass().getName());
    sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    a(2L, null);
    localObject = BridgeHelper.a(getActivity(), this.jdField_f_of_type_JavaLangString).a("buscard_registerNFC");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || ("true".equals(localObject))) {
      ActivityLifecycle.onResume(getActivity());
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if ((this.jdField_b_of_type_Long & 0x2000000) != 0L)
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
      overridePendingTransition(0, 2130771978);
    }
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  public void init(Intent paramIntent)
  {
    super.init(paramIntent);
    if (this.vg != null) {
      this.vg.setOnTouchListener(new xjs(this));
    }
    removeWebViewLayerType();
    this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetTextView = this.leftView;
    this.jdField_a_of_type_Bcbv.b = this.centerView;
    this.jdField_a_of_type_Bcbv.c = this.rightViewText;
    this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView = this.rightViewImg;
    this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup = this.vg;
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Nke != null) && (this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_Nke.onHideCustomView();
    }
    WebViewPluginEngine localWebViewPluginEngine;
    do
    {
      do
      {
        return true;
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.clearHistory();
          this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.destroy();
          this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = null;
        }
        localObject = new HashMap(1);
        ((Map)localObject).put("target", Integer.valueOf(3));
      } while (a(8589934601L, (Map)localObject));
      if (((this.jdField_b_of_type_Long & 0x4) != 0L) || (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) || (!this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack())) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.stopLoading();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.goBack();
      localWebViewPluginEngine = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
    } while (localWebViewPluginEngine == null);
    localWebViewPluginEngine.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 8589934610L, (Map)localObject);
    return true;
    Object localObject = (InputMethodManager)getSystemService("input_method");
    if ((localObject != null) && (getCurrentFocus() != null)) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    if ((this.jdField_a_of_type_Nke != null) && (this.jdField_e_of_type_Boolean))
    {
      this.jdField_a_of_type_Nke.onHideCustomView();
      return true;
    }
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.rightViewImg) || (paramView == this.rightHighLView) || (paramView == this.rightViewText)) {
      a();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    c();
    bcfz.a().a();
    String str = bcgc.a(getIntent());
    WebAccelerateHelper.getInstance().preGetKey(str, getIntent(), this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    WebAccelerateHelper.getInstance().preCheckOffline(str);
    WebAccelerateHelper.getInstance().preFetchResource(str);
    this.jdField_a_of_type_Bcfj.c();
    this.jdField_a_of_type_Bcbv = this.jdField_a_of_type_Bcfj.jdField_a_of_type_Bcbv;
    boolean bool = WebAccelerateHelper.isWebViewCache;
    a(str);
    ThreadManager.getFileThreadHandler().post(new AbsBaseWebViewActivity.6(this, bool));
    super.onCreate(paramBundle);
    QLog.i("WebLog_WebViewBase", 1, "onCreate cache:" + bool);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      if ((!bool) && (!VipWebViewReportLog.a())) {
        VipWebViewReportLog.a(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      b();
    }
    paramBundle = Build.MANUFACTURER + "_" + Build.MODEL;
    if ((Build.VERSION.SDK_INT > 10) && (!jdField_a_of_type_JavaUtilHashSet.contains(paramBundle))) {
      getWindow().addFlags(16777216);
    }
    getWindow().setFormat(-3);
  }
  
  public void onPostThemeChanged()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      this.jdField_f_of_type_Boolean = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      a(8589934604L, null);
    }
    if ((this.mSystemBarComp != null) && (!this.jdField_a_of_type_Bcfm.i))
    {
      int i = getResources().getColor(2131166910);
      this.mSystemBarComp.setStatusColor(i);
      this.mSystemBarComp.setStatusBarColor(i);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
    }
    return false;
  }
  
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
  
  public boolean showPreview()
  {
    setImmersiveStatus();
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.init();
    }
    overridePendingTransition(0, 0);
    setContentViewNoTitle(2131558654);
    ((TextView)findViewById(2131370458)).setText(2131692240);
    return true;
  }
  
  public final int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    return a(paramWebViewPlugin, paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.webviewbase.AbsBaseWebViewActivity
 * JD-Core Version:    0.7.0.1
 */