package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

class Conversation$60
  extends AccountObserver
{
  Conversation$60(Conversation paramConversation) {}
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    if (this.a.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, String.format("onOnlineStatusChanged, currentStatus = %s", new Object[] { paramStatus }));
      }
      this.a.a.a("AccountObserver.onOnlineStatusChanged");
    }
  }
  
  public void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, String.format("onOnlineStatusPush, currentStatus = %s , extOnlineStatus = %d", new Object[] { paramStatus, Long.valueOf(paramLong) }));
    }
    this.a.a.a("AccountObserver.onOnlineStatusPush");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.60
 * JD-Core Version:    0.7.0.1
 */