package com.tencent.mobileqq.app;

import ajom;
import awqx;
import java.util.Timer;
import java.util.TimerTask;

public class PrinterStatusHandler$1
  extends TimerTask
{
  public PrinterStatusHandler$1(ajom paramajom) {}
  
  public void run()
  {
    awqx.b(this.this$0.app, "CliOper", "", "", "0X8004023", "0X8004023", 0, 0, "", "", "", "");
    if (ajom.a(this.this$0) != null)
    {
      ajom.a(this.this$0).cancel();
      ajom.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrinterStatusHandler.1
 * JD-Core Version:    0.7.0.1
 */