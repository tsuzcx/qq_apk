package com.tencent.av.screenshare;

import android.os.SystemClock;

class ScreenShareReportHelper$ScreenShareReportInfo
{
  public int a = 0;
  public long b = 0L;
  
  public boolean a()
  {
    return (this.b != 0L) && (Math.abs(SystemClock.elapsedRealtime() - this.b) < 5000L);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{lastFromType: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", lastStartTime: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareReportHelper.ScreenShareReportInfo
 * JD-Core Version:    0.7.0.1
 */