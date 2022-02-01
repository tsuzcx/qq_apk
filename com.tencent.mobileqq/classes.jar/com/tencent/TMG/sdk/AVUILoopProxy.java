package com.tencent.TMG.sdk;

import android.os.Handler;
import android.os.Looper;

public class AVUILoopProxy
{
  public static void postTaskToMainLooper(Runnable paramRunnable)
  {
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVUILoopProxy
 * JD-Core Version:    0.7.0.1
 */