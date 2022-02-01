package com.gyailib.library;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SDKDeviceConfig
{
  private int cpuLevel;
  private String device = "ARM";
  private Map<String, String> infos;
  private boolean smoothEnable;
  
  public String getDevice()
  {
    return this.device;
  }
  
  public String getInfos()
  {
    Object localObject = this.infos;
    if ((localObject != null) && (((Map)localObject).size() >= 1))
    {
      localObject = new StringBuilder();
      Iterator localIterator = this.infos.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((StringBuilder)localObject).append((String)localEntry.getKey());
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append((String)localEntry.getValue());
        ((StringBuilder)localObject).append(" ");
      }
      return ((StringBuilder)localObject).toString().trim();
    }
    return "";
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