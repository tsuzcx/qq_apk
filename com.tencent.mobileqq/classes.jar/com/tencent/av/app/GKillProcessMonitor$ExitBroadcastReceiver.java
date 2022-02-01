package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;

class GKillProcessMonitor$ExitBroadcastReceiver
  extends BroadcastReceiver
{
  GKillProcessMonitor$ExitBroadcastReceiver(GKillProcessMonitor paramGKillProcessMonitor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.process.exit".equals(paramIntent.getAction())))
    {
      paramContext = paramIntent.getExtras().getStringArrayList("procNameList");
      paramIntent = paramIntent.getExtras().getString("verify");
      if ((GKillProcessMonitor.a(this.a, paramIntent, paramContext)) && (GKillProcessMonitor.a(this.a, paramContext)))
      {
        paramContext = GKillProcessMonitor.a(this.a).a();
        if ((paramContext == null) || (paramContext.a().e()))
        {
          if (paramContext != null) {
            paramContext.A();
          }
          QLog.d("GKillProcessMonitor", 1, "qqExitBroadcastReceiver");
          Process.killProcess(Process.myPid());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GKillProcessMonitor.ExitBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */