package com.tencent.luggage.wxa.i;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class j
  implements d
{
  private int b = -1;
  private int c = -1;
  private int d = 0;
  private ByteBuffer e = a;
  private ByteBuffer f = a;
  private boolean g;
  
  public void a(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    int m = paramByteBuffer.limit();
    int k = m - i;
    int n = this.d;
    if (n != -2147483648)
    {
      j = k;
      if (n != 3)
      {
        if (n == 1073741824)
        {
          j = k / 2;
          break label71;
        }
        throw new IllegalStateException();
      }
    }
    else
    {
      j = k / 3;
    }
    j *= 2;
    label71:
    if (this.e.capacity() < j) {
      this.e = ByteBuffer.allocateDirect(j).order(ByteOrder.nativeOrder());
    } else {
      this.e.clear();
    }
    k = this.d;
    int j = i;
    if (k != -2147483648)
    {
      j = i;
      if (k != 3)
      {
        if (k == 1073741824) {
          while (i < m)
          {
            this.e.put(paramByteBuffer.get(i + 2));
            this.e.put(paramByteBuffer.get(i + 3));
            i += 4;
          }
        }
        throw new IllegalStateException();
      }
      while (j < m)
      {
        this.e.put((byte)0);
        this.e.put((byte)((paramByteBuffer.get(j) & 0xFF) - 128));
        j += 1;
      }
    }
    while (j < m)
    {
      this.e.put(paramByteBuffer.get(j + 1));
      this.e.put(paramByteBuffer.get(j + 2));
      j += 3;
    }
    paramByteBuffer.position(paramByteBuffer.limit());
    this.e.flip();
    this.f = this.e;
  }
  
  public boolean a()
  {
    int i = this.d;
    return (i != 0) && (i != 2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 != 3) && (paramInt3 != 2) && (paramInt3 != -2147483648) && (paramInt3 != 1073741824)) {
      throw new d.a(paramInt1, paramInt2, paramInt3);
    }
    if ((this.b == paramInt1) && (this.c == paramInt2) && (this.d == paramInt3)) {
      return false;
    }
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    if (paramInt3 == 2) {
      this.e = a;
    }
    return true;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return 2;
  }
  
  public void d()
  {
    this.g = true;
  }
  
  public ByteBuffer e()
  {
    ByteBuffer localByteBuffer = this.f;
    this.f = a;
    return localByteBuffer;
  }
  
  public boolean f()
  {
    return (this.g) && (this.f == a);
  }
  
  public void g()
  {
    this.f = a;
    this.g = false;
  }
  
  public void h()
  {
    g();
    this.e = a;
    this.b = -1;
    this.c = -1;
    this.d = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.i.j
 * JD-Core Version:    0.7.0.1
 */