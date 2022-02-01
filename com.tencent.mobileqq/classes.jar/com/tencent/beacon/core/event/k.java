package com.tencent.beacon.core.event;

import java.util.HashMap;
import java.util.Map;

public class k
{
  private static Map<String, Long> a;
  
  private static void a()
  {
    if (a == null) {
      a = new HashMap();
    }
  }
  
  public static void a(String paramString)
  {
    long l = System.currentTimeMillis();
    a();
    a.put(paramString, Long.valueOf(l));
    com.tencent.beacon.core.e.d.a("[page] onPageIn cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  private static void a(String paramString, long paramLong1, long paramLong2)
  {
    com.tencent.beacon.core.a.d.a().a(new j(paramLong2, paramString, paramLong1));
  }
  
  public static void b(String paramString)
  {
    long l = System.currentTimeMillis();
    Object localObject = a;
    if (localObject == null)
    {
      com.tencent.beacon.core.e.d.i("[page] please call 'onPageIn' first!", new Object[0]);
      return;
    }
    localObject = (Long)((Map)localObject).get(paramString);
    if (localObject == null)
    {
      com.tencent.beacon.core.e.d.i("[page] please call 'onPageIn' first!", new Object[0]);
      return;
    }
    a(paramString, l - ((Long)localObject).longValue(), l);
    a.remove(paramString);
    com.tencent.beacon.core.e.d.a("[page] onPageOut cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.k
 * JD-Core Version:    0.7.0.1
 */