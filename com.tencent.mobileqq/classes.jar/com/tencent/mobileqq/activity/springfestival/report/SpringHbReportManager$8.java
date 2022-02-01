package com.tencent.mobileqq.activity.springfestival.report;

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
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cleanOrSaveReqList,reqSeq：");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
        ((StringBuilder)localObject).append(",retCode：");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.i("shua2021report_SpringHbReportManager", 2, ((StringBuilder)localObject).toString());
      }
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 110002))
      {
        localObject = SpringHbReportManager.a(this.this$0).listIterator();
        while (((ListIterator)localObject).hasNext()) {
          if (((SpringHbReportManager.ReportInfo)((ListIterator)localObject).next()).reqSeq == this.jdField_a_of_type_Long) {
            ((ListIterator)localObject).remove();
          }
        }
      }
      SpringHbReportManager.a(this.this$0, true);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.report.SpringHbReportManager.8
 * JD-Core Version:    0.7.0.1
 */