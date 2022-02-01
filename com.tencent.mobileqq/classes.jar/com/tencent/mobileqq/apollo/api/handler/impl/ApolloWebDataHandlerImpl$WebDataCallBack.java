package com.tencent.mobileqq.apollo.api.handler.impl;

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
    WebViewPlugin localWebViewPlugin;
    if ((localApolloWebDataHandlerImpl != null) && (paramWebSSOTask != null))
    {
      localWebViewPlugin = (WebViewPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localWebViewPlugin != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        if (paramApolloWebStatistics != null) {
          paramApolloWebStatistics.d = System.currentTimeMillis();
        }
        if (ApolloWebDataHandlerImpl.WebSSOTask.a(paramWebSSOTask) == null) {
          break label175;
        }
        localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { ApolloWebDataHandlerImpl.WebSSOTask.a(paramWebSSOTask).toString() });
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, plugin.callJs.mResultJson:" + ApolloWebDataHandlerImpl.WebSSOTask.a(paramWebSSOTask));
      }
      if (ApolloWebDataHandlerImpl.access$300(localApolloWebDataHandlerImpl) != null)
      {
        ApolloWebDataHandlerImpl.access$300(localApolloWebDataHandlerImpl).remove(ApolloWebDataHandlerImpl.WebSSOTask.a(paramWebSSOTask));
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, remove sso from mPreloadSSODatas:" + ApolloWebDataHandlerImpl.WebSSOTask.a(paramWebSSOTask));
        }
      }
      return;
      label175:
      localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.handler.impl.ApolloWebDataHandlerImpl.WebDataCallBack
 * JD-Core Version:    0.7.0.1
 */