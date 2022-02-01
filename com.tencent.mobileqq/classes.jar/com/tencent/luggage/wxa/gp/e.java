package com.tencent.luggage.wxa.gp;

import java.lang.reflect.Array;

public class e
  implements i
{
  protected static long m;
  protected static long n;
  protected static Object o = new Object();
  protected j a;
  protected int b = 0;
  protected int c = 0;
  protected int d = 0;
  protected int e = 44100;
  protected int f = 2;
  protected int g = 2;
  protected boolean h = false;
  protected boolean i = false;
  protected boolean j = false;
  protected String k;
  protected String l;
  protected byte[][] p = new byte[2][];
  protected j q;
  
  public com.tencent.luggage.wxa.gm.e a(int paramInt)
  {
    return null;
  }
  
  public j a()
  {
    return c.a(1);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = this.b;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    paramInt1 = this.e;
    paramInt2 = this.b;
    j localj;
    if (paramInt1 != paramInt2)
    {
      localj = this.a;
      if (localj == null)
      {
        this.a = a();
        this.a.a(this.l, this.b, this.e);
      }
      else if ((localj != null) && (i1 != paramInt2))
      {
        localj.a();
        this.a = a();
        this.a.a(this.l, this.b, this.e);
      }
      if ((this.c == 2) && (this.f == 2))
      {
        localj = this.q;
        StringBuilder localStringBuilder;
        if (localj == null)
        {
          this.q = a();
          localj = this.q;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.l);
          localStringBuilder.append("RResample");
          localj.a(localStringBuilder.toString(), this.b, this.e);
        }
        else if ((localj != null) && (i1 != this.b))
        {
          localj.a();
          this.q = a();
          localj = this.q;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.l);
          localStringBuilder.append("RResample");
          localj.a(localStringBuilder.toString(), this.b, this.e);
        }
      }
      this.j = true;
    }
    else
    {
      this.j = false;
      localj = this.a;
      if (localj != null)
      {
        localj.a();
        this.a = null;
      }
    }
    if (this.g != this.d) {
      this.i = true;
    }
    if (this.f != this.c) {
      this.h = true;
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    ??? = null;
    Object localObject2 = ???;
    byte[] arrayOfByte;
    if (f())
    {
      arrayOfByte = d.a(this.d, this.g, paramArrayOfByte);
      localObject2 = ???;
      if (arrayOfByte != null) {
        localObject2 = arrayOfByte;
      }
    }
    ??? = localObject2;
    if (localObject2 == null) {
      ??? = paramArrayOfByte;
    }
    if ((this.c == 1) && (this.f == 2) && (e()))
    {
      paramArrayOfByte = this.a.a((byte[])???);
      if (paramArrayOfByte == null) {
        paramArrayOfByte = (byte[])???;
      }
      ??? = d.a(this.c, this.f, this.g, paramArrayOfByte);
      if (??? != null) {
        paramArrayOfByte = (byte[])???;
      }
      return paramArrayOfByte;
    }
    if ((this.c == 2) && (this.f == 2) && (e()))
    {
      paramArrayOfByte = b((byte[])???);
      if (paramArrayOfByte != null) {
        return paramArrayOfByte;
      }
      return ???;
    }
    localObject2 = ???;
    if (g())
    {
      arrayOfByte = d.a(this.c, this.f, this.g, (byte[])???);
      localObject2 = ???;
      if (arrayOfByte != null) {
        localObject2 = arrayOfByte;
      }
    }
    if (localObject2 != null) {
      paramArrayOfByte = localObject2;
    }
    if (e()) {
      synchronized (o)
      {
        m += 1L;
        System.nanoTime();
        ??? = this.a.a(paramArrayOfByte);
        if (??? != null) {
          paramArrayOfByte = (byte[])???;
        }
        synchronized (o)
        {
          return paramArrayOfByte;
        }
      }
    }
    return paramArrayOfByte;
  }
  
  public void b() {}
  
  protected byte[] b(byte[] paramArrayOfByte)
  {
    Object localObject = this.a;
    if ((localObject instanceof l))
    {
      if (this.f == 2)
      {
        int i1 = paramArrayOfByte.length / 2;
        localObject = this.p;
        if ((localObject == null) || (i1 != localObject.length)) {
          this.p = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { 2, i1 }));
        }
        d.a(this.g, paramArrayOfByte, this.p);
        byte[] arrayOfByte1 = this.a.a(this.p[0]);
        byte[] arrayOfByte2 = this.q.a(this.p[1]);
        localObject = paramArrayOfByte;
        if (arrayOfByte1 != null)
        {
          if (arrayOfByte2 == null) {
            return paramArrayOfByte;
          }
          localObject = d.a(this.g, arrayOfByte1, arrayOfByte2);
        }
        return localObject;
      }
      return ((j)localObject).a(paramArrayOfByte);
    }
    return ((j)localObject).a(paramArrayOfByte);
  }
  
  public void c() {}
  
  public void d()
  {
    j localj = this.a;
    if (localj != null)
    {
      localj.a();
      this.a = null;
    }
    localj = this.q;
    if (localj != null)
    {
      localj.a();
      this.q = null;
    }
  }
  
  protected boolean e()
  {
    return this.j;
  }
  
  protected boolean f()
  {
    return this.i;
  }
  
  protected boolean g()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gp.e
 * JD-Core Version:    0.7.0.1
 */