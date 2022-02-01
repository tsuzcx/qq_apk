package com.tencent.mobileqq.apollo.handler.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.store.webview.ApolloWebStatistics;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class ApolloWebDataHandlerImpl$WebDataCallBack
{
  public String a;
  public WeakReference<WebViewPlugin> b;
  private WeakReference<ApolloWebDataHandlerImpl> c;
  
  public ApolloWebDataHandlerImpl$WebDataCallBack(ApolloWebDataHandlerImpl paramApolloWebDataHandlerImpl, String paramString, WebViewPlugin paramWebViewPlugin)
  {
    this.c = new WeakReference(paramApolloWebDataHandlerImpl);
    this.a = paramString;
    this.b = new WeakReference(paramWebViewPlugin);
  }
  
  public void a(ApolloWebDataHandlerImpl.WebSSOTask paramWebSSOTask, ApolloWebStatistics paramApolloWebStatistics)
  {
    ApolloWebDataHandlerImpl localApolloWebDataHandlerImpl = (ApolloWebDataHandlerImpl)this.c.get();
    if ((localApolloWebDataHandlerImpl != null) && (paramWebSSOTask != null))
    {
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)this.b.get();
      if ((localWebViewPlugin != null) && (!TextUtils.isEmpty(this.a)))
      {
        if (paramApolloWebStatistics != null) {
          paramApolloWebStatistics.d = System.currentTimeMillis();
        }
        if (ApolloWebDataHandlerImpl.WebSSOTask.c(paramWebSSOTask) != null) {
          localWebViewPlugin.callJs(this.a, new String[] { ApolloWebDataHandlerImpl.WebSSOTask.c(paramWebSSOTask).toString() });
        } else {
          localWebViewPlugin.callJs(this.a, new String[] { "" });
        }
        if (QLog.isColorLevel())
        {
          paramApolloWebStatistics = new StringBuilder();
          paramApolloWebStatistics.append("WebDataCallBack, onSSOCallBack, plugin.callJs.mResultJson:");
          paramApolloWebStatistics.append(ApolloWebDataHandlerImpl.WebSSOTask.c(paramWebSSOTask));
          QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, paramApolloWebStatistics.toString());
        }
      }
      if (ApolloWebDataHandlerImpl.access$300(localApolloWebDataHandlerImpl) != null)
      {
        ApolloWebDataHandlerImpl.access$300(localApolloWebDataHandlerImpl).remove(ApolloWebDataHandlerImpl.WebSSOTask.d(paramWebSSOTask));
        if (QLog.isColorLevel())
        {
          paramApolloWebStatistics = new StringBuilder();
          paramApolloWebStatistics.append("WebDataCallBack, onSSOCallBack, remove sso from mPreloadSSODatas:");
          paramApolloWebStatistics.append(ApolloWebDataHandlerImpl.WebSSOTask.d(paramWebSSOTask));
          QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, paramApolloWebStatistics.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.api.impl.ApolloWebDataHandlerImpl.WebDataCallBack
 * JD-Core Version:    0.7.0.1
 */