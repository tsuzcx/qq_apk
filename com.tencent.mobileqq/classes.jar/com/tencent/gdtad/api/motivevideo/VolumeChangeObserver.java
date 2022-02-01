package com.tencent.gdtad.api.motivevideo;

import android.content.Context;
import android.content.IntentFilter;

public class VolumeChangeObserver
{
  private Context jdField_a_of_type_AndroidContentContext;
  private VolumeChangeObserver.VolumeBroadcastReceiver jdField_a_of_type_ComTencentGdtadApiMotivevideoVolumeChangeObserver$VolumeBroadcastReceiver;
  private VolumeChangeObserver.VolumeChangeListener jdField_a_of_type_ComTencentGdtadApiMotivevideoVolumeChangeObserver$VolumeChangeListener;
  
  public VolumeChangeObserver(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoVolumeChangeObserver$VolumeBroadcastReceiver = new VolumeChangeObserver.VolumeBroadcastReceiver(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoVolumeChangeObserver$VolumeBroadcastReceiver, localIntentFilter);
  }
  
  public void a(VolumeChangeObserver.VolumeChangeListener paramVolumeChangeListener)
  {
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoVolumeChangeObserver$VolumeChangeListener = paramVolumeChangeListener;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoVolumeChangeObserver$VolumeBroadcastReceiver != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoVolumeChangeObserver$VolumeBroadcastReceiver);
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoVolumeChangeObserver$VolumeChangeListener = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.VolumeChangeObserver
 * JD-Core Version:    0.7.0.1
 */