package com.tencent.luggage.storage;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.fp.f;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.nl.h;
import com.tencent.luggage.wxa.nl.n;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.appcache.k;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class b
{
  static final Map<b.a, String[]> a;
  private static final AtomicReference<com.tencent.luggage.wxa.dx.a> b = new AtomicReference();
  private static final AtomicReference<com.tencent.luggage.wxa.rb.c> c = new AtomicReference();
  private static final Map<Class, Object> d = new HashMap();
  
  static
  {
    a = new HashMap();
    a(new b.3(), new String[] { com.tencent.luggage.wxa.rb.d.a(s.w, "WxaAttributesTable") });
    a(new b.4(), n.a);
    a(new b.5(), k.a);
    a(new b.6(), ae.c);
    a(new b.7(), com.tencent.mm.plugin.appbrand.appstorage.c.a);
    a(new b.8(), com.tencent.luggage.wxa.jj.d.a);
    a(new b.9(), h.a);
    a(new b.10(), f.c);
    a(new b.2(), ag.g);
  }
  
  public static com.tencent.luggage.wxa.rb.c a()
  {
    return a(new com.tencent.luggage.wxa.dc.i(0));
  }
  
  private static com.tencent.luggage.wxa.rb.c a(@NonNull com.tencent.luggage.wxa.dx.a parama)
  {
    if ((parama.equals(b.get())) && (c.get() != null)) {
      return (com.tencent.luggage.wxa.rb.c)c.get();
    }
    b();
    a locala = new a(SQLiteDatabase.a(r.a().getDatabasePath(String.format(Locale.US, "wxa_%s_common.db", new Object[] { parama.toString() })), null));
    a(locala);
    b.set(parama);
    c.set(locala);
    com.tencent.luggage.wxa.dd.i.a.a(new b.1(locala, parama));
    return locala;
  }
  
  public static <T> T a(Class<T> paramClass)
  {
    boolean bool;
    if (paramClass != null) {
      bool = true;
    } else {
      bool = false;
    }
    junit.framework.a.a("Cant pass Null class here", bool);
    a();
    synchronized (d)
    {
      paramClass = d.get(paramClass);
      return paramClass;
    }
  }
  
  private static void a(b.a parama, String[] paramArrayOfString)
  {
    a.put(parama, paramArrayOfString);
  }
  
  static void a(@NonNull com.tencent.luggage.wxa.rb.c paramc)
  {
    synchronized (d)
    {
      d.clear();
      Iterator localIterator = a.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (b.a)localIterator.next();
        String[] arrayOfString = (String[])a.get(localObject);
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          paramc.a(null, arrayOfString[i]);
          i += 1;
        }
        localObject = ((b.a)localObject).b(paramc);
        d.put(localObject.getClass(), localObject);
      }
      return;
    }
    for (;;)
    {
      throw paramc;
    }
  }
  
  public static void b()
  {
    synchronized (d)
    {
      d.clear();
      ??? = (com.tencent.luggage.wxa.rb.c)c.get();
      if (??? != null) {
        ((com.tencent.luggage.wxa.rb.c)???).a();
      }
      return;
    }
  }
  
  public static Iterator<Map.Entry<Class, Object>> c()
  {
    synchronized (d)
    {
      HashMap localHashMap = new HashMap(d);
      return localHashMap.entrySet().iterator();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.storage.b
 * JD-Core Version:    0.7.0.1
 */