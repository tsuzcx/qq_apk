package com.tencent.component.network.utils.http.pool;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class AbstractConnPool<T, C, E extends PoolEntry<T, C>>
  implements ConnPool<T, E>, ConnPoolControl<T>
{
  private final LinkedList<E> available;
  private final ConnFactory<T, C> connFactory;
  private volatile int defaultMaxPerRoute;
  private volatile boolean isShutDown;
  private final Set<E> leased;
  private final Lock lock;
  private final Map<T, Integer> maxPerRoute;
  private volatile int maxTotal;
  private final LinkedList<PoolEntryFuture<E>> pending;
  private final Map<T, RouteSpecificPool<T, C, E>> routeToPool;
  
  public AbstractConnPool(ConnFactory<T, C> paramConnFactory, int paramInt1, int paramInt2)
  {
    if (paramConnFactory != null)
    {
      if (paramInt1 > 0)
      {
        if (paramInt2 > 0)
        {
          this.lock = new ReentrantLock();
          this.connFactory = paramConnFactory;
          this.routeToPool = new HashMap();
          this.leased = new HashSet();
          this.available = new LinkedList();
          this.pending = new LinkedList();
          this.maxPerRoute = new HashMap();
          this.defaultMaxPerRoute = paramInt1;
          this.maxTotal = paramInt2;
          return;
        }
        throw new IllegalArgumentException("Max total value may not be negative or zero");
      }
      throw new IllegalArgumentException("Max per route value may not be negative or zero");
    }
    throw new IllegalArgumentException("Connection factory may not null");
  }
  
  private int getMax(T paramT)
  {
    paramT = (Integer)this.maxPerRoute.get(paramT);
    if (paramT != null) {
      return paramT.intValue();
    }
    return this.defaultMaxPerRoute;
  }
  
  private RouteSpecificPool<T, C, E> getPool(T paramT)
  {
    RouteSpecificPool localRouteSpecificPool = (RouteSpecificPool)this.routeToPool.get(paramT);
    Object localObject = localRouteSpecificPool;
    if (localRouteSpecificPool == null)
    {
      localObject = new AbstractConnPool.1(this, paramT, paramT);
      this.routeToPool.put(paramT, localObject);
    }
    return localObject;
  }
  
  private E getPoolEntryBlocking(T paramT, Object paramObject, long paramLong, TimeUnit paramTimeUnit, PoolEntryFuture<E> paramPoolEntryFuture)
  {
    Object localObject = null;
    if (paramLong > 0L) {
      paramTimeUnit = new Date(System.currentTimeMillis() + paramTimeUnit.toMillis(paramLong));
    } else {
      paramTimeUnit = null;
    }
    this.lock.lock();
    try
    {
      RouteSpecificPool localRouteSpecificPool = getPool(paramT);
      if (localObject == null)
      {
        if (!this.isShutDown) {
          for (;;)
          {
            PoolEntry localPoolEntry;
            for (;;)
            {
              localPoolEntry = localRouteSpecificPool.getFree(paramObject);
              if ((localPoolEntry == null) || ((!localPoolEntry.isClosed()) && (!localPoolEntry.isExpired(System.currentTimeMillis()))))
              {
                if (localPoolEntry != null)
                {
                  this.available.remove(localPoolEntry);
                  this.leased.add(localPoolEntry);
                  this.lock.unlock();
                  return localPoolEntry;
                }
                int j = getMax(paramT);
                int k = Math.max(0, localRouteSpecificPool.getAllocatedCount() + 1 - j);
                int i;
                if (k > 0)
                {
                  i = 0;
                  while (i < k)
                  {
                    localObject = localRouteSpecificPool.getLastUsed();
                    if (localObject == null) {
                      break;
                    }
                    ((PoolEntry)localObject).close();
                    this.available.remove(localObject);
                    localRouteSpecificPool.remove((PoolEntry)localObject);
                    i += 1;
                  }
                }
                if (localRouteSpecificPool.getAllocatedCount() < j)
                {
                  i = this.leased.size();
                  i = Math.max(this.maxTotal - i, 0);
                  if (i > 0)
                  {
                    if ((this.available.size() > i - 1) && (!this.available.isEmpty()))
                    {
                      paramObject = (PoolEntry)this.available.removeLast();
                      paramObject.close();
                      getPool(paramObject.getRoute()).remove(paramObject);
                    }
                    paramT = localRouteSpecificPool.add(this.connFactory.create(paramT));
                    this.leased.add(paramT);
                    this.lock.unlock();
                    return paramT;
                  }
                }
              }
              try
              {
                localRouteSpecificPool.queue(paramPoolEntryFuture);
                this.pending.add(paramPoolEntryFuture);
                boolean bool = paramPoolEntryFuture.await(paramTimeUnit);
                localRouteSpecificPool.unqueue(paramPoolEntryFuture);
                this.pending.remove(paramPoolEntryFuture);
                localObject = localPoolEntry;
                if (bool) {
                  break;
                }
                localObject = localPoolEntry;
                if (paramTimeUnit == null) {
                  break;
                }
                if (paramTimeUnit.getTime() <= System.currentTimeMillis()) {
                  break label489;
                }
                localObject = localPoolEntry;
              }
              finally
              {
                localRouteSpecificPool.unqueue(paramPoolEntryFuture);
                this.pending.remove(paramPoolEntryFuture);
              }
            }
            localRouteSpecificPool.free(localPoolEntry, false);
          }
        }
        throw new IllegalStateException("Connection pool shut down");
      }
      label489:
      throw new TimeoutException("Timeout waiting for connection");
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw paramT;
    }
  }
  
  private void notifyPending(RouteSpecificPool<T, C, E> paramRouteSpecificPool)
  {
    paramRouteSpecificPool = paramRouteSpecificPool.nextPending();
    if (paramRouteSpecificPool != null) {
      this.pending.remove(paramRouteSpecificPool);
    } else {
      paramRouteSpecificPool = (PoolEntryFuture)this.pending.poll();
    }
    if (paramRouteSpecificPool != null) {
      paramRouteSpecificPool.wakeup();
    }
  }
  
  public void closeExpired()
  {
    long l = System.currentTimeMillis();
    this.lock.lock();
    try
    {
      Iterator localIterator = this.available.iterator();
      while (localIterator.hasNext())
      {
        PoolEntry localPoolEntry = (PoolEntry)localIterator.next();
        if (localPoolEntry.isExpired(l))
        {
          localPoolEntry.close();
          RouteSpecificPool localRouteSpecificPool = getPool(localPoolEntry.getRoute());
          localRouteSpecificPool.remove(localPoolEntry);
          localIterator.remove();
          notifyPending(localRouteSpecificPool);
        }
      }
      this.lock.unlock();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void closeIdle(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramTimeUnit != null)
    {
      long l = paramTimeUnit.toMillis(paramLong);
      paramLong = l;
      if (l < 0L) {
        paramLong = 0L;
      }
      l = System.currentTimeMillis();
      this.lock.lock();
      try
      {
        paramTimeUnit = this.available.iterator();
        while (paramTimeUnit.hasNext())
        {
          PoolEntry localPoolEntry = (PoolEntry)paramTimeUnit.next();
          if (localPoolEntry.getUpdated() <= l - paramLong)
          {
            localPoolEntry.close();
            RouteSpecificPool localRouteSpecificPool = getPool(localPoolEntry.getRoute());
            localRouteSpecificPool.remove(localPoolEntry);
            paramTimeUnit.remove();
            notifyPending(localRouteSpecificPool);
          }
        }
        return;
      }
      finally
      {
        this.lock.unlock();
      }
    }
    paramTimeUnit = new IllegalArgumentException("Time unit must not be null.");
    for (;;)
    {
      throw paramTimeUnit;
    }
  }
  
  protected abstract E createEntry(T paramT, C paramC);
  
  public int getDefaultMaxPerRoute()
  {
    this.lock.lock();
    try
    {
      int i = this.defaultMaxPerRoute;
      return i;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public int getMaxPerRoute(T paramT)
  {
    if (paramT != null)
    {
      this.lock.lock();
      try
      {
        int i = getMax(paramT);
        return i;
      }
      finally
      {
        this.lock.unlock();
      }
    }
    throw new IllegalArgumentException("Route may not be null");
  }
  
  public int getMaxTotal()
  {
    this.lock.lock();
    try
    {
      int i = this.maxTotal;
      return i;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public PoolStats getStats(T paramT)
  {
    if (paramT != null)
    {
      this.lock.lock();
      try
      {
        RouteSpecificPool localRouteSpecificPool = getPool(paramT);
        paramT = new PoolStats(localRouteSpecificPool.getLeasedCount(), localRouteSpecificPool.getPendingCount(), localRouteSpecificPool.getAvailableCount(), getMax(paramT));
        return paramT;
      }
      finally
      {
        this.lock.unlock();
      }
    }
    throw new IllegalArgumentException("Route may not be null");
  }
  
  public PoolStats getTotalStats()
  {
    this.lock.lock();
    try
    {
      PoolStats localPoolStats = new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
      return localPoolStats;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public boolean isShutdown()
  {
    return this.isShutDown;
  }
  
  public Future<E> lease(T paramT, Object paramObject)
  {
    return lease(paramT, paramObject, null);
  }
  
  public Future<E> lease(T paramT, Object paramObject, FutureCallback<E> paramFutureCallback)
  {
    if (paramT != null)
    {
      if (!this.isShutDown) {
        return new AbstractConnPool.2(this, this.lock, paramFutureCallback, paramT, paramObject);
      }
      throw new IllegalStateException("Connection pool shut down");
    }
    throw new IllegalArgumentException("Route may not be null");
  }
  
  public void release(E paramE, boolean paramBoolean)
  {
    this.lock.lock();
    try
    {
      if (this.leased.remove(paramE))
      {
        RouteSpecificPool localRouteSpecificPool = getPool(paramE.getRoute());
        localRouteSpecificPool.free(paramE, paramBoolean);
        if ((paramBoolean) && (!this.isShutDown)) {
          this.available.addFirst(paramE);
        } else {
          paramE.close();
        }
        notifyPending(localRouteSpecificPool);
      }
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void setDefaultMaxPerRoute(int paramInt)
  {
    if (paramInt > 0)
    {
      this.lock.lock();
      try
      {
        this.defaultMaxPerRoute = paramInt;
        return;
      }
      finally
      {
        this.lock.unlock();
      }
    }
    throw new IllegalArgumentException("Max value may not be negative or zero");
  }
  
  public void setMaxPerRoute(T paramT, int paramInt)
  {
    if (paramT != null)
    {
      if (paramInt > 0)
      {
        this.lock.lock();
        try
        {
          this.maxPerRoute.put(paramT, Integer.valueOf(paramInt));
          return;
        }
        finally
        {
          this.lock.unlock();
        }
      }
      throw new IllegalArgumentException("Max value may not be negative or zero");
    }
    throw new IllegalArgumentException("Route may not be null");
  }
  
  public void setMaxTotal(int paramInt)
  {
    if (paramInt > 0)
    {
      this.lock.lock();
      try
      {
        this.maxTotal = paramInt;
        return;
      }
      finally
      {
        this.lock.unlock();
      }
    }
    throw new IllegalArgumentException("Max value may not be negative or zero");
  }
  
  public void shutdown()
  {
    if (this.isShutDown) {
      return;
    }
    this.isShutDown = true;
    this.lock.lock();
    try
    {
      Iterator localIterator = this.available.iterator();
      while (localIterator.hasNext()) {
        ((PoolEntry)localIterator.next()).close();
      }
      localIterator = this.leased.iterator();
      while (localIterator.hasNext()) {
        ((PoolEntry)localIterator.next()).close();
      }
      localIterator = this.routeToPool.values().iterator();
      while (localIterator.hasNext()) {
        ((RouteSpecificPool)localIterator.next()).shutdown();
      }
      this.routeToPool.clear();
      this.leased.clear();
      this.available.clear();
      this.lock.unlock();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[leased: ");
    localStringBuilder.append(this.leased);
    localStringBuilder.append("][available: ");
    localStringBuilder.append(this.available);
    localStringBuilder.append("][pending: ");
    localStringBuilder.append(this.pending);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.AbstractConnPool
 * JD-Core Version:    0.7.0.1
 */