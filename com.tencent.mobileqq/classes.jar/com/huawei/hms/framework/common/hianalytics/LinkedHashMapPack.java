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
    if (paramString != null)
    {
      LinkedHashMap localLinkedHashMap = this.map;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramLong);
      localLinkedHashMap.put(paramString, localStringBuilder.toString());
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
      LinkedHashMap localLinkedHashMap;
      String str;
      if (paramBoolean)
      {
        localLinkedHashMap = this.map;
        str = "1";
      }
      else
      {
        localLinkedHashMap = this.map;
        str = "0";
      }
      localLinkedHashMap.put(paramString, str);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack
 * JD-Core Version:    0.7.0.1
 */