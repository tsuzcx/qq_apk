package com.huawei.hms.activity;

import com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack;
import com.huawei.hms.support.log.HMSLog;

class a$a
  implements AvailableAdapter.AvailableCallBack
{
  private a$a(a parama) {}
  
  public void onComplete(int paramInt)
  {
    if (paramInt == 0)
    {
      a.a(this.a);
      return;
    }
    HMSLog.i("ForegroundBusDelegate", "version check failed");
    a.a(this.a, 0, "apk version is invalid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.activity.a.a
 * JD-Core Version:    0.7.0.1
 */