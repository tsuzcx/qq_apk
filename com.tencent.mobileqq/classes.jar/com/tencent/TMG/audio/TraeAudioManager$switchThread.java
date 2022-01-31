package com.tencent.TMG.audio;

import android.content.Intent;
import com.tencent.TMG.utils.QLog;
import java.util.HashMap;

abstract class TraeAudioManager$switchThread
  extends Thread
{
  boolean[] _exited = { false };
  HashMap<String, Object> _params = null;
  boolean _running = true;
  long _usingtime = 0L;
  
  TraeAudioManager$switchThread(TraeAudioManager paramTraeAudioManager)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, " ++switchThread:" + getDeviceName());
    }
  }
  
  public abstract void _quit();
  
  public abstract void _run();
  
  public abstract String getDeviceName();
  
  void processDeviceConnectRes(int paramInt)
  {
    this.this$0.InternalNotifyDeviceChangableUpdate();
    AudioDeviceInterface.LogTraceEntry(getDeviceName() + " err:" + paramInt);
    if (this._params == null) {
      this.this$0.InternalNotifyDeviceListUpdate();
    }
    do
    {
      return;
      this.this$0.sessionConnectedDev = this.this$0._deviceConfigManager.getConnectedDevice();
      localObject = (Long)this._params.get("PARAM_SESSIONID");
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, " sessonID:" + localObject);
      }
      if ((localObject != null) && (((Long)localObject).longValue() != -9223372036854775808L)) {
        break;
      }
      this.this$0.InternalNotifyDeviceListUpdate();
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 0, "processDeviceConnectRes sid null,don't send res");
    return;
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)this._params.get("PARAM_DEVICE"));
    if (this.this$0.sendResBroadcast((Intent)localObject, this._params, paramInt) == 0) {
      this.this$0.InternalNotifyDeviceListUpdate();
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  public void quit()
  {
    AudioDeviceInterface.LogTraceEntry(getDeviceName());
    this._running = false;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, " quit:" + getDeviceName() + " _running:" + this._running);
    }
    interrupt();
    _quit();
    synchronized (this._exited)
    {
      int i = this._exited[0];
      if (i != 0) {}
    }
    try
    {
      this._exited.wait(10000L);
      label94:
      AudioDeviceInterface.LogTraceExit();
      return;
      localObject = finally;
      throw localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label94;
    }
  }
  
  public void run()
  {
    AudioDeviceInterface.LogTraceEntry(getDeviceName());
    this.this$0._deviceConfigManager.setConnecting(getDeviceName());
    this.this$0.InternalNotifyDeviceChangableUpdate();
    _run();
    synchronized (this._exited)
    {
      this._exited[0] = true;
      this._exited.notifyAll();
      AudioDeviceInterface.LogTraceExit();
      return;
    }
  }
  
  public void setDeviceConnectParam(HashMap<String, Object> paramHashMap)
  {
    this._params = paramHashMap;
  }
  
  void updateStatus()
  {
    this.this$0._deviceConfigManager.setConnected(getDeviceName());
    processDeviceConnectRes(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.switchThread
 * JD-Core Version:    0.7.0.1
 */