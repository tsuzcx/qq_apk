package com.tencent.luggage.wxa.rp;

import android.os.Looper;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class g
{
  private static Map<String, d> a = new ConcurrentHashMap();
  private static Map<Thread, d> b = new HashMap();
  private static boolean c = false;
  private static ThreadLocal<d> d = new ThreadLocal();
  private static g.a e = null;
  
  static
  {
    b();
  }
  
  public static d a()
  {
    Object localObject2 = (d)d.get();
    if ((localObject2 != null) && (b.size() == 0)) {
      return localObject2;
    }
    try
    {
      d locald = (d)b.remove(Thread.currentThread());
      if ((localObject2 != null) && (locald == null)) {
        return localObject2;
      }
      if (locald != null)
      {
        d.set(locald);
        return locald;
      }
      if (Looper.myLooper() != null)
      {
        localObject2 = new h(Looper.myLooper(), Looper.myLooper().toString());
      }
      else
      {
        localObject2 = e;
        if (localObject2 != null)
        {
          locald = ((g.a)localObject2).a(Thread.currentThread());
          com.tencent.luggage.wxa.rn.a.c("Vending.SchedulerProvider", "This is not a handler thread(%s). So we get a instance(%s) from thread factory.", new Object[] { Thread.currentThread(), locald });
        }
        localObject2 = locald;
        if (locald == null)
        {
          com.tencent.luggage.wxa.rn.a.b("Vending.SchedulerProvider", "This is not a handler thread! %s", new Object[] { Thread.currentThread() });
          return new c();
        }
      }
      d.set(localObject2);
      return localObject2;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    a.remove(paramString.toUpperCase(Locale.ENGLISH));
  }
  
  public static void a(String paramString, d paramd)
  {
    junit.framework.a.a("Scheduler type is null", paramString);
    String str = paramString.toUpperCase(Locale.ENGLISH);
    if (a.containsKey(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Fatal error! Duplicate scheduler type ");
      localStringBuilder.append(paramString.toUpperCase(Locale.ENGLISH));
      new IllegalStateException(localStringBuilder.toString());
    }
    a.put(str, paramd);
    if ((paramd instanceof h)) {
      try
      {
        b.put(((h)paramd).b().getThread(), paramd);
        return;
      }
      finally {}
    }
    if ((paramd instanceof i)) {
      try
      {
        b.put(((i)paramd).b(), paramd);
        return;
      }
      finally {}
    }
  }
  
  public static d b(String paramString)
  {
    junit.framework.a.a("Scheduler type is null", paramString);
    d locald = (d)a.get(paramString.toUpperCase(Locale.ENGLISH));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Scheduler type not found: ");
    localStringBuilder.append(paramString.toUpperCase(Locale.ENGLISH));
    junit.framework.a.a(localStringBuilder.toString(), locald);
    return locald;
  }
  
  static void b()
  {
    try
    {
      boolean bool = c;
      if (bool) {
        return;
      }
      com.tencent.luggage.wxa.rn.a.c("Vending.SchedulerProvider", "SchedulerProvider provided.", new Object[0]);
      c = true;
      a("Vending.UI", d.a);
      a("Vending.LOGIC", d.b);
      a("Vending.HEAVY_WORK", d.c);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rp.g
 * JD-Core Version:    0.7.0.1
 */