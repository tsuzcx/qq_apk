package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class FloatArrayList
  extends AbstractProtobufList<Float>
  implements Internal.FloatList, PrimitiveNonBoxingCollection, RandomAccess
{
  private static final FloatArrayList a = new FloatArrayList(new float[0], 0);
  private float[] b;
  private int c;
  
  static
  {
    a.b();
  }
  
  FloatArrayList()
  {
    this(new float[10], 0);
  }
  
  private FloatArrayList(float[] paramArrayOfFloat, int paramInt)
  {
    this.b = paramArrayOfFloat;
    this.c = paramInt;
  }
  
  private void b(int paramInt, float paramFloat)
  {
    c();
    if (paramInt >= 0)
    {
      int i = this.c;
      if (paramInt <= i)
      {
        float[] arrayOfFloat1 = this.b;
        if (i < arrayOfFloat1.length)
        {
          System.arraycopy(arrayOfFloat1, paramInt, arrayOfFloat1, paramInt + 1, i - paramInt);
        }
        else
        {
          float[] arrayOfFloat2 = new float[i * 3 / 2 + 1];
          System.arraycopy(arrayOfFloat1, 0, arrayOfFloat2, 0, paramInt);
          System.arraycopy(this.b, paramInt, arrayOfFloat2, paramInt + 1, this.c - paramInt);
          this.b = arrayOfFloat2;
        }
        this.b[paramInt] = paramFloat;
        this.c += 1;
        this.modCount += 1;
        return;
      }
    }
    throw new IndexOutOfBoundsException(g(paramInt));
  }
  
  public static FloatArrayList d()
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
  
  public float a(int paramInt, float paramFloat)
  {
    c();
    f(paramInt);
    float[] arrayOfFloat = this.b;
    float f = arrayOfFloat[paramInt];
    arrayOfFloat[paramInt] = paramFloat;
    return f;
  }
  
  public Internal.FloatList a(int paramInt)
  {
    if (paramInt >= this.c) {
      return new FloatArrayList(Arrays.copyOf(this.b, paramInt), this.c);
    }
    throw new IllegalArgumentException();
  }
  
  public Float a(int paramInt, Float paramFloat)
  {
    return Float.valueOf(a(paramInt, paramFloat.floatValue()));
  }
  
  public void a(float paramFloat)
  {
    b(this.c, paramFloat);
  }
  
  public boolean addAll(Collection<? extends Float> paramCollection)
  {
    c();
    Internal.a(paramCollection);
    if (!(paramCollection instanceof FloatArrayList)) {
      return super.addAll(paramCollection);
    }
    paramCollection = (FloatArrayList)paramCollection;
    int i = paramCollection.c;
    if (i == 0) {
      return false;
    }
    int j = this.c;
    if (2147483647 - j >= i)
    {
      i = j + i;
      float[] arrayOfFloat = this.b;
      if (i > arrayOfFloat.length) {
        this.b = Arrays.copyOf(arrayOfFloat, i);
      }
      System.arraycopy(paramCollection.b, 0, this.b, this.c, paramCollection.c);
      this.c = i;
      this.modCount += 1;
      return true;
    }
    throw new OutOfMemoryError();
  }
  
  public Float b(int paramInt)
  {
    return Float.valueOf(c(paramInt));
  }
  
  public void b(int paramInt, Float paramFloat)
  {
    b(paramInt, paramFloat.floatValue());
  }
  
  public float c(int paramInt)
  {
    f(paramInt);
    return this.b[paramInt];
  }
  
  public Float d(int paramInt)
  {
    c();
    f(paramInt);
    float[] arrayOfFloat = this.b;
    float f = arrayOfFloat[paramInt];
    int i = this.c;
    if (paramInt < i - 1) {
      System.arraycopy(arrayOfFloat, paramInt + 1, arrayOfFloat, paramInt, i - paramInt - 1);
    }
    this.c -= 1;
    this.modCount += 1;
    return Float.valueOf(f);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof FloatArrayList)) {
      return super.equals(paramObject);
    }
    paramObject = (FloatArrayList)paramObject;
    if (this.c != paramObject.c) {
      return false;
    }
    paramObject = paramObject.b;
    int i = 0;
    while (i < this.c)
    {
      if (Float.floatToIntBits(this.b[i]) != Float.floatToIntBits(paramObject[i])) {
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
      j = j * 31 + Float.floatToIntBits(this.b[i]);
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
      if (paramObject.equals(Float.valueOf(this.b[i])))
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
      float[] arrayOfFloat = this.b;
      System.arraycopy(arrayOfFloat, paramInt2, arrayOfFloat, paramInt1, this.c - paramInt2);
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
 * Qualified Name:     com.google.protobuf.FloatArrayList
 * JD-Core Version:    0.7.0.1
 */