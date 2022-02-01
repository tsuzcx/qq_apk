package com.tencent.TMG.audio;

public class TraeAudioManager$DeviceConfigManager$DeviceConfig
{
  String deviceName = "DEVICE_NONE";
  int priority = 0;
  boolean visible = false;
  
  public TraeAudioManager$DeviceConfigManager$DeviceConfig(TraeAudioManager.DeviceConfigManager paramDeviceConfigManager) {}
  
  public String getDeviceName()
  {
    return this.deviceName;
  }
  
  public int getPriority()
  {
    return this.priority;
  }
  
  public boolean getVisible()
  {
    return this.visible;
  }
  
  public boolean init(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    while (TraeAudioManager.checkDevName(paramString) != true) {
      return false;
    }
    this.deviceName = paramString;
    this.priority = paramInt;
    return true;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.visible = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.DeviceConfigManager.DeviceConfig
 * JD-Core Version:    0.7.0.1
 */