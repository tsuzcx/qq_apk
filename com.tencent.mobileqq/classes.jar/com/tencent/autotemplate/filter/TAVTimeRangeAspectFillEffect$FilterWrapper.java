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
    if (TAVTimeRangeAspectFillEffect.access$300(this.this$0) != null)
    {
      if (paramCMTime == null) {
        return;
      }
      long l1 = TAVTimeRangeAspectFillEffect.access$300(this.this$0).getStartUs();
      long l2 = 100000;
      if ((l1 - l2 > paramCMTime.getTimeUs()) || (TAVTimeRangeAspectFillEffect.access$300(this.this$0).getEndUs() + l2 < paramCMTime.getTimeUs())) {
        release();
      }
    }
  }
  
  public void release()
  {
    if (this.filter != null)
    {
      String str = TAVTimeRangeAspectFillEffect.access$200(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("release() called，filter = ");
      localStringBuilder.append(this.filter);
      Logger.d(str, localStringBuilder.toString());
      this.filter.release();
      this.filter = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.filter.TAVTimeRangeAspectFillEffect.FilterWrapper
 * JD-Core Version:    0.7.0.1
 */