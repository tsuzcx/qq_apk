package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;

public final class PlaybackParameters
{
  public static final PlaybackParameters DEFAULT = new PlaybackParameters(1.0F, 1.0F);
  public final float pitch;
  private final int scaledUsPerMs;
  public final float speed;
  
  public PlaybackParameters(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramFloat1 > 0.0F) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Assertions.checkArgument(bool1);
    if (paramFloat2 > 0.0F) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Assertions.checkArgument(bool1);
    this.speed = paramFloat1;
    this.pitch = paramFloat2;
    this.scaledUsPerMs = Math.round(paramFloat1 * 1000.0F);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (PlaybackParameters)paramObject;
      return (this.speed == paramObject.speed) && (this.pitch == paramObject.pitch);
    }
    return false;
  }
  
  public long getMediaTimeUsForPlayoutTimeMs(long paramLong)
  {
    return paramLong * this.scaledUsPerMs;
  }
  
  public int hashCode()
  {
    return (527 + Float.floatToRawIntBits(this.speed)) * 31 + Float.floatToRawIntBits(this.pitch);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.PlaybackParameters
 * JD-Core Version:    0.7.0.1
 */