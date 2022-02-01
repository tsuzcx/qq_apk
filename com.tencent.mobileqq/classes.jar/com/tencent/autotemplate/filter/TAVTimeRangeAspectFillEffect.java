package com.tencent.autotemplate.filter;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.video.TAVAttachTimeRangeSourceEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;

public class TAVTimeRangeAspectFillEffect
  extends TAVAspectFillEffect
  implements TAVAttachTimeRangeSourceEffect
{
  private final String TAG = "TAVTimeRangeAspectFillE@" + Integer.toHexString(hashCode());
  private CMTimeRange timeRange;
  
  public TAVTimeRangeAspectFillEffect(CGSize paramCGSize)
  {
    super(paramCGSize);
  }
  
  private TAVVideoEffect.Filter createSuperFilter()
  {
    TAVVideoEffect.Filter localFilter = super.createFilter();
    Logger.d(this.TAG, "createSuperFilter() called filter = " + localFilter);
    return localFilter;
  }
  
  public void attachTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
    if (paramCMTimeRange != null) {
      Logger.d(this.TAG, "attachTimeRange() called with: timeRange = [" + paramCMTimeRange.toSimpleString() + "]");
    }
  }
  
  public TAVTimeRangeAspectFillEffect.FilterWrapper createFilter()
  {
    return new TAVTimeRangeAspectFillEffect.FilterWrapper(this, null);
  }
  
  @NonNull
  public String effectId()
  {
    return "TAVTimeRangeAspectFillEffect" + Integer.toHexString(hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.filter.TAVTimeRangeAspectFillEffect
 * JD-Core Version:    0.7.0.1
 */