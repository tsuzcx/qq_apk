package com.tencent.luggage.wxa.sk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class c$1
  extends Handler
{
  c$1(c paramc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    this.a.a(paramMessage);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.c(paramMessage);
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    paramMessage.setTarget(c.a(this.a));
    return this.a.b(paramMessage, paramLong);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sk.c.1
 * JD-Core Version:    0.7.0.1
 */