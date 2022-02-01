package com.tencent.luggage.wxa.pn;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class a$a
  extends FilterOutputStream
{
  private boolean a;
  private int b;
  private byte[] c;
  private int d;
  private int e;
  private boolean f;
  private byte[] g;
  private boolean h;
  private int i;
  private byte[] j;
  
  public a$a(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream);
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt & 0x8) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.f = bool1;
    if ((paramInt & 0x1) != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.a = bool1;
    int k;
    if (this.a) {
      k = 3;
    } else {
      k = 4;
    }
    this.d = k;
    this.c = new byte[this.d];
    this.b = 0;
    this.e = 0;
    this.h = false;
    this.g = new byte[4];
    this.i = paramInt;
    this.j = a.a(paramInt);
  }
  
  public void a()
  {
    if (this.b > 0)
    {
      if (this.a)
      {
        this.out.write(a.a(this.g, this.c, this.b, this.i));
        this.b = 0;
        return;
      }
      throw new IOException("Base64 input not properly padded.");
    }
  }
  
  public void close()
  {
    a();
    super.close();
    this.c = null;
    this.out = null;
  }
  
  public void write(int paramInt)
  {
    if (this.h)
    {
      this.out.write(paramInt);
      return;
    }
    byte[] arrayOfByte;
    int k;
    if (this.a)
    {
      arrayOfByte = this.c;
      k = this.b;
      this.b = (k + 1);
      arrayOfByte[k] = ((byte)paramInt);
      if (this.b >= this.d)
      {
        this.out.write(a.a(this.g, this.c, this.d, this.i));
        this.e += 4;
        if ((this.f) && (this.e >= 76))
        {
          this.out.write(10);
          this.e = 0;
        }
        this.b = 0;
      }
    }
    else
    {
      arrayOfByte = this.j;
      k = paramInt & 0x7F;
      if (arrayOfByte[k] > -5)
      {
        arrayOfByte = this.c;
        k = this.b;
        this.b = (k + 1);
        arrayOfByte[k] = ((byte)paramInt);
        if (this.b >= this.d)
        {
          paramInt = a.a(arrayOfByte, 0, this.g, 0, this.i);
          this.out.write(this.g, 0, paramInt);
          this.b = 0;
        }
      }
      else
      {
        if (arrayOfByte[k] != -5) {
          break label222;
        }
      }
    }
    return;
    label222:
    throw new IOException("Invalid character in Base64 data.");
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.h)
    {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    int k = 0;
    while (k < paramInt2)
    {
      write(paramArrayOfByte[(paramInt1 + k)]);
      k += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pn.a.a
 * JD-Core Version:    0.7.0.1
 */