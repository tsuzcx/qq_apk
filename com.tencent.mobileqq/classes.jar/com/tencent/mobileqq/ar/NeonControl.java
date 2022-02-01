package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.app.ThreadManager;

public class NeonControl
{
  public static boolean b = true;
  private static NeonControl d;
  final Object a;
  NeonControl.AvgConsumeReport c;
  private boolean e;
  
  public static NeonControl a()
  {
    if (d == null) {
      d = new NeonControl();
    }
    return d;
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.c == null)
    {
      this.c = new NeonControl.AvgConsumeReport(this);
      this.c.c = paramInt;
    }
    if (this.c.c != paramInt)
    {
      if ((this.c.a > 0L) || (this.c.b > 0)) {
        c();
      }
      localAvgConsumeReport = this.c;
      localAvgConsumeReport.c = paramInt;
      localAvgConsumeReport.a = 0L;
      localAvgConsumeReport.b = 0;
    }
    NeonControl.AvgConsumeReport localAvgConsumeReport = this.c;
    localAvgConsumeReport.a += paramLong;
    localAvgConsumeReport = this.c;
    localAvgConsumeReport.b += 1;
  }
  
  public boolean b()
  {
    synchronized (this.a)
    {
      boolean bool = this.e;
      return bool;
    }
  }
  
  public void c()
  {
    if (this.c == null) {
      return;
    }
    NeonControl.AvgConsumeReport localAvgConsumeReport1 = new NeonControl.AvgConsumeReport(this);
    localAvgConsumeReport1.a = this.c.a;
    localAvgConsumeReport1.b = this.c.b;
    localAvgConsumeReport1.c = this.c.c;
    NeonControl.AvgConsumeReport localAvgConsumeReport2 = this.c;
    localAvgConsumeReport2.c = -2147483648;
    localAvgConsumeReport2.a = 0L;
    localAvgConsumeReport2.b = 0;
    if ((localAvgConsumeReport1.a > 0L) && (localAvgConsumeReport1.b > 0))
    {
      if (localAvgConsumeReport1.c == -2147483648) {
        return;
      }
      int i = (int)(localAvgConsumeReport1.a / localAvgConsumeReport1.b);
      if (i >= 0)
      {
        if (i >= 600000) {
          return;
        }
        ThreadManager.post(new NeonControl.2(this, localAvgConsumeReport1, i), 5, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.NeonControl
 * JD-Core Version:    0.7.0.1
 */