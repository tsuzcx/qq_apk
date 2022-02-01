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
    long l4 = 0L;
    TAVMovieTimeEffect localTAVMovieTimeEffect = new TAVMovieTimeEffect();
    long l1;
    long l3;
    if ((this.startOffset > -1L) && (this.endOffset == -1L))
    {
      l2 = this.startOffset;
      if (this.duration > 0L)
      {
        l1 = this.duration;
        l3 = l2;
        if (this.parameter != null)
        {
          l3 = l2;
          if (this.parameter.rhythmOffset > 0L) {
            l3 = l2 - this.parameter.rhythmOffset;
          }
        }
        if (l3 >= 0L) {
          break label285;
        }
      }
    }
    label285:
    for (long l2 = l4;; l2 = l3)
    {
      CMTimeRange localCMTimeRange = new CMTimeRange(new CMTime(l2, 1000), new CMTime(l1, 1000));
      localTAVMovieTimeEffect.setSourceTimeRange(localCMTimeRange);
      localTAVMovieTimeEffect.setTimeRange(localCMTimeRange);
      localTAVMovieTimeEffect.setSpeed(getSpeed());
      return localTAVMovieTimeEffect;
      l1 = (paramFloat - (float)this.startOffset);
      break;
      if ((this.startOffset == -1L) && (this.endOffset > -1L))
      {
        if (this.duration > 0L)
        {
          l2 = (paramFloat - (float)this.endOffset - (float)this.duration);
          l1 = this.duration;
          break;
        }
        l1 = (paramFloat - (float)this.endOffset);
        l2 = 0L;
        break;
      }
      l2 = this.startOffset;
      if (this.duration > 0L)
      {
        l1 = this.duration;
        break;
      }
      l1 = (paramFloat - (float)this.startOffset - (float)this.endOffset);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.model.rhythm.TAVTimeAutomaticEffect
 * JD-Core Version:    0.7.0.1
 */