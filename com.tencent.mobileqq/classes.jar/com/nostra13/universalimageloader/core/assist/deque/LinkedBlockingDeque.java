package com.nostra13.universalimageloader.core.assist.deque;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingDeque<E>
  extends AbstractQueue<E>
  implements BlockingDeque<E>, Serializable
{
  private static final long serialVersionUID = -387911632671998426L;
  private final int capacity;
  private transient int count;
  transient LinkedBlockingDeque.Node<E> first;
  transient LinkedBlockingDeque.Node<E> last;
  final ReentrantLock lock = new ReentrantLock();
  private final Condition notEmpty = this.lock.newCondition();
  private final Condition notFull = this.lock.newCondition();
  
  public LinkedBlockingDeque()
  {
    this(2147483647);
  }
  
  public LinkedBlockingDeque(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException();
    }
    this.capacity = paramInt;
  }
  
  public LinkedBlockingDeque(Collection<? extends E> paramCollection)
  {
    this(2147483647);
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    for (;;)
    {
      Object localObject;
      try
      {
        paramCollection = paramCollection.iterator();
        if (!paramCollection.hasNext()) {
          break;
        }
        localObject = paramCollection.next();
        if (localObject == null) {
          throw new NullPointerException();
        }
      }
      finally
      {
        localReentrantLock.unlock();
      }
      if (!linkLast(new LinkedBlockingDeque.Node(localObject))) {
        throw new IllegalStateException("Deque full");
      }
    }
    localReentrantLock.unlock();
  }
  
  private boolean linkFirst(LinkedBlockingDeque.Node<E> paramNode)
  {
    if (this.count >= this.capacity) {
      return false;
    }
    LinkedBlockingDeque.Node localNode = this.first;
    paramNode.next = localNode;
    this.first = paramNode;
    if (this.last == null) {
      this.last = paramNode;
    }
    for (;;)
    {
      this.count += 1;
      this.notEmpty.signal();
      return true;
      localNode.prev = paramNode;
    }
  }
  
  private boolean linkLast(LinkedBlockingDeque.Node<E> paramNode)
  {
    if (this.count >= this.capacity) {
      return false;
    }
    LinkedBlockingDeque.Node localNode = this.last;
    paramNode.prev = localNode;
    this.last = paramNode;
    if (this.first == null) {
      this.first = paramNode;
    }
    for (;;)
    {
      this.count += 1;
      this.notEmpty.signal();
      return true;
      localNode.next = paramNode;
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    this.count = 0;
    this.first = null;
    this.last = null;
    for (;;)
    {
      Object localObject = paramObjectInputStream.readObject();
      if (localObject == null) {
        return;
      }
      add(localObject);
    }
  }
  
  private E unlinkFirst()
  {
    LinkedBlockingDeque.Node localNode1 = this.first;
    if (localNode1 == null) {
      return null;
    }
    LinkedBlockingDeque.Node localNode2 = localNode1.next;
    Object localObject = localNode1.item;
    localNode1.item = null;
    localNode1.next = localNode1;
    this.first = localNode2;
    if (localNode2 == null) {
      this.last = null;
    }
    for (;;)
    {
      this.count -= 1;
      this.notFull.signal();
      return localObject;
      localNode2.prev = null;
    }
  }
  
  private E unlinkLast()
  {
    LinkedBlockingDeque.Node localNode1 = this.last;
    if (localNode1 == null) {
      return null;
    }
    LinkedBlockingDeque.Node localNode2 = localNode1.prev;
    Object localObject = localNode1.item;
    localNode1.item = null;
    localNode1.prev = localNode1;
    this.last = localNode2;
    if (localNode2 == null) {
      this.first = null;
    }
    for (;;)
    {
      this.count -= 1;
      this.notFull.signal();
      return localObject;
      localNode2.next = null;
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      paramObjectOutputStream.defaultWriteObject();
      for (LinkedBlockingDeque.Node localNode = this.first; localNode != null; localNode = localNode.next) {
        paramObjectOutputStream.writeObject(localNode.item);
      }
      paramObjectOutputStream.writeObject(null);
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean add(E paramE)
  {
    addLast(paramE);
    return true;
  }
  
  public void addFirst(E paramE)
  {
    if (!offerFirst(paramE)) {
      throw new IllegalStateException("Deque full");
    }
  }
  
  public void addLast(E paramE)
  {
    if (!offerLast(paramE)) {
      throw new IllegalStateException("Deque full");
    }
  }
  
  public void clear()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      LinkedBlockingDeque.Node localNode;
      for (Object localObject1 = this.first; localObject1 != null; localObject1 = localNode)
      {
        ((LinkedBlockingDeque.Node)localObject1).item = null;
        localNode = ((LinkedBlockingDeque.Node)localObject1).next;
        ((LinkedBlockingDeque.Node)localObject1).prev = null;
        ((LinkedBlockingDeque.Node)localObject1).next = null;
      }
      this.last = null;
      this.first = null;
      this.count = 0;
      this.notFull.signalAll();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean contains(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (LinkedBlockingDeque.Node localNode = this.first; localNode != null; localNode = localNode.next)
      {
        boolean bool = paramObject.equals(localNode.item);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public Iterator<E> descendingIterator()
  {
    return new LinkedBlockingDeque.DescendingItr(this, null);
  }
  
  public int drainTo(Collection<? super E> paramCollection)
  {
    return drainTo(paramCollection, 2147483647);
  }
  
  public int drainTo(Collection<? super E> paramCollection, int paramInt)
  {
    if (paramCollection == null) {
      throw new NullPointerException();
    }
    if (paramCollection == this) {
      throw new IllegalArgumentException();
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      int i = Math.min(paramInt, this.count);
      paramInt = 0;
      while (paramInt < i)
      {
        paramCollection.add(this.first.item);
        unlinkFirst();
        paramInt += 1;
      }
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E element()
  {
    return getFirst();
  }
  
  public E getFirst()
  {
    Object localObject = peekFirst();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public E getLast()
  {
    Object localObject = peekLast();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public Iterator<E> iterator()
  {
    return new LinkedBlockingDeque.Itr(this, null);
  }
  
  public boolean offer(E paramE)
  {
    return offerLast(paramE);
  }
  
  public boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
  {
    return offerLast(paramE, paramLong, paramTimeUnit);
  }
  
  public boolean offerFirst(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    LinkedBlockingDeque.Node localNode = new LinkedBlockingDeque.Node(paramE);
    paramE = this.lock;
    paramE.lock();
    try
    {
      boolean bool = linkFirst(localNode);
      return bool;
    }
    finally
    {
      paramE.unlock();
    }
  }
  
  public boolean offerFirst(E paramE, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    paramE = new LinkedBlockingDeque.Node(paramE);
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.lock;
    paramTimeUnit.lockInterruptibly();
    try
    {
      for (;;)
      {
        boolean bool = linkFirst(paramE);
        if (bool) {
          break;
        }
        if (paramLong <= 0L) {
          return false;
        }
        paramLong = this.notFull.awaitNanos(paramLong);
      }
      return true;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public boolean offerLast(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    LinkedBlockingDeque.Node localNode = new LinkedBlockingDeque.Node(paramE);
    paramE = this.lock;
    paramE.lock();
    try
    {
      boolean bool = linkLast(localNode);
      return bool;
    }
    finally
    {
      paramE.unlock();
    }
  }
  
  public boolean offerLast(E paramE, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    paramE = new LinkedBlockingDeque.Node(paramE);
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.lock;
    paramTimeUnit.lockInterruptibly();
    try
    {
      for (;;)
      {
        boolean bool = linkLast(paramE);
        if (bool) {
          break;
        }
        if (paramLong <= 0L) {
          return false;
        }
        paramLong = this.notFull.awaitNanos(paramLong);
      }
      return true;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public E peek()
  {
    return peekFirst();
  }
  
  /* Error */
  public E peekFirst()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 55	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 100	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:first	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +11 -> 26
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 77	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: getfield 100	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:first	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   30: getfield 131	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:item	Ljava/lang/Object;
    //   33: astore_1
    //   34: goto -14 -> 20
    //   37: astore_1
    //   38: aload_2
    //   39: invokevirtual 77	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	LinkedBlockingDeque
    //   13	21	1	localObject1	Object
    //   37	6	1	localObject2	Object
    //   4	35	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
    //   26	34	37	finally
  }
  
  /* Error */
  public E peekLast()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 55	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 104	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:last	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +11 -> 26
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 77	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: getfield 104	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:last	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   30: getfield 131	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:item	Ljava/lang/Object;
    //   33: astore_1
    //   34: goto -14 -> 20
    //   37: astore_1
    //   38: aload_2
    //   39: invokevirtual 77	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	LinkedBlockingDeque
    //   13	21	1	localObject1	Object
    //   37	6	1	localObject2	Object
    //   4	35	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
    //   26	34	37	finally
  }
  
  public E poll()
  {
    return pollFirst();
  }
  
  public E poll(long paramLong, TimeUnit paramTimeUnit)
  {
    return pollFirst(paramLong, paramTimeUnit);
  }
  
  public E pollFirst()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Object localObject1 = unlinkFirst();
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E pollFirst(long paramLong, TimeUnit paramTimeUnit)
  {
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.lock;
    paramTimeUnit.lockInterruptibly();
    try
    {
      Object localObject1;
      for (;;)
      {
        localObject1 = unlinkFirst();
        if (localObject1 != null) {
          break;
        }
        if (paramLong <= 0L) {
          return null;
        }
        paramLong = this.notEmpty.awaitNanos(paramLong);
      }
      return localObject1;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public E pollLast()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Object localObject1 = unlinkLast();
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E pollLast(long paramLong, TimeUnit paramTimeUnit)
  {
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.lock;
    paramTimeUnit.lockInterruptibly();
    try
    {
      Object localObject1;
      for (;;)
      {
        localObject1 = unlinkLast();
        if (localObject1 != null) {
          break;
        }
        if (paramLong <= 0L) {
          return null;
        }
        paramLong = this.notEmpty.awaitNanos(paramLong);
      }
      return localObject1;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public E pop()
  {
    return removeFirst();
  }
  
  public void push(E paramE)
  {
    addFirst(paramE);
  }
  
  public void put(E paramE)
  {
    putLast(paramE);
  }
  
  public void putFirst(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    LinkedBlockingDeque.Node localNode = new LinkedBlockingDeque.Node(paramE);
    paramE = this.lock;
    paramE.lock();
    try
    {
      if (!linkFirst(localNode)) {
        this.notFull.await();
      }
      return;
    }
    finally
    {
      paramE.unlock();
    }
  }
  
  public void putLast(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    LinkedBlockingDeque.Node localNode = new LinkedBlockingDeque.Node(paramE);
    paramE = this.lock;
    paramE.lock();
    try
    {
      if (!linkLast(localNode)) {
        this.notFull.await();
      }
      return;
    }
    finally
    {
      paramE.unlock();
    }
  }
  
  public int remainingCapacity()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      int i = this.capacity;
      int j = this.count;
      return i - j;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E remove()
  {
    return removeFirst();
  }
  
  public boolean remove(Object paramObject)
  {
    return removeFirstOccurrence(paramObject);
  }
  
  public E removeFirst()
  {
    Object localObject = pollFirst();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public boolean removeFirstOccurrence(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (LinkedBlockingDeque.Node localNode = this.first; localNode != null; localNode = localNode.next) {
        if (paramObject.equals(localNode.item))
        {
          unlink(localNode);
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E removeLast()
  {
    Object localObject = pollLast();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public boolean removeLastOccurrence(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (LinkedBlockingDeque.Node localNode = this.last; localNode != null; localNode = localNode.prev) {
        if (paramObject.equals(localNode.item))
        {
          unlink(localNode);
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public int size()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      int i = this.count;
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E take()
  {
    return takeFirst();
  }
  
  public E takeFirst()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (;;)
      {
        Object localObject = unlinkFirst();
        if (localObject != null) {
          break;
        }
        this.notEmpty.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return ?;
  }
  
  public E takeLast()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      for (;;)
      {
        Object localObject = unlinkLast();
        if (localObject != null) {
          break;
        }
        this.notEmpty.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return ?;
  }
  
  public Object[] toArray()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Object[] arrayOfObject = new Object[this.count];
      int i = 0;
      LinkedBlockingDeque.Node localNode = this.first;
      while (localNode != null)
      {
        arrayOfObject[i] = localNode.item;
        localNode = localNode.next;
        i += 1;
      }
      return arrayOfObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    Object localObject = paramArrayOfT;
    try
    {
      if (paramArrayOfT.length < this.count) {
        localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.count);
      }
      int i = 0;
      paramArrayOfT = this.first;
      while (paramArrayOfT != null)
      {
        localObject[i] = paramArrayOfT.item;
        paramArrayOfT = paramArrayOfT.next;
        i += 1;
      }
      if (localObject.length > i) {
        localObject[i] = null;
      }
      return localObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  /* Error */
  public java.lang.String toString()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:lock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore 4
    //   6: aload 4
    //   8: invokevirtual 55	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   11: aload_0
    //   12: getfield 100	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque:first	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +12 -> 29
    //   20: aload 4
    //   22: invokevirtual 77	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   25: ldc_w 295
    //   28: areturn
    //   29: new 297	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   36: astore 5
    //   38: aload 5
    //   40: bipush 91
    //   42: invokevirtual 302	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_1
    //   47: getfield 131	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:item	Ljava/lang/Object;
    //   50: astore_3
    //   51: aload_3
    //   52: astore_2
    //   53: aload_3
    //   54: aload_0
    //   55: if_acmpne +7 -> 62
    //   58: ldc_w 304
    //   61: astore_2
    //   62: aload 5
    //   64: aload_2
    //   65: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_1
    //   70: getfield 102	com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node:next	Lcom/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$Node;
    //   73: astore_1
    //   74: aload_1
    //   75: ifnonnull +21 -> 96
    //   78: aload 5
    //   80: bipush 93
    //   82: invokevirtual 302	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   85: invokevirtual 309	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore_1
    //   89: aload 4
    //   91: invokevirtual 77	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   94: aload_1
    //   95: areturn
    //   96: aload 5
    //   98: bipush 44
    //   100: invokevirtual 302	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   103: bipush 32
    //   105: invokevirtual 302	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: goto -63 -> 46
    //   112: astore_1
    //   113: aload 4
    //   115: invokevirtual 77	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	LinkedBlockingDeque
    //   15	80	1	localObject1	Object
    //   112	7	1	localObject2	Object
    //   52	13	2	localObject3	Object
    //   50	4	3	localObject4	Object
    //   4	110	4	localReentrantLock	ReentrantLock
    //   36	61	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	16	112	finally
    //   29	46	112	finally
    //   46	51	112	finally
    //   62	74	112	finally
    //   78	89	112	finally
    //   96	109	112	finally
  }
  
  void unlink(LinkedBlockingDeque.Node<E> paramNode)
  {
    LinkedBlockingDeque.Node localNode1 = paramNode.prev;
    LinkedBlockingDeque.Node localNode2 = paramNode.next;
    if (localNode1 == null)
    {
      unlinkFirst();
      return;
    }
    if (localNode2 == null)
    {
      unlinkLast();
      return;
    }
    localNode1.next = localNode2;
    localNode2.prev = localNode1;
    paramNode.item = null;
    this.count -= 1;
    this.notFull.signal();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque
 * JD-Core Version:    0.7.0.1
 */