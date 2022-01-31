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
import plw;
import plx;

public class ArrayDeque
  extends AbstractCollection
  implements Deque, Serializable, Cloneable
{
  private static final long serialVersionUID = 2340985798034038923L;
  private transient int jdField_a_of_type_Int;
  private transient Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  private transient int b;
  
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
    this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[16];
  }
  
  public ArrayDeque(int paramInt)
  {
    a(paramInt);
  }
  
  public ArrayDeque(Collection paramCollection)
  {
    a(paramCollection.size());
    addAll(paramCollection);
  }
  
  private void a()
  {
    assert (this.jdField_a_of_type_Int == this.b);
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_ArrayOfJavaLangObject.length;
    int k = j - i;
    int m = j << 1;
    if (m < 0) {
      throw new IllegalStateException("Sorry, deque too big");
    }
    Object[] arrayOfObject = new Object[m];
    System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, i, arrayOfObject, 0, k);
    System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, 0, arrayOfObject, k, i);
    this.jdField_a_of_type_ArrayOfJavaLangObject = arrayOfObject;
    this.jdField_a_of_type_Int = 0;
    this.b = j;
  }
  
  private void a(int paramInt)
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
    this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[i];
  }
  
  private boolean a(int paramInt)
  {
    b();
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int i = arrayOfObject.length - 1;
    int j = this.jdField_a_of_type_Int;
    int k = this.b;
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
        this.jdField_a_of_type_Int = (j + 1 & i);
        return false;
        System.arraycopy(arrayOfObject, 0, arrayOfObject, 1, paramInt);
        arrayOfObject[0] = arrayOfObject[i];
        System.arraycopy(arrayOfObject, j, arrayOfObject, j + 1, i - j);
      }
    }
    if (paramInt < k) {
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, n);
    }
    for (this.b = (k - 1);; this.b = (k - 1 & i))
    {
      return true;
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i - paramInt);
      arrayOfObject[i] = arrayOfObject[0];
      System.arraycopy(arrayOfObject, 1, arrayOfObject, 0, k);
    }
  }
  
  private Object[] a(Object[] paramArrayOfObject)
  {
    if (this.jdField_a_of_type_Int < this.b) {
      System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, this.jdField_a_of_type_Int, paramArrayOfObject, 0, size());
    }
    while (this.jdField_a_of_type_Int <= this.b) {
      return paramArrayOfObject;
    }
    int i = this.jdField_a_of_type_ArrayOfJavaLangObject.length - this.jdField_a_of_type_Int;
    System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, this.jdField_a_of_type_Int, paramArrayOfObject, 0, i);
    System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, 0, paramArrayOfObject, i, this.b);
    return paramArrayOfObject;
  }
  
  private void b()
  {
    assert (this.jdField_a_of_type_ArrayOfJavaLangObject[this.b] == null);
    if (!$assertionsDisabled)
    {
      if (this.jdField_a_of_type_Int != this.b) {
        break label91;
      }
      if (this.jdField_a_of_type_ArrayOfJavaLangObject[this.jdField_a_of_type_Int] != null) {
        break label125;
      }
    }
    label91:
    while ((this.jdField_a_of_type_ArrayOfJavaLangObject[this.jdField_a_of_type_Int] != null) && (this.jdField_a_of_type_ArrayOfJavaLangObject[(this.b - 1 & this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1)] != null))
    {
      if (($assertionsDisabled) || (this.jdField_a_of_type_ArrayOfJavaLangObject[(this.jdField_a_of_type_Int - 1 & this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1)] == null)) {
        break;
      }
      throw new AssertionError();
    }
    label125:
    throw new AssertionError();
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    int i = 0;
    paramObjectInputStream.defaultReadObject();
    int j = paramObjectInputStream.readInt();
    a(j);
    this.jdField_a_of_type_Int = 0;
    this.b = j;
    while (i < j)
    {
      this.jdField_a_of_type_ArrayOfJavaLangObject[i] = paramObjectInputStream.readObject();
      i += 1;
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(size());
    int j = this.jdField_a_of_type_ArrayOfJavaLangObject.length;
    for (int i = this.jdField_a_of_type_Int; i != this.b; i = i + 1 & j - 1) {
      paramObjectOutputStream.writeObject(this.jdField_a_of_type_ArrayOfJavaLangObject[i]);
    }
  }
  
  public boolean add(Object paramObject)
  {
    addLast(paramObject);
    return true;
  }
  
  public void addFirst(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("e == null");
    }
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int i = this.jdField_a_of_type_Int - 1 & this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1;
    this.jdField_a_of_type_Int = i;
    arrayOfObject[i] = paramObject;
    if (this.jdField_a_of_type_Int == this.b) {
      a();
    }
  }
  
  public void addLast(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException("e == null");
    }
    this.jdField_a_of_type_ArrayOfJavaLangObject[this.b] = paramObject;
    int i = this.b + 1 & this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1;
    this.b = i;
    if (i == this.jdField_a_of_type_Int) {
      a();
    }
  }
  
  public void clear()
  {
    int i = this.jdField_a_of_type_Int;
    int k = this.b;
    if (i != k)
    {
      this.b = 0;
      this.jdField_a_of_type_Int = 0;
      int m = this.jdField_a_of_type_ArrayOfJavaLangObject.length;
      int j;
      do
      {
        this.jdField_a_of_type_ArrayOfJavaLangObject[i] = null;
        j = i + 1 & m - 1;
        i = j;
      } while (j != k);
    }
  }
  
  public ArrayDeque clone()
  {
    try
    {
      ArrayDeque localArrayDeque = (ArrayDeque)super.clone();
      localArrayDeque.jdField_a_of_type_ArrayOfJavaLangObject = Arrays.copyOf(this.jdField_a_of_type_ArrayOfJavaLangObject, this.jdField_a_of_type_ArrayOfJavaLangObject.length);
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
    int j = this.jdField_a_of_type_ArrayOfJavaLangObject.length;
    for (int i = this.jdField_a_of_type_Int;; i = i + 1 & j - 1)
    {
      Object localObject = this.jdField_a_of_type_ArrayOfJavaLangObject[i];
      if (localObject == null) {
        break;
      }
      if (paramObject.equals(localObject)) {
        return true;
      }
    }
    return false;
  }
  
  public Iterator descendingIterator()
  {
    return new plx(this, null);
  }
  
  public Object element()
  {
    return getFirst();
  }
  
  public Object getFirst()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfJavaLangObject[this.jdField_a_of_type_Int];
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public Object getLast()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfJavaLangObject[(this.b - 1 & this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1)];
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return localObject;
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_Int == this.b;
  }
  
  public Iterator iterator()
  {
    return new plw(this, null);
  }
  
  public boolean offer(Object paramObject)
  {
    return offerLast(paramObject);
  }
  
  public boolean offerFirst(Object paramObject)
  {
    addFirst(paramObject);
    return true;
  }
  
  public boolean offerLast(Object paramObject)
  {
    addLast(paramObject);
    return true;
  }
  
  public Object peek()
  {
    return peekFirst();
  }
  
  public Object peekFirst()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangObject[this.jdField_a_of_type_Int];
  }
  
  public Object peekLast()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangObject[(this.b - 1 & this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1)];
  }
  
  public Object poll()
  {
    return pollFirst();
  }
  
  public Object pollFirst()
  {
    int i = this.jdField_a_of_type_Int;
    Object localObject = this.jdField_a_of_type_ArrayOfJavaLangObject[i];
    if (localObject == null) {
      return null;
    }
    this.jdField_a_of_type_ArrayOfJavaLangObject[i] = null;
    this.jdField_a_of_type_Int = (i + 1 & this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1);
    return localObject;
  }
  
  public Object pollLast()
  {
    int i = this.b;
    i = this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1 & i - 1;
    Object localObject = this.jdField_a_of_type_ArrayOfJavaLangObject[i];
    if (localObject == null) {
      return null;
    }
    this.jdField_a_of_type_ArrayOfJavaLangObject[i] = null;
    this.b = i;
    return localObject;
  }
  
  public Object pop()
  {
    return removeFirst();
  }
  
  public void push(Object paramObject)
  {
    addFirst(paramObject);
  }
  
  public Object remove()
  {
    return removeFirst();
  }
  
  public boolean remove(Object paramObject)
  {
    return removeFirstOccurrence(paramObject);
  }
  
  public Object removeFirst()
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
    int j = this.jdField_a_of_type_ArrayOfJavaLangObject.length;
    for (int i = this.jdField_a_of_type_Int;; i = i + 1 & j - 1)
    {
      Object localObject = this.jdField_a_of_type_ArrayOfJavaLangObject[i];
      if (localObject == null) {
        break;
      }
      if (paramObject.equals(localObject))
      {
        a(i);
        return true;
      }
    }
    return false;
  }
  
  public Object removeLast()
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
    int j = this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1;
    for (int i = this.b - 1 & j;; i = i - 1 & j)
    {
      Object localObject = this.jdField_a_of_type_ArrayOfJavaLangObject[i];
      if (localObject == null) {
        break;
      }
      if (paramObject.equals(localObject))
      {
        a(i);
        return true;
      }
    }
    return false;
  }
  
  public int size()
  {
    return this.b - this.jdField_a_of_type_Int & this.jdField_a_of_type_ArrayOfJavaLangObject.length - 1;
  }
  
  public Object[] toArray()
  {
    return a(new Object[size()]);
  }
  
  public Object[] toArray(Object[] paramArrayOfObject)
  {
    int i = size();
    if (paramArrayOfObject.length < i) {
      paramArrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), i);
    }
    for (;;)
    {
      a(paramArrayOfObject);
      if (paramArrayOfObject.length > i) {
        paramArrayOfObject[i] = null;
      }
      return paramArrayOfObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.internel.ArrayDeque
 * JD-Core Version:    0.7.0.1
 */