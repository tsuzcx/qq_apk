package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.webso.WebSoService;
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
import pdo;
import pdp;

public class WebSoPlugin
  extends WebViewPlugin
{
  private static int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler = new pdo(this, Looper.getMainLooper());
  private WebSoPlugin.WebSoJavaScriptObj jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSoJavaScriptObj;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  public String b;
  private boolean b;
  
  public WebSoPlugin()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.mPluginNameSpace = "WebSo";
  }
  
  public static int a(WebView paramWebView)
  {
    if ((jdField_a_of_type_Int < 0) && (paramWebView != null))
    {
      jdField_a_of_type_Int = WebView.getTbsCoreVersion(BaseApplicationImpl.getContext());
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 2, "tbsCoreVersion= " + jdField_a_of_type_Int);
      }
    }
    return jdField_a_of_type_Int;
  }
  
  private void a(int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    JSONObject localJSONObject1;
    CustomWebView localCustomWebView;
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
      localJSONObject1 = new JSONObject();
      localCustomWebView = null;
      if (this.mRuntime != null) {
        localCustomWebView = this.mRuntime.a();
      }
    } while (localCustomWebView == null);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = "";
      return;
      JSONObject localJSONObject2;
      long l;
      try
      {
        localJSONObject2 = new JSONObject(this.jdField_b_of_type_JavaLangString);
        l = System.currentTimeMillis() - localJSONObject2.optLong("local_refresh_time", 0L);
        if (l <= 30000L) {
          break label202;
        }
        if (QLog.isColorLevel()) {
          QLog.w("WebSoPlugin", 1, "receive js call too late, " + l / 1000.0D + "s");
        }
        this.jdField_b_of_type_JavaLangString = "";
        this.jdField_a_of_type_JavaLangString = "";
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("WebSoPlugin", 1, localException, new Object[] { "dispatchDiffData to website error!" });
      }
      continue;
      label202:
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 1, "receive js call in time: " + l / 1000.0D + "s");
      }
      if (l > 0L) {
        localJSONObject1.put("local_refresh_time", l);
      }
      localJSONObject2.remove("local_refresh_time");
      localJSONObject1.put("result", localJSONObject2.toString());
      localJSONObject1.put("code", 200);
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 1, "now call localRefresh data: , " + localJSONObject1.toString());
      }
      localException.a(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject1.toString() });
      continue;
      localJSONObject1.put("code", 304);
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 1, "now call localRefresh data: , " + localJSONObject1.toString());
      }
      localException.a(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject1.toString() });
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.mRuntime != null) {}
    for (CustomWebView localCustomWebView = this.mRuntime.a();; localCustomWebView = null)
    {
      if (localCustomWebView == null) {}
      do
      {
        return;
        localObject = localCustomWebView.getUrl();
      } while (paramBundle == null);
      String str2 = paramBundle.getString("url");
      int j = paramBundle.getInt("req_state", 0);
      int k = paramBundle.getInt("result_code", 0);
      boolean bool2 = paramBundle.getBoolean("is_local_data");
      String str1 = paramBundle.getString("wns_proxy_http_data");
      boolean bool3 = TextUtils.isEmpty(str1);
      if ((TextUtils.isEmpty((CharSequence)localObject)) || ("about:blank".equals(localObject))) {}
      boolean bool4;
      for (int i = 1;; i = 0)
      {
        bool4 = paramBundle.getBoolean("key_wns_cache_hit", false);
        if (k != 10503) {
          break;
        }
        QLog.e("WebSoPlugin", 1, "QZoneWebViewPlugin onReceive 503, now it reload url! " + Util.c(str2, new String[0]));
        localCustomWebView.a(str2);
        return;
      }
      Object localObject = new StringBuilder().append("QZoneWebViewPlugin onReceive  htmlBody(");
      boolean bool1;
      if (!bool3)
      {
        bool1 = true;
        label186:
        localObject = ((StringBuilder)localObject).append(bool1).append(") currentUrl(");
        if (i != 0) {
          break label367;
        }
        bool1 = true;
        label207:
        QLog.d("WebSoPlugin", 1, bool1 + ") cache hit(" + bool4 + ") hasLoadCache(" + this.jdField_b_of_type_Boolean + ") load Url: " + Util.c(str2, new String[0]));
        if ((!bool3) && (Build.VERSION.SDK_INT >= 17))
        {
          if (!bool2) {
            break label373;
          }
          if (this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSoJavaScriptObj == null)
          {
            this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSoJavaScriptObj = new WebSoPlugin.WebSoJavaScriptObj(this, localCustomWebView);
            localCustomWebView.addJavascriptInterface(this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSoJavaScriptObj, "_webso");
          }
        }
        label313:
        if ((this.jdField_b_of_type_Boolean) || (bool3) || (i == 0)) {
          break label412;
        }
        if (j == 2) {}
        this.jdField_b_of_type_Boolean = true;
        if (!bool2) {
          break label401;
        }
      }
      label401:
      for (paramBundle = WebSoUtils.a(str2, str1);; paramBundle = WebSoUtils.b(str2, str1))
      {
        a(localCustomWebView, str2, paramBundle);
        return;
        bool1 = false;
        break label186;
        label367:
        bool1 = false;
        break label207;
        label373:
        if (!paramBundle.getBoolean("is_silent_mode", false)) {
          break label313;
        }
        if (this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSoJavaScriptObj == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSoJavaScriptObj.a(str1);
        return;
      }
      label412:
      if (bool4)
      {
        if (QLog.isColorLevel()) {
          QLog.i("WebSoPlugin", 2, "webso return 304, so hit local cache!");
        }
        if (this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSoJavaScriptObj != null) {
          this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin$WebSoJavaScriptObj.a("{\"code\":0,\"data\":null}");
        }
        this.jdField_b_of_type_JavaLangString = "304";
        a(304);
        return;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i("WebSoPlugin", 1, "webso success load local data, now load new data ! " + this.jdField_b_of_type_Boolean);
        }
        this.jdField_a_of_type_Boolean = true;
      }
      if ((bool3) && (i != 0))
      {
        localCustomWebView.loadUrl(str2);
        a(true);
        return;
      }
      if ((!bool3) && (i != 0))
      {
        if (bool2) {}
        for (paramBundle = WebSoUtils.a(str2, str1);; paramBundle = WebSoUtils.b(str2, str1))
        {
          a(localCustomWebView, str2, paramBundle);
          return;
        }
      }
      if ((!bool3) && (i == 0)) {
        if (paramBundle.getBoolean("need_force_refresh", false)) {
          if (bool2) {
            break label653;
          }
        }
      }
      label653:
      for (paramBundle = WebSoUtils.b(str2, str1);; paramBundle = str1)
      {
        a(localCustomWebView, str2, paramBundle);
        return;
        if (!paramBundle.getBoolean("need_local_refresh", false)) {
          break;
        }
        this.jdField_b_of_type_JavaLangString = paramBundle.getString("key_html_changed_data");
        a(200);
        return;
        this.jdField_a_of_type_Boolean = false;
        return;
      }
    }
  }
  
  public static void a(CustomWebView paramCustomWebView, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      QLog.w("WebSoPlugin", 1, "setWebViewData webview url is Empty!");
    }
    if (a(paramCustomWebView))
    {
      paramCustomWebView.setTag(2131362356, paramString2);
      paramCustomWebView.setTag(2131362357, Long.valueOf(System.currentTimeMillis()));
      paramCustomWebView.loadUrl(paramString1);
      return;
    }
    paramCustomWebView.loadDataWithBaseURL(paramString1, paramString2, "text/html", "utf-8", paramString1);
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (this.mRuntime == null) {}
    do
    {
      do
      {
        return;
        localObject = this.mRuntime.a();
      } while (!(localObject instanceof FragmentActivity));
      localObject = a((FragmentActivity)localObject);
    } while ((localObject == null) || (((WebViewFragment)localObject).a == null));
    if (((WebViewFragment)localObject).a.a != null)
    {
      SwiftBrowserUIStyleHandler localSwiftBrowserUIStyleHandler = ((WebViewFragment)localObject).a;
      if (!paramBoolean) {}
      for (bool = true;; bool = false)
      {
        localSwiftBrowserUIStyleHandler.d = bool;
        ((WebViewFragment)localObject).a.a.a(paramBoolean);
        return;
      }
    }
    Object localObject = ((WebViewFragment)localObject).a;
    if (!paramBoolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((SwiftBrowserUIStyleHandler)localObject).d = paramBoolean;
      return;
    }
  }
  
  public static boolean a(WebView paramWebView)
  {
    return (a(paramWebView) >= 43001) || (Build.VERSION.SDK_INT >= 23);
  }
  
  private boolean a(String paramString, long paramLong, Map paramMap)
  {
    this.jdField_b_of_type_Boolean = false;
    if ((paramLong != 32L) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        do
        {
          return false;
          paramMap = this.mRuntime.a();
        } while ((paramMap == null) || (paramMap.isFinishing()) || (paramMap.getIntent() == null));
        paramMap = this.mRuntime.a();
      } while (paramMap == null);
      paramMap = paramMap.getUrl();
      if ((!TextUtils.isEmpty(paramMap)) && (!"about:blank".equals(paramMap)))
      {
        QLog.e("WebSoPlugin", 1, "now onHandleEventBeforeLoaded current url is not null! so return! " + Util.c(paramMap, new String[0]));
        return false;
      }
      a(paramString);
    } while ((!WebSoUtils.b(paramString)) || (WebSoUtils.e(paramString)));
    WebSoService.a().a(paramString, this.jdField_a_of_type_AndroidOsHandler);
    a(false);
    return true;
  }
  
  public WebViewFragment a(FragmentActivity paramFragmentActivity)
  {
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
    if (paramFragmentActivity != null)
    {
      paramFragmentActivity = paramFragmentActivity.getFragments();
      if ((paramFragmentActivity != null) && (paramFragmentActivity.size() > 0))
      {
        paramFragmentActivity = paramFragmentActivity.iterator();
        while (paramFragmentActivity.hasNext())
        {
          Fragment localFragment = (Fragment)paramFragmentActivity.next();
          if ((localFragment instanceof WebViewFragment)) {
            return (WebViewFragment)localFragment;
          }
        }
      }
    }
    return null;
  }
  
  public void a(CustomWebView paramCustomWebView)
  {
    if ((paramCustomWebView != null) && (Build.VERSION.SDK_INT > 10)) {
      paramCustomWebView.setLayerType(1, null);
    }
  }
  
  void a(String paramString)
  {
    ThreadManager.post(new pdp(this, paramString), 5, null, false);
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 32L) {
      return a(paramString, paramLong, paramMap);
    }
    if (paramLong == 8589934594L)
    {
      if ((TextUtils.isEmpty(paramString)) || ("about:bank".equals(paramString))) {
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
      if ((paramString == null) || (paramString.getSize() == 0))
      {
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
        return false;
      }
      int i;
      if (QLog.isColorLevel())
      {
        i = paramString.getSize() - 1;
        while (i >= 0)
        {
          paramMap = paramString.getItemAtIndex(i);
          if (paramMap != null) {
            QLog.i("WebSoPlugin", 2, " EVENT_LOAD_FINISH --- history: " + i + " " + paramMap.getUrl());
          }
          i -= 1;
        }
      }
      if (paramString.getSize() >= 2)
      {
        String str1 = "";
        String str2 = "";
        i = paramString.getSize() - 1;
        WebHistoryItem localWebHistoryItem1 = paramString.getItemAtIndex(i);
        WebHistoryItem localWebHistoryItem2 = paramString.getItemAtIndex(i - 1);
        paramMap = str2;
        paramString = str1;
        if (localWebHistoryItem1 != null)
        {
          paramMap = str2;
          paramString = str1;
          if (localWebHistoryItem2 != null)
          {
            paramString = localWebHistoryItem1.getUrl();
            paramMap = localWebHistoryItem2.getUrl();
          }
        }
        if ((!TextUtils.isEmpty(paramMap)) && (paramMap.equals(paramString)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("WebSoPlugin", 2, "current url equals with precious url, need clear history!");
          }
          this.jdField_a_of_type_Boolean = true;
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i("WebSoPlugin", 2, "now clear webview history!");
        }
        localCustomWebView.clearHistory();
        this.jdField_a_of_type_Boolean = false;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while (paramLong != 8589934601L);
          if ((TextUtils.isEmpty(paramString)) || ("about:bank".equals(paramString))) {
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
        } while (paramString.getSize() != 2);
        paramMap = paramString.getItemAtIndex(paramString.getSize() - 1).getUrl();
      } while (!paramString.getItemAtIndex(paramString.getSize() - 2).getUrl().equals(paramMap));
      if (QLog.isColorLevel()) {
        QLog.i("WebSoPlugin", 2, "current url equals with precious url, need close activity!");
      }
    } while (this.mRuntime.a() == null);
    this.mRuntime.a().finish();
    return true;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString2 != null)
    {
      bool1 = bool2;
      if ("WebSo".equals(paramString2))
      {
        if ("getWebsoDiffData".equals(paramString3))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebSoPlugin", 2, "WebSo get webso js api, data: " + Arrays.toString(paramVarArgs));
          }
          if ((this.mRuntime.a() != null) && (paramVarArgs.length > 0)) {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("callback");
              if (!TextUtils.isEmpty(paramJsBridgeListener))
              {
                this.jdField_a_of_type_JavaLangString = paramJsBridgeListener;
                if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
                  if (this.jdField_b_of_type_JavaLangString.equals("304")) {
                    a(304);
                  } else {
                    a(200);
                  }
                }
              }
            }
            catch (Exception paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.WebSoPlugin
 * JD-Core Version:    0.7.0.1
 */