package com.tencent.biz.webviewplugin;

import bisl;
import com.tencent.qphone.base.util.QLog;

class NewReportPlugin$4$2
  implements Runnable
{
  NewReportPlugin$4$2(NewReportPlugin.4 param4, Exception paramException) {}
  
  public void run()
  {
    this.this$0.a.dismiss();
    if (QLog.isColorLevel()) {
      QLog.d("NewReportPlugin", 2, "safetyNewReport exception1" + this.a.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.4.2
 * JD-Core Version:    0.7.0.1
 */