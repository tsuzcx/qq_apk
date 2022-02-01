package com.tencent.luggage.wxa.m;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.h.p;
import com.tencent.luggage.wxa.l.l;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

final class c
  extends d
{
  private long b = -9223372036854775807L;
  
  public c(l paraml)
  {
    super(paraml);
  }
  
  private static Object a(m paramm, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 8)
            {
              if (paramInt != 10)
              {
                if (paramInt != 11) {
                  return null;
                }
                return i(paramm);
              }
              return f(paramm);
            }
            return h(paramm);
          }
          return g(paramm);
        }
        return e(paramm);
      }
      return c(paramm);
    }
    return d(paramm);
  }
  
  private static int b(m paramm)
  {
    return paramm.g();
  }
  
  private static Boolean c(m paramm)
  {
    int i = paramm.g();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  private static Double d(m paramm)
  {
    return Double.valueOf(Double.longBitsToDouble(paramm.p()));
  }
  
  private static String e(m paramm)
  {
    int i = paramm.h();
    int j = paramm.d();
    paramm.d(i);
    return new String(paramm.a, j, i);
  }
  
  private static ArrayList<Object> f(m paramm)
  {
    int j = paramm.t();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(a(paramm, b(paramm)));
      i += 1;
    }
    return localArrayList;
  }
  
  private static HashMap<String, Object> g(m paramm)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      String str = e(paramm);
      int i = b(paramm);
      if (i == 9) {
        return localHashMap;
      }
      localHashMap.put(str, a(paramm, i));
    }
  }
  
  private static HashMap<String, Object> h(m paramm)
  {
    int j = paramm.t();
    HashMap localHashMap = new HashMap(j);
    int i = 0;
    while (i < j)
    {
      localHashMap.put(e(paramm), a(paramm, b(paramm)));
      i += 1;
    }
    return localHashMap;
  }
  
  private static Date i(m paramm)
  {
    Date localDate = new Date(d(paramm).doubleValue());
    paramm.d(2);
    return localDate;
  }
  
  public long a()
  {
    return this.b;
  }
  
  protected void a(m paramm, long paramLong)
  {
    if (b(paramm) == 2)
    {
      if (!"onMetaData".equals(e(paramm))) {
        return;
      }
      if (b(paramm) != 8) {
        return;
      }
      paramm = h(paramm);
      if (paramm.containsKey("duration"))
      {
        double d = ((Double)paramm.get("duration")).doubleValue();
        if (d > 0.0D) {
          this.b = ((d * 1000000.0D));
        }
      }
      return;
    }
    throw new p();
  }
  
  protected boolean a(m paramm)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.m.c
 * JD-Core Version:    0.7.0.1
 */