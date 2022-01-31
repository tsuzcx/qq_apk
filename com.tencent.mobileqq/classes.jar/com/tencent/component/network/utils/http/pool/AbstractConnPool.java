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
    if (paramConnFactory == null) {
      throw new IllegalArgumentException("Connection factory may not null");
    }
    if (paramInt1 <= 0) {
      throw new IllegalArgumentException("Max per route value may not be negative or zero");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("Max total value may not be negative or zero");
    }
    this.lock = new ReentrantLock();
    this.connFactory = paramConnFactory;
    this.routeToPool = new HashMap();
    this.leased = new HashSet();
    this.available = new LinkedList();
    this.pending = new LinkedList();
    this.maxPerRoute = new HashMap();
    this.defaultMaxPerRoute = paramInt1;
    this.maxTotal = paramInt2;
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
    Date localDate = null;
    if (paramLong > 0L) {
      localDate = new Date(System.currentTimeMillis() + paramTimeUnit.toMillis(paramLong));
    }
    this.lock.lock();
    for (;;)
    {
      RouteSpecificPool localRouteSpecificPool;
      try
      {
        localRouteSpecificPool = getPool(paramT);
        paramTimeUnit = null;
        if (paramTimeUnit != null) {
          break label463;
        }
        if (this.isShutDown) {
          throw new IllegalStateException("Connection pool shut down");
        }
      }
      finally
      {
        this.lock.unlock();
      }
      Object localObject;
      do
      {
        if ((!((PoolEntry)localObject).isClosed()) && (!((PoolEntry)localObject).isExpired(System.currentTimeMillis()))) {
          break;
        }
        ((PoolEntry)localObject).close();
        this.available.remove(localObject);
        localRouteSpecificPool.free((PoolEntry)localObject, false);
        localObject = localRouteSpecificPool.getFree(paramObject);
      } while (localObject != null);
      if (localObject != null)
      {
        this.available.remove(localObject);
        this.leased.add(localObject);
        this.lock.unlock();
        return localObject;
      }
      int j = getMax(paramT);
      int k = Math.max(0, localRouteSpecificPool.getAllocatedCount() + 1 - j);
      int i;
      if (k > 0) {
        i = 0;
      }
      for (;;)
      {
        if (i < k)
        {
          paramTimeUnit = localRouteSpecificPool.getLastUsed();
          if (paramTimeUnit != null) {}
        }
        else
        {
          if (localRouteSpecificPool.getAllocatedCount() >= j) {
            break;
          }
          i = this.leased.size();
          i = Math.max(this.maxTotal - i, 0);
          if (i <= 0) {
            break;
          }
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
        paramTimeUnit.close();
        this.available.remove(paramTimeUnit);
        localRouteSpecificPool.remove(paramTimeUnit);
        i += 1;
      }
      try
      {
        localRouteSpecificPool.queue(paramPoolEntryFuture);
        this.pending.add(paramPoolEntryFuture);
        boolean bool = paramPoolEntryFuture.await(localDate);
        localRouteSpecificPool.unqueue(paramPoolEntryFuture);
        this.pending.remove(paramPoolEntryFuture);
        paramTimeUnit = (TimeUnit)localObject;
        if (bool) {
          continue;
        }
        paramTimeUnit = (TimeUnit)localObject;
        if (localDate == null) {
          continue;
        }
        paramTimeUnit = (TimeUnit)localObject;
        if (localDate.getTime() > System.currentTimeMillis()) {
          continue;
        }
        label463:
        throw new TimeoutException("Timeout waiting for connection");
      }
      finally
      {
        localRouteSpecificPool.unqueue(paramPoolEntryFuture);
        this.pending.remove(paramPoolEntryFuture);
      }
    }
  }
  
  private void notifyPending(RouteSpecificPool<T, C, E> paramRouteSpecificPool)
  {
    paramRouteSpecificPool = paramRouteSpecificPool.nextPending();
    if (paramRouteSpecificPool != null) {
      this.pending.remove(paramRouteSpecificPool);
    }
    for (;;)
    {
      if (paramRouteSpecificPool != null) {
        paramRouteSpecificPool.wakeup();
      }
      return;
      paramRouteSpecificPool = (PoolEntryFuture)this.pending.poll();
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
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public void closeIdle(long paramLong, TimeUnit paramTimeUnit)
  {
    long l = 0L;
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("Time unit must not be null.");
    }
    paramLong = paramTimeUnit.toMillis(paramLong);
    if (paramLong < 0L) {
      paramLong = l;
    }
    for (;;)
    {
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
      }
      finally
      {
        this.lock.unlock();
      }
      return;
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
    if (paramT == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
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
    if (paramT == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
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
    if (paramT == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    if (this.isShutDown) {
      throw new IllegalStateException("Connection pool shut down");
    }
    return new AbstractConnPool.2(this, this.lock, paramFutureCallback, paramT, paramObject);
  }
  
  /* Error */
  public void release(E paramE, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/tencent/component/network/utils/http/pool/AbstractConnPool:lock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 137 1 0
    //   9: aload_0
    //   10: getfield 65	com/tencent/component/network/utils/http/pool/AbstractConnPool:leased	Ljava/util/Set;
    //   13: aload_1
    //   14: invokeinterface 319 2 0
    //   19: ifeq +42 -> 61
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 208	com/tencent/component/network/utils/http/pool/PoolEntry:getRoute	()Ljava/lang/Object;
    //   27: invokespecial 139	com/tencent/component/network/utils/http/pool/AbstractConnPool:getPool	(Ljava/lang/Object;)Lcom/tencent/component/network/utils/http/pool/RouteSpecificPool;
    //   30: astore_3
    //   31: aload_3
    //   32: aload_1
    //   33: iload_2
    //   34: invokevirtual 170	com/tencent/component/network/utils/http/pool/RouteSpecificPool:free	(Lcom/tencent/component/network/utils/http/pool/PoolEntry;Z)V
    //   37: iload_2
    //   38: ifeq +33 -> 71
    //   41: aload_0
    //   42: getfield 141	com/tencent/component/network/utils/http/pool/AbstractConnPool:isShutDown	Z
    //   45: ifne +26 -> 71
    //   48: aload_0
    //   49: getfield 70	com/tencent/component/network/utils/http/pool/AbstractConnPool:available	Ljava/util/LinkedList;
    //   52: aload_1
    //   53: invokevirtual 323	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   56: aload_0
    //   57: aload_3
    //   58: invokespecial 271	com/tencent/component/network/utils/http/pool/AbstractConnPool:notifyPending	(Lcom/tencent/component/network/utils/http/pool/RouteSpecificPool;)V
    //   61: aload_0
    //   62: getfield 53	com/tencent/component/network/utils/http/pool/AbstractConnPool:lock	Ljava/util/concurrent/locks/Lock;
    //   65: invokeinterface 149 1 0
    //   70: return
    //   71: aload_1
    //   72: invokevirtual 162	com/tencent/component/network/utils/http/pool/PoolEntry:close	()V
    //   75: goto -19 -> 56
    //   78: astore_1
    //   79: aload_0
    //   80: getfield 53	com/tencent/component/network/utils/http/pool/AbstractConnPool:lock	Ljava/util/concurrent/locks/Lock;
    //   83: invokeinterface 149 1 0
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	AbstractConnPool
    //   0	90	1	paramE	E
    //   0	90	2	paramBoolean	boolean
    //   30	28	3	localRouteSpecificPool	RouteSpecificPool
    // Exception table:
    //   from	to	target	type
    //   9	37	78	finally
    //   41	56	78	finally
    //   56	61	78	finally
    //   71	75	78	finally
  }
  
  public void setDefaultMaxPerRoute(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max value may not be negative or zero");
    }
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
  
  public void setMaxPerRoute(T paramT, int paramInt)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max value may not be negative or zero");
    }
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
  
  public void setMaxTotal(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max value may not be negative or zero");
    }
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
  
  public void shutdown()
  {
    if (this.isShutDown) {
      return;
    }
    this.isShutDown = true;
    this.lock.lock();
    try
    {
      Iterator localIterator1 = this.available.iterator();
      while (localIterator1.hasNext()) {
        ((PoolEntry)localIterator1.next()).close();
      }
      localIterator2 = this.leased.iterator();
    }
    finally
    {
      this.lock.unlock();
    }
    while (localIterator2.hasNext()) {
      ((PoolEntry)localIterator2.next()).close();
    }
    Iterator localIterator2 = this.routeToPool.values().iterator();
    while (localIterator2.hasNext()) {
      ((RouteSpecificPool)localIterator2.next()).shutdown();
    }
    this.routeToPool.clear();
    this.leased.clear();
    this.available.clear();
    this.lock.unlock();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.AbstractConnPool
 * JD-Core Version:    0.7.0.1
 */