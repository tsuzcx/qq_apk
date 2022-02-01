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
    if (paramInt > 0)
    {
      this.capacity = paramInt;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public LinkedBlockingDeque(Collection<? extends E> paramCollection)
  {
    this(2147483647);
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Object localObject = paramCollection.next();
        if (localObject != null)
        {
          if (!linkLast(new LinkedBlockingDeque.Node(localObject))) {
            throw new IllegalStateException("Deque full");
          }
        }
        else {
          throw new NullPointerException();
        }
      }
      localReentrantLock.unlock();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw paramCollection;
    }
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
    } else {
      localNode.prev = paramNode;
    }
    this.count += 1;
    this.notEmpty.signal();
    return true;
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
    } else {
      localNode.next = paramNode;
    }
    this.count += 1;
    this.notEmpty.signal();
    return true;
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
    } else {
      localNode2.prev = null;
    }
    this.count -= 1;
    this.notFull.signal();
    return localObject;
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
    } else {
      localNode2.next = null;
    }
    this.count -= 1;
    this.notFull.signal();
    return localObject;
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
      localReentrantLock.unlock();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw paramObjectOutputStream;
    }
  }
  
  public boolean add(E paramE)
  {
    addLast(paramE);
    return true;
  }
  
  public void addFirst(E paramE)
  {
    if (offerFirst(paramE)) {
      return;
    }
    throw new IllegalStateException("Deque full");
  }
  
  public void addLast(E paramE)
  {
    if (offerLast(paramE)) {
      return;
    }
    throw new IllegalStateException("Deque full");
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
      localReentrantLock.unlock();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw localObject2;
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
        if (bool)
        {
          localReentrantLock.unlock();
          return true;
        }
      }
      localReentrantLock.unlock();
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw paramObject;
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
    if (paramCollection != null)
    {
      if (paramCollection != this)
      {
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
      throw new IllegalArgumentException();
    }
    paramCollection = new NullPointerException();
    for (;;)
    {
      throw paramCollection;
    }
  }
  
  public E element()
  {
    return getFirst();
  }
  
  public E getFirst()
  {
    Object localObject = peekFirst();
    if (localObject != null) {
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public E getLast()
  {
    Object localObject = peekLast();
    if (localObject != null) {
      return localObject;
    }
    throw new NoSuchElementException();
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
    if (paramE != null)
    {
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
    throw new NullPointerException();
  }
  
  public boolean offerFirst(E paramE, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramE != null)
    {
      paramE = new LinkedBlockingDeque.Node(paramE);
      paramLong = paramTimeUnit.toNanos(paramLong);
      paramTimeUnit = this.lock;
      paramTimeUnit.lockInterruptibly();
      try
      {
        boolean bool = linkFirst(paramE);
        if (!bool) {
          if (paramLong > 0L) {}
        }
        for (bool = false;; bool = true)
        {
          return bool;
          paramLong = this.notFull.awaitNanos(paramLong);
          break;
        }
        paramE = new NullPointerException();
      }
      finally
      {
        paramTimeUnit.unlock();
      }
    }
    for (;;)
    {
      throw paramE;
    }
  }
  
  public boolean offerLast(E paramE)
  {
    if (paramE != null)
    {
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
    throw new NullPointerException();
  }
  
  public boolean offerLast(E paramE, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramE != null)
    {
      paramE = new LinkedBlockingDeque.Node(paramE);
      paramLong = paramTimeUnit.toNanos(paramLong);
      paramTimeUnit = this.lock;
      paramTimeUnit.lockInterruptibly();
      try
      {
        boolean bool = linkLast(paramE);
        if (!bool) {
          if (paramLong > 0L) {}
        }
        for (bool = false;; bool = true)
        {
          return bool;
          paramLong = this.notFull.awaitNanos(paramLong);
          break;
        }
        paramE = new NullPointerException();
      }
      finally
      {
        paramTimeUnit.unlock();
      }
    }
    for (;;)
    {
      throw paramE;
    }
  }
  
  public E peek()
  {
    return peekFirst();
  }
  
  public E peekFirst()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Object localObject1;
      if (this.first == null) {
        localObject1 = null;
      } else {
        localObject1 = this.first.item;
      }
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E peekLast()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Object localObject1;
      if (this.last == null) {
        localObject1 = null;
      } else {
        localObject1 = this.last.item;
      }
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
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
        if (paramLong <= 0L)
        {
          paramTimeUnit.unlock();
          return null;
        }
        paramLong = this.notEmpty.awaitNanos(paramLong);
      }
      paramTimeUnit.unlock();
      return localObject1;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
    for (;;)
    {
      throw localObject2;
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
        if (paramLong <= 0L)
        {
          paramTimeUnit.unlock();
          return null;
        }
        paramLong = this.notEmpty.awaitNanos(paramLong);
      }
      paramTimeUnit.unlock();
      return localObject1;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
    for (;;)
    {
      throw localObject2;
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
    if (paramE != null)
    {
      LinkedBlockingDeque.Node localNode = new LinkedBlockingDeque.Node(paramE);
      paramE = this.lock;
      paramE.lock();
      try
      {
        while (!linkFirst(localNode)) {
          this.notFull.await();
        }
        return;
      }
      finally
      {
        paramE.unlock();
      }
    }
    paramE = new NullPointerException();
    for (;;)
    {
      throw paramE;
    }
  }
  
  public void putLast(E paramE)
  {
    if (paramE != null)
    {
      LinkedBlockingDeque.Node localNode = new LinkedBlockingDeque.Node(paramE);
      paramE = this.lock;
      paramE.lock();
      try
      {
        while (!linkLast(localNode)) {
          this.notFull.await();
        }
        return;
      }
      finally
      {
        paramE.unlock();
      }
    }
    paramE = new NullPointerException();
    for (;;)
    {
      throw paramE;
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
    if (localObject != null) {
      return localObject;
    }
    throw new NoSuchElementException();
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
          localReentrantLock.unlock();
          return true;
        }
      }
      localReentrantLock.unlock();
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public E removeLast()
  {
    Object localObject = pollLast();
    if (localObject != null) {
      return localObject;
    }
    throw new NoSuchElementException();
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
          localReentrantLock.unlock();
          return true;
        }
      }
      localReentrantLock.unlock();
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw paramObject;
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
      Object localObject1;
      for (;;)
      {
        localObject1 = unlinkFirst();
        if (localObject1 != null) {
          break;
        }
        this.notEmpty.await();
      }
      localReentrantLock.unlock();
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public E takeLast()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Object localObject1;
      for (;;)
      {
        localObject1 = unlinkLast();
        if (localObject1 != null) {
          break;
        }
        this.notEmpty.await();
      }
      localReentrantLock.unlock();
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw localObject2;
    }
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
      localReentrantLock.unlock();
      return arrayOfObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw localObject;
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
      localReentrantLock.unlock();
      return localObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;)
    {
      throw paramArrayOfT;
    }
  }
  
  public String toString()
  {
    ReentrantLock localReentrantLock = this.lock;
    localReentrantLock.lock();
    try
    {
      Object localObject1 = this.first;
      if (localObject1 == null)
      {
        localReentrantLock.unlock();
        return "[]";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('[');
      for (;;)
      {
        Object localObject4 = ((LinkedBlockingDeque.Node)localObject1).item;
        Object localObject3 = localObject4;
        if (localObject4 == this) {
          localObject3 = "(this Collection)";
        }
        localStringBuilder.append(localObject3);
        localObject1 = ((LinkedBlockingDeque.Node)localObject1).next;
        if (localObject1 == null)
        {
          localStringBuilder.append(']');
          localObject1 = localStringBuilder.toString();
          localReentrantLock.unlock();
          return localObject1;
        }
        localStringBuilder.append(',');
        localStringBuilder.append(' ');
      }
      throw localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    for (;;) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque
 * JD-Core Version:    0.7.0.1
 */