package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;

class GVipFunCallMonitor$VipFunCallReceiver
  extends BroadcastReceiver
{
  GVipFunCallMonitor$VipFunCallReceiver(GVipFunCallMonitor paramGVipFunCallMonitor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      paramContext = GVipFunCallMonitor.a(this.a).a();
      if (paramContext == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("recv vipfuncall msg broadcast: ");
        localStringBuilder.append(paramIntent.getAction());
        QLog.d("GVipFunCallMonitor", 2, localStringBuilder.toString());
      }
      if (paramIntent.getAction().equals("tencent.video.q2v.AnnimateDownloadFinish"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GVipFunCallMonitor", 2, "ACTION_ANNIMATE_DOWNLOAD_FINISH");
        }
        paramContext.e(paramIntent.getIntExtra("fun_call_id", 0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GVipFunCallMonitor.VipFunCallReceiver
 * JD-Core Version:    0.7.0.1
 */