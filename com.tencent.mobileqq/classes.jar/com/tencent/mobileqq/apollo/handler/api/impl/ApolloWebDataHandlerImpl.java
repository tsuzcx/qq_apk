package com.tencent.mobileqq.apollo.handler.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.handler.api.IApolloWebDataHandler;
import com.tencent.mobileqq.apollo.store.webview.ApolloClientUtil;
import com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig;
import com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig.CGIConfig;
import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor;
import com.tencent.mobileqq.apollo.store.webview.ApolloWebStatistics;
import com.tencent.mobileqq.apollo.store.webview.BridgeStream;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
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
  public static final String TAG = "[cmshow]apollo_client_ApolloWebDataHandler";
  private static boolean sDisableCache;
  private final LRULinkedHashMap<String, ApolloWebDataHandlerImpl.WebSSOTask> mPreloadSSODatas = new LRULinkedHashMap(128);
  private ApolloSSOConfig mSSOConfig = new ApolloSSOConfig();
  
  public ApolloWebDataHandlerImpl()
  {
    sDisableCache = BaseApplicationImpl.getApplication().getSharedPreferences("sp_apollo_webView", 4).getBoolean("sp_key_disable_thunder_cache", false);
  }
  
  private void colorLogD(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, paramString);
    }
  }
  
  private ApolloUrlInterceptor getInterceptor(CustomWebView paramCustomWebView)
  {
    if (paramCustomWebView == null) {
      return null;
    }
    paramCustomWebView = paramCustomWebView.getPluginEngine();
    if (paramCustomWebView != null)
    {
      paramCustomWebView = paramCustomWebView.b("apollo");
      if ((paramCustomWebView != null) && ((paramCustomWebView instanceof ApolloJsPluginImpl))) {
        return ((ApolloJsPluginImpl)paramCustomWebView).getInterceptor();
      }
    }
    return null;
  }
  
  private String getMD5FromDb(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject = this.mSSOConfig;
    if (localObject == null) {
      return "";
    }
    localObject = ((ApolloSSOConfig)localObject).a(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMD5FromDb pageId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" md5:");
      localStringBuilder.append((String)localObject);
      QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  private boolean shouldInterceptSsoCmd(String paramString1, WebViewPlugin paramWebViewPlugin, String paramString2, AppInterface paramAppInterface)
  {
    for (;;)
    {
      try
      {
        String str3 = getApolloClientId(paramString1);
        if (TextUtils.isEmpty(str3))
        {
          paramWebViewPlugin = new StringBuilder();
          paramWebViewPlugin.append("doInterceptApollo false, url is:");
          paramWebViewPlugin.append(paramString1);
          paramWebViewPlugin.append(" no need preload");
          colorLogD(paramWebViewPlugin.toString());
          return false;
        }
        ApolloUrlInterceptor localApolloUrlInterceptor = getInterceptor(paramWebViewPlugin.mRuntime.a());
        if (localApolloUrlInterceptor == null)
        {
          colorLogD("doInterceptApollo false, apolloSession is null");
          return false;
        }
        JSONObject localJSONObject = new JSONObject(paramString2);
        String str1 = localJSONObject.getString("callback");
        if (TextUtils.isEmpty(str1)) {
          return false;
        }
        String str2 = localJSONObject.getString("cmd");
        if (!this.mSSOConfig.a(str3, str2))
        {
          paramString1 = new StringBuilder();
          paramString1.append("doInterceptApollo false, apolloClientId:");
          paramString1.append(str3);
          paramString1.append(" cmd:");
          paramString1.append(str2);
          paramString1.append(",mSSOConfig.isValidCmd:false");
          colorLogD(paramString1.toString());
          return false;
        }
        str3 = this.mSSOConfig.b(str3, str2);
        paramString2 = (ApolloWebDataHandlerImpl.WebSSOTask)this.mPreloadSSODatas.get(str3);
        if (paramString2 != null)
        {
          if (ApolloWebDataHandlerImpl.WebSSOTask.a(paramString2))
          {
            if (paramString2.a(str2))
            {
              paramString1 = new StringBuilder();
              paramString1.append("doInterceptApolloCmd, webSSOTask.isValid true, mResultJson=");
              paramString1.append(paramString2);
              colorLogD(paramString1.toString());
              if (ApolloWebDataHandlerImpl.WebSSOTask.b(paramString2) != null)
              {
                ApolloWebDataHandlerImpl.WebSSOTask.b(paramString2).c = System.currentTimeMillis();
                ApolloWebDataHandlerImpl.WebSSOTask.b(paramString2).d = System.currentTimeMillis();
              }
              paramWebViewPlugin.callJs(str1, new String[] { ApolloWebDataHandlerImpl.WebSSOTask.c(paramString2).toString() });
              this.mPreloadSSODatas.remove(str3);
              return true;
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("doInterceptApolloCmd, webSSOTask.isValid false,webSSOTask:");
            localStringBuilder.append(paramString2);
            colorLogD(localStringBuilder.toString());
            this.mPreloadSSODatas.remove(str3);
            break label522;
          }
          if (ApolloWebDataHandlerImpl.WebSSOTask.b(paramString2) != null) {
            ApolloWebDataHandlerImpl.WebSSOTask.b(paramString2).c = System.currentTimeMillis();
          }
          paramString2.a(new ApolloWebDataHandlerImpl.WebDataCallBack(this, str1, paramWebViewPlugin));
          colorLogD("doInterceptApolloCmd, has webSSOTask = true, but webSSOTask.mReceivedSSO:false, wait notify!");
          i = 0;
        }
        else
        {
          colorLogD("doInterceptApolloCmd, has webSSOTask = false,create webSSOTask!");
          break label522;
        }
        if (i != 0)
        {
          if (localApolloUrlInterceptor != null) {
            paramString2 = localApolloUrlInterceptor.b();
          } else {
            paramString2 = new ApolloWebStatistics();
          }
          paramString2.c = System.currentTimeMillis();
          paramString2 = new ApolloWebDataHandlerImpl.WebSSOTask(paramString2, str3, str2);
          paramString2.a(new ApolloWebDataHandlerImpl.WebDataCallBack(this, str1, paramWebViewPlugin));
          if (paramWebViewPlugin.mRuntime != null) {
            paramString2.a(paramWebViewPlugin.mRuntime.d(), paramString1, localJSONObject, paramAppInterface);
          }
          this.mPreloadSSODatas.put(str3, paramString2);
        }
        return true;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return false;
      }
      label522:
      int i = 1;
    }
  }
  
  public boolean doInterceptApolloCmd(String paramString1, String paramString2, AppInterface paramAppInterface, Object paramObject)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!(paramObject instanceof WebViewPlugin))
      {
        colorLogD("doInterceptApollo false, webViewPluginObj is not instanceof WebViewPlugin");
        return false;
      }
      paramObject = (WebViewPlugin)paramObject;
      if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
      {
        colorLogD("doInterceptApollo false, NetworkUtil.isNetworkAvailable:false");
        return false;
      }
      if ((paramObject.mRuntime != null) && (paramObject.mRuntime.a() != null))
      {
        if (this.mSSOConfig == null)
        {
          colorLogD("doInterceptApollo false, mSSOConfig is null");
          return false;
        }
        return shouldInterceptSsoCmd(paramString1, paramObject, paramString2, paramAppInterface);
      }
      colorLogD("doInterceptApollo false, plugin.mRuntime.getWebView() is null");
      return false;
    }
    paramObject = new StringBuilder();
    paramObject.append("doInterceptApollo false, url=");
    paramObject.append(paramString1);
    paramObject.append(" app:");
    paramObject.append(paramAppInterface);
    paramObject.append(" requestStr:");
    paramObject.append(paramString2);
    colorLogD(paramObject.toString());
    return false;
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
      QLog.e("[cmshow]apollo_client_ApolloWebDataHandler", 2, paramString.getMessage());
    }
    return null;
  }
  
  public WebResourceResponse getApolloCmdResource(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      if (this.mSSOConfig == null) {
        return null;
      }
      Object localObject = "http://cmshow.qq.com/get_thunder_data?cmd=";
      if ((!paramString1.contains("http://cmshow.qq.com/get_thunder_data?cmd=")) && (!paramString1.contains("https://cmshow.qq.com/get_thunder_data?cmd="))) {
        return null;
      }
      if (paramString1.contains("https://cmshow.qq.com/get_thunder_data?cmd=")) {
        localObject = "https://cmshow.qq.com/get_thunder_data?cmd=";
      }
      localObject = paramString1.substring(((String)localObject).length());
      if (!this.mSSOConfig.a(paramString2, (String)localObject))
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("getApolloCmdResource false, apolloClientId:");
          paramString1.append(paramString2);
          paramString1.append(" cmd:");
          paramString1.append((String)localObject);
          paramString1.append(",mSSOConfig.isValidCmd:false");
          QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, paramString1.toString());
        }
        return null;
      }
      paramString1 = this.mSSOConfig.b(paramString2, (String)localObject);
      paramString2 = (ApolloWebDataHandlerImpl.WebSSOTask)this.mPreloadSSODatas.get(paramString1);
      if (paramString2 != null)
      {
        if (ApolloWebDataHandlerImpl.WebSSOTask.a(paramString2))
        {
          if (paramString2.a((String)localObject))
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("getApolloCmdResource, webSSOTask.isValid true, webSSOTask=");
              ((StringBuilder)localObject).append(paramString2);
              QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, ((StringBuilder)localObject).toString());
            }
            if (ApolloWebDataHandlerImpl.WebSSOTask.b(paramString2) != null)
            {
              ApolloWebDataHandlerImpl.WebSSOTask.b(paramString2).c = System.currentTimeMillis();
              ApolloWebDataHandlerImpl.WebSSOTask.b(paramString2).d = System.currentTimeMillis();
            }
            paramString2 = new WebResourceResponse("text/plain", "utf-8", ApolloClientUtil.c(ApolloWebDataHandlerImpl.WebSSOTask.c(paramString2).toString()));
            this.mPreloadSSODatas.remove(paramString1);
            return paramString2;
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getApolloCmdResource, webSSOTask.isValid false,webSSOTask:");
            ((StringBuilder)localObject).append(paramString2);
            QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, ((StringBuilder)localObject).toString());
          }
          this.mPreloadSSODatas.remove(paramString1);
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, "getApolloCmdResource, has webSSOTask = false");
      }
      return new WebResourceResponse("text/plain", "utf-8", new BridgeStream(null, null, null));
    }
    return null;
  }
  
  public List<ApolloSSOConfig.CGIConfig> getCGIConfigs(String paramString)
  {
    ApolloSSOConfig localApolloSSOConfig = this.mSSOConfig;
    if (localApolloSSOConfig != null) {
      return localApolloSSOConfig.d(paramString);
    }
    return null;
  }
  
  public void initInAsyncThreadIfNeed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, "apollo_client initInAsyncThread");
    }
    ThreadManager.postImmediately(new ApolloWebDataHandlerImpl.1(this), null, true);
  }
  
  public boolean isApolloClientId(String paramString)
  {
    if (((IApolloUtil)QRoute.api(IApolloUtil.class)).isApolloProxyEnable())
    {
      QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, "isApolloClientId, ApolloUtil.isApolloProxyEnable() return");
      return false;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isApolloClientId, apolloClientId:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.mSSOConfig;
      if (localObject != null) {
        return ((ApolloSSOConfig)localObject).b(paramString);
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
    if (!TextUtils.isEmpty(paramString1))
    {
      if (this.mSSOConfig == null) {
        return;
      }
      if (!NetworkUtil.isNetworkAvailable(paramContext))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, "preLoadSSOCmd false, NetworkUtil.isNetworkAvailable:false");
        }
        return;
      }
      this.mSSOConfig.a(paramAppInterface);
      Object localObject1 = this.mSSOConfig.c(paramString1);
      if ((localObject1 != null) && (!((Set)localObject1).isEmpty()))
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("preloadSSOCmd, apolloClientId:");
          ((StringBuilder)localObject2).append(paramString1);
          ((StringBuilder)localObject2).append(" print all task:");
          ((StringBuilder)localObject2).append(this.mPreloadSSODatas);
          QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, ((StringBuilder)localObject2).toString());
        }
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (String)((Iterator)localObject1).next();
          Object localObject4 = this.mSSOConfig.b(paramString1, (String)localObject3);
          localObject2 = (ApolloWebDataHandlerImpl.WebSSOTask)this.mPreloadSSODatas.get(localObject4);
          if ((localObject2 != null) && (((ApolloWebDataHandlerImpl.WebSSOTask)localObject2).a((String)localObject3)))
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("preloadSSOCmd, apolloClientId:");
              ((StringBuilder)localObject3).append(paramString1);
              ((StringBuilder)localObject3).append(" mPreloadSSOCmds.has WebSSOTask:");
              ((StringBuilder)localObject3).append(localObject2);
              QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, ((StringBuilder)localObject3).toString());
            }
          }
          else
          {
            this.mPreloadSSODatas.remove(localObject4);
            localObject2 = new ApolloWebDataHandlerImpl.WebSSOTask(paramApolloWebStatistics, (String)localObject4, (String)localObject3);
            this.mPreloadSSODatas.put(localObject4, localObject2);
            localObject3 = this.mSSOConfig.a(paramString2, paramString1, (String)localObject3, paramAppInterface);
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("preloadSSOCmd, apolloClientId:");
              ((StringBuilder)localObject4).append(paramString1);
              ((StringBuilder)localObject4).append(" create new WebSSOTask, requestJson");
              ((StringBuilder)localObject4).append(localObject3);
              QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, ((StringBuilder)localObject4).toString());
            }
            if (localObject3 != null) {
              ((ApolloWebDataHandlerImpl.WebSSOTask)localObject2).a(paramContext, paramString2, (JSONObject)localObject3, paramAppInterface);
            }
          }
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("preloadSSOCmd, apolloClientId:");
        paramContext.append(paramString1);
        paramContext.append(" cmds is null or empty");
        QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, paramContext.toString());
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
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      int i = paramString1.indexOf("?");
      String str = paramString1;
      if (i != -1) {
        str = paramString1.substring(0, i);
      }
      FileUtils.writeFile(ApolloClientUtil.e(ApolloClientUtil.f(str)), paramString2);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("saveHtml url:");
        paramString1.append(str);
        paramString1.append(" html.length:");
        paramString1.append(paramString2.length());
        QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, paramString1.toString());
      }
      return true;
    }
    return false;
  }
  
  public void stopThunderCache()
  {
    sDisableCache = true;
    BaseApplicationImpl.getApplication().getSharedPreferences("sp_apollo_webView", 4).edit().putBoolean("sp_key_disable_thunder_cache", true).commit();
  }
  
  public boolean verifyCache(String paramString1, String paramString2)
  {
    if (sDisableCache)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("verifyCache, sDisableCache:");
        paramString1.append(sDisableCache);
        QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, paramString1.toString());
      }
      return false;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      String str = ApolloClientUtil.b(paramString2);
      paramString1 = getMD5FromDb(paramString1);
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(str)) && (str.toUpperCase().equals(paramString1.toUpperCase()))) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("verifyMd5 false:");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" contentMd5:");
        localStringBuilder.append(str);
        localStringBuilder.append(",configMd5:");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" html.length:");
        localStringBuilder.append(paramString2.length());
        QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, localStringBuilder.toString());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.api.impl.ApolloWebDataHandlerImpl
 * JD-Core Version:    0.7.0.1
 */