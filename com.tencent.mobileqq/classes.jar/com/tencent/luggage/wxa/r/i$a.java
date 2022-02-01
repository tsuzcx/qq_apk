package com.tencent.luggage.wxa.r;

import java.util.Arrays;

final class i$a
{
  private static final byte[] d = { 0, 0, 1 };
  public int a;
  public int b;
  public byte[] c;
  private boolean e;
  
  public i$a(int paramInt)
  {
    this.c = new byte[paramInt];
  }
  
  public void a()
  {
    this.e = false;
    this.a = 0;
    this.b = 0;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.e) {
      return;
    }
    paramInt2 -= paramInt1;
    byte[] arrayOfByte = this.c;
    int i = arrayOfByte.length;
    int j = this.a;
    if (i < j + paramInt2) {
      this.c = Arrays.copyOf(arrayOfByte, (j + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.c, this.a, paramInt2);
    this.a += paramInt2;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.e)
    {
      this.a -= paramInt2;
      if ((this.b == 0) && (paramInt1 == 181))
      {
        this.b = this.a;
      }
      else
      {
        this.e = false;
        return true;
      }
    }
    else if (paramInt1 == 179)
    {
      this.e = true;
    }
    byte[] arrayOfByte = d;
    a(arrayOfByte, 0, arrayOfByte.length);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.i.a
 * JD-Core Version:    0.7.0.1
 */