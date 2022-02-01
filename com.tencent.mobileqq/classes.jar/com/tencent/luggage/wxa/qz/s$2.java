package com.tencent.luggage.wxa.qz;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.luggage.wxa.sk.a;
import com.tencent.luggage.wxa.sk.c;

class s$2
  extends c
{
  s$2(s params, a parama, Handler.Callback paramCallback, long paramLong, s.a parama1)
  {
    super(parama, paramCallback);
  }
  
  public void a(Message paramMessage)
  {
    long l = System.currentTimeMillis();
    s.a(this.c, paramMessage);
    super.a(paramMessage);
    s.a(this.c, null);
    l = System.currentTimeMillis() - l;
    Thread localThread = Thread.currentThread();
    if (this.a == localThread.getId() ? l >= 300L : l >= 5000L) {
      o.c("Handler#Monitor", "This msg handle so slow[%sms]! runnable=%s callback=%s thread=%s", new Object[] { Long.valueOf(l), paramMessage.getCallback(), this.b, localThread.getName() });
    }
  }
  
  public void c(Message paramMessage)
  {
    this.c.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.s.2
 * JD-Core Version:    0.7.0.1
 */