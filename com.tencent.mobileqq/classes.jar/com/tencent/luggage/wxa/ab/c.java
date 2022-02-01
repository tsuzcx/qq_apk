package com.tencent.luggage.wxa.ab;

import android.net.Uri;
import com.tencent.luggage.wxa.aa.a;
import com.tencent.luggage.wxa.ac.a.a;
import com.tencent.luggage.wxa.ac.b.a;
import com.tencent.luggage.wxa.am.g;
import com.tencent.luggage.wxa.am.j;
import com.tencent.luggage.wxa.ao.u;
import com.tencent.luggage.wxa.ao.w;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.z.n;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

class c
{
  private final g a;
  private final g b;
  private final k c;
  private final a.a[] d;
  private final com.tencent.luggage.wxa.ac.e e;
  private final n f;
  private final List<com.tencent.luggage.wxa.h.k> g;
  private boolean h;
  private byte[] i;
  private IOException j;
  private a.a k;
  private boolean l;
  private Uri m;
  private byte[] n;
  private String o;
  private byte[] p;
  private com.tencent.luggage.wxa.al.e q;
  
  public c(com.tencent.luggage.wxa.ac.e parame, a.a[] paramArrayOfa, d paramd, k paramk, List<com.tencent.luggage.wxa.h.k> paramList)
  {
    this.e = parame;
    this.d = paramArrayOfa;
    this.c = paramk;
    this.g = paramList;
    parame = new com.tencent.luggage.wxa.h.k[paramArrayOfa.length];
    paramk = new int[paramArrayOfa.length];
    int i1 = 0;
    while (i1 < paramArrayOfa.length)
    {
      parame[i1] = paramArrayOfa[i1].b;
      paramk[i1] = i1;
      i1 += 1;
    }
    this.a = paramd.a(1);
    this.b = paramd.a(3);
    this.f = new n(parame);
    this.q = new c.c(this.f, paramk);
  }
  
  private c.a a(Uri paramUri, String paramString, int paramInt1, int paramInt2, Object paramObject)
  {
    paramUri = new j(paramUri, 0L, -1L, null, 1);
    return new c.a(this.b, paramUri, this.d[paramInt1].b, paramInt2, paramObject, this.i, paramString);
  }
  
  private void a(Uri paramUri, String paramString, byte[] paramArrayOfByte)
  {
    if (x.d(paramString).startsWith("0x")) {
      localObject = paramString.substring(2);
    } else {
      localObject = paramString;
    }
    Object localObject = new BigInteger((String)localObject, 16).toByteArray();
    byte[] arrayOfByte = new byte[16];
    int i1;
    if (localObject.length > 16) {
      i1 = localObject.length - 16;
    } else {
      i1 = 0;
    }
    System.arraycopy(localObject, i1, arrayOfByte, arrayOfByte.length - localObject.length + i1, localObject.length - i1);
    this.m = paramUri;
    this.n = paramArrayOfByte;
    this.o = paramString;
    this.p = arrayOfByte;
  }
  
  private void e()
  {
    this.m = null;
    this.n = null;
    this.o = null;
    this.p = null;
  }
  
  public void a()
  {
    Object localObject = this.j;
    if (localObject == null)
    {
      localObject = this.k;
      if (localObject != null) {
        this.e.c((a.a)localObject);
      }
      return;
    }
    throw ((Throwable)localObject);
  }
  
  public void a(a parama)
  {
    if ((parama instanceof c.a))
    {
      parama = (c.a)parama;
      this.i = parama.e();
      a(parama.a.a, parama.i, parama.f());
    }
  }
  
