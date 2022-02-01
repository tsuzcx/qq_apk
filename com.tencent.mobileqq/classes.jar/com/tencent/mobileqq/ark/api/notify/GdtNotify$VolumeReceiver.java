package com.tencent.mobileqq.ark.api.notify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class GdtNotify$VolumeReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("--VolumeReceiver---");
      paramContext.append(paramIntent.getAction());
      QLog.i("GdtNotify", 2, paramContext.toString());
    }
    GdtNotify.a("com.tencent.gouwu.video");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.GdtNotify.VolumeReceiver
 * JD-Core Version:    0.7.0.1
 */