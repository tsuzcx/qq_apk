package com.tencent.luggage.wxa.qk;

import android.os.SystemClock;
import com.tencent.luggage.wxa.qg.g;
import com.tencent.luggage.wxa.qj.i;
import com.tencent.luggage.wxa.qq.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.qz.x;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;

class e$1
  implements PlayerListenerCallback
{
  com.tencent.luggage.wxa.ig.e a = null;
  
  e$1(e parame) {}
  
  private void b()
  {
    o.d("MicroMsg.Music.QQMusicPlayer", "_onPreparing");
    this.a = e.b(this.b);
    com.tencent.luggage.wxa.ig.e locale = this.a;
    if (locale == null)
    {
      o.b("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
      return;
    }
    this.b.b(locale);
  }
  
  private void c()
  {
    o.d("MicroMsg.Music.QQMusicPlayer", "_onPrepared");
    e locale1;
    if (e.a(this.b) != 0)
    {
      o.d("MicroMsg.Music.QQMusicPlayer", "seek to startTime:%d", new Object[] { Integer.valueOf(e.a(this.b)) });
      locale1 = this.b;
      locale1.c(e.a(locale1));
      return;
    }
    o.d("MicroMsg.Music.QQMusicPlayer", "start to play");
    if (i.h().a())
    {
      if (e.b(this.b) == null)
      {
        o.b("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
        return;
      }
      locale1 = this.b;
      locale1.c(e.b(locale1));
      try
      {
        if (e.h(this.b) != null)
        {
          e.h(this.b).start();
          if ((e.h(this.b).getCurrentAudioInformation() != null) && (e.h(this.b).getCurrentAudioInformation().getAudioType() != null))
          {
            o.d("MicroMsg.Music.QQMusicPlayer", "getAudioType:%d", new Object[] { Integer.valueOf(e.h(this.b).getCurrentAudioInformation().getAudioType().getValue()) });
            e.a(this.b, e.h(this.b).getCurrentAudioInformation().getAudioType());
            e.i(this.b);
          }
        }
      }
      catch (Exception localException)
      {
        o.a("MicroMsg.Music.QQMusicPlayer", localException, "_onPrepared", new Object[0]);
        e locale2 = this.b;
        locale2.a(e.b(locale2), 502);
        locale2 = this.b;
        e.a(locale2, e.b(locale2), 502);
      }
      e.a(this.b, true);
      return;
    }
    o.b("MicroMsg.Music.QQMusicPlayer", "request focus error");
  }
  
  private void d()
  {
    o.d("MicroMsg.Music.QQMusicPlayer", "_onStart");
    this.a = e.b(this.b);
    if (this.a == null)
    {
      o.b("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
      return;
    }
    this.b.m = SystemClock.elapsedRealtime();
    if (this.b.i == "pause") {
      this.b.e(this.a);
    } else {
      this.b.d(this.a);
    }
    if (e.f(this.b) != null) {
      e.f(this.b).b();
    }
    e locale = this.b;
    e.a(locale, new e.a(locale, null));
    e.f(this.b).a();
  }
  
  private void e()
  {
    o.d("MicroMsg.Music.QQMusicPlayer", "_onCompletion");
    if (this.a == null)
    {
      o.b("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
      return;
    }
    e.e(this.b);
    e.a(this.b, false);
    e locale = this.b;
    locale.k(e.b(locale));
    if (e.f(this.b) != null)
    {
      e.f(this.b).b();
      e.a(this.b, null);
    }
  }
  
  private void f()
  {
    o.d("MicroMsg.Music.QQMusicPlayer", "_onPause");
    if (this.a == null)
    {
      o.b("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
      return;
    }
    e locale = this.b;
    locale.n += SystemClock.elapsedRealtime() - this.b.m;
    this.b.f(this.a);
  }
  
  private void g()
  {
    o.d("MicroMsg.Music.QQMusicPlayer", "_onStop");
    if (this.a == null)
    {
      o.b("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
      return;
    }
    com.tencent.luggage.wxa.ig.e locale = i.f().d();
    if (locale == null)
    {
      o.b("MicroMsg.Music.QQMusicPlayer", "currentMusic is null");
      return;
    }
    if (locale.a(this.a))
    {
      this.b.g(this.a);
      return;
    }
    this.b.h(this.a);
  }
  
  private void h()
  {
    o.d("MicroMsg.Music.QQMusicPlayer", "_onEnd");
  }
  
  public void a()
  {
    o.d("MicroMsg.Music.QQMusicPlayer", "_onSeekComplete");
    com.tencent.luggage.wxa.ig.e locale = this.a;
    if (locale == null)
    {
      o.b("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
      return;
    }
    this.b.i(locale);
    if (this.b.t())
    {
      o.d("MicroMsg.Music.QQMusicPlayer", "seek end, send play event!");
      this.b.e(this.a);
    }
  }
  
  public void onBufferingUpdate(BaseMediaPlayer paramBaseMediaPlayer, int paramInt) {}
  
  public void onCompletion(BaseMediaPlayer paramBaseMediaPlayer)
  {
    o.d("MicroMsg.Music.QQMusicPlayer", "onCompletion");
  }
  
  public void onError(BaseMediaPlayer paramBaseMediaPlayer, int paramInt1, int paramInt2, int paramInt3)
  {
    o.b("MicroMsg.Music.QQMusicPlayer", "onError what:%d, extra:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramBaseMediaPlayer = i.f().d();
    if (paramBaseMediaPlayer == null)
    {
      o.b("MicroMsg.Music.QQMusicPlayer", "onError, currentMusic is null");
      return;
    }
    this.a = e.b(this.b);
    if (this.a == null)
    {
      o.b("MicroMsg.Music.QQMusicPlayer", "onError, cbMusic is null");
      return;
    }
    boolean bool = x.k(r.a());
    if ((paramInt2 == 80) && (bool)) {
      o.b("MicroMsg.Music.QQMusicPlayer", "connect success, but download is fail!");
    }
    if (e.c(this.b) >= 1)
    {
      o.b("MicroMsg.Music.QQMusicPlayer", "errorCount %d", new Object[] { Integer.valueOf(e.c(this.b)) });
      return;
    }
    e.d(this.b);
    e.e(this.b);
    e.a(this.b, this.a, paramInt2);
    if (paramBaseMediaPlayer.a(this.a))
    {
      this.b.G();
      t.a(new e.1.1(this));
    }
    this.b.g(this.a);
    this.b.a(this.a, paramInt2);
    if (e.f(this.b) != null)
    {
      e.f(this.b).b();
      e.a(this.b, null);
    }
    if ((paramInt1 == 91) && (paramInt2 == 55))
    {
      o.d("MicroMsg.Music.QQMusicPlayer", "unknow format ,delete file");
      g.h(e.g(this.b));
    }
  }
  
  public void onPrepared(BaseMediaPlayer paramBaseMediaPlayer)
  {
    o.d("MicroMsg.Music.QQMusicPlayer", "onPrepared");
  }
  
  public void onSeekComplete(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    o.d("MicroMsg.Music.QQMusicPlayer", "onSeekComplete seekPosition:%d", new Object[] { Integer.valueOf(paramInt) });
    if (e.a(this.b) != 0)
    {
      o.d("MicroMsg.Music.QQMusicPlayer", "seek complete to startTime :%d", new Object[] { Integer.valueOf(e.a(this.b)) });
      e.a(this.b, 0);
      c();
      return;
    }
    a();
  }
  
  public void onStarted(BaseMediaPlayer paramBaseMediaPlayer)
  {
    o.d("MicroMsg.Music.QQMusicPlayer", "onStarted");
  }
  
  public void onStateChanged(BaseMediaPlayer paramBaseMediaPlayer, int paramInt)
  {
    o.d("MicroMsg.Music.QQMusicPlayer", "onStateChanged state %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 3)
    {
      o.d("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARING!");
      b();
      return;
    }
    if (paramInt == 2)
    {
      o.d("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARED!");
      c();
      return;
    }
    if (paramInt == 4)
    {
      o.d("MicroMsg.Music.QQMusicPlayer", "onStateChanged STARTED!");
      d();
      return;
    }
    if (paramInt == 5)
    {
      o.d("MicroMsg.Music.QQMusicPlayer", "onStateChanged PAUSED!");
      f();
      return;
    }
    if (paramInt == 6)
    {
      o.d("MicroMsg.Music.QQMusicPlayer", "onStateChanged STOPPED!");
      g();
      return;
    }
    if (paramInt == 7)
    {
      o.d("MicroMsg.Music.QQMusicPlayer", "onStateChanged PLAYBACKCOMPLETED!");
      e();
      return;
    }
    if (paramInt == 8)
    {
      o.d("MicroMsg.Music.QQMusicPlayer", "onStateChanged END!");
      h();
      return;
    }
    if (paramInt == 9) {
      o.d("MicroMsg.Music.QQMusicPlayer", "onStateChanged ERROR!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qk.e.1
 * JD-Core Version:    0.7.0.1
 */