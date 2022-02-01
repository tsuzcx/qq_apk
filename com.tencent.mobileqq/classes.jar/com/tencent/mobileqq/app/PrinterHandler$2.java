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
    if (this.this$0.g.containsKey(Long.valueOf(this.a)))
    {
      ReportController.b(this.this$0.d, "CliOper", "", "", "0X8004021", "0X8004021", (int)this.a, -1, "", "", "", "");
      this.this$0.a(Long.valueOf(this.a), false);
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("printID=");
        localStringBuilder.append(this.a);
        localStringBuilder.append(", 超时到了");
        QLog.d("dataline.Printer", 4, localStringBuilder.toString());
      }
    }
    this.b.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrinterHandler.2
 * JD-Core Version:    0.7.0.1
 */