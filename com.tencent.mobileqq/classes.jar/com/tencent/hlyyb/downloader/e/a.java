package com.tencent.hlyyb.downloader.e;

import android.os.SystemClock;

public class a
{
  private long a = 0L;
  private i b;
  private long c = 0L;
  private long d = 0L;
  private int e = 0;
  private b f = new b((byte)0);
  
  public a(i parami)
  {
    this.b = parami;
  }
  
  public final void a()
  {
    this.a = SystemClock.elapsedRealtime();
    this.c = 0L;
    this.d = 0L;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.e += paramInt2;
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.a;
    this.a = l1;
    i locali = this.b;
    locali.j = (l1 - l2 + locali.j);
    this.f.a(paramInt1);
    this.b.q = this.f.a();
  }
  
  public final void b()
  {
    this.c = System.currentTimeMillis();
  }
  
  public final void c()
  {
    this.d = System.currentTimeMillis();
  }
  
  public final long d()
  {
    return this.d - this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.a
 * JD-Core Version:    0.7.0.1
 */