package com.gyailib.library;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SDKDeviceConfig
{
  private int cpu_level;
  private String device = "ARM";
  private Map<String, String> infos;
  private boolean smooth_enable;
  
  public String getDevice()
  {
    return this.device;
  }
  
  public String getInfos()
  {
    if ((this.infos == null) || (this.infos.size() < 1)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.infos.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append((String)localEntry.getKey()).append(" ").append((String)localEntry.getValue()).append(" ");
    }
    return localStringBuilder.toString().trim();
  }
  
  public void setDevice(String paramString)
  {
    this.device = paramString;
  }
  
  public void setInfos(Map<String, String> paramMap)
  {
    this.infos = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.library.SDKDeviceConfig
 * JD-Core Version:    0.7.0.1
 */