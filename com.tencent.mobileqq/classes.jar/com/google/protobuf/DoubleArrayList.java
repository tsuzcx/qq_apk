package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class DoubleArrayList
  extends AbstractProtobufList<Double>
  implements Internal.DoubleList, PrimitiveNonBoxingCollection, RandomAccess
{
  private static final DoubleArrayList a = new DoubleArrayList(new double[0], 0);
  private double[] b;
  private int c;
  
  static
  {
    a.b();
  }
  
  DoubleArrayList()
  {
    this(new double[10], 0);
  }
  
  private DoubleArrayList(double[] paramArrayOfDouble, int paramInt)
  {
    this.b = paramArrayOfDouble;
    this.c = paramInt;
  }
  
  private void b(int paramInt, double paramDouble)
  {
    c();
    if (paramInt >= 0)
    {
      int i = this.c;
      if (paramInt <= i)
      {
        double[] arrayOfDouble1 = this.b;
        if (i < arrayOfDouble1.length)
        {
          System.arraycopy(arrayOfDouble1, paramInt, arrayOfDouble1, paramInt + 1, i - paramInt);
        }
        else
        {
          double[] arrayOfDouble2 = new double[i * 3 / 2 + 1];
          System.arraycopy(arrayOfDouble1, 0, arrayOfDouble2, 0, paramInt);
          System.arraycopy(this.b, paramInt, arrayOfDouble2, paramInt + 1, this.c - paramInt);
          this.b = arrayOfDouble2;
        }
        this.b[paramInt] = paramDouble;
        this.c += 1;
        this.modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(g(paramInt));
  }
  
  public static DoubleArrayList d()
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
  
  public double a(int paramInt, double paramDouble)
  {
    c();
    f(paramInt);
    double[] arrayOfDouble = this.b;
    double d = arrayOfDouble[paramInt];
    arrayOfDouble[paramInt] = paramDouble;
    return d;
  }
  
  public Internal.DoubleList a(int paramInt)
  {
    if (paramInt >= this.c) {
      return new DoubleArrayList(Arrays.copyOf(this.b, paramInt), this.c);
    }
    throw new IllegalArgumentException();
  }
  
  public Double a(int paramInt, Double paramDouble)
  {
    return Double.valueOf(a(paramInt, paramDouble.doubleValue()));
  }
  
  public void a(double paramDouble)
  {
    b(this.c, paramDouble);
  }
  
  public boolean addAll(Collection<? extends Double> paramCollection)
  {
    c();
    Internal.a(paramCollection);
    if (!(paramCollection instanceof DoubleArrayList)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (DoubleArrayList)paramCollection;
    int i = paramCollection.c;
    if (i == 0) {
      return false;
    }
    int j = this.c;
    if (2147483647 - j >= i)
    {
      i = j + i;
      double[] arrayOfDouble = this.b;
      if (i > arrayOfDouble.length) {
        this.b = Arrays.copyOf(arrayOfDouble, i);
      }
      System.arraycopy(paramCollection.b, 0, this.b, this.c, paramCollection.c);
      this.c = i;
      this.modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public Double b(int paramInt)
  {
    return Double.valueOf(c(paramInt));
  }
  
  public void b(int paramInt, Double paramDouble)
  {
    b(paramInt, paramDouble.doubleValue());
  }
  
  public double c(int paramInt)
  {
    f(paramInt);
    return this.b[paramInt];
  }
  
  public Double d(int paramInt)
  {
    c();
    f(paramInt);
    double[] arrayOfDouble = this.b;
    double d = arrayOfDouble[paramInt];
    int i = this.c;
    if (paramInt < i - 1) {
      System.arraycopy(arrayOfDouble, paramInt + 1, arrayOfDouble, paramInt, i - paramInt - 1);
    }
    this.c -= 1;
    this.modCount += 1;
    return Double.valueOf(d);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof DoubleArrayList)) {
      return super.equals(paramObject);
    }
    paramObject = (DoubleArrayList)paramObject;
    if (this.c != paramObject.c) {
      return false;
    }
    paramObject = paramObject.b;
    int i = 0;
    while (i < this.c)
    {
      if (Double.doubleToLongBits(this.b[i]) != Double.doubleToLongBits(paramObject[i])) {
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
      j = j * 31 + Internal.a(Double.doubleToLongBits(this.b[i]));
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
      if (paramObject.equals(Double.valueOf(this.b[i])))
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
      double[] arrayOfDouble = this.b;
      System.arraycopy(arrayOfDouble, paramInt2, arrayOfDouble, paramInt1, this.c - paramInt2);
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
 * Qualified Name:     com.google.protobuf.DoubleArrayList
 * JD-Core Version:    0.7.0.1
 */