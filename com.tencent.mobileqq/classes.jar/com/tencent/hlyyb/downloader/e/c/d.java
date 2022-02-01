package com.tencent.hlyyb.downloader.e.c;

import com.tencent.hlyyb.common.b.b;
import com.tencent.hlyyb.downloader.e.d.a;

public final class d
{
  public boolean a;
  public String b = "";
  public long c;
  public long d;
  public int e;
  public String f = "";
  public String g = "";
  public long h = -1L;
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  public String m = "";
  public int n = -1;
  public int o = -1;
  public String p = "";
  public long q;
  public String r = "";
  public String s = "";
  private int t;
  private int u;
  private int v;
  
  public d(int paramInt, a parama)
  {
    this.t = paramInt;
    this.u = parama.c;
    this.v = (parama.b - 1);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(this.t);
    localStringBuilder1.append(",").append(this.u);
    localStringBuilder1.append(",").append(this.v);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(",");
    if (this.a) {}
    for (int i1 = 1;; i1 = 0)
    {
      localStringBuilder2.append(i1);
      localStringBuilder1.append(",").append(b.b(this.b));
      localStringBuilder1.append(",").append(this.c);
      localStringBuilder1.append(",").append(this.d);
      localStringBuilder1.append(",").append(this.e);
      localStringBuilder1.append(",").append(b.b(this.f));
      localStringBuilder1.append(",").append(this.g);
      localStringBuilder1.append(",").append(this.h);
      localStringBuilder1.append(",").append(b.b(this.i));
      localStringBuilder1.append(",").append(this.j);
      localStringBuilder1.append(",").append(b.b("[" + this.k + "]"));
      localStringBuilder1.append(",").append(b.b(this.l));
      localStringBuilder1.append(",").append(b.b("[" + this.m + "]"));
      localStringBuilder1.append(",").append(this.n);
      localStringBuilder1.append(",").append(this.o);
      localStringBuilder1.append(",").append(b.b(this.p));
      localStringBuilder1.append(",").append(this.q);
      localStringBuilder1.append(",").append(this.r);
      localStringBuilder1.append(",").append(this.s);
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.c.d
 * JD-Core Version:    0.7.0.1
 */