package com.huawei.secure.android.common.util;

import android.os.Handler;
import android.os.Looper;

public class c
{
  private static Handler v = new Handler(Looper.getMainLooper());
  
  public static void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    v.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.util.c
 * JD-Core Version:    0.7.0.1
 */