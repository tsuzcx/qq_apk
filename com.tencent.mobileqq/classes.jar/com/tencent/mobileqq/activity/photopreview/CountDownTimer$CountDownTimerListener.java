package com.tencent.mobileqq.activity.photopreview;

import android.os.SystemClock;

public abstract class CountDownTimer$CountDownTimerListener
{
  private CountDownTimer countDownTimer;
  private long mOverTime;
  private long mStopTimeInFuture;
  
  public CountDownTimer$CountDownTimerListener(long paramLong)
  {
    setOverTime(paramLong);
  }
  
  public CountDownTimer$CountDownTimerListener(CountDownTimer paramCountDownTimer)
  {
    this.countDownTimer = paramCountDownTimer;
  }
  
  public abstract void onFinish();
  
  public abstract void onTick(long paramLong);
  
  public void setOverTime(long paramLong)
  {
    if (this.countDownTimer != null) {
      this.countDownTimer.setTime(paramLong);
    }
    this.mOverTime = paramLong;
    this.mStopTimeInFuture = (SystemClock.elapsedRealtime() + 1000L * paramLong);
  }
  
  public final void tick()
  {
    long l = this.mStopTimeInFuture - SystemClock.elapsedRealtime();
    if (l > 1000L)
    {
      onTick(l);
      return;
    }
    onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photopreview.CountDownTimer.CountDownTimerListener
 * JD-Core Version:    0.7.0.1
 */