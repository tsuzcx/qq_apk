package com.tencent.gdtad.web;

import android.app.Activity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class GdtWebReportPlugin
  extends WebViewPlugin
{
  private WeakReference<CustomWebView> jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList<GdtWebReportInterface> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public GdtWebReportPlugin()
  {
    GdtLog.a("GdtWebReportPlugin", " GdtWebReportPlugin ");
    this.mPluginNameSpace = "GdtWebReportPlugin";
    GdtWebReportNoco localGdtWebReportNoco = new GdtWebReportNoco(this);
    GdtWebReportQQ localGdtWebReportQQ = new GdtWebReportQQ(this);
    GdtLandingPageReport localGdtLandingPageReport = new GdtLandingPageReport(this);
    GdtWebReportAction localGdtWebReportAction = new GdtWebReportAction(this);
    this.jdField_a_of_type_JavaUtilArrayList.add(localGdtWebReportNoco);
    this.jdField_a_of_type_JavaUtilArrayList.add(localGdtWebReportQQ);
    this.jdField_a_of_type_JavaUtilArrayList.add(localGdtLandingPageReport);
    this.jdField_a_of_type_JavaUtilArrayList.add(localGdtWebReportAction);
  }
  
  protected Activity a()
  {
    Activity localActivity1;
    if (this.mRuntime != null) {
      localActivity1 = this.mRuntime.a();
    } else {
      localActivity1 = null;
    }
    Activity localActivity2 = localActivity1;
    if ((localActivity1 instanceof BasePluginActivity)) {
      localActivity2 = ((BasePluginActivity)BasePluginActivity.class.cast(localActivity1)).getOutActivity();
    }
    return localActivity2;
  }
  
  protected WeakReference<CustomWebView> a()
  {
    return this.jdField_a_of_type_JavaLangRefWeakReference;
  }
  
  public void callJs(String paramString)
  {
    super.callJs(paramString);
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 2L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" handleEvent url = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("==type ==");
    localStringBuilder.append(paramLong);
    GdtLog.a("GdtWebReportPlugin", localStringBuilder.toString());
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((GdtWebReportInterface)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(paramString, paramLong, paramMap);
      i += 1;
    }
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return super.handleSchemaRequest(paramString1, paramString2);
  }
  
  protected void onActivityReady()
  {
    super.onActivityReady();
    GdtLog.a("GdtWebReportPlugin", " onActivityReady ");
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((GdtWebReportInterface)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b();
      i += 1;
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    GdtLog.a("GdtWebReportPlugin", " onCreate ");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    GdtLog.a("GdtWebReportPlugin", " onDestroy webviewGetPerformanceResult");
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((GdtWebReportInterface)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c();
      i += 1;
    }
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCustomWebView);
    GdtLog.a("GdtWebReportPlugin", " onWebViewCreated ");
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((GdtWebReportInterface)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b(paramCustomWebView);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtWebReportPlugin
 * JD-Core Version:    0.7.0.1
 */