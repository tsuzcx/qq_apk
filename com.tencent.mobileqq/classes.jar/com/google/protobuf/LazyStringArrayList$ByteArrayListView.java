package com.google.protobuf;

import java.util.AbstractList;
import java.util.RandomAccess;

class LazyStringArrayList$ByteArrayListView
  extends AbstractList<byte[]>
  implements RandomAccess
{
  private final LazyStringArrayList a;
  
  public byte[] a(int paramInt)
  {
    return this.a.g(paramInt);
  }
  
  public byte[] a(int paramInt, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = LazyStringArrayList.a(this.a, paramInt, paramArrayOfByte);
    this.modCount += 1;
    return LazyStringArrayList.a(paramArrayOfByte);
  }
  
  public void b(int paramInt, byte[] paramArrayOfByte)
  {
    LazyStringArrayList.b(this.a, paramInt, paramArrayOfByte);
    this.modCount += 1;
  }
  
  public byte[] b(int paramInt)
  {
    String str = this.a.c(paramInt);
    this.modCount += 1;
    return LazyStringArrayList.a(str);
  }
  
  public int size()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.LazyStringArrayList.ByteArrayListView
 * JD-Core Version:    0.7.0.1
 */