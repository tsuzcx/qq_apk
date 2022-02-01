package com.tencent.mobileqq.app;

import com.tencent.mobileqq.onlinestatus.OnBatteryChangeObserver;
import com.tencent.mobileqq.onlinestatus.OnLineStatusPresenter;
import com.tencent.qphone.base.util.QLog;

class FrameHelperActivity$15
  extends OnBatteryChangeObserver
{
  FrameHelperActivity$15(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onBatteryChanged updateOnlineStatusItem");
    }
    if (FrameHelperActivity.a(this.a) != null) {
      FrameHelperActivity.a(this.a).a(paramInt);
    }
    this.a.a("OnBatteryChangeObserver");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.15
 * JD-Core Version:    0.7.0.1
 */