package com.tencent.ad.tangram.canvas.statistics;

import android.os.SystemClock;
import android.support.annotation.Keep;

@Keep
public class AdTimeStatistics
{
  private long startTime = -1L;
  private long stopTime = -1L;
  private long time = -1L;
  
  private void update()
  {
    if ((this.stopTime >= this.startTime) && (this.startTime != -1L) && (this.stopTime != -1L)) {}
    for (long l = this.stopTime - this.startTime;; l = -1L)
    {
      if (l != -1L)
      {
        if (this.time == -1L) {
          this.time = 0L;
        }
        this.time = (l + this.time);
      }
      this.startTime = -1L;
      this.stopTime = -1L;
      return;
    }
  }
  
  public long getTime()
  {
    return this.time;
  }
  
  public void start()
  {
    this.startTime = SystemClock.elapsedRealtime();
  }
  
  public void stop()
  {
    this.stopTime = SystemClock.elapsedRealtime();
    update();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.statistics.AdTimeStatistics
 * JD-Core Version:    0.7.0.1
 */