package com.tencent.mobileqq.apollo.api.handler.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.handler.IApolloWebDataHandler;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl;
import com.tencent.mobileqq.apollo.store.webview.ApolloClientUtil;
import com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig;
import com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig.CGIConfig;
import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor;
import com.tencent.mobileqq.apollo.store.webview.ApolloWebStatistics;
import com.tencent.mobileqq.apollo.store.webview.BridgeStream;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.util.LRULinkedHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class ApolloWebDataHandlerImpl
  implements IApolloWebDataHandler
{
  private static final int DATA_INVALID_INTERVAL = 10000;
  public static final String SP_KEY_DISABLE_THUNDER_CACHE = "sp_key_disable_thunder_cache";
  public static final String SP_KEY_NAME = "sp_apollo_webView";
  public static final String SP_KEY_SSO_CHECK_TIME = "sp_key_sso_check_time";
  public static final String SP_KEY_WEBVIEW_CONFIG_VERSION = "sp_key_apollo_webView_config_version";
  public static final String TAG = "apollo_client_ApolloWebDataHandler";
  private static boolean sDisableCache;
  private final LRULinkedHashMap<String, ApolloWebDataHandlerImpl.WebSSOTask> mPreloadSSODatas = new LRULinkedHashMap(128);
  private ApolloSSOConfig mSSOConfig = new ApolloSSOConfig();
  
  public ApolloWebDataHandlerImpl()
  {
    sDisableCache = BaseApplicationImpl.getApplication().getSharedPreferences("sp_apollo_webView", 4).getBoolean("sp_key_disable_thunder_cache", false);
  }
  
  private ApolloUrlInterceptor getInterceptor(CustomWebView paramCustomWebView)
  {
    if (paramCustomWebView == null) {
      return null;
    }
    paramCustomWebView = paramCustomWebView.getPluginEngine();
    if (paramCustomWebView != null)
    {
      paramCustomWebView = paramCustomWebView.a("apollo");
      if ((paramCustomWebView != null) && ((paramCustomWebView instanceof ApolloJsPluginImpl))) {
        return ((ApolloJsPluginImpl)paramCustomWebView).getInterceptor();
      }
    }
    return null;
  }
  
  private String getMD5FromDb(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      if (this.mSSOConfig == null) {
        return "";
      }
      str = this.mSSOConfig.a(paramString);
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloWebDataHandler", 2, "getMD5FromDb pageId:" + paramString + " md5:" + str);
    return str;
  }
  
  public boolean doInterceptApolloCmd(String paramString1, String paramString2, AppInterface paramAppInterface, WebViewPlugin paramWebViewPlugin)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramWebViewPlugin == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, url=" + paramString1 + " plugin:" + paramWebViewPlugin + " app:" + paramAppInterface + " requestStr:" + paramString2);
      }
      return false;
    }
    if (!NetworkUtil.g(BaseApplicationImpl.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, NetworkUtil.isNetworkAvailable:false");
      }
      return false;
    }
    if ((paramWebViewPlugin.mRuntime == null) || (paramWebViewPlugin.mRuntime.a() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, plugin.mRuntime.getWebView() is null");
      }
      return false;
    }
    if (this.mSSOConfig == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, mSSOConfig is null");
      }
      return false;
    }
    for (;;)
    {
      try
      {
        String str3 = getApolloClientId(paramString1);
        if (TextUtils.isEmpty(str3))
        {
          if (!QLog.isColorLevel()) {
            break label722;
          }
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, url is:" + paramString1 + " no need preload");
          break label722;
        }
        ApolloUrlInterceptor localApolloUrlInterceptor = getInterceptor(paramWebViewPlugin.mRuntime.a());
        if (localApolloUrlInterceptor == null)
        {
          if (!QLog.isColorLevel()) {
            break label724;
          }
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, apolloSession is null");
          break label724;
        }
        JSONObject localJSONObject = new JSONObject(paramString2);
        String str1 = localJSONObject.getString("callback");
        if (TextUtils.isEmpty(str1)) {
          return false;
        }
        String str2 = localJSONObject.getString("cmd");
        if (!this.mSSOConfig.a(str3, str2))
        {
          if (!QLog.isColorLevel()) {
            break label726;
          }
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApollo false, apolloClientId:" + str3 + " cmd:" + str2 + ",mSSOConfig.isValidCmd:false");
          break label726;
        }
        str3 = this.mSSOConfig.a(str3, str2);
        paramString2 = (ApolloWebDataHandlerImpl.WebSSOTask)this.mPreloadSSODatas.get(str3);
        if (paramString2 != null)
        {
          if (ApolloWebDataHandlerImpl.WebSSOTask.a(paramString2))
          {
            if (paramString2.a(str2))
            {
              if (QLog.isColorLevel()) {
                QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApolloCmd, webSSOTask.isValid true, mResultJson=" + paramString2);
              }
              if (ApolloWebDataHandlerImpl.WebSSOTask.a(paramString2) != null)
              {
                ApolloWebDataHandlerImpl.WebSSOTask.a(paramString2).c = System.currentTimeMillis();
                ApolloWebDataHandlerImpl.WebSSOTask.a(paramString2).d = System.currentTimeMillis();
              }
              paramWebViewPlugin.callJs(str1, new String[] { ApolloWebDataHandlerImpl.WebSSOTask.a(paramString2).toString() });
              this.mPreloadSSODatas.remove(str3);
              return true;
            }
            if (QLog.isColorLevel()) {
              QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApolloCmd, webSSOTask.isValid false,webSSOTask:" + paramString2);
            }
            i = 1;
            this.mPreloadSSODatas.remove(str3);
            if (i == 0) {
              break label728;
            }
            if (localApolloUrlInterceptor != null)
            {
              paramString2 = localApolloUrlInterceptor.a();
              paramString2.c = System.currentTimeMillis();
              paramString2 = new ApolloWebDataHandlerImpl.WebSSOTask(paramString2, str3, str2);
              paramString2.a(new ApolloWebDataHandlerImpl.WebDataCallBack(this, str1, paramWebViewPlugin));
              if (paramWebViewPlugin.mRuntime != null) {
                paramString2.a(paramWebViewPlugin.mRuntime.a(), paramString1, localJSONObject, paramAppInterface);
              }
              this.mPreloadSSODatas.put(str3, paramString2);
              break label728;
            }
          }
          else
          {
            if (ApolloWebDataHandlerImpl.WebSSOTask.a(paramString2) != null) {
              ApolloWebDataHandlerImpl.WebSSOTask.a(paramString2).c = System.currentTimeMillis();
            }
            paramString2.a(new ApolloWebDataHandlerImpl.WebDataCallBack(this, str1, paramWebViewPlugin));
            if (!QLog.isColorLevel()) {
              break label716;
            }
            QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApolloCmd, has webSSOTask = true, but webSSOTask.mReceivedSSO:false, wait notify!");
            i = 0;
            continue;
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label730;
          }
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "doInterceptApolloCmd, has webSSOTask = false,create webSSOTask!");
          break label730;
        }
        paramString2 = new ApolloWebStatistics();
        continue;
        i = 0;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return false;
      }
      label716:
      continue;
      label722:
      return false;
      label724:
      return false;
      label726:
      return false;
      label728:
      return true;
      label730:
      int i = 1;
    }
  }
  
  public String getApolloClientId(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString.isHierarchical())
      {
        paramString = paramString.getQueryParameter("thunder_id");
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("apollo_client_ApolloWebDataHandler", 2, paramString.getMessage());
    }
    return null;
  }
  
  public WebResourceResponse getApolloCmdResource(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    if (this.mSSOConfig == null) {
      return null;
    }
    if ((paramString1.contains("http://cmshow.qq.com/get_thunder_data?cmd=")) || (paramString1.contains("https://cmshow.qq.com/get_thunder_data?cmd=")))
    {
      Object localObject = "http://cmshow.qq.com/get_thunder_data?cmd=";
      if (paramString1.contains("https://cmshow.qq.com/get_thunder_data?cmd=")) {
        localObject = "https://cmshow.qq.com/get_thunder_data?cmd=";
      }
      paramString1 = paramString1.substring(((String)localObject).length());
      if (!this.mSSOConfig.a(paramString2, paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "getApolloCmdResource false, apolloClientId:" + paramString2 + " cmd:" + paramString1 + ",mSSOConfig.isValidCmd:false");
        }
        return null;
      }
      paramString2 = this.mSSOConfig.a(paramString2, paramString1);
      localObject = (ApolloWebDataHandlerImpl.WebSSOTask)this.mPreloadSSODatas.get(paramString2);
      if (localObject != null) {
        if (ApolloWebDataHandlerImpl.WebSSOTask.a((ApolloWebDataHandlerImpl.WebSSOTask)localObject))
        {
          if (((ApolloWebDataHandlerImpl.WebSSOTask)localObject).a(paramString1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollo_client_ApolloWebDataHandler", 2, "getApolloCmdResource, webSSOTask.isValid true, webSSOTask=" + localObject);
            }
            if (ApolloWebDataHandlerImpl.WebSSOTask.a((ApolloWebDataHandlerImpl.WebSSOTask)localObject) != null)
            {
              ApolloWebDataHandlerImpl.WebSSOTask.a((ApolloWebDataHandlerImpl.WebSSOTask)localObject).c = System.currentTimeMillis();
              ApolloWebDataHandlerImpl.WebSSOTask.a((ApolloWebDataHandlerImpl.WebSSOTask)localObject).d = System.currentTimeMillis();
            }
            paramString1 = new WebResourceResponse("text/plain", "utf-8", ApolloClientUtil.a(ApolloWebDataHandlerImpl.WebSSOTask.a((ApolloWebDataHandlerImpl.WebSSOTask)localObject).toString()));
            this.mPreloadSSODatas.remove(paramString2);
            return paramString1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("apollo_client_ApolloWebDataHandler", 2, "getApolloCmdResource, webSSOTask.isValid false,webSSOTask:" + localObject);
          }
          this.mPreloadSSODatas.remove(paramString2);
        }
      }
      for (;;)
      {
        return new WebResourceResponse("text/plain", "utf-8", new BridgeStream(null, null, null));
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "getApolloCmdResource, has webSSOTask = false");
        }
      }
    }
    return null;
  }
  
  public List<ApolloSSOConfig.CGIConfig> getCGIConfigs(String paramString)
  {
    if (this.mSSOConfig != null) {
      return this.mSSOConfig.a(paramString);
    }
    return null;
  }
  
  public void initInAsyncThreadIfNeed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "apollo_client initInAsyncThread");
    }
    ThreadManager.postImmediately(new ApolloWebDataHandlerImpl.1(this), null, true);
  }
  
  public boolean isApolloClientId(String paramString)
  {
    if (((IApolloUtil)QRoute.api(IApolloUtil.class)).isApolloProxyEnable())
    {
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "isApolloClientId, ApolloUtil.isApolloProxyEnable() return");
      return false;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "isApolloClientId, apolloClientId:" + paramString);
      }
      if (this.mSSOConfig != null) {
        return this.mSSOConfig.a(paramString);
      }
    }
    return false;
  }
  
  public boolean isCmdResourceUrl(String paramString)
  {
    return (paramString.contains("http://cmshow.qq.com/get_thunder_data?cmd=")) || (paramString.contains("https://cmshow.qq.com/get_thunder_data?cmd="));
  }
  
  public void preLoadSSOCmd(Context paramContext, String paramString1, String paramString2, AppInterface paramAppInterface, ApolloWebStatistics paramApolloWebStatistics)
  {
    if ((TextUtils.isEmpty(paramString1)) || (this.mSSOConfig == null)) {}
    for (;;)
    {
      return;
      if (!NetworkUtil.g(paramContext))
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "preLoadSSOCmd false, NetworkUtil.isNetworkAvailable:false");
        }
      }
      else
      {
        this.mSSOConfig.a(paramAppInterface);
        Object localObject1 = this.mSSOConfig.a(paramString1);
        if ((localObject1 == null) || (((Set)localObject1).isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollo_client_ApolloWebDataHandler", 2, "preloadSSOCmd, apolloClientId:" + paramString1 + " cmds is null or empty");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollo_client_ApolloWebDataHandler", 2, "preloadSSOCmd, apolloClientId:" + paramString1 + " print all task:" + this.mPreloadSSODatas);
          }
          localObject1 = ((Set)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (String)((Iterator)localObject1).next();
            String str = this.mSSOConfig.a(paramString1, (String)localObject2);
            ApolloWebDataHandlerImpl.WebSSOTask localWebSSOTask = (ApolloWebDataHandlerImpl.WebSSOTask)this.mPreloadSSODatas.get(str);
            if ((localWebSSOTask != null) && (localWebSSOTask.a((String)localObject2)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("apollo_client_ApolloWebDataHandler", 2, "preloadSSOCmd, apolloClientId:" + paramString1 + " mPreloadSSOCmds.has WebSSOTask:" + localWebSSOTask);
              }
            }
            else
            {
              this.mPreloadSSODatas.remove(str);
              localWebSSOTask = new ApolloWebDataHandlerImpl.WebSSOTask(paramApolloWebStatistics, str, (String)localObject2);
              this.mPreloadSSODatas.put(str, localWebSSOTask);
              localObject2 = this.mSSOConfig.a(paramString2, paramString1, (String)localObject2, paramAppInterface);
              if (QLog.isColorLevel()) {
                QLog.d("apollo_client_ApolloWebDataHandler", 2, "preloadSSOCmd, apolloClientId:" + paramString1 + " create new WebSSOTask, requestJson" + localObject2);
              }
              if (localObject2 != null) {
                localWebSSOTask.a(paramContext, paramString2, (JSONObject)localObject2, paramAppInterface);
              }
            }
          }
        }
      }
    }
  }
  
  public void resumeThunderCache()
  {
    sDisableCache = false;
    BaseApplicationImpl.getApplication().getSharedPreferences("sp_apollo_webView", 4).edit().putBoolean("sp_key_disable_thunder_cache", false).commit();
  }
  
  public boolean saveHtml(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    int i = paramString1.indexOf("?");
    String str = paramString1;
    if (i != -1) {
      str = paramString1.substring(0, i);
    }
    ApolloClientUtil.a(ApolloClientUtil.d(ApolloClientUtil.e(str)), paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "saveHtml url:" + str + " html.length:" + paramString2.length());
    }
    return true;
  }
  
  public void stopThunderCache()
  {
    sDisableCache = true;
    BaseApplicationImpl.getApplication().getSharedPreferences("sp_apollo_webView", 4).edit().putBoolean("sp_key_disable_thunder_cache", true).commit();
  }
  
  public boolean verifyCache(String paramString1, String paramString2)
  {
    if (sDisableCache) {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "verifyCache, sDisableCache:" + sDisableCache);
      }
    }
    String str;
    do
    {
      do
      {
        return false;
      } while ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)));
      str = ApolloClientUtil.b(paramString2);
      paramString1 = getMD5FromDb(paramString1);
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(str)) && (str.toUpperCase().equals(paramString1.toUpperCase()))) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloWebDataHandler", 2, "verifyMd5 false:" + paramString1 + " contentMd5:" + str + ",configMd5:" + paramString1 + " html.length:" + paramString2.length());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.handler.impl.ApolloWebDataHandlerImpl
 * JD-Core Version:    0.7.0.1
 */