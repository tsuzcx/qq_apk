package com.tencent.liteav.videodecoder;

import java.io.InputStream;
import java.io.OutputStream;

class c
{
  protected a a = new a(50);
  int b;
  private InputStream c;
  private int d;
  private int e;
  private final OutputStream f;
  private int[] g = new int[8];
  private int h;
  
  public c(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    this.c = paramInputStream;
    this.f = paramOutputStream;
    this.d = paramInputStream.read();
    this.e = paramInputStream.read();
  }
  
  private void a(String paramString1, String paramString2) {}
  
  private void d()
  {
    this.d = this.e;
    this.e = this.c.read();
    this.b = 0;
  }
  
  private int e()
  {
    int j = 0;
    int i = 0;
    while (b(true) == 0) {
      i += 1;
    }
    if (i > 0)
    {
      long l = a(i);
      j = (int)((1 << i) - 1 + l);
    }
    return j;
  }
  
  private void f()
  {
    int i = 0;
    while (b(true) == 0) {
      i += 1;
    }
    if (i > 0) {
      b(i);
    }
  }
  
  private void g()
  {
    int[] arrayOfInt = this.g;
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = arrayOfInt[2];
    int m = arrayOfInt[3];
    int n = arrayOfInt[4];
    int i1 = arrayOfInt[5];
    int i2 = arrayOfInt[6];
    int i3 = arrayOfInt[7];
    this.f.write(i3 | i << 7 | j << 6 | k << 5 | m << 4 | n << 3 | i1 << 2 | i2 << 1);
  }
  
  public int a(String paramString)
  {
    int i = e();
    a(paramString, String.valueOf(i));
    return i;
  }
  
  public long a(int paramInt)
  {
    if (paramInt <= 64)
    {
      long l = 0L;
      int i = 0;
      while (i < paramInt)
      {
        l = l << 1 | b(true);
        i += 1;
      }
      return l;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can not readByte more then 64 bit");
    for (;;)
    {
      throw localIllegalArgumentException;
    }
  }
  
  public long a(int paramInt, String paramString)
  {
    long l = a(paramInt);
    a(paramString, String.valueOf(l));
    return l;
  }
  
  public long a(int paramInt, boolean paramBoolean)
  {
    if (paramInt <= 64)
    {
      long l = 0L;
      int i = 0;
      while (i < paramInt)
      {
        l = l << 1 | b(paramBoolean);
        i += 1;
      }
      return l;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can not readByte more then 64 bit");
    for (;;)
    {
      throw localIllegalArgumentException;
    }
  }
  
  public void a()
  {
    int i = this.h;
    while (i < 8)
    {
      this.g[i] = 0;
      i += 1;
    }
    this.h = 0;
    g();
  }
  
  public void a(long paramLong, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      d((int)(paramLong >> paramInt - i - 1) & 0x1);
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a(boolean paramBoolean)
  {
    return b(paramBoolean) == 1;
  }
  
  public int b(boolean paramBoolean)
  {
    if (this.b == 8)
    {
      d();
      if (this.d == -1) {
        return -1;
      }
    }
    int j = this.d;
    int i = this.b;
    j = j >> 7 - i & 0x1;
    this.b = (i + 1);
    if ((paramBoolean) && (this.f != null)) {
      d(j);
    }
    return j;
  }
  
  public void b()
  {
    a(0L, 8 - this.h);
  }
  
  public void b(int paramInt)
  {
    if (paramInt <= 64)
    {
      int i = 0;
      while (i < paramInt)
      {
        b(true);
        i += 1;
      }
      return;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Can not skip more then 64 bit");
    for (;;)
    {
      throw localIllegalArgumentException;
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    b(paramInt);
    a(paramString, "skip NBits");
  }
  
  public void b(String paramString)
  {
    f();
    a(paramString, "skip UE");
  }
  
  public int c(String paramString)
  {
    int i = e();
    int j = i & 0x1;
    i = ((i >> 1) + j) * ((j << 1) - 1);
    a(paramString, String.valueOf(i));
    return i;
  }
  
  public int c(boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    while (b(paramBoolean) == 0) {
      i += 1;
    }
    if (i > 0)
    {
      long l = a(i, paramBoolean);
      j = (int)((1 << i) - 1 + l);
    }
    return j;
  }
  
  public void c()
  {
    d(1);
    b();
    a();
  }
  
  public void c(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    int m = 8;
    int k = 0;
    int j = 8;
    while (k < paramInt)
    {
      int i = m;
      if (m != 0) {
        i = (c("deltaScale") + j + 256) % 256;
      }
      if (i != 0) {
        j = i;
      }
      arrayOfInt[k] = j;
      j = arrayOfInt[k];
      k += 1;
      m = i;
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    e(paramInt);
  }
  
  public void d(int paramInt)
  {
    if (this.h == 8)
    {
      this.h = 0;
      g();
    }
    int[] arrayOfInt = this.g;
    int i = this.h;
    this.h = (i + 1);
    arrayOfInt[i] = paramInt;
  }
  
  public boolean d(String paramString)
  {
    boolean bool = a(true);
    String str;
    if (bool) {
      str = "1";
    } else {
      str = "0";
    }
    a(paramString, str);
    return bool;
  }
  
  public void e(int paramInt)
  {
    int m = 0;
    int i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      k = m;
      if (i >= 15) {
        break;
      }
      k = (1 << i) + j;
      if (paramInt < k)
      {
        k = i;
        break;
      }
      i += 1;
    }
    a(0L, k);
    d(1);
    a(paramInt - j, k);
  }
  
  public boolean e(String paramString)
  {
    boolean bool = a(false);
    String str;
    if (bool) {
      str = "1";
    } else {
      str = "0";
    }
    a(paramString, str);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.c
 * JD-Core Version:    0.7.0.1
 */