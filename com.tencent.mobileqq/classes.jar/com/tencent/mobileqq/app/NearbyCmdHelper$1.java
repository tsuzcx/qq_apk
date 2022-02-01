package com.tencent.mobileqq.app;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;

final class NearbyCmdHelper$1
  extends LbsManagerServiceOnLocationChangeListener
{
  NearbyCmdHelper$1(String paramString, ToServiceMsg paramToServiceMsg)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo arg2)
  {
    synchronized (this.a)
    {
      this.a.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyCmdHelper.1
 * JD-Core Version:    0.7.0.1
 */