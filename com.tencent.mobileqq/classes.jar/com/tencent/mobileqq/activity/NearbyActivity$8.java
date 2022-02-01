package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class NearbyActivity$8
  implements Handler.Callback
{
  NearbyActivity$8(NearbyActivity paramNearbyActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1000)
    {
      if (i == 1001) {
        NearbyActivity.access$100(this.a);
      }
    }
    else if (!this.a.isStopHeartBeat)
    {
      this.a.notifyHeartBeat();
      this.a.mHeartBeatHandler.removeMessages(1000);
      this.a.mHeartBeatHandler.sendEmptyMessageDelayed(1000, this.a.mHeartBeatInterval);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity.8
 * JD-Core Version:    0.7.0.1
 */