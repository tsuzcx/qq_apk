package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.webview.cookie.SetCookiesCallback;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.utils.ProxyConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.tools.WebViewInfoRecordHelper;
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
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomWebView
  extends SuperWebView
{
  static final String CALLBACK_NAME_HOLDER = "((0))";
  static final String CALLBACK_PARAM_HOLDER = "((1))";
  static final String CALL_JS_DEFAULT_TPL = "(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);";
  public static final String TAG = "CustomWebView";
  public static final String TAG_WEBVIEW_CHECK = "WEBVIEWCHECK";
  public static final String TAG_WEBVIEW_LOAD = "webviewLoad";
  protected static SparseArray<String> mMsg4CallbackMap = new SparseArray(8);
  static String sCallJsTpl;
  public static String sLastContextLog;
  protected boolean attachedToWindow = false;
  String cookieUrl = "";
  SetCookiesCallback cookiesCallback = null;
  protected boolean isDestroyed = false;
  protected boolean isFirstLoad = true;
  public boolean isPaused = true;
  protected CustomWebView.OpenApiTokenInfo mOpenApiInfo;
  protected WebViewPluginEngine mPluginEngine;
  public boolean mWebIsInitMiniAIO;
  CustomWebView.ScrollInterface mt;
  boolean needSetCookies = true;
  protected SonicClientImpl sonicSessionClient;
  
  static
  {
    mMsg4CallbackMap.put(0, "recode_successed");
    mMsg4CallbackMap.put(1, "recode_failed_permission_denied");
    mMsg4CallbackMap.put(2, "recode_failed_token_verify_time_out");
    mMsg4CallbackMap.put(3, "recode_failed_no_such_method");
    mMsg4CallbackMap.put(4, "recode_failed_params_error");
    mMsg4CallbackMap.put(5, "recode_failed_frequency_limit");
  }
  
  public CustomWebView(Context paramContext)
  {
    super(paramContext);
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public CustomWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public CustomWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (Build.VERSION.SDK_INT >= 11) {
      removeJavascriptInterface("searchBoxJavaBridge_");
    }
  }
  
  public static void addContextLog(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.equals(sLastContextLog)) {
        return;
      }
      long l = System.currentTimeMillis();
      sLastContextLog = paramString;
      Object localObject = paramString;
      if (paramString.length() > 512) {
        localObject = paramString.substring(0, 512);
      }
      StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
      paramString = (String)localObject;
      if (arrayOfStackTraceElement.length > 2)
      {
        paramString = new StringBuilder();
        paramString.append((String)localObject);
        paramString.append(" at ");
        paramString.append(arrayOfStackTraceElement[2].toString());
        paramString = paramString.toString();
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cost:");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("webviewLoad", 4, ((StringBuilder)localObject).toString());
      }
      WebViewInfoRecordHelper.a("webviewLoad", paramString);
    }
  }
  
  private Intent getIntent()
  {
    if (this.mIntent != null) {
      return this.mIntent;
    }
    WebViewPluginEngine localWebViewPluginEngine = this.mPluginEngine;
    if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.a != null)) {
      return this.mPluginEngine.a.getIntent();
    }
    return null;
  }
  
  private boolean isNeedSetCookies()
  {
    if (this.needSetCookies)
    {
      Intent localIntent = getIntent();
      if ((localIntent != null) && (localIntent.getBooleanExtra("ignoreLoginWeb", false)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CustomWebView", 2, "ignore login state, set key cookie abort.");
        }
        this.needSetCookies = false;
      }
    }
    return this.needSetCookies;
  }
  
  private boolean setCookiesIfNeeded(CustomWebView.LoadUrlInfo paramLoadUrlInfo)
  {
    if (!this.needSetCookies) {
      return false;
    }
    Object localObject = SwiftWebViewUtils.b(paramLoadUrlInfo.jdField_a_of_type_JavaLangString);
    if ((!"http".equals(localObject)) && (!"https".equals(localObject))) {
      return false;
    }
    this.cookiesCallback = new CustomWebView.1(this, paramLoadUrlInfo);
    localObject = SwiftBrowserCookieMonster.a(paramLoadUrlInfo.jdField_a_of_type_JavaLangString);
    if (localObject != null)
    {
      this.needSetCookies = false;
      Intent localIntent = getIntent();
      if ((localIntent != null) && (localIntent.getBooleanExtra("avoidLoginWeb", false)))
      {
        ((SwiftBrowserCookieMonster)localObject).f();
        return false;
      }
      this.cookieUrl = paramLoadUrlInfo.jdField_a_of_type_JavaLangString;
      ((SwiftBrowserCookieMonster)localObject).a(paramLoadUrlInfo.jdField_a_of_type_JavaLangString, this.cookiesCallback, null, localIntent);
      return true;
    }
    return false;
  }
  
  public void callJs(String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("call js script = javascript:");
      localStringBuilder.append(paramString);
      QLog.i("CustomWebView", 2, localStringBuilder.toString());
    }
    if (this.isDestroyed) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:");
        localStringBuilder.append(paramString);
        super.loadUrl(localStringBuilder.toString());
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    ThreadManagerV2.getUIHandlerV2().post(new CustomWebView.4(this, paramString));
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("CustomWebView", 2, QLog.getStackTraceString(new Throwable("func is empty")));
      }
      return;
    }
    if (sCallJsTpl == null)
    {
      localObject = AuthorizeConfig.a().a("jscallback", null);
      if ((localObject != null) && (((String)localObject).contains("((0))")) && (((String)localObject).contains("((1))"))) {
        sCallJsTpl = (String)localObject;
      } else {
        sCallJsTpl = "(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);";
      }
    }
    Object localObject = new StringBuilder();
    int j;
    int i;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!"".equals(paramVarArgs[0])))
    {
      ((StringBuilder)localObject).append(paramVarArgs[0]);
      j = paramVarArgs.length;
      i = 1;
    }
    while (i < j)
    {
      ((StringBuilder)localObject).append(',');
      ((StringBuilder)localObject).append(paramVarArgs[i]);
      i += 1;
      continue;
      ((StringBuilder)localObject).append("void(0)");
    }
    callJs(sCallJsTpl.replace("((0))", Util.a(paramString)).replace("((1))", (CharSequence)localObject));
  }
  
  public void callJs4OpenApi(JsBridgeListener paramJsBridgeListener, int paramInt, String... paramVarArgs)
  {
    Object localObject;
    if ((paramJsBridgeListener != null) && (paramJsBridgeListener.jdField_a_of_type_Long != -1L)) {
      localObject = (String)mMsg4CallbackMap.get(paramInt);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", paramInt);
      if (localObject == null) {
        localObject = "";
      }
      localJSONObject.put("msg", localObject);
      localObject = new StringBuilder();
      int i;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!"".equals(paramVarArgs[0])))
      {
        ((StringBuilder)localObject).append(paramVarArgs[0]);
        i = paramVarArgs.length;
        paramInt = 1;
      }
      while (paramInt < i)
      {
        ((StringBuilder)localObject).append(',');
        ((StringBuilder)localObject).append(paramVarArgs[paramInt]);
        paramInt += 1;
        continue;
        ((StringBuilder)localObject).append("{}");
      }
      localJSONObject.put("data", ((StringBuilder)localObject).toString());
      paramVarArgs = localJSONObject.toString();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("callJs4OpenApi,listener.sn");
        ((StringBuilder)localObject).append(paramJsBridgeListener.jdField_a_of_type_Long);
        ((StringBuilder)localObject).append(" | result:");
        ((StringBuilder)localObject).append(paramVarArgs);
        QLog.d("CustomWebView.troop.openapi", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramJsBridgeListener.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("");
      callJs("(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);".replace("((0))", Util.a(((StringBuilder)localObject).toString())).replace("((1))", paramVarArgs));
      return;
    }
    catch (JSONException paramJsBridgeListener)
    {
      label290:
      break label290;
    }
    if (QLog.isColorLevel()) {
      QLog.e("CustomWebView.troop.openapi", 2, "callJs4OpenApi, JSONException");
    }
    return;
    if (QLog.isColorLevel()) {
      QLog.w("CustomWebView", 2, "callJs4OpenApi, listener == null || listener.sn == -1");
    }
  }
  
  public boolean checkToken(CustomWebView paramCustomWebView, int paramInt, String paramString1, String paramString2, String paramString3, JsBridgeListener paramJsBridgeListener)
  {
    if (paramCustomWebView == null) {
      return false;
    }
    if ("auth.init".equals(paramString3)) {
      return true;
    }
    if (this.mOpenApiInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CustomWebView.troop.openapi", 2, "mOpenApiInfo == null");
      }
      return false;
    }
    if ((paramInt != 0) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      long l = NetConnInfoCenter.getServerTime();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("serverTime - mOpenApiInfo.expireTime:");
        ((StringBuilder)localObject).append(l - this.mOpenApiInfo.jdField_a_of_type_Long);
        QLog.e("CustomWebView.troop.openapi", 2, ((StringBuilder)localObject).toString());
      }
      if (l > this.mOpenApiInfo.jdField_a_of_type_Long)
      {
        paramCustomWebView.callJs4OpenApi(paramJsBridgeListener, 2, new String[] { JsBridgeListener.a(2, null, "token_verify_time_out") });
        if (QLog.isColorLevel()) {
          QLog.e("CustomWebView.troop.openapi", 2, "RECODE_FAILED_TOKEN_VERIFY_TIME_OUT");
        }
        return false;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString2);
      paramString1 = ((StringBuilder)localObject).toString();
      paramString2 = new StringBuilder();
      paramString2.append("mqq.");
      paramString2.append(paramString3);
      paramString3 = paramString2.toString();
      paramString2 = this.mOpenApiInfo;
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2.jdField_b_of_type_JavaLangString)) && (paramString1.equals(this.mOpenApiInfo.jdField_b_of_type_JavaLangString))) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      int i;
      if (this.mOpenApiInfo.jdField_a_of_type_JavaUtilHashMap != null)
      {
        localObject = this.mOpenApiInfo.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        paramString1 = null;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          paramString2 = (String)((Iterator)localObject).next();
          paramString1 = paramString2;
        } while (!Pattern.compile(paramString2).matcher(paramString3).find());
        i = 1;
        paramString1 = paramString2;
      }
      else
      {
        paramString1 = null;
        i = 0;
      }
      if ((paramInt == 0) && (i != 0))
      {
        l = ((Long)this.mOpenApiInfo.jdField_a_of_type_JavaUtilHashMap.get(paramString1)).longValue() + this.mOpenApiInfo.jdField_b_of_type_Int;
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("expectedTime - System.currentTimeMillis():");
          paramString2.append(l - System.currentTimeMillis());
          QLog.e("CustomWebView.troop.openapi", 2, paramString2.toString());
        }
        if (l > System.currentTimeMillis())
        {
          paramCustomWebView.callJs4OpenApi(paramJsBridgeListener, 5, new String[] { JsBridgeListener.a(5, null, "frequency_limit") });
          if (QLog.isColorLevel()) {
            QLog.e("CustomWebView.troop.openapi", 2, "frequency_limit");
          }
          return false;
        }
        this.mOpenApiInfo.jdField_a_of_type_JavaUtilHashMap.put(paramString1, Long.valueOf(System.currentTimeMillis()));
        return true;
      }
      paramCustomWebView.callJs4OpenApi(paramJsBridgeListener, 1, new String[] { JsBridgeListener.a(1, null, "permission_denied") });
      if (QLog.isColorLevel()) {
        QLog.e("CustomWebView.troop.openapi", 2, "permission_denied");
      }
      return false;
    }
    paramCustomWebView.callJs4OpenApi(paramJsBridgeListener, 4, new String[] { JsBridgeListener.a(4, null, "params_error") });
    if (QLog.isColorLevel()) {
      QLog.e("CustomWebView.troop.openapi", 2, "RECODE_FAILED_PARAMS_ERROR");
    }
    return false;
  }
  
  public void destroy()
  {
    this.isDestroyed = true;
    if ((this.cookiesCallback != null) && (!TextUtils.isEmpty(this.cookieUrl)))
    {
      localObject = SwiftBrowserCookieMonster.a(this.cookieUrl);
      if (localObject != null) {
        ((SwiftBrowserCookieMonster)localObject).a(this.cookiesCallback);
      }
      this.cookiesCallback = null;
      this.cookieUrl = "";
    }
    if (!this.attachedToWindow) {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new CustomWebView.2(this), 1000L);
    }
    Object localObject = this.mOpenApiInfo;
    if (localObject != null)
    {
      ((CustomWebView.OpenApiTokenInfo)localObject).a();
      this.mOpenApiInfo = null;
    }
  }
  
  public void destroyWebView()
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
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
    }
    try
    {
      access$101(this);
      return;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }
  
  public String getCookieUrl()
  {
    return this.cookieUrl;
  }
  
  public CustomWebView.OpenApiTokenInfo getOpenApiTokenInfo()
  {
    return this.mOpenApiInfo;
  }
  
  public WebViewPluginEngine getPluginEngine()
  {
    return this.mPluginEngine;
  }
  
  public SonicClientImpl getSonicClient()
  {
    return this.sonicSessionClient;
  }
  
  public boolean goBack(Map<String, Object> paramMap)
  {
    WebViewPluginEngine localWebViewPluginEngine = this.mPluginEngine;
    if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.a(getUrl(), 8589934601L, paramMap))) {
      return false;
    }
    super.stopLoading();
    super.goBack();
    return true;
  }
  
  public boolean goForward(Map<String, Object> paramMap)
  {
    WebViewPluginEngine localWebViewPluginEngine = this.mPluginEngine;
    if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.a(getUrl(), 8589934602L, paramMap))) {
      return false;
    }
    super.stopLoading();
    super.goForward();
    return true;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    if (this.isDestroyed) {
      return;
    }
    if (isNeedSetCookies())
    {
      localObject = new CustomWebView.LoadUrlInfo(this);
      ((CustomWebView.LoadUrlInfo)localObject).jdField_a_of_type_Int = 3;
      ((CustomWebView.LoadUrlInfo)localObject).jdField_a_of_type_JavaLangString = paramString1;
      ((CustomWebView.LoadUrlInfo)localObject).c = paramString2;
      ((CustomWebView.LoadUrlInfo)localObject).d = paramString3;
      if (setCookiesIfNeeded((CustomWebView.LoadUrlInfo)localObject)) {
        return;
      }
    }
    Object localObject = paramString1;
    if (this.isFirstLoad)
    {
      this.isFirstLoad = false;
      localObject = new HashMap();
      ((Map)localObject).put("url", paramString1);
      paramString1 = this.mPluginEngine;
      if ((paramString1 != null) && (paramString1.a((Map)localObject))) {
        return;
      }
      localObject = (String)((Map)localObject).get("url");
    }
    addContextLog((String)localObject);
    super.loadData((String)localObject, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (this.isDestroyed) {
      return;
    }
    if (isNeedSetCookies())
    {
      localObject = new CustomWebView.LoadUrlInfo(this);
      ((CustomWebView.LoadUrlInfo)localObject).jdField_a_of_type_Int = 4;
      ((CustomWebView.LoadUrlInfo)localObject).jdField_a_of_type_JavaLangString = paramString1;
      ((CustomWebView.LoadUrlInfo)localObject).jdField_b_of_type_JavaLangString = paramString2;
      ((CustomWebView.LoadUrlInfo)localObject).c = paramString3;
      ((CustomWebView.LoadUrlInfo)localObject).d = paramString4;
      ((CustomWebView.LoadUrlInfo)localObject).e = paramString5;
      if (setCookiesIfNeeded((CustomWebView.LoadUrlInfo)localObject)) {
        return;
      }
    }
    Object localObject = paramString1;
    if (this.isFirstLoad)
    {
      this.isFirstLoad = false;
      localObject = new HashMap();
      ((Map)localObject).put("url", paramString1);
      paramString1 = this.mPluginEngine;
      if ((paramString1 != null) && (paramString1.a((Map)localObject))) {
        return;
      }
      localObject = (String)((Map)localObject).get("url");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(Util.b((String)localObject, new String[0]));
    localStringBuilder.append("]");
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramString2.length() > 128) {
        paramString1 = paramString2.substring(0, 128);
      } else {
        paramString1 = paramString2;
      }
      localStringBuilder.append(paramString1);
    }
    addContextLog(localStringBuilder.toString());
    super.loadDataWithBaseURL((String)localObject, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadDataWithBaseURLAndHeader(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, HashMap<String, String> paramHashMap)
  {
    if ((getX5WebViewExtension() != null) && (QbSdk.getTbsVersion(MobileQQ.getContext()) >= 43304))
    {
      getX5WebViewExtension().loadDataWithBaseURLWithHeaders(paramString1, paramString2, paramString3, paramString4, paramString5, paramHashMap);
      QLog.d("CustomWebView", 1, "loadDataWithBaseURLAndHeader");
      super.readyForLoadJs();
      return;
    }
    loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadDataWithHeaders(String paramString1, String paramString2, String paramString3, HashMap<String, String> paramHashMap)
  {
    if ((getX5WebViewExtension() != null) && (QbSdk.getTbsVersion(MobileQQ.getContext()) >= 43304))
    {
      QLog.d("CustomWebView", 1, "loadDataWithHeaders");
      getX5WebViewExtension().loaddataWithHeaders(paramString1, paramString2, paramString3, paramHashMap);
      return;
    }
    loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadUrl(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("tendocpreload CustomWebView needLoadUrl000: ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(", loadUrl url:");
    ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
    QLog.d("WEBVIEWCHECK", 2, ((StringBuilder)localObject1).toString());
    if (this.isDestroyed) {
      return;
    }
    localObject1 = new HashMap();
    ((Map)localObject1).put("url", paramString);
    boolean bool1 = isNeedSetCookies();
    boolean bool2 = true;
    if (bool1)
    {
      localObject2 = new CustomWebView.LoadUrlInfo(this);
      ((CustomWebView.LoadUrlInfo)localObject2).jdField_a_of_type_Int = 1;
      ((CustomWebView.LoadUrlInfo)localObject2).jdField_a_of_type_JavaLangString = paramString;
      if (setCookiesIfNeeded((CustomWebView.LoadUrlInfo)localObject2)) {
        return;
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("tendocpreload CustomWebView needLoadUrl111: ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(", loadUrl url:");
    ((StringBuilder)localObject2).append(Util.b(paramString, new String[0]));
    QLog.d("WEBVIEWCHECK", 2, ((StringBuilder)localObject2).toString());
    localObject2 = this.sonicSessionClient;
    if ((localObject2 != null) && (((SonicClientImpl)localObject2).getSession().isMatchCurrentUrl(paramString)) && (this.sonicSessionClient.getSession().onClientReady()))
    {
      this.isFirstLoad = true;
      QLog.d("CustomWebView", 1, "loadUrl intercept by sonic client.");
      return;
    }
    if (this.isFirstLoad)
    {
      this.isFirstLoad = false;
      paramString = this.mPluginEngine;
      if ((paramString != null) && (paramString.a((Map)localObject1))) {
        return;
      }
      paramString = (String)((Map)localObject1).get("url");
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = this.mPluginEngine;
      bool1 = bool2;
      if (localObject1 == null) {
        break label322;
      }
      if (!((WebViewPluginEngine)localObject1).a(paramString))
      {
        bool1 = bool2;
        break label322;
      }
    }
    bool1 = false;
    label322:
    if ((bool1) && ((paramString.startsWith("http")) || (paramString.startsWith("data:"))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
      addContextLog(Util.b(paramString, new String[0]));
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("tendocpreload CustomWebView needLoadUrl222: ");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(", loadUrl url:");
      ((StringBuilder)localObject1).append(Util.b(paramString, new String[0]));
      QLog.d("WEBVIEWCHECK", 2, ((StringBuilder)localObject1).toString());
      com.tencent.mobileqq.log.VipWebViewReportLog.d = paramString;
    }
    ProxyConfig.a(this, ProxyConfig.jdField_a_of_type_JavaLangString);
    if (bool1) {
      super.loadUrl(paramString);
    }
  }
  
  public void loadUrlOriginal(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tendocpreload CustomWebView loadUrlOriginal000 url:");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("WEBVIEWCHECK", 2, ((StringBuilder)localObject).toString());
    if (this.isDestroyed) {
      return;
    }
    if ("about:blank".equals(paramString))
    {
      super.loadUrl(paramString);
      return;
    }
    if (isNeedSetCookies())
    {
      localObject = new CustomWebView.LoadUrlInfo(this);
      ((CustomWebView.LoadUrlInfo)localObject).jdField_a_of_type_Int = 2;
      ((CustomWebView.LoadUrlInfo)localObject).jdField_a_of_type_JavaLangString = paramString;
      if (setCookiesIfNeeded((CustomWebView.LoadUrlInfo)localObject)) {
        return;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tendocpreload CustomWebView loadUrlOriginal111 url:");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("WEBVIEWCHECK", 2, ((StringBuilder)localObject).toString());
    localObject = paramString;
    if (this.isFirstLoad)
    {
      this.isFirstLoad = false;
      localObject = new HashMap();
      ((Map)localObject).put("url", paramString);
      paramString = this.mPluginEngine;
      if ((paramString != null) && (paramString.a((Map)localObject))) {
        return;
      }
      localObject = (String)((Map)localObject).get("url");
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("tendocpreload CustomWebView loadUrlOriginal222 url:");
      paramString.append(Util.b((String)localObject, new String[0]));
      QLog.d("WEBVIEWCHECK", 2, paramString.toString());
    }
    if (((((String)localObject).startsWith("http")) || (((String)localObject).startsWith("data:"))) && (!((String)localObject).contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
      addContextLog(Util.b((String)localObject, new String[0]));
    }
    super.loadUrl((String)localObject);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.attachedToWindow = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.attachedToWindow = false;
    if (this.isDestroyed) {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new CustomWebView.3(this), 1000L);
    }
  }
  
  public void onPause()
  {
    this.isPaused = true;
    super.onPause();
  }
  
  public void onResume()
  {
    this.isPaused = false;
    super.onResume();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    CustomWebView.ScrollInterface localScrollInterface = this.mt;
    if (localScrollInterface != null) {
      localScrollInterface.onSChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void recordHttpStream(boolean paramBoolean)
  {
    try
    {
      IX5WebSettingsExtension localIX5WebSettingsExtension = getSettingsExtension();
      if (localIX5WebSettingsExtension == null) {
        break label32;
      }
      localIX5WebSettingsExtension.setRecordRequestEnabled(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      label17:
      label32:
      break label17;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CustomWebView", 2, "webkit not support request record!");
    }
  }
  
  public void resetForReuse()
  {
    super.resetForReuse();
    if (this.sonicSessionClient != null) {
      this.sonicSessionClient = null;
    }
    if ((this.cookiesCallback != null) && (!TextUtils.isEmpty(this.cookieUrl)))
    {
      localObject = SwiftBrowserCookieMonster.a(this.cookieUrl);
      if (localObject != null) {
        ((SwiftBrowserCookieMonster)localObject).a(this.cookiesCallback);
      }
      this.cookiesCallback = null;
      this.cookieUrl = "";
    }
    this.attachedToWindow = false;
    this.isPaused = true;
    this.isDestroyed = false;
    this.isFirstLoad = true;
    this.needSetCookies = true;
    Object localObject = this.mOpenApiInfo;
    if (localObject != null)
    {
      ((CustomWebView.OpenApiTokenInfo)localObject).a();
      this.mOpenApiInfo = null;
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
    this.mPluginEngine = null;
  }
  
  public void saveToken(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, ArrayList<String> paramArrayList)
  {
    if (this.mOpenApiInfo == null) {
      this.mOpenApiInfo = new CustomWebView.OpenApiTokenInfo();
    }
    CustomWebView.OpenApiTokenInfo localOpenApiTokenInfo = this.mOpenApiInfo;
    localOpenApiTokenInfo.jdField_a_of_type_Int = paramInt1;
    localOpenApiTokenInfo.jdField_a_of_type_JavaLangString = paramString2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localOpenApiTokenInfo.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    paramString1 = this.mOpenApiInfo;
    paramString1.jdField_b_of_type_Int = paramInt2;
    paramString1.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTime() + paramInt3);
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.mOpenApiInfo.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      paramString1 = paramArrayList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        this.mOpenApiInfo.jdField_a_of_type_JavaUtilHashMap.put(paramString2, Long.valueOf(0L));
      }
    }
  }
  
  public void setMask(boolean paramBoolean)
  {
    Object localObject2 = getContext();
    Object localObject1 = localObject2;
    if ((localObject2 instanceof MutableContextWrapper)) {
      localObject1 = ((MutableContextWrapper)localObject2).getBaseContext();
    }
    boolean bool = localObject1 instanceof Activity;
    localObject2 = null;
    if (bool)
    {
      localObject1 = (Activity)localObject1;
      localObject2 = ((Activity)localObject1).findViewById(2131371886);
    }
    else
    {
      Object localObject3 = null;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    if (localObject1 == null) {
      return;
    }
    if (paramBoolean)
    {
      if (localObject2 == null)
      {
        localObject2 = new View(getContext());
        ((View)localObject2).setBackgroundColor(1711276032);
        ((View)localObject2).setId(2131371886);
        ((Activity)localObject1).addContentView((View)localObject2, new ViewGroup.LayoutParams(-1, -1));
        return;
      }
      ((View)localObject2).setVisibility(0);
      return;
    }
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(8);
    }
  }
  
  public void setOnCustomScrollChangeListener(CustomWebView.ScrollInterface paramScrollInterface)
  {
    this.mt = paramScrollInterface;
  }
  
  public void setPluginEngine(WebViewPluginEngine paramWebViewPluginEngine)
  {
    if (paramWebViewPluginEngine != this.mPluginEngine)
    {
      this.mPluginEngine = paramWebViewPluginEngine;
      if (paramWebViewPluginEngine != null) {
        paramWebViewPluginEngine.a(this);
      }
    }
  }
  
  public void setSonicClient(SonicClientImpl paramSonicClientImpl)
  {
    this.sonicSessionClient = paramSonicClientImpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebView
 * JD-Core Version:    0.7.0.1
 */