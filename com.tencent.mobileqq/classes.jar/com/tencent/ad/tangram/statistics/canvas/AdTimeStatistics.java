package com.tencent.ad.tangram.statistics.canvas;

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
    long l1 = this.stopTime;
    long l2 = this.startTime;
    if ((l1 >= l2) && (l2 != -1L) && (l1 != -1L)) {
      l1 -= l2;
    } else {
      l1 = -1L;
    }
    if (l1 != -1L)
    {
      if (this.time == -1L) {
        this.time = 0L;
      }
      this.time += l1;
    }
    this.startTime = -1L;
    this.stopTime = -1L;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.canvas.AdTimeStatistics
 * JD-Core Version:    0.7.0.1
 */