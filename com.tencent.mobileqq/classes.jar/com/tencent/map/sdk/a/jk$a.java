package com.tencent.map.sdk.a;

import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

final class jk$a<E>
  extends AbstractQueue<E>
  implements Serializable, BlockingQueue<E>
{
  int a = 5;
  final AtomicInteger b = new AtomicInteger();
  transient a<E>.b<E> c = new jk.a.b(this, null);
  final Condition d = this.h.newCondition();
  private final ReentrantLock f = new ReentrantLock();
  private final Condition g = this.f.newCondition();
  private final ReentrantLock h = new ReentrantLock();
  
  public jk$a(jk paramjk) {}
  
  private void a(a<E>.b<E> parama)
  {
    parama.b = this.c.b;
    this.c.b = parama;
  }
  
  private E b()
  {
    jk.a.b localb = this.c.b;
    if (localb != null)
    {
      this.c.b = localb.b;
      localb.b = null;
      Object localObject = localb.a;
      localb.a = null;
      return localObject;
    }
    return null;
  }
  
  private void c()
  {
    ReentrantLock localReentrantLock = this.h;
    localReentrantLock.lock();
    try
    {
      this.d.signal();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  private void d()
  {
    ReentrantLock localReentrantLock = this.f;
    localReentrantLock.lock();
    try
    {
      this.g.signal();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  final void a()
  {
    this.f.unlock();
    this.h.unlock();
  }
  
  public final int drainTo(Collection<? super E> paramCollection)
  {
    return drainTo(paramCollection, 2147483647);
  }
  
  public final int drainTo(Collection<? super E> paramCollection, int paramInt)
  {
    if (paramCollection != null)
    {
      if (paramCollection != this)
      {
        int k = 0;
        int m = 0;
        int n = 0;
        if (paramInt <= 0) {
          return 0;
        }
        ReentrantLock localReentrantLock = this.f;
        localReentrantLock.lock();
        int i = m;
        try
        {
          int i1 = Math.min(paramInt, this.b.get());
          i = m;
          Object localObject = this.c;
          int j = 0;
          for (;;)
          {
            if (j < i1) {}
            try
            {
              jk.a.b localb = ((jk.a.b)localObject).b;
              paramCollection.add(localb.a);
              localb.a = null;
              ((jk.a.b)localObject).b = ((jk.a.b)localObject);
              j += 1;
              localObject = localb;
            }
            finally
            {
              paramInt = n;
              if (j > 0)
              {
                i = m;
                this.c = ((jk.a.b)localObject);
                paramInt = n;
                i = m;
                if (this.b.getAndAdd(-j) == this.a) {
                  paramInt = 1;
                }
              }
              i = paramInt;
            }
          }
          if (j == m) {
            paramInt = 1;
          }
          return i1;
        }
        finally
        {
          localReentrantLock.unlock();
          if (i != 0) {
            c();
          }
        }
      }
      throw new IllegalArgumentException();
    }
    paramCollection = new NullPointerException();
    for (;;)
    {
      throw paramCollection;
    }
  }
  
  public final Iterator<E> iterator()
  {
    return new jk.a.a(this);
  }
  
  public final boolean offer(E paramE)
  {
    if (paramE != null)
    {
      AtomicInteger localAtomicInteger = this.b;
      if (localAtomicInteger.get() == this.a) {
        return false;
      }
      int i = -1;
      jk.a.b localb = new jk.a.b(this, paramE);
      paramE = this.h;
      paramE.lock();
      try
      {
        if (localAtomicInteger.get() < this.a)
        {
          a(localb);
          int j = localAtomicInteger.getAndIncrement();
          i = j;
          if (j + 1 < this.a)
          {
            this.d.signal();
            i = j;
          }
        }
        paramE.unlock();
        if (i == 0) {
          d();
        }
        return i >= 0;
      }
      finally
      {
        paramE.unlock();
      }
    }
    throw new NullPointerException();
  }
  
  public final boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramE != null)
    {
      paramLong = paramTimeUnit.toNanos(paramLong);
      paramTimeUnit = this.h;
      AtomicInteger localAtomicInteger = this.b;
      paramTimeUnit.lockInterruptibly();
      try
      {
        for (;;)
        {
          i = localAtomicInteger.get();
          int j = this.a;
          if (i != j) {
            break;
          }
          if (paramLong <= 0L) {
            return false;
          }
          paramLong = this.d.awaitNanos(paramLong);
        }
        a(new jk.a.b(this, paramE));
        int i = localAtomicInteger.getAndIncrement();
        if (i + 1 < this.a) {
          this.d.signal();
        }
        paramTimeUnit.unlock();
        if (i == 0) {
          d();
        }
        return true;
      }
      finally
      {
        paramTimeUnit.unlock();
      }
    }
    paramE = new NullPointerException();
    for (;;)
    {
      throw paramE;
    }
  }
  
  public final E peek()
  {
    if (this.b.get() == 0) {
      return null;
    }
    ReentrantLock localReentrantLock = this.f;
    localReentrantLock.lock();
    try
    {
      Object localObject1 = this.c.b;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = ((jk.a.b)localObject1).a;
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public final E poll()
  {
    AtomicInteger localAtomicInteger = this.b;
    int i = localAtomicInteger.get();
    Object localObject1 = null;
    if (i == 0) {
      return null;
    }
    i = -1;
    ReentrantLock localReentrantLock = this.f;
    localReentrantLock.lock();
    try
    {
      if (localAtomicInteger.get() > 0)
      {
        Object localObject3 = b();
        int j = localAtomicInteger.getAndDecrement();
        i = j;
        localObject1 = localObject3;
        if (j > 1)
        {
          this.g.signal();
          localObject1 = localObject3;
          i = j;
        }
      }
      localReentrantLock.unlock();
      if (i == this.a) {
        c();
      }
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public final E poll(long paramLong, TimeUnit paramTimeUnit)
  {
    paramLong = paramTimeUnit.toNanos(paramLong);
    AtomicInteger localAtomicInteger = this.b;
    paramTimeUnit = this.f;
    paramTimeUnit.lockInterruptibly();
    try
    {
      for (;;)
      {
        i = localAtomicInteger.get();
        if (i != 0) {
          break;
        }
        if (paramLong <= 0L)
        {
          paramTimeUnit.unlock();
          return null;
        }
        paramLong = this.g.awaitNanos(paramLong);
      }
      Object localObject2 = b();
      int i = localAtomicInteger.getAndDecrement();
      if (i > 1) {
        this.g.signal();
      }
      paramTimeUnit.unlock();
      if (i == this.a) {
        c();
      }
      return localObject2;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public final void put(E paramE)
  {
    if (paramE != null)
    {
      jk.a.b localb = new jk.a.b(this, paramE);
      paramE = this.h;
      AtomicInteger localAtomicInteger = this.b;
      paramE.lockInterruptibly();
      try
      {
        while (localAtomicInteger.get() == this.a) {
          this.d.await();
        }
        a(localb);
        int i = localAtomicInteger.getAndIncrement();
        if (i + 1 < this.a) {
          this.d.signal();
        }
        paramE.unlock();
        if (i == 0) {
          d();
        }
        return;
      }
      finally
      {
        paramE.unlock();
      }
    }
    paramE = new NullPointerException();
    for (;;)
    {
      throw paramE;
    }
  }
  
  public final int remainingCapacity()
  {
    return this.a - this.b.get();
  }
  
  public final int size()
  {
    return this.b.get();
  }
  
  public final E take()
  {
    AtomicInteger localAtomicInteger = this.b;
    ReentrantLock localReentrantLock = this.f;
    localReentrantLock.lockInterruptibly();
    try
    {
      while (localAtomicInteger.get() == 0) {
        this.g.await();
      }
      Object localObject2 = b();
      int i = localAtomicInteger.getAndDecrement();
      if (i > 1) {
        this.g.signal();
      }
      localReentrantLock.unlock();
      if (i == this.a) {
        c();
      }
      return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.jk.a
 * JD-Core Version:    0.7.0.1
 */