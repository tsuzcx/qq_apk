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
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      this.a.a("Msg");
      super.sendEmptyMessageDelayed(1, 2000L);
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.BaseGaInvite.TimerHandler
 * JD-Core Version:    0.7.0.1
 */