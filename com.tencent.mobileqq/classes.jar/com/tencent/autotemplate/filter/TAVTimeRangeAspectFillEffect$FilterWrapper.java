package com.tencent.autotemplate.filter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVAttachTimeRangeSourceEffect.TimeAttachFilter;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;

class TAVTimeRangeAspectFillEffect$FilterWrapper
  implements TAVAttachTimeRangeSourceEffect.TimeAttachFilter, TAVVideoEffect.Filter
{
  @Nullable
  private TAVVideoEffect.Filter filter;
  
  private TAVTimeRangeAspectFillEffect$FilterWrapper(TAVTimeRangeAspectFillEffect paramTAVTimeRangeAspectFillEffect) {}
  
  @NonNull
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    if (this.filter == null) {
      this.filter = TAVTimeRangeAspectFillEffect.access$100(this.this$0);
    }
    return this.filter.apply(paramTAVVideoEffect, paramCIImage, paramRenderInfo);
  }
  
  public void attachPositionTime(CMTime paramCMTime)
  {
    if ((TAVTimeRangeAspectFillEffect.access$300(this.this$0) == null) || (paramCMTime == null)) {}
    long l;
    do
    {
      return;
      if (TAVTimeRangeAspectFillEffect.access$300(this.this$0).getStartUs() - 100000 > paramCMTime.getTimeUs()) {
        break;
      }
      l = TAVTimeRangeAspectFillEffect.access$300(this.this$0).getEndUs();
    } while (100000 + l >= paramCMTime.getTimeUs());
    release();
  }
  
  public void release()
  {
    if (this.filter != null)
    {
      Logger.d(TAVTimeRangeAspectFillEffect.access$200(this.this$0), "release() called，filter = " + this.filter);
      this.filter.release();
      this.filter = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.filter.TAVTimeRangeAspectFillEffect.FilterWrapper
 * JD-Core Version:    0.7.0.1
 */