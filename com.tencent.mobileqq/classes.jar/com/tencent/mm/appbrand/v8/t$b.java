package com.tencent.mm.appbrand.v8;

import androidx.annotation.NonNull;
import com.eclipsesource.mmv8.V8Function;
import com.tencent.luggage.wxa.qz.o;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

class t$b
{
  private static b c = null;
  private final ConcurrentHashMap<Integer, ConcurrentLinkedQueue<t.a>> b = new ConcurrentHashMap(100);
  private AtomicInteger d = new AtomicInteger(0);
  
  private int a(int paramInt, V8Function paramV8Function, n paramn)
  {
    synchronized (this.b)
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue;
      boolean bool;
      if (this.b.containsKey(Integer.valueOf(paramInt)))
      {
        localConcurrentLinkedQueue = (ConcurrentLinkedQueue)this.b.get(Integer.valueOf(paramInt));
        if ((!a) && (localConcurrentLinkedQueue == null)) {
          throw new AssertionError();
        }
        bool = localConcurrentLinkedQueue.isEmpty();
      }
      else
      {
        localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.b.put(Integer.valueOf(paramInt), localConcurrentLinkedQueue);
        bool = true;
      }
      paramInt = this.d.getAndIncrement();
      paramV8Function = new t.a(paramInt, paramn, paramV8Function);
      localConcurrentLinkedQueue.offer(paramV8Function);
      if (bool) {
        a(t.a.a(paramV8Function), t.a.b(paramV8Function));
      }
      o.f("MicroMsg.V8DirectApiSharedBufferLock", "hy: request lock %d", new Object[] { Integer.valueOf(paramInt) });
      return paramInt;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    synchronized (this.b)
    {
      o.f("MicroMsg.V8DirectApiSharedBufferLock", "hy: request unlock %d", new Object[] { Integer.valueOf(paramInt2) });
      Object localObject1 = (ConcurrentLinkedQueue)this.b.get(Integer.valueOf(paramInt1));
      o.e("MicroMsg.V8DirectApiSharedBufferLock", "hy: current queue: %s", new Object[] { localObject1 });
      if (localObject1 != null)
      {
        t.a locala = (t.a)((ConcurrentLinkedQueue)localObject1).poll();
        if (locala != null)
        {
          o.e("MicroMsg.V8DirectApiSharedBufferLock", "hy: toBeRemoved: %d", new Object[] { Integer.valueOf(t.a.c(locala)) });
          localObject1 = (t.a)((ConcurrentLinkedQueue)localObject1).peek();
          if (localObject1 != null)
          {
            o.e("MicroMsg.V8DirectApiSharedBufferLock", "hy: next called: %d", new Object[] { Integer.valueOf(t.a.c((t.a)localObject1)) });
            a(t.a.a((t.a)localObject1), t.a.b((t.a)localObject1));
          }
        }
        else
        {
          o.c("MicroMsg.V8DirectApiSharedBufferLock", "hy: bufferId: %d itemId: %d not found", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        }
      }
      else
      {
        o.f("MicroMsg.V8DirectApiSharedBufferLock", "hy: can not locate buffer locks %d", new Object[] { Integer.valueOf(paramInt1) });
      }
      return;
    }
  }
  
  private void a(n paramn)
  {
    synchronized (this.b)
    {
      o.d("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger release engine %d", new Object[] { Integer.valueOf(paramn.hashCode()) });
      Iterator localIterator1 = this.b.keySet().iterator();
      while (localIterator1.hasNext())
      {
        Object localObject = (Integer)localIterator1.next();
        localObject = (ConcurrentLinkedQueue)this.b.get(localObject);
        if (localObject != null)
        {
          Iterator localIterator2 = ((ConcurrentLinkedQueue)localObject).iterator();
          while (localIterator2.hasNext())
          {
            t.a locala = (t.a)localIterator2.next();
            if (t.a.a(locala) == paramn)
            {
              t.a.b(locala).release();
              ((ConcurrentLinkedQueue)localObject).remove(locala);
            }
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw paramn;
    }
  }
  
  private void a(@NonNull n paramn, @NonNull V8Function paramV8Function)
  {
    paramn.a().a(new t.b.1(this, paramV8Function, paramn));
  }
  
  private static b b()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new b();
        }
      }
      finally {}
    }
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.t.b
 * JD-Core Version:    0.7.0.1
 */