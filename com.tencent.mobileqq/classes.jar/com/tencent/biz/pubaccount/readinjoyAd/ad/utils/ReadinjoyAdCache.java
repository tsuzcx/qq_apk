package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import java.util.concurrent.ConcurrentHashMap;

public class ReadinjoyAdCache
{
  public static ConcurrentHashMap<Integer, Object> a = new ConcurrentHashMap();
  
  public static void a(int paramInt)
  {
    a.remove(Integer.valueOf(paramInt));
  }
  
  public static void a(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    a.remove(Integer.valueOf(paramInt));
    a.put(Integer.valueOf(paramInt), paramObject);
  }
  
  public static Object b(int paramInt)
  {
    if (a.containsKey(Integer.valueOf(paramInt))) {
      return a.get(Integer.valueOf(paramInt));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadinjoyAdCache
 * JD-Core Version:    0.7.0.1
 */