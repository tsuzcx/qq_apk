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
  private ArrayList<GdtWebReportInterface> a = new ArrayList();
  private WeakReference<CustomWebView> b;
  
  public GdtWebReportPlugin()
  {
    GdtLog.a("GdtWebReportPlugin", " GdtWebReportPlugin ");
    this.mPluginNameSpace = "GdtWebReportPlugin";
    Object localObject = new GdtWebReportNoco(this);
    GdtWebReportQQ localGdtWebReportQQ = new GdtWebReportQQ(this);
    GdtWebReportAction localGdtWebReportAction = new GdtWebReportAction(this);
    this.a.add(localObject);
    this.a.add(localGdtWebReportQQ);
    this.a.add(localGdtWebReportAction);
    if (GdtLandingPageConfig.a().b())
    {
      localObject = new GdtLandingPageReport(this);
      this.a.add(localObject);
    }
  }
  
  protected WeakReference<CustomWebView> a()
  {
    return this.b;
  }
  
  protected Activity b()
  {
    Activity localActivity1;
    if (this.mRuntime != null) {
      localActivity1 = this.mRuntime.d();
    } else {
      localActivity1 = null;
    }
    Activity localActivity2 = localActivity1;
    if ((localActivity1 instanceof BasePluginActivity)) {
      localActivity2 = ((BasePluginActivity)BasePluginActivity.class.cast(localActivity1)).getOutActivity();
    }
    return localActivity2;
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
    while (i < this.a.size())
    {
      ((GdtWebReportInterface)this.a.get(i)).a(paramString, paramLong, paramMap);
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
    while (i < this.a.size())
    {
      ((GdtWebReportInterface)this.a.get(i)).b();
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
    while (i < this.a.size())
    {
      ((GdtWebReportInterface)this.a.get(i)).c();
      i += 1;
    }
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.b = new WeakReference(paramCustomWebView);
    GdtLog.a("GdtWebReportPlugin", " onWebViewCreated ");
    int i = 0;
    while (i < this.a.size())
    {
      ((GdtWebReportInterface)this.a.get(i)).b(paramCustomWebView);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtWebReportPlugin
 * JD-Core Version:    0.7.0.1
 */