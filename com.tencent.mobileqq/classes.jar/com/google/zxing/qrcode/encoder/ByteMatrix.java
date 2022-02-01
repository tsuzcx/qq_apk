package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;

public final class ByteMatrix
{
  private final int jdField_a_of_type_Int;
  private final byte[][] jdField_a_of_type_Array2dOfByte;
  private final int b;
  
  public ByteMatrix(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Array2dOfByte = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { paramInt2, paramInt1 }));
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public byte a(int paramInt1, int paramInt2)
  {
    return this.jdField_a_of_type_Array2dOfByte[paramInt2][paramInt1];
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(byte paramByte)
  {
    int i = 0;
    while (i < this.b)
    {
      int j = 0;
      while (j < this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Array2dOfByte[i][j] = paramByte;
        j += 1;
      }
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Array2dOfByte[paramInt2][paramInt1] = ((byte)paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Array2dOfByte[paramInt2][paramInt1] = ((byte)paramBoolean);
  }
  
  public byte[][] a()
  {
    return this.jdField_a_of_type_Array2dOfByte;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_Int * 2 * this.b + 2);
    int i = 0;
    while (i < this.b)
    {
      int j = 0;
      while (j < this.jdField_a_of_type_Int)
      {
        int k = this.jdField_a_of_type_Array2dOfByte[i][j];
        if (k != 0)
        {
          if (k != 1) {
            localStringBuilder.append("  ");
          } else {
            localStringBuilder.append(" 1");
          }
        }
        else {
          localStringBuilder.append(" 0");
        }
        j += 1;
      }
      localStringBuilder.append('\n');
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.zxing.qrcode.encoder.ByteMatrix
 * JD-Core Version:    0.7.0.1
 */