package com.huawei.hms.common;

import com.huawei.hms.support.api.client.Status;

public class ApiException
  extends Exception
{
  protected final Status mStatus;
  
  public ApiException(Status paramStatus) {}
  
  public int getStatusCode()
  {
    return this.mStatus.getStatusCode();
  }
  
  @Deprecated
  public String getStatusMessage()
  {
    return this.mStatus.getStatusMessage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.ApiException
 * JD-Core Version:    0.7.0.1
 */