package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report;

import com.tencent.qphone.base.util.QLog;

class SpringHbReportManager$2
  implements Runnable
{
  SpringHbReportManager$2(SpringHbReportManager paramSpringHbReportManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_report_SpringHbReportManager", 2, "[saveReportFile] time to save");
    }
    SpringHbReportManager.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbReportManager.2
 * JD-Core Version:    0.7.0.1
 */