package com.huawei.updatesdk.service.otaupdate;

import android.content.Intent;

public class d
{
  private static final Object a = new Object();
  private static d b = null;
  private CheckUpdateCallBack c;
  
  public static d a()
  {
    synchronized (a)
    {
      if (b == null) {
        b = new d();
      }
      d locald = b;
      return locald;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.c != null) {
      this.c.onMarketStoreError(paramInt);
    }
  }
  
  public void a(Intent paramIntent)
  {
    if (this.c != null) {
      this.c.onMarketInstallInfo(paramIntent);
    }
  }
  
  public void a(CheckUpdateCallBack paramCheckUpdateCallBack)
  {
    this.c = paramCheckUpdateCallBack;
  }
  
  public void b(Intent paramIntent)
  {
    if (this.c != null) {
      this.c.onUpdateInfo(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.d
 * JD-Core Version:    0.7.0.1
 */