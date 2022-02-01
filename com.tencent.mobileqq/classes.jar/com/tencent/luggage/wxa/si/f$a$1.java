package com.tencent.luggage.wxa.si;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.wxa.sj.i;

class f$a$1
  extends Handler
{
  f$a$1(f.a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    if ((paramMessage.getCallback() != null) && ((paramMessage.getCallback() instanceof i)) && (((i)paramMessage.getCallback()).isCancelled())) {
      return;
    }
    super.dispatchMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.si.f.a.1
 * JD-Core Version:    0.7.0.1
 */