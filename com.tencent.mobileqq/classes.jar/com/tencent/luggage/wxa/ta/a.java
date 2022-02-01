package com.tencent.luggage.wxa.ta;

import java.io.InputStream;
import java.util.LinkedList;

public final class a
{
  private byte[] a;
  private int b;
  private int c = 0;
  private int d;
  private InputStream e;
  private int f = 0;
  private int g = 0;
  private int h = 2147483647;
  private int i = 67108864;
  
  private a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = (paramInt2 + paramInt1);
    this.d = paramInt1;
    this.e = null;
  }
  
  public static a a(byte[] paramArrayOfByte)
  {
    return new a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private boolean a(boolean paramBoolean)
  {
    int k = this.d;
    int j = this.b;
    if (k >= j)
    {
      k = this.g;
      if (k + j == this.h)
      {
        if (!paramBoolean) {
          return false;
        }
        throw b.a();
      }
      this.g = (k + j);
      this.d = 0;
      InputStream localInputStream = this.e;
      if (localInputStream == null) {
        j = -1;
      } else {
        j = localInputStream.read(this.a);
      }
      this.b = j;
      if (this.b == -1)
      {
        this.b = 0;
        if (!paramBoolean) {
          return false;
        }
        throw b.a();
      }
      m();
      j = this.g + this.b + this.c;
      if ((j <= this.i) && (j >= 0)) {
        return true;
      }
      throw b.e();
    }
    throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
  }
  
  private int[] b(int paramInt)
  {
    int j = c(paramInt);
    paramInt += 1;
    if (j >= 0) {
      return new int[] { j, paramInt };
    }
    j &= 0x7F;
    int k = c(paramInt);
    if (k >= 0)
    {
      paramInt += 1;
      k <<= 7;
    }
    for (;;)
    {
      j |= k;
      break label196;
      j |= (k & 0x7F) << 7;
      k = c(paramInt);
      if (k >= 0)
      {
        paramInt += 1;
        k <<= 14;
      }
      else
      {
        j |= (k & 0x7F) << 14;
        k = c(paramInt);
        if (k < 0) {
          break;
        }
        paramInt += 1;
        k <<= 21;
      }
    }
    int m = c(paramInt);
    j = j | (k & 0x7F) << 21 | m << 28;
    k = paramInt + 1;
    paramInt = k;
    if (m < 0)
    {
      paramInt = 0;
      while (paramInt < 5)
      {
        if (c(k) >= 0) {
          return new int[] { m, k + 1 };
        }
        paramInt += 1;
      }
      throw b.c();
    }
    label196:
    return new int[] { j, paramInt };
  }
  
  private byte c(int paramInt)
  {
    return this.a[paramInt];
  }
  
  private byte[] d(int paramInt)
  {
    if (paramInt >= 0)
    {
      int j = this.g;
      int i1 = this.d;
      int k = this.h;
      if (j + i1 + paramInt <= k)
      {
        k = this.b;
        if (paramInt <= k - i1)
        {
          localObject1 = new byte[paramInt];
          System.arraycopy(this.a, i1, localObject1, 0, paramInt);
          this.d += paramInt;
          return localObject1;
        }
        int m;
        if (paramInt < 2048)
        {
          localObject1 = new byte[paramInt];
          j = k - i1;
          System.arraycopy(this.a, i1, localObject1, 0, j);
          this.d = this.b;
          a(true);
          for (;;)
          {
            k = paramInt - j;
            m = this.b;
            if (k <= m)
            {
              System.arraycopy(this.a, 0, localObject1, j, k);
              this.d = k;
              return localObject1;
            }
            System.arraycopy(this.a, 0, localObject1, j, m);
            k = this.b;
            j += k;
            this.d = k;
            a(true);
          }
        }
        this.g = (j + k);
        this.d = 0;
        this.b = 0;
        int n = k - i1;
        j = paramInt - n;
        localObject1 = new LinkedList();
        Object localObject2;
        if (j <= 0)
        {
          arrayOfByte = new byte[paramInt];
          System.arraycopy(this.a, i1, arrayOfByte, 0, n);
          paramInt = 0;
          j = n;
          for (;;)
          {
            if (paramInt >= ((LinkedList)localObject1).size()) {
              return arrayOfByte;
            }
            localObject2 = (byte[])((LinkedList)localObject1).get(paramInt);
            System.arraycopy(localObject2, 0, arrayOfByte, j, localObject2.length);
            j += localObject2.length;
            paramInt += 1;
          }
        }
        byte[] arrayOfByte = new byte[Math.min(j, 2048)];
        k = 0;
        for (;;)
        {
          if (k >= arrayOfByte.length)
          {
            j -= arrayOfByte.length;
            ((LinkedList)localObject1).add(arrayOfByte);
            break;
          }
          localObject2 = this.e;
          if (localObject2 == null) {
            m = -1;
          } else {
            m = ((InputStream)localObject2).read(arrayOfByte, k, arrayOfByte.length - k);
          }
          if (m == -1) {
            break label397;
          }
          this.g += m;
          k += m;
        }
        label397:
        throw b.a();
      }
      e(k - j - i1);
      throw b.a();
    }
    Object localObject1 = b.b();
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  private void e(int paramInt)
  {
    if (paramInt >= 0)
    {
      int k = this.g;
      int j = this.d;
      int m = this.h;
      if (k + j + paramInt <= m)
      {
        m = this.b;
        if (paramInt < m - j)
        {
          this.d = (j + paramInt);
          return;
        }
        j = m - j;
        this.g = (k + j);
        this.d = 0;
        this.b = 0;
        for (;;)
        {
          if (j >= paramInt) {
            return;
          }
          localObject = this.e;
          if (localObject == null) {
            k = -1;
          } else {
            k = (int)((InputStream)localObject).skip(paramInt - j);
          }
          if (k <= 0) {
            break;
          }
          j += k;
          this.g += k;
        }
        throw b.a();
      }
      e(m - k - j);
      throw b.a();
    }
    Object localObject = b.b();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private int l()
  {
    int j = n();
    if (j >= 0) {
      return j;
    }
    j &= 0x7F;
    int k = n();
    if (k >= 0) {
      k <<= 7;
    }
    for (;;)
    {
      return j | k;
      j |= (k & 0x7F) << 7;
      k = n();
      if (k >= 0)
      {
        k <<= 14;
      }
      else
      {
        j |= (k & 0x7F) << 14;
        k = n();
        if (k < 0) {
          break;
        }
        k <<= 21;
      }
    }
    int m = n();
    k = j | (k & 0x7F) << 21 | m << 28;
    if (m < 0)
    {
      j = 0;
      while (j < 5)
      {
        if (n() >= 0) {
          return k;
        }
        j += 1;
      }
      throw b.c();
    }
    return k;
  }
  
  private void m()
  {
    this.b += this.c;
    int k = this.g;
    int j = this.b;
    k += j;
    int m = this.h;
    if (k > m)
    {
      this.c = (k - m);
      this.b = (j - this.c);
      return;
    }
    this.c = 0;
  }
  
  private byte n()
  {
    if (this.d == this.b) {
      a(true);
    }
    byte[] arrayOfByte = this.a;
    int j = this.d;
    this.d = (j + 1);
    return arrayOfByte[j];
  }
  
  public int a()
  {
    if ((this.d == this.b) && (!a(false)))
    {
      this.f = 0;
      return 0;
    }
    this.f = l();
    int j = this.f;
    if (j != 0) {
      return j;
    }
    throw b.d();
  }
  
  public LinkedList<byte[]> a(int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    int j = l();
    try
    {
      localObject = new byte[j];
      System.arraycopy(this.a, this.d, localObject, 0, j);
      localLinkedList.add(localObject);
      this.d += j;
      j = this.d;
      if (j == this.b) {
        return localLinkedList;
      }
      localObject = b(j);
      for (j = localObject[0];; j = localObject[0])
      {
        if (com.tencent.luggage.wxa.sz.a.b(j) != paramInt) {
          return localLinkedList;
        }
        this.d = localObject[1];
        j = l();
        localObject = new byte[j];
        System.arraycopy(this.a, this.d, localObject, 0, j);
        localLinkedList.add(localObject);
        this.d += j;
        j = this.d;
        if (j == this.b) {
          return localLinkedList;
        }
        localObject = b(j);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject;
      label162:
      break label162;
    }
    localObject = new StringBuilder("alloc bytes:");
    ((StringBuilder)localObject).append(j);
    localObject = new OutOfMemoryError(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public double b()
  {
    return Double.longBitsToDouble(k());
  }
  
  public float c()
  {
    return Float.intBitsToFloat(j());
  }
  
  public long d()
  {
    return i();
  }
  
  public int e()
  {
    return l();
  }
  
  public boolean f()
  {
    return l() != 0;
  }
  
  public String g()
  {
    int j = l();
    int k = this.b;
    int m = this.d;
    if ((j < k - m) && (j > 0))
    {
      String str = new String(this.a, m, j, "UTF-8");
      this.d += j;
      return str;
    }
    return new String(d(j), "UTF-8");
  }
  
  public com.tencent.luggage.wxa.qu.b h()
  {
    int j = l();
    int k = this.b;
    int m = this.d;
    if ((j < k - m) && (j > 0))
    {
      com.tencent.luggage.wxa.qu.b localb = com.tencent.luggage.wxa.qu.b.a(this.a, m, j);
      this.d += j;
      return localb;
    }
    return com.tencent.luggage.wxa.qu.b.a(d(j));
  }
  
  public long i()
  {
    int j = 0;
    long l = 0L;
    while (j < 64)
    {
      int k = n();
      l |= (k & 0x7F) << j;
      if ((k & 0x80) == 0) {
        return l;
      }
      j += 7;
    }
    b localb = b.c();
    for (;;)
    {
      throw localb;
    }
  }
  
  int j()
  {
    return n() & 0xFF | (n() & 0xFF) << 8 | (n() & 0xFF) << 16 | (n() & 0xFF) << 24;
  }
  
  long k()
  {
    int j = n();
    int k = n();
    int m = n();
    int n = n();
    int i1 = n();
    int i2 = n();
    int i3 = n();
    int i4 = n();
    long l = j;
    return (k & 0xFF) << 8 | l & 0xFF | (m & 0xFF) << 16 | (n & 0xFF) << 24 | (i1 & 0xFF) << 32 | (i2 & 0xFF) << 40 | (i3 & 0xFF) << 48 | (i4 & 0xFF) << 56;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ta.a
 * JD-Core Version:    0.7.0.1
 */