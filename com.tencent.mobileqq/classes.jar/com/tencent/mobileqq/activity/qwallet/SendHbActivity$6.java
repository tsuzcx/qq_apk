package com.tencent.mobileqq.activity.qwallet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class SendHbActivity$6
  extends BroadcastReceiver
{
  SendHbActivity$6(SendHbActivity paramSendHbActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction())) && (SendHbActivity.access$300(this.a)) && ((this.a.nChannel & 0x40) > 0)) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.SendHbActivity.6
 * JD-Core Version:    0.7.0.1
 */