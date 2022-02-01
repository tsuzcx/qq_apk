package com.tencent.luggage.wxa.j;

import com.tencent.luggage.wxa.ao.a;
import java.util.LinkedList;

public abstract class g<I extends e, O extends f, E extends Exception>
  implements c<I, O, E>
{
  private final Thread a;
  private final Object b = new Object();
  private final LinkedList<I> c = new LinkedList();
  private final LinkedList<O> d = new LinkedList();
  private final I[] e;
  private final O[] f;
  private int g;
  private int h;
  private I i;
  private E j;
  private boolean k;
  private boolean l;
  private int m;
  
  protected g(I[] paramArrayOfI, O[] paramArrayOfO)
  {
    this.e = paramArrayOfI;
    this.g = paramArrayOfI.length;
    int i1 = 0;
    int n = 0;
    while (n < this.g)
    {
      this.e[n] = g();
      n += 1;
    }
    this.f = paramArrayOfO;
    this.h = paramArrayOfO.length;
    n = i1;
    while (n < this.h)
    {
      this.f[n] = h();
      n += 1;
    }
    this.a = new g.1(this);
    this.a.start();
  }
  
  private void b(I paramI)
  {
    paramI.a();
    e[] arrayOfe = this.e;
    int n = this.g;
    this.g = (n + 1);
    arrayOfe[n] = paramI;
  }
  
  private void b(O paramO)
  {
    paramO.a();
    f[] arrayOff = this.f;
    int n = this.h;
    this.h = (n + 1);
    arrayOff[n] = paramO;
  }
  
  private void i()
  {
    Exception localException = this.j;
    if (localException == null) {
      return;
    }
    throw localException;
  }
  
  private void j()
  {
    if (m()) {
      this.b.notify();
    }
  }
  
  private void k()
  {
    IllegalStateException localIllegalStateException;
    try
    {
      boolean bool;
      do
      {
        bool = l();
      } while (bool);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localIllegalStateException = new IllegalStateException(localInterruptedException);
    }
    for (;;)
    {
      throw localIllegalStateException;
    }
  }
  
  private boolean l()
  {
    synchronized (this.b)
    {
      while ((!this.l) && (!m())) {
        this.b.wait();
      }
      if (this.l) {
        return false;
      }
      e locale1 = (e)this.c.removeFirst();
      Object localObject4 = this.f;
      int n = this.h - 1;
      this.h = n;
      localObject4 = localObject4[n];
      boolean bool = this.k;
      this.k = false;
      if (locale1.c())
      {
        ((f)localObject4).b(4);
      }
      else
      {
        if (locale1.e_()) {
          ((f)localObject4).b(-2147483648);
        }
        this.j = a(locale1, (f)localObject4, bool);
        if (this.j != null) {
          synchronized (this.b)
          {
            return false;
          }
        }
      }
      synchronized (this.b)
      {
        if (this.k)
        {
          b((f)localObject4);
        }
        else if (((f)localObject4).e_())
        {
          this.m += 1;
          b((f)localObject4);
        }
        else
        {
          ((f)localObject4).b = this.m;
          this.m = 0;
          this.d.addLast(localObject4);
        }
        b(locale2);
        return true;
      }
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  private boolean m()
  {
    return (!this.c.isEmpty()) && (this.h > 0);
  }
  
  protected abstract E a(I paramI, O paramO, boolean paramBoolean);
  
  protected final void a(int paramInt)
  {
    int i1 = this.g;
    int i2 = this.e.length;
    int n = 0;
    boolean bool;
    if (i1 == i2) {
      bool = true;
    } else {
      bool = false;
    }
    a.b(bool);
    e[] arrayOfe = this.e;
    i1 = arrayOfe.length;
    while (n < i1)
    {
      arrayOfe[n].e(paramInt);
      n += 1;
    }
  }
  
  public final void a(I paramI)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        i();
        if (paramI == this.i)
        {
          bool = true;
          a.a(bool);
          this.c.addLast(paramI);
          j();
          this.i = null;
          return;
        }
      }
      boolean bool = false;
    }
  }
  
  protected void a(O paramO)
  {
    synchronized (this.b)
    {
      b(paramO);
      j();
      return;
    }
  }
  
  public final void c()
  {
    synchronized (this.b)
    {
      this.k = true;
      this.m = 0;
      if (this.i != null)
      {
        b(this.i);
        this.i = null;
      }
      while (!this.c.isEmpty()) {
        b((e)this.c.removeFirst());
      }
      while (!this.d.isEmpty()) {
        b((f)this.d.removeFirst());
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void d()
  {
    synchronized (this.b)
    {
      this.l = true;
      this.b.notify();
      try
      {
        this.a.join();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        label29:
        break label29;
      }
      Thread.currentThread().interrupt();
      return;
    }
  }
  
  public final I e()
  {
    for (;;)
    {
      synchronized (this.b)
      {
        i();
        if (this.i == null)
        {
          bool = true;
          a.b(bool);
          if (this.g == 0)
          {
            localObject1 = null;
          }
          else
          {
            localObject1 = this.e;
            int n = this.g - 1;
            this.g = n;
            localObject1 = localObject1[n];
          }
          this.i = ((e)localObject1);
          Object localObject1 = this.i;
          return localObject1;
        }
      }
      boolean bool = false;
    }
  }
  
  public final O f()
  {
    synchronized (this.b)
    {
      i();
      if (this.d.isEmpty()) {
        return null;
      }
      f localf = (f)this.d.removeFirst();
      return localf;
    }
  }
  
  protected abstract I g();
  
  protected abstract O h();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.j.g
 * JD-Core Version:    0.7.0.1
 */