package com.google.protobuf;

import java.util.AbstractList;
import java.util.List;

public class Internal$ListAdapter<F, T>
  extends AbstractList<T>
{
  private final List<F> a;
  private final Internal.ListAdapter.Converter<F, T> b;
  
  public T get(int paramInt)
  {
    return this.b.a(this.a.get(paramInt));
  }
  
  public int size()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Internal.ListAdapter
 * JD-Core Version:    0.7.0.1
 */