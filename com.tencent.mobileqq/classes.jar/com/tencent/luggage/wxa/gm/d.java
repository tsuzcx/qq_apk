package com.tencent.luggage.wxa.gm;

import com.tencent.luggage.wxa.gw.b;
import java.util.ArrayList;
import java.util.Arrays;

public class d
{
  private static long p;
  private static long q;
  public String a;
  public String b;
  public int c = 44100;
  public int d = 2;
  public int e = 2;
  private ArrayList<e> f = new ArrayList();
  private boolean g;
  private long h;
  private boolean i;
  private int j = 0;
  private int k = 0;
  private long l = 0L;
  private boolean m = false;
  private a n;
  private String o;
  
  public d(String paramString)
  {
    this.a = paramString;
  }
  
  private void b(e parame)
  {
    this.b = parame.a;
    this.c = parame.b;
    this.e = parame.d;
    this.d = parame.c;
  }
  
  private void c(int paramInt)
  {
    b.b("MicroMsg.Mix.PcmBufferProvider", "resetProvider src:%s, size:%d, complete:%b, duration:%d, supportMixPlay:%b, bufferSize:%d", new Object[] { this.a, Integer.valueOf(paramInt), Boolean.valueOf(this.g), Long.valueOf(this.h), Boolean.valueOf(this.i), Long.valueOf(this.l) });
    this.f.clear();
    this.g = false;
    this.h = 0L;
    this.i = false;
    this.j = 0;
    this.l = 0L;
    j();
  }
  
  public e a(int paramInt)
  {
    if ((this.m) && (this.n != null)) {
      return b(paramInt);
    }
    if ((this.m) && (this.n == null))
    {
      l();
      return b(paramInt);
    }
    ArrayList localArrayList = this.f;
    if (localArrayList != null)
    {
      if (localArrayList.size() == 0) {
        return null;
      }
      if (paramInt >= this.f.size()) {
        return null;
      }
      return (e)this.f.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      i2 = this.f.size();
      i1 = i2 - 1;
    }
    finally
    {
      for (;;)
      {
        int i2;
        int i1;
        e locale;
        for (;;)
        {
          throw localObject;
        }
        i1 -= 1;
      }
    }
    if (i1 >= 0)
    {
      locale = (e)this.f.remove(i1);
      if (locale != null)
      {
        locale.a = null;
        locale.f = null;
      }
    }
    else
    {
      c(i2);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    this.h = paramLong;
  }
  
  public void a(e parame)
  {
    this.j += 1;
    parame.e = (this.j * 20);
    ArrayList localArrayList = this.f;
    if (localArrayList != null) {
      localArrayList.add(parame);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean a(String paramString)
  {
    try
    {
      if (this.m)
      {
        b.b("MicroMsg.Mix.PcmBufferProvider", "cache to file has finish, file:%s", new Object[] { this.a });
        return true;
      }
      this.o = paramString;
      int i2 = this.f.size();
      if (i2 > 0) {
        m();
      }
      if (this.n == null)
      {
        b.a("MicroMsg.Mix.PcmBufferProvider", "cacheFile is null");
        this.m = false;
        return false;
      }
      i1 = 0;
      while (i1 < i2)
      {
        paramString = (e)this.f.get(i1);
        if (i1 == 0) {
          b(paramString);
        }
        if ((paramString != null) && (!a(paramString.f, i1 * 3536, paramString.f.length)))
        {
          n();
          b.a("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile fail");
          this.m = false;
          return false;
        }
        i1 += 1;
      }
      this.m = true;
      i1 = i2 - 1;
    }
    finally
    {
      for (;;)
      {
        int i1;
        for (;;)
        {
          throw paramString;
        }
        i1 -= 1;
      }
    }
    if (i1 >= 0)
    {
      paramString = (e)this.f.remove(i1);
      if (paramString != null) {
        com.tencent.luggage.wxa.gn.e.a().a(paramString);
      }
    }
    else
    {
      b.b("MicroMsg.Mix.PcmBufferProvider", "setCacheToFile finish");
      return true;
    }
  }
  
  protected boolean a(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    a locala = this.n;
    if (locala != null) {
      return locala.b(paramArrayOfByte, paramLong, paramInt);
    }
    return false;
  }
  
  protected int b(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    a locala = this.n;
    if (locala != null) {
      return locala.a(paramArrayOfByte, paramLong, paramInt);
    }
    return 0;
  }
  
  protected e b(int paramInt)
  {
    if (paramInt >= this.k) {
      return null;
    }
    Object localObject = this.n;
    if (localObject == null) {
      return null;
    }
    int i1 = paramInt * 3536;
    if (i1 > ((a)localObject).c()) {
      return null;
    }
    localObject = com.tencent.luggage.wxa.gn.d.a().b();
    if (localObject == null) {
      return null;
    }
    if (((e)localObject).f == null) {
      ((e)localObject).f = new byte[3536];
    } else {
      Arrays.fill(((e)localObject).f, 0, ((e)localObject).f.length, (byte)0);
    }
    System.nanoTime();
    if (b(((e)localObject).f, i1, ((e)localObject).f.length) <= 0)
    {
      com.tencent.luggage.wxa.gn.d.a().a((e)localObject);
      return null;
    }
    ((e)localObject).a = this.b;
    ((e)localObject).b = this.c;
    ((e)localObject).c = this.d;
    ((e)localObject).d = this.e;
    ((e)localObject).e = (paramInt * 20);
    return localObject;
  }
  
  public void b()
  {
    try
    {
      i2 = this.f.size();
      i1 = i2 - 1;
    }
    finally
    {
      for (;;)
      {
        int i2;
        int i1;
        e locale;
        for (;;)
        {
          throw localObject;
        }
        i1 -= 1;
      }
    }
    if (i1 >= 0)
    {
      locale = (e)this.f.remove(i1);
      if (locale != null) {
        com.tencent.luggage.wxa.gn.e.a().a(locale);
      }
    }
    else
    {
      c(i2);
      return;
    }
  }
  
  public int c()
  {
    int i1 = this.k;
    if ((i1 > 0) && (this.g)) {
      return i1;
    }
    return this.f.size();
  }
  
  public long d()
  {
    return this.h;
  }
  
  public boolean e()
  {
    return this.g;
  }
  
  public void f()
  {
    this.g = true;
    this.k = c();
    b.b("MicroMsg.Mix.PcmBufferProvider", "src:%s is complete cache", new Object[] { this.a });
  }
  
  public boolean g()
  {
    return this.i;
  }
  
  public long h()
  {
    long l1 = this.l;
    if (l1 > 0L) {
      return l1;
    }
    this.l = (c() * 3536);
    return this.l;
  }
  
  public boolean i()
  {
    return this.m;
  }
  
  public void j()
  {
    this.m = false;
    n();
  }
  
  public void k()
  {
    try
    {
      if (this.n != null)
      {
        b.b("MicroMsg.Mix.PcmBufferProvider", "closeCacheFileWithNoDiscard success");
        this.n.b();
        this.n = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void l()
  {
    try
    {
      m();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void m()
  {
    if (this.n == null)
    {
      this.n = new a(this.o, this.a);
      if (this.n.a())
      {
        b.b("MicroMsg.Mix.PcmBufferProvider", "openCacheFile success");
        this.n.a(h());
        return;
      }
      b.b("MicroMsg.Mix.PcmBufferProvider", "openCacheFile fail");
      this.m = false;
      n();
    }
  }
  
  public void n()
  {
    a locala = this.n;
    if (locala != null)
    {
      locala.b();
      this.n.d();
      this.n = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gm.d
 * JD-Core Version:    0.7.0.1
 */