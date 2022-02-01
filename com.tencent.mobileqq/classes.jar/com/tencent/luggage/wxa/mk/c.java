package com.tencent.luggage.wxa.mk;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.am.g.a;
import com.tencent.luggage.wxa.am.k;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.f.a;
import com.tencent.luggage.wxa.h.f.c;
import com.tencent.luggage.wxa.h.q;
import com.tencent.luggage.wxa.h.s;
import com.tencent.luggage.wxa.ma.j;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
  extends com.tencent.luggage.wxa.mi.a
{
  private HandlerThread A;
  private f B;
  private int C;
  private int D;
  private int E;
  private boolean F;
  private boolean G;
  private volatile boolean H;
  private final AtomicBoolean I = new AtomicBoolean();
  private final AtomicBoolean J = new AtomicBoolean(false);
  private int K = 0;
  protected int i = 0;
  protected float j = 0.75F;
  protected int k = 10000;
  protected int l = 25000;
  protected int m = 15000;
  protected int n = 30000;
  protected int o = 2500;
  protected int p = 5000;
  private Context q;
  private com.tencent.luggage.wxa.h.f r;
  private Surface s;
  private boolean t;
  private c.e u;
  private com.tencent.luggage.wxa.z.h v;
  private List<s> w;
  private f.a x;
  private c.b y;
  private Handler z;
  
  public c()
  {
    this(null);
  }
  
  public c(Handler paramHandler)
  {
    this(paramHandler, 0, 0.75F, 10000, 25000, 15000, 30000, 2500, 5000);
  }
  
  public c(Handler paramHandler, int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    o.d("MicroMsg.SameLayer.ExoMediaPlayer", "ExoMediaPlayer, handler = %s, maxInitBitrate = %s, bandFraction = %s, minDur = %s, maxDur = %s, minBuffer = %s, maxBuffer = %s, bufferForPlaybackMs:%s, bufferForPlaybackAfterRebufferMs:%s", new Object[] { paramHandler, Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7) });
    a(paramInt1, paramFloat, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    a(paramHandler);
  }
  
  private int a(Uri paramUri)
  {
    if (paramUri != null)
    {
      paramUri = paramUri.toString();
      if ((paramUri.contains(".m3u8")) || (paramUri.contains(".m3u"))) {
        return 2;
      }
    }
    return 3;
  }
  
  private com.tencent.luggage.wxa.z.h a(Uri paramUri, @Nullable String paramString)
  {
    int i1 = a(paramUri);
    paramString = com.tencent.luggage.wxa.lr.d.a(paramString);
    if (i1 != 2)
    {
      if (i1 != 3)
      {
        paramString = new StringBuilder();
        paramString.append("buildMediaSource, unsupported type:");
        paramString.append(i1);
        paramString.append(", url:");
        paramString.append(paramUri);
        o.b("MicroMsg.SameLayer.ExoMediaPlayer", paramString.toString());
        return null;
      }
      o.d("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:other, url:%s", new Object[] { paramUri });
      return new com.tencent.luggage.wxa.z.f(paramUri, a(paramString), s(), this.z, this.y);
    }
    o.d("MicroMsg.SameLayer.ExoMediaPlayer", "buildMediaSource, type:HLS, url:%s", new Object[] { paramUri });
    return new com.tencent.luggage.wxa.ab.h(paramUri, d.a(this.q, paramString), this.z, this.y);
  }
  
  private void a(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.i = 0;
    this.j = paramFloat;
    this.k = paramInt2;
    this.l = paramInt3;
    this.m = paramInt4;
    this.n = paramInt5;
    this.o = paramInt6;
    this.p = paramInt7;
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject)
  {
    a(paramInt1, paramInt2, paramObject, false);
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    if (this.w.isEmpty()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext())
    {
      s locals = (s)localIterator.next();
      if (locals.a() == paramInt1) {
        localArrayList.add(new f.c(locals, paramInt2, paramObject));
      }
    }
    if (paramBoolean)
    {
      this.r.b((f.c[])localArrayList.toArray(new f.c[localArrayList.size()]));
      return;
    }
    this.r.a((f.c[])localArrayList.toArray(new f.c[localArrayList.size()]));
  }
  
  private void a(Handler paramHandler)
  {
    this.q = r.a();
    this.u = new c.e(null);
    if (paramHandler != null)
    {
      this.z = paramHandler;
    }
    else
    {
      this.A = com.tencent.luggage.wxa.sc.d.b("ExoMediaPlayer_HandlerThread", 5);
      this.A.start();
      this.z = new Handler(this.A.getLooper());
    }
    this.x = new c.c(this, null);
    this.y = new c.b(this, null);
    this.B = new f(this.z);
    this.B.a(1000);
    this.B.a(new c.a(this, null));
    c.d locald = new c.d(this, null);
    this.w = new a(this.q, this.z, locald, locald, locald, locald).a();
    if ((paramHandler != null) && (paramHandler.getLooper() == Looper.myLooper()))
    {
      u();
      return;
    }
    this.z.post(new c.1(this));
    for (;;)
    {
      try
      {
        paramHandler = this.r;
        if (paramHandler != null) {
          break;
        }
      }
      finally
      {
        continue;
        throw paramHandler;
        continue;
      }
      try
      {
        wait();
      }
      catch (InterruptedException paramHandler)
      {
        continue;
      }
      Thread.currentThread().interrupt();
    }
  }
  
  private void a(Surface paramSurface, boolean paramBoolean)
  {
    if (v())
    {
      Surface localSurface = this.s;
      if ((localSurface != null) && (localSurface != paramSurface) && (paramSurface != null))
      {
        if (this.t) {
          localSurface.release();
        }
        a(2, 1, paramSurface, true);
        long l1 = this.r.h();
        if (x.a < 23) {
          this.z.postDelayed(new c.2(this, l1), 200L);
        }
      }
      else
      {
        a(2, 1, paramSurface, false);
      }
      this.s = paramSurface;
      this.t = paramBoolean;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBufferRepeaterStarted ");
    localStringBuilder.append(paramBoolean);
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", localStringBuilder.toString());
    if ((paramBoolean) && (this.f != null))
    {
      this.B.a();
      return;
    }
    this.B.b();
  }
  
  private void u()
  {
    o.d("MicroMsg.SameLayer.ExoMediaPlayer", "iniMediaPlayer");
    com.tencent.luggage.wxa.al.b localb = new com.tencent.luggage.wxa.al.b(new com.tencent.luggage.wxa.mj.c.b(d.b(), this.i, this.k, this.l, 25000, this.j));
    com.tencent.luggage.wxa.h.c localc = new com.tencent.luggage.wxa.h.c(new k(true, 65536), this.m, this.n, this.o, this.p);
    List localList = this.w;
    this.r = com.tencent.luggage.wxa.h.g.a((s[])localList.toArray(new s[localList.size()]), localb, localc);
    this.r.a(this.x);
  }
  
  private boolean v()
  {
    return this.r != null;
  }
  
  private int w()
  {
    if (v()) {
      return this.r.j();
    }
    return 0;
  }
  
  private void x()
  {
    o.e("MicroMsg.SameLayer.ExoMediaPlayer", "dispatchOnErrorWorkaroundWhenLoadErrorIfNeed");
    this.K += 1;
    if ((6 <= this.K) && (!d.b(this.q)))
    {
      o.e("MicroMsg.SameLayer.ExoMediaPlayer", "dispatchOnErrorWorkaroundWhenLoadErrorIfNeed, notifyOnError");
      b(-1, -2);
    }
  }
  
  private void y()
  {
    for (;;)
    {
      int i2;
      try
      {
        if ((this.r != null) && (!this.H))
        {
          int i1 = this.r.a();
          boolean bool1 = this.r.b();
          i2 = this.u.b(bool1, i1);
          if (i2 != this.u.a())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("reportPlayerState, set new recent state [");
            localStringBuilder.append(bool1);
            localStringBuilder.append(",");
            localStringBuilder.append(i1);
            localStringBuilder.append("]");
            o.d("MicroMsg.SameLayer.ExoMediaPlayer", localStringBuilder.toString());
            this.u.a(bool1, i1);
            if (i2 != 3) {
              break label553;
            }
            c(true);
            continue;
            c(false);
            if (i2 == this.u.b(true, 4))
            {
              o.d("MicroMsg.SameLayer.ExoMediaPlayer", "reportPlayerState, isSeeking: %b, loopingPlaySeek: %b", new Object[] { Boolean.valueOf(this.J.get()), Boolean.valueOf(this.G) });
              if ((this.J.getAndSet(false)) && (!this.G)) {
                e();
              }
              if (t())
              {
                o.d("MicroMsg.SameLayer.ExoMediaPlayer", "looping play start");
                this.G = true;
                a(0L);
              }
              else
              {
                a(6);
                d();
              }
              return;
            }
            if (this.u.a(new int[] { this.u.b(false, 1), this.u.b(false, 2), this.u.b(false, 3) }, false))
            {
              a(2);
              c();
              return;
            }
            bool1 = this.u.a(new int[] { 100, 2, 3 }, true);
            boolean bool2 = this.u.a(new int[] { 2, 100, 3 }, true);
            if ((this.u.a(new int[] { 100, 3, 2, 3 }, true) | bool1 | bool2))
            {
              if (!this.G) {
                e();
              } else {
                this.G = false;
              }
              this.J.set(false);
              return;
            }
            if (this.u.a(new int[] { this.u.b(true, 3), this.u.b(true, 2) }, false))
            {
              c(701, w());
              return;
            }
            if (this.u.a(new int[] { this.u.b(true, 2), this.u.b(true, 3) }, false)) {
              c(702, w());
            }
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      label553:
      if (i2 != 1) {
        if (i2 != 4) {}
      }
    }
  }
  
  protected g.a a(@Nullable Map<String, String> paramMap)
  {
    if ((paramMap == null) && (!j.a().c()))
    {
      g.a locala = null;
      if (com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.ma.g.class) != null) {
        locala = ((com.tencent.luggage.wxa.ma.g)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.ma.g.class)).b();
      }
      if (locala != null)
      {
        o.d("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return customized data source factory");
        return locala;
      }
    }
    o.d("MicroMsg.SameLayer.ExoMediaPlayer", "getDataSourceFactory, return default data source factory");
    return d.a(this.q, paramMap);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(1, 2, Float.valueOf(paramFloat1));
  }
  
  public void a(long paramLong)
  {
    if (v())
    {
      this.r.a(paramLong);
      c.e locale = this.u;
      locale.a(locale.b(), 100);
      this.J.set(true);
    }
  }
  
  public void a(Surface paramSurface)
  {
    if (v()) {
      a(paramSurface, false);
    }
  }
  
  public void a(String paramString1, @Nullable String paramString2)
  {
    this.v = a(Uri.parse(paramString1), paramString2);
    this.K = 0;
    a(1);
  }
  
  public void a(boolean paramBoolean)
  {
    if (v())
    {
      if (paramBoolean)
      {
        a(0.0F, 0.0F);
        return;
      }
      a(1.0F, 1.0F);
    }
  }
  
  public boolean a(float paramFloat)
  {
    if (v())
    {
      q localq = new q(paramFloat, 1.0F);
      this.r.a(localq);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.H = true;
    if (v())
    {
      c(false);
      if (v())
      {
        this.r.e();
        this.r.b(this.x);
        this.r = null;
      }
      this.C = 0;
      this.D = 0;
      this.E = 0;
    }
    Object localObject = this.A;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quit();
      this.A = null;
    }
    localObject = this.s;
    if (localObject != null)
    {
      if (this.t) {
        ((Surface)localObject).release();
      }
      this.s = null;
    }
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    a(-2);
    super.b();
  }
  
  public void b(String paramString)
  {
    a(paramString, null);
  }
  
  public void b(boolean paramBoolean)
  {
    this.F = paramBoolean;
  }
  
  protected boolean b(int paramInt1, int paramInt2)
  {
    boolean bool = super.b(paramInt1, paramInt2);
    this.K = 0;
    return bool;
  }
  
  public boolean f()
  {
    if (v())
    {
      int i1 = this.r.a();
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 == 3) {
            break label50;
          }
          if (i1 != 4) {
            return false;
          }
        }
        return this.F;
      }
      label50:
      return this.r.b();
    }
    return false;
  }
  
  public int g()
  {
    if (v()) {
      return (int)this.r.g();
    }
    return 0;
  }
  
  public int h()
  {
    if (v()) {
      return (int)this.r.h();
    }
    return 0;
  }
  
  public int i()
  {
    return this.C;
  }
  
  public int j()
  {
    return this.D;
  }
  
  public void k()
  {
    if (this.v == null)
    {
      o.c("MicroMsg.SameLayer.ExoMediaPlayer", "prepareAsync, media source is null");
      return;
    }
    if (v())
    {
      this.r.a(false);
      this.r.a(this.v);
    }
  }
  
  public void l()
  {
    if (v())
    {
      if (this.r.a() == 4) {
        this.r.a(0L);
      }
      this.r.a(true);
      a(3);
      this.I.set(false);
    }
  }
  
  public void m()
  {
    if (v())
    {
      this.r.a(false);
      a(3);
    }
  }
  
  public void n()
  {
    if ((v()) && (!this.I.getAndSet(true)))
    {
      this.r.a(false);
      this.r.d();
      a(5);
    }
  }
  
  public void o()
  {
    if (v())
    {
      c(false);
      if (v())
      {
        this.r.a(false);
        this.r.d();
      }
      this.F = false;
      this.E = 0;
      this.u.c();
      a(0);
    }
  }
  
  public int p()
  {
    return this.m;
  }
  
  public int q()
  {
    return this.n;
  }
  
  public int r()
  {
    return this.o;
  }
  
  protected com.tencent.luggage.wxa.l.g s()
  {
    return new b();
  }
  
  public boolean t()
  {
    return this.F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mk.c
 * JD-Core Version:    0.7.0.1
 */