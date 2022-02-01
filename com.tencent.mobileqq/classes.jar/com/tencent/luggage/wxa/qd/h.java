package com.tencent.luggage.wxa.qd;

import android.os.Looper;
import com.tencent.luggage.wxa.ql.d;
import com.tencent.luggage.wxa.ql.d.a;
import com.tencent.luggage.wxa.qy.a;
import com.tencent.luggage.wxa.qy.b;
import com.tencent.luggage.wxa.qz.o;

public abstract class h
  implements i, d
{
  protected boolean a;
  protected e b = null;
  protected d.a c;
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 2)) {
        return;
      }
      if (t())
      {
        this.a = true;
        q();
      }
    }
    else if (this.a)
    {
      this.a = false;
      s();
    }
  }
  
  public void a(e parame)
  {
    this.b = parame;
  }
  
  public void a(d.a parama)
  {
    this.c = parama;
  }
  
  public void b(int paramInt)
  {
    o.d("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent with errCode:%d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = new com.tencent.luggage.wxa.gz.c();
    ((com.tencent.luggage.wxa.gz.c)localObject).a.a = 4;
    ((com.tencent.luggage.wxa.gz.c)localObject).a.d = "error";
    ((com.tencent.luggage.wxa.gz.c)localObject).a.f = com.tencent.luggage.wxa.ql.e.a(paramInt);
    ((com.tencent.luggage.wxa.gz.c)localObject).a.g = com.tencent.luggage.wxa.ql.e.b(paramInt);
    ((com.tencent.luggage.wxa.gz.c)localObject).a.c = e();
    ((com.tencent.luggage.wxa.gz.c)localObject).a.e = f();
    a.a.a((b)localObject, Looper.getMainLooper());
    localObject = this.b;
    if (localObject != null) {
      ((e)localObject).e(e());
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public com.tencent.luggage.wxa.ig.c d()
  {
    return null;
  }
  
  public abstract String e();
  
  public abstract String f();
  
  public void g()
  {
    o.d("MicroMsg.Audio.BaseAudioPlayer", "onPreparintEvent");
    com.tencent.luggage.wxa.gz.c localc = new com.tencent.luggage.wxa.gz.c();
    localc.a.a = 9;
    localc.a.d = "waiting";
    localc.a.c = e();
    localc.a.e = f();
    a.a.a(localc, Looper.getMainLooper());
  }
  
  public void h()
  {
    o.d("MicroMsg.Audio.BaseAudioPlayer", "onPrepareEvent");
    com.tencent.luggage.wxa.gz.c localc = new com.tencent.luggage.wxa.gz.c();
    localc.a.a = 7;
    localc.a.d = "canplay";
    localc.a.b = I();
    localc.a.c = e();
    localc.a.e = f();
    a.a.a(localc, Looper.getMainLooper());
  }
  
  public void i()
  {
    o.d("MicroMsg.Audio.BaseAudioPlayer", "onStartEvent %b", new Object[] { Boolean.valueOf(t()) });
    Object localObject = new com.tencent.luggage.wxa.gz.c();
    ((com.tencent.luggage.wxa.gz.c)localObject).a.a = 0;
    ((com.tencent.luggage.wxa.gz.c)localObject).a.d = "play";
    ((com.tencent.luggage.wxa.gz.c)localObject).a.c = e();
    ((com.tencent.luggage.wxa.gz.c)localObject).a.e = f();
    a.a.a((b)localObject, Looper.getMainLooper());
    localObject = this.b;
    if (localObject != null) {
      ((e)localObject).a(e());
    }
  }
  
  public void j()
  {
    o.d("MicroMsg.Audio.BaseAudioPlayer", "onResumeEvent");
    Object localObject = new com.tencent.luggage.wxa.gz.c();
    ((com.tencent.luggage.wxa.gz.c)localObject).a.a = 1;
    ((com.tencent.luggage.wxa.gz.c)localObject).a.d = "play";
    ((com.tencent.luggage.wxa.gz.c)localObject).a.c = e();
    ((com.tencent.luggage.wxa.gz.c)localObject).a.e = f();
    a.a.a((b)localObject, Looper.getMainLooper());
    localObject = this.b;
    if (localObject != null) {
      ((e)localObject).a(e());
    }
  }
  
  public void k()
  {
    o.d("MicroMsg.Audio.BaseAudioPlayer", "onPauseEvent");
    Object localObject = new com.tencent.luggage.wxa.gz.c();
    ((com.tencent.luggage.wxa.gz.c)localObject).a.a = 2;
    ((com.tencent.luggage.wxa.gz.c)localObject).a.d = "pause";
    ((com.tencent.luggage.wxa.gz.c)localObject).a.c = e();
    ((com.tencent.luggage.wxa.gz.c)localObject).a.e = f();
    a.a.a((b)localObject, Looper.getMainLooper());
    localObject = this.b;
    if (localObject != null) {
      ((e)localObject).b(e());
    }
  }
  
  public void l()
  {
    o.d("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
    Object localObject = new com.tencent.luggage.wxa.gz.c();
    ((com.tencent.luggage.wxa.gz.c)localObject).a.a = 3;
    ((com.tencent.luggage.wxa.gz.c)localObject).a.d = "stop";
    ((com.tencent.luggage.wxa.gz.c)localObject).a.c = e();
    ((com.tencent.luggage.wxa.gz.c)localObject).a.e = f();
    a.a.a((b)localObject, Looper.getMainLooper());
    localObject = this.b;
    if (localObject != null) {
      ((e)localObject).c(e());
    }
  }
  
  public void m()
  {
    o.d("MicroMsg.Audio.BaseAudioPlayer", "onSeekToEvent");
    com.tencent.luggage.wxa.gz.c localc = new com.tencent.luggage.wxa.gz.c();
    localc.a.a = 6;
    localc.a.d = "seeked";
    localc.a.c = e();
    localc.a.e = f();
    a.a.a(localc, Looper.getMainLooper());
  }
  
  public void n()
  {
    o.d("MicroMsg.Audio.BaseAudioPlayer", "onSeekingEvent");
    com.tencent.luggage.wxa.gz.c localc = new com.tencent.luggage.wxa.gz.c();
    localc.a.a = 10;
    localc.a.d = "seeking";
    localc.a.c = e();
    localc.a.e = f();
    a.a.a(localc, Looper.getMainLooper());
  }
  
  public void o()
  {
    o.d("MicroMsg.Audio.BaseAudioPlayer", "onCompleteEvent");
    Object localObject = new com.tencent.luggage.wxa.gz.c();
    ((com.tencent.luggage.wxa.gz.c)localObject).a.a = 5;
    ((com.tencent.luggage.wxa.gz.c)localObject).a.d = "ended";
    ((com.tencent.luggage.wxa.gz.c)localObject).a.c = e();
    ((com.tencent.luggage.wxa.gz.c)localObject).a.e = f();
    a.a.a((b)localObject, Looper.getMainLooper());
    localObject = this.b;
    if (localObject != null) {
      ((e)localObject).d(e());
    }
  }
  
  public void p()
  {
    o.d("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent");
    b(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.h
 * JD-Core Version:    0.7.0.1
 */