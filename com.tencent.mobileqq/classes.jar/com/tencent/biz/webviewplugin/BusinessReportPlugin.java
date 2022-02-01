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
  private Handler a;
  public boolean a;
  
  public BusinessReportPlugin()
  {
    this.jdField_a_of_type_Boolean = false;
    this.mPluginNameSpace = "JD_REPORT";
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      try
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new BusinessReportPlugin.1(this, paramString));
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
    this.jdField_a_of_type_Boolean = BusinessReporter.a(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.BusinessReportPlugin
 * JD-Core Version:    0.7.0.1
 */