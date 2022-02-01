package com.tencent.luggage.wxa.ac;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.luggage.wxa.ab.d;
import com.tencent.luggage.wxa.am.t;
import com.tencent.luggage.wxa.am.t.a;
import com.tencent.luggage.wxa.am.u;
import com.tencent.luggage.wxa.am.u.a;
import com.tencent.luggage.wxa.h.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

public final class e
  implements t.a<u<c>>
{
  private final Uri a;
  private final d b;
  private final u.a<c> c;
  private final int d;
  private final IdentityHashMap<a.a, e.a> e;
  private final Handler f;
  private final e.e g;
  private final List<e.b> h;
  private final t i;
  private final com.tencent.luggage.wxa.z.a.a j;
  private a k;
  private a.a l;
  private b m;
  private boolean n;
  
  public e(Uri paramUri, d paramd, com.tencent.luggage.wxa.z.a.a parama, int paramInt, e.e parame, u.a<c> parama1)
  {
    this.a = paramUri;
    this.b = paramd;
    this.j = parama;
    this.d = paramInt;
    this.g = parame;
    this.c = parama1;
    this.h = new ArrayList();
    this.i = new t("HlsPlaylistTracker:MasterPlaylist");
    this.e = new IdentityHashMap();
    this.f = new Handler();
  }
  
  private b a(b paramb1, b paramb2)
  {
    if (!paramb2.a(paramb1))
    {
      b localb = paramb1;
      if (paramb2.j) {
        localb = paramb1.b();
      }
      return localb;
    }
    return paramb2.a(b(paramb1, paramb2), c(paramb1, paramb2));
  }
  
  private void a(a.a parama, long paramLong)
  {
    int i2 = this.h.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((e.b)this.h.get(i1)).a(parama, paramLong);
      i1 += 1;
    }
  }
  
  private void a(a.a parama, b paramb)
  {
    if (parama == this.l)
    {
      if (this.m == null) {
        this.n = (paramb.j ^ true);
      }
      this.m = paramb;
      this.g.a(paramb);
    }
    int i2 = this.h.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((e.b)this.h.get(i1)).h();
      i1 += 1;
    }
  }
  
  private void a(List<a.a> paramList)
  {
    int i2 = paramList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      a.a locala = (a.a)paramList.get(i1);
      e.a locala1 = new e.a(this, locala);
      this.e.put(locala, locala1);
      i1 += 1;
    }
  }
  
  private long b(b paramb1, b paramb2)
  {
    if (paramb2.k) {
      return paramb2.c;
    }
    Object localObject = this.m;
    long l1;
    if (localObject != null) {
      l1 = ((b)localObject).c;
    } else {
      l1 = 0L;
    }
    if (paramb1 == null) {
      return l1;
    }
    int i1 = paramb1.m.size();
    localObject = d(paramb1, paramb2);
    if (localObject != null) {
      return paramb1.c + ((b.a)localObject).d;
    }
    if (i1 == paramb2.f - paramb1.f) {
      return paramb1.a();
    }
    return l1;
  }
  
  private int c(b paramb1, b paramb2)
  {
    if (paramb2.d) {
      return paramb2.e;
    }
    Object localObject = this.m;
    int i1;
    if (localObject != null) {
      i1 = ((b)localObject).e;
    } else {
      i1 = 0;
    }
    if (paramb1 == null) {
      return i1;
    }
    localObject = d(paramb1, paramb2);
    if (localObject != null) {
      return paramb1.e + ((b.a)localObject).c - ((b.a)paramb2.m.get(0)).c;
    }
    return i1;
  }
  
  private static b.a d(b paramb1, b paramb2)
  {
    int i1 = paramb2.f - paramb1.f;
    paramb1 = paramb1.m;
    if (i1 < paramb1.size()) {
      return (b.a)paramb1.get(i1);
    }
    return null;
  }
  
  private void e(a.a parama)
  {
    if ((parama != this.l) && (this.k.a.contains(parama)))
    {
      b localb = this.m;
      if ((localb != null) && (localb.j)) {
        return;
      }
      this.l = parama;
      ((e.a)this.e.get(this.l)).d();
    }
  }
  
  private boolean f()
  {
    List localList = this.k.a;
    int i2 = localList.size();
    long l1 = SystemClock.elapsedRealtime();
    int i1 = 0;
    while (i1 < i2)
    {
      e.a locala = (e.a)this.e.get(localList.get(i1));
      if (l1 > e.a.a(locala))
      {
        this.l = e.a.b(locala);
        locala.d();
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public int a(u<c> paramu, long paramLong1, long paramLong2, IOException paramIOException)
  {
    boolean bool = paramIOException instanceof p;
    this.j.a(paramu.a, 4, paramLong1, paramLong2, paramu.e(), paramIOException, bool);
    if (bool) {
      return 3;
    }
    return 0;
  }
  
  public b a(a.a parama)
  {
    b localb = ((e.a)this.e.get(parama)).a();
    if (localb != null) {
      e(parama);
    }
    return localb;
  }
  
  public void a()
  {
    u localu = new u(this.b.a(4), this.a, 4, this.c);
    this.i.a(localu, this, this.d);
  }
  
  public void a(e.b paramb)
  {
    this.h.add(paramb);
  }
  
  public void a(u<c> paramu, long paramLong1, long paramLong2)
  {
    c localc = (c)paramu.d();
    boolean bool = localc instanceof b;
    if (bool)
    {
      if (((b)localc).j) {
        this.j.a();
      }
      localObject = a.a(localc.o);
    }
    else
    {
      localObject = (a)localc;
    }
    this.k = ((a)localObject);
    this.l = ((a.a)((a)localObject).a.get(0));
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((a)localObject).a);
    localArrayList.addAll(((a)localObject).b);
    localArrayList.addAll(((a)localObject).c);
    a(localArrayList);
    Object localObject = (e.a)this.e.get(this.l);
    if (bool) {
      e.a.a((e.a)localObject, (b)localc);
    } else {
      ((e.a)localObject).d();
    }
    this.j.a(paramu.a, 4, paramLong1, paramLong2, paramu.e());
  }
  
  public void a(u<c> paramu, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.j.b(paramu.a, 4, paramLong1, paramLong2, paramu.e());
  }
  
  public a b()
  {
    return this.k;
  }
  
  public void b(e.b paramb)
  {
    this.h.remove(paramb);
  }
  
  public boolean b(a.a parama)
  {
    return ((e.a)this.e.get(parama)).b();
  }
  
  public void c()
  {
    this.i.c();
    Iterator localIterator = this.e.values().iterator();
    while (localIterator.hasNext()) {
      ((e.a)localIterator.next()).c();
    }
    this.f.removeCallbacksAndMessages(null);
    this.e.clear();
  }
  
  public void c(a.a parama)
  {
    ((e.a)this.e.get(parama)).e();
  }
  
  public void d()
  {
    this.i.d();
    a.a locala = this.l;
    if (locala != null) {
      c(locala);
    }
  }
  
  public void d(a.a parama)
  {
    ((e.a)this.e.get(parama)).d();
  }
  
  public boolean e()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ac.e
 * JD-Core Version:    0.7.0.1
 */