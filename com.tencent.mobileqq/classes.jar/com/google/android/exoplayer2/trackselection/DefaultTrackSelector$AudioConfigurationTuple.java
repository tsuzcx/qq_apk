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
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (AudioConfigurationTuple)paramObject;
    } while ((this.channelCount == paramObject.channelCount) && (this.sampleRate == paramObject.sampleRate) && (TextUtils.equals(this.mimeType, paramObject.mimeType)));
    return false;
  }
  
  public int hashCode()
  {
    int j = this.channelCount;
    int k = this.sampleRate;
    if (this.mimeType != null) {}
    for (int i = this.mimeType.hashCode();; i = 0) {
      return i + (j * 31 + k) * 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioConfigurationTuple
 * JD-Core Version:    0.7.0.1
 */