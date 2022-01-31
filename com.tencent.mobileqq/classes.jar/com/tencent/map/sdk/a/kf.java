package com.tencent.map.sdk.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class kf
  implements lh, mc
{
  public kf.a a;
  public int b = 60;
  nw c;
  long d;
  boolean e;
  he f;
  private ArrayList<nv> g = new ArrayList();
  private final byte[] h = new byte[0];
  private ArrayList<nv> i = new ArrayList();
  private ArrayList<nv> j = new ArrayList();
  private LinkedList<Object> k;
  
  public kf(nw paramnw)
  {
    this.c = paramnw;
    this.k = new LinkedList();
    nu.a(a());
  }
  
  public final long a()
  {
    long l2 = 1000L / this.b;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 1L;
    }
    return l1;
  }
  
  public final void a(kc paramkc)
  {
    this.e = true;
    this.d = System.currentTimeMillis();
  }
  
  public final void a(nv paramnv)
  {
    synchronized (this.h)
    {
      if (this.g.size() > 200) {
        this.g.clear();
      }
      this.g.add(paramnv);
      b();
      return;
    }
  }
  
  public final void b()
  {
    synchronized (this.k)
    {
      this.k.add(nv.p);
      return;
    }
  }
  
  public final void c()
  {
    int m;
    for (;;)
    {
      nv localnv;
      synchronized (this.h)
      {
        this.j.clear();
        this.i.clear();
        Iterator localIterator = this.g.iterator();
        m = 0;
        if (!localIterator.hasNext()) {
          break;
        }
        localnv = (nv)localIterator.next();
        if (localnv.m)
        {
          m = 1;
          this.i.add(localnv);
        }
      }
      this.j.add(localnv);
    }
    this.g.clear();
    Object localObject2;
    if (m != 0)
    {
      localObject2 = this.g;
      this.g = this.i;
      this.i = ((ArrayList)localObject2);
    }
    if (this.j.size() > 0)
    {
      localObject2 = this.j.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((nv)((Iterator)localObject2).next()).a();
      }
    }
  }
  
  public final boolean d()
  {
    synchronized (this.h)
    {
      if (this.g.isEmpty()) {
        return false;
      }
      nv localnv = (nv)this.g.get(0);
      if ((localnv != null) && (localnv.a(this.c))) {
        synchronized (this.h)
        {
          this.g.remove(localnv);
        }
      }
    }
    synchronized (this.h)
    {
      boolean bool = this.g.isEmpty();
      if (!bool)
      {
        return true;
        localObject1 = finally;
        throw localObject1;
        localObject2 = finally;
        throw localObject2;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.kf
 * JD-Core Version:    0.7.0.1
 */