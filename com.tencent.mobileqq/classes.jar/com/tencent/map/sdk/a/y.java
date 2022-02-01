package com.tencent.map.sdk.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class y
  implements u
{
  public String a;
  public byte[] b;
  public Map<String, String> c;
  public boolean d = false;
  public boolean e = true;
  public int f = -1;
  public String g = "";
  public s h;
  public au i;
  public volatile boolean j = false;
  public int k = 0;
  public boolean l = true;
  CountDownLatch m = new CountDownLatch(1);
  public volatile boolean n = false;
  public String o;
  private Object p;
  private int q = 0;
  private bh r;
  
  public y(String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
    this.g = dg.d();
  }
  
  public final void a()
  {
    this.j = true;
    au localau = this.i;
    if (localau != null) {
      localau.b();
    }
  }
  
  public final void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void a(bh parambh)
  {
    try
    {
      this.r = parambh;
      return;
    }
    finally
    {
      parambh = finally;
      throw parambh;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (this.c == null) {
      this.c = new HashMap();
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      this.c.put(paramString1, paramString2);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final void b(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    this.k = paramInt;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public final boolean b()
  {
    try
    {
      boolean bool = this.m.await(this.k, TimeUnit.MILLISECONDS);
      return bool;
    }
    catch (InterruptedException localInterruptedException)
    {
      label18:
      break label18;
    }
    return true;
  }
  
  public final bh c()
  {
    try
    {
      bh localbh = this.r;
      return localbh;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("url:");
    localStringBuilder2.append(this.a);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",body:");
    localStringBuilder2.append(dg.b(this.b));
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",isGet:");
    localStringBuilder2.append(this.d);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",timeout:");
    localStringBuilder2.append(this.f);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",tag:");
    localStringBuilder2.append(this.p);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",httpCallback:");
    localStringBuilder2.append(this.h);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",testMode:");
    localStringBuilder2.append(this.q);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",httpCallback:");
    localStringBuilder2.append(this.h);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",testMode:");
    localStringBuilder2.append(this.q);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",followRedirects:");
    localStringBuilder2.append(this.e);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",isAbort:");
    localStringBuilder2.append(this.j);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",headers:");
    localStringBuilder2.append(this.c);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.y
 * JD-Core Version:    0.7.0.1
 */