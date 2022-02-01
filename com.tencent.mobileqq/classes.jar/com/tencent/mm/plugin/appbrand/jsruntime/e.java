package com.tencent.mm.plugin.appbrand.jsruntime;

import android.util.SparseArray;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicInteger;

public class e
{
  private final e.a b;
  private final AtomicInteger c;
  private final SparseArray<d> d;
  
  public e(e.a parama)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.b = parama;
    this.c = new AtomicInteger(1);
    this.d = new SparseArray();
  }
  
  public static int a()
  {
    return 1;
  }
  
  public g a(int paramInt)
  {
    synchronized (this.d)
    {
      g localg = (g)this.d.get(paramInt);
      return localg;
    }
  }
  
  public void a(d paramd)
  {
    o.d("MicroMsg.AppBrandJ2V8ContextMgr", "setMainContext id:%d", new Object[] { Integer.valueOf(1) });
    this.d.put(1, paramd);
  }
  
  public g b()
  {
    return a(1);
  }
  
  public void b(int paramInt)
  {
    o.d("MicroMsg.AppBrandJ2V8ContextMgr", "destroyJsContext id:%d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (this.d)
    {
      d locald = (d)this.d.get(paramInt);
      this.d.delete(paramInt);
      if (locald != null) {
        locald.destroy();
      }
      return;
    }
  }
  
  public g c()
  {
    int i = this.c.incrementAndGet();
    f localf = new f(this.b.a(i), i);
    synchronized (this.d)
    {
      this.d.put(i, localf);
      o.d("MicroMsg.AppBrandJ2V8ContextMgr", "allocJsContext id:%d", new Object[] { Integer.valueOf(i) });
      return localf;
    }
  }
  
  public void d()
  {
    SparseArray localSparseArray = this.d;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.d.size())
        {
          int j = this.d.keyAt(i);
          if (j != 1)
          {
            o.d("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d", new Object[] { Integer.valueOf(j) });
            if (this.d.get(j) == null) {
              o.c("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d null", new Object[] { Integer.valueOf(j) });
            } else {
              ((d)this.d.get(j)).destroy();
            }
          }
        }
        else
        {
          this.d.clear();
          return;
        }
      }
      finally
      {
        continue;
        throw localObject;
        continue;
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.e
 * JD-Core Version:    0.7.0.1
 */