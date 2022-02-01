package com.huawei.hms.common.api;

import com.huawei.hms.common.Feature;

@Deprecated
public final class UnsupportedApiCallException
  extends UnsupportedOperationException
{
  private final Feature a;
  
  public UnsupportedApiCallException(Feature paramFeature)
  {
    this.a = paramFeature;
  }
  
  public final String getMessage()
  {
    return this.a + " is unsupported";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.api.UnsupportedApiCallException
 * JD-Core Version:    0.7.0.1
 */