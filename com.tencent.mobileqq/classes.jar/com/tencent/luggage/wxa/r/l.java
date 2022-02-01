package com.tencent.luggage.wxa.r;

import android.util.Log;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.l.f;

public final class l
  implements h
{
  private final m a = new m(10);
  private com.tencent.luggage.wxa.l.l b;
  private boolean c;
  private long d;
  private int e;
  private int f;
  
  public void a()
  {
    this.c = false;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.c = true;
    this.d = paramLong;
    this.e = 0;
    this.f = 0;
  }
  
  public void a(m paramm)
  {
    if (!this.c) {
      return;
    }
    int i = paramm.b();
    int j = this.f;
    if (j < 10)
    {
      j = Math.min(i, 10 - j);
      System.arraycopy(paramm.a, paramm.d(), this.a.a, this.f, j);
      if (this.f + j == 10)
      {
        this.a.c(0);
        if ((73 == this.a.g()) && (68 == this.a.g()) && (51 == this.a.g()))
        {
          this.a.d(3);
          this.e = (this.a.s() + 10);
        }
        else
        {
          Log.w("Id3Reader", "Discarding invalid ID3 tag");
          this.c = false;
          return;
        }
      }
    }
    i = Math.min(i, this.e - this.f);
    this.b.a(paramm, i);
    this.f += i;
  }
  
  public void a(f paramf, v.d paramd)
  {
    paramd.a();
    this.b = paramf.a(paramd.b(), 4);
    this.b.a(k.a(paramd.c(), "application/id3", null, -1, null));
  }
  
  public void b()
  {
    if (this.c)
    {
      int i = this.e;
      if (i != 0)
      {
        if (this.f != i) {
          return;
        }
        this.b.a(this.d, 1, i, 0, null);
        this.c = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.l
 * JD-Core Version:    0.7.0.1
 */