package com.tencent.luggage.wxa.i;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class g
  implements d
{
  private int b = -1;
  private int c = -1;
  private int[] d;
  private boolean e;
  private int[] f;
  private ByteBuffer g = a;
  private ByteBuffer h = a;
  private boolean i;
  
  public void a(ByteBuffer paramByteBuffer)
  {
    int j = paramByteBuffer.position();
    int m = paramByteBuffer.limit();
    int k = (m - j) / (this.b * 2) * this.f.length * 2;
    if (this.g.capacity() < k) {
      this.g = ByteBuffer.allocateDirect(k).order(ByteOrder.nativeOrder());
    } else {
      this.g.clear();
    }
    while (j < m)
    {
      int[] arrayOfInt = this.f;
      int n = arrayOfInt.length;
      k = 0;
      while (k < n)
      {
        int i1 = arrayOfInt[k];
        this.g.putShort(paramByteBuffer.getShort(i1 * 2 + j));
        k += 1;
      }
      j += this.b * 2;
    }
    paramByteBuffer.position(m);
    this.g.flip();
    this.h = this.g;
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.d = paramArrayOfInt;
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int m = Arrays.equals(this.d, this.f) ^ true;
    this.f = this.d;
    if (this.f == null)
    {
      this.e = false;
      return m;
    }
    if (paramInt3 == 2)
    {
      if ((m == 0) && (this.c == paramInt1) && (this.b == paramInt2)) {
        return false;
      }
      this.c = paramInt1;
      this.b = paramInt2;
      if (paramInt2 != this.f.length) {
        m = 1;
      } else {
        m = 0;
      }
      this.e = m;
      int j = 0;
      for (;;)
      {
        localObject = this.f;
        if (j >= localObject.length) {
          break label181;
        }
        int k = localObject[j];
        if (k >= paramInt2) {
          break;
        }
        m = this.e;
        if (k != j) {
          k = 1;
        } else {
          k = 0;
        }
        this.e = (k | m);
        j += 1;
      }
      throw new d.a(paramInt1, paramInt2, paramInt3);
      label181:
      return true;
    }
    Object localObject = new d.a(paramInt1, paramInt2, paramInt3);
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public int b()
  {
    int[] arrayOfInt = this.f;
    if (arrayOfInt == null) {
      return this.b;
    }
    return arrayOfInt.length;
  }
  
  public int c()
  {
    return 2;
  }
  
  public void d()
  {
    this.i = true;
  }
  
  public ByteBuffer e()
  {
    ByteBuffer localByteBuffer = this.h;
    this.h = a;
    return localByteBuffer;
  }
  
  public boolean f()
  {
    return (this.i) && (this.h == a);
  }
  
  public void g()
  {
    this.h = a;
    this.i = false;
  }
  
  public void h()
  {
    g();
    this.g = a;
    this.b = -1;
    this.c = -1;
    this.f = null;
    this.e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.i.g
 * JD-Core Version:    0.7.0.1
 */