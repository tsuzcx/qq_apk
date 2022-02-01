package com.huawei.secure.android.common.util;

import android.os.Looper;

public class b
{
  public static boolean isMainThread()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.util.b
 * JD-Core Version:    0.7.0.1
 */