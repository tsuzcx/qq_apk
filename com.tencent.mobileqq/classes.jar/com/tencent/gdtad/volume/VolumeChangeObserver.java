package com.tencent.gdtad.volume;

import android.content.Context;
import android.content.IntentFilter;

public class VolumeChangeObserver
{
  private VolumeChangeObserver.VolumeChangeListener a;
  private VolumeChangeObserver.VolumeBroadcastReceiver b;
  private Context c;
  
  public VolumeChangeObserver(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public void a()
  {
    this.b = new VolumeChangeObserver.VolumeBroadcastReceiver(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    this.c.registerReceiver(this.b, localIntentFilter);
  }
  
  public void a(VolumeChangeObserver.VolumeChangeListener paramVolumeChangeListener)
  {
    this.a = paramVolumeChangeListener;
  }
  
  public void b()
  {
    VolumeChangeObserver.VolumeBroadcastReceiver localVolumeBroadcastReceiver = this.b;
    if (localVolumeBroadcastReceiver != null)
    {
      Context localContext = this.c;
      if (localContext != null)
      {
        localContext.unregisterReceiver(localVolumeBroadcastReceiver);
        this.a = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.volume.VolumeChangeObserver
 * JD-Core Version:    0.7.0.1
 */