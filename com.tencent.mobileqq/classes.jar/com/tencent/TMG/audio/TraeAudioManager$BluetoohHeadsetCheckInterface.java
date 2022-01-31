package com.tencent.TMG.audio;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.TMG.utils.QLog;

abstract class TraeAudioManager$BluetoohHeadsetCheckInterface
{
  TraeAudioManager$BluetoohHeadsetCheckInterface(TraeAudioManager paramTraeAudioManager) {}
  
  abstract void _addAction(IntentFilter paramIntentFilter);
  
  abstract void _onReceive(Context paramContext, Intent paramIntent);
  
  public void addAction(IntentFilter paramIntentFilter)
  {
    paramIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    paramIntentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
    paramIntentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
    _addAction(paramIntentFilter);
  }
  
  String getBTActionStateChangedExtraString(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknow";
    }
    for (;;)
    {
      return str + ":" + paramInt;
      str = "STATE_OFF";
      continue;
      str = "STATE_TURNING_ON";
      continue;
      str = "STATE_ON";
      continue;
      str = "STATE_TURNING_OFF";
    }
  }
  
  String getBTAdapterConnectionState(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknow";
    }
    for (;;)
    {
      return str + ":" + paramInt;
      str = "STATE_DISCONNECTED";
      continue;
      str = "STATE_CONNECTING";
      continue;
      str = "STATE_CONNECTED";
      continue;
      str = "STATE_DISCONNECTING";
    }
  }
  
  String getBTHeadsetAudioState(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 11: 
    default: 
      str = "unknow:" + paramInt;
    }
    for (;;)
    {
      return str + ":" + paramInt;
      str = "STATE_AUDIO_CONNECTED";
      continue;
      str = "STATE_AUDIO_DISCONNECTED";
    }
  }
  
  String getBTHeadsetConnectionState(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknow";
    }
    for (;;)
    {
      return str + ":" + paramInt;
      str = "STATE_DISCONNECTED";
      continue;
      str = "STATE_CONNECTING";
      continue;
      str = "STATE_CONNECTED";
      continue;
      str = "STATE_DISCONNECTING";
    }
  }
  
  String getSCOAudioStateExtraString(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknow";
    }
    for (;;)
    {
      return str + ":" + paramInt;
      str = "SCO_AUDIO_STATE_DISCONNECTED";
      continue;
      str = "SCO_AUDIO_STATE_CONNECTED";
      continue;
      str = "SCO_AUDIO_STATE_CONNECTING";
      continue;
      str = "SCO_AUDIO_STATE_ERROR";
    }
  }
  
  public abstract boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager);
  
  public abstract String interfaceDesc();
  
  public abstract boolean isConnected();
  
  public void onReceive(Context paramContext, Intent paramIntent, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
  {
    if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
      j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "BT ACTION_STATE_CHANGED|   EXTRA_STATE " + getBTActionStateChangedExtraString(i));
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "BT ACTION_STATE_CHANGED|   EXTRA_PREVIOUS_STATE " + getBTActionStateChangedExtraString(j));
      }
      if (i == 10) {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "    BT off");
        }
      }
    }
    while ((("android.bluetooth.device.action.ACL_CONNECTED".equals(paramIntent.getAction())) && (Build.VERSION.SDK_INT < 11)) || (("android.bluetooth.device.action.ACL_DISCONNECTED".equals(paramIntent.getAction())) && (Build.VERSION.SDK_INT < 11)))
    {
      int i;
      int j;
      paramDeviceConfigManager.setVisible("DEVICE_BLUETOOTHHEADSET", false);
      do
      {
        return;
      } while ((i != 12) || (!QLog.isColorLevel()));
      QLog.w("TRAE", 0, "BT OFF-->ON,Visiable it...");
      return;
    }
    _onReceive(paramContext, paramIntent);
  }
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.BluetoohHeadsetCheckInterface
 * JD-Core Version:    0.7.0.1
 */