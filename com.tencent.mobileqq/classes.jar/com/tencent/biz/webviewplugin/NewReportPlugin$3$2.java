package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class NewReportPlugin$3$2
  implements Runnable
{
  NewReportPlugin$3$2(NewReportPlugin.3 param3, Exception paramException) {}
  
  public void run()
  {
    this.this$0.a.dismiss();
    if (QLog.isColorLevel()) {
      QLog.d("NewReportPlugin", 2, "nearbySafetyRealReport exception1" + this.a.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.3.2
 * JD-Core Version:    0.7.0.1
 */