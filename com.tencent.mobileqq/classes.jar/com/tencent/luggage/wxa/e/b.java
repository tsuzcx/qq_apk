package com.tencent.luggage.wxa.e;

import android.os.SystemClock;
import java.io.Closeable;
import java.io.IOException;

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
  
  public static void a(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException|IllegalStateException paramCloseable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.e.b
 * JD-Core Version:    0.7.0.1
 */