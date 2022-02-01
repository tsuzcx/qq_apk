package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.utils.SeqUtil;
import com.tencent.qphone.base.util.QLog;

class GAudioExitMonitor$AudioExitReceiver
  extends BroadcastReceiver
{
  GAudioExitMonitor$AudioExitReceiver(GAudioExitMonitor paramGAudioExitMonitor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.av.EXIT_VIDEO_PROCESS".equals(paramIntent.getAction())))
    {
      long l = SeqUtil.a(paramIntent);
      paramContext = new StringBuilder();
      paramContext.append("onReceive.EXIT_VIDEO_ACTION, seq[");
      paramContext.append(l);
      paramContext.append("]");
      QLog.w("GAudioExitMonitor", 1, paramContext.toString());
      paramContext = GAudioExitMonitor.a(this.a).a();
      if (paramContext != null)
      {
        paramContext.a(false, 202, new int[] { paramContext.a().j });
        paramContext.b(202);
        paramContext.d(1011);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GAudioExitMonitor.AudioExitReceiver
 * JD-Core Version:    0.7.0.1
 */