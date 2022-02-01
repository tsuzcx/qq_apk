package com.tencent.mobileqq.app;

import anrd;
import bcst;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class PrinterHandler$2
  extends TimerTask
{
  public PrinterHandler$2(anrd paramanrd, long paramLong, Timer paramTimer) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(this.jdField_a_of_type_Long)))
    {
      bcst.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004021", "0X8004021", (int)this.jdField_a_of_type_Long, -1, "", "", "", "");
      this.this$0.a(Long.valueOf(this.jdField_a_of_type_Long), false);
      if (QLog.isDevelopLevel()) {
        QLog.d("dataline.Printer", 4, "printID=" + this.jdField_a_of_type_Long + ", 超时到了");
      }
    }
    this.jdField_a_of_type_JavaUtilTimer.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrinterHandler.2
 * JD-Core Version:    0.7.0.1
 */