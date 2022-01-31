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
import pjm;
import pjn;
import pjo;
import pjp;

public abstract class AbstractConnPool
  implements ConnPool, ConnPoolControl
{
  private volatile int jdField_a_of_type_Int;
  private final ConnFactory jdField_a_of_type_ComTencentComponentNetworkUtilsHttpPoolConnFactory;
  private final LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private final Map jdField_a_of_type_JavaUtilMap;
  private final Set jdField_a_of_type_JavaUtilSet;
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int;
  private final LinkedList jdField_b_of_type_JavaUtilLinkedList;
  private final Map jdField_b_of_type_JavaUtilMap;
  
  public AbstractConnPool(ConnFactory paramConnFactory, int paramInt1, int paramInt2)
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
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
    this.jdField_a_of_type_ComTencentComponentNetworkUtilsHttpPoolConnFactory = paramConnFactory;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  private int a(Object paramObject)
  {
    paramObject = (Integer)this.jdField_b_of_type_JavaUtilMap.get(paramObject);
    if (paramObject != null) {
      return paramObject.intValue();
    }
    return this.jdField_a_of_type_Int;
  }
  
  private PoolEntry a(Object paramObject1, Object paramObject2, long paramLong, TimeUnit paramTimeUnit, pjo parampjo)
  {
    Date localDate = null;
    if (paramLong > 0L) {
      localDate = new Date(System.currentTimeMillis() + paramTimeUnit.toMillis(paramLong));
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      pjp localpjp;
      try
      {
        localpjp = a(paramObject1);
        paramTimeUnit = null;
        if (paramTimeUnit != null) {
          break label463;
        }
        if (this.jdField_a_of_type_Boolean) {
          throw new IllegalStateException("Connection pool shut down");
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      Object localObject;
      do
      {
        if ((!((PoolEntry)localObject).a()) && (!((PoolEntry)localObject).a(System.currentTimeMillis()))) {
          break;
        }
        ((PoolEntry)localObject).b();
        this.jdField_a_of_type_JavaUtilLinkedList.remove(localObject);
        localpjp.a((PoolEntry)localObject, false);
        localObject = localpjp.b(paramObject2);
      } while (localObject != null);
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(localObject);
        this.jdField_a_of_type_JavaUtilSet.add(localObject);
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        return localObject;
      }
      int j = a(paramObject1);
      int k = Math.max(0, localpjp.a() + 1 - j);
      int i;
      if (k > 0) {
        i = 0;
      }
      for (;;)
      {
        if (i < k)
        {
          paramTimeUnit = localpjp.a();
          if (paramTimeUnit != null) {}
        }
        else
        {
          if (localpjp.a() >= j) {
            break;
          }
          i = this.jdField_a_of_type_JavaUtilSet.size();
          i = Math.max(this.jdField_b_of_type_Int - i, 0);
          if (i <= 0) {
            break;
          }
          if ((this.jdField_a_of_type_JavaUtilLinkedList.size() > i - 1) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()))
          {
            paramObject2 = (PoolEntry)this.jdField_a_of_type_JavaUtilLinkedList.removeLast();
            paramObject2.b();
            a(paramObject2.a()).a(paramObject2);
          }
          paramObject1 = localpjp.c(this.jdField_a_of_type_ComTencentComponentNetworkUtilsHttpPoolConnFactory.a(paramObject1));
          this.jdField_a_of_type_JavaUtilSet.add(paramObject1);
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          return paramObject1;
        }
        paramTimeUnit.b();
        this.jdField_a_of_type_JavaUtilLinkedList.remove(paramTimeUnit);
        localpjp.a(paramTimeUnit);
        i += 1;
      }
      try
      {
        localpjp.a(parampjo);
        this.jdField_b_of_type_JavaUtilLinkedList.add(parampjo);
        boolean bool = parampjo.a(localDate);
        localpjp.b(parampjo);
        this.jdField_b_of_type_JavaUtilLinkedList.remove(parampjo);
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
        localpjp.b(parampjo);
        this.jdField_b_of_type_JavaUtilLinkedList.remove(parampjo);
      }
    }
  }
  
  private pjp a(Object paramObject)
  {
    pjp localpjp = (pjp)this.jdField_a_of_type_JavaUtilMap.get(paramObject);
    Object localObject = localpjp;
    if (localpjp == null)
    {
      localObject = new pjm(this, paramObject, paramObject);
      this.jdField_a_of_type_JavaUtilMap.put(paramObject, localObject);
    }
    return localObject;
  }
  
  private void a(pjp parampjp)
  {
    parampjp = parampjp.a();
    if (parampjp != null) {
      this.jdField_b_of_type_JavaUtilLinkedList.remove(parampjp);
    }
    for (;;)
    {
      if (parampjp != null) {
        parampjp.a();
      }
      return;
      parampjp = (pjo)this.jdField_b_of_type_JavaUtilLinkedList.poll();
    }
  }
  
  public abstract PoolEntry a(Object paramObject1, Object paramObject2);
  
  public Future a(Object paramObject1, Object paramObject2)
  {
    return a(paramObject1, paramObject2, null);
  }
  
  public Future a(Object paramObject1, Object paramObject2, FutureCallback paramFutureCallback)
  {
    if (paramObject1 == null) {
      throw new IllegalArgumentException("Route may not be null");
    }
    if (this.jdField_a_of_type_Boolean) {
      throw new IllegalStateException("Connection pool shut down");
    }
    return new pjn(this, this.jdField_a_of_type_JavaUtilConcurrentLocksLock, paramFutureCallback, paramObject1, paramObject2);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Iterator localIterator1 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator1.hasNext()) {
        ((PoolEntry)localIterator1.next()).b();
      }
      localIterator2 = this.jdField_a_of_type_JavaUtilSet.iterator();
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    while (localIterator2.hasNext()) {
      ((PoolEntry)localIterator2.next()).b();
    }
    Iterator localIterator2 = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator2.hasNext()) {
      ((pjp)localIterator2.next()).a();
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
  }
  
  public void a(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max value may not be negative or zero");
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_b_of_type_Int = paramInt;
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
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
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      try
      {
        paramTimeUnit = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (paramTimeUnit.hasNext())
        {
          PoolEntry localPoolEntry = (PoolEntry)paramTimeUnit.next();
          if (localPoolEntry.a() <= l - paramLong)
          {
            localPoolEntry.b();
            pjp localpjp = a(localPoolEntry.a());
            localpjp.a(localPoolEntry);
            paramTimeUnit.remove();
            a(localpjp);
          }
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      return;
    }
  }
  
  /* Error */
  public void a(PoolEntry paramPoolEntry, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/tencent/component/network/utils/http/pool/AbstractConnPool:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 103 1 0
    //   9: aload_0
    //   10: getfield 50	com/tencent/component/network/utils/http/pool/AbstractConnPool:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   13: aload_1
    //   14: invokeinterface 267 2 0
    //   19: ifeq +42 -> 61
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 169	com/tencent/component/network/utils/http/pool/PoolEntry:a	()Ljava/lang/Object;
    //   27: invokespecial 106	com/tencent/component/network/utils/http/pool/AbstractConnPool:a	(Ljava/lang/Object;)Lpjp;
    //   30: astore_3
    //   31: aload_3
    //   32: aload_1
    //   33: iload_2
    //   34: invokevirtual 135	pjp:a	(Lcom/tencent/component/network/utils/http/pool/PoolEntry;Z)V
    //   37: iload_2
    //   38: ifeq +33 -> 71
    //   41: aload_0
    //   42: getfield 108	com/tencent/component/network/utils/http/pool/AbstractConnPool:jdField_a_of_type_Boolean	Z
    //   45: ifne +26 -> 71
    //   48: aload_0
    //   49: getfield 55	com/tencent/component/network/utils/http/pool/AbstractConnPool:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   52: aload_1
    //   53: invokevirtual 271	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   56: aload_0
    //   57: aload_3
    //   58: invokespecial 266	com/tencent/component/network/utils/http/pool/AbstractConnPool:a	(Lpjp;)V
    //   61: aload_0
    //   62: getfield 38	com/tencent/component/network/utils/http/pool/AbstractConnPool:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   65: invokeinterface 116 1 0
    //   70: return
    //   71: aload_1
    //   72: invokevirtual 126	com/tencent/component/network/utils/http/pool/PoolEntry:b	()V
    //   75: goto -19 -> 56
    //   78: astore_1
    //   79: aload_0
    //   80: getfield 38	com/tencent/component/network/utils/http/pool/AbstractConnPool:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   83: invokeinterface 116 1 0
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	AbstractConnPool
    //   0	90	1	paramPoolEntry	PoolEntry
    //   0	90	2	paramBoolean	boolean
    //   30	28	3	localpjp	pjp
    // Exception table:
    //   from	to	target	type
    //   9	37	78	finally
    //   41	56	78	finally
    //   56	61	78	finally
    //   71	75	78	finally
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext())
      {
        PoolEntry localPoolEntry = (PoolEntry)localIterator.next();
        if (localPoolEntry.a(l))
        {
          localPoolEntry.b();
          pjp localpjp = a(localPoolEntry.a());
          localpjp.a(localPoolEntry);
          localIterator.remove();
          a(localpjp);
        }
      }
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Max value may not be negative or zero");
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[leased: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilSet);
    localStringBuilder.append("][available: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilLinkedList);
    localStringBuilder.append("][pending: ");
    localStringBuilder.append(this.jdField_b_of_type_JavaUtilLinkedList);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.AbstractConnPool
 * JD-Core Version:    0.7.0.1
 */