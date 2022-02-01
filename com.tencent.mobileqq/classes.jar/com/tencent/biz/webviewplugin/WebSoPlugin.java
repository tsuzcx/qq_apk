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
  private static int e = -1;
  public String a = "";
  public String b = "";
  boolean[] c = new boolean[1];
  private boolean d;
  private WebSoPlugin.WebSoJavaScriptObj f;
  private WebSoPlugin.WebSo3Helper g = new WebSoPlugin.WebSo3Helper();
  private Handler h = new WebSoPlugin.1(this, Looper.getMainLooper());
  private boolean i = false;
  
  public WebSoPlugin()
  {
    this.mPluginNameSpace = "WebSo";
  }
  
  public static int a(WebView paramWebView)
  {
    if ((e < 0) && (paramWebView != null))
    {
      e = WebView.getTbsCoreVersion(BaseApplicationImpl.getContext());
      if (QLog.isColorLevel())
      {
        paramWebView = new StringBuilder();
        paramWebView.append("tbsCoreVersion= ");
        paramWebView.append(e);
        QLog.i("WebSoPlugin", 2, paramWebView.toString());
      }
    }
    return e;
  }
  
  private void a(int paramInt)
  {
    if (TextUtils.isEmpty(this.a)) {
      return;
    }
    if (TextUtils.isEmpty(this.b)) {
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
        ((CustomWebView)localObject1).callJs(this.a, new String[] { localJSONObject.toString() });
      }
      catch (Exception localException)
      {
        Object localObject2;
        long l1;
        long l2;
        double d1;
        StringBuilder localStringBuilder;
        localException.printStackTrace();
        QLog.e("WebSoPlugin", 1, localException, new Object[] { "dispatchDiffData to website error!" });
      }
      localObject2 = new JSONObject(this.b);
      l1 = System.currentTimeMillis();
      l2 = ((JSONObject)localObject2).optLong("local_refresh_time", 0L);
      l1 -= l2;
      if (l1 > 30000L)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("receive js call too late, ");
          d1 = l1;
          Double.isNaN(d1);
          d1 /= 1000.0D;
          ((StringBuilder)localObject1).append(d1);
          ((StringBuilder)localObject1).append("s");
          QLog.w("WebSoPlugin", 1, ((StringBuilder)localObject1).toString());
        }
        this.b = "";
        this.a = "";
        return;
      }
      if (!QLog.isColorLevel()) {
        break label490;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("receive js call in time: ");
      d1 = l1;
      Double.isNaN(d1);
      d1 /= 1000.0D;
      localStringBuilder.append(d1);
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
      ((CustomWebView)localObject1).callJs(this.a, new String[] { localJSONObject.toString() });
      this.b = "";
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
    int k = paramBundle.getInt("result_code", 0);
    boolean bool1 = paramBundle.getBoolean("is_local_data");
    String str1 = paramBundle.getString("wns_proxy_http_data");
    boolean bool2 = TextUtils.isEmpty(str1);
    int j;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"about:blank".equals(localObject))) {
      j = 0;
    } else {
      j = 1;
    }
    boolean bool3 = paramBundle.getBoolean("key_wns_cache_hit", false);
    WebSoService.WebSoState.WebSo3 localWebSo3 = (WebSoService.WebSoState.WebSo3)paramBundle.getParcelable("key_webso_3");
    if (k == 10503)
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
    localStringBuilder.append(this.i);
    localStringBuilder.append(") load Url: ");
    localStringBuilder.append(Util.c(str2, new String[0]));
    localStringBuilder.append(",silent_mode:");
    localStringBuilder.append(paramBundle.getBoolean("is_silent_mode", false));
    localStringBuilder.append(",isLocalData:");
    localStringBuilder.append(bool1);
    QLog.d("WebSoPlugin", 1, localStringBuilder.toString());
    if ((localWebSo3 != null) && (localWebSo3.a))
    {
      this.g.a(this, localWebSo3);
      return;
    }
    this.g.a();
    if ((!bool2) && (Build.VERSION.SDK_INT >= 17)) {
      if (bool1)
      {
        if (this.f == null)
        {
          this.f = new WebSoPlugin.WebSoJavaScriptObj(this, localCustomWebView);
          localCustomWebView.addJavascriptInterface(this.f, "_webso");
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("js method : ");
            ((StringBuilder)localObject).append(Arrays.toString(this.f.getClass().getDeclaredMethods()));
            QLog.d("WebSoPlugin", 1, ((StringBuilder)localObject).toString());
          }
        }
      }
      else if (paramBundle.getBoolean("is_silent_mode", false))
      {
        QLog.d("WebSoPlugin", 1, "静默加载html");
        paramBundle = this.f;
        if (paramBundle != null) {
          paramBundle.a(str1);
        }
        return;
      }
    }
    if ((!this.i) && (!bool2) && (j != 0))
    {
      this.i = true;
      this.c[0] = true;
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
      paramBundle = this.f;
      if (paramBundle != null) {
        paramBundle.a("{\"code\":0,\"data\":null}");
      }
      this.b = "304";
      a(304);
      return;
    }
    if (this.i)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("webso success load local data, now load new data ! ");
        ((StringBuilder)localObject).append(this.i);
        QLog.i("WebSoPlugin", 1, ((StringBuilder)localObject).toString());
      }
      this.d = true;
    }
    if ((bool2) && (j != 0))
    {
      localCustomWebView.loadUrl(str2);
      a(true);
      return;
    }
    if ((!bool2) && (j != 0))
    {
      if (bool1) {
        paramBundle = WebSoUtils.a(str2, str1);
      } else {
        paramBundle = WebSoUtils.b(str2, str1);
      }
      a(localCustomWebView, str2, paramBundle);
      return;
    }
    if ((!bool2) && (j == 0))
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
        this.b = paramBundle.getString("key_html_changed_data");
        a(200);
      }
    }
    else
    {
      this.d = false;
    }
  }
  
  public static void a(CustomWebView paramCustomWebView, String paramString1, String paramString2)
  {
    WebSoUtils.m("setdata");
    if (TextUtils.isEmpty(paramString1)) {
      QLog.w("WebSoPlugin", 1, "setWebViewData webview url is Empty!");
    }
    if (b(paramCustomWebView))
    {
      paramCustomWebView.setTag(2131442538, paramString2);
      paramCustomWebView.setTag(2131442539, Long.valueOf(System.currentTimeMillis()));
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
    Object localObject = this.mRuntime.d();
    if ((localObject instanceof QBaseActivity))
    {
      localObject = a((QBaseActivity)localObject);
      if ((localObject != null) && (((WebViewFragment)localObject).getUIStyleHandler() != null))
      {
        if (((WebViewFragment)localObject).getUIStyleHandler().w != null)
        {
          ((WebViewFragment)localObject).getUIStyleHandler().C = (paramBoolean ^ true);
          ((WebViewFragment)localObject).getUIStyleHandler().w.a(paramBoolean);
          return;
        }
        ((WebViewFragment)localObject).getUIStyleHandler().C = (paramBoolean ^ true);
        return;
      }
      b(paramBoolean);
      return;
    }
    b(paramBoolean);
  }
  
  private boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    this.i = false;
    this.c[0] = false;
    this.g.a();
    if (paramLong == 32L)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (this.mRuntime == null) {
        return false;
      }
      paramMap = this.mRuntime.d();
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
          if (WebSoUtils.i(paramString)) {
            return false;
          }
          WebSoService.a().a(paramString, this.h, this.c);
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
      if (this.mRuntime.a().getRootView().findViewById(2131450099) == null) {
        return;
      }
      View localView = this.mRuntime.a().getRootView().findViewById(2131450099).findViewById(2131440738);
      if (localView != null)
      {
        int j;
        if (paramBoolean) {
          j = 0;
        } else {
          j = 8;
        }
        localView.setVisibility(j);
      }
    }
  }
  
  public static boolean b(WebView paramWebView)
  {
    return (a(paramWebView) >= 43001) || (Build.VERSION.SDK_INT >= 23);
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
      WebSoUtils.m("KEY_EVENT_BEFORE_LOAD");
      return a(paramString, paramLong, paramMap);
    }
    if (paramLong == 8589934594L)
    {
      WebSoUtils.m("EVENT_LOAD_FINISH");
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
          int j;
          Object localObject;
          if (QLog.isColorLevel())
          {
            j = paramString.getSize() - 1;
            while (j >= 0)
            {
              paramMap = paramString.getItemAtIndex(j);
              if (paramMap != null)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(" EVENT_LOAD_FINISH --- history: ");
                ((StringBuilder)localObject).append(j);
                ((StringBuilder)localObject).append(" ");
                ((StringBuilder)localObject).append(paramMap.getUrl());
                QLog.i("WebSoPlugin", 2, ((StringBuilder)localObject).toString());
              }
              j -= 1;
            }
          }
          if (paramString.getSize() >= 2)
          {
            j = paramString.getSize() - 1;
            localObject = paramString.getItemAtIndex(j);
            paramString = paramString.getItemAtIndex(j - 1);
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
              this.d = true;
            }
          }
          if (!this.d) {
            break label520;
          }
          if (QLog.isColorLevel()) {
            QLog.i("WebSoPlugin", 2, "now clear webview history!");
          }
          localCustomWebView.clearHistory();
          this.d = false;
          return false;
        }
        if (this.d)
        {
          if (localCustomWebView != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("WebSoPlugin", 2, "now clear webview history!");
            }
            localCustomWebView.clearHistory();
          }
          this.d = false;
        }
      }
      return false;
    }
    else if (paramLong == 8589934601L)
    {
      WebSoUtils.m("EVENT_GO_BACK");
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
            if (this.mRuntime.d() != null)
            {
              this.mRuntime.d().finish();
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
            this.a = paramJsBridgeListener;
            if (TextUtils.isEmpty(this.b)) {
              break label504;
            }
            if (this.b.equals("304"))
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
          WebSoUtils.m("js call getData");
          this.g.a(this, paramJsBridgeListener);
          return true;
        }
        if (!"updateWebsoCache".equals(paramString3)) {}
      }
    }
    try
    {
      WebSoUtils.m("js call updateWebsoCache");
      if (this.g.b() != null)
      {
        if (this.mRuntime != null) {
          this.mRuntime.a().loadUrl("javascript:window._webso.catchHtml(document.getElementsByTagName('html')[0].outerHTML);");
        }
        paramString1 = new JSONObject();
        paramString1.put("result", 1);
        super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
        return true;
      }
      WebSoUtils.m("return : webso == null");
      return true;
    }
    catch (Exception paramJsBridgeListener) {}
    if ("updateScreenshot".equals(paramString3))
    {
      WebSoUtils.m("js call updateScreenshot");
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
      WebSoUtils.m("js call hideScreenshot");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.WebSoPlugin
 * JD-Core Version:    0.7.0.1
 */