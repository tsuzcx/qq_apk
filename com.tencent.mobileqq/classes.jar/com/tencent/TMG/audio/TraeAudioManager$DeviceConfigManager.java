package com.tencent.TMG.audio;

import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

class TraeAudioManager$DeviceConfigManager
{
  String _bluetoothDevName = "unknow";
  String connectedDevice = "DEVICE_NONE";
  String connectingDevice = "DEVICE_NONE";
  HashMap<String, TraeAudioManager.DeviceConfigManager.DeviceConfig> deviceConfigs = new HashMap();
  ReentrantLock mLock = new ReentrantLock();
  String prevConnectedDevice = "DEVICE_NONE";
  boolean visiableUpdate = false;
  
  public TraeAudioManager$DeviceConfigManager(TraeAudioManager paramTraeAudioManager) {}
  
  boolean _addConfig(String paramString, int paramInt)
  {
    AudioDeviceInterface.LogTraceEntry(" devName:" + paramString + " priority:" + paramInt);
    TraeAudioManager.DeviceConfigManager.DeviceConfig localDeviceConfig = new TraeAudioManager.DeviceConfigManager.DeviceConfig(this);
    if (localDeviceConfig.init(paramString, paramInt)) {
      if (this.deviceConfigs.containsKey(paramString)) {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 0, "err dev exist!");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return false;
      this.deviceConfigs.put(paramString, localDeviceConfig);
      this.visiableUpdate = true;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 0, " n" + getDeviceNumber() + " 0:" + getDeviceName(0));
      }
      AudioDeviceInterface.LogTraceExit();
      return true;
    }
    QLog.e("TRAE", 0, " err dev init!");
    return false;
  }
  
  ArrayList<String> _getAvailableDeviceList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.deviceConfigs.entrySet().iterator();
    while (localIterator.hasNext())
    {
      TraeAudioManager.DeviceConfigManager.DeviceConfig localDeviceConfig = (TraeAudioManager.DeviceConfigManager.DeviceConfig)((Map.Entry)localIterator.next()).getValue();
      if ((localDeviceConfig != null) && (localDeviceConfig.getVisible())) {
        localArrayList.add(localDeviceConfig.getDeviceName());
      }
    }
    return localArrayList;
  }
  
  String _getConnectedDevice()
  {
    TraeAudioManager.DeviceConfigManager.DeviceConfig localDeviceConfig = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(this.connectedDevice);
    if ((localDeviceConfig != null) && (localDeviceConfig.getVisible())) {
      return this.connectedDevice;
    }
    return "DEVICE_NONE";
  }
  
  String _getPrevConnectedDevice()
  {
    TraeAudioManager.DeviceConfigManager.DeviceConfig localDeviceConfig = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(this.prevConnectedDevice);
    if ((localDeviceConfig != null) && (localDeviceConfig.getVisible())) {
      return this.prevConnectedDevice;
    }
    return "DEVICE_NONE";
  }
  
  public void clearConfig()
  {
    this.mLock.lock();
    this.deviceConfigs.clear();
    this.prevConnectedDevice = "DEVICE_NONE";
    this.connectedDevice = "DEVICE_NONE";
    this.connectingDevice = "DEVICE_NONE";
    this.mLock.unlock();
  }
  
  public ArrayList<String> getAvailableDeviceList()
  {
    new ArrayList();
    this.mLock.lock();
    ArrayList localArrayList = _getAvailableDeviceList();
    this.mLock.unlock();
    return localArrayList;
  }
  
  public String getAvailabledHighestPriorityDevice()
  {
    Object localObject1 = null;
    this.mLock.lock();
    Iterator localIterator = this.deviceConfigs.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      ((Map.Entry)localObject2).getKey();
      ((Map.Entry)localObject2).getValue();
      TraeAudioManager.DeviceConfigManager.DeviceConfig localDeviceConfig = (TraeAudioManager.DeviceConfigManager.DeviceConfig)((Map.Entry)localObject2).getValue();
      if ((localDeviceConfig != null) && (localDeviceConfig.getVisible()))
      {
        if (localObject1 == null) {
          localObject2 = localDeviceConfig;
        }
        for (;;)
        {
          localObject1 = localObject2;
          break;
          localObject2 = localDeviceConfig;
          if (localDeviceConfig.getPriority() < localObject1.getPriority()) {
            localObject2 = localObject1;
          }
        }
      }
    }
    this.mLock.unlock();
    if (localObject1 != null) {
      return localObject1.getDeviceName();
    }
    return "DEVICE_SPEAKERPHONE";
  }
  
  public String getAvailabledHighestPriorityDevice(String paramString)
  {
    Object localObject1 = null;
    this.mLock.lock();
    Iterator localIterator = this.deviceConfigs.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      ((Map.Entry)localObject2).getKey();
      ((Map.Entry)localObject2).getValue();
      TraeAudioManager.DeviceConfigManager.DeviceConfig localDeviceConfig = (TraeAudioManager.DeviceConfigManager.DeviceConfig)((Map.Entry)localObject2).getValue();
      if ((localDeviceConfig != null) && (localDeviceConfig.getVisible()) && (!localDeviceConfig.getDeviceName().equals(paramString)))
      {
        if (localObject1 == null) {
          localObject2 = localDeviceConfig;
        }
        for (;;)
        {
          localObject1 = localObject2;
          break;
          localObject2 = localDeviceConfig;
          if (localDeviceConfig.getPriority() < localObject1.getPriority()) {
            localObject2 = localObject1;
          }
        }
      }
    }
    this.mLock.unlock();
    if (localObject1 != null) {
      return localObject1.getDeviceName();
    }
    return "DEVICE_SPEAKERPHONE";
  }
  
  public String getBluetoothName()
  {
    return this._bluetoothDevName;
  }
  
  public String getConnectedDevice()
  {
    this.mLock.lock();
    String str = _getConnectedDevice();
    this.mLock.unlock();
    return str;
  }
  
  public String getConnectingDevice()
  {
    this.mLock.lock();
    Object localObject = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(this.connectingDevice);
    if ((localObject != null) && (((TraeAudioManager.DeviceConfigManager.DeviceConfig)localObject).getVisible())) {}
    for (localObject = this.connectingDevice;; localObject = null)
    {
      this.mLock.unlock();
      return localObject;
    }
  }
  
  public String getDeviceName(int paramInt)
  {
    this.mLock.lock();
    Object localObject = this.deviceConfigs.entrySet().iterator();
    int i = 0;
    Map.Entry localEntry;
    if (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      if (i != paramInt) {}
    }
    for (localObject = (TraeAudioManager.DeviceConfigManager.DeviceConfig)localEntry.getValue();; localObject = null)
    {
      if (localObject != null) {}
      for (localObject = ((TraeAudioManager.DeviceConfigManager.DeviceConfig)localObject).getDeviceName();; localObject = "DEVICE_NONE")
      {
        this.mLock.unlock();
        return localObject;
        i += 1;
        break;
      }
    }
  }
  
  public int getDeviceNumber()
  {
    this.mLock.lock();
    int i = this.deviceConfigs.size();
    this.mLock.unlock();
    return i;
  }
  
  public String getPrevConnectedDevice()
  {
    this.mLock.lock();
    String str = _getPrevConnectedDevice();
    this.mLock.unlock();
    return str;
  }
  
  public int getPriority(String paramString)
  {
    this.mLock.lock();
    paramString = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(paramString);
    if (paramString != null) {}
    for (int i = paramString.getPriority();; i = -1)
    {
      this.mLock.unlock();
      return i;
    }
  }
  
  public HashMap<String, Object> getSnapParams()
  {
    HashMap localHashMap = new HashMap();
    this.mLock.lock();
    localHashMap.put("EXTRA_DATA_AVAILABLEDEVICE_LIST", _getAvailableDeviceList());
    localHashMap.put("EXTRA_DATA_CONNECTEDDEVICE", _getConnectedDevice());
    localHashMap.put("EXTRA_DATA_PREV_CONNECTEDDEVICE", _getPrevConnectedDevice());
    this.mLock.unlock();
    return localHashMap;
  }
  
  public boolean getVisiableUpdateFlag()
  {
    this.mLock.lock();
    boolean bool = this.visiableUpdate;
    this.mLock.unlock();
    return bool;
  }
  
  public boolean getVisible(String paramString)
  {
    this.mLock.lock();
    paramString = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(paramString);
    if (paramString != null) {}
    for (boolean bool = paramString.getVisible();; bool = false)
    {
      this.mLock.unlock();
      return bool;
    }
  }
  
  public boolean init(String paramString)
  {
    AudioDeviceInterface.LogTraceEntry(" strConfigs:" + paramString);
    if ((paramString == null) || (paramString.length() <= 0)) {}
    do
    {
      String str;
      do
      {
        return false;
        str = paramString.replace("\n", "").replace("\r", "");
      } while ((str == null) || (str.length() <= 0));
      paramString = str;
      if (str.indexOf(";") < 0) {
        paramString = str + ";";
      }
      paramString = paramString.split(";");
    } while ((paramString == null) || (1 > paramString.length));
    this.mLock.lock();
    int i = 0;
    while (i < paramString.length)
    {
      _addConfig(paramString[i], i);
      i += 1;
    }
    this.mLock.unlock();
    this.this$0.printDevices();
    return true;
  }
  
  public boolean isConnected(String paramString)
  {
    this.mLock.lock();
    TraeAudioManager.DeviceConfigManager.DeviceConfig localDeviceConfig = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(paramString);
    if ((localDeviceConfig != null) && (localDeviceConfig.getVisible())) {}
    for (boolean bool = this.connectedDevice.equals(paramString);; bool = false)
    {
      this.mLock.unlock();
      return bool;
    }
  }
  
  public void resetVisiableUpdateFlag()
  {
    this.mLock.lock();
    this.visiableUpdate = false;
    this.mLock.unlock();
  }
  
  public void setBluetoothName(String paramString)
  {
    if (paramString == null)
    {
      this._bluetoothDevName = "unknow";
      return;
    }
    if (paramString.isEmpty())
    {
      this._bluetoothDevName = "unknow";
      return;
    }
    this._bluetoothDevName = paramString;
  }
  
  public boolean setConnected(String paramString)
  {
    this.mLock.lock();
    TraeAudioManager.DeviceConfigManager.DeviceConfig localDeviceConfig = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(paramString);
    if ((localDeviceConfig != null) && (localDeviceConfig.getVisible()))
    {
      if ((this.connectedDevice != null) && (!this.connectedDevice.equals(paramString))) {
        this.prevConnectedDevice = this.connectedDevice;
      }
      this.connectedDevice = paramString;
      this.connectingDevice = "";
    }
    for (boolean bool = true;; bool = false)
    {
      this.mLock.unlock();
      return bool;
    }
  }
  
  public boolean setConnecting(String paramString)
  {
    this.mLock.lock();
    TraeAudioManager.DeviceConfigManager.DeviceConfig localDeviceConfig = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(paramString);
    if ((localDeviceConfig != null) && (localDeviceConfig.getVisible())) {
      this.connectingDevice = paramString;
    }
    for (boolean bool = true;; bool = false)
    {
      this.mLock.unlock();
      return bool;
    }
  }
  
  public boolean setVisible(String paramString, boolean paramBoolean)
  {
    this.mLock.lock();
    Object localObject = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(paramString);
    if ((localObject != null) && (((TraeAudioManager.DeviceConfigManager.DeviceConfig)localObject).getVisible() != paramBoolean))
    {
      ((TraeAudioManager.DeviceConfigManager.DeviceConfig)localObject).setVisible(paramBoolean);
      this.visiableUpdate = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append(" ++setVisible:").append(paramString);
        if (!paramBoolean) {
          break label98;
        }
        paramString = " Y";
        QLog.w("TRAE", 0, paramString);
      }
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.mLock.unlock();
      return paramBoolean;
      label98:
      paramString = " N";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.DeviceConfigManager
 * JD-Core Version:    0.7.0.1
 */