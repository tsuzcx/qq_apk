package com.jeremyliao.liveeventbus.utils;

import android.os.Looper;

public final class ThreadUtils
{
  public static boolean isMainThread()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.utils.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */