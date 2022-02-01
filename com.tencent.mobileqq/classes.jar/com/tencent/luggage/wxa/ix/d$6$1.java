package com.tencent.luggage.wxa.ix;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;

class d$6$1
  implements MessageQueue.IdleHandler
{
  d$6$1(d.6 param6) {}
  
  public boolean queueIdle()
  {
    Looper.myLooper().quit();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ix.d.6.1
 * JD-Core Version:    0.7.0.1
 */