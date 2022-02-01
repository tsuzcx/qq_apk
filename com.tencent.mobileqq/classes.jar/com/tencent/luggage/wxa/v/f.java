package com.tencent.luggage.wxa.v;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.h.l;
import java.util.Arrays;

public final class f
  extends com.tencent.luggage.wxa.h.a
  implements Handler.Callback
{
  private final d a;
  private final f.a b;
  private final Handler c;
  private final l d;
  private final e e;
  private final a[] f;
  private final long[] g;
  private int h;
  private int i;
  private b j;
  private boolean k;
  
  public f(f.a parama, Looper paramLooper)
  {
    this(parama, paramLooper, d.a);
  }
  
  public f(f.a parama, Looper paramLooper, d paramd)
  {
    super(4);
    this.b = ((f.a)com.tencent.luggage.wxa.ao.a.a(parama));
    if (paramLooper == null) {
      parama = null;
    } else {
      parama = new Handler(paramLooper, this);
    }
    this.c = parama;
    this.a = ((d)com.tencent.luggage.wxa.ao.a.a(paramd));
    this.d = new l();
    this.e = new e();
    this.f = new a[5];
    this.g = new long[5];
  }
  
  private void a(a parama)
  {
    Handler localHandler = this.c;
    if (localHandler != null)
    {
      localHandler.obtainMessage(0, parama).sendToTarget();
      return;
    }
    b(parama);
  }
  
  private void b(a parama)
  {
    this.b.a(parama);
  }
  
  private void v()
  {
    Arrays.fill(this.f, null);
    this.h = 0;
    this.i = 0;
  }
  
  public int a(k paramk)
  {
    if (this.a.a(paramk)) {
      return 4;
    }
    return 0;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    int m;
    if ((!this.k) && (this.i < 5))
    {
      this.e.a();
      if (a(this.d, this.e, false) == -4) {
        if (this.e.c())
        {
          this.k = true;
        }
        else if (!this.e.e_())
        {
          this.e.d = this.d.a.w;
          this.e.h();
          try
          {
            m = (this.h + this.i) % 5;
            this.f[m] = this.j.a(this.e);
            this.g[m] = this.e.c;
            this.i += 1;
          }
          catch (c localc)
          {
            throw com.tencent.luggage.wxa.h.e.a(localc, r());
          }
        }
      }
    }
    if (this.i > 0)
    {
      Object localObject = this.g;
      m = this.h;
      if (localObject[m] <= paramLong1)
      {
        a(this.f[m]);
        localObject = this.f;
        m = this.h;
        localObject[m] = null;
        this.h = ((m + 1) % 5);
        this.i -= 1;
      }
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    v();
    this.k = false;
  }
  
  protected void a(k[] paramArrayOfk, long paramLong)
  {
    this.j = this.a.b(paramArrayOfk[0]);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      b((a)paramMessage.obj);
      return true;
    }
    throw new IllegalStateException();
  }
  
  protected void p()
  {
    v();
    this.j = null;
  }
  
  public boolean t()
  {
    return true;
  }
  
  public boolean u()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.v.f
 * JD-Core Version:    0.7.0.1
 */