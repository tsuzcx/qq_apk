package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class BooleanArrayList
  extends AbstractProtobufList<Boolean>
  implements Internal.BooleanList, PrimitiveNonBoxingCollection, RandomAccess
{
  private static final BooleanArrayList a = new BooleanArrayList(new boolean[0], 0);
  private boolean[] b;
  private int c;
  
  static
  {
    a.b();
  }
  
  BooleanArrayList()
  {
    this(new boolean[10], 0);
  }
  
  private BooleanArrayList(boolean[] paramArrayOfBoolean, int paramInt)
  {
    this.b = paramArrayOfBoolean;
    this.c = paramInt;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    c();
    if (paramInt >= 0)
    {
      int i = this.c;
      if (paramInt <= i)
      {
        boolean[] arrayOfBoolean1 = this.b;
        if (i < arrayOfBoolean1.length)
        {
          System.arraycopy(arrayOfBoolean1, paramInt, arrayOfBoolean1, paramInt + 1, i - paramInt);
        }
        else
        {
          boolean[] arrayOfBoolean2 = new boolean[i * 3 / 2 + 1];
          System.arraycopy(arrayOfBoolean1, 0, arrayOfBoolean2, 0, paramInt);
          System.arraycopy(this.b, paramInt, arrayOfBoolean2, paramInt + 1, this.c - paramInt);
          this.b = arrayOfBoolean2;
        }
        this.b[paramInt] = paramBoolean;
        this.c += 1;
        this.modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(g(paramInt));
  }
  
  public static BooleanArrayList d()
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
  
  public Internal.BooleanList a(int paramInt)
  {
    if (paramInt >= this.c) {
      return new BooleanArrayList(Arrays.copyOf(this.b, paramInt), this.c);
    }
    throw new IllegalArgumentException();
  }
  
  public Boolean a(int paramInt, Boolean paramBoolean)
  {
    return Boolean.valueOf(a(paramInt, paramBoolean.booleanValue()));
  }
  
  public void a(boolean paramBoolean)
  {
    b(this.c, paramBoolean);
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    c();
    f(paramInt);
    boolean[] arrayOfBoolean = this.b;
    int i = arrayOfBoolean[paramInt];
    arrayOfBoolean[paramInt] = paramBoolean;
    return i;
  }
  
  public boolean addAll(Collection<? extends Boolean> paramCollection)
  {
    c();
    Internal.a(paramCollection);
    if (!(paramCollection instanceof BooleanArrayList)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (BooleanArrayList)paramCollection;
    int i = paramCollection.c;
    if (i == 0) {
      return false;
    }
    int j = this.c;
    if (2147483647 - j >= i)
    {
      i = j + i;
      boolean[] arrayOfBoolean = this.b;
      if (i > arrayOfBoolean.length) {
        this.b = Arrays.copyOf(arrayOfBoolean, i);
      }
      System.arraycopy(paramCollection.b, 0, this.b, this.c, paramCollection.c);
      this.c = i;
      this.modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public Boolean b(int paramInt)
  {
    return Boolean.valueOf(c(paramInt));
  }
  
  public void b(int paramInt, Boolean paramBoolean)
  {
    b(paramInt, paramBoolean.booleanValue());
  }
  
  public boolean c(int paramInt)
  {
    f(paramInt);
    return this.b[paramInt];
  }
  
  public Boolean d(int paramInt)
  {
    c();
    f(paramInt);
    boolean[] arrayOfBoolean = this.b;
    int j = arrayOfBoolean[paramInt];
    int i = this.c;
    if (paramInt < i - 1) {
      System.arraycopy(arrayOfBoolean, paramInt + 1, arrayOfBoolean, paramInt, i - paramInt - 1);
    }
    this.c -= 1;
    this.modCount += 1;
    return Boolean.valueOf(j);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof BooleanArrayList)) {
      return super.equals(paramObject);
    }
    paramObject = (BooleanArrayList)paramObject;
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
      if (paramObject.equals(Boolean.valueOf(this.b[i])))
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
      boolean[] arrayOfBoolean = this.b;
      System.arraycopy(arrayOfBoolean, paramInt2, arrayOfBoolean, paramInt1, this.c - paramInt2);
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
 * Qualified Name:     com.google.protobuf.BooleanArrayList
 * JD-Core Version:    0.7.0.1
 */