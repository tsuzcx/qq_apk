package com.tencent.luggage.wxa.an;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.am.f;
import com.tencent.luggage.wxa.am.j;
import com.tencent.luggage.wxa.am.v;
import java.io.IOException;
import java.io.InterruptedIOException;

public final class d
  implements com.tencent.luggage.wxa.am.g
{
  private final a a;
  private final com.tencent.luggage.wxa.am.g b;
  private final com.tencent.luggage.wxa.am.g c;
  private final com.tencent.luggage.wxa.am.g d;
  @Nullable
  private final d.a e;
  private final boolean f;
  private final boolean g;
  private final boolean h;
  private com.tencent.luggage.wxa.am.g i;
  private boolean j;
  private Uri k;
  private int l;
  private String m;
  private long n;
  private long o;
  private g p;
  private boolean q;
  private boolean r;
  private long s;
  
  public d(a parama, com.tencent.luggage.wxa.am.g paramg1, com.tencent.luggage.wxa.am.g paramg2, f paramf, int paramInt, @Nullable d.a parama1)
  {
    this.a = parama;
    this.b = paramg2;
    boolean bool2 = false;
    if ((paramInt & 0x1) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.f = bool1;
    if ((paramInt & 0x2) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.g = bool1;
    boolean bool1 = bool2;
    if ((paramInt & 0x4) != 0) {
      bool1 = true;
    }
    this.h = bool1;
    this.d = paramg1;
    if (paramf != null) {
      this.c = new v(paramg1, paramf);
    } else {
      this.c = null;
    }
    this.e = parama1;
  }
  
  private void a(long paramLong)
  {
    if (this.i == this.c) {
      this.a.c(this.m, paramLong);
    }
  }
  
  private void a(IOException paramIOException)
  {
    if ((this.i == this.b) || ((paramIOException instanceof a.a))) {
      this.q = true;
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (this.r) {
      localObject1 = null;
    } else if (!this.f) {}
    try
    {
      localObject1 = this.a.a(this.m, this.n);
    }
    catch (InterruptedException localInterruptedException)
    {
      label42:
      Object localObject2;
      long l3;
      long l2;
      long l4;
      long l1;
      Object localObject3;
      boolean bool2;
      boolean bool1;
      IOException localIOException2;
      break label42;
    }
    throw new InterruptedIOException();
    Object localObject1 = this.a.b(this.m, this.n);
    if (localObject1 == null)
    {
      this.i = this.d;
      localObject1 = new j(this.k, this.n, this.o, this.m, this.l);
    }
    else if (((g)localObject1).d)
    {
      localObject2 = Uri.fromFile(((g)localObject1).e);
      l3 = this.n - ((g)localObject1).b;
      l2 = ((g)localObject1).c - l3;
      l4 = this.o;
      l1 = l2;
      if (l4 != -1L) {
        l1 = Math.min(l2, l4);
      }
      localObject1 = new j((Uri)localObject2, this.n, l3, l1, this.m, this.l);
      this.i = this.b;
    }
    else
    {
      if (((g)localObject1).a())
      {
        l1 = this.o;
      }
      else
      {
        l2 = ((g)localObject1).c;
        l3 = this.o;
        l1 = l2;
        if (l3 != -1L) {
          l1 = Math.min(l2, l3);
        }
      }
      localObject2 = new j(this.k, this.n, l1, this.m, this.l);
      localObject3 = this.c;
      if (localObject3 != null)
      {
        this.i = ((com.tencent.luggage.wxa.am.g)localObject3);
        this.p = ((g)localObject1);
        localObject1 = localObject2;
      }
      else
      {
        this.i = this.d;
        this.a.a((g)localObject1);
        localObject1 = localObject2;
      }
    }
    l1 = ((j)localObject1).e;
    bool2 = true;
    if (l1 == -1L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.j = bool1;
    l1 = 0L;
    try
    {
      l2 = this.i.a((j)localObject1);
      paramBoolean = bool2;
      l1 = l2;
    }
    catch (IOException localIOException1)
    {
      localIOException2 = localIOException1;
      if (!paramBoolean)
      {
        localIOException2 = localIOException1;
        if (this.j) {
          for (localObject3 = localIOException1;; localObject3 = ((Throwable)localObject3).getCause())
          {
            localIOException2 = localIOException1;
            if (localObject3 == null) {
              break;
            }
            if (((localObject3 instanceof com.tencent.luggage.wxa.am.h)) && (((com.tencent.luggage.wxa.am.h)localObject3).a == 0))
            {
              localIOException2 = null;
              break;
            }
          }
        }
      }
      if (localIOException2 != null) {
        break label521;
      }
    }
    paramBoolean = false;
    if ((this.j) && (l1 != -1L))
    {
      this.o = l1;
      a(((j)localObject1).d + this.o);
    }
    return paramBoolean;
    for (;;)
    {
      label521:
      throw localIOException2;
    }
  }
  
  private void c()
  {
    Object localObject1 = this.i;
    if (localObject1 == null) {
      return;
    }
    try
    {
      ((com.tencent.luggage.wxa.am.g)localObject1).a();
      this.i = null;
      this.j = false;
      localObject1 = this.p;
      if (localObject1 != null)
      {
        this.a.a((g)localObject1);
        this.p = null;
      }
      return;
    }
    finally
    {
      g localg = this.p;
      if (localg != null)
      {
        this.a.a(localg);
        this.p = null;
      }
    }
  }
  
  private void d()
  {
    d.a locala = this.e;
    if ((locala != null) && (this.s > 0L))
    {
      locala.a(this.a.a(), this.s);
      this.s = 0L;
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return 0;
    }
    if (this.o == 0L) {
      return -1;
    }
    try
    {
      int i1 = this.i.a(paramArrayOfByte, paramInt1, paramInt2);
      if (i1 >= 0)
      {
        if (this.i == this.b) {
          this.s += i1;
        }
        long l1 = this.n;
        long l2 = i1;
        this.n = (l1 + l2);
        if (this.o != -1L)
        {
          this.o -= l2;
          return i1;
        }
      }
      else
      {
        if (this.j)
        {
          a(this.n);
          this.o = 0L;
        }
        c();
        if (((this.o > 0L) || (this.o == -1L)) && (a(false)))
        {
          paramInt1 = a(paramArrayOfByte, paramInt1, paramInt2);
          return paramInt1;
        }
      }
      return i1;
    }
    catch (IOException paramArrayOfByte)
    {
      a(paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  public long a(j paramj)
  {
    for (;;)
    {
      try
      {
        this.k = paramj.a;
        this.l = paramj.g;
        this.m = h.a(paramj);
        this.n = paramj.d;
        if ((this.g) && (this.q)) {
          break label184;
        }
        if ((paramj.e != -1L) || (!this.h)) {
          break label189;
        }
      }
      catch (IOException paramj)
      {
        long l1;
        a(paramj);
        throw paramj;
      }
      this.r = bool;
      if ((paramj.e == -1L) && (!this.r))
      {
        this.o = this.a.a(this.m);
        if (this.o != -1L)
        {
          this.o -= paramj.d;
          if (this.o <= 0L) {
            throw new com.tencent.luggage.wxa.am.h(0);
          }
        }
      }
      else
      {
        this.o = paramj.e;
      }
      a(true);
      l1 = this.o;
      return l1;
      label184:
      boolean bool = true;
      continue;
      label189:
      bool = false;
    }
  }
  
  public void a()
  {
    this.k = null;
    d();
    try
    {
      c();
      return;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public Uri b()
  {
    com.tencent.luggage.wxa.am.g localg = this.i;
    if (localg == this.d) {
      return localg.b();
    }
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.an.d
 * JD-Core Version:    0.7.0.1
 */