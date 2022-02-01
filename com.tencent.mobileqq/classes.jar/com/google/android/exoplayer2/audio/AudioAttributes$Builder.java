package com.google.android.exoplayer2.audio;

public final class AudioAttributes$Builder
{
  private int contentType = 0;
  private int flags = 0;
  private int usage = 1;
  
  public AudioAttributes build()
  {
    return new AudioAttributes(this.contentType, this.flags, this.usage, null);
  }
  
  public Builder setContentType(int paramInt)
  {
    this.contentType = paramInt;
    return this;
  }
  
  public Builder setFlags(int paramInt)
  {
    this.flags = paramInt;
    return this;
  }
  
  public Builder setUsage(int paramInt)
  {
    this.usage = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioAttributes.Builder
 * JD-Core Version:    0.7.0.1
 */