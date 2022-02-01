package com.tencent.luggage.wxa.mt;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.wxa.qz.o;

class a$1
  extends Handler
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    if (paramMessage.what != 1) {
      return;
    }
    o.d("MicroMsg.WiFiConnector", "MSG_TIME_OUT");
    if (!this.a.a())
    {
      this.a.a("fail to connect wifi:time out");
      o.d("MicroMsg.wifi_event", "MSG_TIME_OUT FAIL.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mt.a.1
 * JD-Core Version:    0.7.0.1
 */