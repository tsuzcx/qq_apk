package com.tencent.falco.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class CollectionsUtil
{
  public static <V> int getSize(Collection<V> paramCollection)
  {
    if (paramCollection == null) {
      return 0;
    }
    return paramCollection.size();
  }
  
  public static <V> int getSize(List<V> paramList)
  {
    if (paramList == null) {
      return 0;
    }
    return paramList.size();
  }
  
  public static <K, V> int getSize(Map<K, V> paramMap)
  {
    if (paramMap == null) {
      return 0;
    }
    return paramMap.size();
  }
  
  public static <V> int getSize(V[] paramArrayOfV)
  {
    if (paramArrayOfV == null) {
      return 0;
    }
    return paramArrayOfV.length;
  }
  
  public static <V> boolean isEmpty(Collection<V> paramCollection)
  {
    return (paramCollection == null) || (paramCollection.size() == 0);
  }
  
  public static <V> boolean isEmpty(List<V> paramList)
  {
    return (paramList == null) || (paramList.size() == 0);
  }
  
  public static <K, V> boolean isEmpty(Map<K, V> paramMap)
  {
    return (paramMap == null) || (paramMap.size() == 0);
  }
  
  public static <V> boolean isEmpty(V[] paramArrayOfV)
  {
    return (paramArrayOfV == null) || (paramArrayOfV.length == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.CollectionsUtil
 * JD-Core Version:    0.7.0.1
 */