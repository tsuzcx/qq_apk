package com.tencent.map.sdk.a;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class bj$c
  extends bj.a
{
  private bj.d a;
  
  public bj$c(bj parambj, bj.d paramd)
  {
    super(parambj, (byte)0);
    this.a = paramd;
  }
  
  public final void run()
  {
    bj.g(this.b);
    bj.a(this.b, SystemClock.elapsedRealtime());
    boolean bool = this.a.d;
    int i = 0;
    int j = 0;
    if (bool)
    {
      if (bj.j(this.b) > 0) {
        bj.k(this.b);
      }
      this.b.a.addAndGet(this.a.f);
      if (!this.a.b)
      {
        int k = this.a.e.size();
        ArrayList localArrayList = new ArrayList();
        i = j;
        while (i < k)
        {
          localArrayList.add(Long.valueOf(((bs.a)this.a.e.get(i)).a));
          i += 1;
        }
        bs.a(this.b.b()).a(localArrayList);
        if (bj.l(this.b))
        {
          bj.m(this.b);
          bj.a(this.b, true, this.a.c);
          return;
        }
      }
      if (!this.a.a)
      {
        SystemClock.sleep(200L);
        bj.a(this.b, this.a.b, this.a.c);
        return;
      }
      bj.a(this.b, true);
      return;
    }
    if (ao.i()) {
      if (bj.j(this.b) > 0)
      {
        j = as.a("report_interval_forbid_limit", 30, 1440, 60);
        if (bj.j(this.b) < j) {
          bj.n(this.b);
        }
      }
      else
      {
        bj.o(this.b);
      }
    }
    if ((this.a.c) && (this.a.b))
    {
      j = this.a.e.size();
      while (i < j)
      {
        bs.a(this.b.b()).b(((bs.a)this.a.e.get(i)).b);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.bj.c
 * JD-Core Version:    0.7.0.1
 */