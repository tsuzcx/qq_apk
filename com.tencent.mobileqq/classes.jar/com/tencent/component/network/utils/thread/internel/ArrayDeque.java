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
  
  static
  {
    if (!ArrayDeque.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
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
      paramInt = paramInt >>> 1 | paramInt;
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
  
  private void checkInvariants()
  {
    assert (this.elements[this.tail] == null);
    if (!$assertionsDisabled)
    {
      if (this.head != this.tail) {
        break label91;
      }
      if (this.elements[this.head] != null) {
        break label125;
      }
    }
    label91:
    while ((this.elements[this.head] != null) && (this.elements[(this.tail - 1 & this.elements.length - 1)] != null))
    {
      if (($assertionsDisabled) || (this.elements[(this.head - 1 & this.elements.length - 1)] == null)) {
        break;
      }
      throw new AssertionError();
    }
    label125:
    throw new AssertionError();
  }
  
  private <T> T[] copyElements(T[] paramArrayOfT)
  {
    if (this.head < this.tail) {
      System.arraycopy(this.elements, this.head, paramArrayOfT, 0, size());
    }
    while (this.head <= this.tail) {
      return paramArrayOfT;
    }
    int i = this.elements.length - this.head;
    System.arraycopy(this.elements, this.head, paramArrayOfT, 0, i);
    System.arraycopy(this.elements, 0, paramArrayOfT, i, this.tail);
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
    if (m >= (k - j & i)) {
      throw new ConcurrentModificationException();
    }
    if (m < n)
    {
      if (j <= paramInt) {
        System.arraycopy(arrayOfObject, j, arrayOfObject, j + 1, m);
      }
      for (;;)
      {
        arrayOfObject[j] = null;
        this.head = (j + 1 & i);
        return false;
        System.arraycopy(arrayOfObject, 0, arrayOfObject, 1, paramInt);
        arrayOfObject[0] = arrayOfObject[i];
        System.arraycopy(arrayOfObject, j, arrayOfObject, j + 1, i - j);
      }
    }
    if (paramInt < k) {
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, n);
    }
    for (this.tail = (k - 1);; this.tail = (k - 1 & i))
    {
      return true;
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i - paramInt);
      arrayOfObject[i] = arrayOfObject[0];
      System.arraycopy(arrayOfObject, 1, arrayOfObject, 0, k);
    }
  }
  
  private void doubleCapacity()
  {
    assert (this.head == this.tail);
    int i = this.head;
    int j = this.elements.length;
    int k = j - i;
    int m = j << 1;
    if (m < 0) {
      throw new IllegalStateException("Sorry, deque too big");
    }
    Object[] arrayOfObject = new Object[m];
    System.arraycopy(this.elements, i, arrayOfObject, 0, k);
    System.arraycopy(this.elements, 0, arrayOfObject, k, i);
    this.elements = arrayOfObject;
    this.head = 0;
    this.tail = j;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    int i = 0;
    paramObjectInputStream.defaultReadObject();
    int j = paramObjectInputStream.readInt();
    allocateElements(j);
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
    if (paramE == null) {
      throw new NullPointerException("e == null");
    }
    Object[] arrayOfObject = this.elements;
    int i = this.head - 1 & this.elements.length - 1;
    this.head = i;
    arrayOfObject[i] = paramE;
    if (this.head == this.tail) {
      doubleCapacity();
    }
  }
  
  public void addLast(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException("e == null");
    }
    this.elements[this.tail] = paramE;
    int i = this.tail + 1 & this.elements.length - 1;
    this.tail = i;
    if (i == this.head) {
      doubleCapacity();
    }
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
      throw new AssertionError();
    }
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
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public E getLast()
  {
    Object localObject = this.elements[(this.tail - 1 & this.elements.length - 1)];
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
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
    return this.elements[(this.tail - 1 & this.elements.length - 1)];
  }
  
  public E poll()
  {
    return pollFirst();
  }
  
  public E pollFirst()
  {
    int i = this.head;
    Object localObject = this.elements[i];
    if (localObject == null) {
      return null;
    }
    this.elements[i] = null;
    this.head = (i + 1 & this.elements.length - 1);
    return localObject;
  }
  
  public E pollLast()
  {
    int i = this.tail;
    i = this.elements.length - 1 & i - 1;
    Object localObject = this.elements[i];
    if (localObject == null) {
      return null;
    }
    this.elements[i] = null;
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
    int j = this.elements.length - 1;
    for (int i = this.tail - 1 & j;; i = i - 1 & j)
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
    if (paramArrayOfT.length < i) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
    }
    for (;;)
    {
      copyElements(paramArrayOfT);
      if (paramArrayOfT.length > i) {
        paramArrayOfT[i] = null;
      }
      return paramArrayOfT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.internel.ArrayDeque
 * JD-Core Version:    0.7.0.1
 */