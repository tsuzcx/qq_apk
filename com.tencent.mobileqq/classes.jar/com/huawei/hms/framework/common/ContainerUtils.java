package com.huawei.hms.framework.common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ContainerUtils
{
  public static final String FIELD_DELIMITER = "&";
  public static final String KEY_VALUE_DELIMITER = "=";
  
  public static <K, V> boolean equals(Map<K, V> paramMap1, Map<K, V> paramMap2)
  {
    if (paramMap1 == paramMap2) {
      return true;
    }
    int j = 0;
    if ((paramMap1 != null) && (paramMap2 != null) && (paramMap1.size() == paramMap2.size()))
    {
      paramMap1 = paramMap1.entrySet().iterator();
      Map.Entry localEntry;
      do
      {
        i = j;
        if (!paramMap1.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)paramMap1.next();
      } while (paramMap2.get(localEntry.getKey()) == localEntry.getValue());
      int i = 1;
      return i ^ 0x1;
    }
    return false;
  }
  
  public static <K, V> int hashCode(Map<K, V> paramMap)
  {
    return toString(paramMap).hashCode();
  }
  
  public static <K> String toString(List<K> paramList)
  {
    if (paramList == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append(localObject.toString());
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static <K, V> String toString(Map<K, V> paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (i > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append(localEntry.getKey().toString());
      localStringBuilder.append("=");
      localStringBuilder.append(localEntry.getValue().toString());
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static <K> String toString(Set<K> paramSet)
  {
    if (paramSet == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Object localObject = paramSet.next();
      if (i > 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append(localObject.toString());
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.ContainerUtils
 * JD-Core Version:    0.7.0.1
 */