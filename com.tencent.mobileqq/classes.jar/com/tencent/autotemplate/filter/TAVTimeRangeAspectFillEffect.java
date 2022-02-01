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
  private final String TAG;
  private CMTimeRange timeRange;
  
  public TAVTimeRangeAspectFillEffect(CGSize paramCGSize)
  {
    super(paramCGSize);
    paramCGSize = new StringBuilder();
    paramCGSize.append("TAVTimeRangeAspectFillE@");
    paramCGSize.append(Integer.toHexString(hashCode()));
    this.TAG = paramCGSize.toString();
  }
  
  private TAVVideoEffect.Filter createSuperFilter()
  {
    TAVVideoEffect.Filter localFilter = super.createFilter();
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createSuperFilter() called filter = ");
    localStringBuilder.append(localFilter);
    Logger.d(str, localStringBuilder.toString());
    return localFilter;
  }
  
  public void attachTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
    if (paramCMTimeRange != null)
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("attachTimeRange() called with: timeRange = [");
      localStringBuilder.append(paramCMTimeRange.toSimpleString());
      localStringBuilder.append("]");
      Logger.d(str, localStringBuilder.toString());
    }
  }
  
  public TAVTimeRangeAspectFillEffect.FilterWrapper createFilter()
  {
    return new TAVTimeRangeAspectFillEffect.FilterWrapper(this, null);
  }
  
  @NonNull
  public String effectId()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVTimeRangeAspectFillEffect");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.filter.TAVTimeRangeAspectFillEffect
 * JD-Core Version:    0.7.0.1
 */