package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.SetCookiesCallback;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils.ProxyConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.sonic.sdk.SonicSession;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kvw;
import kvx;
import kvy;
import kvz;
import kwa;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomWebView
  extends SuperWebView
{
  protected static SparseArray a;
  public static String b;
  static String c;
  protected CustomWebView.OpenApiTokenInfo a;
  CustomWebView.ScrollInterface jdField_a_of_type_ComTencentBizPubaccountCustomWebView$ScrollInterface;
  protected SonicClientImpl a;
  protected WebViewPluginEngine a;
  SwiftBrowserCookieMonster.SetCookiesCallback jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback = null;
  String jdField_a_of_type_JavaLangString = "";
  public boolean a;
  public boolean b;
  protected boolean c;
  protected boolean d = true;
  boolean e = true;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(8);
    jdField_a_of_type_AndroidUtilSparseArray.put(0, "recode_successed");
    jdField_a_of_type_AndroidUtilSparseArray.put(1, "recode_failed_permission_denied");
    jdField_a_of_type_AndroidUtilSparseArray.put(2, "recode_failed_token_verify_time_out");
    jdField_a_of_type_AndroidUtilSparseArray.put(3, "recode_failed_no_such_method");
    jdField_a_of_type_AndroidUtilSparseArray.put(4, "recode_failed_params_error");
    jdField_a_of_type_AndroidUtilSparseArray.put(5, "recode_failed_frequency_limit");
  }
  
  public CustomWebView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public CustomWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public CustomWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  private Intent a()
  {
    if (this.jdField_a_of_type_AndroidContentIntent != null) {
      return this.jdField_a_of_type_AndroidContentIntent;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a.getIntent();
    }
    return null;
  }
  
  private boolean a()
  {
    if (this.e)
    {
      Intent localIntent = a();
      if ((localIntent != null) && (localIntent.getBooleanExtra("ignoreLoginWeb", false)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CustomWebView", 2, "ignore login state, set key cookie abort.");
        }
        this.e = false;
      }
    }
    return this.e;
  }
  
  private boolean a(kwa paramkwa)
  {
    if (!this.e) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = SwiftWebViewUtils.a(paramkwa.jdField_a_of_type_JavaLangString);
      } while ((!"http".equals(localObject)) && (!"https".equals(localObject)));
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback = new kvw(this, paramkwa);
      localObject = SwiftBrowserCookieMonster.a(paramkwa.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    this.e = false;
    Intent localIntent = a();
    if ((localIntent != null) && (localIntent.getBooleanExtra("avoidLoginWeb", false)))
    {
      ((SwiftBrowserCookieMonster)localObject).f();
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramkwa.jdField_a_of_type_JavaLangString;
    ((SwiftBrowserCookieMonster)localObject).a(paramkwa.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback, null, localIntent);
    return true;
  }
  
  public static void b(String paramString)
  {
    if ((paramString == null) || (paramString.equals(jdField_b_of_type_JavaLangString))) {
      return;
    }
    long l = System.currentTimeMillis();
    jdField_b_of_type_JavaLangString = paramString;
    String str = paramString;
    if (paramString.length() > 512) {
      str = paramString.substring(0, 512);
    }
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    paramString = str;
    if (arrayOfStackTraceElement.length > 2) {
      paramString = str + " at " + arrayOfStackTraceElement[2].toString();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("webviewLoad", 4, "cost:" + (System.currentTimeMillis() - l) + " " + paramString);
    }
    StatisticCollector.a(null).a("webviewLoad", paramString);
  }
  
  public CustomWebView.OpenApiTokenInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo;
  }
  
  public SonicClientImpl a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl;
  }
  
  public WebViewPluginEngine a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      SwiftBrowserCookieMonster localSwiftBrowserCookieMonster = SwiftBrowserCookieMonster.a(this.jdField_a_of_type_JavaLangString);
      if (localSwiftBrowserCookieMonster != null) {
        localSwiftBrowserCookieMonster.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback = null;
      this.jdField_a_of_type_JavaLangString = "";
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.d = true;
    this.e = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.a();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo = null;
    }
    setIntent(null);
    setWebChromeClient(null);
    setWebViewClient(null);
    setDownloadListener(null);
    setOnLongClickListener(null);
    if (getX5WebViewExtension() != null) {
      getX5WebViewExtension().setWebViewClientExtension(null);
    }
    getView().setOnTouchListener(null);
    setMask(false);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = null;
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo = new CustomWebView.OpenApiTokenInfo();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_b_of_type_JavaLangString = (paramInt1 + "_" + paramString1 + "_" + paramString2);
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTime() + paramInt3);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      paramString1 = paramArrayList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_JavaUtilHashMap.put(paramString2, Long.valueOf(0L));
      }
    }
  }
  
  public void a(JsBridgeListener paramJsBridgeListener, int paramInt, String... paramVarArgs)
  {
    if ((paramJsBridgeListener == null) || (paramJsBridgeListener.jdField_a_of_type_Long == -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.w("CustomWebView", 2, "callJs4OpenApi, listener == null || listener.sn == -1");
      }
      return;
    }
    for (Object localObject = (String)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);; localObject = "")
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("code", paramInt);
        if (localObject == null) {
          continue;
        }
        localJSONObject.put("msg", localObject);
        localObject = new StringBuilder();
        int i;
        if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!"".equals(paramVarArgs[0])))
        {
          ((StringBuilder)localObject).append(paramVarArgs[0]);
          paramInt = 1;
          i = paramVarArgs.length;
        }
        while (paramInt < i)
        {
          ((StringBuilder)localObject).append(',').append(paramVarArgs[paramInt]);
          paramInt += 1;
          continue;
          ((StringBuilder)localObject).append("{}");
        }
        localJSONObject.put("data", ((StringBuilder)localObject).toString());
        paramVarArgs = localJSONObject.toString();
        if (QLog.isColorLevel()) {
          QLog.d("CustomWebView.troop.openapi", 2, "callJs4OpenApi,listener.sn" + paramJsBridgeListener.jdField_a_of_type_Long + " | result:" + paramVarArgs);
        }
        c("(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);".replace("((0))", Util.a(paramJsBridgeListener.jdField_a_of_type_Long + "")).replace("((1))", paramVarArgs));
        return;
      }
      catch (JSONException paramJsBridgeListener) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("CustomWebView.troop.openapi", 2, "callJs4OpenApi, JSONException");
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_Boolean) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if ("about:blank".equals(paramString))
        {
          super.loadUrl(paramString);
          return;
        }
        if (!a()) {
          break;
        }
        localObject = new kwa(this);
        ((kwa)localObject).jdField_a_of_type_Int = 2;
        ((kwa)localObject).jdField_a_of_type_JavaLangString = paramString;
      } while (a((kwa)localObject));
      if (!this.d) {
        break;
      }
      this.d = false;
      localObject = new HashMap();
      ((Map)localObject).put("url", paramString);
    } while ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a((Map)localObject)));
    paramString = (String)((Map)localObject).get("url");
    WebAccelerateHelper.getInstance().checkCookie(paramString);
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WEBVIEWCHECK", 2, "CustomWebView loadUrlOriginal url:" + Util.b(paramString, new String[0]));
      }
      super.loadUrl(paramString);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, HashMap paramHashMap)
  {
    if ((getX5WebViewExtension() != null) && (QbSdk.getTbsVersion(BaseApplicationImpl.getContext()) >= 43304))
    {
      getX5WebViewExtension().loadDataWithBaseURLWithHeaders(paramString1, paramString2, paramString3, paramString4, paramString5, paramHashMap);
      QLog.d("CustomWebView", 1, "loadDataWithBaseURLAndHeader");
      super.d();
      return;
    }
    loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void a(String paramString, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("CustomWebView", 2, QLog.getStackTraceString(new Throwable("func is empty")));
      }
      return;
    }
    Object localObject;
    if (jdField_c_of_type_JavaLangString == null)
    {
      localObject = AuthorizeConfig.a().a("jscallback", null);
      if ((localObject == null) || (!((String)localObject).contains("((0))")) || (!((String)localObject).contains("((1))"))) {
        break label154;
      }
    }
    label154:
    for (jdField_c_of_type_JavaLangString = (String)localObject;; jdField_c_of_type_JavaLangString = "(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);")
    {
      localObject = new StringBuilder();
      if ((paramVarArgs == null) || (paramVarArgs.length <= 0) || ("".equals(paramVarArgs[0]))) {
        break;
      }
      ((StringBuilder)localObject).append(paramVarArgs[0]);
      int i = 1;
      int j = paramVarArgs.length;
      while (i < j)
      {
        ((StringBuilder)localObject).append(',').append(paramVarArgs[i]);
        i += 1;
      }
    }
    ((StringBuilder)localObject).append("void(0)");
    c(jdField_c_of_type_JavaLangString.replace("((0))", Util.a(paramString)).replace("((1))", (CharSequence)localObject));
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      IX5WebSettingsExtension localIX5WebSettingsExtension = getSettingsExtension();
      if (localIX5WebSettingsExtension != null) {
        localIX5WebSettingsExtension.setRecordRequestEnabled(paramBoolean);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("CustomWebView", 2, "webkit not support request record!");
    }
  }
  
  public boolean a(CustomWebView paramCustomWebView, int paramInt, String paramString1, String paramString2, String paramString3, JsBridgeListener paramJsBridgeListener)
  {
    if (paramCustomWebView == null) {
      return false;
    }
    if ("auth.init".equals(paramString3)) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CustomWebView.troop.openapi", 2, "mOpenApiInfo == null");
      }
      return false;
    }
    if ((paramInt == 0) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramCustomWebView.a(paramJsBridgeListener, 4, new String[] { JsBridgeListener.a(4, null, "params_error") });
      if (QLog.isColorLevel()) {
        QLog.e("CustomWebView.troop.openapi", 2, "RECODE_FAILED_PARAMS_ERROR");
      }
      return false;
    }
    long l = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel()) {
      QLog.e("CustomWebView.troop.openapi", 2, "serverTime - mOpenApiInfo.expireTime:" + (l - this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_Long));
    }
    if (l > this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_Long)
    {
      paramCustomWebView.a(paramJsBridgeListener, 2, new String[] { JsBridgeListener.a(2, null, "token_verify_time_out") });
      if (QLog.isColorLevel()) {
        QLog.e("CustomWebView.troop.openapi", 2, "RECODE_FAILED_TOKEN_VERIFY_TIME_OUT");
      }
      return false;
    }
    paramString2 = paramInt + "_" + paramString1 + "_" + paramString2;
    paramString3 = "mqq." + paramString3;
    paramString1 = null;
    int i;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_b_of_type_JavaLangString)) || (!paramString2.equals(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_b_of_type_JavaLangString)))
    {
      i = 1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_JavaUtilHashMap == null) {
        break label573;
      }
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      paramString1 = null;
      while (localIterator.hasNext())
      {
        paramString2 = (String)localIterator.next();
        paramString1 = paramString2;
        if (Pattern.compile(paramString2).matcher(paramString3).find())
        {
          paramString1 = paramString2;
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      if ((i != 0) || (paramInt == 0))
      {
        paramCustomWebView.a(paramJsBridgeListener, 1, new String[] { JsBridgeListener.a(1, null, "permission_denied") });
        if (QLog.isColorLevel()) {
          QLog.e("CustomWebView.troop.openapi", 2, "permission_denied");
        }
        return false;
        i = 0;
        break;
      }
      l = ((Long)this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_JavaUtilHashMap.get(paramString1)).longValue() + this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_b_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.e("CustomWebView.troop.openapi", 2, "expectedTime - System.currentTimeMillis():" + (l - System.currentTimeMillis()));
      }
      if (l > System.currentTimeMillis())
      {
        paramCustomWebView.a(paramJsBridgeListener, 5, new String[] { JsBridgeListener.a(5, null, "frequency_limit") });
        if (QLog.isColorLevel()) {
          QLog.e("CustomWebView.troop.openapi", 2, "frequency_limit");
        }
        return false;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.jdField_a_of_type_JavaUtilHashMap.put(paramString1, Long.valueOf(System.currentTimeMillis()));
      return true;
      paramInt = 0;
      continue;
      label573:
      paramInt = 0;
    }
  }
  
  public boolean a(Map paramMap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(getUrl(), 8589934601L, paramMap))) {
      return false;
    }
    super.stopLoading();
    super.goBack();
    return true;
  }
  
  public void b()
  {
    try
    {
      if ((((AccessibilityManager)getContext().getSystemService("accessibility")).isEnabled()) && (Build.VERSION.SDK_INT < 19))
      {
        Object localObject1 = com.tencent.smtt.sdk.WebView.class.getDeclaredField("isX5Core");
        ((Field)localObject1).setAccessible(true);
        if (!((Boolean)((Field)localObject1).get(this)).booleanValue())
        {
          localObject1 = com.tencent.smtt.sdk.WebView.class.getDeclaredField("mSysWebView");
          ((Field)localObject1).setAccessible(true);
          localObject1 = ((Field)localObject1).get(this);
          Object localObject2 = android.webkit.WebView.class.getDeclaredField("mProvider");
          ((Field)localObject2).setAccessible(true);
          localObject1 = ((Field)localObject2).get(localObject1);
          localObject2 = Class.forName("android.webkit.WebViewClassic").getDeclaredField("mAccessibilityInjector");
          ((Field)localObject2).setAccessible(true);
          localObject2 = ((Field)localObject2).get(localObject1);
          Field localField = Class.forName("android.webkit.AccessibilityInjector").getDeclaredField("mTextToSpeech");
          localField.setAccessible(true);
          localObject1 = localField.get(localObject2);
          if (localObject1 != null)
          {
            localField.set(localObject2, null);
            localObject2 = Class.forName("android.webkit.AccessibilityInjector.TextToSpeechWrapper").getDeclaredMethod("shutdown", new Class[0]);
            ((Method)localObject2).setAccessible(true);
            ((Method)localObject2).invoke(localObject1, new Object[0]);
          }
        }
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        localNoSuchFieldException.printStackTrace();
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "destroy_webview", 0, 1, 0, localIllegalArgumentException.toString(), "", "", "");
        localIllegalArgumentException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        localNoSuchMethodException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "destroy_webview", 0, 1, 0, localException.toString(), "", "", "");
        localException.printStackTrace();
      }
    }
    a(this);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CustomWebView", 2, "call js script = javascript:" + paramString);
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {
      try
      {
        super.loadUrl("javascript:" + paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    post(new kvz(this, paramString));
  }
  
  public void destroy()
  {
    this.jdField_b_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      SwiftBrowserCookieMonster localSwiftBrowserCookieMonster = SwiftBrowserCookieMonster.a(this.jdField_a_of_type_JavaLangString);
      if (localSwiftBrowserCookieMonster != null) {
        localSwiftBrowserCookieMonster.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster$SetCookiesCallback = null;
      this.jdField_a_of_type_JavaLangString = "";
    }
    if (!this.jdField_c_of_type_Boolean) {
      postDelayed(new kvx(this), 1000L);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo.a();
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$OpenApiTokenInfo = null;
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_b_of_type_Boolean) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (!a()) {
          break;
        }
        localObject = new kwa(this);
        ((kwa)localObject).jdField_a_of_type_Int = 3;
        ((kwa)localObject).jdField_a_of_type_JavaLangString = paramString1;
        ((kwa)localObject).jdField_c_of_type_JavaLangString = paramString2;
        ((kwa)localObject).d = paramString3;
      } while (a((kwa)localObject));
      if (!this.d) {
        break;
      }
      this.d = false;
      localObject = new HashMap();
      ((Map)localObject).put("url", paramString1);
    } while ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a((Map)localObject)));
    paramString1 = (String)((Map)localObject).get("url");
    for (;;)
    {
      b(paramString1);
      super.loadData(paramString1, paramString2, paramString3);
      return;
    }
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (this.jdField_b_of_type_Boolean) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (!a()) {
          break;
        }
        localObject = new kwa(this);
        ((kwa)localObject).jdField_a_of_type_Int = 4;
        ((kwa)localObject).jdField_a_of_type_JavaLangString = paramString1;
        ((kwa)localObject).jdField_b_of_type_JavaLangString = paramString2;
        ((kwa)localObject).jdField_c_of_type_JavaLangString = paramString3;
        ((kwa)localObject).d = paramString4;
        ((kwa)localObject).e = paramString5;
      } while (a((kwa)localObject));
      if (!this.d) {
        break;
      }
      this.d = false;
      localObject = new HashMap();
      ((Map)localObject).put("url", paramString1);
    } while ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a((Map)localObject)));
    paramString1 = (String)((Map)localObject).get("url");
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[").append(Util.b(paramString1, new String[0])).append("]");
      if (!TextUtils.isEmpty(paramString2)) {
        if (paramString2.length() <= 128) {
          break label228;
        }
      }
      label228:
      for (localObject = paramString2.substring(0, 128);; localObject = paramString2)
      {
        localStringBuilder.append((String)localObject);
        b(localStringBuilder.toString());
        super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
        return;
      }
    }
  }
  
  public void loadUrl(String paramString)
  {
    boolean bool = true;
    if (this.jdField_b_of_type_Boolean) {}
    HashMap localHashMap;
    do
    {
      kwa localkwa;
      do
      {
        return;
        localHashMap = new HashMap();
        localHashMap.put("url", paramString);
        if (!a()) {
          break;
        }
        localkwa = new kwa(this);
        localkwa.jdField_a_of_type_Int = 1;
        localkwa.jdField_a_of_type_JavaLangString = paramString;
      } while (a(localkwa));
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.a().isMatchCurrentUrl(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.a().onClientReady()))
      {
        this.d = true;
        QLog.d("CustomWebView", 1, "loadUrl intercept by sonic client.");
        return;
      }
      if (!this.d) {
        break;
      }
      this.d = false;
    } while ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(localHashMap)));
    paramString = (String)localHashMap.get("url");
    WebAccelerateHelper.getInstance().checkCookie(paramString);
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(paramString))) {}
      for (;;)
      {
        if ((bool) && ((paramString.startsWith("http")) || (paramString.startsWith("data:"))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
          b(Util.b(paramString, new String[0]));
        }
        if (QLog.isColorLevel())
        {
          QLog.d("WEBVIEWCHECK", 2, "CustomWebView needLoadUrl: " + bool + ", loadUrl url:" + Util.b(paramString, new String[0]));
          com.tencent.mobileqq.log.VipWebViewReportLog.jdField_c_of_type_JavaLangString = paramString;
        }
        if (SwiftWebViewUtils.ProxyConfig.jdField_a_of_type_Boolean)
        {
          SwiftWebViewUtils.a(this, SwiftWebViewUtils.ProxyConfig.jdField_a_of_type_JavaLangString);
          SwiftWebViewUtils.ProxyConfig.jdField_a_of_type_Boolean = false;
        }
        if (!bool) {
          break;
        }
        super.loadUrl(paramString);
        return;
        bool = false;
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_c_of_type_Boolean = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_b_of_type_Boolean) {
      postDelayed(new kvy(this), 1000L);
    }
  }
  
  public void onPause()
  {
    this.jdField_a_of_type_Boolean = true;
    super.onPause();
  }
  
  public void onResume()
  {
    this.jdField_a_of_type_Boolean = false;
    super.onResume();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$ScrollInterface != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$ScrollInterface.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setMask(boolean paramBoolean)
  {
    View localView = null;
    Context localContext = getContext();
    Object localObject = localContext;
    if ((localContext instanceof MutableContextWrapper)) {
      localObject = ((MutableContextWrapper)localContext).getBaseContext();
    }
    if ((localObject instanceof Activity))
    {
      localObject = (Activity)localObject;
      localView = ((Activity)localObject).findViewById(2131362371);
    }
    for (;;)
    {
      if (localObject == null) {}
      do
      {
        return;
        if (paramBoolean)
        {
          if (localView == null)
          {
            localView = new View(getContext());
            localView.setBackgroundColor(1996488704);
            localView.setId(2131362371);
            ((Activity)localObject).addContentView(localView, new ViewGroup.LayoutParams(-1, -1));
            return;
          }
          localView.setVisibility(0);
          return;
        }
      } while (localView == null);
      localView.setVisibility(8);
      return;
      localObject = null;
    }
  }
  
  public void setOnCustomScrollChangeListener(CustomWebView.ScrollInterface paramScrollInterface)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$ScrollInterface = paramScrollInterface;
  }
  
  public void setPluginEngine(WebViewPluginEngine paramWebViewPluginEngine)
  {
    if (paramWebViewPluginEngine != this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = paramWebViewPluginEngine;
      if (paramWebViewPluginEngine != null) {
        paramWebViewPluginEngine.a(this);
      }
    }
  }
  
  public void setSonicClient(SonicClientImpl paramSonicClientImpl)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl = paramSonicClientImpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebView
 * JD-Core Version:    0.7.0.1
 */