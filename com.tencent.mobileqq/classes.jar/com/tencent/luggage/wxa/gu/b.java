package com.tencent.luggage.wxa.gu;

import android.media.AudioTrack;
import com.tencent.luggage.wxa.gm.d;
import com.tencent.luggage.wxa.gt.f;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.util.concurrent.atomic.AtomicInteger;

public class b
  extends a
{
  private static long p;
  private static long q;
  private Thread o;
  
  public b(int paramInt1, int paramInt2, d paramd, f paramf)
  {
    super(paramInt1, paramInt2, paramd, paramf);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.a == null)
    {
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack before");
      if (!a())
      {
        if (this.i != null) {
          this.i.e(707);
        }
        com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack fail");
        return;
      }
      try
      {
        AudioTrack localAudioTrack = this.a;
        if (localAudioTrack != null) {
          localAudioTrack.setStereoVolume(this.l, this.l);
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", localIllegalStateException, "setStereoVolume", new Object[0]);
      }
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack after and success!");
    }
    if (this.b == null)
    {
      if (this.h != null) {
        j = this.h.c() * 3536;
      } else {
        j = 3536;
      }
      int i = j;
      if (j == 0) {
        i = 3536;
      }
      int j = i;
      if (paramArrayOfByte.length == 3536) {
        j = i + 1;
      }
      this.b = new byte[j];
    }
    if (this.d + paramArrayOfByte.length <= this.b.length)
    {
      System.arraycopy(paramArrayOfByte, 0, this.b, this.d, paramArrayOfByte.length);
      this.d += paramArrayOfByte.length;
    }
  }
  
  protected boolean a()
  {
    if (this.c > 1)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", "createAudioTrack fail count reach MAX COUNT");
      return false;
    }
    int j;
    if (this.f == 1) {
      j = 4;
    } else {
      j = 12;
    }
    int k = AudioTrack.getMinBufferSize(this.e, j, 2);
    int i = k;
    if (this.h != null)
    {
      i = k;
      if (this.h.c() > 0) {
        i = this.h.c() * 3536;
      }
    }
    k = i;
    if (this.g > 1.0D)
    {
      double d1 = this.g;
      double d2 = i;
      Double.isNaN(d2);
      k = (int)(d1 * d2);
    }
    if (this.a == null)
    {
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioPcmStaticPlayComponent", "new AudioTrack");
      System.currentTimeMillis();
      this.a = new ReportAudioTrack(3, this.e, j, 2, k, 0);
      this.c += 1;
      n.incrementAndGet();
    }
    if ((this.a != null) && (this.a.getState() == 2)) {
      return true;
    }
    com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", "audio track not initialized");
    m.incrementAndGet();
    if (this.a != null)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack getState:%d", new Object[] { Integer.valueOf(this.a.getState()) });
      try
      {
        this.a.release();
        this.a = null;
        return false;
      }
      catch (Exception localException)
      {
        com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", localException, "AudioTrack release", new Object[0]);
      }
    }
    return false;
  }
  
  public void b()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioPcmStaticPlayComponent", "playFlush play_count:%d, fail_count:%d", new Object[] { Integer.valueOf(n.get()), Integer.valueOf(m.get()) });
    if (this.a != null)
    {
      if (this.i != null) {
        this.i.t();
      }
      AudioTrack localAudioTrack = this.a;
      if ((localAudioTrack.getState() == 2) && (localAudioTrack.write(this.b, 0, this.b.length) <= 0))
      {
        com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack write fail, should write length:%d", new Object[] { Integer.valueOf(this.b.length) });
        this.i.e(708);
        return;
      }
      if (localAudioTrack.getState() == 1)
      {
        localAudioTrack.reloadStaticData();
        b(this.g);
        localAudioTrack.play();
        this.o = Thread.currentThread();
      }
    }
    try
    {
      long l2 = this.h.d();
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = 2000L;
      }
      Thread.sleep(l1);
      return;
    }
    catch (Exception localException)
    {
      label186:
      break label186;
    }
    com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play Thread.sleep");
  }
  
  public void c()
  {
    AudioTrack localAudioTrack = this.a;
    if ((localAudioTrack != null) && (localAudioTrack.getState() == 1))
    {
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioPcmStaticPlayComponent", "resume");
      if (this.i != null) {
        this.i.t();
      }
      try
      {
        localAudioTrack.setStereoVolume(this.l, this.l);
      }
      catch (IllegalStateException localIllegalStateException)
      {
        com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", localIllegalStateException, "setStereoVolume", new Object[0]);
      }
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play startPos:%d", new Object[] { Integer.valueOf(this.j) });
      localAudioTrack.setPlaybackHeadPosition(this.j);
      localAudioTrack.play();
    }
    try
    {
      long l2 = this.h.d();
      long l1 = l2;
      if (l2 <= 0L) {
        l1 = 2000L;
      }
      Thread.sleep(l1);
      return;
    }
    catch (Exception localException)
    {
      label136:
      break label136;
    }
    com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play Thread.sleep");
  }
  
  public void d()
  {
    AudioTrack localAudioTrack = this.a;
    if (localAudioTrack != null)
    {
      int i = localAudioTrack.getState();
      int j = localAudioTrack.getPlayState();
      if ((i == 1) && (j == 3)) {
        try
        {
          localAudioTrack.pause();
          this.j = localAudioTrack.getPlaybackHeadPosition();
          com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioPcmStaticPlayComponent", "pause startPos :%d", new Object[] { Integer.valueOf(this.j) });
          if (this.o != null)
          {
            this.o.interrupt();
            return;
          }
        }
        catch (Exception localException)
        {
          com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioPcmStaticPlayComponent", localException, "pause", new Object[0]);
        }
      }
    }
  }
  
  public void g()
  {
    super.g();
    f();
    this.o = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gu.b
 * JD-Core Version:    0.7.0.1
 */