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
    synchronized (this.h)
    {
      this.j.clear();
      this.i.clear();
      int m = 0;
      Object localObject1 = this.g.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        nv localnv = (nv)((Iterator)localObject1).next();
        if (localnv.m)
        {
          m = 1;
          this.i.add(localnv);
        }
        else
        {
          this.j.add(localnv);
        }
      }
      this.g.clear();
      if (m != 0)
      {
        localObject1 = this.g;
        this.g = this.i;
        this.i = ((ArrayList)localObject1);
      }
      if (this.j.size() > 0)
      {
        localObject1 = this.j.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((nv)((Iterator)localObject1).next()).a();
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
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
      synchronized (this.h)
      {
        boolean bool = this.g.isEmpty();
        if (!bool) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.kf
 * JD-Core Version:    0.7.0.1
 */