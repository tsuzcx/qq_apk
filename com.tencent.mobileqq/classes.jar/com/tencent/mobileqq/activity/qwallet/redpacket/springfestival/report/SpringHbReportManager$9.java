package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report;

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
      if (QLog.isColorLevel()) {
        QLog.i("springHb_report_SpringHbReportManager", 2, "resetSendingState,reqSeq：" + this.a);
      }
      Iterator localIterator = SpringHbReportManager.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        SpringHbReportManager.ReportInfo localReportInfo = (SpringHbReportManager.ReportInfo)localIterator.next();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbReportManager.9
 * JD-Core Version:    0.7.0.1
 */