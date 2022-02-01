package com.tencent.ilivesdk.startliveservice_interface.model;

public class MachineInfo
{
  private String cpu_max_freq;
  private String memory_size;
  private String os_model;
  private String os_version;
  private MachineInfo.Platform platform;
  
  public String getCpu_max_freq()
  {
    return this.cpu_max_freq;
  }
  
  public String getMemory_size()
  {
    return this.memory_size;
  }
  
  public String getOs_model()
  {
    return this.os_model;
  }
  
  public String getOs_version()
  {
    return this.os_version;
  }
  
  public MachineInfo.Platform getPlatform()
  {
    return this.platform;
  }
  
  public void setCpu_max_freq(String paramString)
  {
    this.cpu_max_freq = paramString;
  }
  
  public void setMemory_size(String paramString)
  {
    this.memory_size = paramString;
  }
  
  public void setOs_model(String paramString)
  {
    this.os_model = paramString;
  }
  
  public void setOs_version(String paramString)
  {
    this.os_version = paramString;
  }
  
  public void setPlatform(MachineInfo.Platform paramPlatform)
  {
    this.platform = paramPlatform;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.startliveservice_interface.model.MachineInfo
 * JD-Core Version:    0.7.0.1
 */