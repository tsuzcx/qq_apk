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
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (!this.a.c)
      {
        this.a.g();
        this.a.b.removeMessages(1000);
        this.a.b.sendEmptyMessageDelayed(1000, this.a.o);
        continue;
        NearbyActivity.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity.8
 * JD-Core Version:    0.7.0.1
 */