package com.tencent.luggage.wxa.rc;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;

final class c$1
  implements Runnable
{
  c$1(MessageQueue.IdleHandler paramIdleHandler) {}
  
  public void run()
  {
    Looper.myQueue().addIdleHandler(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rc.c.1
 * JD-Core Version:    0.7.0.1
 */