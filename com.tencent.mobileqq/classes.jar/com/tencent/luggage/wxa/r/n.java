package com.tencent.luggage.wxa.r;

import com.tencent.luggage.wxa.ao.a;
import java.util.Arrays;

final class n
{
  public byte[] a;
  public int b;
  private final int c;
  private boolean d;
  private boolean e;
  
  public n(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.a = new byte[paramInt2 + 3];
    this.a[2] = 1;
  }
  
  public void a()
  {
    this.d = false;
    this.e = false;
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = this.d;
    boolean bool1 = true;
    a.b(bool2 ^ true);
    if (paramInt != this.c) {
      bool1 = false;
    }
    this.d = bool1;
    if (this.d)
    {
      this.b = 3;
      this.e = false;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.d) {
      return;
    }
    paramInt2 -= paramInt1;
    byte[] arrayOfByte = this.a;
    int i = arrayOfByte.length;
    int j = this.b;
    if (i < j + paramInt2) {
      this.a = Arrays.copyOf(arrayOfByte, (j + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.b, paramInt2);
    this.b += paramInt2;
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public boolean b(int paramInt)
  {
    if (!this.d) {
      return false;
    }
    this.b -= paramInt;
    this.d = false;
    this.e = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.n
 * JD-Core Version:    0.7.0.1
 */