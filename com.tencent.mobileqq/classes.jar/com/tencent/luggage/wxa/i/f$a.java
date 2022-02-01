package com.tencent.luggage.wxa.i;

import android.media.AudioTrack;
import android.os.SystemClock;

class f$a
{
  protected AudioTrack a;
  private boolean b;
  private int c;
  private long d;
  private long e;
  private long f;
  private long g;
  private long h;
  private long i;
  
  public void a()
  {
    if (this.g != -9223372036854775807L) {
      return;
    }
    this.a.pause();
  }
  
  public void a(long paramLong)
  {
    this.h = b();
    this.g = (SystemClock.elapsedRealtime() * 1000L);
    this.i = paramLong;
    this.a.stop();
  }
  
  public void a(AudioTrack paramAudioTrack, boolean paramBoolean)
  {
    this.a = paramAudioTrack;
    this.b = paramBoolean;
    this.g = -9223372036854775807L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
    if (paramAudioTrack != null) {
      this.c = paramAudioTrack.getSampleRate();
    }
  }
  
  public long b()
  {
    if (this.g != -9223372036854775807L)
    {
      l1 = (SystemClock.elapsedRealtime() * 1000L - this.g) * this.c / 1000000L;
      return Math.min(this.i, this.h + l1);
    }
    int j = this.a.getPlayState();
    if (j == 1) {
      return 0L;
    }
    long l2 = 0xFFFFFFFF & this.a.getPlaybackHeadPosition();
    long l1 = l2;
    if (this.b)
    {
      if ((j == 2) && (l2 == 0L)) {
        this.f = this.d;
      }
      l1 = l2 + this.f;
    }
    if (this.d > l1) {
      this.e += 1L;
    }
    this.d = l1;
    return l1 + (this.e << 32);
  }
  
  public long c()
  {
    return b() * 1000000L / this.c;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public long e()
  {
    throw new UnsupportedOperationException();
  }
  
  public long f()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.i.f.a
 * JD-Core Version:    0.7.0.1
 */