package com.tencent.mobileqq.apollo.aio.api.impl;

import com.tencent.mobileqq.apollo.aio.api.ICmShowAioMatcher;
import com.tencent.mobileqq.apollo.aio.api.ICmShowAioMatcher.AioSupported;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CmShowAioMatcherImpl
  implements ICmShowAioMatcher
{
  private static final String TAG = "[cmshow]CmShowAioMatcher";
  private static final Map<Integer, ICmShowAioMatcher.AioSupported> allFilters;
  private static final Map<Integer, ICmShowAioMatcher.AioSupported> c2cFilters;
  private static final Map<Integer, ICmShowAioMatcher.AioSupported> groupFilters = new HashMap();
  
  static
  {
    c2cFilters = new HashMap();
    allFilters = new HashMap();
    init();
  }
  
  private static void init()
  {
    initC2CSet();
    initGroupSet();
    Iterator localIterator = c2cFilters.entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      allFilters.put(localEntry.getKey(), localEntry.getValue());
    }
    localIterator = groupFilters.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      allFilters.put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  private static void initC2CSet()
  {
    c2cFilters.put(Integer.valueOf(0), new CmShowAioMatcherImpl.1());
    c2cFilters.put(Integer.valueOf(1000), new CmShowAioMatcherImpl.2());
    c2cFilters.put(Integer.valueOf(1045), new CmShowAioMatcherImpl.3());
    c2cFilters.put(Integer.valueOf(1044), new CmShowAioMatcherImpl.4());
  }
  
  private static void initGroupSet()
  {
    groupFilters.put(Integer.valueOf(1), new CmShowAioMatcherImpl.5());
    groupFilters.put(Integer.valueOf(3000), new CmShowAioMatcherImpl.6());
  }
  
  public static boolean judgeSupported(int paramInt)
  {
    return judgeSupported(paramInt, 0);
  }
  
  public static boolean judgeSupported(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2) {
          return false;
        }
        return groupFilters.containsKey(Integer.valueOf(paramInt1));
      }
      return c2cFilters.containsKey(Integer.valueOf(paramInt1));
    }
    return allFilters.containsKey(Integer.valueOf(paramInt1));
  }
  
  public static ICmShowAioMatcher.AioSupported match(int paramInt)
  {
    return match(paramInt, 0);
  }
  
  public static ICmShowAioMatcher.AioSupported match(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2) {
          return null;
        }
        return (ICmShowAioMatcher.AioSupported)groupFilters.get(Integer.valueOf(paramInt1));
      }
      return (ICmShowAioMatcher.AioSupported)c2cFilters.get(Integer.valueOf(paramInt1));
    }
    return (ICmShowAioMatcher.AioSupported)allFilters.get(Integer.valueOf(paramInt1));
  }
  
  public boolean isSupported(int paramInt)
  {
    return judgeSupported(paramInt);
  }
  
  public boolean isSupported(int paramInt1, int paramInt2)
  {
    return judgeSupported(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl
 * JD-Core Version:    0.7.0.1
 */