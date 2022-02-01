package com.tencent.luggage.wxa.ro;

import android.util.Pair;
import com.tencent.luggage.wxa.rn.a;
import com.tencent.luggage.wxa.rr.k;
import java.util.Iterator;
import java.util.List;

class f$b
  implements b
{
  f$b(f paramf) {}
  
  private void c()
  {
    synchronized (this.a)
    {
      if ((f.d(this.a) != f.d.e) && (f.d(this.a) != f.d.a))
      {
        if (!f.g(this.a))
        {
          a.a("Vending.Pipeline", "you are using mario().pause() out of a functional scope on %s!", new Object[] { this.a });
          return;
        }
        if (!f.k(this.a))
        {
          a.a("Vending.Pipeline", "you are using mario().pause() out of calling thread on %s!", new Object[] { this.a });
          return;
        }
        f.a(this.a, f.d.d);
        return;
      }
      a.b("Vending.Pipeline", "current is state(%s), ignore pause.", new Object[] { f.d(this.a) });
      return;
    }
  }
  
  public void a()
  {
    synchronized (this.a)
    {
      c();
      return;
    }
  }
  
  public void a(Object paramObject)
  {
    synchronized (this.a)
    {
      if (f.d(this.a) == f.d.e)
      {
        a.c("Vending.Pipeline", "interrupted, skip this interrupt.", new Object[0]);
        return;
      }
      if ((!f.g(this.a)) && (f.d(this.a) != f.d.d))
      {
        a.c("Vending.Pipeline", "interrupt not in func scope or pending, skip this retryOrInterrupt.", new Object[0]);
        return;
      }
      a.c("Vending.Pipeline", "interrupt Pipeline(%s)", new Object[] { this.a });
      f.a(this.a, false);
      f.b(this.a, true);
      f.b(this.a, paramObject);
      if (f.h(this.a) != null)
      {
        Iterator localIterator = f.h(this.a).iterator();
        while (localIterator.hasNext())
        {
          Pair localPair = (Pair)localIterator.next();
          f.a(this.a, localPair, paramObject);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public void a(Object... paramVarArgs)
  {
    synchronized (this.a)
    {
      if (f.d(this.a) != f.d.d)
      {
        a.c("Vending.Pipeline", "state is not pausing %s, skip this wormhole", new Object[] { f.d(this.a) });
        return;
      }
      f localf2 = this.a;
      if (paramVarArgs.length == 0) {
        paramVarArgs = null;
      } else if (paramVarArgs.length == 1) {
        paramVarArgs = paramVarArgs[0];
      } else {
        paramVarArgs = k.b(paramVarArgs);
      }
      f.a(localf2, paramVarArgs);
      a.c("Vending.Pipeline", "pipline(%s) wormhole(%s).", new Object[] { this.a, f.a(f.j(this.a)) });
      b();
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.a)
    {
      if (f.d(this.a) != f.d.d)
      {
        a.a("Vending.Pipeline", "this Pipeline(%s) is not pausing! why call resume?", new Object[] { this.a });
        return;
      }
      if (!f.g(this.a)) {
        f.a(this.a, f.d.b);
      } else {
        f.a(this.a, f.d.c);
      }
      f.e(this.a);
      if (!f.k(this.a)) {
        f.f(this.a);
      }
      return;
    }
  }
  
  public void b(Object paramObject)
  {
    synchronized (this.a)
    {
      if (f.d(this.a) == f.d.e)
      {
        a.c("Vending.Pipeline", "interrupted, skip this progress.", new Object[0]);
        return;
      }
      if ((!f.g(this.a)) && (f.d(this.a) != f.d.d))
      {
        a.c("Vending.Pipeline", "progress not in func scope or pending, skip this retryOrInterrupt.", new Object[0]);
        return;
      }
      f.c(this.a, true);
      f.c(this.a, paramObject);
      if (f.i(this.a) != null)
      {
        Iterator localIterator = f.i(this.a).iterator();
        while (localIterator.hasNext())
        {
          Pair localPair = (Pair)localIterator.next();
          f.b(this.a, localPair, paramObject);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ro.f.b
 * JD-Core Version:    0.7.0.1
 */