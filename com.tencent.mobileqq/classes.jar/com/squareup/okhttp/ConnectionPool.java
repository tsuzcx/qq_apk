package com.squareup.okhttp;

import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.io.RealConnection;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public final class ConnectionPool
{
  private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 300000L;
  private static final ConnectionPool systemDefault;
  private Runnable cleanupRunnable = new Runnable()
  {
    public void run()
    {
      long l1;
      do
      {
        l1 = ConnectionPool.this.cleanup(System.nanoTime());
        if (l1 == -1L) {
          return;
        }
      } while (l1 <= 0L);
      long l2 = l1 / 1000000L;
      try
      {
        label57:
        synchronized (ConnectionPool.this)
        {
          ConnectionPool.this.wait(l2, (int)(l1 - l2 * 1000000L));
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label57;
      }
    }
  };
  private final Deque<RealConnection> connections = new ArrayDeque();
  private final Executor executor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
  private final long keepAliveDurationNs;
  private final int maxIdleConnections;
  final RouteDatabase routeDatabase = new RouteDatabase();
  
  static
  {
    boolean bool;
    String str1;
    String str2;
    String str3;
    if (!ConnectionPool.class.desiredAssertionStatus())
    {
      bool = true;
      $assertionsDisabled = bool;
      str1 = System.getProperty("http.keepAlive");
      str2 = System.getProperty("http.keepAliveDuration");
      str3 = System.getProperty("http.maxConnections");
      if (str2 == null) {
        break label74;
      }
    }
    label74:
    for (long l = Long.parseLong(str2);; l = 300000L)
    {
      if ((str1 == null) || (Boolean.parseBoolean(str1))) {
        break label81;
      }
      systemDefault = new ConnectionPool(0, l);
      return;
      bool = false;
      break;
    }
    label81:
    if (str3 != null)
    {
      systemDefault = new ConnectionPool(Integer.parseInt(str3), l);
      return;
    }
    systemDefault = new ConnectionPool(5, l);
  }
  
  public ConnectionPool(int paramInt, long paramLong)
  {
    this(paramInt, paramLong, TimeUnit.MILLISECONDS);
  }
  
  public ConnectionPool(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    this.maxIdleConnections = paramInt;
    this.keepAliveDurationNs = paramTimeUnit.toNanos(paramLong);
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("keepAliveDuration <= 0: " + paramLong);
    }
  }
  
  public static ConnectionPool getDefault()
  {
    return systemDefault;
  }
  
  private int pruneAndGetAllocationCount(RealConnection paramRealConnection, long paramLong)
  {
    List localList = paramRealConnection.allocations;
    int i = 0;
    while (i < localList.size()) {
      if (((Reference)localList.get(i)).get() != null)
      {
        i += 1;
      }
      else
      {
        Internal.logger.warning("A connection to " + paramRealConnection.getRoute().getAddress().url() + " was leaked. Did you forget to close a response body?");
        localList.remove(i);
        paramRealConnection.noNewStreams = true;
        if (localList.isEmpty())
        {
          paramRealConnection.idleAtNanos = (paramLong - this.keepAliveDurationNs);
          return 0;
        }
      }
    }
    return localList.size();
  }
  
  long cleanup(long paramLong)
  {
    int j = 0;
    int i = 0;
    Object localObject1 = null;
    long l1 = -9223372036854775808L;
    try
    {
      Iterator localIterator = this.connections.iterator();
      while (localIterator.hasNext())
      {
        RealConnection localRealConnection = (RealConnection)localIterator.next();
        if (pruneAndGetAllocationCount(localRealConnection, paramLong) > 0)
        {
          j += 1;
        }
        else
        {
          int k = i + 1;
          long l2 = paramLong - localRealConnection.idleAtNanos;
          i = k;
          if (l2 > l1)
          {
            l1 = l2;
            localObject1 = localRealConnection;
            i = k;
          }
        }
      }
      if ((l1 >= this.keepAliveDurationNs) || (i > this.maxIdleConnections))
      {
        this.connections.remove(localObject1);
        Util.closeQuietly(localObject1.getSocket());
        return 0L;
      }
      if (i > 0)
      {
        paramLong = this.keepAliveDurationNs;
        return paramLong - l1;
      }
    }
    finally {}
    if (j > 0)
    {
      paramLong = this.keepAliveDurationNs;
      return paramLong;
    }
    return -1L;
  }
  
  boolean connectionBecameIdle(RealConnection paramRealConnection)
  {
    assert (Thread.holdsLock(this));
    if ((paramRealConnection.noNewStreams) || (this.maxIdleConnections == 0))
    {
      this.connections.remove(paramRealConnection);
      return true;
    }
    notifyAll();
    return false;
  }
  
  public void evictAll()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator2 = this.connections.iterator();
      while (localIterator2.hasNext())
      {
        RealConnection localRealConnection = (RealConnection)localIterator2.next();
        if (localRealConnection.allocations.isEmpty())
        {
          localRealConnection.noNewStreams = true;
          localArrayList.add(localRealConnection);
          localIterator2.remove();
        }
      }
    }
    finally {}
    Iterator localIterator1 = localObject.iterator();
    while (localIterator1.hasNext()) {
      Util.closeQuietly(((RealConnection)localIterator1.next()).getSocket());
    }
  }
  
  RealConnection get(Address paramAddress, StreamAllocation paramStreamAllocation)
  {
    assert (Thread.holdsLock(this));
    Iterator localIterator = this.connections.iterator();
    while (localIterator.hasNext())
    {
      RealConnection localRealConnection = (RealConnection)localIterator.next();
      if ((localRealConnection.allocations.size() < localRealConnection.allocationLimit()) && (paramAddress.equals(localRealConnection.getRoute().address)) && (!localRealConnection.noNewStreams))
      {
        paramStreamAllocation.acquire(localRealConnection);
        return localRealConnection;
      }
    }
    return null;
  }
  
  public int getConnectionCount()
  {
    try
    {
      int i = this.connections.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getHttpConnectionCount()
  {
    try
    {
      int i = this.connections.size();
      int j = getMultiplexedConnectionCount();
      return i - j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getIdleConnectionCount()
  {
    int i = 0;
    try
    {
      Iterator localIterator = this.connections.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((RealConnection)localIterator.next()).allocations.isEmpty();
        if (bool) {
          i += 1;
        }
      }
      return i;
    }
    finally {}
  }
  
  public int getMultiplexedConnectionCount()
  {
    int i = 0;
    try
    {
      Iterator localIterator = this.connections.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = ((RealConnection)localIterator.next()).isMultiplexed();
        if (bool) {
          i += 1;
        }
      }
      return i;
    }
    finally {}
  }
  
  @Deprecated
  public int getSpdyConnectionCount()
  {
    try
    {
      int i = getMultiplexedConnectionCount();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void put(RealConnection paramRealConnection)
  {
    assert (Thread.holdsLock(this));
    if (this.connections.isEmpty()) {
      this.executor.execute(this.cleanupRunnable);
    }
    this.connections.add(paramRealConnection);
  }
  
  void setCleanupRunnableForTest(Runnable paramRunnable)
  {
    this.cleanupRunnable = paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.ConnectionPool
 * JD-Core Version:    0.7.0.1
 */