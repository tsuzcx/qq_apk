package com.tencent.mobileqq.app;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

class PrinterHandler$2
  extends TimerTask
{
  PrinterHandler$2(PrinterHandler paramPrinterHandler, long paramLong, Timer paramTimer) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(this.jdField_a_of_type_Long)))
    {
      ReportController.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004021", "0X8004021", (int)this.jdField_a_of_type_Long, -1, "", "", "", "");
      this.this$0.a(Long.valueOf(this.jdField_a_of_type_Long), false);
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("printID=");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        localStringBuilder.append(", 超时到了");
        QLog.d("dataline.Printer", 4, localStringBuilder.toString());
      }
    }
    this.jdField_a_of_type_JavaUtilTimer.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrinterHandler.2
 * JD-Core Version:    0.7.0.1
 */