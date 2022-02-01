package com.tencent.luggage.wxa.sq;

import android.os.SystemClock;

public class b
{
  public static long a()
  {
    return SystemClock.elapsedRealtime();
  }
  
  public static long a(long paramLong)
  {
    return SystemClock.elapsedRealtime() - paramLong;
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sq.b
 * JD-Core Version:    0.7.0.1
 */