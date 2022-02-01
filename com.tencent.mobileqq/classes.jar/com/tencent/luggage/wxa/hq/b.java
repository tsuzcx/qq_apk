package com.tencent.luggage.wxa.hq;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class b
{
  private static final Set<Object> a = new HashSet();
  private static final Map<String, Set<c>> b = new HashMap();
  
  public static void a(Object paramObject)
  {
    a.add(paramObject);
  }
  
  public static void a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      synchronized (b)
      {
        Set localSet = (Set)b.remove(paramString);
        if (localSet == null) {
          return;
        }
        com.tencent.luggage.wxa.hs.b.a("IPC.ObjectRecycler", "recycleAll(%s)", new Object[] { paramString });
        try
        {
          paramString = localSet.iterator();
          while (paramString.hasNext())
          {
            ??? = (c)paramString.next();
            com.tencent.luggage.wxa.hs.b.a("IPC.ObjectRecycler", "recycle(%s)", new Object[] { Integer.valueOf(???.hashCode()) });
            ((c)???).a();
          }
          localSet.clear();
          return;
        }
        finally {}
      }
    }
  }
  
  public static boolean a(String paramString, c paramc)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramc == null) {
        return false;
      }
      synchronized (b)
      {
        Set localSet = (Set)b.get(paramString);
        Object localObject = localSet;
        if (localSet == null)
        {
          localObject = new HashSet();
          b.put(paramString, localObject);
        }
        com.tencent.luggage.wxa.hs.b.a("IPC.ObjectRecycler", "addIntoSet(%s)", new Object[] { paramString });
        try
        {
          boolean bool = ((Set)localObject).add(paramc);
          return bool;
        }
        finally {}
      }
    }
    return false;
  }
  
  public static void b(Object paramObject)
  {
    a.remove(paramObject);
  }
  
  public static boolean b(String paramString, c paramc)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramc == null) {
        return false;
      }
      synchronized (b)
      {
        Set localSet = (Set)b.get(paramString);
        if (localSet == null) {
          return false;
        }
        com.tencent.luggage.wxa.hs.b.a("IPC.ObjectRecycler", "removeFromSet(%s)", new Object[] { paramString });
        try
        {
          boolean bool = localSet.remove(paramc);
          return bool;
        }
        finally {}
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hq.b
 * JD-Core Version:    0.7.0.1
 */