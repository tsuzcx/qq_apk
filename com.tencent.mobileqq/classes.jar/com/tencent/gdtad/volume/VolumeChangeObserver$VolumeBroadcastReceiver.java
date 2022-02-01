package com.tencent.gdtad.volume;

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
    boolean bool;
    if (i == 3) {
      bool = true;
    } else {
      bool = false;
    }
    paramContext = new StringBuilder();
    paramContext.append("VolumeBroadcastReceiver action type = ");
    paramContext.append(paramIntent.getAction());
    paramContext.append(", isStreamMusic = ");
    paramContext.append(bool);
    paramContext.append(", streamType = ");
    paramContext.append(i);
    GdtLog.a("VolumeBroadcastReceiver", paramContext.toString());
    if (("android.media.VOLUME_CHANGED_ACTION".equals(paramIntent.getAction())) && (bool) && (VolumeChangeObserver.a(this.a) != null)) {
      VolumeChangeObserver.a(this.a).a(new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.volume.VolumeChangeObserver.VolumeBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */