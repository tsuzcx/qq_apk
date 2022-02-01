package com.tencent.luggage.wxa.gu;

import android.media.AudioTrack;
import com.tencent.luggage.wxa.gm.d;
import com.tencent.luggage.wxa.gt.f;
import com.tencent.luggage.wxa.gw.b;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.util.concurrent.atomic.AtomicInteger;

public class c
  extends a
{
  private static long o;
  private static long p;
  
  public c(int paramInt1, int paramInt2, d paramd, f paramf)
  {
    super(paramInt1, paramInt2, paramd, paramf);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.a == null)
    {
      b.b("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack before");
      if (!a())
      {
        if (this.i != null) {
          this.i.e(707);
        }
        b.a("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack fail");
        return;
      }
      b.b("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack success");
      try
      {
        b(this.g);
        this.a.play();
        this.a.setStereoVolume(this.l, this.l);
      }
      catch (IllegalStateException localIllegalStateException)
      {
        b.a("MicroMsg.Mix.AudioPcmStreamPlayComponent", localIllegalStateException, "setStereoVolume", new Object[0]);
      }
      b.b("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack after");
    }
    if (this.i != null) {
      this.i.t();
    }
    this.a.setStereoVolume(this.l, this.l);
    this.a.write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  protected boolean a()
  {
    b.b("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack");
    if (this.c > 1)
    {
      b.a("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack fail count reach MAX COUNT");
      return false;
    }
    int i;
    if (this.f == 1) {
      i = 4;
    } else {
      i = 12;
    }
    int k = AudioTrack.getMinBufferSize(this.e, i, 2);
    if (k <= 0)
    {
      b.a("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack miniBufferSize %d is illegal", new Object[] { Integer.valueOf(k) });
      return false;
    }
    int j = k;
    if (this.g > 1.0D)
    {
      double d1 = this.g;
      double d2 = k;
      Double.isNaN(d2);
      j = (int)(d1 * d2);
    }
    if (this.a == null)
    {
      b.a("MicroMsg.Mix.AudioPcmStreamPlayComponent", "new AudioTrack");
      System.currentTimeMillis();
      this.a = new ReportAudioTrack(3, this.e, i, 2, j, 1);
      this.c += 1;
      n.incrementAndGet();
    }
    if ((this.a != null) && (this.a.getState() == 1)) {
      return true;
    }
    m.incrementAndGet();
    b.b("MicroMsg.Mix.AudioPcmStreamPlayComponent", "play_count:%d, fail_count:%d", new Object[] { Integer.valueOf(n.get()), Integer.valueOf(m.get()) });
    b.a("MicroMsg.Mix.AudioPcmStreamPlayComponent", "audio track not initialized");
    if (this.a != null)
    {
      b.a("MicroMsg.Mix.AudioPcmStreamPlayComponent", "AudioTrack getState:%d", new Object[] { Integer.valueOf(this.a.getState()) });
      try
      {
        this.a.release();
        this.a = null;
        return false;
      }
      catch (Exception localException)
      {
        b.a("MicroMsg.Mix.AudioPcmStreamPlayComponent", localException, "AudioTrack release", new Object[0]);
      }
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    b.b("MicroMsg.Mix.AudioPcmStreamPlayComponent", "playFlush");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gu.c
 * JD-Core Version:    0.7.0.1
 */