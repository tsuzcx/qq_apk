package com.tencent.luggage.wxa.ae;

import com.tencent.luggage.wxa.ad.h;
import com.tencent.luggage.wxa.ad.i;
import com.tencent.luggage.wxa.ao.a;
import java.util.LinkedList;
import java.util.PriorityQueue;

abstract class d
  implements com.tencent.luggage.wxa.ad.e
{
  private final LinkedList<h> a = new LinkedList();
  private final LinkedList<i> b;
  private final PriorityQueue<h> c;
  private h d;
  private long e;
  
  public d()
  {
    int j = 0;
    int i = 0;
    while (i < 10)
    {
      this.a.add(new h());
      i += 1;
    }
    this.b = new LinkedList();
    i = j;
    while (i < 2)
    {
      this.b.add(new e(this));
      i += 1;
    }
    this.c = new PriorityQueue();
  }
  
  private void c(h paramh)
  {
    paramh.a();
    this.a.add(paramh);
  }
  
  public void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  protected abstract void a(h paramh);
  
  protected void a(i parami)
  {
    parami.a();
    this.b.add(parami);
  }
  
  public void b(h paramh)
  {
    boolean bool;
    if (paramh == this.d) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(bool);
    if (paramh.e_()) {
      c(paramh);
    } else {
      this.c.add(paramh);
    }
    this.d = null;
  }
  
  public void c()
  {
    this.e = 0L;
    while (!this.c.isEmpty()) {
      c((h)this.c.poll());
    }
    h localh = this.d;
    if (localh != null)
    {
      c(localh);
      this.d = null;
    }
  }
  
  public void d() {}
  
  protected abstract boolean e();
  
  protected abstract com.tencent.luggage.wxa.ad.d f();
  
  public i g()
  {
    if (this.b.isEmpty()) {
      return null;
    }
    while ((!this.c.isEmpty()) && (((h)this.c.peek()).c <= this.e))
    {
      h localh = (h)this.c.poll();
      Object localObject;
      if (localh.c())
      {
        localObject = (i)this.b.pollFirst();
        ((i)localObject).b(4);
        c(localh);
        return localObject;
      }
      a(localh);
      if (e())
      {
        localObject = f();
        if (!localh.e_())
        {
          i locali = (i)this.b.pollFirst();
          locali.a(localh.c, (com.tencent.luggage.wxa.ad.d)localObject, 9223372036854775807L);
          c(localh);
          return locali;
        }
      }
      c(localh);
    }
    return null;
  }
  
  public h h()
  {
    boolean bool;
    if (this.d == null) {
      bool = true;
    } else {
      bool = false;
    }
    a.b(bool);
    if (this.a.isEmpty()) {
      return null;
    }
    this.d = ((h)this.a.pollFirst());
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ae.d
 * JD-Core Version:    0.7.0.1
 */