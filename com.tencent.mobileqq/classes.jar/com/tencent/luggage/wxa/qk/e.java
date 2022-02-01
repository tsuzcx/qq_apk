package com.tencent.luggage.wxa.qk;

import android.net.Uri;
import android.os.SystemClock;
import com.tencent.luggage.wxa.ig.c;
import com.tencent.luggage.wxa.qg.g;
import com.tencent.luggage.wxa.qj.d;
import com.tencent.luggage.wxa.qj.i;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import java.net.URL;

public class e
  extends a
{
  public boolean a = false;
  private com.tencent.luggage.wxa.ig.e b;
  private CommonPlayer c;
  private c d;
  private boolean e;
  private e.a f;
  private com.tencent.luggage.wxa.qp.b g;
  private String r = "";
  private String s;
  private int t = 0;
  private int u = 0;
  private long v = 0L;
  private AudioFormat.AudioType w = AudioFormat.AudioType.UNSUPPORT;
  private boolean x = false;
  private PlayerListenerCallback y = new e.1(this);
  
  public e()
  {
    com.tencent.luggage.wxa.ql.a.a();
  }
  
  private void b(com.tencent.luggage.wxa.ig.e parame, int paramInt)
  {
    if (this.j != null) {
      this.j.a(parame, paramInt);
    }
  }
  
  private void k()
  {
    o.d("MicroMsg.Music.QQMusicPlayer", "initPlayer");
    l();
    Object localObject2;
    if (!af.c(this.s))
    {
      o.d("MicroMsg.Music.QQMusicPlayer", "play with local file, filePath:%s", new Object[] { this.s });
      if (this.c == null) {
        this.c = new CommonPlayer(this.y);
      }
      this.c.reset();
      if (this.s.startsWith("file://")) {
        this.s = this.s.substring(7);
      }
      try
      {
        this.c.setDataSource(this.s);
        this.c.prepare();
      }
      catch (Exception localException1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("initPlayer exception:");
        ((StringBuilder)localObject2).append(localException1.getMessage());
        o.b("MicroMsg.Music.QQMusicPlayer", ((StringBuilder)localObject2).toString());
        o.a("MicroMsg.Music.QQMusicPlayer", localException1, "initPlayer", new Object[0]);
        a(this.b, 501);
        b(this.b, 501);
      }
    }
    else
    {
      Object localObject1 = null;
      try
      {
        localObject2 = new URL(this.r);
        localObject1 = localObject2;
      }
      catch (Exception localException3)
      {
        o.a("MicroMsg.Music.QQMusicPlayer", localException3, "initPlayer", new Object[0]);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("new URL exception:");
        localStringBuilder.append(localException3.getMessage());
        o.b("MicroMsg.Music.QQMusicPlayer", localStringBuilder.toString());
      }
      if (localObject1 == null)
      {
        o.b("MicroMsg.Music.QQMusicPlayer", "initPlayer url is null");
        a(this.b, 500);
        b(this.b, 500);
        return;
      }
      if (this.c == null) {
        this.c = new CommonPlayer(this.y);
      }
      this.c.reset();
      if (this.g == null) {
        this.g = new com.tencent.luggage.wxa.qp.b();
      }
      Object localObject3 = this.b;
      if (localObject3 == null) {
        localObject3 = "invalidReferrer";
      } else {
        localObject3 = ((com.tencent.luggage.wxa.ig.e)localObject3).E;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initPlayer, referrer: ");
      localStringBuilder.append((String)localObject3);
      o.d("MicroMsg.Music.QQMusicPlayer", localStringBuilder.toString());
      this.g.a(this.r, (String)localObject3);
      try
      {
        this.c.setDataSource(this.g, Uri.parse(localObject1.toString()));
        this.c.prepare();
      }
      catch (Exception localException2)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("initPlayer exception:");
        ((StringBuilder)localObject3).append(localException2.getMessage());
        o.b("MicroMsg.Music.QQMusicPlayer", ((StringBuilder)localObject3).toString());
        o.a("MicroMsg.Music.QQMusicPlayer", localException2, "initPlayer", new Object[0]);
        a(this.b, 501);
        b(this.b, 501);
      }
    }
    a((float)this.b.A);
    b(this.b.B);
  }
  
  private void l()
  {
    this.r = this.b.C;
    this.s = this.b.o;
    o.d("MicroMsg.Music.QQMusicPlayer", "mSrc:%s mSongLocalPath:%s", new Object[] { this.r, this.s });
    o.d("MicroMsg.Music.QQMusicPlayer", "field_songWifiUrl:%s", new Object[] { this.b.i });
    if ((!af.c(this.r)) && (af.c(this.s)))
    {
      g.a(this.r);
      g.a(this.r, 0);
      g.b(this.r, 0);
    }
  }
  
  private boolean m()
  {
    CommonPlayer localCommonPlayer = this.c;
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
  
  private void n()
  {
    AudioFormat.AudioType localAudioType = this.w;
    if (localAudioType == null) {
      return;
    }
    o.d("MicroMsg.Music.QQMusicPlayer", "idKeyReportMusicMimeType audioType:%d, isStatMineType:%b", new Object[] { Integer.valueOf(localAudioType.getValue()), Boolean.valueOf(this.x) });
    if (this.x) {
      return;
    }
    o.d("MicroMsg.Music.QQMusicPlayer", "idKeyReportMusicMimeType OK");
    this.x = true;
    if (this.j != null) {
      this.j.b(this.b, this.w.getValue());
    }
  }
  
  private void o()
  {
    if (this.c != null)
    {
      this.l = H();
      this.n += SystemClock.elapsedRealtime() - this.m;
      this.o = I();
      if (this.j != null) {
        this.j.a(this.b, this.l, this.n, this.o);
      }
    }
  }
  
  private void p()
  {
    this.l = 0L;
    this.m = SystemClock.elapsedRealtime();
    this.n = 0L;
    this.o = 0L;
  }
  
  public boolean B()
  {
    return (this.e) && (!m());
  }
  
  public void G()
  {
    o.d("MicroMsg.Music.QQMusicPlayer", "stopPlay");
    try
    {
      o();
      if (this.c != null) {
        this.c.stop();
      }
      if (this.f != null)
      {
        this.f.b();
        this.f = null;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.Music.QQMusicPlayer", localException, "stopPlay", new Object[0]);
      a(this.b, 504);
      b(this.b, 504);
    }
    i.h().b();
    this.e = false;
    this.a = false;
  }
  
  public int H()
  {
    CommonPlayer localCommonPlayer = this.c;
    if (localCommonPlayer != null) {
      return (int)localCommonPlayer.getCurrentPosition();
    }
    return -1;
  }
  
  public int I()
  {
    CommonPlayer localCommonPlayer = this.c;
    if (localCommonPlayer != null) {
      return localCommonPlayer.getDuration();
    }
    return -1;
  }
  
  public void a()
  {
    this.a = true;
    o.d("MicroMsg.Music.QQMusicPlayer", "passivePause");
    if ((this.c != null) && (t())) {
      try
      {
        this.c.pause();
        return;
      }
      catch (Exception localException)
      {
        o.a("MicroMsg.Music.QQMusicPlayer", localException, "passivePause", new Object[0]);
        a(this.b, 503);
        b(this.b, 503);
      }
    }
  }
  
  public void a(float paramFloat)
  {
    if (this.c == null) {
      return;
    }
    if ((paramFloat >= 0.5F) && (paramFloat <= 2.0F))
    {
      o.d("MicroMsg.Music.QQMusicPlayer", "set speed :%f", new Object[] { Float.valueOf(paramFloat) });
      this.c.setSpeed(paramFloat);
      return;
    }
    this.c.setSpeed(1.0F);
  }
  
  public void a(com.tencent.luggage.wxa.ig.e parame)
  {
    super.a(parame);
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.v;
    com.tencent.luggage.wxa.ig.e locale = this.b;
    if ((locale != null) && (locale.a(parame)) && (l2 <= 3000L))
    {
      this.b = parame;
      o.b("MicroMsg.Music.QQMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[] { this.r, Long.valueOf(l2) });
      return;
    }
    if (parame == null)
    {
      o.b("MicroMsg.Music.QQMusicPlayer", "music is null");
      return;
    }
    p();
    if (this.j != null) {
      this.j.a(parame, false);
    }
    this.v = l1;
    this.b = parame;
    o.d("MicroMsg.Music.QQMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(parame.u) });
    if ((this.c != null) && (t())) {
      this.c.stop();
    }
    com.tencent.luggage.wxa.ql.a.b();
    this.t = 0;
    this.u = parame.u;
    this.w = null;
    this.x = false;
    k();
    h();
  }
  
  public void b(float paramFloat)
  {
    CommonPlayer localCommonPlayer = this.c;
    if ((localCommonPlayer != null) && (paramFloat >= 0.0F)) {
      localCommonPlayer.setVolume(paramFloat, paramFloat);
    }
  }
  
  public boolean b()
  {
    return (this.e) && (this.a);
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean c(int paramInt)
  {
    int i = I();
    o.d("MicroMsg.Music.QQMusicPlayer", "seekToMusic pos:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if ((i >= 0) && (paramInt <= i))
    {
      if (this.c != null)
      {
        j(this.b);
        this.c.seekTo(paramInt);
      }
      return true;
    }
    o.b("MicroMsg.Music.QQMusicPlayer", "position is invalid, position:%d, duration:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    G();
    return false;
  }
  
  public c d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void e()
  {
    this.j = ((d)com.tencent.luggage.wxa.qn.b.a(d.class));
    this.k = i.i();
  }
  
  public int f()
  {
    CommonPlayer localCommonPlayer = this.c;
    int i;
    if (localCommonPlayer != null) {
      i = localCommonPlayer.getBufferedPercentage();
    } else {
      i = 0;
    }
    if (i >= 0)
    {
      if (i > 100) {
        return 0;
      }
      return i;
    }
    return 0;
  }
  
  public void g()
  {
    com.tencent.luggage.wxa.ig.e locale = i.f().d();
    if (locale == null) {
      return;
    }
    if ((locale.a(this.b)) && (this.c != null) && (t()))
    {
      int i = (int)this.c.getCurrentPosition();
      int j = this.c.getDuration();
      if ((i > 0) && (j > 0)) {
        a(i, j);
      }
    }
  }
  
  public void l(com.tencent.luggage.wxa.ig.e parame)
  {
    com.tencent.luggage.wxa.ig.e locale = this.b;
    if ((locale != null) && (locale.a(parame)))
    {
      o.d("MicroMsg.Music.QQMusicPlayer", "updateCurrentMusicWrapper src:%s", new Object[] { this.r });
      if ((parame.A > 0.0D) && (parame.A != this.b.A))
      {
        o.d("MicroMsg.Music.QQMusicPlayer", "setPlaybackRate playbackRate:%f", new Object[] { Double.valueOf(parame.A) });
        a((float)parame.A);
        this.b.A = parame.A;
      }
      if ((parame.B >= 0.0F) && (parame.B != this.b.B))
      {
        o.d("MicroMsg.Music.QQMusicPlayer", "setVolume volume:%f", new Object[] { Float.valueOf(parame.B) });
        b(parame.B);
        this.b.B = parame.B;
      }
    }
  }
  
  public void q()
  {
    this.a = false;
    o.d("MicroMsg.Music.QQMusicPlayer", "pause");
    if ((this.c != null) && (t())) {
      try
      {
        this.c.pause();
        return;
      }
      catch (Exception localException)
      {
        o.a("MicroMsg.Music.QQMusicPlayer", localException, "pause", new Object[0]);
        a(this.b, 503);
        b(this.b, 503);
      }
    }
  }
  
  public void r()
  {
    o.d("MicroMsg.Music.QQMusicPlayer", "pauseAndAbandonFocus");
    q();
    i.h().b();
  }
  
  public void s()
  {
    this.t = 0;
    boolean bool1 = m();
    boolean bool2 = t();
    o.d("MicroMsg.Music.QQMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((this.c != null) && (!bool1) && (!bool2))
    {
      if (i.h().a()) {
        try
        {
          this.c.start();
        }
        catch (Exception localException)
        {
          o.a("MicroMsg.Music.QQMusicPlayer", localException, "resume", new Object[0]);
          a(this.b, 502);
          b(this.b, 502);
        }
      } else {
        o.b("MicroMsg.Music.QQMusicPlayer", "request focus error");
      }
      this.e = true;
    }
  }
  
  public boolean t()
  {
    CommonPlayer localCommonPlayer = this.c;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qk.e
 * JD-Core Version:    0.7.0.1
 */