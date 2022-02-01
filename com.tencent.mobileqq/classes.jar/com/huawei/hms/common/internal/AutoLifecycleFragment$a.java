package com.huawei.hms.common.internal;

import com.huawei.hms.api.HuaweiApiClient;

class AutoLifecycleFragment$a
{
  public final HuaweiApiClient a;
  public final int b;
  
  public AutoLifecycleFragment$a(AutoLifecycleFragment paramAutoLifecycleFragment, int paramInt, HuaweiApiClient paramHuaweiApiClient)
  {
    this.a = paramHuaweiApiClient;
    this.b = paramInt;
  }
  
  public void a()
  {
    this.a.disconnect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.common.internal.AutoLifecycleFragment.a
 * JD-Core Version:    0.7.0.1
 */