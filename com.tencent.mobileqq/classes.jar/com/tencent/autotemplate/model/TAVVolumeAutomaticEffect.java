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
    float f1 = this.duration;
    float f2 = this.startOffset;
    if ((f2 > -1.0F) && (this.endOffset == -1.0F))
    {
      paramFloat = f2;
    }
    else if ((this.startOffset == -1.0F) && (this.endOffset > -1.0F))
    {
      paramFloat -= f1;
    }
    else
    {
      f1 = this.startOffset;
      if (f1 <= -1.0F) {
        break label146;
      }
      f2 = this.endOffset;
      if (f2 <= -1.0F) {
        break label146;
      }
      f2 = paramFloat - f1 - f2;
      paramFloat = f1;
      f1 = f2;
    }
    if (f1 > 0.0F) {
      return new TAVAudioConfiguration.VolumeEdge(new CMTimeRange(new CMTime(paramFloat / 1000.0F), new CMTime(f1 / 1000.0F)), getStartVolume(), getEndVolume());
    }
    return null;
    label146:
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
    TAVVolumeRange localTAVVolumeRange = this.volumeRange;
    if (localTAVVolumeRange != null) {
      return localTAVVolumeRange.end;
    }
    return 0.0F;
  }
  
  public float getStartOffset()
  {
    return this.startOffset;
  }
  
  public float getStartVolume()
  {
    TAVVolumeRange localTAVVolumeRange = this.volumeRange;
    if (localTAVVolumeRange != null) {
      return localTAVVolumeRange.start;
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