package com.tencent.luggage.wxa.rt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

class e$1
  extends BroadcastReceiver
{
  e$1(e parame) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    e.b(this.a).sendMessageAtFrontOfQueue(Message.obtain(e.b(this.a), 1, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.e.1
 * JD-Core Version:    0.7.0.1
 */