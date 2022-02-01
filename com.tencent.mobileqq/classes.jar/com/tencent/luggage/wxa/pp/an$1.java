package com.tencent.luggage.wxa.pp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class an$1
  extends Handler
{
  an$1(an paraman, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i != 1) && (i != 2)) {
      return;
    }
    if (an.a(this.a)) {
      sendMessageDelayed(Message.obtain(an.b(this.a), 2), 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.an.1
 * JD-Core Version:    0.7.0.1
 */