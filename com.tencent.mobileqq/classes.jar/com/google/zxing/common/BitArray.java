package com.google.zxing.common;

public final class BitArray
{
  private int jdField_a_of_type_Int = 0;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  
  private void a(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_ArrayOfInt.length << 5)
    {
      int[] arrayOfInt1 = a(paramInt);
      int[] arrayOfInt2 = this.jdField_a_of_type_ArrayOfInt;
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, arrayOfInt2.length);
      this.jdField_a_of_type_ArrayOfInt = arrayOfInt1;
    }
  }
  
  private static int[] a(int paramInt)
  {
    return new int[paramInt + 31 >> 5];
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 0) && (paramInt2 <= 32))
    {
      a(this.jdField_a_of_type_Int + paramInt2);
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
    int j = paramBitArray.jdField_a_of_type_Int;
    a(this.jdField_a_of_type_Int + j);
    int i = 0;
    while (i < j)
    {
      a(paramBitArray.a(i));
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(this.jdField_a_of_type_Int + 1);
    if (paramBoolean)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      int i = this.jdField_a_of_type_Int;
      int j = i >> 5;
      arrayOfInt[j] = (1 << (i & 0x1F) | arrayOfInt[j]);
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  public boolean a(int paramInt)
  {
    return (1 << (paramInt & 0x1F) & this.jdField_a_of_type_ArrayOfInt[(paramInt >> 5)]) != 0;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int + 7 >> 3;
  }
  
  public void b(BitArray paramBitArray)
  {
    if (this.jdField_a_of_type_ArrayOfInt.length == paramBitArray.jdField_a_of_type_ArrayOfInt.length)
    {
      int i = 0;
      for (;;)
      {
        int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] ^= paramBitArray.jdField_a_of_type_ArrayOfInt[i];
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
    StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_Int);
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.zxing.common.BitArray
 * JD-Core Version:    0.7.0.1
 */