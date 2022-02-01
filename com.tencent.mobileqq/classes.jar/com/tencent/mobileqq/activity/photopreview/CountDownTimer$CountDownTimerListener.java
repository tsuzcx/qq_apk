package com.tencent.mobileqq.activity.photopreview;

import android.os.SystemClock;

public abstract class CountDownTimer$CountDownTimerListener
{
  private long a;
  private CountDownTimer b;
  private long c;
  
  public CountDownTimer$CountDownTimerListener(long paramLong)
  {
    a(paramLong);
  }
  
  public final void a()
  {
    long l = this.a - SystemClock.elapsedRealtime();
    if (l > 1000L)
    {
      b(l);
      return;
    }
    b();
  }
  
  public void a(long paramLong)
  {
    CountDownTimer localCountDownTimer = this.b;
    if (localCountDownTimer != null) {
      localCountDownTimer.a(paramLong);
    }
    this.c = paramLong;
    this.a = (SystemClock.elapsedRealtime() + paramLong * 1000L);
  }
  
  public abstract void b();
  
  public abstract void b(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photopreview.CountDownTimer.CountDownTimerListener
 * JD-Core Version:    0.7.0.1
 */