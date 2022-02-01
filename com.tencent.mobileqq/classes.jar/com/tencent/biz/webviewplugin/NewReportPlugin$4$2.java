package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class NewReportPlugin$4$2
  implements Runnable
{
  NewReportPlugin$4$2(NewReportPlugin.4 param4, Exception paramException) {}
  
  public void run()
  {
    if (this.this$0.k.isShowing()) {
      this.this$0.k.dismiss();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("safetyNewReport exception1");
      localStringBuilder.append(this.a.getMessage());
      QLog.d("NewReportPlugin", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.4.2
 * JD-Core Version:    0.7.0.1
 */