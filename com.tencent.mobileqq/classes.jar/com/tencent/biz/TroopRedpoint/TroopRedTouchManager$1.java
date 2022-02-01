package com.tencent.biz.TroopRedpoint;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class TroopRedTouchManager$1
  extends BroadcastReceiver
{
  TroopRedTouchManager$1(TroopRedTouchManager paramTroopRedTouchManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("request_type", 0);
    QLog.i(this.a.c, 2, "receive request" + paramIntent.getExtras());
    switch (i)
    {
    default: 
      return;
    }
    paramContext = new Intent();
    paramContext.setAction("com.tencent.mobileqq.NearbyJsInterface");
    paramContext.putExtra("command_type", 1);
    paramContext.putExtra("data", TroopRedTouchManager.a(this.a));
    this.a.a.getApp().sendBroadcast(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchManager.1
 * JD-Core Version:    0.7.0.1
 */