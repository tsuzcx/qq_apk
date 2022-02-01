package com.google.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList
  extends AbstractList<String>
  implements LazyStringList, RandomAccess
{
  private final LazyStringList a;
  
  public UnmodifiableLazyStringList(LazyStringList paramLazyStringList)
  {
    this.a = paramLazyStringList;
  }
  
  public String a(int paramInt)
  {
    return (String)this.a.get(paramInt);
  }
  
  public void a(ByteString paramByteString)
  {
    throw new UnsupportedOperationException();
  }
  
  public Object d(int paramInt)
  {
    return this.a.d(paramInt);
  }
  
  public List<?> d()
  {
    return this.a.d();
  }
  
  public LazyStringList e()
  {
    return this;
  }
  
  public ByteString f(int paramInt)
  {
    return this.a.f(paramInt);
  }
  
  public Iterator<String> iterator()
  {
    return new UnmodifiableLazyStringList.2(this);
  }
  
  public ListIterator<String> listIterator(int paramInt)
  {
    return new UnmodifiableLazyStringList.1(this, paramInt);
  }
  
  public int size()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.UnmodifiableLazyStringList
 * JD-Core Version:    0.7.0.1
 */