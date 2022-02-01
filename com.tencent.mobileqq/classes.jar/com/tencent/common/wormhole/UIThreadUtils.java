package com.tencent.common.wormhole;

import android.os.Handler;
import android.os.Looper;

public class UIThreadUtils
{
  private static Handler a = new Handler(Looper.getMainLooper());
  
  public static void a(Runnable paramRunnable)
  {
    a.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.wormhole.UIThreadUtils
 * JD-Core Version:    0.7.0.1
 */