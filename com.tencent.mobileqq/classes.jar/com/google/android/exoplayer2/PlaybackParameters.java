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
    if (paramFloat1 > 0.0F)
    {
      bool1 = true;
      Assertions.checkArgument(bool1);
      if (paramFloat2 <= 0.0F) {
        break label59;
      }
    }
    label59:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assertions.checkArgument(bool1);
      this.speed = paramFloat1;
      this.pitch = paramFloat2;
      this.scaledUsPerMs = Math.round(1000.0F * paramFloat1);
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (PlaybackParameters)paramObject;
    } while ((this.speed == paramObject.speed) && (this.pitch == paramObject.pitch));
    return false;
  }
  
  public long getMediaTimeUsForPlayoutTimeMs(long paramLong)
  {
    return this.scaledUsPerMs * paramLong;
  }
  
  public int hashCode()
  {
    return (Float.floatToRawIntBits(this.speed) + 527) * 31 + Float.floatToRawIntBits(this.pitch);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.PlaybackParameters
 * JD-Core Version:    0.7.0.1
 */