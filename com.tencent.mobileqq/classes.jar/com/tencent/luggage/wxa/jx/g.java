package com.tencent.luggage.wxa.jx;

import androidx.annotation.UiThread;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class g
  implements f
{
  private final Set<f.g> a = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<f.b> b = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<f.d> c = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<f.c> d = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<f.a> e = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<f.h> f = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<f.e> g = Collections.newSetFromMap(new ConcurrentHashMap());
  private final Set<f.f> h = Collections.newSetFromMap(new ConcurrentHashMap());
  private boolean i = true;
  
  @UiThread
  public void a()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((f.h)localIterator.next()).a();
    }
  }
  
  public void a(f.a parama)
  {
    this.e.add(parama);
  }
  
  public void a(f.b paramb)
  {
    this.b.add(paramb);
  }
  
  public void a(f.c paramc)
  {
    this.d.add(paramc);
  }
  
  public void a(f.d paramd)
  {
    this.c.add(paramd);
  }
  
  public void a(f.e parame)
  {
    this.g.add(parame);
  }
  
  public void a(f.g paramg)
  {
    this.a.add(paramg);
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator;
    if ((this.i == true) && (!paramBoolean)) {
      localIterator = this.h.iterator();
    }
    while (localIterator.hasNext())
    {
      ((f.f)localIterator.next()).a();
      continue;
      if ((!this.i) && (paramBoolean == true))
      {
        localIterator = this.g.iterator();
        while (localIterator.hasNext()) {
          ((f.e)localIterator.next()).a();
        }
      }
    }
    this.i = paramBoolean;
  }
  
  @UiThread
  public void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((f.g)localIterator.next()).a();
    }
  }
  
  public void b(f.b paramb)
  {
    this.b.remove(paramb);
  }
  
  public void b(f.c paramc)
  {
    this.d.remove(paramc);
  }
  
  public void b(f.d paramd)
  {
    this.c.remove(paramd);
  }
  
  public void b(f.e parame)
  {
    this.g.remove(parame);
  }
  
  public void b(f.g paramg)
  {
    this.a.remove(paramg);
  }
  
  public void c()
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((f.c)localIterator.next()).d();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((f.d)localIterator.next()).c();
    }
    a(true);
  }
  
  public boolean e()
  {
    Iterator localIterator = this.e.iterator();
    boolean bool = false;
    while (localIterator.hasNext()) {
      if (((f.a)localIterator.next()).a()) {
        bool = true;
      }
    }
    return bool;
  }
  
  public void f()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((f.b)localIterator.next()).b();
    }
    a(false);
  }
  
  public void g()
  {
    this.a.clear();
    this.d.clear();
    this.b.clear();
    this.c.clear();
    this.e.clear();
    this.f.clear();
    this.h.clear();
    this.g.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.g
 * JD-Core Version:    0.7.0.1
 */