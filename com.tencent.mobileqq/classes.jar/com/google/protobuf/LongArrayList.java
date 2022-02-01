package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class LongArrayList
  extends AbstractProtobufList<Long>
  implements Internal.LongList, PrimitiveNonBoxingCollection, RandomAccess
{
  private static final LongArrayList a = new LongArrayList(new long[0], 0);
  private long[] b;
  private int c;
  
  static
  {
    a.b();
  }
  
  LongArrayList()
  {
    this(new long[10], 0);
  }
  
  private LongArrayList(long[] paramArrayOfLong, int paramInt)
  {
    this.b = paramArrayOfLong;
    this.c = paramInt;
  }
  
  private void b(int paramInt, long paramLong)
  {
    c();
    if (paramInt >= 0)
    {
      int i = this.c;
      if (paramInt <= i)
      {
        long[] arrayOfLong1 = this.b;
        if (i < arrayOfLong1.length)
        {
          System.arraycopy(arrayOfLong1, paramInt, arrayOfLong1, paramInt + 1, i - paramInt);
        }
        else
        {
          long[] arrayOfLong2 = new long[i * 3 / 2 + 1];
          System.arraycopy(arrayOfLong1, 0, arrayOfLong2, 0, paramInt);
          System.arraycopy(this.b, paramInt, arrayOfLong2, paramInt + 1, this.c - paramInt);
          this.b = arrayOfLong2;
        }
        this.b[paramInt] = paramLong;
        this.c += 1;
        this.modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(g(paramInt));
  }
  
  public static LongArrayList d()
  {
    return a;
  }
  
  private void f(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.c)) {
      return;
    }
    throw new IndexOutOfBoundsException(g(paramInt));
  }
  
  private String g(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Index:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", Size:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
  
  public long a(int paramInt, long paramLong)
  {
    c();
    f(paramInt);
    long[] arrayOfLong = this.b;
    long l = arrayOfLong[paramInt];
    arrayOfLong[paramInt] = paramLong;
    return l;
  }
  
  public Internal.LongList a(int paramInt)
  {
    if (paramInt >= this.c) {
      return new LongArrayList(Arrays.copyOf(this.b, paramInt), this.c);
    }
    throw new IllegalArgumentException();
  }
  
  public Long a(int paramInt, Long paramLong)
  {
    return Long.valueOf(a(paramInt, paramLong.longValue()));
  }
  
  public void a(long paramLong)
  {
    b(this.c, paramLong);
  }
  
  public boolean addAll(Collection<? extends Long> paramCollection)
  {
    c();
    Internal.a(paramCollection);
    if (!(paramCollection instanceof LongArrayList)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (LongArrayList)paramCollection;
    int i = paramCollection.c;
    if (i == 0) {
      return false;
    }
    int j = this.c;
    if (2147483647 - j >= i)
    {
      i = j + i;
      long[] arrayOfLong = this.b;
      if (i > arrayOfLong.length) {
        this.b = Arrays.copyOf(arrayOfLong, i);
      }
      System.arraycopy(paramCollection.b, 0, this.b, this.c, paramCollection.c);
      this.c = i;
      this.modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public Long b(int paramInt)
  {
    return Long.valueOf(c(paramInt));
  }
  
  public void b(int paramInt, Long paramLong)
  {
    b(paramInt, paramLong.longValue());
  }
  
  public long c(int paramInt)
  {
    f(paramInt);
    return this.b[paramInt];
  }
  
  public Long d(int paramInt)
  {
    c();
    f(paramInt);
    long[] arrayOfLong = this.b;
    long l = arrayOfLong[paramInt];
    int i = this.c;
    if (paramInt < i - 1) {
      System.arraycopy(arrayOfLong, paramInt + 1, arrayOfLong, paramInt, i - paramInt - 1);
    }
    this.c -= 1;
    this.modCount += 1;
    return Long.valueOf(l);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof LongArrayList)) {
      return super.equals(paramObject);
    }
    paramObject = (LongArrayList)paramObject;
    if (this.c != paramObject.c) {
      return false;
    }
    paramObject = paramObject.b;
    int i = 0;
    while (i < this.c)
    {
      if (this.b[i] != paramObject[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < this.c)
    {
      j = j * 31 + Internal.a(this.b[i]);
      i += 1;
    }
    return j;
  }
  
  public boolean remove(Object paramObject)
  {
    c();
    int i = 0;
    while (i < this.c)
    {
      if (paramObject.equals(Long.valueOf(this.b[i])))
      {
        paramObject = this.b;
        System.arraycopy(paramObject, i + 1, paramObject, i, this.c - i - 1);
        this.c -= 1;
        this.modCount += 1;
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  protected void removeRange(int paramInt1, int paramInt2)
  {
    c();
    if (paramInt2 >= paramInt1)
    {
      long[] arrayOfLong = this.b;
      System.arraycopy(arrayOfLong, paramInt2, arrayOfLong, paramInt1, this.c - paramInt2);
      this.c -= paramInt2 - paramInt1;
      this.modCount += 1;
      return;
    }
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public int size()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.LongArrayList
 * JD-Core Version:    0.7.0.1
 */