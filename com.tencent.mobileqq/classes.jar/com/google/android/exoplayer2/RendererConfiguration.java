package com.google.android.exoplayer2;

public final class RendererConfiguration
{
  public static final RendererConfiguration DEFAULT = new RendererConfiguration(0);
  public final int tunnelingAudioSessionId;
  
  public RendererConfiguration(int paramInt)
  {
    this.tunnelingAudioSessionId = paramInt;
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
      paramObject = (RendererConfiguration)paramObject;
      return this.tunnelingAudioSessionId == paramObject.tunnelingAudioSessionId;
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.tunnelingAudioSessionId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.RendererConfiguration
 * JD-Core Version:    0.7.0.1
 */