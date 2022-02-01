package com.tencent.mobileqq.app.automator.step;

import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

class RegisterPush$MyAccountObserver
  extends AccountObserver
{
  private RegisterPush$MyAccountObserver(RegisterPush paramRegisterPush) {}
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onOnlineStatusChanged isSuccess=" + paramBoolean1 + ",curStatus=" + paramStatus.toString() + ",isFriendListChang=" + paramBoolean3 + ",timeStamp=" + paramLong + ",isGatherListChange=" + paramBoolean4);
    }
    if (paramBoolean1)
    {
      this.a.a(7);
      return;
    }
    this.a.a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterPush.MyAccountObserver
 * JD-Core Version:    0.7.0.1
 */