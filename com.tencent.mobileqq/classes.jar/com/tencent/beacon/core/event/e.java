package com.tencent.beacon.core.event;

import java.util.HashMap;
import java.util.Map;

public final class e
{
  private static Map<String, Long> a = null;
  
  public static void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if (a == null) {
      a = new HashMap();
    }
    a.put(paramString, Long.valueOf(l));
    com.tencent.beacon.core.d.b.b("[page] onPageIn cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public static void b(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (a == null)
    {
      com.tencent.beacon.core.d.b.c("[page] please call 'onPageIn' first!", new Object[0]);
      return;
    }
    Long localLong = (Long)a.get(paramString);
    if (localLong == null)
    {
      com.tencent.beacon.core.d.b.c("[page] please call 'onPageIn' first!", new Object[0]);
      return;
    }
    long l2 = localLong.longValue();
    com.tencent.beacon.core.a.b.b().a(new e.1(l1, paramString, l1 - l2));
    a.remove(paramString);
    com.tencent.beacon.core.d.b.b("[page] onPageOut cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.event.e
 * JD-Core Version:    0.7.0.1
 */