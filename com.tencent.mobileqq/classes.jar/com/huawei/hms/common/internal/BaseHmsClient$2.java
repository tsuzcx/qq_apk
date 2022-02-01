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
      BaseHmsClient.access$700(this.this$0);
      return;
    }
    BaseHmsClient.access$300(this.this$0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.internal.BaseHmsClient.2
 * JD-Core Version:    0.7.0.1
 */