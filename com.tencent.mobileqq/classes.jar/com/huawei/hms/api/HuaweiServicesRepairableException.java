package com.huawei.hms.api;

import android.content.Intent;

public class HuaweiServicesRepairableException
  extends UserRecoverableException
{
  private final int b;
  
  public HuaweiServicesRepairableException(int paramInt, String paramString, Intent paramIntent)
  {
    super(paramString, paramIntent);
    this.b = paramInt;
  }
  
  public int getConnectionStatusCode()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiServicesRepairableException
 * JD-Core Version:    0.7.0.1
 */