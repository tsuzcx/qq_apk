package com.tencent.av.screenshare;

import android.os.SystemClock;

class ScreenShareReportHelper$ScreenShareReportInfo
{
  public int a;
  public long a;
  
  private ScreenShareReportHelper$ScreenShareReportInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Long != 0L) && (Math.abs(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long) < 5000L);
  }
  
  public String toString()
  {
    return "{lastFromType: " + this.jdField_a_of_type_Int + ", lastStartTime: " + this.jdField_a_of_type_Long + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareReportHelper.ScreenShareReportInfo
 * JD-Core Version:    0.7.0.1
 */