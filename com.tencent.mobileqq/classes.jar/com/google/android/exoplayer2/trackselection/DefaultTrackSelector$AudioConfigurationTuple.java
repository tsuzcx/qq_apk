package com.google.android.exoplayer2.trackselection;

import android.text.TextUtils;

final class DefaultTrackSelector$AudioConfigurationTuple
{
  public final int channelCount;
  public final String mimeType;
  public final int sampleRate;
  
  public DefaultTrackSelector$AudioConfigurationTuple(int paramInt1, int paramInt2, String paramString)
  {
    this.channelCount = paramInt1;
    this.sampleRate = paramInt2;
    this.mimeType = paramString;
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
      paramObject = (AudioConfigurationTuple)paramObject;
      return (this.channelCount == paramObject.channelCount) && (this.sampleRate == paramObject.sampleRate) && (TextUtils.equals(this.mimeType, paramObject.mimeType));
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = this.channelCount;
    int k = this.sampleRate;
    String str = this.mimeType;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return (j * 31 + k) * 31 + i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioConfigurationTuple
 * JD-Core Version:    0.7.0.1
 */