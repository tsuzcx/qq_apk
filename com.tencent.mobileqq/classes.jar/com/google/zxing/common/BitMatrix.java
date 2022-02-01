package com.google.zxing.common;

public final class BitMatrix
{
  private final int a;
  private final int b;
  private final int c;
  private final int[] d;
  
  public BitMatrix(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 1) && (paramInt2 >= 1))
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = (paramInt1 + 31 >> 5);
      this.d = new int[this.c * paramInt2];
      return;
    }
    throw new IllegalArgumentException("Both dimensions must be greater than 0");
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 >= 0) && (paramInt1 >= 0))
    {
      if ((paramInt4 >= 1) && (paramInt3 >= 1))
      {
        int i = paramInt3 + paramInt1;
        paramInt4 += paramInt2;
        if ((paramInt4 <= this.b) && (i <= this.a))
        {
          while (paramInt2 < paramInt4)
          {
            int j = this.c;
            paramInt3 = paramInt1;
            while (paramInt3 < i)
            {
              localObject = this.d;
              int k = (paramInt3 >> 5) + j * paramInt2;
              localObject[k] |= 1 << (paramInt3 & 0x1F);
              paramInt3 += 1;
            }
            paramInt2 += 1;
          }
          return;
        }
        throw new IllegalArgumentException("The region must fit inside the matrix");
      }
      throw new IllegalArgumentException("Height and width must be at least 1");
    }
    Object localObject = new IllegalArgumentException("Left and top must be nonnegative");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    int i = this.c;
    return (this.d[(paramInt2 * i + (paramInt1 >> 5))] >>> (paramInt1 & 0x1F) & 0x1) != 0;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof BitMatrix)) {
      return false;
    }
    paramObject = (BitMatrix)paramObject;
    if ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c))
    {
      if (this.d.length != paramObject.d.length) {
        return false;
      }
      int i = 0;
      for (;;)
      {
        int[] arrayOfInt = this.d;
        if (i >= arrayOfInt.length) {
          break;
        }
        if (arrayOfInt[i] != paramObject.d[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = this.a;
    int j = ((i * 31 + i) * 31 + this.b) * 31 + this.c;
    int[] arrayOfInt = this.d;
    int k = arrayOfInt.length;
    i = 0;
    while (i < k)
    {
      j = j * 31 + arrayOfInt[i];
      i += 1;
    }
    return j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.b * (this.a + 1));
    int i = 0;
    while (i < this.b)
    {
      int j = 0;
      while (j < this.a)
      {
        String str;
        if (a(j, i)) {
          str = "X ";
        } else {
          str = "  ";
        }
        localStringBuilder.append(str);
        j += 1;
      }
      localStringBuilder.append('\n');
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.zxing.common.BitMatrix
 * JD-Core Version:    0.7.0.1
 */