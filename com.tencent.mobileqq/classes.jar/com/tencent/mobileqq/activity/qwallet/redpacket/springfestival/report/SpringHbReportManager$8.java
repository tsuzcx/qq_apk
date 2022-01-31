package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report;

import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.ListIterator;

class SpringHbReportManager$8
  implements Runnable
{
  SpringHbReportManager$8(SpringHbReportManager paramSpringHbReportManager, long paramLong, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("springHb_report_SpringHbReportManager", 2, "cleanOrSaveReqList,reqSeq：" + this.jdField_a_of_type_Long + ",retCode：" + this.jdField_a_of_type_Int);
      }
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 110002))
      {
        ListIterator localListIterator = SpringHbReportManager.a(this.this$0).listIterator();
        while (localListIterator.hasNext()) {
          if (((SpringHbReportManager.ReportInfo)localListIterator.next()).reqSeq == this.jdField_a_of_type_Long) {
            localListIterator.remove();
          }
        }
      }
      SpringHbReportManager.a(this.this$0, true);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.report.SpringHbReportManager.8
 * JD-Core Version:    0.7.0.1
 */