package com.tencent.biz.webviewplugin;

import com.tencent.qphone.base.util.QLog;

class NewReportPlugin$1$2
  implements Runnable
{
  NewReportPlugin$1$2(NewReportPlugin.1 param1, Exception paramException) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("safetyNewReport exception1");
      localStringBuilder.append(this.a.getMessage());
      QLog.d("NewReportPlugin", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.1.2
 * JD-Core Version:    0.7.0.1
 */