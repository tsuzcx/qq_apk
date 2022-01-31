package com.tencent.map.sdk.a;

import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class os
{
  private static final ow.f<os.a> a = ow.a(30, new os.1());
  private static volatile AtomicInteger b = new AtomicInteger();
  private static HashSet<String> c = new HashSet();
  private static Map<String, Map<String, os.b>> d = Collections.synchronizedMap(new Hashtable());
  
  public static int a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = null;
    Map localMap = (Map)d.get(paramString1);
    if (localMap != null) {}
    for (paramString1 = (os.b)localMap.get(paramString1);; paramString1 = null)
    {
      if (paramString1 != null)
      {
        if (paramString1.a != null) {
          localObject = paramString1.a.get(paramString2);
        }
        if ((localObject instanceof AtomicInteger))
        {
          int i = paramInt;
          if (paramInt <= 0) {
            i = 1;
          }
          paramInt = ((AtomicInteger)localObject).get() + i;
          ((AtomicInteger)localObject).set(paramInt);
          return paramInt;
        }
        localObject = new AtomicInteger(1);
        if (paramString1.a == null) {
          paramString1.a = new Hashtable();
        }
        paramString1.a.put(paramString2, localObject);
        return 1;
      }
      return -1;
    }
  }
  
  public static os.a a(String paramString)
  {
    b.incrementAndGet();
    os.a locala = (os.a)a.a();
    locala.a = paramString;
    return locala;
  }
  
  public static void a() {}
  
  public static void b() {}
  
  public static void b(String paramString)
  {
    c.add(paramString);
  }
  
  public static void c() {}
  
  public static int d()
  {
    return 0;
  }
  
  public static int e()
  {
    return -1;
  }
  
  public static long f()
  {
    return 0L;
  }
  
  public static long g()
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.os
 * JD-Core Version:    0.7.0.1
 */