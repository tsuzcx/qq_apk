package com.tencent.mobileqq.activity.springfestival.report;

import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
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
      QWalletTools.a(this.a, SpringHbReportManager.a(this.this$0));
      if (QLog.isColorLevel()) {
        QLog.d("shua2021report_SpringHbReportManager", 2, "[saveReportFile] done");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbReportManager.3
 * JD-Core Version:    0.7.0.1
 */