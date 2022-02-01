package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

class Conversation$62
  extends AccountObserver
{
  Conversation$62(Conversation paramConversation) {}
  
  protected void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, long paramLong1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4)
  {
    if (this.a.Y != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, String.format("onOnlineStatusChanged, currentStatus = %s", new Object[] { paramStatus }));
      }
      this.a.Y.b("AccountObserver.onOnlineStatusChanged");
      paramStatus = this.a;
      paramStatus.a(8, paramStatus.aF.getCurrentUin(), 0);
    }
  }
  
  protected void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, String.format("onOnlineStatusPush, currentStatus = %s , extOnlineStatus = %d", new Object[] { paramStatus, Long.valueOf(paramLong) }));
    }
    this.a.Y.b("AccountObserver.onOnlineStatusPush");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.62
 * JD-Core Version:    0.7.0.1
 */