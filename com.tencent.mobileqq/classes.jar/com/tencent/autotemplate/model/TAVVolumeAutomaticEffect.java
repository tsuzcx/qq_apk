package com.tencent.autotemplate.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration.VolumeEdge;

public class TAVVolumeAutomaticEffect
{
  public static final String TAG = "TAVVolumeAutomaticEffect";
  @SerializedName("duration")
  private float duration;
  @SerializedName("endOffset")
  private float endOffset = -1.0F;
  @SerializedName("startOffset")
  private float startOffset = -1.0F;
  @SerializedName("volumeRange")
  private TAVVolumeRange volumeRange;
  
  public TAVAudioConfiguration.VolumeEdge convertToAudioVolumeEdge(float paramFloat)
  {
    TAVAudioConfiguration.VolumeEdge localVolumeEdge = null;
    float f = this.duration;
    if ((this.startOffset > -1.0F) && (this.endOffset == -1.0F)) {
      paramFloat = this.startOffset;
    }
    for (;;)
    {
      if (f > 0.0F) {
        localVolumeEdge = new TAVAudioConfiguration.VolumeEdge(new CMTimeRange(new CMTime(paramFloat / 1000.0F), new CMTime(f / 1000.0F)), getStartVolume(), getEndVolume());
      }
      return localVolumeEdge;
      if ((this.startOffset == -1.0F) && (this.endOffset > -1.0F))
      {
        paramFloat -= f;
      }
      else
      {
        if ((this.startOffset <= -1.0F) || (this.endOffset <= -1.0F)) {
          break;
        }
        f = paramFloat - this.startOffset - this.endOffset;
        paramFloat = this.startOffset;
      }
    }
    Logger.e("TAVVolumeAutomaticEffect", "effect's startOffset and endOffset is wrong.");
    return null;
  }
  
  public float getDuration()
  {
    return this.duration;
  }
  
  public float getEndOffset()
  {
    return this.endOffset;
  }
  
  public float getEndVolume()
  {
    if (this.volumeRange != null) {
      return this.volumeRange.end;
    }
    return 0.0F;
  }
  
  public float getStartOffset()
  {
    return this.startOffset;
  }
  
  public float getStartVolume()
  {
    if (this.volumeRange != null) {
      return this.volumeRange.start;
    }
    return 0.0F;
  }
  
  public void setDuration(float paramFloat)
  {
    this.duration = paramFloat;
  }
  
  public void setEndOffset(float paramFloat)
  {
    this.endOffset = paramFloat;
  }
  
  public void setEndVolume(float paramFloat)
  {
    if (this.volumeRange == null) {
      this.volumeRange = new TAVVolumeRange();
    }
    this.volumeRange.end = paramFloat;
  }
  
  public void setStartOffset(float paramFloat)
  {
    this.startOffset = paramFloat;
  }
  
  public void setStartVolume(float paramFloat)
  {
    if (this.volumeRange == null) {
      this.volumeRange = new TAVVolumeRange();
    }
    this.volumeRange.start = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.model.TAVVolumeAutomaticEffect
 * JD-Core Version:    0.7.0.1
 */