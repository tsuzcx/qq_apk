package com.tencent.luggage.wxa.td;

import java.io.OutputStream;

public class a
{
  byte[] a;
  int b;
  int c = 0;
  int d;
  OutputStream e;
  
  public void a()
  {
    b();
    this.e = null;
  }
  
  public void a(byte paramByte)
  {
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    arrayOfByte[i] = paramByte;
    if (this.b >= this.c) {
      b();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.a == null) || (this.c != paramInt)) {
      this.a = new byte[paramInt];
    }
    this.c = paramInt;
    this.b = 0;
    this.d = 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j = this.b - paramInt1 - 1;
    paramInt1 = j;
    int i = paramInt2;
    if (j < 0)
    {
      paramInt1 = j + this.c;
      i = paramInt2;
    }
    while (i != 0)
    {
      paramInt2 = paramInt1;
      if (paramInt1 >= this.c) {
        paramInt2 = 0;
      }
      byte[] arrayOfByte = this.a;
      paramInt1 = this.b;
      this.b = (paramInt1 + 1);
      arrayOfByte[paramInt1] = arrayOfByte[paramInt2];
      if (this.b >= this.c) {
        b();
      }
      i -= 1;
      paramInt1 = paramInt2 + 1;
    }
  }
  
  public void a(OutputStream paramOutputStream)
  {
    a();
    this.e = paramOutputStream;
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.d = 0;
      this.b = 0;
    }
  }
  
  public byte b(int paramInt)
  {
    int i = this.b - paramInt - 1;
    paramInt = i;
    if (i < 0) {
      paramInt = i + this.c;
    }
    return this.a[paramInt];
  }
  
  public void b()
  {
    int j = this.b;
    int i = this.d;
    j -= i;
    if (j == 0) {
      return;
    }
    this.e.write(this.a, i, j);
    if (this.b >= this.c) {
      this.b = 0;
    }
    this.d = this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.td.a
 * JD-Core Version:    0.7.0.1
 */