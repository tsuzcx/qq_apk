package com.tencent.mobileqq.activity.richmedia.view;

import android.os.Handler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class LbsFilterStatusManager$3
  implements INetInfoHandler
{
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    long l = Thread.currentThread().getId();
    if (LbsFilterStatusManager.a(this.a) == l)
    {
      LbsFilterStatusManager.b(this.a);
      return;
    }
    if (LbsFilterStatusManager.c(this.a) != null) {
      LbsFilterStatusManager.c(this.a).post(new LbsFilterStatusManager.3.1(this));
    }
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.3
 * JD-Core Version:    0.7.0.1
 */