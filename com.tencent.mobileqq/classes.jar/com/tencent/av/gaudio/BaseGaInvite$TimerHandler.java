package com.tencent.av.gaudio;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

@SuppressLint({"HandlerLeak"})
class BaseGaInvite$TimerHandler
  extends Handler
{
  BaseGaInvite$TimerHandler(BaseGaInvite paramBaseGaInvite) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.b();
      return;
    }
    this.a.a("Msg");
    super.sendEmptyMessageDelayed(1, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.BaseGaInvite.TimerHandler
 * JD-Core Version:    0.7.0.1
 */