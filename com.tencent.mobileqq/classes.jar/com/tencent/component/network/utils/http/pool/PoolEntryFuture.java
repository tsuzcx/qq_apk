package com.tencent.component.network.utils.http.pool;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

abstract class PoolEntryFuture<T>
  implements Future<T>
{
  private final FutureCallback<T> callback;
  private volatile boolean cancelled;
  private volatile boolean completed;
  private final Condition condition;
  private final Lock lock;
  private T result;
  
  PoolEntryFuture(Lock paramLock, FutureCallback<T> paramFutureCallback)
  {
    this.lock = paramLock;
    this.condition = paramLock.newCondition();
    this.callback = paramFutureCallback;
  }
  
  public boolean await(Date paramDate)
  {
    this.lock.lock();
    try
    {
      boolean bool1 = this.cancelled;
      if (!bool1)
      {
        if (paramDate != null)
        {
          bool1 = this.condition.awaitUntil(paramDate);
        }
        else
        {
          this.condition.await();
          bool1 = true;
        }
        boolean bool2 = this.cancelled;
        if (!bool2) {
          return bool1;
        }
        throw new InterruptedException("Operation interrupted");
      }
      throw new InterruptedException("Operation interrupted");
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    this.lock.lock();
    try
    {
      paramBoolean = this.completed;
      if (paramBoolean) {
        paramBoolean = false;
      }
      for (;;)
      {
        this.lock.unlock();
        return paramBoolean;
        paramBoolean = true;
        this.completed = true;
        this.cancelled = true;
        if (this.callback != null) {
          this.callback.cancelled();
        }
        this.condition.signalAll();
      }
      throw localObject;
    }
    finally
    {
      this.lock.unlock();
    }
    for (;;) {}
  }
  
  public T get()
  {
    try
    {
      Object localObject = get(0L, TimeUnit.MILLISECONDS);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      throw new ExecutionException(localTimeoutException);
    }
  }
  
  /* Error */
  public T get(long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/tencent/component/network/utils/http/pool/PoolEntryFuture:lock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 44 1 0
    //   9: aload_0
    //   10: getfield 67	com/tencent/component/network/utils/http/pool/PoolEntryFuture:completed	Z
    //   13: ifeq +19 -> 32
    //   16: aload_0
    //   17: getfield 97	com/tencent/component/network/utils/http/pool/PoolEntryFuture:result	Ljava/lang/Object;
    //   20: astore_3
    //   21: aload_0
    //   22: getfield 27	com/tencent/component/network/utils/http/pool/PoolEntryFuture:lock	Ljava/util/concurrent/locks/Lock;
    //   25: invokeinterface 56 1 0
    //   30: aload_3
    //   31: areturn
    //   32: aload_0
    //   33: aload_0
    //   34: lload_1
    //   35: aload_3
    //   36: invokevirtual 100	com/tencent/component/network/utils/http/pool/PoolEntryFuture:getPoolEntry	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   39: putfield 97	com/tencent/component/network/utils/http/pool/PoolEntryFuture:result	Ljava/lang/Object;
    //   42: aload_0
    //   43: iconst_1
    //   44: putfield 67	com/tencent/component/network/utils/http/pool/PoolEntryFuture:completed	Z
    //   47: aload_0
    //   48: getfield 37	com/tencent/component/network/utils/http/pool/PoolEntryFuture:callback	Lcom/tencent/component/network/utils/http/pool/FutureCallback;
    //   51: ifnull +16 -> 67
    //   54: aload_0
    //   55: getfield 37	com/tencent/component/network/utils/http/pool/PoolEntryFuture:callback	Lcom/tencent/component/network/utils/http/pool/FutureCallback;
    //   58: aload_0
    //   59: getfield 97	com/tencent/component/network/utils/http/pool/PoolEntryFuture:result	Ljava/lang/Object;
    //   62: invokeinterface 103 2 0
    //   67: aload_0
    //   68: getfield 97	com/tencent/component/network/utils/http/pool/PoolEntryFuture:result	Ljava/lang/Object;
    //   71: astore_3
    //   72: goto -51 -> 21
    //   75: astore_3
    //   76: goto +40 -> 116
    //   79: astore_3
    //   80: aload_0
    //   81: iconst_1
    //   82: putfield 67	com/tencent/component/network/utils/http/pool/PoolEntryFuture:completed	Z
    //   85: aload_0
    //   86: aconst_null
    //   87: putfield 97	com/tencent/component/network/utils/http/pool/PoolEntryFuture:result	Ljava/lang/Object;
    //   90: aload_0
    //   91: getfield 37	com/tencent/component/network/utils/http/pool/PoolEntryFuture:callback	Lcom/tencent/component/network/utils/http/pool/FutureCallback;
    //   94: ifnull +13 -> 107
    //   97: aload_0
    //   98: getfield 37	com/tencent/component/network/utils/http/pool/PoolEntryFuture:callback	Lcom/tencent/component/network/utils/http/pool/FutureCallback;
    //   101: aload_3
    //   102: invokeinterface 107 2 0
    //   107: new 89	java/util/concurrent/ExecutionException
    //   110: dup
    //   111: aload_3
    //   112: invokespecial 92	java/util/concurrent/ExecutionException:<init>	(Ljava/lang/Throwable;)V
    //   115: athrow
    //   116: aload_0
    //   117: getfield 27	com/tencent/component/network/utils/http/pool/PoolEntryFuture:lock	Ljava/util/concurrent/locks/Lock;
    //   120: invokeinterface 56 1 0
    //   125: goto +5 -> 130
    //   128: aload_3
    //   129: athrow
    //   130: goto -2 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	PoolEntryFuture
    //   0	133	1	paramLong	long
    //   0	133	3	paramTimeUnit	TimeUnit
    // Exception table:
    //   from	to	target	type
    //   9	21	75	finally
    //   32	67	75	finally
    //   67	72	75	finally
    //   80	107	75	finally
    //   107	116	75	finally
    //   9	21	79	java/io/IOException
    //   32	67	79	java/io/IOException
    //   67	72	79	java/io/IOException
  }
  
  protected abstract T getPoolEntry(long paramLong, TimeUnit paramTimeUnit);
  
  public boolean isCancelled()
  {
    return this.cancelled;
  }
  
  public boolean isDone()
  {
    return this.completed;
  }
  
  public void wakeup()
  {
    this.lock.lock();
    try
    {
      this.condition.signalAll();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.PoolEntryFuture
 * JD-Core Version:    0.7.0.1
 */