package com.tencent.component.network.utils.thread.internel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque<E>
  extends AbstractCollection<E>
  implements Deque<E>, Serializable, Cloneable
{
  private static final int MIN_INITIAL_CAPACITY = 8;
  private static final long serialVersionUID = 2340985798034038923L;
  private transient Object[] elements;
  private transient int head;
  private transient int tail;
  
  public ArrayDeque()
  {
    this.elements = new Object[16];
  }
  
  public ArrayDeque(int paramInt)
  {
    allocateElements(paramInt);
  }
  
  public ArrayDeque(Collection<? extends E> paramCollection)
  {
    allocateElements(paramCollection.size());
    addAll(paramCollection);
  }
  
  private void allocateElements(int paramInt)
  {
    int i = 8;
    if (paramInt >= 8)
    {
      paramInt |= paramInt >>> 1;
      paramInt |= paramInt >>> 2;
      paramInt |= paramInt >>> 4;
      paramInt |= paramInt >>> 8;
      paramInt = (paramInt | paramInt >>> 16) + 1;
      i = paramInt;
      if (paramInt < 0) {
        i = paramInt >>> 1;
      }
    }
    this.elements = new Object[i];
  }
  
  private void checkInvariants() {}
  
  private <T> T[] copyElements(T[] paramArrayOfT)
  {
    int i = this.head;
    int j = this.tail;
    if (i < j)
    {
      System.arraycopy(this.elements, i, paramArrayOfT, 0, size());
      return paramArrayOfT;
    }
    if (i > j)
    {
      Object[] arrayOfObject = this.elements;
      j = arrayOfObject.length - i;
      System.arraycopy(arrayOfObject, i, paramArrayOfT, 0, j);
      System.arraycopy(this.elements, 0, paramArrayOfT, j, this.tail);
    }
    return paramArrayOfT;
  }
  
  private boolean delete(int paramInt)
  {
    checkInvariants();
    Object[] arrayOfObject = this.elements;
    int i = arrayOfObject.length - 1;
    int j = this.head;
    int k = this.tail;
    int m = paramInt - j & i;
    int n = k - paramInt & i;
    if (m < (k - j & i))
    {
      if (m < n)
      {
        if (j <= paramInt)
        {
          System.arraycopy(arrayOfObject, j, arrayOfObject, j + 1, m);
        }
        else
        {
          System.arraycopy(arrayOfObject, 0, arrayOfObject, 1, paramInt);
          arrayOfObject[0] = arrayOfObject[i];
          System.arraycopy(arrayOfObject, j, arrayOfObject, j + 1, i - j);
        }
        arrayOfObject[j] = null;
        this.head = (j + 1 & i);
        return false;
      }
      if (paramInt < k)
      {
        System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, n);
        this.tail = (k - 1);
        return true;
      }
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i - paramInt);
      arrayOfObject[i] = arrayOfObject[0];
      System.arraycopy(arrayOfObject, 1, arrayOfObject, 0, k);
      this.tail = (k - 1 & i);
      return true;
    }
    throw new ConcurrentModificationException();
  }
  
  private void doubleCapacity()
  {
    int i = this.head;
    Object[] arrayOfObject1 = this.elements;
    int j = arrayOfObject1.length;
    int k = j - i;
    int m = j << 1;
    if (m >= 0)
    {
      Object[] arrayOfObject2 = new Object[m];
      System.arraycopy(arrayOfObject1, i, arrayOfObject2, 0, k);
      System.arraycopy(this.elements, 0, arrayOfObject2, k, i);
      this.elements = arrayOfObject2;
      this.head = 0;
      this.tail = j;
      return;
    }
    throw new IllegalStateException("Sorry, deque too big");
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    int j = paramObjectInputStream.readInt();
    allocateElements(j);
    int i = 0;
    this.head = 0;
    this.tail = j;
    while (i < j)
    {
      this.elements[i] = paramObjectInputStream.readObject();
      i += 1;
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(size());
    int j = this.elements.length;
    for (int i = this.head; i != this.tail; i = i + 1 & j - 1) {
      paramObjectOutputStream.writeObject(this.elements[i]);
    }
  }
  
  public boolean add(E paramE)
  {
    addLast(paramE);
    return true;
  }
  
  public void addFirst(E paramE)
  {
    if (paramE != null)
    {
      Object[] arrayOfObject = this.elements;
      int i = this.head - 1 & arrayOfObject.length - 1;
      this.head = i;
      arrayOfObject[i] = paramE;
      if (this.head == this.tail) {
        doubleCapacity();
      }
      return;
    }
    throw new NullPointerException("e == null");
  }
  
  public void addLast(E paramE)
  {
    if (paramE != null)
    {
      Object[] arrayOfObject = this.elements;
      int i = this.tail;
      arrayOfObject[i] = paramE;
      i = arrayOfObject.length - 1 & i + 1;
      this.tail = i;
      if (i == this.head) {
        doubleCapacity();
      }
      return;
    }
    throw new NullPointerException("e == null");
  }
  
  public void clear()
  {
    int i = this.head;
    int k = this.tail;
    if (i != k)
    {
      this.tail = 0;
      this.head = 0;
      int m = this.elements.length;
      int j;
      do
      {
        this.elements[i] = null;
        j = i + 1 & m - 1;
        i = j;
      } while (j != k);
    }
  }
  
  public ArrayDeque<E> clone()
  {
    try
    {
      ArrayDeque localArrayDeque = (ArrayDeque)super.clone();
      localArrayDeque.elements = Arrays.copyOf(this.elements, this.elements.length);
      return localArrayDeque;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label26:
      break label26;
    }
    throw new AssertionError();
  }
  
  public boolean contains(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    int j = this.elements.length;
    for (int i = this.head;; i = i + 1 & j - 1)
    {
      Object localObject = this.elements[i];
      if (localObject == null) {
        break;
      }
      if (paramObject.equals(localObject)) {
        return true;
      }
    }
    return false;
  }
  
  public Iterator<E> descendingIterator()
  {
    return new ArrayDeque.DescendingIterator(this, null);
  }
  
  public E element()
  {
    return getFirst();
  }
  
  public E getFirst()
  {
    Object localObject = this.elements[this.head];
    if (localObject != null) {
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public E getLast()
  {
    Object localObject = this.elements;
    localObject = localObject[(this.tail - 1 & localObject.length - 1)];
    if (localObject != null) {
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public boolean isEmpty()
  {
    return this.head == this.tail;
  }
  
  public Iterator<E> iterator()
  {
    return new ArrayDeque.DeqIterator(this, null);
  }
  
  public boolean offer(E paramE)
  {
    return offerLast(paramE);
  }
  
  public boolean offerFirst(E paramE)
  {
    addFirst(paramE);
    return true;
  }
  
  public boolean offerLast(E paramE)
  {
    addLast(paramE);
    return true;
  }
  
  public E peek()
  {
    return peekFirst();
  }
  
  public E peekFirst()
  {
    return this.elements[this.head];
  }
  
  public E peekLast()
  {
    Object[] arrayOfObject = this.elements;
    return arrayOfObject[(this.tail - 1 & arrayOfObject.length - 1)];
  }
  
  public E poll()
  {
    return pollFirst();
  }
  
  public E pollFirst()
  {
    int i = this.head;
    Object[] arrayOfObject = this.elements;
    Object localObject = arrayOfObject[i];
    if (localObject == null) {
      return null;
    }
    arrayOfObject[i] = null;
    this.head = (i + 1 & arrayOfObject.length - 1);
    return localObject;
  }
  
  public E pollLast()
  {
    int i = this.tail;
    Object[] arrayOfObject = this.elements;
    i = i - 1 & arrayOfObject.length - 1;
    Object localObject = arrayOfObject[i];
    if (localObject == null) {
      return null;
    }
    arrayOfObject[i] = null;
    this.tail = i;
    return localObject;
  }
  
  public E pop()
  {
    return removeFirst();
  }
  
  public void push(E paramE)
  {
    addFirst(paramE);
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
    int j = this.elements.length;
    for (int i = this.head;; i = i + 1 & j - 1)
    {
      Object localObject = this.elements[i];
      if (localObject == null) {
        break;
      }
      if (paramObject.equals(localObject))
      {
        delete(i);
        return true;
      }
    }
    return false;
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
    int j = this.elements.length;
    int i = this.tail - 1;
    for (;;)
    {
      i &= j - 1;
      Object localObject = this.elements[i];
      if (localObject == null) {
        break;
      }
      if (paramObject.equals(localObject))
      {
        delete(i);
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  public int size()
  {
    return this.tail - this.head & this.elements.length - 1;
  }
  
  public Object[] toArray()
  {
    return copyElements(new Object[size()]);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    int i = size();
    Object localObject = paramArrayOfT;
    if (paramArrayOfT.length < i) {
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
    }
    copyElements((Object[])localObject);
    if (localObject.length > i) {
      localObject[i] = null;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.internel.ArrayDeque
 * JD-Core Version:    0.7.0.1
 */