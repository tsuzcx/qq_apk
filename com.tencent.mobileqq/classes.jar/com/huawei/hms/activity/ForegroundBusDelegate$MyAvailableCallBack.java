package com.huawei.hms.activity;

import com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack;
import com.huawei.hms.support.log.HMSLog;

class ForegroundBusDelegate$MyAvailableCallBack
  implements AvailableAdapter.AvailableCallBack
{
  private ForegroundBusDelegate$MyAvailableCallBack(ForegroundBusDelegate paramForegroundBusDelegate) {}
  
  public void onComplete(int paramInt)
  {
    if (paramInt == 0)
    {
      ForegroundBusDelegate.access$100(this.this$0);
      return;
    }
    HMSLog.i("ForegroundBusDelegate", "version check failed");
    ForegroundBusDelegate.access$200(this.this$0, 0, "apk version is invalid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.activity.ForegroundBusDelegate.MyAvailableCallBack
 * JD-Core Version:    0.7.0.1
 */