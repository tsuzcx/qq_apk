package com.tencent.biz.webviewplugin;

import bety;
import com.tencent.qphone.base.util.QLog;

class NewReportPlugin$2$2
  implements Runnable
{
  NewReportPlugin$2$2(NewReportPlugin.2 param2, Exception paramException) {}
  
  public void run()
  {
    this.this$0.a.dismiss();
    if (QLog.isColorLevel()) {
      QLog.d("NewReportPlugin", 2, "nearbySafetyRealReport exception1" + this.a.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.2.2
 * JD-Core Version:    0.7.0.1
 */