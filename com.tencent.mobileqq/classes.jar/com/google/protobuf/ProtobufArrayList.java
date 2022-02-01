package com.google.protobuf;

import java.util.ArrayList;
import java.util.List;

final class ProtobufArrayList<E>
  extends AbstractProtobufList<E>
{
  private static final ProtobufArrayList<Object> a = new ProtobufArrayList(new ArrayList(0));
  private final List<E> b;
  
  static
  {
    a.b();
  }
  
  ProtobufArrayList()
  {
    this(new ArrayList(10));
  }
  
  private ProtobufArrayList(List<E> paramList)
  {
    this.b = paramList;
  }
  
  public ProtobufArrayList<E> a(int paramInt)
  {
    if (paramInt >= size())
    {
      ArrayList localArrayList = new ArrayList(paramInt);
      localArrayList.addAll(this.b);
      return new ProtobufArrayList(localArrayList);
    }
    throw new IllegalArgumentException();
  }
  
  public void add(int paramInt, E paramE)
  {
    c();
    this.b.add(paramInt, paramE);
    this.modCount += 1;
  }
  
  public E get(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public E remove(int paramInt)
  {
    c();
    Object localObject = this.b.remove(paramInt);
    this.modCount += 1;
    return localObject;
  }
  
  public E set(int paramInt, E paramE)
  {
    c();
    paramE = this.b.set(paramInt, paramE);
    this.modCount += 1;
    return paramE;
  }
  
  public int size()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ProtobufArrayList
 * JD-Core Version:    0.7.0.1
 */