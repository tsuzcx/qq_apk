package com.tencent.luggage.wxa.hg;

import android.os.Build.VERSION;

public class c
{
  public static boolean a(int paramInt)
  {
    return Build.VERSION.SDK_INT >= paramInt;
  }
  
  public static boolean b(int paramInt)
  {
    return Build.VERSION.SDK_INT < paramInt;
  }
  
  public static boolean c(int paramInt)
  {
    return Build.VERSION.SDK_INT > paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hg.c
 * JD-Core Version:    0.7.0.1
 */