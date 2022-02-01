package com.tencent.comic.data;

import java.util.ArrayList;
import java.util.HashMap;

public class VipComicHippyBounceRateHelper
{
  public static final ArrayList<Integer> a = new ArrayList();
  private static HashMap<Integer, HashMap<Integer, Long>> b = new HashMap();
  
  static
  {
    a.add(Integer.valueOf(13));
    a.add(Integer.valueOf(12));
    a.add(Integer.valueOf(11));
    a.add(Integer.valueOf(2));
    a.add(Integer.valueOf(1));
  }
  
  public static long a(int paramInt1, int paramInt2)
  {
    Object localObject = (HashMap)b.get(Integer.valueOf(paramInt1));
    if (localObject == null) {
      return 0L;
    }
    localObject = (Long)((HashMap)localObject).get(Integer.valueOf(paramInt2));
    if (localObject == null) {
      return 0L;
    }
    return ((Long)localObject).longValue();
  }
  
  public static void a(int paramInt)
  {
    if (b.containsKey(Integer.valueOf(paramInt))) {
      b.remove(Integer.valueOf(paramInt));
    }
  }
  
  public static void a(int paramInt1, int paramInt2, long paramLong)
  {
    if (a.contains(Integer.valueOf(paramInt2)))
    {
      HashMap localHashMap2 = (HashMap)b.get(Integer.valueOf(paramInt1));
      HashMap localHashMap1 = localHashMap2;
      if (localHashMap2 == null)
      {
        localHashMap1 = new HashMap();
        b.put(Integer.valueOf(paramInt1), localHashMap1);
      }
      localHashMap1.put(Integer.valueOf(paramInt2), Long.valueOf(paramLong));
    }
  }
  
  public static boolean b(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = (HashMap)b.get(Integer.valueOf(paramInt1));
    if (localHashMap == null) {
      return false;
    }
    return localHashMap.containsKey(Integer.valueOf(paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.comic.data.VipComicHippyBounceRateHelper
 * JD-Core Version:    0.7.0.1
 */