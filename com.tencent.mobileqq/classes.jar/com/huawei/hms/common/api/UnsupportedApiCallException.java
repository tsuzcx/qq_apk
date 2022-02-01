package com.huawei.hms.common.api;

import com.huawei.hms.common.Feature;

@Deprecated
public final class UnsupportedApiCallException
  extends UnsupportedOperationException
{
  private final Feature feature;
  
  public UnsupportedApiCallException(Feature paramFeature)
  {
    this.feature = paramFeature;
  }
  
  public final String getMessage()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.feature);
    localStringBuilder.append(" is unsupported");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.api.UnsupportedApiCallException
 * JD-Core Version:    0.7.0.1
 */