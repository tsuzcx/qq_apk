package com.tencent.aelight.camera.aioeditor.activity.richmedia.view;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class LbsFilterStatusManager$3
  implements INetInfoHandler
{
  LbsFilterStatusManager$3(LbsFilterStatusManager paramLbsFilterStatusManager) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    Thread.currentThread().getId();
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      LbsFilterStatusManager.a(this.a);
      return;
    }
    if (LbsFilterStatusManager.a(this.a) != null) {
      LbsFilterStatusManager.a(this.a).post(new LbsFilterStatusManager.3.1(this));
    }
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString) {}
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.view.LbsFilterStatusManager.3
 * JD-Core Version:    0.7.0.1
 */