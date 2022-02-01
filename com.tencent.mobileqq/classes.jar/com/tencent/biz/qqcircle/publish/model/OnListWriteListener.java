package com.tencent.biz.qqcircle.publish.model;

import java.util.Collection;

public abstract interface OnListWriteListener<E>
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, E paramE);
  
  public abstract void a(int paramInt, Collection<? extends E> paramCollection);
  
  public abstract void a(DoListWriteInterface<E> paramDoListWriteInterface);
  
  public abstract void a(E paramE);
  
  public abstract void a(Collection<? extends E> paramCollection);
  
  public abstract void b(int paramInt, E paramE);
  
  public abstract void b(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.model.OnListWriteListener
 * JD-Core Version:    0.7.0.1
 */