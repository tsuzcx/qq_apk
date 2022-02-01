package com.tencent.luggage.wxa.pp;

import androidx.annotation.MainThread;
import androidx.collection.ArrayMap;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum o
{
  public static final Map<String, Integer> a;
  public static final Set<String> b;
  private static final ArrayMap<u, ac> c = new ArrayMap();
  
  static
  {
    Object localObject = new HashSet();
    ((Set)localObject).add("text");
    ((Set)localObject).add("emoji");
    ((Set)localObject).add("number");
    ((Set)localObject).add("digit");
    ((Set)localObject).add("idcard");
    b = Collections.unmodifiableSet((Set)localObject);
    localObject = new HashMap(3);
    ((Map)localObject).put("digit", Integer.valueOf(2));
    ((Map)localObject).put("number", Integer.valueOf(0));
    ((Map)localObject).put("idcard", Integer.valueOf(1));
    a = Collections.unmodifiableMap((Map)localObject);
  }
  
  public static ab a(u paramu, int paramInt)
  {
    return e.a(paramu, new o.1(paramInt));
  }
  
  static void a(u paramu, ab paramab)
  {
    e.a(paramu, paramab);
  }
  
  static void a(u paramu, ac paramac)
  {
    if (paramu == null) {
      return;
    }
    l.a(new o.3(paramu, paramac));
  }
  
  public static void a(u paramu, String paramString, Integer paramInteger)
  {
    if (paramu == null) {
      return;
    }
    l.a(new o.2(paramu, paramString, paramInteger));
  }
  
  @MainThread
  public static boolean a(u paramu)
  {
    return a(paramu, null);
  }
  
  @MainThread
  public static boolean a(u paramu, int paramInt1, int paramInt2, int paramInt3)
  {
    ab localab = a(paramu, paramInt1);
    return (localab != null) && (localab.a(paramu)) && (localab.a(paramInt2, paramInt3, paramu.y().i_()));
  }
  
  @MainThread
  public static boolean a(u paramu, Integer paramInteger)
  {
    try
    {
      boolean bool = b(paramu, paramInteger);
      return bool;
    }
    catch (Throwable paramu)
    {
      com.tencent.luggage.wxa.qz.o.a("MicroMsg.AppBrandInputService", paramu, "[NOT CRASH]", new Object[0]);
    }
    return false;
  }
  
  static void b(u paramu)
  {
    if (paramu == null) {
      return;
    }
    l.a(new o.4(paramu));
  }
  
  @MainThread
  public static boolean b(u paramu, int paramInt)
  {
    paramu = a(paramu, paramInt);
    return (paramu != null) && (paramu.e());
  }
  
  @MainThread
  public static boolean b(u paramu, Integer paramInteger)
  {
    boolean bool2 = false;
    Integer localInteger = paramInteger;
    if (paramInteger == null)
    {
      paramInteger = (ac)c.get(paramu);
      if (paramInteger == null) {
        return false;
      }
      localInteger = Integer.valueOf(paramInteger.getInputId());
    }
    paramu = a(paramu, localInteger.intValue());
    boolean bool1 = bool2;
    if (paramu != null)
    {
      bool1 = bool2;
      if (paramu.q()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @MainThread
  public static ab c(u paramu)
  {
    if (paramu == null) {
      return null;
    }
    ac localac = (ac)c.get(paramu);
    if (localac == null) {
      return null;
    }
    return a(paramu, localac.getInputId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.o
 * JD-Core Version:    0.7.0.1
 */