package com.tencent.luggage.wxa.rc;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;

public class c
{
  public static void a(MessageQueue.IdleHandler paramIdleHandler)
  {
    if (paramIdleHandler == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      Looper.getMainLooper().getQueue().addIdleHandler(paramIdleHandler);
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Looper.myQueue().addIdleHandler(paramIdleHandler);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new c.1(paramIdleHandler));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rc.c
 * JD-Core Version:    0.7.0.1
 */