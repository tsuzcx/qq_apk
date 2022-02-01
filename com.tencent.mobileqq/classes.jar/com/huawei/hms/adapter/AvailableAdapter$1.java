package com.huawei.hms.adapter;

import android.content.Intent;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.support.log.HMSLog;
import java.util.concurrent.atomic.AtomicBoolean;

class AvailableAdapter$1
  implements SystemObserver
{
  AvailableAdapter$1(AvailableAdapter paramAvailableAdapter) {}
  
  public boolean onSolutionResult(Intent paramIntent, String paramString)
  {
    return false;
  }
  
  public boolean onUpdateResult(int paramInt)
  {
    AvailableAdapter.AvailableCallBack localAvailableCallBack = AvailableAdapter.a(this.a);
    if (localAvailableCallBack == null)
    {
      HMSLog.e("AvailableAdapter", "onUpdateResult baseCallBack null");
      return true;
    }
    localAvailableCallBack.onComplete(paramInt);
    AvailableAdapter.a(paramInt);
    HMSLog.i("AvailableAdapter", "user response " + AvailableAdapter.a());
    AvailableAdapter.b().set(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.adapter.AvailableAdapter.1
 * JD-Core Version:    0.7.0.1
 */