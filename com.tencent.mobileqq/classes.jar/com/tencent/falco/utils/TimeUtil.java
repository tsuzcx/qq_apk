package com.tencent.falco.utils;

import android.os.SystemClock;
import java.text.SimpleDateFormat;

public class TimeUtil
{
  private static long mCpuTime;
  private static long mServerTime;
  
  public static String convertTimestampToDate(long paramLong, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "yyyy-MM-dd HH:mm:ss";
    }
    return new SimpleDateFormat(str).format(new Long(paramLong));
  }
  
  public static long getCurrentMillis()
  {
    return System.currentTimeMillis();
  }
  
  public static long getServerCurTime()
  {
    long l = mServerTime;
    if (l <= 0L) {
      return System.currentTimeMillis();
    }
    return l + (SystemClock.elapsedRealtime() - mCpuTime);
  }
  
  public static void setServerUTCTime(long paramLong)
  {
    mServerTime = paramLong * 1000L;
    mCpuTime = SystemClock.elapsedRealtime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.utils.TimeUtil
 * JD-Core Version:    0.7.0.1
 */