package com.tencent.luggage.wxa.ix;

import androidx.collection.ArrayMap;
import java.util.Set;

public final class c
{
  private final d a;
  private final com.tencent.luggage.wxa.iu.d b;
  private final ArrayMap<c.a, c> c = new ArrayMap();
  
  public c(com.tencent.luggage.wxa.iu.d paramd)
  {
    this.b = paramd;
    this.a = new c.1(this, paramd);
  }
  
  private void a(b paramb)
  {
    synchronized (this.c)
    {
      c.a[] arrayOfa = new c.a[this.c.size()];
      arrayOfa = (c.a[])this.c.keySet().toArray(arrayOfa);
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        arrayOfa[i].a(this.b.aa(), paramb);
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw paramb;
    }
  }
  
  private void l()
  {
    this.b.E();
  }
  
  public b a()
  {
    return this.a.e();
  }
  
  public void a(c.a parama)
  {
    if (parama != null)
    {
      if (j()) {
        return;
      }
      synchronized (this.c)
      {
        this.c.put(parama, this);
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void b()
  {
    this.a.d();
  }
  
  public void b(c.a parama)
  {
    if (parama != null)
    {
      if (b.d == a()) {
        return;
      }
      synchronized (this.c)
      {
        this.c.remove(parama);
        return;
      }
    }
  }
  
  public void c()
  {
    this.a.a(d.a.h);
  }
  
  public void d()
  {
    this.a.a(d.a.b);
  }
  
  public void e()
  {
    this.a.a(d.a.c, "onRuntimeResume");
  }
  
  public void f()
  {
    this.a.a(d.a.c, "onRuntimeCreate");
  }
  
  public void g()
  {
    this.a.a(d.a.g);
  }
  
  public void h()
  {
    this.a.c();
  }
  
  public void i()
  {
    this.a.g();
    synchronized (this.c)
    {
      this.c.clear();
      return;
    }
  }
  
  public boolean j()
  {
    return this.a.h();
  }
  
  public boolean k()
  {
    return this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ix.c
 * JD-Core Version:    0.7.0.1
 */