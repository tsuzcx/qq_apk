package com.google.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class AbstractProtobufList<E>
  extends AbstractList<E>
  implements Internal.ProtobufList<E>
{
  private boolean a = true;
  
  public boolean a()
  {
    return this.a;
  }
  
  public void add(int paramInt, E paramE)
  {
    c();
    super.add(paramInt, paramE);
  }
  
  public boolean add(E paramE)
  {
    c();
    return super.add(paramE);
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    c();
    return super.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    c();
    return super.addAll(paramCollection);
  }
  
  public final void b()
  {
    this.a = false;
  }
  
  protected void c()
  {
    if (this.a) {
      return;
    }
    throw new UnsupportedOperationException();
  }
  
  public void clear()
  {
    c();
    super.clear();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof List)) {
      return false;
    }
    if (!(paramObject instanceof RandomAccess)) {
      return super.equals(paramObject);
    }
    paramObject = (List)paramObject;
    int j = size();
    if (j != paramObject.size()) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      if (!get(i).equals(paramObject.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int hashCode()
  {
    int k = size();
    int j = 1;
    int i = 0;
    while (i < k)
    {
      j = j * 31 + get(i).hashCode();
      i += 1;
    }
    return j;
  }
  
  public E remove(int paramInt)
  {
    c();
    return super.remove(paramInt);
  }
  
  public boolean remove(Object paramObject)
  {
    c();
    return super.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    c();
    return super.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    c();
    return super.retainAll(paramCollection);
  }
  
  public E set(int paramInt, E paramE)
  {
    c();
    return super.set(paramInt, paramE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.AbstractProtobufList
 * JD-Core Version:    0.7.0.1
 */