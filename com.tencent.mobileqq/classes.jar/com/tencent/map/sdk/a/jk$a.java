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
  
  /* Error */
  public final int drainTo(Collection<? super E> paramCollection, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: iconst_0
    //   7: istore_3
    //   8: aload_1
    //   9: ifnonnull +11 -> 20
    //   12: new 92	java/lang/NullPointerException
    //   15: dup
    //   16: invokespecial 93	java/lang/NullPointerException:<init>	()V
    //   19: athrow
    //   20: aload_1
    //   21: aload_0
    //   22: if_acmpne +11 -> 33
    //   25: new 95	java/lang/IllegalArgumentException
    //   28: dup
    //   29: invokespecial 96	java/lang/IllegalArgumentException:<init>	()V
    //   32: athrow
    //   33: iload_2
    //   34: ifgt +5 -> 39
    //   37: iconst_0
    //   38: ireturn
    //   39: aload_0
    //   40: getfield 41	com/tencent/map/sdk/a/jk$a:f	Ljava/util/concurrent/locks/ReentrantLock;
    //   43: astore 9
    //   45: aload 9
    //   47: invokevirtual 70	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   50: iload_2
    //   51: aload_0
    //   52: getfield 36	com/tencent/map/sdk/a/jk$a:b	Ljava/util/concurrent/atomic/AtomicInteger;
    //   55: invokevirtual 100	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   58: invokestatic 106	java/lang/Math:min	(II)I
    //   61: istore 6
    //   63: aload_0
    //   64: getfield 60	com/tencent/map/sdk/a/jk$a:c	Lcom/tencent/map/sdk/a/jk$a$b;
    //   67: astore 7
    //   69: iconst_0
    //   70: istore_2
    //   71: iload_2
    //   72: iload 6
    //   74: if_icmpge +46 -> 120
    //   77: aload 7
    //   79: getfield 64	com/tencent/map/sdk/a/jk$a$b:b	Lcom/tencent/map/sdk/a/jk$a$b;
    //   82: astore 8
    //   84: aload_1
    //   85: aload 8
    //   87: getfield 74	com/tencent/map/sdk/a/jk$a$b:a	Ljava/lang/Object;
    //   90: invokeinterface 112 2 0
    //   95: pop
    //   96: aload 8
    //   98: aconst_null
    //   99: putfield 74	com/tencent/map/sdk/a/jk$a$b:a	Ljava/lang/Object;
    //   102: aload 7
    //   104: aload 7
    //   106: putfield 64	com/tencent/map/sdk/a/jk$a$b:b	Lcom/tencent/map/sdk/a/jk$a$b;
    //   109: iload_2
    //   110: iconst_1
    //   111: iadd
    //   112: istore_2
    //   113: aload 8
    //   115: astore 7
    //   117: goto -46 -> 71
    //   120: iload_2
    //   121: ifle +125 -> 246
    //   124: aload_0
    //   125: aload 7
    //   127: putfield 60	com/tencent/map/sdk/a/jk$a:c	Lcom/tencent/map/sdk/a/jk$a$b;
    //   130: aload_0
    //   131: getfield 36	com/tencent/map/sdk/a/jk$a:b	Ljava/util/concurrent/atomic/AtomicInteger;
    //   134: iload_2
    //   135: ineg
    //   136: invokevirtual 116	java/util/concurrent/atomic/AtomicInteger:getAndAdd	(I)I
    //   139: istore_2
    //   140: aload_0
    //   141: getfield 53	com/tencent/map/sdk/a/jk$a:a	I
    //   144: istore 5
    //   146: iload_2
    //   147: iload 5
    //   149: if_icmpne +22 -> 171
    //   152: iload 4
    //   154: istore_2
    //   155: aload 9
    //   157: invokevirtual 83	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   160: iload_2
    //   161: ifeq +7 -> 168
    //   164: aload_0
    //   165: invokespecial 118	com/tencent/map/sdk/a/jk$a:c	()V
    //   168: iload 6
    //   170: ireturn
    //   171: iconst_0
    //   172: istore_2
    //   173: goto -18 -> 155
    //   176: astore_1
    //   177: iload_2
    //   178: ifle +63 -> 241
    //   181: aload_0
    //   182: aload 7
    //   184: putfield 60	com/tencent/map/sdk/a/jk$a:c	Lcom/tencent/map/sdk/a/jk$a$b;
    //   187: aload_0
    //   188: getfield 36	com/tencent/map/sdk/a/jk$a:b	Ljava/util/concurrent/atomic/AtomicInteger;
    //   191: iload_2
    //   192: ineg
    //   193: invokevirtual 116	java/util/concurrent/atomic/AtomicInteger:getAndAdd	(I)I
    //   196: istore_2
    //   197: aload_0
    //   198: getfield 53	com/tencent/map/sdk/a/jk$a:a	I
    //   201: istore 4
    //   203: iload_2
    //   204: iload 4
    //   206: if_icmpne +24 -> 230
    //   209: iload 5
    //   211: istore_2
    //   212: aload_1
    //   213: athrow
    //   214: astore_1
    //   215: aload 9
    //   217: invokevirtual 83	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   220: iload_2
    //   221: ifeq +7 -> 228
    //   224: aload_0
    //   225: invokespecial 118	com/tencent/map/sdk/a/jk$a:c	()V
    //   228: aload_1
    //   229: athrow
    //   230: iconst_0
    //   231: istore_2
    //   232: goto -20 -> 212
    //   235: astore_1
    //   236: iload_3
    //   237: istore_2
    //   238: goto -23 -> 215
    //   241: iconst_0
    //   242: istore_2
    //   243: goto -31 -> 212
    //   246: iconst_0
    //   247: istore_2
    //   248: goto -93 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	a
    //   0	251	1	paramCollection	Collection<? super E>
    //   0	251	2	paramInt	int
    //   7	230	3	i	int
    //   4	203	4	j	int
    //   1	209	5	k	int
    //   61	108	6	m	int
    //   67	116	7	localObject	Object
    //   82	32	8	localb	jk.a.b
    //   43	173	9	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   77	109	176	finally
    //   212	214	214	finally
    //   50	69	235	finally
    //   124	146	235	finally
    //   181	203	235	finally
  }
  
  public final Iterator<E> iterator()
  {
    return new jk.a.a(this);
  }
  
  public final boolean offer(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
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
      if (i >= 0) {
        return true;
      }
    }
    finally
    {
      paramE.unlock();
    }
    return false;
  }
  
  public final boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
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
    Object localObject1 = null;
    Object localObject3 = null;
    AtomicInteger localAtomicInteger = this.b;
    if (localAtomicInteger.get() == 0) {}
    for (;;)
    {
      return localObject3;
      int i = -1;
      ReentrantLock localReentrantLock = this.f;
      localReentrantLock.lock();
      try
      {
        if (localAtomicInteger.get() > 0)
        {
          localObject3 = b();
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
        localObject3 = localObject1;
        if (i != this.a) {
          continue;
        }
        c();
        return localObject1;
      }
      finally
      {
        localReentrantLock.unlock();
      }
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
      int i = localAtomicInteger.get();
      if (i == 0) {
        if (paramLong <= 0L)
        {
          paramTimeUnit.unlock();
          paramTimeUnit = null;
        }
      }
      Object localObject1;
      do
      {
        return paramTimeUnit;
        paramLong = this.g.awaitNanos(paramLong);
        break;
        localObject1 = b();
        i = localAtomicInteger.getAndDecrement();
        if (i > 1) {
          this.g.signal();
        }
        paramTimeUnit.unlock();
        paramTimeUnit = localObject1;
      } while (i != this.a);
      c();
      return localObject1;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public final void put(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    jk.a.b localb1 = new jk.a.b(this, paramE);
    paramE = this.h;
    AtomicInteger localAtomicInteger = this.b;
    paramE.lockInterruptibly();
    try
    {
      while (localAtomicInteger.get() == this.a) {
        this.d.await();
      }
      a(localb2);
    }
    finally
    {
      paramE.unlock();
    }
    int i = localAtomicInteger.getAndIncrement();
    if (i + 1 < this.a) {
      this.d.signal();
    }
    paramE.unlock();
    if (i == 0) {
      d();
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
      localObject2 = b();
    }
    finally
    {
      localReentrantLock.unlock();
    }
    Object localObject2;
    int i = localObject1.getAndDecrement();
    if (i > 1) {
      this.g.signal();
    }
    localReentrantLock.unlock();
    if (i == this.a) {
      c();
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.jk.a
 * JD-Core Version:    0.7.0.1
 */