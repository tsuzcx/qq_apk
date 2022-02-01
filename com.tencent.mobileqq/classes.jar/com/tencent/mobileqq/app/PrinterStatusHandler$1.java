package com.tencent.mobileqq.app;

import aoab;
import bdla;
import java.util.Timer;
import java.util.TimerTask;

public class PrinterStatusHandler$1
  extends TimerTask
{
  public PrinterStatusHandler$1(aoab paramaoab) {}
  
  public void run()
  {
    bdla.b(this.this$0.app, "CliOper", "", "", "0X8004023", "0X8004023", 0, 0, "", "", "", "");
    if (aoab.a(this.this$0) != null)
    {
      aoab.a(this.this$0).cancel();
      aoab.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrinterStatusHandler.1
 * JD-Core Version:    0.7.0.1
 */