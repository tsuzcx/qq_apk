package com.tencent.luggage.wxa.an;

import com.tencent.luggage.wxa.am.f;
import com.tencent.luggage.wxa.am.j;
import com.tencent.luggage.wxa.ao.q;
import com.tencent.luggage.wxa.ao.x;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class b
  implements f
{
  private final a a;
  private final long b;
  private final int c;
  private j d;
  private File e;
  private OutputStream f;
  private FileOutputStream g;
  private long h;
  private long i;
  private q j;
  
  public b(a parama, long paramLong, int paramInt)
  {
    this.a = ((a)com.tencent.luggage.wxa.ao.a.a(parama));
    this.b = paramLong;
    this.c = paramInt;
  }
  
  private void b()
  {
    long l1;
    if (this.d.e == -1L) {
      l1 = this.b;
    } else {
      l1 = Math.min(this.d.e - this.i, this.b);
    }
    Object localObject = this.a;
    String str = this.d.f;
    long l2 = this.d.c;
    this.e = ((a)localObject).a(str, this.i + l2, l1);
    this.g = new FileOutputStream(this.e);
    int k = this.c;
    if (k > 0)
    {
      localObject = this.j;
      if (localObject == null) {
        this.j = new q(this.g, k);
      } else {
        ((q)localObject).a(this.g);
      }
      this.f = this.j;
    }
    else
    {
      this.f = this.g;
    }
    this.h = 0L;
  }
  
  private void c()
  {
    Object localObject1 = this.f;
    if (localObject1 == null) {
      return;
    }
    try
    {
      ((OutputStream)localObject1).flush();
      this.g.getFD().sync();
      x.a(this.f);
      this.f = null;
      localObject1 = this.e;
      this.e = null;
      this.a.a((File)localObject1);
      return;
    }
    finally
    {
      x.a(this.f);
      this.f = null;
      File localFile = this.e;
      this.e = null;
      localFile.delete();
    }
  }
  
  public void a()
  {
    if (this.d == null) {
      return;
    }
    try
    {
      c();
      return;
    }
    catch (IOException localIOException)
    {
      throw new b.a(localIOException);
    }
  }
  
  public void a(j paramj)
  {
    if ((paramj.e == -1L) && (!paramj.a(2)))
    {
      this.d = null;
      return;
    }
    this.d = paramj;
    this.i = 0L;
    try
    {
      b();
      return;
    }
    catch (IOException paramj)
    {
      throw new b.a(paramj);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.d == null) {
      return;
    }
    int k = 0;
    while (k < paramInt2) {
      try
      {
        if (this.h == this.b)
        {
          c();
          b();
        }
        int m = (int)Math.min(paramInt2 - k, this.b - this.h);
        this.f.write(paramArrayOfByte, paramInt1 + k, m);
        k += m;
        long l1 = this.h;
        long l2 = m;
        this.h = (l1 + l2);
        this.i += l2;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new b.a(paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.an.b
 * JD-Core Version:    0.7.0.1
 */