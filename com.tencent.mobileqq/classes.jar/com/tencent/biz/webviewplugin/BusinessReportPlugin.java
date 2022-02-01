package com.tencent.biz.webviewplugin;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.ecshopassit.BusinessReporter;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;

public class BusinessReportPlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  public boolean a = false;
  private Handler b = new Handler(Looper.getMainLooper());
  
  public BusinessReportPlugin()
  {
    this.mPluginNameSpace = "JD_REPORT";
  }
  
  public void a(String paramString)
  {
    if (this.a) {
      try
      {
        this.b.post(new BusinessReportPlugin.1(this, paramString));
        return;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Report Error:");
        localStringBuilder.append(paramString);
        QLog.e("BusinessReporter", 1, localStringBuilder.toString());
      }
    }
  }
  
  public void b(String paramString)
  {
    this.a = BusinessReporter.a(paramString);
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8L;
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L) {
      a(paramString);
    }
    return null;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return (BusinessReporter.a()) && (BusinessReporter.a(paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.BusinessReportPlugin
 * JD-Core Version:    0.7.0.1
 */