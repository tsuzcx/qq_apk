package com.tencent.av.camera.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.utils.SeqUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class CameraManagerApiImpl$CameraAvailabilityReceiver
  extends BroadcastReceiver
{
  CameraManagerApiImpl$CameraAvailabilityReceiver(CameraManagerApiImpl paramCameraManagerApiImpl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getStringExtra("camera_id");
    int i = paramIntent.getIntExtra("availability", 1);
    long l = SeqUtil.a(paramIntent);
    CameraManagerApiImpl.access$700(this.a).put(paramContext, Integer.valueOf(i));
    if ((i == 1) && (this.a.isCameraOpened(l)))
    {
      paramContext = CameraManagerApiImpl.access$700(this.a).entrySet().iterator();
      while (paramContext.hasNext()) {
        if (((Integer)((Map.Entry)paramContext.next()).getValue()).intValue() == 0)
        {
          bool = false;
          break label120;
        }
      }
      boolean bool = true;
      label120:
      if (QQAudioHelper.c())
      {
        paramContext = new StringBuilder();
        paramContext.append("CameraAvailabilityReceiver, sendReopenCameraMsg, result[");
        paramContext.append(bool);
        paramContext.append("], seq[");
        paramContext.append(l);
        paramContext.append("]");
        QLog.w("CameraUtils", 1, paramContext.toString());
      }
      if (bool) {
        CameraManagerApiImpl.access$800(this.a).a("CameraAvailabilityReceiver", l, -1, -1);
      }
    }
    else
    {
      if (QQAudioHelper.c())
      {
        paramContext = new StringBuilder();
        paramContext.append("CameraAvailabilityReceiver, removeReopenCameraMsg, seq[");
        paramContext.append(i);
        paramContext.append("]");
        QLog.w("CameraUtils", 1, paramContext.toString());
      }
      CameraManagerApiImpl.access$800(this.a).a(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.camera.api.impl.CameraManagerApiImpl.CameraAvailabilityReceiver
 * JD-Core Version:    0.7.0.1
 */