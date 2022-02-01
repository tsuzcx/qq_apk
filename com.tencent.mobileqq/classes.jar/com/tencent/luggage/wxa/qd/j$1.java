package com.tencent.luggage.wxa.qd;

import com.tencent.luggage.wxa.if.b;
import com.tencent.luggage.wxa.qe.a;
import com.tencent.luggage.wxa.qg.g;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.qz.x;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;

class j$1
  implements PlayerListenerCallback
{
  b a = null;
  
  j$1(j paramj) {}
  
  private void b()
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "_onPreparing");
    this.a = this.b.d;
    if (this.a == null)
    {
      o.b("MicroMsg.Audio.QQAudioPlayer", "cbMusic is null");
      return;
    }
    if ((!this.b.C()) && (!j.j(this.b)))
    {
      this.b.g();
      return;
    }
    o.d("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
  }
  
  private void c()
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "_onPrepared");
    this.a = this.b.d;
    if ((!this.b.C()) && (!j.j(this.b)))
    {
      j localj;
      if (j.a(this.b) != 0)
      {
        o.d("MicroMsg.Audio.QQAudioPlayer", "seek to startTime:%d", new Object[] { Integer.valueOf(j.a(this.b)) });
        localj = this.b;
        localj.c(j.a(localj));
        return;
      }
      if ((this.b.e != null) && (this.b.e.getCurrentAudioInformation() != null) && (this.b.e.getCurrentAudioInformation().getAudioType() != null))
      {
        localj = this.b;
        j.a(localj, localj.e.getCurrentAudioInformation().getAudioType());
        if (j.k(this.b) != null) {
          o.d("MicroMsg.Audio.QQAudioPlayer", "getAudioType:%d", new Object[] { Integer.valueOf(j.k(this.b).getValue()) });
        }
        j.l(this.b);
      }
      this.b.h();
      if (!j.m(this.b))
      {
        o.d("MicroMsg.Audio.QQAudioPlayer", "autoplay is false, don't start auto play!");
        return;
      }
      o.d("MicroMsg.Audio.QQAudioPlayer", "start to play");
      try
      {
        if (this.b.e != null)
        {
          this.b.e.setVolume((float)this.b.d.l, (float)this.b.d.l);
          j.n(this.b);
        }
      }
      catch (Exception localException)
      {
        o.a("MicroMsg.Audio.QQAudioPlayer", localException, "_onPrepared", new Object[0]);
        this.b.b(502);
        j.c(this.b, 502);
      }
      j.a(this.b, true);
      return;
    }
    o.d("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
    if ((this.b.C()) && (this.b.e != null)) {
      this.b.e.stop();
    }
    if (j.j(this.b)) {
      this.b.k();
    }
  }
  
  private void d()
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "_onStart");
    if (j.o(this.b) != null) {
      j.o(this.b).a(this.b.d.a, this.b.d.b, System.currentTimeMillis() - this.b.d.o, this.b.d.p, this.b.d.q, true);
    }
    this.a = this.b.d;
    if ((!this.b.C()) && (!j.j(this.b)))
    {
      this.b.i();
      if (j.g(this.b) != null) {
        j.g(this.b).b();
      }
      j localj = this.b;
      j.a(localj, new j.a(localj, null));
      j.g(this.b).a();
      return;
    }
    o.d("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
    if ((this.b.e != null) && (j.p(this.b)))
    {
      j.a(this.b, false);
      this.b.e.stop();
    }
  }
  
  private void e()
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "_onCompletion");
    if (!this.b.d.h) {
      this.b.o();
    }
    if (j.g(this.b) != null)
    {
      j.g(this.b).b();
      j.a(this.b, null);
    }
    j.a(this.b, System.currentTimeMillis());
    o.d("MicroMsg.Audio.QQAudioPlayer", "play end, isPausedOnBackground:%b, playParam.loop:%b, isStartPlaying:%b, ", new Object[] { Boolean.valueOf(j.q(this.b)), Boolean.valueOf(this.b.d.h), Boolean.valueOf(j.p(this.b)) });
    if (this.b.C())
    {
      j.a(this.b, false);
      j.a(this.b, 0);
      j.b(this.b, true);
      o.d("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground is true, do stop player and don't play again");
      return;
    }
    if (this.b.x())
    {
      j.a(this.b, false);
      j.a(this.b, 0);
      j.b(this.b, true);
      o.d("MicroMsg.Audio.QQAudioPlayer", "isForcePause is true, do stop player and don't play again");
      return;
    }
    if ((this.b.d.h) && (j.p(this.b)))
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "play end normally and loop play again");
      j.a(this.b, false);
      j.a(this.b, 0);
      j.b(this.b, true);
      j.r(this.b);
      return;
    }
    o.d("MicroMsg.Audio.QQAudioPlayer", "play end, but not loop play");
    j.a(this.b, false);
    j.a(this.b, 0);
    j.b(this.b, true);
  }
  
  private void f()
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "_onPause");
    this.b.k();
  }
  
  private void g()
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "_onStop");
    if (this.a == null)
    {
      o.b("MicroMsg.Audio.QQAudioPlayer", "currentMusic is null");
      return;
    }
    j.a(this.b, false);
    j.a(this.b, System.currentTimeMillis());
    if (j.c(this.b).equalsIgnoreCase(this.a.a))
    {
      if (j.q(this.b))
      {
        o.d("MicroMsg.Audio.QQAudioPlayer", "stop play, but send pause state event");
        this.b.k();
        return;
      }
      this.b.l();
    }
  }
  
  private void h()
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "_onEnd");
  }
  
  public void a()
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "_onSeekComplete");
    this.b.m();
    if (this.b.t())
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "seek end, send play event!");
      this.b.j();
    }
  }
  
  public void onBufferingUpdate(BaseMediaPlayer paramBaseMediaPlayer, int paramInt) {}
  
  public void onCompletion(BaseMediaPlayer paramBaseMediaPlayer)
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "onCompletion");
  }
  
  public void onError(BaseMediaPlayer paramBaseMediaPlayer, int paramInt1, int paramInt2, int paramInt3)
  {
    o.b("MicroMsg.Audio.QQAudioPlayer", "onError what:%d, extra:%d, errCode:%d, audioId:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), j.c(this.b) });
    if (this.a == null)
    {
      o.b("MicroMsg.Audio.QQAudioPlayer", "onError, currentParam is null");
      return;
    }
    boolean bool = x.k(r.a());
    if ((paramInt2 == 80) && (bool)) {
      o.b("MicroMsg.Audio.QQAudioPlayer", "connect success, but download is fail!");
    }
    if (j.d(this.b) >= 1)
    {
      o.b("MicroMsg.Audio.QQAudioPlayer", "errorCount %d", new Object[] { Integer.valueOf(j.d(this.b)) });
      return;
    }
    j.a(this.b, false);
    j.e(this.b);
    j.b(this.b, paramInt2);
    j.a(this.b, System.currentTimeMillis());
    j.c(this.b, paramInt2);
    if (j.c(this.b).equalsIgnoreCase(this.a.a))
    {
      this.b.G();
      t.a(new j.1.2(this));
    }
    this.b.b(paramInt2);
    if (j.g(this.b) != null)
    {
      j.g(this.b).b();
      j.a(this.b, null);
    }
    if ((paramInt1 == 91) && (paramInt2 == 55))
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "unknow format ,delete file");
      g.h(j.h(this.b));
    }
  }
  
  public void onPrepared(BaseMediaPlayer paramBaseMediaPlayer)
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "onPrepared");
  }
  
  public void onSeekComplete(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    j.b(this.b).a(new j.1.1(this, paramInt));
  }
  
  public void onStarted(BaseMediaPlayer paramBaseMediaPlayer)
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "onStarted");
  }
  
  public void onStateChanged(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    j.b(this.b).a(new j.1.3(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.j.1
 * JD-Core Version:    0.7.0.1
 */