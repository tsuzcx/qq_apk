package com.huawei.hms.api;

import android.content.Intent;

public class HuaweiServicesRepairableException
  extends UserRecoverableException
{
  private final int a;
  
  public HuaweiServicesRepairableException(int paramInt, String paramString, Intent paramIntent)
  {
    super(paramString, paramIntent);
    this.a = paramInt;
  }
  
  public int getConnectionStatusCode()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.api.HuaweiServicesRepairableException
 * JD-Core Version:    0.7.0.1
 */