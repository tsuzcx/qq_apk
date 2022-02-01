package com.tencent.mobileqq.apollo.web.jsmodule;

import android.app.Activity;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.store.ApolloStoreViewController;
import com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl;
import com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.ApiReportData;
import com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.CmStoreUserInfo;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class BaseJsModule
{
  protected HashMap<String, ApolloJsPluginImpl.ApiReportData> a = new HashMap();
  private VasWebviewJsPlugin b;
  
  public BaseJsModule(VasWebviewJsPlugin paramVasWebviewJsPlugin)
  {
    this.b = paramVasWebviewJsPlugin;
  }
  
  private void c(String paramString1, String paramString2)
  {
    if (!this.a.containsKey(paramString1)) {
      return;
    }
    ApolloJsPluginImpl.ApiReportData localApiReportData = (ApolloJsPluginImpl.ApiReportData)this.a.get(paramString1);
    this.a.remove(paramString1);
    if (localApiReportData == null) {
      return;
    }
    int j = c(localApiReportData.a);
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
    ApolloQualityReportUtil.a("dressup_js_api", String.valueOf(System.currentTimeMillis() - localApiReportData.b), localApiReportData.a, paramString2);
  }
  
  public WebViewPlugin.PluginRuntime a()
  {
    return this.b.mRuntime;
  }
  
  protected <T> T a(int paramInt)
  {
    return this.b.getBrowserComponent(paramInt);
  }
  
  protected void a(ApolloStoreViewController paramApolloStoreViewController)
  {
    ((ApolloJsPluginImpl)this.b).setApolloStoreViewController(paramApolloStoreViewController);
  }
  
  protected void a(ApolloJsPluginImpl.CmStoreUserInfo paramCmStoreUserInfo)
  {
    ((ApolloJsPluginImpl)this.b).setCmStoreUserInfo(paramCmStoreUserInfo);
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
      d(localStringBuilder2.toString());
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
      this.b.callJs(paramString, new String[] { localJSONObject.toString() });
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
  
  protected WebViewFragment b()
  {
    if (this.b.mRuntime != null) {
      return (WebViewFragment)this.b.mRuntime.f();
    }
    return null;
  }
  
  protected void b(String paramString)
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
      d(localStringBuilder.toString());
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
  
  protected void b(String paramString1, String paramString2)
  {
    ApolloJsPluginImpl.ApiReportData localApiReportData = new ApolloJsPluginImpl.ApiReportData(paramString1, System.currentTimeMillis());
    this.a.put(paramString2, localApiReportData);
    int i = c(paramString1);
    if (i > 0)
    {
      TraceReportUtil.a(131);
      TraceReportUtil.a(131, i);
    }
  }
  
  protected int c(String paramString)
  {
    if ("change3DAvatarComponent".equals(paramString))
    {
      if (CMShowPlatform.a.b(Scene.MAKE_UP_3D)) {
        return 2;
      }
      return 1;
    }
    return -1;
  }
  
  protected ApolloStoreViewController c()
  {
    return ((ApolloJsPluginImpl)this.b).getApolloStoreViewController();
  }
  
  protected ApolloJsPluginImpl.CmStoreUserInfo d()
  {
    return ((ApolloJsPluginImpl)this.b).getCmStoreUserInfo();
  }
  
  void d(String paramString)
  {
    this.b.callJs(paramString);
  }
  
  protected Activity e()
  {
    return ((ApolloJsPluginImpl)this.b).getActivity();
  }
  
  protected String f()
  {
    return ((ApolloJsPluginImpl)this.b).getAbsoluteUrl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.BaseJsModule
 * JD-Core Version:    0.7.0.1
 */