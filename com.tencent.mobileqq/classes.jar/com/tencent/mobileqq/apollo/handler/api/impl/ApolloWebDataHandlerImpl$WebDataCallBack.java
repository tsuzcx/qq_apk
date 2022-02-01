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
  public WeakReference<WebViewPlugin> a;
  private WeakReference<ApolloWebDataHandlerImpl> b;
  
  public ApolloWebDataHandlerImpl$WebDataCallBack(ApolloWebDataHandlerImpl paramApolloWebDataHandlerImpl, String paramString, WebViewPlugin paramWebViewPlugin)
  {
    this.b = new WeakReference(paramApolloWebDataHandlerImpl);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebViewPlugin);
  }
  
  public void a(ApolloWebDataHandlerImpl.WebSSOTask paramWebSSOTask, ApolloWebStatistics paramApolloWebStatistics)
  {
    ApolloWebDataHandlerImpl localApolloWebDataHandlerImpl = (ApolloWebDataHandlerImpl)this.b.get();
    if ((localApolloWebDataHandlerImpl != null) && (paramWebSSOTask != null))
    {
      WebViewPlugin localWebViewPlugin = (WebViewPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localWebViewPlugin != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        if (paramApolloWebStatistics != null) {
          paramApolloWebStatistics.d = System.currentTimeMillis();
        }
        if (ApolloWebDataHandlerImpl.WebSSOTask.a(paramWebSSOTask) != null) {
          localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { ApolloWebDataHandlerImpl.WebSSOTask.a(paramWebSSOTask).toString() });
        } else {
          localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
        }
        if (QLog.isColorLevel())
        {
          paramApolloWebStatistics = new StringBuilder();
          paramApolloWebStatistics.append("WebDataCallBack, onSSOCallBack, plugin.callJs.mResultJson:");
          paramApolloWebStatistics.append(ApolloWebDataHandlerImpl.WebSSOTask.a(paramWebSSOTask));
          QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, paramApolloWebStatistics.toString());
        }
      }
      if (ApolloWebDataHandlerImpl.access$300(localApolloWebDataHandlerImpl) != null)
      {
        ApolloWebDataHandlerImpl.access$300(localApolloWebDataHandlerImpl).remove(ApolloWebDataHandlerImpl.WebSSOTask.a(paramWebSSOTask));
        if (QLog.isColorLevel())
        {
          paramApolloWebStatistics = new StringBuilder();
          paramApolloWebStatistics.append("WebDataCallBack, onSSOCallBack, remove sso from mPreloadSSODatas:");
          paramApolloWebStatistics.append(ApolloWebDataHandlerImpl.WebSSOTask.a(paramWebSSOTask));
          QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, paramApolloWebStatistics.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.api.impl.ApolloWebDataHandlerImpl.WebDataCallBack
 * JD-Core Version:    0.7.0.1
 */