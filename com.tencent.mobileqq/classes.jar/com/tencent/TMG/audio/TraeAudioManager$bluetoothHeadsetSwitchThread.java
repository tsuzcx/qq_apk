package com.tencent.TMG.audio;

import android.annotation.TargetApi;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.TMG.utils.QLog;

class TraeAudioManager$bluetoothHeadsetSwitchThread
  extends TraeAudioManager.switchThread
{
  TraeAudioManager$bluetoothHeadsetSwitchThread(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  @TargetApi(8)
  public void _quit()
  {
    if (this.this$0._am == null) {
      return;
    }
    _stopBluetoothSco();
  }
  
  public void _run()
  {
    if ((TraeAudioManager.IsMusicScene) || (!TraeAudioManager.IsUpdateSceneFlag))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "connect bluetoothHeadset: do nothing, IsMusicScene:" + TraeAudioManager.IsMusicScene + " ,IsUpdateSceneFlag:" + TraeAudioManager.IsUpdateSceneFlag);
      }
      updateStatus();
    }
    for (;;)
    {
      return;
      try
      {
        Thread.sleep(1000L);
        label67:
        _startBluetoothSco();
        int i = 0;
        for (;;)
        {
          int j;
          StringBuilder localStringBuilder;
          if (this._running == true)
          {
            j = i + 1;
            if (i < 10) {
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder().append("bluetoothHeadsetSwitchThread i:").append(j).append(" sco:");
                if (!this.this$0._am.isBluetoothScoOn()) {
                  break label243;
                }
              }
            }
          }
          label243:
          for (String str = "Y";; str = "N")
          {
            QLog.w("TRAE", 0, str + " :" + this.this$0._deviceConfigManager.getBluetoothName());
            if (!this.this$0._am.isBluetoothScoOn()) {
              break label249;
            }
            updateStatus();
            if (this.this$0._am.isBluetoothScoOn()) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.e("TRAE", 0, "bluetoothHeadsetSwitchThread sco fail,remove btheadset");
            }
            this.this$0._deviceConfigManager.setVisible(getDeviceName(), false);
            processDeviceConnectRes(10);
            this.this$0.checkAutoDeviceListUpdate();
            return;
          }
          try
          {
            label249:
            Thread.sleep(1000L);
            i = j;
          }
          catch (InterruptedException localInterruptedException1)
          {
            i = j;
          }
        }
      }
      catch (InterruptedException localInterruptedException2)
      {
        break label67;
      }
    }
  }
  
  @TargetApi(8)
  void _startBluetoothSco()
  {
    this.this$0._am.setBluetoothScoOn(true);
    if (Build.VERSION.SDK_INT > 8) {
      this.this$0._am.startBluetoothSco();
    }
  }
  
  @TargetApi(8)
  void _stopBluetoothSco()
  {
    if (Build.VERSION.SDK_INT > 8) {
      this.this$0._am.stopBluetoothSco();
    }
    this.this$0._am.setBluetoothScoOn(false);
  }
  
  public String getDeviceName()
  {
    return "DEVICE_BLUETOOTHHEADSET";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.bluetoothHeadsetSwitchThread
 * JD-Core Version:    0.7.0.1
 */