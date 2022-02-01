package com.huawei.hms.common.internal;

import com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack;

class BaseHmsClient$2
  implements AvailableAdapter.AvailableCallBack
{
  BaseHmsClient$2(BaseHmsClient paramBaseHmsClient) {}
  
  public void onComplete(int paramInt)
  {
    if (paramInt == 0)
    {
      BaseHmsClient.d(this.a);
      return;
    }
    BaseHmsClient.b(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.common.internal.BaseHmsClient.2
 * JD-Core Version:    0.7.0.1
 */