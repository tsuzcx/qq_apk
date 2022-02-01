package com.b.a.a;

import com.b.a.o.a;
import com.b.a.o.b;
import com.b.a.t;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class k<T>
  implements o.a, o.b<T>, Future<T>
{
  private boolean a = false;
  private T b;
  private t c;
  
  public static <E> k<E> a()
  {
    return new k();
  }
  
  private T a(Long paramLong)
  {
    try
    {
      if (this.c == null)
      {
        if (this.a)
        {
          paramLong = this.b;
          return paramLong;
        }
        long l = 0L;
        if (paramLong == null) {}
        for (;;)
        {
          wait(l);
          break;
          if (paramLong.longValue() <= 0L) {
            break;
          }
          l = paramLong.longValue();
        }
        if (this.c == null)
        {
          if (this.a)
          {
            paramLong = this.b;
            return paramLong;
          }
          throw new TimeoutException();
        }
        throw new ExecutionException(this.c);
      }
      throw new ExecutionException(this.c);
    }
    finally {}
    for (;;)
    {
      throw paramLong;
    }
  }
  
  public final void a(t paramt)
  {
    try
    {
      this.c = paramt;
      notifyAll();
      return;
    }
    finally
    {
      paramt = finally;
      throw paramt;
    }
  }
  
  public final void a(T paramT)
  {
    try
    {
      this.a = true;
      this.b = paramT;
      notifyAll();
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public final T get()
  {
    try
    {
      Object localObject = a(null);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      throw new AssertionError(localTimeoutException);
    }
  }
  
  public final T get(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(paramLong, paramTimeUnit)));
  }
  
  public final boolean isCancelled()
  {
    return false;
  }
  
  /* Error */
  public final boolean isDone()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/b/a/a/k:a	Z
    //   6: ifne +28 -> 34
    //   9: aload_0
    //   10: getfield 32	com/b/a/a/k:c	Lcom/b/a/t;
    //   13: ifnonnull +21 -> 34
    //   16: aload_0
    //   17: invokevirtual 91	com/b/a/a/k:isCancelled	()Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifeq +6 -> 28
    //   25: goto +9 -> 34
    //   28: iconst_0
    //   29: istore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: iload_1
    //   33: ireturn
    //   34: iconst_1
    //   35: istore_1
    //   36: goto -6 -> 30
    //   39: astore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: goto +5 -> 47
    //   45: aload_2
    //   46: athrow
    //   47: goto -2 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	k
    //   20	16	1	bool	boolean
    //   39	7	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	39	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.a.k
 * JD-Core Version:    0.7.0.1
 */