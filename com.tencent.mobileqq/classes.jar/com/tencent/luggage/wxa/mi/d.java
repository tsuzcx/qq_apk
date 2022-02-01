package com.tencent.luggage.wxa.mi;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.hc.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;

public class d
  extends a
{
  private MediaPlayer i;
  private MediaPlayer.OnPreparedListener j = new d.1(this);
  private MediaPlayer.OnVideoSizeChangedListener k = new d.2(this);
  private MediaPlayer.OnCompletionListener l = new d.3(this);
  private MediaPlayer.OnInfoListener m = new d.4(this);
  private MediaPlayer.OnSeekCompleteListener n = new d.5(this);
  private MediaPlayer.OnErrorListener o = new d.6(this);
  private MediaPlayer.OnBufferingUpdateListener p = new d.7(this);
  
  public d()
  {
    p();
  }
  
  private void c(int paramInt)
  {
    MediaPlayer.OnErrorListener localOnErrorListener = this.o;
    if (localOnErrorListener != null) {
      localOnErrorListener.onError(this.i, -1024, paramInt);
    }
  }
  
  private void p()
  {
    this.i = new b();
    this.i.setScreenOnWhilePlaying(true);
    this.i.setAudioStreamType(3);
    this.i.setOnInfoListener(this.m);
    this.i.setOnErrorListener(this.o);
    this.i.setOnPreparedListener(this.j);
    this.i.setOnCompletionListener(this.l);
    this.i.setOnSeekCompleteListener(this.n);
    this.i.setOnVideoSizeChangedListener(this.k);
    this.i.setOnBufferingUpdateListener(this.p);
  }
  
  private boolean q()
  {
    return this.i != null;
  }
  
  private void r()
  {
    MediaPlayer localMediaPlayer = this.i;
    if (localMediaPlayer == null) {
      return;
    }
    localMediaPlayer.setOnInfoListener(null);
    this.i.setOnErrorListener(null);
    this.i.setOnPreparedListener(null);
    this.i.setOnCompletionListener(null);
    this.i.setOnSeekCompleteListener(null);
    this.i.setOnBufferingUpdateListener(null);
    this.i.setOnVideoSizeChangedListener(null);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    try
    {
      if (q())
      {
        this.i.setVolume(paramFloat1, paramFloat2);
        return;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setVolume fail", new Object[] { Integer.valueOf(hashCode()) });
      c(-13);
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      if ((q()) && ((a() == 2) || (a() == 3) || (a() == 4) || (a() == 6)))
      {
        this.i.seekTo((int)paramLong);
        return;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s seekTo fail", new Object[] { Integer.valueOf(hashCode()) });
      c(-3);
    }
  }
  
  public void a(Surface paramSurface)
  {
    try
    {
      if (q())
      {
        this.i.setSurface(paramSurface);
        return;
      }
    }
    catch (Exception paramSurface)
    {
      o.a("MicroMsg.SameLayer.SystemMediaPlayer", paramSurface, "%s setSurface fail", new Object[] { Integer.valueOf(hashCode()) });
      c(-12);
    }
  }
  
  public void a(String paramString1, @Nullable String paramString2)
  {
    try
    {
      if (q())
      {
        if (paramString2 == null)
        {
          this.i.setDataSource(paramString1);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setDataSource, referrer: ");
          localStringBuilder.append(paramString2);
          o.d("MicroMsg.SameLayer.SystemMediaPlayer", localStringBuilder.toString());
          paramString2 = com.tencent.luggage.wxa.lr.d.a(paramString2);
          this.i.setDataSource(r.a(), Uri.parse(paramString1), paramString2);
        }
        a(1);
        return;
      }
    }
    catch (Exception paramString1)
    {
      o.a("MicroMsg.SameLayer.SystemMediaPlayer", paramString1, "%s setDataSource fail", new Object[] { Integer.valueOf(hashCode()) });
      c(-11);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (q())
    {
      if (paramBoolean)
      {
        a(0.0F, 0.0F);
        return;
      }
      a(1.0F, 1.0F);
    }
  }
  
  public boolean a(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return false;
    }
    try
    {
      if ((q()) && (Build.VERSION.SDK_INT >= 23))
      {
        PlaybackParams localPlaybackParams = this.i.getPlaybackParams();
        localPlaybackParams.setSpeed(paramFloat);
        if (!this.i.isPlaying())
        {
          this.i.setPlaybackParams(localPlaybackParams);
          this.i.pause();
          return true;
        }
        this.i.setPlaybackParams(localPlaybackParams);
        return true;
      }
      o.c("MicroMsg.SameLayer.SystemMediaPlayer", "%s setSpeed, current system(%d) not support play speed setting", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(Build.VERSION.SDK_INT) });
      return false;
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setSpeed fail", new Object[] { Integer.valueOf(hashCode()) });
      c(-14);
    }
    return false;
  }
  
  public void b()
  {
    try
    {
      if (q())
      {
        r();
        this.i.release();
        a(-2);
        super.b();
        return;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s release fail", new Object[] { Integer.valueOf(hashCode()) });
      c(-8);
    }
  }
  
  public void b(String paramString)
  {
    a(paramString, null);
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      if (q())
      {
        this.i.setLooping(paramBoolean);
        return;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s setLooping fail", new Object[] { Integer.valueOf(hashCode()) });
      c(-10);
    }
  }
  
  public boolean f()
  {
    try
    {
      if ((q()) && (a() != -1) && (a() != -2) && (a() != 0) && (a() != 1))
      {
        boolean bool = this.i.isPlaying();
        return bool;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s isPlaying fail", new Object[] { Integer.valueOf(hashCode()) });
      c(-9);
    }
    return false;
  }
  
  public int g()
  {
    try
    {
      if ((q()) && (a() != -1) && (a() != 1) && (a() != 0))
      {
        int i1 = this.i.getDuration();
        return i1;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getDuration fail", new Object[] { Integer.valueOf(hashCode()) });
      c(-16);
    }
    return 0;
  }
  
  public int h()
  {
    try
    {
      if ((q()) && ((a() == 2) || (a() == 3) || (a() == 4) || (a() == 6)))
      {
        int i1 = this.i.getCurrentPosition();
        return i1;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getCurrentPosition fail", new Object[] { Integer.valueOf(hashCode()) });
      c(-15);
    }
    return 0;
  }
  
  public int i()
  {
    try
    {
      if (q())
      {
        int i1 = this.i.getVideoWidth();
        return i1;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoWidth fail", new Object[] { Integer.valueOf(hashCode()) });
      c(-17);
    }
    return 0;
  }
  
  public int j()
  {
    try
    {
      if (q())
      {
        int i1 = this.i.getVideoHeight();
        return i1;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s getVideoHeight fail", new Object[] { Integer.valueOf(hashCode()) });
      c(-18);
    }
    return 0;
  }
  
  public void k()
  {
    try
    {
      if (q())
      {
        this.i.prepareAsync();
        return;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s prepareAsync fail", new Object[] { Integer.valueOf(hashCode()) });
      c(-6);
    }
  }
  
  public void l()
  {
    try
    {
      if ((q()) && ((a() == 2) || (a() == 4) || (a() == 6)))
      {
        this.i.start();
        a(3);
        return;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s start fail", new Object[] { Integer.valueOf(hashCode()) });
      c(-1);
    }
  }
  
  public void m()
  {
    try
    {
      if ((q()) && ((a() == 2) || (a() == 3) || (a() == 6)))
      {
        this.i.pause();
        a(4);
        return;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s pause fail", new Object[] { Integer.valueOf(hashCode()) });
      c(-2);
    }
  }
  
  public void n()
  {
    try
    {
      if ((q()) && ((a() == 2) || (a() == 3) || (a() == 4) || (a() == 6)))
      {
        this.i.stop();
        a(5);
        return;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s stop fail", new Object[] { Integer.valueOf(hashCode()) });
      c(-4);
    }
  }
  
  public void o()
  {
    try
    {
      if (q())
      {
        this.i.reset();
        a(0);
        return;
      }
    }
    catch (Exception localException)
    {
      o.a("MicroMsg.SameLayer.SystemMediaPlayer", localException, "%s reset fail", new Object[] { Integer.valueOf(hashCode()) });
      c(-7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mi.d
 * JD-Core Version:    0.7.0.1
 */