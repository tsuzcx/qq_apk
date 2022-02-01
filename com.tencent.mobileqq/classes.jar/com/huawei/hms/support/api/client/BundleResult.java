package com.huawei.hms.support.api.client;

import android.os.Bundle;

public class BundleResult
{
  private int a;
  private Bundle b;
  
  public BundleResult(int paramInt, Bundle paramBundle)
  {
    this.a = paramInt;
    this.b = paramBundle;
  }
  
  public int getResultCode()
  {
    return this.a;
  }
  
  public Bundle getRspBody()
  {
    return this.b;
  }
  
  public void setResultCode(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setRspBody(Bundle paramBundle)
  {
    this.b = paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.client.BundleResult
 * JD-Core Version:    0.7.0.1
 */