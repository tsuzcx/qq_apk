package com.tencent.mobileqq.apollo.web.jsmodule;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.ApiReportData;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class BaseJsModule
{
  private VasWebviewJsPlugin a;
  protected HashMap<String, ApolloJsPluginImpl.ApiReportData> a;
  
  public BaseJsModule(VasWebviewJsPlugin paramVasWebviewJsPlugin)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin = paramVasWebviewJsPlugin;
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin.callJs(paramString);
  }
  
  private void c(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1))
    {
      ApolloJsPluginImpl.ApiReportData localApiReportData = (ApolloJsPluginImpl.ApiReportData)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      if (localApiReportData != null)
      {
        int j = a(localApiReportData.jdField_a_of_type_JavaLangString);
        if (j > 0)
        {
          int i;
          if ("ok".equals(paramString2)) {
            i = 0;
          } else {
            i = -1;
          }
          TraceReportUtil.a(131, j, i, new Object[] { paramString2 });
          TraceReportUtil.b(131);
        }
        ApolloQualityReportUtil.a("dressup_js_api", String.valueOf(System.currentTimeMillis() - localApiReportData.jdField_a_of_type_Long), localApiReportData.jdField_a_of_type_JavaLangString, paramString2);
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
    }
  }
  
  protected int a(String paramString)
  {
    if ("change3DAvatarComponent".equals(paramString))
    {
      if (CmShowWnsUtils.w()) {
        return 2;
      }
      return 1;
    }
    return -1;
  }
  
  @Deprecated
  protected Bundle a(String paramString1, String paramString2, Bundle paramBundle)
  {
    return DataFactory.a(paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin.mOnRemoteResp.key, paramBundle);
  }
  
  protected WebViewFragment a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin.mRuntime != null) {
      return (WebViewFragment)this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin.mRuntime.a();
    }
    return null;
  }
  
  public WebViewPlugin.PluginRuntime a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin.mRuntime;
  }
  
  @Deprecated
  protected void a(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin.sendRemoteReq(paramBundle, paramBoolean1, paramBoolean2);
  }
  
  protected void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 0);
      localJSONObject.put("msg", "");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("&&");
      localStringBuilder.append(paramString);
      localStringBuilder.append("(");
      localStringBuilder.append(localJSONObject.toString());
      localStringBuilder.append(");");
      b(localStringBuilder.toString());
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("callbackId->");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" callbackOk");
        localStringBuilder.append(localJSONObject.toString());
        QLog.d("[cmshow]BaseJsModule", 2, localStringBuilder.toString());
      }
      c(paramString, "ok");
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[cmshow]BaseJsModule", 1, paramString.getMessage());
    }
  }
  
  protected void a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", paramInt);
      localJSONObject.put("msg", paramString2);
      a(paramString1, localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("[cmshow]BaseJsModule", 1, paramString1.getMessage());
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 1);
      localJSONObject.put("msg", paramString2);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString1);
      localStringBuilder2.append("&&");
      localStringBuilder2.append(paramString1);
      localStringBuilder2.append("(");
      localStringBuilder2.append(localJSONObject.toString());
      localStringBuilder2.append(");");
      b(localStringBuilder2.toString());
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]BaseJsModule", 1, localException.getMessage());
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("callbackId->");
    localStringBuilder1.append(paramString1);
    localStringBuilder1.append(" errorMsg: ");
    localStringBuilder1.append(paramString2);
    QLog.e("[cmshow]BaseJsModule", 2, localStringBuilder1.toString());
    c(paramString1, paramString2);
  }
  
  protected void a(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 0);
      localJSONObject.put("msg", "");
      if (paramJSONObject != null) {
        localJSONObject.put("data", paramJSONObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqVaswebviewpluginVasWebviewJsPlugin.callJs(paramString, new String[] { localJSONObject.toString() });
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("callbackId->");
        paramJSONObject.append(paramString);
        paramJSONObject.append(" callbackOk");
        paramJSONObject.append(localJSONObject.toString());
        QLog.d("[cmshow]BaseJsModule", 2, paramJSONObject.toString());
      }
      c(paramString, "ok");
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("[cmshow]BaseJsModule", 1, paramString.getMessage());
    }
  }
  
  protected void b(String paramString1, String paramString2)
  {
    ApolloJsPluginImpl.ApiReportData localApiReportData = new ApolloJsPluginImpl.ApiReportData(paramString1, System.currentTimeMillis());
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString2, localApiReportData);
    int i = a(paramString1);
    if (i > 0)
    {
      TraceReportUtil.a(131);
      TraceReportUtil.a(131, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.BaseJsModule
 * JD-Core Version:    0.7.0.1
 */