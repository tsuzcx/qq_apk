package com.tencent.TMG.audio;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.TMG.utils.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TraeAudioManager$BluetoohHeadsetCheckFor2x
  extends TraeAudioManager.BluetoohHeadsetCheckInterface
{
  public static final String ACTION_BLUETOOTHHEADSET_AUDIO_STATE_CHANGED = "android.bluetooth.headset.action.AUDIO_STATE_CHANGED";
  public static final String ACTION_BLUETOOTHHEADSET_STATE_CHANGED = "android.bluetooth.headset.action.STATE_CHANGED";
  public static final int AUDIO_STATE_CONNECTED = 1;
  public static final int AUDIO_STATE_DISCONNECTED = 0;
  static final int STATE_CONNECTED = 2;
  static final int STATE_DISCONNECTED = 0;
  Class<?> BluetoothHeadsetClass = null;
  Object BluetoothHeadsetObj = null;
  Class<?> ListenerClass = null;
  Context _ctx = null;
  TraeAudioManager.DeviceConfigManager _devCfg = null;
  Method getCurrentHeadsetMethod = null;
  
  TraeAudioManager$BluetoohHeadsetCheckFor2x(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  void _addAction(IntentFilter paramIntentFilter)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, " " + interfaceDesc() + " _addAction");
    }
    paramIntentFilter.addAction("android.bluetooth.headset.action.AUDIO_STATE_CHANGED");
    paramIntentFilter.addAction("android.bluetooth.headset.action.STATE_CHANGED");
  }
  
  void _onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    int j;
    int k;
    if ("android.bluetooth.headset.action.AUDIO_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
      j = paramIntent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
      k = paramIntent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "++ AUDIO_STATE_CHANGED|  STATE " + i);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "       PREVIOUS_STATE " + j);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "       AUDIO_STATE " + k);
      }
      if (k != 2) {}
    }
    do
    {
      do
      {
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
        do
        {
          return;
        } while (k != 0);
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
        return;
      } while (!"android.bluetooth.headset.action.STATE_CHANGED".equals(paramIntent.getAction()));
      i = paramIntent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
      j = paramIntent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
      k = paramIntent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "++ STATE_CHANGED|  STATE " + i);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "       PREVIOUS_STATE " + j);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, "       AUDIO_STATE " + k);
      }
      if (k == 2)
      {
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
        return;
      }
    } while (k != 0);
    this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
  }
  
  public boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
  {
    AudioDeviceInterface.LogTraceEntry("");
    this._ctx = paramContext;
    this._devCfg = paramDeviceConfigManager;
    if ((this._ctx == null) || (this._devCfg == null)) {}
    for (;;)
    {
      return false;
      try
      {
        this.BluetoothHeadsetClass = Class.forName("android.bluetooth.BluetoothHeadset");
        if (this.BluetoothHeadsetClass == null) {
          continue;
        }
      }
      catch (Exception paramDeviceConfigManager)
      {
        try
        {
          this.ListenerClass = Class.forName("android.bluetooth.BluetoothHeadset$ServiceListener");
          if (this.ListenerClass != null) {}
        }
        catch (Exception paramDeviceConfigManager)
        {
          try
          {
            this.getCurrentHeadsetMethod = this.BluetoothHeadsetClass.getDeclaredMethod("getCurrentHeadset", new Class[0]);
            if (this.getCurrentHeadsetMethod == null) {
              continue;
            }
          }
          catch (NoSuchMethodException paramDeviceConfigManager)
          {
            try
            {
              do
              {
                for (;;)
                {
                  this.BluetoothHeadsetObj = this.BluetoothHeadsetClass.getConstructor(new Class[] { Context.class, this.ListenerClass }).newInstance(new Object[] { paramContext, null });
                  if (this.BluetoothHeadsetObj == null) {
                    break;
                  }
                  this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", isConnected());
                  if (!isConnected()) {
                    break label344;
                  }
                  this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
                  this.this$0.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
                  AudioDeviceInterface.LogTraceExit();
                  return true;
                  paramDeviceConfigManager = paramDeviceConfigManager;
                  if (QLog.isColorLevel())
                  {
                    QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset class not found");
                    continue;
                    paramDeviceConfigManager = paramDeviceConfigManager;
                    if (QLog.isColorLevel()) {
                      QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset.ServiceListener class not found:" + paramDeviceConfigManager);
                    }
                  }
                }
                paramDeviceConfigManager = paramDeviceConfigManager;
              } while (!QLog.isColorLevel());
              QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset method getCurrentHeadset NoSuchMethodException");
            }
            catch (IllegalArgumentException paramContext)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset getConstructor IllegalArgumentException");
                }
              }
            }
            catch (InstantiationException paramContext)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset getConstructor InstantiationException");
                }
              }
            }
            catch (IllegalAccessException paramContext)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset getConstructor IllegalAccessException");
                }
              }
            }
            catch (InvocationTargetException paramContext)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset getConstructor InvocationTargetException");
                }
              }
            }
            catch (NoSuchMethodException paramContext)
            {
              for (;;)
              {
                if (QLog.isColorLevel())
                {
                  QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset getConstructor NoSuchMethodException");
                  continue;
                  label344:
                  this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public String interfaceDesc()
  {
    return "BluetoohHeadsetCheckFor2x";
  }
  
  public boolean isConnected()
  {
    String str4 = null;
    if ((this.getCurrentHeadsetMethod == null) || (this.getCurrentHeadsetMethod == null)) {
      return false;
    }
    try
    {
      Object localObject = this.getCurrentHeadsetMethod.invoke(this.BluetoothHeadsetObj, new Object[0]);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("BTLooperThread BluetoothHeadset method getCurrentHeadset res:");
        if (localObject != null)
        {
          str4 = " Y";
          QLog.w("TRAE", 0, str4);
        }
      }
      else
      {
        if (localObject == null) {
          break label152;
        }
        return true;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        String str1 = str4;
        if (QLog.isColorLevel())
        {
          QLog.w("TRAE", 0, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalArgumentException");
          str1 = str4;
        }
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        String str2 = str4;
        if (QLog.isColorLevel())
        {
          QLog.w("TRAE", 0, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalAccessException");
          str2 = str4;
        }
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        String str3 = str4;
        if (QLog.isColorLevel())
        {
          QLog.w("TRAE", 0, "BTLooperThread BluetoothHeadset method getCurrentHeadset InvocationTargetException");
          str3 = str4;
          continue;
          str4 = "N";
        }
      }
    }
    label152:
    return false;
  }
  
  public void release()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this.BluetoothHeadsetObj == null) {}
    for (;;)
    {
      return;
      try
      {
        localMethod = this.BluetoothHeadsetClass.getDeclaredMethod("close", new Class[0]);
        if (localMethod == null) {
          continue;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        try
        {
          Method localMethod;
          localMethod.invoke(this.BluetoothHeadsetObj, new Object[0]);
          label44:
          this.BluetoothHeadsetClass = null;
          this.ListenerClass = null;
          this.BluetoothHeadsetObj = null;
          this.getCurrentHeadsetMethod = null;
          AudioDeviceInterface.LogTraceExit();
          return;
          localNoSuchMethodException = localNoSuchMethodException;
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 0, "BTLooperThread _uninitHeadsetfor2x method close NoSuchMethodException");
          }
          Object localObject = null;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          break label44;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          break label44;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          break label44;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.BluetoohHeadsetCheckFor2x
 * JD-Core Version:    0.7.0.1
 */