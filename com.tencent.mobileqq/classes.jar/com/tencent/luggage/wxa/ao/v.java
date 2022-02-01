package com.tencent.luggage.wxa.ao;

import android.annotation.TargetApi;
import android.os.Trace;

public final class v
{
  public static void a()
  {
    if (x.a >= 18) {
      b();
    }
  }
  
  public static void a(String paramString)
  {
    if (x.a >= 18) {
      b(paramString);
    }
  }
  
  @TargetApi(18)
  private static void b() {}
  
  @TargetApi(18)
  private static void b(String paramString)
  {
    Trace.beginSection(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.v
 * JD-Core Version:    0.7.0.1
 */