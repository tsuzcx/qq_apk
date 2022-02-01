package com.tencent.luggage.wxa.ba;

import com.tencent.luggage.wxa.qz.o;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

public class e
{
  private static LinkedHashMap<String, c> a = new LinkedHashMap();
  private static Map<Class<? extends d>, Object> b = new HashMap();
  
  static
  {
    a(new a());
  }
  
  public static <T extends b> T a(Class<T> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    ListIterator localListIterator = new ArrayList(a.values()).listIterator(a.size());
    while (localListIterator.hasPrevious())
    {
      b localb = ((c)localListIterator.previous()).a(paramClass);
      if (localb != null) {
        return localb;
      }
    }
    o.c("Luggage.Luggage", "no customize found for [%s]", new Object[] { paramClass.getCanonicalName() });
    return null;
  }
  
  public static <T extends d> T a(Class<T> paramClass, boolean paramBoolean)
  {
    Object localObject = null;
    ListIterator localListIterator = null;
    if (paramClass == null)
    {
      localObject = localListIterator;
      if (paramBoolean) {
        localObject = c(paramClass);
      }
      return localObject;
    }
    localListIterator = new ArrayList(a.values()).listIterator(a.size());
    while (localListIterator.hasPrevious())
    {
      d locald = ((c)localListIterator.previous()).b(paramClass);
      if (locald != null) {
        return locald;
      }
    }
    o.c("Luggage.Luggage", "no profiler found for [%s], genDummy[%b]", new Object[] { paramClass.getCanonicalName(), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      localObject = c(paramClass);
    }
    return localObject;
  }
  
  public static void a(c paramc)
  {
    if (paramc == null)
    {
      o.b("Luggage.Luggage", "install fail, plugin is null");
      return;
    }
    o.d("Luggage.Luggage", "plugin:[%s] installed", new Object[] { paramc.c() });
    a.put(paramc.c(), paramc);
    paramc.d();
  }
  
  public static <T extends b> void a(Class<T> paramClass, T paramT)
  {
    if (paramClass != null)
    {
      if (paramT == null) {
        return;
      }
      Object localObject = a.get("luggage-core");
      localObject.getClass();
      if ((((a)localObject).a().put(paramClass, paramT) != paramT) && ((paramT instanceof com.tencent.luggage.wxa.hw.b))) {
        ((com.tencent.luggage.wxa.hw.b)paramT).c();
      }
    }
  }
  
  public static <T extends d> void a(Class<T> paramClass, T paramT)
  {
    if (paramClass != null)
    {
      if (paramT == null) {
        return;
      }
      Object localObject = a.get("luggage-core");
      localObject.getClass();
      ((a)localObject).b().put(paramClass, paramT);
    }
  }
  
  public static <T extends d> T b(Class<T> paramClass)
  {
    return a(paramClass, true);
  }
  
  private static <T extends d> T c(Class<T> paramClass)
  {
    if (b.get(paramClass) != null) {
      return (d)b.get(paramClass);
    }
    Object localObject = new e.1();
    localObject = (d)Proxy.newProxyInstance(d.class.getClassLoader(), new Class[] { paramClass }, (InvocationHandler)localObject);
    b.put(paramClass, localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ba.e
 * JD-Core Version:    0.7.0.1
 */