package com.tencent.TMG.audio;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(11)
class TraeAudioManager$BluetoohHeadsetCheck
  extends TraeAudioManager.BluetoohHeadsetCheckInterface
  implements BluetoothProfile.ServiceListener
{
  BluetoothAdapter _adapter = null;
  Context _ctx = null;
  TraeAudioManager.DeviceConfigManager _devCfg = null;
  BluetoothProfile _profile = null;
  private final ReentrantLock _profileLock = new ReentrantLock();
  
  TraeAudioManager$BluetoohHeadsetCheck(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  void _addAction(IntentFilter paramIntentFilter)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, " " + interfaceDesc() + " _addAction");
    }
    paramIntentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    paramIntentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
    paramIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
  }
  
  void _onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    int j;
    if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
      j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
      paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "BT ACTION_CONNECTION_STATE_CHANGED|   EXTRA_CONNECTION_STATE " + getBTAdapterConnectionState(i));
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "    EXTRA_PREVIOUS_CONNECTION_STATE " + getBTAdapterConnectionState(j));
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("    EXTRA_DEVICE ").append(paramIntent).append(" ");
        if (paramIntent != null)
        {
          paramContext = paramIntent.getName();
          QLog.w("TRAE", 0, paramContext);
        }
      }
      else
      {
        if (i != 2) {
          break label252;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "   dev:" + paramIntent.getName() + " connected,start sco...");
        }
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
        localObject = this._devCfg;
        if (paramIntent == null) {
          break label246;
        }
        paramContext = paramIntent.getName();
        label233:
        ((TraeAudioManager.DeviceConfigManager)localObject).setBluetoothName(paramContext);
      }
    }
    label246:
    label252:
    do
    {
      do
      {
        do
        {
          return;
          paramContext = " ";
          break;
          paramContext = "unkown";
          break label233;
        } while (i != 0);
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
        return;
        if (!"android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(paramIntent.getAction())) {
          break label410;
        }
        i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
        j = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
        paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "BT ACTION_SCO_AUDIO_STATE_UPDATED|   EXTRA_CONNECTION_STATE  dev:" + paramContext);
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "   EXTRA_SCO_AUDIO_STATE " + getSCOAudioStateExtraString(i));
        }
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 0, "   EXTRA_SCO_AUDIO_PREVIOUS_STATE " + getSCOAudioStateExtraString(j));
      return;
    } while (!"android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()));
    label410:
    paramContext = BluetoothAdapter.getDefaultAdapter();
    switch (paramContext.getProfileConnectionState(2))
    {
    case 1: 
    default: 
      QLog.w("TRAE", 0, "BluetoothA2dp" + paramContext.getProfileConnectionState(2));
      return;
    case 2: 
      QLog.w("TRAE", 0, "BluetoothA2dp STATE_CONNECTED");
      this.this$0.IsBluetoothA2dpExisted = true;
      return;
    }
    QLog.w("TRAE", 0, "BluetoothA2dp STATE_DISCONNECTED");
    this.this$0.IsBluetoothA2dpExisted = false;
  }
  
  @TargetApi(11)
  public boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
  {
    AudioDeviceInterface.LogTraceEntry("");
    if ((paramContext == null) || (paramDeviceConfigManager == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 0, " err ctx==null||_devCfg==null");
      }
    }
    do
    {
      return false;
      this._ctx = paramContext;
      this._devCfg = paramDeviceConfigManager;
      this._adapter = BluetoothAdapter.getDefaultAdapter();
      if (this._adapter != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 0, " err getDefaultAdapter fail!");
    return false;
    this._profileLock.lock();
    try
    {
      if ((this._adapter.isEnabled()) && (this._profile == null) && (!this._adapter.getProfileProxy(this._ctx, this, 1)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!");
        }
        return false;
      }
      this._profileLock.unlock();
      AudioDeviceInterface.LogTraceExit();
      return true;
    }
    finally
    {
      this._profileLock.unlock();
    }
  }
  
  public String interfaceDesc()
  {
    return "BluetoohHeadsetCheck";
  }
  
  public boolean isConnected()
  {
    boolean bool2 = false;
    this._profileLock.lock();
    boolean bool1 = bool2;
    try
    {
      if (this._profile != null)
      {
        List localList = this._profile.getConnectedDevices();
        if (localList == null) {
          return false;
        }
        int i = localList.size();
        bool1 = bool2;
        if (i > 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally
    {
      this._profileLock.unlock();
    }
  }
  
  @TargetApi(11)
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile + " profile:" + paramInt + " proxy:" + paramBluetoothProfile);
    if (paramInt == 1) {
      this._profileLock.lock();
    }
    for (;;)
    {
      int i;
      try
      {
        if ((this._profile != null) && (this._profile != paramBluetoothProfile))
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 0, "BluetoohHeadsetCheck: HEADSET Connected proxy:" + paramBluetoothProfile + " _profile:" + this._profile);
          }
          this._adapter.closeProfileProxy(1, this._profile);
          this._profile = null;
        }
        this._profile = paramBluetoothProfile;
        if (this._profile == null) {
          break label464;
        }
        paramBluetoothProfile = this._profile.getConnectedDevices();
        if ((paramBluetoothProfile != null) && (this._profile != null))
        {
          if (!QLog.isColorLevel()) {
            break label469;
          }
          QLog.w("TRAE", 0, "TRAEBluetoohProxy: HEADSET Connected devs:" + paramBluetoothProfile.size() + " _profile:" + this._profile);
          break label469;
          if (i < paramBluetoothProfile.size())
          {
            BluetoothDevice localBluetoothDevice = (BluetoothDevice)paramBluetoothProfile.get(i);
            try
            {
              if (this._profile == null) {
                break label459;
              }
              paramInt = this._profile.getConnectionState(localBluetoothDevice);
              if (paramInt == 2) {
                this._devCfg.setBluetoothName(localBluetoothDevice.getName());
              }
              if (QLog.isColorLevel()) {
                QLog.w("TRAE", 0, "   " + i + " " + localBluetoothDevice.getName() + " ConnectionState:" + paramInt);
              }
              i += 1;
            }
            catch (Exception localException)
            {
              paramInt = 0;
              continue;
            }
          }
        }
        this._profileLock.unlock();
        if (this._devCfg != null)
        {
          if (this.this$0._deviceConfigManager == null) {
            break label454;
          }
          paramBluetoothProfile = this.this$0._deviceConfigManager.getBluetoothName();
          if (TextUtils.isEmpty(paramBluetoothProfile)) {
            this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
          }
        }
        else
        {
          AudioDeviceInterface.LogTraceExit();
          return;
        }
      }
      finally
      {
        this._profileLock.unlock();
      }
      if (isConnected())
      {
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
        this.this$0.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
      }
      else
      {
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
        continue;
        label454:
        paramBluetoothProfile = null;
        continue;
        label459:
        paramInt = 0;
        continue;
        label464:
        paramBluetoothProfile = null;
        continue;
        label469:
        i = 0;
      }
    }
  }
  
  @TargetApi(11)
  public void onServiceDisconnected(int paramInt)
  {
    AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile + " profile:" + paramInt);
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "TRAEBluetoohProxy: HEADSET Disconnected");
      }
      if (isConnected()) {
        this.this$0.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", false);
      }
      this._profileLock.lock();
    }
    try
    {
      if (this._profile != null)
      {
        this._adapter.closeProfileProxy(1, this._profile);
        this._profile = null;
      }
      this._profileLock.unlock();
      AudioDeviceInterface.LogTraceExit();
      return;
    }
    finally
    {
      this._profileLock.unlock();
    }
  }
  
  public void release()
  {
    AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile);
    this._profileLock.lock();
    try
    {
      if (this._adapter != null)
      {
        if (this._profile != null) {
          this._adapter.closeProfileProxy(1, this._profile);
        }
        this._profile = null;
      }
      this._profileLock.unlock();
      AudioDeviceInterface.LogTraceExit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, " closeProfileProxy:e:" + localException.getMessage());
        }
        this._profileLock.unlock();
      }
    }
    finally
    {
      this._profileLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.BluetoohHeadsetCheck
 * JD-Core Version:    0.7.0.1
 */