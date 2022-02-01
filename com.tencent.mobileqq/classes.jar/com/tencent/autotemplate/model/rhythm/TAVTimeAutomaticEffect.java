package com.tencent.autotemplate.model.rhythm;

import android.support.annotation.NonNull;
import com.tencent.autotemplate.model.TAVEffectAutomaticEffect;
import com.tencent.autotemplate.model.TAVEffectParameter;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;

public class TAVTimeAutomaticEffect
  extends TAVEffectAutomaticEffect
{
  public TAVTimeAutomaticEffect(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public TAVMovieTimeEffect convertToMovieTimeEffect(float paramFloat)
  {
    TAVMovieTimeEffect localTAVMovieTimeEffect = new TAVMovieTimeEffect();
    if ((this.startOffset > -1L) && (this.endOffset == -1L))
    {
      l1 = this.startOffset;
      if (this.duration > 0L)
      {
        l2 = this.duration;
        break label178;
      }
      l2 = this.startOffset;
    }
    else
    {
      if ((this.startOffset == -1L) && (this.endOffset > -1L))
      {
        if (this.duration > 0L)
        {
          l1 = (paramFloat - (float)this.endOffset - (float)this.duration);
          l2 = this.duration;
          break label178;
        }
        l2 = (paramFloat - (float)this.endOffset);
        l1 = 0L;
        break label178;
      }
      l1 = this.startOffset;
      if (this.duration > 0L)
      {
        l2 = this.duration;
        break label178;
      }
      paramFloat -= (float)this.startOffset;
      l2 = this.endOffset;
    }
    long l2 = (paramFloat - (float)l2);
    label178:
    long l3 = l1;
    if (this.parameter != null)
    {
      l3 = l1;
      if (this.parameter.rhythmOffset > 0L) {
        l3 = l1 - this.parameter.rhythmOffset;
      }
    }
    long l1 = l3;
    if (l3 < 0L) {
      l1 = 0L;
    }
    CMTimeRange localCMTimeRange = new CMTimeRange(new CMTime(l1, 1000), new CMTime(l2, 1000));
    localTAVMovieTimeEffect.setSourceTimeRange(localCMTimeRange);
    localTAVMovieTimeEffect.setTimeRange(localCMTimeRange);
    localTAVMovieTimeEffect.setSpeed(getSpeed());
    return localTAVMovieTimeEffect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.model.rhythm.TAVTimeAutomaticEffect
 * JD-Core Version:    0.7.0.1
 */