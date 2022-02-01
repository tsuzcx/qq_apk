package com.tencent.luggage.wxa.aa;

import com.tencent.luggage.wxa.am.g;
import com.tencent.luggage.wxa.am.j;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.k;
import java.util.Arrays;

public abstract class c
  extends a
{
  private byte[] i;
  private int j;
  private volatile boolean k;
  
  public c(g paramg, j paramj, int paramInt1, k paramk, int paramInt2, Object paramObject, byte[] paramArrayOfByte)
  {
    super(paramg, paramj, paramInt1, paramk, paramInt2, paramObject, -9223372036854775807L, -9223372036854775807L);
    this.i = paramArrayOfByte;
  }
  
  private void f()
  {
    byte[] arrayOfByte = this.i;
    if (arrayOfByte == null)
    {
      this.i = new byte[16384];
      return;
    }
    if (arrayOfByte.length < this.j + 16384) {
      this.i = Arrays.copyOf(arrayOfByte, arrayOfByte.length + 16384);
    }
  }
  
  public final void a()
  {
    this.k = true;
  }
  
  protected abstract void a(byte[] paramArrayOfByte, int paramInt);
  
  public final boolean b()
  {
    return this.k;
  }
  
  public final void c()
  {
    try
    {
      this.h.a(this.a);
      int m = 0;
      this.j = 0;
      while ((m != -1) && (!this.k))
      {
        f();
        int n = this.h.a(this.i, this.j, 16384);
        m = n;
        if (n != -1)
        {
          this.j += n;
          m = n;
        }
      }
      if (!this.k) {
        a(this.i, this.j);
      }
      x.a(this.h);
      return;
    }
    finally
    {
      x.a(this.h);
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public long d()
  {
    return this.j;
  }
  
  public byte[] e()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.aa.c
 * JD-Core Version:    0.7.0.1
 */