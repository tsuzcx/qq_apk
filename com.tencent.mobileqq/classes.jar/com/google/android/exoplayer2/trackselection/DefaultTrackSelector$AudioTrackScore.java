package com.google.android.exoplayer2.trackselection;

import android.support.annotation.NonNull;
import com.google.android.exoplayer2.Format;

final class DefaultTrackSelector$AudioTrackScore
  implements Comparable<AudioTrackScore>
{
  private final int bitrate;
  private final int channelCount;
  private final int defaultSelectionFlagScore;
  private final int matchLanguageScore;
  private final DefaultTrackSelector.Parameters parameters;
  private final int sampleRate;
  private final int withinRendererCapabilitiesScore;
  
  public DefaultTrackSelector$AudioTrackScore(Format paramFormat, DefaultTrackSelector.Parameters paramParameters, int paramInt) {}
  
  public int compareTo(@NonNull AudioTrackScore paramAudioTrackScore)
  {
    int i = this.withinRendererCapabilitiesScore;
    int j = paramAudioTrackScore.withinRendererCapabilitiesScore;
    if (i != j) {
      return DefaultTrackSelector.access$200(i, j);
    }
    i = this.matchLanguageScore;
    j = paramAudioTrackScore.matchLanguageScore;
    if (i != j) {
      return DefaultTrackSelector.access$200(i, j);
    }
    i = this.defaultSelectionFlagScore;
    j = paramAudioTrackScore.defaultSelectionFlagScore;
    if (i != j) {
      return DefaultTrackSelector.access$200(i, j);
    }
    if (this.parameters.forceLowestBitrate) {
      return DefaultTrackSelector.access$200(paramAudioTrackScore.bitrate, this.bitrate);
    }
    i = this.withinRendererCapabilitiesScore;
    j = 1;
    if (i != 1) {
      j = -1;
    }
    i = this.channelCount;
    int k = paramAudioTrackScore.channelCount;
    if (i != k) {
      i = DefaultTrackSelector.access$200(i, k);
    }
    for (;;)
    {
      return j * i;
      i = this.sampleRate;
      k = paramAudioTrackScore.sampleRate;
      if (i != k) {
        i = DefaultTrackSelector.access$200(i, k);
      } else {
        i = DefaultTrackSelector.access$200(this.bitrate, paramAudioTrackScore.bitrate);
      }
    }
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
      paramObject = (AudioTrackScore)paramObject;
      return (this.withinRendererCapabilitiesScore == paramObject.withinRendererCapabilitiesScore) && (this.matchLanguageScore == paramObject.matchLanguageScore) && (this.defaultSelectionFlagScore == paramObject.defaultSelectionFlagScore) && (this.channelCount == paramObject.channelCount) && (this.sampleRate == paramObject.sampleRate) && (this.bitrate == paramObject.bitrate);
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((((this.withinRendererCapabilitiesScore * 31 + this.matchLanguageScore) * 31 + this.defaultSelectionFlagScore) * 31 + this.channelCount) * 31 + this.sampleRate) * 31 + this.bitrate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore
 * JD-Core Version:    0.7.0.1
 */