package com.tencent.biz.qqcircle.publish.model;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class DynamicArrayList<E>
  extends ArrayList<E>
  implements DoListWriteInterface<E>
{
  private OnListWriteListener<E> mListener;
  
  public DynamicArrayList() {}
  
  public DynamicArrayList(int paramInt)
  {
    super(paramInt);
  }
  
  public DynamicArrayList(Collection<? extends E> paramCollection)
  {
    super(paramCollection);
  }
  
  public void add(int paramInt, E paramE)
  {
    OnListWriteListener localOnListWriteListener = this.mListener;
    if (localOnListWriteListener != null) {
      localOnListWriteListener.a(paramInt, paramE);
    }
    super.add(paramInt, paramE);
  }
  
  public boolean add(E paramE)
  {
    OnListWriteListener localOnListWriteListener = this.mListener;
    if (localOnListWriteListener != null) {
      localOnListWriteListener.a(paramE);
    }
    return super.add(paramE);
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    OnListWriteListener localOnListWriteListener = this.mListener;
    if (localOnListWriteListener != null) {
      localOnListWriteListener.a(paramInt, paramCollection);
    }
    return super.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    OnListWriteListener localOnListWriteListener = this.mListener;
    if (localOnListWriteListener != null) {
      localOnListWriteListener.a(paramCollection);
    }
    return super.addAll(paramCollection);
  }
  
  public void clear()
  {
    OnListWriteListener localOnListWriteListener = this.mListener;
    if (localOnListWriteListener != null) {
      localOnListWriteListener.a();
    }
    super.clear();
  }
  
  public E doRemove(int paramInt)
  {
    return super.remove(paramInt);
  }
  
  public E doSet(int paramInt, E paramE)
  {
    return super.set(paramInt, paramE);
  }
  
  @NonNull
  public Iterator<E> iterator()
  {
    return new DynamicArrayList.DelegateIterator(this, super.iterator(), null);
  }
  
  @NonNull
  public ListIterator<E> listIterator()
  {
    throw new UnsupportedOperationException();
  }
  
  @NonNull
  public ListIterator<E> listIterator(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public E remove(int paramInt)
  {
    OnListWriteListener localOnListWriteListener = this.mListener;
    if (localOnListWriteListener != null) {
      localOnListWriteListener.a(paramInt);
    }
    return super.remove(paramInt);
  }
  
  public boolean remove(Object paramObject)
  {
    OnListWriteListener localOnListWriteListener = this.mListener;
    if (localOnListWriteListener != null) {
      localOnListWriteListener.b(paramObject);
    }
    return super.remove(paramObject);
  }
  
  public E set(int paramInt, E paramE)
  {
    OnListWriteListener localOnListWriteListener = this.mListener;
    if (localOnListWriteListener != null) {
      localOnListWriteListener.b(paramInt, paramE);
    }
    return super.set(paramInt, paramE);
  }
  
  public void setOnListWriteListener(OnListWriteListener<E> paramOnListWriteListener)
  {
    this.mListener = paramOnListWriteListener;
    if (paramOnListWriteListener != null) {
      paramOnListWriteListener.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.model.DynamicArrayList
 * JD-Core Version:    0.7.0.1
 */