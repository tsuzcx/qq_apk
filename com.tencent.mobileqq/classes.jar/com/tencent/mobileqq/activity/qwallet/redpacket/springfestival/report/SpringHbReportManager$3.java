package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report;

import ahiy;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class SpringHbReportManager$3
  implements Runnable
{
  SpringHbReportManager$3(SpringHbReportManager paramSpringHbReportManager, LinkedList paramLinkedList) {}
  
  public void run()
  {
    synchronized ()
    {
      ahiy.a(this.a, SpringHbReportManager.a(this.this$0));
      if (QLog.isColorLevel()) {
        QLog.d("springHb_report_SpringHbReportManager", 2, "[saveReportFile] done");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbReportManager.3
 * JD-Core Version:    0.7.0.1
 */