package com.tencent.mobileqq.activity.bless;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class BlessActivity$10
  extends BroadcastReceiver
{
  BlessActivity$10(BlessActivity paramBlessActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction())) {
      BlessActivity.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessActivity.10
 * JD-Core Version:    0.7.0.1
 */