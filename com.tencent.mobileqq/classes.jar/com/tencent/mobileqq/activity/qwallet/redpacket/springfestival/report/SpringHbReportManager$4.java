package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report;

import agvn;
import com.tencent.qphone.base.util.QLog;

class SpringHbReportManager$4
  implements Runnable
{
  SpringHbReportManager$4(SpringHbReportManager paramSpringHbReportManager, SpringHbReportManager.ReportInfo paramReportInfo) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("springHb_report_SpringHbReportManager", 2, "[report] " + this.a + ",over:" + SpringHbReportManager.a(this.this$0) + ",level:" + SpringHbReportManager.a(this.this$0) + ",levelTime:" + SpringHbReportManager.a(this.this$0));
        }
        agvn.a(this.a, SpringHbReportManager.a(this.this$0));
        if (SpringHbReportManager.a(this.this$0, this.a))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("springHb_report_SpringHbReportManager", 2, "[report] sorry, we should drop this info");
          return;
        }
        SpringHbReportManager.a(this.this$0, this.a);
        SpringHbReportManager localSpringHbReportManager = this.this$0;
        if (this.a.isRealTime)
        {
          i = 1;
          SpringHbReportManager.a(localSpringHbReportManager, i);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbReportManager.4
 * JD-Core Version:    0.7.0.1
 */