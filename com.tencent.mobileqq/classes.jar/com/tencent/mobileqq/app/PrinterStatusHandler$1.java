package com.tencent.mobileqq.app;

import akcw;
import axqw;
import java.util.Timer;
import java.util.TimerTask;

public class PrinterStatusHandler$1
  extends TimerTask
{
  public PrinterStatusHandler$1(akcw paramakcw) {}
  
  public void run()
  {
    axqw.b(this.this$0.app, "CliOper", "", "", "0X8004023", "0X8004023", 0, 0, "", "", "", "");
    if (akcw.a(this.this$0) != null)
    {
      akcw.a(this.this$0).cancel();
      akcw.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrinterStatusHandler.1
 * JD-Core Version:    0.7.0.1
 */