package com.huawei.hms.api;

public final class HuaweiServicesNotAvailableException
  extends Exception
{
  public final int errorCode;
  
  public HuaweiServicesNotAvailableException(int paramInt)
  {
    this.errorCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiServicesNotAvailableException
 * JD-Core Version:    0.7.0.1
 */