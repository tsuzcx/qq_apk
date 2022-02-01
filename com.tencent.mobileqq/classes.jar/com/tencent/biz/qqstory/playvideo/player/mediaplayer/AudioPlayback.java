package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.util.Log;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.nio.ByteBuffer;

class AudioPlayback
{
  public static long a = -9223372036854775808L;
  protected AudioPlayback.BufferQueue b = new AudioPlayback.BufferQueue();
  private MediaFormat c;
  private AudioTrack d;
  private byte[] e;
  private int f = 8192;
  private int g;
  private int h;
  private int i;
  private AudioPlayback.AudioThread j;
  private long k;
  private int l = 0;
  private int m = 3;
  private float n = 1.0F;
  private float o = 1.0F;
  private long p;
  private long q;
  
  private void b(boolean paramBoolean)
  {
    if (c())
    {
      if (paramBoolean) {
        this.j.interrupt();
      }
      this.d.stop();
      this.d.release();
    }
    this.d = null;
  }
  
  @TargetApi(16)
  private boolean b(MediaFormat paramMediaFormat)
  {
    return (this.c.getInteger("channel-count") != paramMediaFormat.getInteger("channel-count")) || (this.c.getInteger("sample-rate") != paramMediaFormat.getInteger("sample-rate")) || (!this.c.getString("mime").equals(paramMediaFormat.getString("mime")));
  }
  
  private long l()
  {
    double d1 = this.d.getPlaybackHeadPosition() & 0xFFFFFFFF;
    double d2 = this.h;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return (d1 / d2 * 1000000.0D);
  }
  
  public int a()
  {
    return this.l;
  }
  
  public void a(float paramFloat)
  {
    if (c())
    {
      this.d.setPlaybackRate((int)(this.h * paramFloat));
      return;
    }
    throw new IllegalStateException();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.n = paramFloat1;
    this.o = paramFloat2;
    AudioTrack localAudioTrack = this.d;
    if (localAudioTrack != null) {
      localAudioTrack.setStereoVolume(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    if (!c())
    {
      this.l = paramInt;
      return;
    }
    throw new IllegalStateException("cannot set session id on an initialized audio track");
  }
  
  @TargetApi(16)
  public void a(MediaFormat paramMediaFormat)
  {
    Log.d("AudioPlayback", "init");
    boolean bool;
    if (c())
    {
      if (!b(paramMediaFormat))
      {
        this.c = paramMediaFormat;
        return;
      }
      bool = k();
      e();
      b(false);
    }
    else
    {
      this.j = new AudioPlayback.AudioThread(this);
      this.j.a(true);
      this.j.start();
      bool = false;
    }
    this.c = paramMediaFormat;
    int i2 = paramMediaFormat.getInteger("channel-count");
    this.g = (i2 * 2);
    this.h = paramMediaFormat.getInteger("sample-rate");
    int i1;
    if (i2 != 1)
    {
      if (i2 != 2)
      {
        if (i2 != 4)
        {
          if (i2 != 6)
          {
            if (i2 != 8) {
              i1 = 1;
            } else {
              i1 = 1020;
            }
          }
          else {
            i1 = 252;
          }
        }
        else {
          i1 = 204;
        }
      }
      else {
        i1 = 12;
      }
    }
    else {
      i1 = 4;
    }
    this.i = (this.f * i2);
    this.d = new ReportAudioTrack(this.m, this.h, i1, 2, this.i, 1, this.l);
    this.l = this.d.getAudioSessionId();
    this.m = this.d.getStreamType();
    a(this.n, this.o);
    this.p = a;
    if (bool) {
      d();
    }
  }
  
  public void a(ByteBuffer paramByteBuffer, long paramLong)
  {
    int i1 = paramByteBuffer.remaining();
    if (this.f < i1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("incoming frame chunk size increased to ");
      localStringBuilder.append(i1);
      Log.d("AudioPlayback", localStringBuilder.toString());
      this.f = i1;
      a(this.c);
    }
    if (this.p == a)
    {
      this.p = paramLong;
      this.q = 0L;
      long l1 = l();
      if (l1 > 0L)
      {
        this.p -= l1;
        Log.d("AudioPlayback", "playback head not reset");
      }
    }
    this.b.a(paramByteBuffer, paramLong);
    this.j.a();
  }
  
  public void a(boolean paramBoolean)
  {
    if (c())
    {
      this.j.a(true);
      this.d.pause();
      if (paramBoolean) {
        f();
      }
      return;
    }
    throw new IllegalStateException();
  }
  
  public int b()
  {
    return this.m;
  }
  
  protected void b(ByteBuffer paramByteBuffer, long paramLong)
  {
    int i1 = paramByteBuffer.remaining();
    byte[] arrayOfByte = this.e;
    if ((arrayOfByte == null) || (arrayOfByte.length < i1)) {
      this.e = new byte[i1];
    }
    paramByteBuffer.get(this.e, 0, i1);
    this.k = paramLong;
    this.d.write(this.e, 0, i1);
  }
  
  public boolean c()
  {
    return this.d != null;
  }
  
  public void d()
  {
    if (c())
    {
      this.d.play();
      this.j.a(false);
      return;
    }
    throw new IllegalStateException();
  }
  
  public void e()
  {
    a(true);
  }
  
  public void f()
  {
    if (c())
    {
      boolean bool = k();
      if (bool) {
        this.d.pause();
      }
      this.d.flush();
      this.b.b();
      this.p = a;
      if (bool) {
        this.d.play();
      }
      return;
    }
    throw new IllegalStateException();
  }
  
  public void g()
  {
    b(true);
  }
  
  public long h()
  {
    double d1 = AudioPlayback.BufferQueue.a(this.b) / this.g;
    double d2 = this.h;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return (d1 / d2 * 1000000.0D);
  }
  
  public long i()
  {
    double d1 = this.i / this.g;
    double d2 = this.h;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return (d1 / d2 * 1000000.0D);
  }
  
  public long j()
  {
    long l1 = this.p;
    long l2 = a;
    if (l1 == l2) {
      return l2;
    }
    l1 = l();
    if (l1 < this.q)
    {
      Log.d("AudioPlayback", "playback head has wrapped");
      l2 = this.p;
      double d1 = this.h;
      Double.isNaN(d1);
      this.p = (l2 + (-1.0D / d1 * 1000000.0D));
    }
    this.q = l1;
    return this.p + l1;
  }
  
  public boolean k()
  {
    return this.d.getPlayState() == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback
 * JD-Core Version:    0.7.0.1
 */