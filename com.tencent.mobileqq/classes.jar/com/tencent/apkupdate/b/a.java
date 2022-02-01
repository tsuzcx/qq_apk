package com.tencent.apkupdate.b;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public final class a
{
  private byte[] a;
  private byte[] b;
  private byte[] c;
  private int d;
  private int e;
  private int f;
  private int g;
  private byte[] h;
  private boolean i = true;
  private int j;
  private Random k = new Random();
  
  private void a()
  {
    byte[] arrayOfByte;
    for (this.f = 0;; this.f += 1)
    {
      m = this.f;
      if (m >= 8) {
        break;
      }
      if (this.i)
      {
        arrayOfByte = this.a;
        arrayOfByte[m] = ((byte)(arrayOfByte[m] ^ this.b[m]));
      }
      else
      {
        arrayOfByte = this.a;
        arrayOfByte[m] = ((byte)(arrayOfByte[m] ^ this.c[(this.e + m)]));
      }
    }
    System.arraycopy(a(this.a), 0, this.c, this.d, 8);
    for (this.f = 0;; this.f = (m + 1))
    {
      m = this.f;
      if (m >= 8) {
        break;
      }
      arrayOfByte = this.c;
      int n = this.d + m;
      arrayOfByte[n] = ((byte)(arrayOfByte[n] ^ this.b[m]));
    }
    System.arraycopy(this.a, 0, this.b, 0, 8);
    int m = this.d;
    this.e = m;
    this.d = (m + 8);
    this.f = 0;
    this.i = false;
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int m;
    for (this.f = 0;; this.f = (m + 1))
    {
      m = this.f;
      if (m >= 8) {
        break;
      }
      if (this.j + m >= paramInt2) {
        return true;
      }
      byte[] arrayOfByte = this.b;
      arrayOfByte[m] = ((byte)(arrayOfByte[m] ^ paramArrayOfByte[(this.d + paramInt1 + m)]));
    }
    this.b = a(this.b, 0);
    if (this.b == null) {
      return false;
    }
    this.j += 8;
    this.d += 8;
    this.f = 0;
    return true;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    int m = 16;
    for (;;)
    {
      long l1;
      long l2;
      long l4;
      long l5;
      long l6;
      long l7;
      long l3;
      try
      {
        l1 = b(paramArrayOfByte, 0, 4);
        l2 = b(paramArrayOfByte, 4, 4);
        l4 = b(this.h, 0, 4);
        l5 = b(this.h, 4, 4);
        l6 = b(this.h, 8, 4);
        l7 = b(this.h, 12, 4);
        l3 = 0L;
      }
      catch (IOException paramArrayOfByte)
      {
        DataOutputStream localDataOutputStream;
        continue;
      }
      paramArrayOfByte = new ByteArrayOutputStream(8);
      localDataOutputStream = new DataOutputStream(paramArrayOfByte);
      localDataOutputStream.writeInt((int)l1);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.close();
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      return paramArrayOfByte;
      return null;
      while (m > 0)
      {
        l3 = l3 + 2654435769L & 0xFFFFFFFF;
        l1 = l1 + ((l2 << 4) + l4 ^ l2 + l3 ^ (l2 >>> 5) + l5) & 0xFFFFFFFF;
        l2 = l2 + ((l1 << 4) + l6 ^ l1 + l3 ^ (l1 >>> 5) + l7) & 0xFFFFFFFF;
        m -= 1;
      }
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int m = 16;
    for (;;)
    {
      long l2;
      long l1;
      long l4;
      long l5;
      long l6;
      long l7;
      long l3;
      try
      {
        l2 = b(paramArrayOfByte, paramInt, 4);
        l1 = b(paramArrayOfByte, paramInt + 4, 4);
        l4 = b(this.h, 0, 4);
        l5 = b(this.h, 4, 4);
        l6 = b(this.h, 8, 4);
        l7 = b(this.h, 12, 4);
        l3 = 3816266640L;
        paramInt = m;
      }
      catch (IOException paramArrayOfByte)
      {
        DataOutputStream localDataOutputStream;
        continue;
      }
      paramArrayOfByte = new ByteArrayOutputStream(8);
      localDataOutputStream = new DataOutputStream(paramArrayOfByte);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.writeInt((int)l1);
      localDataOutputStream.close();
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      return paramArrayOfByte;
      return null;
      while (paramInt > 0)
      {
        l1 = l1 - ((l2 << 4) + l6 ^ l2 + l3 ^ (l2 >>> 5) + l7) & 0xFFFFFFFF;
        l2 = l2 - ((l1 << 4) + l4 ^ l1 + l3 ^ (l1 >>> 5) + l5) & 0xFFFFFFFF;
        l3 = l3 - 2654435769L & 0xFFFFFFFF;
        paramInt -= 1;
      }
    }
  }
  
  private static long b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = 0L;
    paramInt2 = paramInt1;
    while (paramInt2 < paramInt1 + 4)
    {
      l = l << 8 | paramArrayOfByte[paramInt2] & 0xFF;
      paramInt2 += 1;
    }
    return 0xFFFFFFFF & l | l >>> 32;
  }
  
  public final byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.e = 0;
    this.d = 0;
    this.h = paramArrayOfByte2;
    paramArrayOfByte2 = new byte[8];
    if (paramInt2 % 8 == 0)
    {
      if (paramInt2 < 16) {
        return null;
      }
      this.b = a(paramArrayOfByte1, 0);
      this.f = (this.b[0] & 0x7);
      int m = paramInt2 - this.f - 10;
      if (m < 0) {
        return null;
      }
      paramInt1 = 0;
      while (paramInt1 < paramArrayOfByte2.length)
      {
        paramArrayOfByte2[paramInt1] = 0;
        paramInt1 += 1;
      }
      this.c = new byte[m];
      this.e = 0;
      this.d = 8;
      this.j = 8;
      this.f += 1;
      this.g = 1;
      for (;;)
      {
        paramInt1 = this.g;
        if (paramInt1 > 2) {
          break;
        }
        n = this.f;
        if (n < 8)
        {
          this.f = (n + 1);
          this.g = (paramInt1 + 1);
        }
        if (this.f == 8)
        {
          if (!a(paramArrayOfByte1, 0, paramInt2)) {
            return null;
          }
          paramArrayOfByte2 = paramArrayOfByte1;
        }
      }
      int n = 0;
      paramInt1 = m;
      while (paramInt1 != 0)
      {
        int i2 = this.f;
        int i1 = n;
        m = paramInt1;
        if (i2 < 8)
        {
          this.c[n] = ((byte)(paramArrayOfByte2[(this.e + 0 + i2)] ^ this.b[i2]));
          i1 = n + 1;
          m = paramInt1 - 1;
          this.f = (i2 + 1);
        }
        n = i1;
        paramInt1 = m;
        if (this.f == 8)
        {
          this.e = (this.d - 8);
          if (!a(paramArrayOfByte1, 0, paramInt2)) {
            return null;
          }
          paramArrayOfByte2 = paramArrayOfByte1;
          n = i1;
          paramInt1 = m;
        }
      }
      for (this.g = 1; this.g < 8; this.g += 1)
      {
        paramInt1 = this.f;
        if (paramInt1 < 8)
        {
          if ((paramArrayOfByte2[(this.e + 0 + paramInt1)] ^ this.b[paramInt1]) != 0) {
            return null;
          }
          this.f = (paramInt1 + 1);
        }
        if (this.f == 8)
        {
          this.e = this.d;
          if (!a(paramArrayOfByte1, 0, paramInt2)) {
            return null;
          }
          paramArrayOfByte2 = paramArrayOfByte1;
        }
      }
      return this.c;
    }
    return null;
  }
  
  public final byte[] b(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.a = new byte[8];
    this.b = new byte[8];
    this.f = 1;
    this.g = 0;
    this.e = 0;
    this.d = 0;
    this.h = paramArrayOfByte2;
    this.i = true;
    this.f = ((paramInt2 + 10) % 8);
    paramInt1 = this.f;
    if (paramInt1 != 0) {
      this.f = (8 - paramInt1);
    }
    this.c = new byte[this.f + paramInt2 + 10];
    this.a[0] = ((byte)(this.k.nextInt() & 0xF8 | this.f));
    paramInt1 = 1;
    for (;;)
    {
      m = this.f;
      if (paramInt1 > m) {
        break;
      }
      this.a[paramInt1] = ((byte)this.k.nextInt());
      paramInt1 += 1;
    }
    this.f = (m + 1);
    paramInt1 = 0;
    while (paramInt1 < 8)
    {
      this.b[paramInt1] = 0;
      paramInt1 += 1;
    }
    this.g = 1;
    while (this.g <= 2)
    {
      paramInt1 = this.f;
      if (paramInt1 < 8)
      {
        paramArrayOfByte2 = this.a;
        this.f = (paramInt1 + 1);
        paramArrayOfByte2[paramInt1] = ((byte)this.k.nextInt());
        this.g += 1;
      }
      if (this.f == 8) {
        a();
      }
    }
    paramInt1 = 0;
    int m = paramInt2;
    while (m > 0)
    {
      int i1 = this.f;
      int n = m;
      paramInt2 = paramInt1;
      if (i1 < 8)
      {
        paramArrayOfByte2 = this.a;
        this.f = (i1 + 1);
        paramArrayOfByte2[i1] = paramArrayOfByte1[paramInt1];
        n = m - 1;
        paramInt2 = paramInt1 + 1;
      }
      m = n;
      paramInt1 = paramInt2;
      if (this.f == 8)
      {
        a();
        m = n;
        paramInt1 = paramInt2;
      }
    }
    this.g = 1;
    for (;;)
    {
      paramInt1 = this.g;
      if (paramInt1 > 7) {
        break;
      }
      paramInt2 = this.f;
      if (paramInt2 < 8)
      {
        paramArrayOfByte1 = this.a;
        this.f = (paramInt2 + 1);
        paramArrayOfByte1[paramInt2] = 0;
        this.g = (paramInt1 + 1);
      }
      if (this.f == 8) {
        a();
      }
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.b.a
 * JD-Core Version:    0.7.0.1
 */