  public void a(f paramf, long paramLong, c.b paramb)
  {
    if (paramf == null) {
      i2 = -1;
    } else {
      i2 = this.f.a(paramf.c);
    }
    u localu = null;
    this.k = null;
    long l1 = 0L;
    if (paramf != null)
    {
      if (this.l) {
        l1 = paramf.g;
      } else {
        l1 = paramf.f;
      }
      l1 = Math.max(0L, l1 - paramLong);
    }
    this.q.a(l1);
    int i4 = this.q.g();
    boolean bool = false;
    int i1;
    if (i2 != i4) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Object localObject3 = this.d[i4];
    if (!this.e.b((a.a)localObject3))
    {
      paramb.c = ((a.a)localObject3);
      this.k = ((a.a)localObject3);
      return;
    }
    Object localObject4 = this.e.a((a.a)localObject3);
    this.l = ((com.tencent.luggage.wxa.ac.b)localObject4).i;
    Object localObject2;
    int i3;
    if ((paramf != null) && (i1 == 0))
    {
      i1 = paramf.e();
      localObject1 = localObject4;
      localObject2 = localObject3;
      i3 = i4;
    }
    for (;;)
    {
      break;
      if (paramf != null) {
        if (this.l) {
          paramLong = paramf.g;
        } else {
          paramLong = paramf.f;
        }
      }
      if ((!((com.tencent.luggage.wxa.ac.b)localObject4).j) && (paramLong >= ((com.tencent.luggage.wxa.ac.b)localObject4).a()))
      {
        i1 = ((com.tencent.luggage.wxa.ac.b)localObject4).f + ((com.tencent.luggage.wxa.ac.b)localObject4).m.size();
        i3 = i4;
        localObject2 = localObject3;
        localObject1 = localObject4;
      }
      else
      {
        localObject1 = ((com.tencent.luggage.wxa.ac.b)localObject4).m;
        l1 = ((com.tencent.luggage.wxa.ac.b)localObject4).c;
        if ((!this.e.e()) || (paramf == null)) {
          bool = true;
        }
        int i5 = x.a((List)localObject1, Long.valueOf(paramLong - l1), true, bool) + ((com.tencent.luggage.wxa.ac.b)localObject4).f;
        i3 = i4;
        i1 = i5;
        localObject2 = localObject3;
        localObject1 = localObject4;
        if (i5 < ((com.tencent.luggage.wxa.ac.b)localObject4).f)
        {
          i3 = i4;
          i1 = i5;
          localObject2 = localObject3;
          localObject1 = localObject4;
          if (paramf != null)
          {
            localObject2 = this.d[i2];
            localObject1 = this.e.a((a.a)localObject2);
            i1 = paramf.e();
            i3 = i2;
          }
        }
      }
    }
    if (i1 < ((com.tencent.luggage.wxa.ac.b)localObject1).f)
    {
      this.j = new com.tencent.luggage.wxa.z.b();
      return;
    }
    int i2 = i1 - ((com.tencent.luggage.wxa.ac.b)localObject1).f;
    if (i2 >= ((com.tencent.luggage.wxa.ac.b)localObject1).m.size())
    {
      if (((com.tencent.luggage.wxa.ac.b)localObject1).j)
      {
        paramb.b = true;
        return;
      }
      paramb.c = ((a.a)localObject2);
      this.k = ((a.a)localObject2);
      return;
    }
    localObject4 = (b.a)((com.tencent.luggage.wxa.ac.b)localObject1).m.get(i2);
    if (((b.a)localObject4).e)
    {
      localObject3 = w.a(((com.tencent.luggage.wxa.ac.b)localObject1).o, ((b.a)localObject4).f);
      if (!((Uri)localObject3).equals(this.m))
      {
        paramb.a = a((Uri)localObject3, ((b.a)localObject4).g, i3, this.q.b(), this.q.c());
        return;
      }
      if (!x.a(((b.a)localObject4).g, this.o)) {
        a((Uri)localObject3, ((b.a)localObject4).g, this.n);
      }
    }
    else
    {
      e();
    }
    b.a locala = ((com.tencent.luggage.wxa.ac.b)localObject1).l;
    localObject3 = localu;
    if (locala != null) {
      localObject3 = new j(w.a(((com.tencent.luggage.wxa.ac.b)localObject1).o, locala.a), locala.h, locala.i, null);
    }
    paramLong = ((com.tencent.luggage.wxa.ac.b)localObject1).c + ((b.a)localObject4).d;
    i2 = ((com.tencent.luggage.wxa.ac.b)localObject1).e + ((b.a)localObject4).c;
    localu = this.c.a(i2);
    Object localObject1 = new j(w.a(((com.tencent.luggage.wxa.ac.b)localObject1).o, ((b.a)localObject4).a), ((b.a)localObject4).h, ((b.a)localObject4).i, null);
    paramb.a = new f(this.a, (j)localObject1, (j)localObject3, (a.a)localObject2, this.g, this.q.b(), this.q.c(), paramLong, paramLong + ((b.a)localObject4).b, i1, i2, this.h, localu, paramf, this.n, this.p);
  }
  
  public void a(a.a parama, long paramLong)
  {
    int i1 = this.f.a(parama.b);
    if (i1 != -1)
    {
      i1 = this.q.c(i1);
      if (i1 != -1) {
        this.q.a(i1, paramLong);
      }
    }
  }
  
  public void a(com.tencent.luggage.wxa.al.e parame)
  {
    this.q = parame;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a(a parama, boolean paramBoolean, IOException paramIOException)
  {
    if (paramBoolean)
    {
      com.tencent.luggage.wxa.al.e locale = this.q;
      if (com.tencent.luggage.wxa.aa.b.a(locale, locale.c(this.f.a(parama.c)), paramIOException)) {
        return true;
      }
    }
    return false;
  }
  
  public n b()
  {
    return this.f;
  }
  
  public com.tencent.luggage.wxa.al.e c()
  {
    return this.q;
  }
  
  public void d()
  {
    this.j = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ab.c
 * JD-Core Version:    0.7.0.1
 */