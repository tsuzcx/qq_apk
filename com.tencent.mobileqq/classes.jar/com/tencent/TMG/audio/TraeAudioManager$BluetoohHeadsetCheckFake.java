package com.tencent.TMG.audio;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class TraeAudioManager$BluetoohHeadsetCheckFake
  extends TraeAudioManager.BluetoohHeadsetCheckInterface
{
  TraeAudioManager$BluetoohHeadsetCheckFake(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  void _addAction(IntentFilter paramIntentFilter) {}
  
  void _onReceive(Context paramContext, Intent paramIntent) {}
  
  public boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
  {
    return true;
  }
  
  public String interfaceDesc()
  {
    return "BluetoohHeadsetCheckFake";
  }
  
  public boolean isConnected()
  {
    return false;
  }
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.BluetoohHeadsetCheckFake
 * JD-Core Version:    0.7.0.1
 */