package com.tencent.mobileqq.app;

import com.tencent.mobileqq.statistics.ReportController;
import java.util.Timer;
import java.util.TimerTask;

class PrinterStatusHandler$1
  extends TimerTask
{
  PrinterStatusHandler$1(PrinterStatusHandler paramPrinterStatusHandler) {}
  
  public void run()
  {
    ReportController.b(PrinterStatusHandler.a(this.this$0), "CliOper", "", "", "0X8004023", "0X8004023", 0, 0, "", "", "", "");
    if (PrinterStatusHandler.b(this.this$0) != null)
    {
      PrinterStatusHandler.b(this.this$0).cancel();
      PrinterStatusHandler.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrinterStatusHandler.1
 * JD-Core Version:    0.7.0.1
 */