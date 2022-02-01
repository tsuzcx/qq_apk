package com.tencent.mobileqq.activity.springfestival.report;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class SpringHbReportManager$9
  implements Runnable
{
  SpringHbReportManager$9(SpringHbReportManager paramSpringHbReportManager, long paramLong) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("resetSendingState,reqSeq：");
        ((StringBuilder)localObject).append(this.a);
        QLog.i("shua2021report_SpringHbReportManager", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = SpringHbReportManager.a(this.this$0).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SpringHbReportManager.ReportInfo localReportInfo = (SpringHbReportManager.ReportInfo)((Iterator)localObject).next();
        if (localReportInfo.reqSeq == this.a) {
          localReportInfo.isSending = false;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbReportManager.9
 * JD-Core Version:    0.7.0.1
 */