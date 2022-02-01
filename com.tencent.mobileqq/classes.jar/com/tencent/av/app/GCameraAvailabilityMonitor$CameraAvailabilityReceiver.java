package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.utils.SeqUtil;
import com.tencent.qphone.base.util.QLog;

class GCameraAvailabilityMonitor$CameraAvailabilityReceiver
  extends BroadcastReceiver
{
  GCameraAvailabilityMonitor$CameraAvailabilityReceiver(GCameraAvailabilityMonitor paramGCameraAvailabilityMonitor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((this.a.a() != null) && (paramIntent != null))
    {
      long l = SeqUtil.a(paramIntent);
      paramContext = paramIntent.getStringExtra("camera_id");
      int i = paramIntent.getIntExtra("availability", 1);
      this.a.a(paramContext, i);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("CameraAvailabilityReceiver, id[");
        paramIntent.append(paramContext);
        paramIntent.append("], available[");
        paramIntent.append(i);
        paramIntent.append("], seq[");
        paramIntent.append(l);
        paramIntent.append("]");
        QLog.w("GCameraAvailabilityMonitor", 1, paramIntent.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GCameraAvailabilityMonitor.CameraAvailabilityReceiver
 * JD-Core Version:    0.7.0.1
 */