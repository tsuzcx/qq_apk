package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;

public final class AudioAttributes
{
  public static final AudioAttributes DEFAULT = new AudioAttributes.Builder().build();
  private android.media.AudioAttributes audioAttributesV21;
  public final int contentType;
  public final int flags;
  public final int usage;
  
  private AudioAttributes(int paramInt1, int paramInt2, int paramInt3)
  {
    this.contentType = paramInt1;
    this.flags = paramInt2;
    this.usage = paramInt3;
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
      paramObject = (AudioAttributes)paramObject;
      return (this.contentType == paramObject.contentType) && (this.flags == paramObject.flags) && (this.usage == paramObject.usage);
    }
    return false;
  }
  
  @TargetApi(21)
  android.media.AudioAttributes getAudioAttributesV21()
  {
    if (this.audioAttributesV21 == null) {
      this.audioAttributesV21 = new android.media.AudioAttributes.Builder().setContentType(this.contentType).setFlags(this.flags).setUsage(this.usage).build();
    }
    return this.audioAttributesV21;
  }
  
  public int hashCode()
  {
    return ((527 + this.contentType) * 31 + this.flags) * 31 + this.usage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioAttributes
 * JD-Core Version:    0.7.0.1
 */