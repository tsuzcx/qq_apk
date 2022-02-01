package com.tencent.luggage.wxa.am;

import android.net.Uri;
import com.tencent.luggage.wxa.ao.a;

public final class v
  implements g
{
  private final g a;
  private final f b;
  
  public v(g paramg, f paramf)
  {
    this.a = ((g)a.a(paramg));
    this.b = ((f)a.a(paramf));
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = this.a.a(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      this.b.a(paramArrayOfByte, paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  public long a(j paramj)
  {
    long l = this.a.a(paramj);
    j localj = paramj;
    if (paramj.e == -1L)
    {
      localj = paramj;
      if (l != -1L) {
        localj = new j(paramj.a, paramj.c, paramj.d, l, paramj.f, paramj.g);
      }
    }
    this.b.a(localj);
    return l;
  }
  
  public void a()
  {
    try
    {
      this.a.a();
      return;
    }
    finally
    {
      this.b.a();
    }
  }
  
  public Uri b()
  {
    return this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.am.v
 * JD-Core Version:    0.7.0.1
 */