package com.tencent.luggage.wxa.am;

import android.os.Handler;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.c;
import com.tencent.luggage.wxa.ao.r;

public final class l
  implements d, w<Object>
{
  private final Handler a;
  private final d.a b;
  private final r c;
  private final c d;
  private int e;
  private long f;
  private long g;
  private long h;
  private long i;
  private long j;
  
  public l()
  {
    this(null, null);
  }
  
  public l(Handler paramHandler, d.a parama)
  {
    this(paramHandler, parama, 2000);
  }
  
  public l(Handler paramHandler, d.a parama, int paramInt)
  {
    this(paramHandler, parama, paramInt, c.a);
  }
  
  public l(Handler paramHandler, d.a parama, int paramInt, c paramc)
  {
    this.a = paramHandler;
    this.b = parama;
    this.c = new r(paramInt);
    this.d = paramc;
    this.j = -1L;
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2)
  {
    Handler localHandler = this.a;
    if ((localHandler != null) && (this.b != null)) {
      localHandler.post(new l.1(this, paramInt, paramLong1, paramLong2));
    }
  }
  
  public long a()
  {
    try
    {
      long l = this.j;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(Object paramObject)
  {
    for (;;)
    {
      float f1;
      try
      {
        if (this.e > 0)
        {
          bool = true;
          a.b(bool);
          long l2 = this.d.a();
          int k = (int)(l2 - this.f);
          l1 = this.h;
          long l3 = k;
          this.h = (l1 + l3);
          this.i += this.g;
          if (k > 0)
          {
            f1 = (float)(this.g * 8000L / l3);
            this.c.a((int)Math.sqrt(this.g), f1);
            if ((this.h >= 2000L) || (this.i >= 524288L))
            {
              f1 = this.c.a(0.5F);
              if (!Float.isNaN(f1)) {
                break label213;
              }
              l1 = -1L;
              this.j = l1;
            }
          }
          a(k, this.g, this.j);
          k = this.e - 1;
          this.e = k;
          if (k > 0) {
            this.f = l2;
          }
          this.g = 0L;
          return;
        }
      }
      finally {}
      boolean bool = false;
      continue;
      label213:
      long l1 = f1;
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    try
    {
      this.g += paramInt;
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public void a(Object paramObject, j paramj)
  {
    try
    {
      if (this.e == 0) {
        this.f = this.d.a();
      }
      this.e += 1;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.am.l
 * JD-Core Version:    0.7.0.1
 */