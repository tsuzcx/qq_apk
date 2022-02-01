package com.huawei.hms.framework.common.hianalytics;

import java.util.LinkedHashMap;

public class LinkedHashMapPack
{
  private LinkedHashMap<String, String> map = new LinkedHashMap();
  
  public LinkedHashMap<String, String> getAll()
  {
    return this.map;
  }
  
  public LinkedHashMapPack put(String paramString, long paramLong)
  {
    if (paramString != null) {
      this.map.put(paramString, "" + paramLong);
    }
    return this;
  }
  
  public LinkedHashMapPack put(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      this.map.put(paramString1, paramString2);
    }
    return this;
  }
  
  public LinkedHashMapPack put(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      if (paramBoolean) {
        this.map.put(paramString, "1");
      }
    }
    else {
      return this;
    }
    this.map.put(paramString, "0");
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack
 * JD-Core Version:    0.7.0.1
 */