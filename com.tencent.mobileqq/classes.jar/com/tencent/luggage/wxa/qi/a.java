package com.tencent.luggage.wxa.qi;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.luggage.wxa.am.d.a;
import com.tencent.luggage.wxa.am.g.a;
import com.tencent.luggage.wxa.am.l;
import com.tencent.luggage.wxa.am.s.b;
import com.tencent.luggage.wxa.am.s.c;
import com.tencent.luggage.wxa.am.s.e;
import com.tencent.luggage.wxa.h.g;
import com.tencent.luggage.wxa.h.w;
import com.tencent.luggage.wxa.qj.d;
import com.tencent.luggage.wxa.qj.i;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.u.b.a;
import com.tencent.luggage.wxa.v.f.a;
import java.net.URL;

public class a
  extends com.tencent.luggage.wxa.qk.a
  implements d.a, f.a
{
  private String A = "";
  private int B = 0;
  private int C = 0;
  private long D = 0L;
  private long E;
  private boolean F = false;
  private a.f G = new a.f(null);
  private boolean H = false;
  protected String a;
  a.a b = new a.a(this, null);
  a.e c = new a.e(this, null);
  a.d d = new a.d(this, null);
  a.b e = new a.c(this);
  Handler f = new a.1(this, Looper.getMainLooper());
  public boolean g = false;
  private com.tencent.luggage.wxa.ig.e r;
  private com.tencent.luggage.wxa.ig.c s;
  private boolean t;
  private int u = 0;
  private w v;
  private com.tencent.luggage.wxa.al.b w;
  private l x;
  private g.a y;
  private com.tencent.luggage.wxa.z.h z;
  
  public a()
  {
    com.tencent.luggage.wxa.qm.a.a();
  }
  
  private com.tencent.luggage.wxa.z.h a(Uri paramUri)
  {
    return new com.tencent.luggage.wxa.ab.h(paramUri, this.y, this.f, this.d);
  }
  
  private void a(com.tencent.luggage.wxa.h.e parame)
  {
    if (parame != null)
    {
      Object localObject = parame.getCause();
      if (localObject != null)
      {
        if ((localObject instanceof s.c))
        {
          if (((Throwable)localObject).toString().contains("Unable to connect"))
          {
            boolean bool = com.tencent.luggage.wxa.qz.x.k(r.a());
            parame = new StringBuilder();
            parame.append("ExoPlaybackException hasNetwork=");
            parame.append(bool);
            parame.append(" caused by:\n");
            parame.append(((Throwable)localObject).toString());
            o.b("MicroMsg.Music.ExoMusicPlayer", parame.toString());
            if (!bool)
            {
              b(-4000, -2);
              return;
            }
            b(-4000, -3);
            return;
          }
          if ((localObject instanceof s.e))
          {
            localObject = ((Throwable)localObject).toString();
            if (((String)localObject).contains("403")) {
              b(-4000, -10);
            } else if (((String)localObject).contains("404")) {
              b(-4000, -11);
            } else if (((String)localObject).contains("500")) {
              b(-4000, -12);
            } else if (((String)localObject).contains("502")) {
              b(-4000, -13);
            } else {
              b(-4000, -30);
            }
          }
        }
        else if ((localObject instanceof com.tencent.luggage.wxa.z.p))
        {
          b(-4001, -1);
        }
        else if ((localObject instanceof IllegalStateException))
        {
          b(-4002, -1);
        }
        else if ((localObject instanceof b.a))
        {
          b(-4003, -1);
        }
        else
        {
          b(-4999, -1);
        }
      }
      else {
        b(-4999, -1);
      }
    }
    o.a("MicroMsg.Music.ExoMusicPlayer", parame, "ExoPlaybackException", new Object[0]);
  }
  
  private void a(String paramString, Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("internalError [");
    localStringBuilder.append(o());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    o.a("MicroMsg.Music.ExoMusicPlayer", paramException, localStringBuilder.toString(), new Object[0]);
  }
  
  private g.a b(boolean paramBoolean)
  {
    Context localContext = r.a();
    l locall;
    if (paramBoolean) {
      locall = this.x;
    } else {
      locall = null;
    }
    return new com.tencent.luggage.wxa.am.n(localContext, locall, f());
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    o.d("MicroMsg.Music.ExoMusicPlayer", "notifyOnError what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a.b localb = this.e;
    if (localb != null) {
      localb.a(this, paramInt1, paramInt2);
    }
  }
  
  private void b(com.tencent.luggage.wxa.ig.e parame, int paramInt1, int paramInt2)
  {
    if (this.j != null) {
      this.j.b(parame, paramInt1, paramInt2);
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyOnInfo [");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    o.d("MicroMsg.Music.ExoMusicPlayer", localStringBuilder.toString());
    if ((this.e != null) && ((paramInt1 == 701) || (paramInt1 == 702))) {
      this.e.a(this, paramInt2);
    }
  }
  
  private void k()
  {
    boolean bool = com.tencent.luggage.wxa.qz.x.j(r.a());
    com.tencent.luggage.wxa.qt.a locala = new com.tencent.luggage.wxa.qt.a();
    String str;
    if (af.c(this.r.i)) {
      str = this.r.k;
    } else {
      str = this.r.i;
    }
    this.A = com.tencent.luggage.wxa.qq.e.a(str, this.r.j, bool, locala);
    o.d("MicroMsg.Music.ExoMusicPlayer", "mSrc:%s", new Object[] { this.A });
    o.d("MicroMsg.Music.ExoMusicPlayer", "field_songWifiUrl:%s", new Object[] { this.r.i });
  }
  
  private void l()
  {
    o.d("MicroMsg.Music.ExoMusicPlayer", "initPlayer");
    k();
    Object localObject2;
    try
    {
      URL localURL = new URL(this.A);
    }
    catch (Exception localException1)
    {
      o.a("MicroMsg.Music.ExoMusicPlayer", localException1, "initPlayer", new Object[0]);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("new URL exception:");
      ((StringBuilder)localObject2).append(localException1.getMessage());
      o.b("MicroMsg.Music.ExoMusicPlayer", ((StringBuilder)localObject2).toString());
      localObject1 = null;
    }
    if (localObject1 == null)
    {
      o.b("MicroMsg.Music.ExoMusicPlayer", "initPlayer url is null");
      a(this.r, 500);
      b(this.r, -4005, -43);
      return;
    }
    Object localObject1 = this.v;
    if ((localObject1 != null) && ((this.u != 3) || (((w)localObject1).b())))
    {
      o.d("MicroMsg.Music.ExoMusicPlayer", "stop it first!");
      this.u = 3;
      this.v.a(false);
      this.v.d();
    }
    this.G.c();
    this.a = com.tencent.luggage.wxa.ao.x.a(r.a(), "wechat");
    localObject1 = Uri.parse(this.A);
    if (this.v == null)
    {
      this.x = new l(this.f, this);
      this.w = new com.tencent.luggage.wxa.al.b();
      localObject2 = new com.tencent.luggage.wxa.h.c();
      this.v = g.a(r.a(), this.w, (com.tencent.luggage.wxa.h.n)localObject2);
    }
    if (this.y == null) {
      this.y = b(true);
    }
    try
    {
      this.F = false;
      this.z = a((Uri)localObject1);
      this.v.a(this.b);
      this.v.a(this);
      this.v.a(this.c);
      this.u = 0;
      if (this.C == 0)
      {
        o.d("MicroMsg.Music.ExoMusicPlayer", "startTime is 0, play it when ready!");
        this.v.a(true);
      }
      else
      {
        this.v.a(false);
      }
      this.v.a(this.z);
      this.t = true;
      this.f.sendEmptyMessageDelayed(100, 5000L);
      return;
    }
    catch (Exception localException2)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initPlayer exception:");
      ((StringBuilder)localObject2).append(localException2.getMessage());
      o.b("MicroMsg.Music.ExoMusicPlayer", ((StringBuilder)localObject2).toString());
      o.a("MicroMsg.Music.ExoMusicPlayer", localException2, "initPlayer", new Object[0]);
      a(this.r, 501);
      b(this.r, -4005, -41);
    }
  }
  
  private void m()
  {
    o.d("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
    Object localObject = this.r;
    if (localObject != null) {
      i((com.tencent.luggage.wxa.ig.e)localObject);
    }
    if (this.C > 0)
    {
      localObject = this.v;
      if ((localObject != null) && (!((w)localObject).b()))
      {
        o.d("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete, stay play hls");
        this.C = 0;
        this.v.a(true);
      }
    }
  }
  
  private boolean n()
  {
    w localw = this.v;
    if (localw != null) {
      return localw.c();
    }
    return false;
  }
  
  private String o()
  {
    return com.tencent.luggage.wxa.qm.a.a(SystemClock.elapsedRealtime() - this.E);
  }
  
  private void p()
  {
    Object localObject = this.v;
    if (localObject == null) {
      return;
    }
    boolean bool = ((w)localObject).b();
    int i = this.v.a();
    if ((bool) && (i == 3))
    {
      o.d("MicroMsg.Music.ExoMusicPlayer", "onStart");
      localObject = this.e;
      if (localObject != null) {
        ((a.b)localObject).b(this);
      }
    }
    else if ((!bool) && (i == 3) && (this.u == 2))
    {
      o.d("MicroMsg.Music.ExoMusicPlayer", "onPause");
      localObject = this.e;
      if (localObject != null) {
        ((a.b)localObject).c(this);
      }
    }
    else if ((!bool) && (i == 3) && (this.u == 3))
    {
      o.d("MicroMsg.Music.ExoMusicPlayer", "onStop");
      localObject = this.e;
      if (localObject != null) {
        ((a.b)localObject).d(this);
      }
    }
    int j = this.G.b(bool, i);
    if (j != this.G.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setMostRecentState [");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("]");
      o.d("MicroMsg.Music.ExoMusicPlayer", ((StringBuilder)localObject).toString());
      this.G.a(bool, i);
      if (j == this.G.b(true, 4))
      {
        o.d("MicroMsg.Music.ExoMusicPlayer", "onComplete");
        localObject = this.e;
        if (localObject != null) {
          ((a.b)localObject).f(this);
        }
        return;
      }
      localObject = this.G;
      if (((a.f)localObject).a(new int[] { ((a.f)localObject).b(false, 1), this.G.b(false, 2), this.G.b(false, 3) }, false))
      {
        o.d("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
        localObject = this.e;
        if (localObject != null) {
          ((a.b)localObject).a(this);
        }
        return;
      }
      if ((this.G.a(new int[] { 100, 2, 3 }, true) | this.G.a(new int[] { 2, 100, 3 }, true) | this.G.a(new int[] { 100, 3, 2, 3 }, true)))
      {
        o.d("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
        localObject = this.e;
        if (localObject != null) {
          ((a.b)localObject).e(this);
        }
        return;
      }
      localObject = this.G;
      if (((a.f)localObject).a(new int[] { ((a.f)localObject).b(true, 3), this.G.b(true, 2) }, false))
      {
        o.d("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_START");
        c(701, g());
        return;
      }
      localObject = this.G;
      if (((a.f)localObject).a(new int[] { ((a.f)localObject).b(true, 2), this.G.b(true, 3) }, false))
      {
        o.d("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_END");
        c(702, g());
      }
    }
  }
  
  public boolean B()
  {
    return (this.t) && (!n());
  }
  
  public void G()
  {
    o.d("MicroMsg.Music.ExoMusicPlayer", "stopPlay");
    try
    {
      if (this.v != null)
      {
        this.u = 3;
        this.v.a(false);
        this.v.d();
        g(this.r);
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Music.ExoMusicPlayer", localException, "stopPlay", new Object[0]);
      a(this.r, 504);
      b(this.r, -4005, -42);
    }
    i.h().b();
    this.t = false;
    this.g = false;
    this.f.removeMessages(100);
  }
  
  public int H()
  {
    w localw = this.v;
    if (localw != null) {
      return (int)localw.h();
    }
    return 0;
  }
  
  public int I()
  {
    w localw = this.v;
    if (localw != null) {
      return (int)localw.g();
    }
    return 0;
  }
  
  public void a()
  {
    this.g = true;
    o.d("MicroMsg.Music.ExoMusicPlayer", "passivePause");
    w localw = this.v;
    if (localw != null)
    {
      this.u = 2;
      localw.a(false);
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2) {}
  
  public void a(com.tencent.luggage.wxa.ig.e parame)
  {
    super.a(parame);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.D;
    com.tencent.luggage.wxa.ig.e locale = this.r;
    if ((locale != null) && (locale.a(parame)) && (l2 <= 1000L))
    {
      this.r = parame;
      o.b("MicroMsg.Music.ExoMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.A, Long.valueOf(l2) });
      return;
    }
    if (parame == null)
    {
      o.b("MicroMsg.Music.ExoMusicPlayer", "music is null");
      return;
    }
    if (this.j != null) {
      this.j.a(parame, false);
    }
    this.D = l1;
    o.d("MicroMsg.Music.ExoMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(parame.u) });
    if ((this.v != null) && (t())) {
      this.v.d();
    }
    this.B = 0;
    this.C = parame.u;
    this.E = SystemClock.elapsedRealtime();
    this.r = parame;
    b(this.r);
    o.d("MicroMsg.Music.ExoMusicPlayer", "startPlay startTime:%d", new Object[] { Integer.valueOf(this.C) });
    t.a(new a.2(this));
  }
  
  public void a(com.tencent.luggage.wxa.ig.e parame, int paramInt1, int paramInt2)
  {
    o.d("MicroMsg.Music.ExoMusicPlayer", "onErrorEvent with extra:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.i = "error";
    com.tencent.luggage.wxa.gz.e locale = new com.tencent.luggage.wxa.gz.e();
    locale.a.a = 4;
    locale.a.b = parame;
    locale.a.e = "error";
    locale.a.d = I();
    locale.a.f = c();
    locale.a.i = com.tencent.luggage.wxa.qm.b.a(paramInt1);
    locale.a.j = com.tencent.luggage.wxa.qm.b.b(paramInt2);
    com.tencent.luggage.wxa.qy.a.a.a(locale, Looper.getMainLooper());
  }
  
  public void a(com.tencent.luggage.wxa.v.a parama)
  {
    o.d("MicroMsg.Music.ExoMusicPlayer", "onMetadata [");
    com.tencent.luggage.wxa.qm.a.a(parama, "  ");
    o.d("MicroMsg.Music.ExoMusicPlayer", "]");
  }
  
  public boolean b()
  {
    return (this.t) && (this.g);
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean c(int paramInt)
  {
    int i = I();
    o.d("MicroMsg.Music.ExoMusicPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((i >= 0) && (paramInt <= i))
    {
      if (this.v != null)
      {
        j(this.r);
        a.f localf = this.G;
        localf.a(localf.b(), 100);
        this.u = 4;
        this.v.a(paramInt);
      }
      return true;
    }
    o.b("MicroMsg.Music.ExoMusicPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    return false;
  }
  
  public com.tencent.luggage.wxa.ig.c d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void e()
  {
    this.j = ((d)com.tencent.luggage.wxa.qn.b.a(d.class));
    this.k = i.i();
  }
  
  public s.b f()
  {
    return new com.tencent.luggage.wxa.am.p(this.a, this.x);
  }
  
  public int g()
  {
    w localw = this.v;
    if (localw != null) {
      return localw.j();
    }
    return 0;
  }
  
  public void q()
  {
    this.g = false;
    o.d("MicroMsg.Music.ExoMusicPlayer", "pause");
    w localw = this.v;
    if (localw != null)
    {
      this.u = 2;
      localw.a(false);
    }
  }
  
  public void r()
  {
    o.d("MicroMsg.Music.ExoMusicPlayer", "pauseAndAbandonFocus");
    q();
    i.h().b();
  }
  
  public void s()
  {
    this.B = 0;
    o.d("MicroMsg.Music.ExoMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(n()), Boolean.valueOf(t()) });
    if (this.v != null)
    {
      if (i.h().a())
      {
        this.u = 1;
        this.v.a(true);
        e(this.r);
      }
      else
      {
        o.b("MicroMsg.Music.ExoMusicPlayer", "request focus error");
      }
      this.t = true;
    }
  }
  
  public boolean t()
  {
    w localw = this.v;
    if (localw == null) {
      return false;
    }
    int i = localw.a();
    if ((i != 1) && (i != 3)) {
      return false;
    }
    return this.v.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qi.a
 * JD-Core Version:    0.7.0.1
 */