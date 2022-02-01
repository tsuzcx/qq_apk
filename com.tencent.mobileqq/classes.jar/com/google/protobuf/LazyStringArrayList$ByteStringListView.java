package com.google.protobuf;

import java.util.AbstractList;
import java.util.RandomAccess;

class LazyStringArrayList$ByteStringListView
  extends AbstractList<ByteString>
  implements RandomAccess
{
  private final LazyStringArrayList a;
  
  public ByteString a(int paramInt)
  {
    return this.a.f(paramInt);
  }
  
  public ByteString a(int paramInt, ByteString paramByteString)
  {
    paramByteString = LazyStringArrayList.a(this.a, paramInt, paramByteString);
    this.modCount += 1;
    return LazyStringArrayList.b(paramByteString);
  }
  
  public ByteString b(int paramInt)
  {
    String str = this.a.c(paramInt);
    this.modCount += 1;
    return LazyStringArrayList.b(str);
  }
  
  public void b(int paramInt, ByteString paramByteString)
  {
    LazyStringArrayList.b(this.a, paramInt, paramByteString);
    this.modCount += 1;
  }
  
  public int size()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.LazyStringArrayList.ByteStringListView
 * JD-Core Version:    0.7.0.1
 */