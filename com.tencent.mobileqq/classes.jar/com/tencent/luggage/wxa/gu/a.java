package com.tencent.luggage.wxa.gu;

import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Build.VERSION;
import com.tencent.luggage.wxa.gm.d;
import com.tencent.luggage.wxa.gt.f;
import com.tencent.luggage.wxa.gw.b;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
{
  protected static volatile AtomicInteger m = new AtomicInteger(0);
  protected static volatile AtomicInteger n = new AtomicInteger(0);
  protected volatile AudioTrack a;
  protected byte[] b;
  protected int c = 0;
  protected int d = 0;
  protected int e = 0;
  protected int f = 0;
  protected double g = 0.0D;
  protected d h;
  protected f i;
  protected int j = 0;
  protected long k = -1L;
  protected float l = 1.0F;
  
  public a(int paramInt1, int paramInt2, d paramd, f paramf)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.h = paramd;
    this.i = paramf;
  }
  
  public void a(double paramDouble)
  {
    this.g = paramDouble;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    try
    {
      if ((this.a != null) && ((this.a.getState() == 1) || (this.a.getState() == 2))) {
        this.a.setStereoVolume(paramFloat1, paramFloat2);
      }
    }
    catch (Exception localException)
    {
      b.a("MicroMsg.Mix.AudioPcmBasePlayComponent", localException, "setVolume", new Object[0]);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      b.a("MicroMsg.Mix.AudioPcmBasePlayComponent", localIllegalStateException, "setVolume", new Object[0]);
    }
    this.l = paramFloat1;
  }
  
  public void a(int paramInt)
  {
    b.b("MicroMsg.Mix.AudioPcmBasePlayComponent", "seek startPos:%d", new Object[] { Integer.valueOf(this.j) });
    this.j = paramInt;
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  protected abstract boolean a();
  
  public void b() {}
  
  public void b(double paramDouble)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      b.b("MicroMsg.Mix.AudioPcmBasePlayComponent", "setPlaybackRate:%f", new Object[] { Double.valueOf(paramDouble) });
      try
      {
        if ((this.a != null) && ((this.a.getState() == 1) || (this.a.getState() == 2)))
        {
          PlaybackParams localPlaybackParams = this.a.getPlaybackParams();
          localPlaybackParams.setSpeed((float)paramDouble);
          this.a.setPlaybackParams(localPlaybackParams);
          return;
        }
      }
      catch (Exception localException)
      {
        b.a("MicroMsg.Mix.AudioPcmBasePlayComponent", localException, "setPlaybackRate", new Object[0]);
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        b.a("MicroMsg.Mix.AudioPcmBasePlayComponent", localIllegalStateException, "setPlaybackRate", new Object[0]);
      }
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    f();
    this.i = null;
    this.h = null;
    this.b = null;
    this.c = 0;
    this.d = 0;
  }
  
  protected void f()
  {
    try
    {
      if ((this.a != null) && (this.a.getState() != 0))
      {
        this.a.stop();
        this.a.flush();
      }
      if (this.a != null)
      {
        this.a.release();
        this.a = null;
        return;
      }
    }
    catch (Exception localException)
    {
      b.a("MicroMsg.Mix.AudioPcmBasePlayComponent", localException, "releaseAudioTrack", new Object[0]);
    }
  }
  
  public void g()
  {
    this.c = 0;
    this.d = 0;
    byte[] arrayOfByte = this.b;
    if (arrayOfByte != null) {
      Arrays.fill(arrayOfByte, 0, arrayOfByte.length, (byte)0);
    }
  }
  
  public long h()
  {
    long l2 = -1L;
    long l1 = l2;
    try
    {
      if (this.a != null)
      {
        l1 = l2;
        if (this.a.getState() != 0)
        {
          l1 = l2;
          double d1 = this.a.getPlaybackHeadPosition();
          l1 = l2;
          int i1 = this.a.getSampleRate();
          double d2 = i1;
          Double.isNaN(d1);
          Double.isNaN(d2);
          d1 /= d2;
          l1 = l2;
          l2 = Math.round(d1 * 1000.0D);
          l1 = l2;
          this.k = l2;
          return l2;
        }
      }
      l1 = l2;
      l2 = this.k;
      return l2;
    }
    catch (Exception localException)
    {
      b.a("MicroMsg.Mix.AudioPcmBasePlayComponent", localException, "getCurrentPosition", new Object[0]);
    }
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gu.a
 * JD-Core Version:    0.7.0.1
 */