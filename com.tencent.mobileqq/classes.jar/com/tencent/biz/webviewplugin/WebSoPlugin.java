package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.webso.WebSoScreenshot;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState.WebSo3;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import com.tencent.smtt.sdk.WebView;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class WebSoPlugin
  extends WebViewPlugin
{
  private static int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler = new WebSoPlugin.1(this, Looper.getMainLooper());
  private WebSoPlugin.WebSo3Helper jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSo3Helper = new WebSoPlugin.WebSo3Helper();
  private WebSoPlugin.WebSoJavaScriptObj jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSoJavaScriptObj;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  boolean[] jdField_a_of_type_ArrayOfBoolean = new boolean[1];
  public String b;
  private boolean b;
  
  public WebSoPlugin()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = false;
    this.mPluginNameSpace = "WebSo";
  }
  
  public static int a(WebView paramWebView)
  {
    if ((jdField_a_of_type_Int < 0) && (paramWebView != null))
    {
      jdField_a_of_type_Int = WebView.getTbsCoreVersion(BaseApplicationImpl.getContext());
      if (QLog.isColorLevel())
      {
        paramWebView = new StringBuilder();
        paramWebView.append("tbsCoreVersion= ");
        paramWebView.append(jdField_a_of_type_Int);
        QLog.i("WebSoPlugin", 2, paramWebView.toString());
      }
    }
    return jdField_a_of_type_Int;
  }
  
  private void a(int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = null;
    if (this.mRuntime != null) {
      localObject1 = this.mRuntime.a();
    }
    if (localObject1 == null) {
      return;
    }
    if ((paramInt == 200) || (paramInt == 304))
    {
      try
      {
        localJSONObject.put("code", 304);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("now call localRefresh data: , ");
          ((StringBuilder)localObject2).append(localJSONObject.toString());
          QLog.i("WebSoPlugin", 1, ((StringBuilder)localObject2).toString());
        }
        ((CustomWebView)localObject1).callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      }
      catch (Exception localException)
      {
        Object localObject2;
        long l1;
        long l2;
        double d;
        StringBuilder localStringBuilder;
        localException.printStackTrace();
        QLog.e("WebSoPlugin", 1, localException, new Object[] { "dispatchDiffData to website error!" });
      }
      localObject2 = new JSONObject(this.jdField_b_of_type_JavaLangString);
      l1 = System.currentTimeMillis();
      l2 = ((JSONObject)localObject2).optLong("local_refresh_time", 0L);
      l1 -= l2;
      if (l1 > 30000L)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("receive js call too late, ");
          d = l1;
          Double.isNaN(d);
          d /= 1000.0D;
          ((StringBuilder)localObject1).append(d);
          ((StringBuilder)localObject1).append("s");
          QLog.w("WebSoPlugin", 1, ((StringBuilder)localObject1).toString());
        }
        this.jdField_b_of_type_JavaLangString = "";
        this.jdField_a_of_type_JavaLangString = "";
        return;
      }
      if (!QLog.isColorLevel()) {
        break label490;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("receive js call in time: ");
      d = l1;
      Double.isNaN(d);
      d /= 1000.0D;
      localStringBuilder.append(d);
      localStringBuilder.append("s");
      QLog.i("WebSoPlugin", 1, localStringBuilder.toString());
    }
    label490:
    for (;;)
    {
      if (l1 > 0L) {
        localJSONObject.put("local_refresh_time", l1);
      }
      ((JSONObject)localObject2).remove("local_refresh_time");
      localJSONObject.put("result", ((JSONObject)localObject2).toString());
      localJSONObject.put("code", 200);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("now call localRefresh data: , ");
        ((StringBuilder)localObject2).append(localJSONObject.toString());
        QLog.i("WebSoPlugin", 1, ((StringBuilder)localObject2).toString());
      }
      ((CustomWebView)localObject1).callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      this.jdField_b_of_type_JavaLangString = "";
      return;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    CustomWebView localCustomWebView;
    if (this.mRuntime != null) {
      localCustomWebView = this.mRuntime.a();
    } else {
      localCustomWebView = null;
    }
    if (localCustomWebView == null) {
      return;
    }
    Object localObject = localCustomWebView.getUrl();
    if (paramBundle == null) {
      return;
    }
    String str2 = paramBundle.getString("url");
    paramBundle.getInt("req_state", 0);
    int j = paramBundle.getInt("result_code", 0);
    boolean bool1 = paramBundle.getBoolean("is_local_data");
    String str1 = paramBundle.getString("wns_proxy_http_data");
    boolean bool2 = TextUtils.isEmpty(str1);
    int i;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"about:blank".equals(localObject))) {
      i = 0;
    } else {
      i = 1;
    }
    boolean bool3 = paramBundle.getBoolean("key_wns_cache_hit", false);
    WebSoService.WebSoState.WebSo3 localWebSo3 = (WebSoService.WebSoState.WebSo3)paramBundle.getParcelable("key_webso_3");
    if (j == 10503)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("QZoneWebViewPlugin onReceive 503, now it reload url! ");
      paramBundle.append(Util.c(str2, new String[0]));
      QLog.e("WebSoPlugin", 1, paramBundle.toString());
      localCustomWebView.loadUrlOriginal(str2);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QZoneWebViewPlugin onReceive  htmlBody(");
    localStringBuilder.append(bool2 ^ true);
    localStringBuilder.append(") currentUrl(");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(") cache hit(");
    localStringBuilder.append(bool3);
    localStringBuilder.append(") hasLoadCache(");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(") load Url: ");
    localStringBuilder.append(Util.c(str2, new String[0]));
    localStringBuilder.append(",silent_mode:");
    localStringBuilder.append(paramBundle.getBoolean("is_silent_mode", false));
    localStringBuilder.append(",isLocalData:");
    localStringBuilder.append(bool1);
    QLog.d("WebSoPlugin", 1, localStringBuilder.toString());
    if ((localWebSo3 != null) && (localWebSo3.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSo3Helper.a(this, localWebSo3);
      return;
    }
    this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSo3Helper.a();
    if ((!bool2) && (Build.VERSION.SDK_INT >= 17)) {
      if (bool1)
      {
        if (this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSoJavaScriptObj == null)
        {
          this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSoJavaScriptObj = new WebSoPlugin.WebSoJavaScriptObj(this, localCustomWebView);
          localCustomWebView.addJavascriptInterface(this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSoJavaScriptObj, "_webso");
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("js method : ");
            ((StringBuilder)localObject).append(Arrays.toString(this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSoJavaScriptObj.getClass().getDeclaredMethods()));
            QLog.d("WebSoPlugin", 1, ((StringBuilder)localObject).toString());
          }
        }
      }
      else if (paramBundle.getBoolean("is_silent_mode", false))
      {
        QLog.d("WebSoPlugin", 1, "静默加载html");
        paramBundle = this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSoJavaScriptObj;
        if (paramBundle != null) {
          paramBundle.a(str1);
        }
        return;
      }
    }
    if ((!this.jdField_b_of_type_Boolean) && (!bool2) && (i != 0))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfBoolean[0] = true;
      if (bool1) {
        paramBundle = WebSoUtils.a(str2, str1);
      } else {
        paramBundle = WebSoUtils.b(str2, str1);
      }
      a(localCustomWebView, str2, paramBundle);
      return;
    }
    if (bool3)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 2, "webso return 304, so hit local cache!");
      }
      paramBundle = this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSoJavaScriptObj;
      if (paramBundle != null) {
        paramBundle.a("{\"code\":0,\"data\":null}");
      }
      this.jdField_b_of_type_JavaLangString = "304";
      a(304);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("webso success load local data, now load new data ! ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
        QLog.i("WebSoPlugin", 1, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_Boolean = true;
    }
    if ((bool2) && (i != 0))
    {
      localCustomWebView.loadUrl(str2);
      a(true);
      return;
    }
    if ((!bool2) && (i != 0))
    {
      if (bool1) {
        paramBundle = WebSoUtils.a(str2, str1);
      } else {
        paramBundle = WebSoUtils.b(str2, str1);
      }
      a(localCustomWebView, str2, paramBundle);
      return;
    }
    if ((!bool2) && (i == 0))
    {
      if (paramBundle.getBoolean("need_force_refresh", false))
      {
        paramBundle = str1;
        if (!bool1) {
          paramBundle = WebSoUtils.b(str2, str1);
        }
        a(localCustomWebView, str2, paramBundle);
        return;
      }
      if (paramBundle.getBoolean("need_local_refresh", false))
      {
        this.jdField_b_of_type_JavaLangString = paramBundle.getString("key_html_changed_data");
        a(200);
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public static void a(CustomWebView paramCustomWebView, String paramString1, String paramString2)
  {
    WebSoUtils.a("setdata");
    if (TextUtils.isEmpty(paramString1)) {
      QLog.w("WebSoPlugin", 1, "setWebViewData webview url is Empty!");
    }
    if (a(paramCustomWebView))
    {
      paramCustomWebView.setTag(2131374373, paramString2);
      paramCustomWebView.setTag(2131374374, Long.valueOf(System.currentTimeMillis()));
      paramCustomWebView.loadUrl(paramString1);
      return;
    }
    paramCustomWebView.loadDataWithBaseURL(paramString1, paramString2, "text/html", "utf-8", paramString1);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.mRuntime == null) {
      return;
    }
    Object localObject = this.mRuntime.a();
    if ((localObject instanceof QBaseActivity))
    {
      localObject = a((QBaseActivity)localObject);
      if ((localObject != null) && (((WebViewFragment)localObject).getUIStyleHandler() != null))
      {
        if (((WebViewFragment)localObject).getUIStyleHandler().a != null)
        {
          ((WebViewFragment)localObject).getUIStyleHandler().d = (paramBoolean ^ true);
          ((WebViewFragment)localObject).getUIStyleHandler().a.a(paramBoolean);
          return;
        }
        ((WebViewFragment)localObject).getUIStyleHandler().d = (paramBoolean ^ true);
        return;
      }
      b(paramBoolean);
      return;
    }
    b(paramBoolean);
  }
  
  public static boolean a(WebView paramWebView)
  {
    return (a(paramWebView) >= 43001) || (Build.VERSION.SDK_INT >= 23);
  }
  
  private boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfBoolean[0] = false;
    this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSo3Helper.a();
    if (paramLong == 32L)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (this.mRuntime == null) {
        return false;
      }
      paramMap = this.mRuntime.a();
      if ((paramMap != null) && (!paramMap.isFinishing()))
      {
        if (paramMap.getIntent() == null) {
          return false;
        }
        paramMap = this.mRuntime.a();
        if (paramMap == null) {
          return false;
        }
        paramMap = paramMap.getUrl();
        if ((!TextUtils.isEmpty(paramMap)) && (!"about:blank".equals(paramMap)))
        {
          paramString = new StringBuilder();
          paramString.append("now onHandleEventBeforeLoaded current url is not null! so return! ");
          paramString.append(Util.c(paramMap, new String[0]));
          QLog.e("WebSoPlugin", 1, paramString.toString());
          return false;
        }
        a(paramString);
        if (WebSoUtils.b(paramString))
        {
          if (WebSoUtils.e(paramString)) {
            return false;
          }
          WebSoService.a().a(paramString, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ArrayOfBoolean);
          a(false);
          return true;
        }
      }
    }
    return false;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.mRuntime != null) && (this.mRuntime.a() != null) && (this.mRuntime.a().getRootView() != null))
    {
      if (this.mRuntime.a().getRootView().findViewById(2131381085) == null) {
        return;
      }
      View localView = this.mRuntime.a().getRootView().findViewById(2131381085).findViewById(2131373133);
      if (localView != null)
      {
        int i;
        if (paramBoolean) {
          i = 0;
        } else {
          i = 8;
        }
        localView.setVisibility(i);
      }
    }
  }
  
  public WebViewFragment a(QBaseActivity paramQBaseActivity)
  {
    paramQBaseActivity = paramQBaseActivity.getSupportFragmentManager();
    if (paramQBaseActivity != null)
    {
      paramQBaseActivity = paramQBaseActivity.getFragments();
      if ((paramQBaseActivity != null) && (paramQBaseActivity.size() > 0))
      {
        paramQBaseActivity = paramQBaseActivity.iterator();
        while (paramQBaseActivity.hasNext())
        {
          Fragment localFragment = (Fragment)paramQBaseActivity.next();
          if ((localFragment instanceof WebViewFragment)) {
            return (WebViewFragment)localFragment;
          }
        }
      }
    }
    return null;
  }
  
  void a(CustomWebView paramCustomWebView)
  {
    if ((paramCustomWebView != null) && (Build.VERSION.SDK_INT > 10)) {
      paramCustomWebView.setLayerType(1, null);
    }
  }
  
  void a(String paramString)
  {
    ThreadManager.post(new WebSoPlugin.2(this, paramString), 5, null, false);
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 32L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 32L)
    {
      WebSoUtils.a("KEY_EVENT_BEFORE_LOAD");
      return a(paramString, paramLong, paramMap);
    }
    if (paramLong == 8589934594L)
    {
      WebSoUtils.a("EVENT_LOAD_FINISH");
      if (!TextUtils.isEmpty(paramString))
      {
        if ("about:bank".equals(paramString)) {
          return false;
        }
        if (!WebSoUtils.b(paramString)) {
          return false;
        }
        CustomWebView localCustomWebView = this.mRuntime.a();
        if (localCustomWebView == null) {
          return false;
        }
        paramString = localCustomWebView.copyBackForwardList();
        if ((paramString != null) && (paramString.getSize() != 0))
        {
          int i;
          Object localObject;
          if (QLog.isColorLevel())
          {
            i = paramString.getSize() - 1;
            while (i >= 0)
            {
              paramMap = paramString.getItemAtIndex(i);
              if (paramMap != null)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(" EVENT_LOAD_FINISH --- history: ");
                ((StringBuilder)localObject).append(i);
                ((StringBuilder)localObject).append(" ");
                ((StringBuilder)localObject).append(paramMap.getUrl());
                QLog.i("WebSoPlugin", 2, ((StringBuilder)localObject).toString());
              }
              i -= 1;
            }
          }
          if (paramString.getSize() >= 2)
          {
            i = paramString.getSize() - 1;
            localObject = paramString.getItemAtIndex(i);
            paramString = paramString.getItemAtIndex(i - 1);
            paramMap = "";
            if ((localObject != null) && (paramString != null))
            {
              paramMap = ((WebHistoryItem)localObject).getUrl();
              paramString = paramString.getUrl();
            }
            else
            {
              paramString = "";
            }
            if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(paramMap)))
            {
              if (QLog.isColorLevel()) {
                QLog.i("WebSoPlugin", 2, "current url equals with precious url, need clear history!");
              }
              this.jdField_a_of_type_Boolean = true;
            }
          }
          if (!this.jdField_a_of_type_Boolean) {
            break label520;
          }
          if (QLog.isColorLevel()) {
            QLog.i("WebSoPlugin", 2, "now clear webview history!");
          }
          localCustomWebView.clearHistory();
          this.jdField_a_of_type_Boolean = false;
          return false;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          if (localCustomWebView != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("WebSoPlugin", 2, "now clear webview history!");
            }
            localCustomWebView.clearHistory();
          }
          this.jdField_a_of_type_Boolean = false;
        }
      }
      return false;
    }
    else if (paramLong == 8589934601L)
    {
      WebSoUtils.a("EVENT_GO_BACK");
      if (!TextUtils.isEmpty(paramString))
      {
        if ("about:bank".equals(paramString)) {
          return false;
        }
        if (!WebSoUtils.b(paramString)) {
          return false;
        }
        paramString = this.mRuntime.a();
        if (paramString == null) {
          return false;
        }
        paramString = paramString.copyBackForwardList();
        if (paramString == null) {
          return false;
        }
        if (paramString.getSize() == 2)
        {
          paramMap = paramString.getItemAtIndex(paramString.getSize() - 1).getUrl();
          if (paramString.getItemAtIndex(paramString.getSize() - 2).getUrl().equals(paramMap))
          {
            if (QLog.isColorLevel()) {
              QLog.i("WebSoPlugin", 2, "current url equals with precious url, need close activity!");
            }
            if (this.mRuntime.a() != null)
            {
              this.mRuntime.a().finish();
              return true;
            }
          }
        }
      }
    }
    label520:
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 != null) && ("WebSo".equals(paramString2)))
    {
      paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramJsBridgeListener == null) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("handleJsRequest JSON = ");
        paramString1.append(paramJsBridgeListener.toString());
        QLog.d("WebSoPlugin", 2, paramString1.toString());
      }
      paramJsBridgeListener = paramJsBridgeListener.optString("callback");
      if (TextUtils.isEmpty(paramJsBridgeListener))
      {
        QLog.e("WebSoPlugin", 1, "callback id is null, so return");
        return true;
      }
      if ("getWebsoDiffData".equals(paramString3))
      {
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("WebSo get webso js api, data: ");
          paramJsBridgeListener.append(Arrays.toString(paramVarArgs));
          QLog.d("WebSoPlugin", 2, paramJsBridgeListener.toString());
        }
        if ((this.mRuntime.a() != null) && (paramVarArgs.length > 0)) {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("callback");
            if (TextUtils.isEmpty(paramJsBridgeListener)) {
              break label504;
            }
            this.jdField_a_of_type_JavaLangString = paramJsBridgeListener;
            if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
              break label504;
            }
            if (this.jdField_b_of_type_JavaLangString.equals("304"))
            {
              a(304);
              return true;
            }
            a(200);
            return true;
          }
          catch (Exception paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            return true;
          }
        }
      }
      else
      {
        if ("getData".equals(paramString3))
        {
          WebSoUtils.a("js call getData");
          this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSo3Helper.a(this, paramJsBridgeListener);
          return true;
        }
        if (!"updateWebsoCache".equals(paramString3)) {}
      }
    }
    try
    {
      WebSoUtils.a("js call updateWebsoCache");
      if (this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSo3Helper.a() != null)
      {
        if (this.mRuntime != null) {
          this.mRuntime.a().loadUrl("javascript:window._webso.catchHtml(document.getElementsByTagName('html')[0].outerHTML);");
        }
        paramString1 = new JSONObject();
        paramString1.put("result", 1);
        super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
        return true;
      }
      WebSoUtils.a("return : webso == null");
      return true;
    }
    catch (Exception paramJsBridgeListener) {}
    if ("updateScreenshot".equals(paramString3))
    {
      WebSoUtils.a("js call updateScreenshot");
      if (this.mRuntime != null)
      {
        paramString1 = this.mRuntime.a();
        paramString2 = paramString1.getUrl();
        if (WebSoUtils.b(paramString2)) {
          WebSoScreenshot.a(paramString1, paramString2);
        }
      }
      paramString1 = new JSONObject();
      paramString1.put("result", 1);
      super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
      return true;
    }
    if ("hideScreenshot".equals(paramString3))
    {
      WebSoUtils.a("js call hideScreenshot");
      if (this.mRuntime != null) {
        WebSoScreenshot.a(this.mRuntime.a());
      }
      paramString1 = new JSONObject();
      paramString1.put("result", 1);
      super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
    }
    label504:
    return true;
    return false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.WebSoPlugin
 * JD-Core Version:    0.7.0.1
 */