package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;

public final class ByteMatrix
{
  private final byte[][] a;
  private final int b;
  private final int c;
  
  public ByteMatrix(int paramInt1, int paramInt2)
  {
    this.a = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { paramInt2, paramInt1 }));
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public byte a(int paramInt1, int paramInt2)
  {
    return this.a[paramInt2][paramInt1];
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(byte paramByte)
  {
    int i = 0;
    while (i < this.c)
    {
      int j = 0;
      while (j < this.b)
      {
        this.a[i][j] = paramByte;
        j += 1;
      }
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a[paramInt2][paramInt1] = ((byte)paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a[paramInt2][paramInt1] = ((byte)paramBoolean);
  }
  
  public int b()
  {
    return this.b;
  }
  
  public byte[][] c()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.b * 2 * this.c + 2);
    int i = 0;
    while (i < this.c)
    {
      int j = 0;
      while (j < this.b)
      {
        int k = this.a[i][j];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.zxing.qrcode.encoder.ByteMatrix
 * JD-Core Version:    0.7.0.1
 */