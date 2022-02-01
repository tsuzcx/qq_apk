package com.tencent.mobileqq.activity.springfestival.report;

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
        boolean bool = QLog.isColorLevel();
        Object localObject;
        if (bool)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[report] ");
          ((StringBuilder)localObject).append(this.a);
          ((StringBuilder)localObject).append(",over:");
          ((StringBuilder)localObject).append(SpringHbReportManager.a(this.this$0));
          ((StringBuilder)localObject).append(",level:");
          ((StringBuilder)localObject).append(SpringHbReportManager.a(this.this$0));
          ((StringBuilder)localObject).append(",levelTime:");
          ((StringBuilder)localObject).append(SpringHbReportManager.a(this.this$0));
          QLog.i("shua2021report_SpringHbReportManager", 2, ((StringBuilder)localObject).toString());
        }
        SpringHbMonitorReporter.a(this.a);
        if (SpringHbReportManager.a(this.this$0, this.a))
        {
          if (QLog.isColorLevel()) {
            QLog.i("shua2021report_SpringHbReportManager", 2, "[report] sorry, we should drop this info");
          }
        }
        else
        {
          SpringHbReportManager.a(this.this$0, this.a);
          localObject = this.this$0;
          if (!this.a.isRealTime) {
            break label179;
          }
          i = 1;
          SpringHbReportManager.a((SpringHbReportManager)localObject, i);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      return;
      label179:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbReportManager.4
 * JD-Core Version:    0.7.0.1
 */