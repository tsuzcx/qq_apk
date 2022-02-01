package com.tencent.gamecenter.wadl.biz.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class GameCenterBroadcastReceiver$1
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    boolean bool1 = "android.intent.action.SCREEN_OFF".equals(paramContext);
    boolean bool2 = true;
    if (bool1)
    {
      QLog.i("GameCenterBroadcastReceiver", 1, "mScreenOff = true");
      ((IQQGameCheckService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameCheckService.class, "")).checkGameCenter();
      return;
    }
    if ("android.intent.action.BATTERY_CHANGED".equals(paramContext))
    {
      GameCenterBroadcastReceiver.a = paramIntent.getIntExtra("level", 0) * 100 / paramIntent.getIntExtra("scale", 100);
      paramContext = new StringBuilder();
      paramContext.append("battery cap= ");
      paramContext.append(GameCenterBroadcastReceiver.a);
      QLog.i("GameCenterBroadcastReceiver", 1, paramContext.toString());
      return;
    }
    if (("android.intent.action.ACTION_POWER_CONNECTED".equals(paramContext)) || ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(paramContext)))
    {
      int i = paramIntent.getIntExtra("status", -1);
      bool1 = bool2;
      if (i != 2) {
        if (i == 5) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      GameCenterBroadcastReceiver.b = bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */