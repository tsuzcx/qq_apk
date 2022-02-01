package com.tencent.luggage.wxa.qd;

import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.luggage.wxa.if.d;
import com.tencent.luggage.wxa.ql.d.a;
import com.tencent.luggage.wxa.qo.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import java.net.URL;

public class j
  extends h
{
  protected com.tencent.luggage.wxa.if.b d;
  CommonPlayer e;
  private String f = "";
  private d g;
  private boolean h;
  private boolean i = false;
  private boolean j = false;
  private j.a k;
  private com.tencent.luggage.wxa.qp.b l;
  private String m = "";
  private int n = 0;
  private int o = 0;
  private int p = 0;
  private boolean q = false;
  private long r = 0L;
  private AudioFormat.AudioType s = AudioFormat.AudioType.UNSUPPORT;
  private boolean t = false;
  private s u;
  private long v = 0L;
  private long w = 0L;
  private com.tencent.luggage.wxa.qe.a x;
  private PlayerListenerCallback y = new j.1(this);
  
  public j()
  {
    com.tencent.luggage.wxa.ql.a.a();
    g.a().a(this);
    o.d("MicroMsg.Audio.QQAudioPlayer", "create QQAudioPlayer instance");
    this.u = new s(Looper.myLooper());
  }
  
  private void P()
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "initPlayer");
    Object localObject2;
    if (c(this.d))
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "play with pByteBuff");
      if (this.e == null) {
        this.e = new CommonPlayer(this.y);
      }
      this.e.reset();
      c localc1 = new c(this.d.C);
      try
      {
        this.e.setDataSource(localc1);
        this.e.prepare();
      }
      catch (Exception localException1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("initPlayer exception:");
        ((StringBuilder)localObject2).append(localException1.getMessage());
        o.b("MicroMsg.Audio.QQAudioPlayer", ((StringBuilder)localObject2).toString());
        o.a("MicroMsg.Audio.QQAudioPlayer", localException1, "initPlayer", new Object[0]);
        b(501);
        d(501);
      }
    }
    else if ((!TextUtils.isEmpty(this.d.c)) && (this.d.y == null))
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "play with local file, filePath:%s", new Object[] { this.d.c });
      if (this.e == null) {
        this.e = new CommonPlayer(this.y);
      }
      this.e.reset();
      try
      {
        this.e.setDataSource(this.d.c);
        this.e.prepare();
      }
      catch (Exception localException2)
      {
        o.a("MicroMsg.Audio.QQAudioPlayer", localException2, "initPlayer exception", new Object[0]);
        b(501);
        d(501);
      }
    }
    else if ((!TextUtils.isEmpty(this.d.c)) && (this.d.y != null))
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "play with inputStream, filePath:%s", new Object[] { this.d.c });
      if (this.e == null) {
        this.e = new CommonPlayer(this.y);
      }
      this.e.reset();
      c localc2 = new c(this.d.y);
      try
      {
        this.e.setDataSource(localc2);
        this.e.prepare();
      }
      catch (Exception localException3)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("initPlayer exception:");
        ((StringBuilder)localObject2).append(localException3.getMessage());
        o.b("MicroMsg.Audio.QQAudioPlayer", ((StringBuilder)localObject2).toString());
        o.a("MicroMsg.Audio.QQAudioPlayer", localException3, "initPlayer", new Object[0]);
        b(501);
        d(501);
      }
    }
    else
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "play with src url :%s", new Object[] { this.d.b });
      Object localObject1 = null;
      Q();
      try
      {
        localObject2 = new URL(this.m);
        localObject1 = localObject2;
      }
      catch (Exception localException5)
      {
        o.a("MicroMsg.Audio.QQAudioPlayer", localException5, "initPlayer", new Object[0]);
      }
      if (localObject1 == null)
      {
        o.b("MicroMsg.Audio.QQAudioPlayer", "initPlayer url is null");
        b(500);
        d(500);
        return;
      }
      if (this.e == null) {
        this.e = new CommonPlayer(this.y);
      }
      this.e.reset();
      if (this.l == null) {
        this.l = new com.tencent.luggage.wxa.qp.b();
      }
      this.l.a(this.m, this.d.w);
      try
      {
        this.e.setDataSource(this.l, Uri.parse(localObject1.toString()));
        this.e.prepare();
      }
      catch (Exception localException4)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initPlayer exception:");
        localStringBuilder.append(localException4.getMessage());
        o.b("MicroMsg.Audio.QQAudioPlayer", localStringBuilder.toString());
        o.a("MicroMsg.Audio.QQAudioPlayer", localException4, "initPlayer", new Object[0]);
        b(501);
        d(501);
      }
    }
    float f1 = 0.0F;
    com.tencent.luggage.wxa.if.b localb = this.d;
    if (localb != null) {
      f1 = (float)localb.m;
    }
    if (this.e != null)
    {
      if ((f1 >= 0.5F) && (f1 <= 2.0F))
      {
        o.d("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", new Object[] { Float.valueOf(f1) });
        this.e.setSpeed(f1);
        return;
      }
      this.e.setSpeed(1.0F);
    }
  }
  
  private void Q()
  {
    this.m = this.d.b;
    boolean bool;
    if (com.tencent.luggage.wxa.qq.e.a(this.m))
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "can match shake music wifi url");
      bool = true;
    }
    else
    {
      bool = false;
    }
    o.d("MicroMsg.Audio.QQAudioPlayer", "mSrc:%s", new Object[] { this.m });
    com.tencent.luggage.wxa.qg.g.a(this.m);
    com.tencent.luggage.wxa.qg.g.a(this.m, bool);
  }
  
  private void R()
  {
    this.e.setAudioStreamType(V());
    this.e.start();
  }
  
  private void S()
  {
    try
    {
      if (this.e != null)
      {
        this.e.setVolume(0.0F, 0.0F);
        this.e.stop();
      }
      if (this.k != null)
      {
        this.k.b();
        this.k = null;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Audio.QQAudioPlayer", localException, "stopPlay", new Object[0]);
      b(504);
      d(504);
    }
    this.h = false;
    this.i = true;
    this.w = System.currentTimeMillis();
  }
  
  private void T()
  {
    Object localObject = this.s;
    if (localObject == null) {
      return;
    }
    o.d("MicroMsg.Audio.QQAudioPlayer", "idKeyReportAudioMimeType audioType:%d, isStatMineType:%b", new Object[] { Integer.valueOf(((AudioFormat.AudioType)localObject).getValue()), Boolean.valueOf(this.t) });
    if (this.t) {
      return;
    }
    o.d("MicroMsg.Audio.QQAudioPlayer", "idKeyReportAudioMimeType OK");
    this.t = true;
    localObject = this.x;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.qe.a)localObject).b(this.s.getValue());
    }
  }
  
  private boolean U()
  {
    return com.tencent.luggage.wxa.qg.e.a();
  }
  
  private int V()
  {
    return g.a().f();
  }
  
  private boolean c(com.tencent.luggage.wxa.if.b paramb)
  {
    return (paramb != null) && (paramb.b.startsWith("wxblob://")) && (paramb.C != null);
  }
  
  private void d(int paramInt)
  {
    com.tencent.luggage.wxa.qe.a locala = this.x;
    if (locala != null) {
      locala.a(this.d.i, paramInt);
    }
  }
  
  public boolean A()
  {
    CommonPlayer localCommonPlayer = this.e;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localCommonPlayer != null)
    {
      bool1 = bool2;
      if (localCommonPlayer.getPlayerState() == 9) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean B()
  {
    return (this.h) && (!u());
  }
  
  public boolean C()
  {
    return this.j;
  }
  
  public void D()
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "setPauseOnBackground");
    this.j = true;
    this.i = true;
  }
  
  public void E()
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "pauseOnBackGround");
    this.j = true;
    S();
  }
  
  public void F()
  {
    this.j = false;
    this.i = true;
    l();
    this.w = System.currentTimeMillis();
  }
  
  public void G()
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "stopPlay");
    this.j = false;
    S();
  }
  
  public int H()
  {
    CommonPlayer localCommonPlayer = this.e;
    if (localCommonPlayer != null) {
      return (int)localCommonPlayer.getCurrentPosition();
    }
    return -1;
  }
  
  public int I()
  {
    CommonPlayer localCommonPlayer = this.e;
    if (localCommonPlayer != null) {
      return localCommonPlayer.getDuration();
    }
    return -1;
  }
  
  public int J()
  {
    CommonPlayer localCommonPlayer = this.e;
    int i1;
    if (localCommonPlayer != null) {
      i1 = localCommonPlayer.getBufferedPercentage();
    } else {
      i1 = 0;
    }
    if (i1 >= 0)
    {
      if (i1 > 100) {
        return 0;
      }
      return i1;
    }
    return 0;
  }
  
  public d K()
  {
    if (this.g == null) {
      this.g = new d();
    }
    int i3 = I();
    int i4 = H();
    boolean bool = t();
    int i2 = J();
    int i1 = i2;
    if (i2 < 0) {
      i1 = 0;
    }
    d locald = this.g;
    locald.b = i4;
    locald.a = i3;
    locald.c = (bool ^ true);
    locald.d = this.j;
    locald.e = (i1 * i3 / 100);
    com.tencent.luggage.wxa.if.b localb = this.d;
    if (localb != null)
    {
      locald.g = localb.e;
      this.g.f = this.d.b;
      this.g.h = this.d.v;
      return this.g;
    }
    return null;
  }
  
  public void L()
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "release");
    this.b = null;
    CommonPlayer localCommonPlayer = this.e;
    if (localCommonPlayer != null)
    {
      localCommonPlayer.release();
      this.e = null;
    }
    g.a().b(this);
  }
  
  public void M()
  {
    if ((this.f.equalsIgnoreCase(this.d.a)) && (this.e != null) && (t()))
    {
      int i1 = (int)this.e.getCurrentPosition();
      int i2 = this.e.getDuration();
      if ((i1 > 0) && (i2 > 0) && (this.c != null)) {
        this.c.a(i1, i2);
      }
    }
  }
  
  public int N()
  {
    return this.o;
  }
  
  public long O()
  {
    return this.w;
  }
  
  public void a(com.tencent.luggage.wxa.if.b paramb)
  {
    this.d = paramb;
    this.p = paramb.d;
    this.q = paramb.g;
    if ((this.e != null) && (t()))
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "audioId:%s, param.src:%s setVoume %f", new Object[] { this.f, this.m, Double.valueOf(this.d.l) });
      this.e.setVolume((float)this.d.l, (float)this.d.l);
      if (this.d.m > 0.0D)
      {
        o.d("MicroMsg.Audio.QQAudioPlayer", "set speed :%f", new Object[] { Double.valueOf(this.d.m) });
        this.e.setSpeed((float)this.d.m);
        return;
      }
      this.e.setSpeed(1.0F);
    }
  }
  
  public void a(String paramString)
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "setAudioId:%s", new Object[] { paramString });
    this.f = paramString;
  }
  
  public void b(com.tencent.luggage.wxa.if.b paramb)
  {
    if (paramb == null)
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "startPlay fail, play param is null");
      p();
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.r;
    Object localObject = this.d;
    if ((localObject != null) && (((com.tencent.luggage.wxa.if.b)localObject).a(paramb)) && (l2 <= 20L))
    {
      this.d = paramb;
      this.p = paramb.d;
      this.q = paramb.g;
      o.b("MicroMsg.Audio.QQAudioPlayer", "startPlay, is playing for audio src:%s, don't play again in 3 second, interval:%d", new Object[] { this.m, Long.valueOf(l2) });
      return;
    }
    this.x = ((com.tencent.luggage.wxa.qe.a)com.tencent.luggage.wxa.qn.b.a(com.tencent.luggage.wxa.qe.a.class));
    localObject = this.x;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.qe.a)localObject).a(paramb.i);
    }
    this.r = l1;
    this.d = paramb;
    o.d("MicroMsg.Audio.QQAudioPlayer", "startPlay, fromScene:%d, audioId:%s", new Object[] { Integer.valueOf(this.d.i), this.f });
    if ((this.e != null) && (t())) {
      this.e.stop();
    }
    this.n = 0;
    this.p = paramb.d;
    this.q = paramb.g;
    this.s = null;
    this.t = false;
    this.j = false;
    this.i = false;
    P();
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean c(int paramInt)
  {
    int i1 = I();
    o.d("MicroMsg.Audio.QQAudioPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i1) });
    if (i1 < 0)
    {
      o.b("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i1) });
      G();
      return false;
    }
    if (paramInt > i1)
    {
      o.b("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i1) });
      return false;
    }
    if (this.e != null)
    {
      n();
      this.e.seekTo(paramInt);
    }
    return true;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public String f()
  {
    com.tencent.luggage.wxa.if.b localb = this.d;
    if (localb != null) {
      return localb.n;
    }
    return "";
  }
  
  public void q()
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "pause, audioId:%s", new Object[] { this.f });
    this.i = true;
    if ((this.e != null) && (t())) {
      try
      {
        o.d("MicroMsg.Audio.QQAudioPlayer", "pause success");
        this.e.pause();
        return;
      }
      catch (Exception localException)
      {
        o.a("MicroMsg.Audio.QQAudioPlayer", localException, "pause", new Object[0]);
        b(503);
        d(503);
        return;
      }
    }
    if ((this.e != null) && (y()))
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "pause fail, play complete, set isStartPlaying false");
      this.h = false;
    }
  }
  
  public void r()
  {
    o.d("MicroMsg.Audio.QQAudioPlayer", "pauseAndAbandonFocus");
    q();
  }
  
  public void s()
  {
    this.n = 0;
    boolean bool1 = u();
    boolean bool2 = t();
    this.i = false;
    this.j = false;
    o.d("MicroMsg.Audio.QQAudioPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, isStartPlaying:%b, audioId:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.h), this.f });
    if ((this.e != null) && (!v()) && (!bool1) && (!bool2) && (!this.h))
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "audio play is complete, need initPlayer again");
      this.p = 0;
      this.q = true;
      P();
      com.tencent.luggage.wxa.qe.a locala = this.x;
      if (locala != null) {
        locala.a(this.d.i);
      }
    }
    else if ((this.e != null) && ((w()) || (v())) && (!bool2))
    {
      o.d("MicroMsg.Audio.QQAudioPlayer", "audio play is paused, need start to play");
      try
      {
        this.e.setVolume((float)this.d.l, (float)this.d.l);
        R();
      }
      catch (Exception localException)
      {
        o.a("MicroMsg.Audio.QQAudioPlayer", localException, "resume", new Object[0]);
        b(502);
        d(502);
      }
      this.h = true;
    }
  }
  
  public boolean t()
  {
    CommonPlayer localCommonPlayer = this.e;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localCommonPlayer != null)
    {
      bool1 = bool2;
      if (localCommonPlayer.getPlayerState() == 4) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean u()
  {
    CommonPlayer localCommonPlayer = this.e;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localCommonPlayer != null)
    {
      bool1 = bool2;
      if (localCommonPlayer.getPlayerState() == 3) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean v()
  {
    CommonPlayer localCommonPlayer = this.e;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localCommonPlayer != null)
    {
      bool1 = bool2;
      if (localCommonPlayer.getPlayerState() == 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean w()
  {
    CommonPlayer localCommonPlayer = this.e;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localCommonPlayer != null)
    {
      bool1 = bool2;
      if (localCommonPlayer.getPlayerState() == 5) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean x()
  {
    return this.i;
  }
  
  public boolean y()
  {
    CommonPlayer localCommonPlayer = this.e;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localCommonPlayer != null)
    {
      bool1 = bool2;
      if (localCommonPlayer.getPlayerState() == 7) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean z()
  {
    CommonPlayer localCommonPlayer = this.e;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localCommonPlayer != null)
    {
      bool1 = bool2;
      if (localCommonPlayer.getPlayerState() == 6) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.j
 * JD-Core Version:    0.7.0.1
 */