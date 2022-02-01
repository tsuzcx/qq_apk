package com.tencent.luggage.wxa.qz;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

class s$1
  extends Handler
{
  s$1(s params, Looper paramLooper, Handler.Callback paramCallback, long paramLong, s.a parama)
  {
    super(paramLooper, paramCallback);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    long l = System.currentTimeMillis();
    s.a(this.c, paramMessage);
    super.dispatchMessage(paramMessage);
    s.a(this.c, null);
    l = System.currentTimeMillis() - l;
    Thread localThread = Thread.currentThread();
    if (this.a == localThread.getId() ? l >= 300L : l >= 5000L) {
      o.c("Handler#Monitor", "This msg handle so slow[%sms]! runnable=%s callback=%s thread=%s", new Object[] { Long.valueOf(l), paramMessage.getCallback(), this.b, localThread.getName() });
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.c.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.s.1
 * JD-Core Version:    0.7.0.1
 */