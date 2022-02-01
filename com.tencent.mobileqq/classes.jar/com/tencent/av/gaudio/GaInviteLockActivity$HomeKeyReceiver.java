package com.tencent.av.gaudio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class GaInviteLockActivity$HomeKeyReceiver
  extends BroadcastReceiver
{
  GaInviteLockActivity$HomeKeyReceiver(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (paramContext.equals("homekey")))
      {
        ReportController.b(null, "CliOper", "", "", "0X8004210", "0X8004210", 0, 0, "", "", "", "");
        this.a.c(-1038L);
      }
    }
    boolean bool;
    do
    {
      do
      {
        return;
      } while (!paramContext.equals("android.intent.action.SCREEN_OFF"));
      bool = VideoController.a(this.a);
      if (bool) {
        ReportController.b(null, "CliOper", "", "", "0X800420C", "0X800420C", 0, 0, "", "", "", "");
      }
    } while (!QLog.isColorLevel());
    QLog.w(this.a.b, 1, "ACTION_SCREEN_OFF, isScreenLocked[" + bool + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.HomeKeyReceiver
 * JD-Core Version:    0.7.0.1
 */