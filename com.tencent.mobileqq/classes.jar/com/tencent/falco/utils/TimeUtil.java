package com.tencent.falco.utils;

import android.os.SystemClock;
import java.text.SimpleDateFormat;

public class TimeUtil
{
  private static long mCpuTime = 0L;
  private static long mServerTime = 0L;
  
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
    if (mServerTime <= 0L) {
      return System.currentTimeMillis();
    }
    return mServerTime + (SystemClock.elapsedRealtime() - mCpuTime);
  }
  
  public static void setServerUTCTime(long paramLong)
  {
    mServerTime = 1000L * paramLong;
    mCpuTime = SystemClock.elapsedRealtime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.TimeUtil
 * JD-Core Version:    0.7.0.1
 */