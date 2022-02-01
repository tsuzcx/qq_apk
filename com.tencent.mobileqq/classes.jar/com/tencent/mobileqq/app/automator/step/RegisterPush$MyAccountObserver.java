package com.tencent.mobileqq.app.automator.step;

import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

class RegisterPush$MyAccountObserver
  extends AccountObserver
{
  private RegisterPush$MyAccountObserver(RegisterPush paramRegisterPush) {}
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, long paramLong1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onOnlineStatusChanged isSuccess=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",curStatus=");
      localStringBuilder.append(paramStatus.toString());
      localStringBuilder.append(",isFriendListChang=");
      localStringBuilder.append(paramBoolean3);
      localStringBuilder.append(",timeStamp=");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(",isGatherListChange=");
      localStringBuilder.append(paramBoolean4);
      QLog.d("QQInitHandler", 2, localStringBuilder.toString());
    }
    if (paramBoolean1)
    {
      this.a.setResult(7);
      return;
    }
    this.a.setResult(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterPush.MyAccountObserver
 * JD-Core Version:    0.7.0.1
 */