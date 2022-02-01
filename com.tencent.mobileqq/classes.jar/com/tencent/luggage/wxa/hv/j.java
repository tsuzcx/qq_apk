package com.tencent.luggage.wxa.hv;

import com.tencent.luggage.wxa.b.b;
import com.tencent.luggage.wxa.b.e;
import com.tencent.luggage.wxa.b.h;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class j
{
  public static b a(a parama)
  {
    b localb = new b();
    if (parama == null) {
      return localb;
    }
    int i = 0;
    try
    {
      while (i < parama.length())
      {
        a(localb, parama.get(i));
        i += 1;
      }
      return localb;
    }
    catch (g parama) {}
    return localb;
  }
  
  public static e a(c paramc)
  {
    e locale = new e();
    if (paramc == null) {
      return locale;
    }
    try
    {
      Iterator localIterator = paramc.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a(locale, str, paramc.get(str));
      }
      return locale;
    }
    catch (g paramc) {}
    return locale;
  }
  
  public static e a(Map paramMap)
  {
    e locale = new e();
    if (paramMap != null)
    {
      if (paramMap.isEmpty()) {
        return locale;
      }
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        Object localObject2 = paramMap.get(localObject1);
        a(locale, (String)localObject1, localObject2);
      }
    }
    return locale;
  }
  
  protected static void a(b paramb, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof c))
    {
      paramb.a(paramInt, a((c)paramObject));
      return;
    }
    if ((paramObject instanceof a))
    {
      paramb.a(paramInt, a((a)paramObject));
      return;
    }
    boolean bool = paramObject instanceof Integer;
    if (bool)
    {
      paramb.a(paramInt, ((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof String))
    {
      paramb.a(paramInt, (String)paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramb.a(paramInt, ((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramb.a(paramInt, ((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramb.a(paramInt, ((Float)paramObject).floatValue());
      return;
    }
    if (bool)
    {
      paramb.a(paramInt, ((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramb.a(paramInt, ((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof h)) {
      paramb.a(paramInt, (h)paramObject);
    }
  }
  
  protected static void a(b paramb, Object paramObject)
  {
    if ((paramObject instanceof c))
    {
      paramb.a(a((c)paramObject));
      return;
    }
    if ((paramObject instanceof a))
    {
      paramb.a(a((a)paramObject));
      return;
    }
    boolean bool = paramObject instanceof Integer;
    if (bool)
    {
      paramb.a(((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof String))
    {
      paramb.a((String)paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramb.a(((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramb.a(((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramb.a(((Float)paramObject).floatValue());
      return;
    }
    if (bool)
    {
      paramb.a(((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramb.a(((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof h)) {
      paramb.a((h)paramObject);
    }
  }
  
  protected static void a(e parame, String paramString, Object paramObject)
  {
    if ((paramObject instanceof c))
    {
      parame.b(paramString, a((c)paramObject));
      return;
    }
    if ((paramObject instanceof a))
    {
      parame.b(paramString, a((a)paramObject));
      return;
    }
    if ((paramObject instanceof Integer))
    {
      parame.b(paramString, ((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof String))
    {
      parame.a(paramString, (String)paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      parame.b(paramString, ((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof Long))
    {
      parame.b(paramString, ((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Float))
    {
      parame.a(paramString, ((Float)paramObject).floatValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      parame.b(paramString, ((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof h)) {
      parame.b(paramString, (h)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hv.j
 * JD-Core Version:    0.7.0.1
 */