package com.tencent.luggage.wxa.i;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
class f$b
  extends f.a
{
  private final AudioTimestamp b = new AudioTimestamp();
  private long c;
  private long d;
  private long e;
  
  public f$b()
  {
    super(null);
  }
  
  public void a(AudioTrack paramAudioTrack, boolean paramBoolean)
  {
    super.a(paramAudioTrack, paramBoolean);
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
  }
  
  public boolean d()
  {
    boolean bool = this.a.getTimestamp(this.b);
    if (bool)
    {
      long l = this.b.framePosition;
      if (this.d > l) {
        this.c += 1L;
      }
      this.d = l;
      this.e = (l + (this.c << 32));
    }
    return bool;
  }
  
  public long e()
  {
    return this.b.nanoTime;
  }
  
  public long f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.i.f.b
 * JD-Core Version:    0.7.0.1
 */