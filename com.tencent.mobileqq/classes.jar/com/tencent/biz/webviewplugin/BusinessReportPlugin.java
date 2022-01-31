package com.tencent.biz.webviewplugin;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.ecshopassit.BusinessReporter;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

public class BusinessReportPlugin
  extends WebViewPlugin
{
  public boolean a;
  
  public BusinessReportPlugin()
  {
    this.mPluginNameSpace = "JD_REPORT";
  }
  
  public void a(String paramString)
  {
    if (this.a) {}
    try
    {
      BusinessReporter.a(this.mRuntime.a(), paramString, this.mRuntime.a().getUrl());
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("BusinessReporter", 1, "Report Error:" + paramString);
    }
  }
  
  public void b(String paramString)
  {
    this.a = BusinessReporter.a(paramString);
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L) {
      a(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.BusinessReportPlugin
 * JD-Core Version:    0.7.0.1
 */