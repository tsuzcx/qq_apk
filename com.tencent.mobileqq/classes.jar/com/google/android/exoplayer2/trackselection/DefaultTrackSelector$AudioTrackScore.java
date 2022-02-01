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
  
  public DefaultTrackSelector$AudioTrackScore(Format paramFormat, DefaultTrackSelector.Parameters paramParameters, int paramInt)
  {
    this.parameters = paramParameters;
    if (DefaultTrackSelector.isSupported(paramInt, false))
    {
      paramInt = 1;
      this.withinRendererCapabilitiesScore = paramInt;
      if (!DefaultTrackSelector.formatHasLanguage(paramFormat, paramParameters.preferredAudioLanguage)) {
        break label92;
      }
      paramInt = 1;
      label40:
      this.matchLanguageScore = paramInt;
      if ((paramFormat.selectionFlags & 0x1) == 0) {
        break label97;
      }
    }
    label92:
    label97:
    for (paramInt = i;; paramInt = 0)
    {
      this.defaultSelectionFlagScore = paramInt;
      this.channelCount = paramFormat.channelCount;
      this.sampleRate = paramFormat.sampleRate;
      this.bitrate = paramFormat.bitrate;
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label40;
    }
  }
  
  public int compareTo(@NonNull AudioTrackScore paramAudioTrackScore)
  {
    int i = 1;
    if (this.withinRendererCapabilitiesScore != paramAudioTrackScore.withinRendererCapabilitiesScore) {
      return DefaultTrackSelector.access$200(this.withinRendererCapabilitiesScore, paramAudioTrackScore.withinRendererCapabilitiesScore);
    }
    if (this.matchLanguageScore != paramAudioTrackScore.matchLanguageScore) {
      return DefaultTrackSelector.access$200(this.matchLanguageScore, paramAudioTrackScore.matchLanguageScore);
    }
    if (this.defaultSelectionFlagScore != paramAudioTrackScore.defaultSelectionFlagScore) {
      return DefaultTrackSelector.access$200(this.defaultSelectionFlagScore, paramAudioTrackScore.defaultSelectionFlagScore);
    }
    if (this.parameters.forceLowestBitrate) {
      return DefaultTrackSelector.access$200(paramAudioTrackScore.bitrate, this.bitrate);
    }
    if (this.withinRendererCapabilitiesScore == 1) {}
    while (this.channelCount != paramAudioTrackScore.channelCount)
    {
      return i * DefaultTrackSelector.access$200(this.channelCount, paramAudioTrackScore.channelCount);
      i = -1;
    }
    if (this.sampleRate != paramAudioTrackScore.sampleRate) {
      return i * DefaultTrackSelector.access$200(this.sampleRate, paramAudioTrackScore.sampleRate);
    }
    return i * DefaultTrackSelector.access$200(this.bitrate, paramAudioTrackScore.bitrate);
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
      paramObject = (AudioTrackScore)paramObject;
    } while ((this.withinRendererCapabilitiesScore == paramObject.withinRendererCapabilitiesScore) && (this.matchLanguageScore == paramObject.matchLanguageScore) && (this.defaultSelectionFlagScore == paramObject.defaultSelectionFlagScore) && (this.channelCount == paramObject.channelCount) && (this.sampleRate == paramObject.sampleRate) && (this.bitrate == paramObject.bitrate));
    return false;
  }
  
  public int hashCode()
  {
    return ((((this.withinRendererCapabilitiesScore * 31 + this.matchLanguageScore) * 31 + this.defaultSelectionFlagScore) * 31 + this.channelCount) * 31 + this.sampleRate) * 31 + this.bitrate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.DefaultTrackSelector.AudioTrackScore
 * JD-Core Version:    0.7.0.1
 */