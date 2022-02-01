package com.tencent.beacon.core.network.volley;

import android.os.SystemClock;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFuture<T>
  implements Response.ErrorListener, Response.Listener<T>, Future<T>
{
  private VolleyError mException;
  private Request<?> mRequest;
  private T mResult;
  private boolean mResultReceived = false;
  
  private T doGet(Long paramLong)
  {
    VolleyError localVolleyError;
    for (;;)
    {
      try
      {
        localVolleyError = this.mException;
        if (localVolleyError != null) {
          break label144;
        }
        if (this.mResultReceived)
        {
          paramLong = this.mResult;
          return paramLong;
        }
        if (paramLong == null)
        {
          if (isDone()) {
            break label103;
          }
          wait(0L);
          continue;
        }
        if (paramLong.longValue() <= 0L) {
          break label103;
        }
      }
      finally {}
      long l1 = SystemClock.uptimeMillis();
      long l2 = paramLong.longValue() + l1;
      while ((!isDone()) && (l1 < l2))
      {
        wait(l2 - l1);
        l1 = SystemClock.uptimeMillis();
      }
      label103:
      paramLong = this.mException;
      if (paramLong != null) {
        break label135;
      }
      if (!this.mResultReceived) {
        break;
      }
      paramLong = this.mResult;
    }
    throw new TimeoutException();
    label135:
    throw new ExecutionException(paramLong);
    label144:
    throw new ExecutionException(localVolleyError);
  }
  
  public static <E> RequestFuture<E> newFuture()
  {
    return new RequestFuture();
  }
  
  /* Error */
  public boolean cancel(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 71	com/tencent/beacon/core/network/volley/RequestFuture:mRequest	Lcom/tencent/beacon/core/network/volley/Request;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: invokevirtual 38	com/tencent/beacon/core/network/volley/RequestFuture:isDone	()Z
    //   21: ifne -8 -> 13
    //   24: aload_0
    //   25: getfield 71	com/tencent/beacon/core/network/volley/RequestFuture:mRequest	Lcom/tencent/beacon/core/network/volley/Request;
    //   28: invokevirtual 75	com/tencent/beacon/core/network/volley/Request:cancel	()V
    //   31: iconst_1
    //   32: istore_1
    //   33: goto -20 -> 13
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	RequestFuture
    //   0	41	1	paramBoolean	boolean
    //   8	2	2	localRequest	Request
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	36	finally
    //   17	31	36	finally
  }
  
  public T get()
  {
    try
    {
      Object localObject = doGet(null);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      throw new AssertionError(localTimeoutException);
    }
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
  {
    return doGet(Long.valueOf(TimeUnit.MILLISECONDS.convert(paramLong, paramTimeUnit)));
  }
  
  public boolean isCancelled()
  {
    Request localRequest = this.mRequest;
    if (localRequest == null) {
      return false;
    }
    return localRequest.isCanceled();
  }
  
  /* Error */
  public boolean isDone()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/beacon/core/network/volley/RequestFuture:mResultReceived	Z
    //   6: ifne +19 -> 25
    //   9: aload_0
    //   10: getfield 32	com/tencent/beacon/core/network/volley/RequestFuture:mException	Lcom/tencent/beacon/core/network/volley/VolleyError;
    //   13: ifnonnull +12 -> 25
    //   16: aload_0
    //   17: invokevirtual 107	com/tencent/beacon/core/network/volley/RequestFuture:isCancelled	()Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifeq +9 -> 31
    //   25: iconst_1
    //   26: istore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_1
    //   30: ireturn
    //   31: iconst_0
    //   32: istore_1
    //   33: goto -6 -> 27
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	RequestFuture
    //   20	13	1	bool	boolean
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	36	finally
  }
  
  public void onErrorResponse(VolleyError paramVolleyError)
  {
    try
    {
      this.mException = paramVolleyError;
      notifyAll();
      return;
    }
    finally
    {
      paramVolleyError = finally;
      throw paramVolleyError;
    }
  }
  
  public void onResponse(T paramT)
  {
    try
    {
      this.mResultReceived = true;
      this.mResult = paramT;
      notifyAll();
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public void setRequest(Request<?> paramRequest)
  {
    this.mRequest = paramRequest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.RequestFuture
 * JD-Core Version:    0.7.0.1
 */