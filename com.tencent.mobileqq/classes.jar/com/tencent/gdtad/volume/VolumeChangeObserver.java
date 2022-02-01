package com.tencent.gdtad.volume;

import android.content.Context;
import android.content.IntentFilter;

public class VolumeChangeObserver
{
  private Context jdField_a_of_type_AndroidContentContext;
  private VolumeChangeObserver.VolumeBroadcastReceiver jdField_a_of_type_ComTencentGdtadVolumeVolumeChangeObserver$VolumeBroadcastReceiver;
  private VolumeChangeObserver.VolumeChangeListener jdField_a_of_type_ComTencentGdtadVolumeVolumeChangeObserver$VolumeChangeListener;
  
  public VolumeChangeObserver(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentGdtadVolumeVolumeChangeObserver$VolumeBroadcastReceiver = new VolumeChangeObserver.VolumeBroadcastReceiver(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentGdtadVolumeVolumeChangeObserver$VolumeBroadcastReceiver, localIntentFilter);
  }
  
  public void a(VolumeChangeObserver.VolumeChangeListener paramVolumeChangeListener)
  {
    this.jdField_a_of_type_ComTencentGdtadVolumeVolumeChangeObserver$VolumeChangeListener = paramVolumeChangeListener;
  }
  
  public void b()
  {
    VolumeChangeObserver.VolumeBroadcastReceiver localVolumeBroadcastReceiver = this.jdField_a_of_type_ComTencentGdtadVolumeVolumeChangeObserver$VolumeBroadcastReceiver;
    if (localVolumeBroadcastReceiver != null)
    {
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      if (localContext != null)
      {
        localContext.unregisterReceiver(localVolumeBroadcastReceiver);
        this.jdField_a_of_type_ComTencentGdtadVolumeVolumeChangeObserver$VolumeChangeListener = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.volume.VolumeChangeObserver
 * JD-Core Version:    0.7.0.1
 */