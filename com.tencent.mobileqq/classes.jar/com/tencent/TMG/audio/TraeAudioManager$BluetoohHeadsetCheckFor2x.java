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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ");
      localStringBuilder.append(interfaceDesc());
      localStringBuilder.append(" _addAction");
      QLog.w("TRAE", 0, localStringBuilder.toString());
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
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("++ AUDIO_STATE_CHANGED|  STATE ");
        paramContext.append(i);
        QLog.w("TRAE", 0, paramContext.toString());
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("       PREVIOUS_STATE ");
        paramContext.append(j);
        QLog.w("TRAE", 0, paramContext.toString());
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("       AUDIO_STATE ");
        paramContext.append(k);
        QLog.w("TRAE", 0, paramContext.toString());
      }
      if (k == 2)
      {
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
        return;
      }
      if (k == 0) {
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
      }
    }
    else if ("android.bluetooth.headset.action.STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
      j = paramIntent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
      k = paramIntent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("++ STATE_CHANGED|  STATE ");
        paramContext.append(i);
        QLog.w("TRAE", 0, paramContext.toString());
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("       PREVIOUS_STATE ");
        paramContext.append(j);
        QLog.w("TRAE", 0, paramContext.toString());
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("       AUDIO_STATE ");
        paramContext.append(k);
        QLog.w("TRAE", 0, paramContext.toString());
      }
      if (k == 2)
      {
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
        return;
      }
      if (k == 0) {
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
      }
    }
  }
  
  public boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
  {
    AudioDeviceInterface.LogTraceEntry("");
    this._ctx = paramContext;
    this._devCfg = paramDeviceConfigManager;
    if (this._ctx != null) {
      if (this._devCfg == null) {
        return false;
      }
    }
    try
    {
      this.BluetoothHeadsetClass = Class.forName("android.bluetooth.BluetoothHeadset");
    }
    catch (Exception paramDeviceConfigManager)
    {
      label43:
      break label43;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset class not found");
    }
    if (this.BluetoothHeadsetClass == null) {
      return false;
    }
    try
    {
      this.ListenerClass = Class.forName("android.bluetooth.BluetoothHeadset$ServiceListener");
    }
    catch (Exception paramDeviceConfigManager)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("BTLooperThread BluetoothHeadset.ServiceListener class not found:");
        localStringBuilder.append(paramDeviceConfigManager);
        QLog.e("TRAE", 0, localStringBuilder.toString());
      }
    }
    paramDeviceConfigManager = this.ListenerClass;
    label141:
    label277:
    label291:
    try
    {
      this.getCurrentHeadsetMethod = this.BluetoothHeadsetClass.getDeclaredMethod("getCurrentHeadset", new Class[0]);
    }
    catch (NoSuchMethodException paramDeviceConfigManager)
    {
      label209:
      label226:
      label243:
      break label141;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset method getCurrentHeadset NoSuchMethodException");
    }
    if (this.getCurrentHeadsetMethod == null) {
      return false;
    }
    try
    {
      this.BluetoothHeadsetObj = this.BluetoothHeadsetClass.getConstructor(new Class[] { Context.class, this.ListenerClass }).newInstance(new Object[] { paramContext, null });
    }
    catch (IllegalArgumentException paramContext)
    {
      break label277;
    }
    catch (InstantiationException paramContext)
    {
      break label260;
    }
    catch (IllegalAccessException paramContext)
    {
      break label243;
    }
    catch (InvocationTargetException paramContext)
    {
      break label226;
    }
    catch (NoSuchMethodException paramContext)
    {
      label260:
      break label209;
    }
    if (QLog.isColorLevel())
    {
      QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset getConstructor NoSuchMethodException");
      break label291;
      if (QLog.isColorLevel())
      {
        QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset getConstructor InvocationTargetException");
        break label291;
        if (QLog.isColorLevel())
        {
          QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset getConstructor IllegalAccessException");
          break label291;
          if (QLog.isColorLevel())
          {
            QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset getConstructor InstantiationException");
            break label291;
            if (QLog.isColorLevel()) {
              QLog.e("TRAE", 0, "BTLooperThread BluetoothHeadset getConstructor IllegalArgumentException");
            }
          }
        }
      }
    }
    if (this.BluetoothHeadsetObj == null) {
      return false;
    }
    this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", isConnected());
    if (isConnected())
    {
      this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
      this.this$0.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
    }
    else
    {
      this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
    }
    AudioDeviceInterface.LogTraceExit();
    return true;
    return false;
  }
  
  public String interfaceDesc()
  {
    return "BluetoohHeadsetCheckFor2x";
  }
  
  public boolean isConnected()
  {
    Object localObject = this.getCurrentHeadsetMethod;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null) {
      if (localObject == null) {
        return false;
      }
    }
    try
    {
      localObject = ((Method)localObject).invoke(this.BluetoothHeadsetObj, new Object[0]);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      StringBuilder localStringBuilder;
      String str;
      break label69;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label52;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label35:
      label52:
      label69:
      break label35;
    }
    if (QLog.isColorLevel())
    {
      QLog.w("TRAE", 0, "BTLooperThread BluetoothHeadset method getCurrentHeadset InvocationTargetException");
      break label83;
      if (QLog.isColorLevel())
      {
        QLog.w("TRAE", 0, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalAccessException");
        break label83;
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 0, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalArgumentException");
        }
      }
    }
    label83:
    localObject = null;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("BTLooperThread BluetoothHeadset method getCurrentHeadset res:");
      if (localObject != null) {
        str = " Y";
      } else {
        str = "N";
      }
      localStringBuilder.append(str);
      QLog.w("TRAE", 0, localStringBuilder.toString());
    }
    bool1 = bool2;
    if (localObject != null) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void release()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this.BluetoothHeadsetObj == null) {
      return;
    }
    try
    {
      localMethod = this.BluetoothHeadsetClass.getDeclaredMethod("close", new Class[0]);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      try
      {
        Method localMethod;
        localMethod.invoke(this.BluetoothHeadsetObj, new Object[0]);
        this.BluetoothHeadsetClass = null;
        this.ListenerClass = null;
        this.BluetoothHeadsetObj = null;
        this.getCurrentHeadsetMethod = null;
        AudioDeviceInterface.LogTraceExit();
        return;
        localNoSuchMethodException = localNoSuchMethodException;
      }
      catch (IllegalArgumentException|IllegalAccessException|InvocationTargetException localIllegalArgumentException)
      {
        break label64;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("TRAE", 0, "BTLooperThread _uninitHeadsetfor2x method close NoSuchMethodException");
    }
    localMethod = null;
    if (localMethod == null) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.BluetoohHeadsetCheckFor2x
 * JD-Core Version:    0.7.0.1
 */