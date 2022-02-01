package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class IntArrayList
  extends AbstractProtobufList<Integer>
  implements Internal.IntList, PrimitiveNonBoxingCollection, RandomAccess
{
  private static final IntArrayList a = new IntArrayList(new int[0], 0);
  private int[] b;
  private int c;
  
  static
  {
    a.b();
  }
  
  IntArrayList()
  {
    this(new int[10], 0);
  }
  
  private IntArrayList(int[] paramArrayOfInt, int paramInt)
  {
    this.b = paramArrayOfInt;
    this.c = paramInt;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    c();
    if (paramInt1 >= 0)
    {
      int i = this.c;
      if (paramInt1 <= i)
      {
        int[] arrayOfInt1 = this.b;
        if (i < arrayOfInt1.length)
        {
          System.arraycopy(arrayOfInt1, paramInt1, arrayOfInt1, paramInt1 + 1, i - paramInt1);
        }
        else
        {
          int[] arrayOfInt2 = new int[i * 3 / 2 + 1];
          System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, paramInt1);
          System.arraycopy(this.b, paramInt1, arrayOfInt2, paramInt1 + 1, this.c - paramInt1);
          this.b = arrayOfInt2;
        }
        this.b[paramInt1] = paramInt2;
        this.c += 1;
        this.modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(h(paramInt1));
  }
  
  public static IntArrayList d()
  {
    return a;
  }
  
  private void g(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.c)) {
      return;
    }
    throw new IndexOutOfBoundsException(h(paramInt));
  }
  
  private String h(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Index:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", Size:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    c();
    g(paramInt1);
    int[] arrayOfInt = this.b;
    int i = arrayOfInt[paramInt1];
    arrayOfInt[paramInt1] = paramInt2;
    return i;
  }
  
  public Internal.IntList a(int paramInt)
  {
    if (paramInt >= this.c) {
      return new IntArrayList(Arrays.copyOf(this.b, paramInt), this.c);
    }
    throw new IllegalArgumentException();
  }
  
  public Integer a(int paramInt, Integer paramInteger)
  {
    return Integer.valueOf(a(paramInt, paramInteger.intValue()));
  }
  
  public boolean addAll(Collection<? extends Integer> paramCollection)
  {
    c();
    Internal.a(paramCollection);
    if (!(paramCollection instanceof IntArrayList)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (IntArrayList)paramCollection;
    int i = paramCollection.c;
    if (i == 0) {
      return false;
    }
    int j = this.c;
    if (2147483647 - j >= i)
    {
      i = j + i;
      int[] arrayOfInt = this.b;
      if (i > arrayOfInt.length) {
        this.b = Arrays.copyOf(arrayOfInt, i);
      }
      System.arraycopy(paramCollection.b, 0, this.b, this.c, paramCollection.c);
      this.c = i;
      this.modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public Integer b(int paramInt)
  {
    return Integer.valueOf(c(paramInt));
  }
  
  public void b(int paramInt, Integer paramInteger)
  {
    b(paramInt, paramInteger.intValue());
  }
  
  public int c(int paramInt)
  {
    g(paramInt);
    return this.b[paramInt];
  }
  
  public void d(int paramInt)
  {
    b(this.c, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof IntArrayList)) {
      return super.equals(paramObject);
    }
    paramObject = (IntArrayList)paramObject;
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
  
  public Integer f(int paramInt)
  {
    c();
    g(paramInt);
    int[] arrayOfInt = this.b;
    int i = arrayOfInt[paramInt];
    int j = this.c;
    if (paramInt < j - 1) {
      System.arraycopy(arrayOfInt, paramInt + 1, arrayOfInt, paramInt, j - paramInt - 1);
    }
    this.c -= 1;
    this.modCount += 1;
    return Integer.valueOf(i);
  }
  
  public int hashCode()
  {
    int j = 1;
    int i = 0;
    while (i < this.c)
    {
      j = j * 31 + this.b[i];
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
      if (paramObject.equals(Integer.valueOf(this.b[i])))
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
      int[] arrayOfInt = this.b;
      System.arraycopy(arrayOfInt, paramInt2, arrayOfInt, paramInt1, this.c - paramInt2);
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
 * Qualified Name:     com.google.protobuf.IntArrayList
 * JD-Core Version:    0.7.0.1
 */