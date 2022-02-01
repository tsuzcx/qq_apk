package com.google.zxing.common;

public final class BitArray
{
  private int[] a = new int[1];
  private int b = 0;
  
  private void b(int paramInt)
  {
    if (paramInt > this.a.length << 5)
    {
      int[] arrayOfInt1 = c(paramInt);
      int[] arrayOfInt2 = this.a;
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, arrayOfInt2.length);
      this.a = arrayOfInt1;
    }
  }
  
  private static int[] c(int paramInt)
  {
    return new int[paramInt + 31 >> 5];
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 0) && (paramInt2 <= 32))
    {
      b(this.b + paramInt2);
      while (paramInt2 > 0)
      {
        boolean bool = true;
        if ((paramInt1 >> paramInt2 - 1 & 0x1) != 1) {
          bool = false;
        }
        a(bool);
        paramInt2 -= 1;
      }
      return;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Num bits must be between 0 and 32");
    for (;;)
    {
      throw localIllegalArgumentException;
    }
  }
  
  public void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      int j = 0;
      int m;
      for (int k = 0; j < 8; k = m)
      {
        m = k;
        if (a(paramInt1)) {
          m = k | 1 << 7 - j;
        }
        paramInt1 += 1;
        j += 1;
      }
      paramArrayOfByte[(paramInt2 + i)] = ((byte)k);
      i += 1;
    }
  }
  
  public void a(BitArray paramBitArray)
  {
    int j = paramBitArray.b;
    b(this.b + j);
    int i = 0;
    while (i < j)
    {
      a(paramBitArray.a(i));
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b(this.b + 1);
    if (paramBoolean)
    {
      int[] arrayOfInt = this.a;
      int i = this.b;
      int j = i >> 5;
      arrayOfInt[j] = (1 << (i & 0x1F) | arrayOfInt[j]);
    }
    this.b += 1;
  }
  
  public boolean a(int paramInt)
  {
    return (1 << (paramInt & 0x1F) & this.a[(paramInt >> 5)]) != 0;
  }
  
  public int b()
  {
    return this.b + 7 >> 3;
  }
  
  public void b(BitArray paramBitArray)
  {
    if (this.a.length == paramBitArray.a.length)
    {
      int i = 0;
      for (;;)
      {
        int[] arrayOfInt = this.a;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] ^= paramBitArray.a[i];
        i += 1;
      }
      return;
    }
    paramBitArray = new IllegalArgumentException("Sizes don't match");
    for (;;)
    {
      throw paramBitArray;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.b);
    int i = 0;
    while (i < this.b)
    {
      if ((i & 0x7) == 0) {
        localStringBuilder.append(' ');
      }
      char c;
      if (a(i)) {
        c = 'X';
      } else {
        c = '.';
      }
      localStringBuilder.append(c);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.zxing.common.BitArray
 * JD-Core Version:    0.7.0.1
 */