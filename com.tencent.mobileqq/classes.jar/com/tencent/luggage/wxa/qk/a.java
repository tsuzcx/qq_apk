package com.tencent.luggage.wxa.qk;

import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.ql.d.a;
import com.tencent.luggage.wxa.qy.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.y;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a
  implements com.tencent.luggage.wxa.ql.d
{
  private y a;
  private boolean b;
  protected boolean h;
  protected String i = "";
  protected com.tencent.luggage.wxa.qj.d j;
  protected com.tencent.luggage.wxa.qj.a k;
  protected long l = 0L;
  protected long m = 0L;
  protected long n = 0L;
  protected long o = 0L;
  protected d.a p;
  protected LinkedList<d.a> q = new LinkedList();
  
  protected void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.p;
    if (localObject != null) {
      ((d.a)localObject).a(paramInt1, paramInt2);
    }
    localObject = this.q.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((d.a)((Iterator)localObject).next()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(com.tencent.luggage.wxa.ig.e parame)
  {
    e();
  }
  
  public void a(com.tencent.luggage.wxa.ig.e parame, int paramInt)
  {
    o.d("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.i = "error";
    Object localObject = new com.tencent.luggage.wxa.gz.e();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.a = 4;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.b = parame;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.e = "error";
    ((com.tencent.luggage.wxa.gz.e)localObject).a.d = I();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.f = c();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.i = com.tencent.luggage.wxa.ql.e.a(paramInt);
    ((com.tencent.luggage.wxa.gz.e)localObject).a.j = com.tencent.luggage.wxa.ql.e.b(paramInt);
    com.tencent.luggage.wxa.qy.a.a.a((b)localObject, Looper.getMainLooper());
    localObject = this.k;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.qj.a)localObject).a(parame, paramInt);
    }
  }
  
  public void a(com.tencent.luggage.wxa.ig.e parame, int paramInt1, int paramInt2)
  {
    o.d("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
    a(parame, -1);
  }
  
  public void a(d.a parama)
  {
    this.p = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b(com.tencent.luggage.wxa.ig.e parame)
  {
    o.d("MicroMsg.Music.BaseMusicPlayer", "onPreparingEvent %b", new Object[] { Boolean.valueOf(t()) });
    this.i = "waiting";
    Object localObject = new com.tencent.luggage.wxa.gz.e();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.a = 11;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.b = parame;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.e = "waiting";
    ((com.tencent.luggage.wxa.gz.e)localObject).a.d = I();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.f = c();
    com.tencent.luggage.wxa.qy.a.a.a((b)localObject, Looper.getMainLooper());
    localObject = this.k;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.qj.a)localObject).f(parame);
    }
  }
  
  public void c(com.tencent.luggage.wxa.ig.e parame)
  {
    o.d("MicroMsg.Music.BaseMusicPlayer", "onPrepareEvent %b", new Object[] { Boolean.valueOf(t()) });
    this.i = "canplay";
    Object localObject = new com.tencent.luggage.wxa.gz.e();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.a = 9;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.b = parame;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.e = "canplay";
    ((com.tencent.luggage.wxa.gz.e)localObject).a.d = I();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.f = c();
    com.tencent.luggage.wxa.qy.a.a.a((b)localObject, Looper.getMainLooper());
    localObject = this.k;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.qj.a)localObject).g(parame);
    }
  }
  
  public void d(com.tencent.luggage.wxa.ig.e parame)
  {
    o.d("MicroMsg.Music.BaseMusicPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(t()) });
    this.i = "play";
    Object localObject = new com.tencent.luggage.wxa.gz.e();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.a = 0;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.b = parame;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.e = "play";
    ((com.tencent.luggage.wxa.gz.e)localObject).a.d = I();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.f = c();
    com.tencent.luggage.wxa.qy.a.a.a((b)localObject, Looper.getMainLooper());
    localObject = this.k;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.qj.a)localObject).h(parame);
    }
  }
  
  protected abstract void e();
  
  public void e(com.tencent.luggage.wxa.ig.e parame)
  {
    o.d("MicroMsg.Music.BaseMusicPlayer", "onResumeEvent");
    this.i = "play";
    Object localObject = new com.tencent.luggage.wxa.gz.e();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.a = 1;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.b = parame;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.e = "play";
    ((com.tencent.luggage.wxa.gz.e)localObject).a.d = I();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.f = c();
    com.tencent.luggage.wxa.qy.a.a.a((b)localObject, Looper.getMainLooper());
    localObject = this.k;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.qj.a)localObject).i(parame);
    }
  }
  
  public void f(com.tencent.luggage.wxa.ig.e parame)
  {
    o.d("MicroMsg.Music.BaseMusicPlayer", "onPauseEvent");
    this.i = "pause";
    Object localObject = new com.tencent.luggage.wxa.gz.e();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.a = 3;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.b = parame;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.e = "pause";
    ((com.tencent.luggage.wxa.gz.e)localObject).a.d = I();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.f = c();
    com.tencent.luggage.wxa.qy.a.a.a((b)localObject, Looper.getMainLooper());
    localObject = this.k;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.qj.a)localObject).j(parame);
    }
  }
  
  public void g(com.tencent.luggage.wxa.ig.e parame)
  {
    o.d("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.i = "stop";
    Object localObject = new com.tencent.luggage.wxa.gz.e();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.a = 2;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.b = parame;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.e = "stop";
    ((com.tencent.luggage.wxa.gz.e)localObject).a.d = I();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.f = c();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.g = j();
    com.tencent.luggage.wxa.qy.a.a.a((b)localObject, Looper.getMainLooper());
    localObject = this.k;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.qj.a)localObject).k(parame);
    }
  }
  
  protected void h()
  {
    if (this.a != null) {
      return;
    }
    if (ContextCompat.checkSelfPermission(r.a(), "android.permission.READ_PHONE_STATE") != 0)
    {
      o.b("MicroMsg.Music.BaseMusicPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
      return;
    }
    this.a = new y();
    this.a.a(r.a());
    this.a.a(new a.1(this));
  }
  
  public void h(com.tencent.luggage.wxa.ig.e parame)
  {
    o.d("MicroMsg.Music.BaseMusicPlayer", "onStopForReportEvent");
    com.tencent.luggage.wxa.gz.e locale = new com.tencent.luggage.wxa.gz.e();
    locale.a.a = 18;
    locale.a.b = parame;
    com.tencent.luggage.wxa.qy.a.a.a(locale, Looper.getMainLooper());
  }
  
  protected String i()
  {
    return this.i;
  }
  
  public void i(com.tencent.luggage.wxa.ig.e parame)
  {
    o.d("MicroMsg.Music.BaseMusicPlayer", "onSeekToEvent");
    this.i = "seeked";
    Object localObject = new com.tencent.luggage.wxa.gz.e();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.a = 8;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.b = parame;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.e = "seeked";
    ((com.tencent.luggage.wxa.gz.e)localObject).a.d = I();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.f = c();
    com.tencent.luggage.wxa.qy.a.a.a((b)localObject, Looper.getMainLooper());
    localObject = this.k;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.qj.a)localObject).m(parame);
    }
  }
  
  public void j(com.tencent.luggage.wxa.ig.e parame)
  {
    o.d("MicroMsg.Music.BaseMusicPlayer", "onSeekingEvent");
    this.i = "seeking";
    Object localObject = new com.tencent.luggage.wxa.gz.e();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.a = 12;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.b = parame;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.e = "seeking";
    ((com.tencent.luggage.wxa.gz.e)localObject).a.d = I();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.f = c();
    com.tencent.luggage.wxa.qy.a.a.a((b)localObject, Looper.getMainLooper());
    localObject = this.k;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.qj.a)localObject).n(parame);
    }
  }
  
  public boolean j()
  {
    boolean bool = this.b;
    this.b = false;
    return bool;
  }
  
  public void k(com.tencent.luggage.wxa.ig.e parame)
  {
    o.d("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
    this.i = "ended";
    Object localObject = new com.tencent.luggage.wxa.gz.e();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.a = 7;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.b = parame;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.e = "ended";
    ((com.tencent.luggage.wxa.gz.e)localObject).a.d = I();
    ((com.tencent.luggage.wxa.gz.e)localObject).a.c = parame.c;
    ((com.tencent.luggage.wxa.gz.e)localObject).a.f = c();
    com.tencent.luggage.wxa.qy.a.a.a((b)localObject, Looper.getMainLooper());
    localObject = this.k;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.qj.a)localObject).l(parame);
    }
  }
  
  public void l(com.tencent.luggage.wxa.ig.e parame) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qk.a
 * JD-Core Version:    0.7.0.1
 */