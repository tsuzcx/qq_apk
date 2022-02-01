package com.tencent.luggage.wxa.pd;

import android.os.Looper;

public class u
{
  public static boolean a()
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      return true;
    }
    return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.u
 * JD-Core Version:    0.7.0.1
 */