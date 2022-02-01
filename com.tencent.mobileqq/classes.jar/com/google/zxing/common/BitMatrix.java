package com.google.zxing.common;

public final class BitMatrix
{
  private final int jdField_a_of_type_Int;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private final int b;
  private final int c;
  
  public BitMatrix(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 1) || (paramInt2 < 1)) {
      throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = (paramInt1 + 31 >> 5);
    this.jdField_a_of_type_ArrayOfInt = new int[this.c * paramInt2];
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < 0) || (paramInt1 < 0)) {
      throw new IllegalArgumentException("Left and top must be nonnegative");
    }
    if ((paramInt4 < 1) || (paramInt3 < 1)) {
      throw new IllegalArgumentException("Height and width must be at least 1");
    }
    int i = paramInt1 + paramInt3;
    paramInt4 = paramInt2 + paramInt4;
    if ((paramInt4 > this.b) || (i > this.jdField_a_of_type_Int)) {
      throw new IllegalArgumentException("The region must fit inside the matrix");
    }
    for (;;)
    {
      paramInt2 += 1;
      if (paramInt2 >= paramInt4) {
        break;
      }
      int j = this.c;
      paramInt3 = paramInt1;
      while (paramInt3 < i)
      {
        int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
        int k = (paramInt3 >> 5) + paramInt2 * j;
        arrayOfInt[k] |= 1 << (paramInt3 & 0x1F);
        paramInt3 += 1;
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    int i = this.c;
    return (this.jdField_a_of_type_ArrayOfInt[(i * paramInt2 + (paramInt1 >> 5))] >>> (paramInt1 & 0x1F) & 0x1) != 0;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof BitMatrix)) {}
    do
    {
      return false;
      paramObject = (BitMatrix)paramObject;
    } while ((this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (this.b != paramObject.b) || (this.c != paramObject.c) || (this.jdField_a_of_type_ArrayOfInt.length != paramObject.jdField_a_of_type_ArrayOfInt.length));
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_ArrayOfInt.length) {
        break label93;
      }
      if (this.jdField_a_of_type_ArrayOfInt[i] != paramObject.jdField_a_of_type_ArrayOfInt[i]) {
        break;
      }
      i += 1;
    }
    label93:
    return true;
  }
  
  public int hashCode()
  {
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_Int;
    int k = this.b;
    j = this.c + ((i * 31 + j) * 31 + k) * 31;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    k = arrayOfInt.length;
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
    StringBuilder localStringBuilder = new StringBuilder(this.b * (this.jdField_a_of_type_Int + 1));
    int i = 0;
    while (i < this.b)
    {
      int j = 0;
      if (j < this.jdField_a_of_type_Int)
      {
        if (a(j, i)) {}
        for (String str = "X ";; str = "  ")
        {
          localStringBuilder.append(str);
          j += 1;
          break;
        }
      }
      localStringBuilder.append('\n');
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.zxing.common.BitMatrix
 * JD-Core Version:    0.7.0.1
 */