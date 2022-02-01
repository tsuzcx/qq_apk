package com.tencent.luggage.wxa.gn;

import com.tencent.luggage.wxa.gm.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class f
{
  private static f d;
  private volatile LinkedList<String> a = new LinkedList();
  private volatile HashMap<String, d> b = new HashMap();
  private volatile Object c = new Object();
  
  public static f c()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new f();
        }
      }
      finally {}
    }
    return d;
  }
  
  public d a(String paramString)
  {
    synchronized (this.c)
    {
      if (!this.a.contains(paramString)) {
        this.a.add(paramString);
      }
      d locald2 = (d)this.b.get(paramString);
      d locald1 = locald2;
      if (locald2 == null)
      {
        locald1 = new d(paramString);
        this.b.put(paramString, locald1);
      }
      return locald1;
    }
  }
  
  public void a()
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        localObject3 = (d)this.b.get(localObject3);
        if (localObject3 != null) {
          ((d)localObject3).a();
        }
      }
      this.a.clear();
      this.b.clear();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public int b(String paramString)
  {
    synchronized (this.c)
    {
      if (!this.a.contains(paramString)) {
        return 0;
      }
      paramString = (d)this.b.get(paramString);
      if (paramString != null)
      {
        int i = paramString.c();
        return i;
      }
      return 0;
    }
  }
  
  public void b()
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        localObject3 = (d)this.b.get(localObject3);
        if (localObject3 != null) {
          ((d)localObject3).b();
        }
      }
      this.a.clear();
      this.b.clear();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean c(String paramString)
  {
    synchronized (this.c)
    {
      if (!this.a.contains(paramString)) {
        return false;
      }
      paramString = (d)this.b.get(paramString);
      return (paramString != null) && (paramString.c() > 0) && (paramString.e());
    }
  }
  
  public long d(String paramString)
  {
    synchronized (this.c)
    {
      if (!this.a.contains(paramString)) {
        return 0L;
      }
      paramString = (d)this.b.get(paramString);
      if ((paramString != null) && (paramString.e()))
      {
        long l = paramString.h();
        return l;
      }
      return 0L;
    }
  }
  
  public void d()
  {
    a();
  }
  
  public long e()
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.a.iterator();
      label18:
      Object localObject3;
      for (long l = 0L; localIterator.hasNext(); l += ((d)localObject3).h())
      {
        localObject3 = (String)localIterator.next();
        localObject3 = (d)this.b.get(localObject3);
        if ((localObject3 == null) || (!((d)localObject3).e()) || (((d)localObject3).i())) {
          break label18;
        }
      }
      return l;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public ArrayList<String> f()
  {
    synchronized (this.c)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.a);
      return localArrayList;
    }
  }
  
  public void g()
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        localObject3 = (d)this.b.get(localObject3);
        if ((localObject3 != null) && (((d)localObject3).e()) && (((d)localObject3).i())) {
          ((d)localObject3).k();
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gn.f
 * JD-Core Version:    0.7.0.1
 */