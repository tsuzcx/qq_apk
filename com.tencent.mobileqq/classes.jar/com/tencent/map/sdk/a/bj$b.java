package com.tencent.map.sdk.a;

import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class bj$b
  extends bj.a
{
  private String a;
  private boolean b;
  private boolean c;
  
  public bj$b(bj parambj, String paramString)
  {
    super(parambj, (byte)0);
    this.a = paramString;
    this.b = false;
    this.c = true;
  }
  
  public final void run()
  {
    bj.b(this.d).decrementAndGet();
    if (TextUtils.isEmpty(this.a)) {
      return;
    }
    int i = as.a("report_new_record_num", 1, 50, 10);
    if (!this.b)
    {
      if (bs.a(this.d.b()).b(this.a) != -1L)
      {
        if (bj.c(this.d))
        {
          bj.a(this.d, false);
          bj.b(this.d, false);
        }
        if (bj.d(this.d).incrementAndGet() >= i) {
          bj.a(this.d, this.b, this.c);
        }
        return;
      }
      bj.c();
      return;
    }
    bj.e(this.d).add(this.a);
    boolean bool = this.c;
    if (bool)
    {
      if (bj.e(this.d).size() >= i)
      {
        bj.f(this.d).set(1);
        bj.a(this.d, this.b, this.c);
        return;
      }
      if (bj.f(this.d).get() == 0)
      {
        bj.f(this.d).set(1);
        bj.b(this.d, true);
      }
    }
    else
    {
      bj.a(this.d, this.b, bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.bj.b
 * JD-Core Version:    0.7.0.1
 */