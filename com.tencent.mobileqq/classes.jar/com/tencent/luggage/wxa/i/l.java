package com.tencent.luggage.wxa.i;

import com.tencent.luggage.wxa.ao.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class l
  implements d
{
  private int b = -1;
  private int c = -1;
  private k d;
  private float e = 1.0F;
  private float f = 1.0F;
  private ByteBuffer g = a;
  private ShortBuffer h = this.g.asShortBuffer();
  private ByteBuffer i = a;
  private long j;
  private long k;
  private boolean l;
  
  public float a(float paramFloat)
  {
    this.e = x.a(paramFloat, 0.1F, 8.0F);
    return this.e;
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasRemaining())
    {
      ShortBuffer localShortBuffer = paramByteBuffer.asShortBuffer();
      m = paramByteBuffer.remaining();
      this.j += m;
      this.d.a(localShortBuffer);
      paramByteBuffer.position(paramByteBuffer.position() + m);
    }
    int m = this.d.b() * this.b * 2;
    if (m > 0)
    {
      if (this.g.capacity() < m)
      {
        this.g = ByteBuffer.allocateDirect(m).order(ByteOrder.nativeOrder());
        this.h = this.g.asShortBuffer();
      }
      else
      {
        this.g.clear();
        this.h.clear();
      }
      this.d.b(this.h);
      this.k += m;
      this.g.limit(m);
      this.i = this.g;
    }
  }
  
  public boolean a()
  {
    return (Math.abs(this.e - 1.0F) >= 0.01F) || (Math.abs(this.f - 1.0F) >= 0.01F);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 2)
    {
      if ((this.c == paramInt1) && (this.b == paramInt2)) {
        return false;
      }
      this.c = paramInt1;
      this.b = paramInt2;
      return true;
    }
    throw new d.a(paramInt1, paramInt2, paramInt3);
  }
  
  public float b(float paramFloat)
  {
    this.f = x.a(paramFloat, 0.1F, 8.0F);
    return paramFloat;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return 2;
  }
  
  public void d()
  {
    this.d.a();
    this.l = true;
  }
  
  public ByteBuffer e()
  {
    ByteBuffer localByteBuffer = this.i;
    this.i = a;
    return localByteBuffer;
  }
  
  public boolean f()
  {
    if (this.l)
    {
      k localk = this.d;
      if ((localk == null) || (localk.b() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  public void g()
  {
    this.d = new k(this.c, this.b);
    this.d.a(this.e);
    this.d.b(this.f);
    this.i = a;
    this.j = 0L;
    this.k = 0L;
    this.l = false;
  }
  
  public void h()
  {
    this.d = null;
    this.g = a;
    this.h = this.g.asShortBuffer();
    this.i = a;
    this.b = -1;
    this.c = -1;
    this.j = 0L;
    this.k = 0L;
    this.l = false;
  }
  
  public long i()
  {
    return this.j;
  }
  
  public long j()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.i.l
 * JD-Core Version:    0.7.0.1
 */