package com.tencent.mobileqq.app;

import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import zas;

public class BoundedPriorityBlockingQueue
  extends AbstractQueue
  implements BlockingQueue
{
  private int jdField_a_of_type_Int;
  private final Comparator jdField_a_of_type_JavaUtilComparator;
  private final Condition jdField_a_of_type_JavaUtilConcurrentLocksCondition;
  private final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  private final Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  private final Condition b;
  
  private int a(Object paramObject)
  {
    if (paramObject != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_Int)
      {
        if (paramObject.equals(this.jdField_a_of_type_ArrayOfJavaLangObject[i])) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  private Object a()
  {
    Object localObject = b();
    if (localObject != null) {
      this.b.signal();
    }
    return localObject;
  }
  
  private void a(int paramInt)
  {
    int i = this.jdField_a_of_type_Int - 1;
    if (i == paramInt) {
      this.jdField_a_of_type_ArrayOfJavaLangObject[paramInt] = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int -= 1;
      this.b.signal();
      return;
      Object localObject = this.jdField_a_of_type_ArrayOfJavaLangObject[i];
      this.jdField_a_of_type_ArrayOfJavaLangObject[i] = null;
      a(paramInt, localObject, this.jdField_a_of_type_ArrayOfJavaLangObject, i, this.jdField_a_of_type_JavaUtilComparator);
      if (this.jdField_a_of_type_ArrayOfJavaLangObject[paramInt] == localObject) {
        a(paramInt, localObject, this.jdField_a_of_type_ArrayOfJavaLangObject, this.jdField_a_of_type_JavaUtilComparator);
      }
    }
  }
  
  private static void a(int paramInt1, Object paramObject, Object[] paramArrayOfObject, int paramInt2, Comparator paramComparator)
  {
    int j;
    Comparable localComparable;
    label16:
    int k;
    label19:
    int i;
    Object localObject;
    int m;
    if (paramComparator != null)
    {
      j = 1;
      if (j == 0) {
        break label126;
      }
      localComparable = null;
      k = paramInt1;
      if (k < paramInt2 >>> 1)
      {
        i = (k << 1) + 1;
        localObject = paramArrayOfObject[i];
        m = i + 1;
        if (m >= paramInt2) {
          break label207;
        }
        if (j == 0) {
          break label140;
        }
        if (paramComparator.compare(localObject, paramArrayOfObject[m]) <= 0) {
          break label135;
        }
        paramInt1 = 1;
        label76:
        if (paramInt1 == 0) {
          break label207;
        }
        localObject = paramArrayOfObject[m];
        i = m;
      }
    }
    label135:
    label140:
    label194:
    label207:
    for (;;)
    {
      if (j != 0) {
        if (paramComparator.compare(paramObject, localObject) <= 0) {
          paramInt1 = 1;
        }
      }
      for (;;)
      {
        if (paramInt1 == 0) {
          break label194;
        }
        paramArrayOfObject[k] = paramObject;
        return;
        j = 0;
        break;
        label126:
        localComparable = (Comparable)paramObject;
        break label16;
        paramInt1 = 0;
        break label76;
        if (((Comparable)localObject).compareTo(paramArrayOfObject[m]) > 0)
        {
          paramInt1 = 1;
          break label76;
        }
        paramInt1 = 0;
        break label76;
        paramInt1 = 0;
        continue;
        if (localComparable.compareTo(localObject) <= 0) {
          paramInt1 = 1;
        } else {
          paramInt1 = 0;
        }
      }
      paramArrayOfObject[k] = localObject;
      k = i;
      break label19;
    }
  }
  
  private static void a(int paramInt, Object paramObject, Object[] paramArrayOfObject, Comparator paramComparator)
  {
    int i;
    Comparable localComparable;
    int j;
    if (paramComparator != null)
    {
      i = 1;
      if (i == 0) {
        break label72;
      }
      localComparable = null;
      j = paramInt;
    }
    for (;;)
    {
      label18:
      int k;
      Object localObject;
      if (j > 0)
      {
        k = j - 1 >>> 1;
        localObject = paramArrayOfObject[k];
        if (i == 0) {
          break label89;
        }
        if (paramComparator.compare(paramObject, localObject) < 0) {
          break label84;
        }
        paramInt = 1;
      }
      for (;;)
      {
        if (paramInt == 0) {
          break label111;
        }
        paramArrayOfObject[j] = paramObject;
        return;
        i = 0;
        break;
        label72:
        localComparable = (Comparable)paramObject;
        j = paramInt;
        break label18;
        label84:
        paramInt = 0;
        continue;
        label89:
        if (localComparable.compareTo(localObject) >= 0) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
      }
      label111:
      paramArrayOfObject[j] = localObject;
      j = k;
    }
  }
  
  private static void a(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
  }
  
  private static void a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      throw new IllegalArgumentException("Not allowed due to same object");
    }
  }
  
  private Object b()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      int i = this.jdField_a_of_type_Int - 1;
      Object localObject1 = this.jdField_a_of_type_ArrayOfJavaLangObject[0];
      Object localObject2 = this.jdField_a_of_type_ArrayOfJavaLangObject[i];
      this.jdField_a_of_type_ArrayOfJavaLangObject[i] = null;
      a(0, localObject2, this.jdField_a_of_type_ArrayOfJavaLangObject, i, this.jdField_a_of_type_JavaUtilComparator);
      this.jdField_a_of_type_Int -= 1;
      return localObject1;
    }
    return null;
  }
  
  private void b(Object paramObject)
  {
    a(this.jdField_a_of_type_Int, paramObject, this.jdField_a_of_type_ArrayOfJavaLangObject, this.jdField_a_of_type_JavaUtilComparator);
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_JavaUtilConcurrentLocksCondition.signal();
  }
  
  public boolean add(Object paramObject)
  {
    return super.add(paramObject);
  }
  
  public void clear()
  {
    int i = 0;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      while (i < this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_ArrayOfJavaLangObject[i] = null;
        i += 1;
      }
      this.jdField_a_of_type_Int = 0;
      this.b.signalAll();
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  /* Error */
  public boolean contains(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 89	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 98	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:a	(Ljava/lang/Object;)I
    //   12: istore_2
    //   13: iload_2
    //   14: iconst_m1
    //   15: if_icmpeq +14 -> 29
    //   18: iconst_1
    //   19: istore_3
    //   20: aload_0
    //   21: getfield 40	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   24: invokevirtual 95	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   27: iload_3
    //   28: ireturn
    //   29: iconst_0
    //   30: istore_3
    //   31: goto -11 -> 20
    //   34: astore_1
    //   35: aload_0
    //   36: getfield 40	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   39: invokevirtual 95	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	BoundedPriorityBlockingQueue
    //   0	44	1	paramObject	Object
    //   12	4	2	i	int
    //   19	12	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	13	34	finally
  }
  
  public int drainTo(Collection paramCollection)
  {
    a(paramCollection);
    a(paramCollection, this);
    int i = 0;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      for (Object localObject = b(); localObject != null; localObject = b())
      {
        paramCollection.add(localObject);
        i += 1;
      }
      if (i > 0) {
        this.b.signalAll();
      }
      return i;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  public int drainTo(Collection paramCollection, int paramInt)
  {
    a(paramCollection);
    a(paramCollection, this);
    int i = 0;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    for (;;)
    {
      if (i < paramInt) {}
      try
      {
        Object localObject = b();
        if (localObject != null)
        {
          paramCollection.add(localObject);
          i += 1;
          continue;
        }
        if (i > 0) {
          this.b.signalAll();
        }
        return i;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
    }
  }
  
  public Iterator iterator()
  {
    return new zas(this, toArray());
  }
  
  public boolean offer(Object paramObject)
  {
    a(paramObject);
    boolean bool = false;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      if (this.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfJavaLangObject.length)
      {
        b(paramObject);
        bool = true;
      }
      return bool;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  /* Error */
  public boolean offer(Object paramObject, long paramLong, java.util.concurrent.TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 102	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:a	(Ljava/lang/Object;)V
    //   4: aload 4
    //   6: lload_2
    //   7: invokevirtual 131	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   10: lstore_2
    //   11: aload_0
    //   12: getfield 40	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   15: invokevirtual 134	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
    //   18: aload_0
    //   19: getfield 16	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_Int	I
    //   22: aload_0
    //   23: getfield 20	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   26: arraylength
    //   27: if_icmpge +17 -> 44
    //   30: aload_0
    //   31: aload_1
    //   32: invokespecial 122	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:b	(Ljava/lang/Object;)V
    //   35: aload_0
    //   36: getfield 40	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   39: invokevirtual 95	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: iconst_1
    //   43: ireturn
    //   44: lload_2
    //   45: lconst_0
    //   46: lcmp
    //   47: ifgt +12 -> 59
    //   50: aload_0
    //   51: getfield 40	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   54: invokevirtual 95	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   57: iconst_0
    //   58: ireturn
    //   59: aload_0
    //   60: getfield 31	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:b	Ljava/util/concurrent/locks/Condition;
    //   63: lload_2
    //   64: invokeinterface 137 3 0
    //   69: lstore_2
    //   70: goto -52 -> 18
    //   73: astore_1
    //   74: aload_0
    //   75: getfield 31	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:b	Ljava/util/concurrent/locks/Condition;
    //   78: invokeinterface 37 1 0
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: aload_0
    //   87: getfield 40	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   90: invokevirtual 95	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	BoundedPriorityBlockingQueue
    //   0	95	1	paramObject	Object
    //   0	95	2	paramLong	long
    //   0	95	4	paramTimeUnit	java.util.concurrent.TimeUnit
    // Exception table:
    //   from	to	target	type
    //   59	70	73	java/lang/InterruptedException
    //   18	35	85	finally
    //   59	70	85	finally
    //   74	85	85	finally
  }
  
  /* Error */
  public Object peek()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 89	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 16	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_Int	I
    //   11: ifle +19 -> 30
    //   14: aload_0
    //   15: getfield 20	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   18: iconst_0
    //   19: aaload
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 40	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   25: invokevirtual 95	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   28: aload_1
    //   29: areturn
    //   30: aconst_null
    //   31: astore_1
    //   32: goto -11 -> 21
    //   35: astore_1
    //   36: aload_0
    //   37: getfield 40	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   40: invokevirtual 95	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	BoundedPriorityBlockingQueue
    //   20	12	1	localObject1	Object
    //   35	9	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	21	35	finally
  }
  
  public Object poll()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      Object localObject1 = a();
      return localObject1;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  /* Error */
  public Object poll(long paramLong, java.util.concurrent.TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_3
    //   1: lload_1
    //   2: invokevirtual 131	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   5: lstore_1
    //   6: aload_0
    //   7: getfield 40	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   10: invokevirtual 134	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
    //   13: aload_0
    //   14: getfield 16	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_Int	I
    //   17: ifle +17 -> 34
    //   20: aload_0
    //   21: invokespecial 141	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:a	()Ljava/lang/Object;
    //   24: astore_3
    //   25: aload_0
    //   26: getfield 40	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   29: invokevirtual 95	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   32: aload_3
    //   33: areturn
    //   34: lload_1
    //   35: lconst_0
    //   36: lcmp
    //   37: ifgt +12 -> 49
    //   40: aload_0
    //   41: getfield 40	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   44: invokevirtual 95	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   47: aconst_null
    //   48: areturn
    //   49: aload_0
    //   50: getfield 80	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_JavaUtilConcurrentLocksCondition	Ljava/util/concurrent/locks/Condition;
    //   53: lload_1
    //   54: invokeinterface 137 3 0
    //   59: lstore_1
    //   60: goto -47 -> 13
    //   63: astore_3
    //   64: aload_0
    //   65: getfield 80	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_JavaUtilConcurrentLocksCondition	Ljava/util/concurrent/locks/Condition;
    //   68: invokeinterface 37 1 0
    //   73: aload_3
    //   74: athrow
    //   75: astore_3
    //   76: aload_0
    //   77: getfield 40	com/tencent/mobileqq/app/BoundedPriorityBlockingQueue:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   80: invokevirtual 95	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   83: aload_3
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	BoundedPriorityBlockingQueue
    //   0	85	1	paramLong	long
    //   0	85	3	paramTimeUnit	java.util.concurrent.TimeUnit
    // Exception table:
    //   from	to	target	type
    //   49	60	63	java/lang/InterruptedException
    //   13	25	75	finally
    //   49	60	75	finally
    //   64	75	75	finally
  }
  
  public void put(Object paramObject)
  {
    a(paramObject);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lockInterruptibly();
    try
    {
      while (this.jdField_a_of_type_Int == this.jdField_a_of_type_ArrayOfJavaLangObject.length) {
        this.b.await();
      }
      b(paramObject);
    }
    catch (InterruptedException paramObject)
    {
      this.b.signal();
      throw paramObject;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
  }
  
  public int remainingCapacity()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      int i = this.jdField_a_of_type_ArrayOfJavaLangObject.length;
      int j = this.jdField_a_of_type_Int;
      return i - j;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  public boolean remove(Object paramObject)
  {
    boolean bool = false;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      int i = a(paramObject);
      if (i != -1)
      {
        a(i);
        bool = true;
      }
      return bool;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  public int size()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      int i = this.jdField_a_of_type_Int;
      return i;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  public Object take()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lockInterruptibly();
    try
    {
      while (this.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_JavaUtilConcurrentLocksCondition.await();
      }
      localObject2 = a();
    }
    catch (InterruptedException localInterruptedException)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksCondition.signal();
      throw localInterruptedException;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    Object localObject2;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    return localObject2;
  }
  
  public Object[] toArray()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      if (this.jdField_a_of_type_ArrayOfJavaLangObject == null) {
        throw new NullPointerException("myQueue == null");
      }
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    if (this.jdField_a_of_type_Int < 0) {
      throw new NegativeArraySizeException(Integer.toString(this.jdField_a_of_type_Int));
    }
    int j = this.jdField_a_of_type_ArrayOfJavaLangObject.length;
    if (j < 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    int i = this.jdField_a_of_type_Int + 0;
    j = Math.min(i, j + 0);
    Object[] arrayOfObject = (Object[])Array.newInstance(this.jdField_a_of_type_ArrayOfJavaLangObject.getClass().getComponentType(), i);
    System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, 0, arrayOfObject, 0, j);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    return arrayOfObject;
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      if (paramArrayOfObject.length >= this.jdField_a_of_type_Int) {
        break label119;
      }
      if (this.jdField_a_of_type_Int < 0) {
        throw new NegativeArraySizeException(Integer.toString(this.jdField_a_of_type_Int));
      }
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    int j = this.jdField_a_of_type_ArrayOfJavaLangObject.length;
    if (j < 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    int i = this.jdField_a_of_type_Int + 0;
    j = Math.min(i, j + 0);
    paramArrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), i);
    System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, 0, paramArrayOfObject, 0, j);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    return paramArrayOfObject;
    label119:
    System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, 0, paramArrayOfObject, 0, this.jdField_a_of_type_Int);
    if (paramArrayOfObject.length > this.jdField_a_of_type_Int) {
      paramArrayOfObject[this.jdField_a_of_type_Int] = null;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    return paramArrayOfObject;
  }
  
  public String toString()
  {
    return Arrays.toString(toArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BoundedPriorityBlockingQueue
 * JD-Core Version:    0.7.0.1
 */