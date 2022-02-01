package com.tencent.gdtad.api.motivevideo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.gdtad.log.GdtLog;

class VolumeChangeObserver$VolumeBroadcastReceiver
  extends BroadcastReceiver
{
  private VolumeChangeObserver$VolumeBroadcastReceiver(VolumeChangeObserver paramVolumeChangeObserver) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
    if (i == 3) {}
    for (boolean bool = true;; bool = false)
    {
      GdtLog.a("VolumeBroadcastReceiver", "VolumeBroadcastReceiver action type = " + paramIntent.getAction() + ", isStreamMusic = " + bool + ", streamType = " + i);
      if (("android.media.VOLUME_CHANGED_ACTION".equals(paramIntent.getAction())) && (bool) && (VolumeChangeObserver.a(this.a) != null)) {
        VolumeChangeObserver.a(this.a).a(new Object[0]);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.VolumeChangeObserver.VolumeBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */