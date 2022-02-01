package com.tencent.mobileqq.activity.activateFriend;

import android.os.Bundle;
import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderSwitchObserver.QQReminderSwitchListener;
import eipc.EIPCResult;

class QQNotifyIPCModule$1
  implements QQReminderSwitchObserver.QQReminderSwitchListener
{
  QQNotifyIPCModule$1(QQNotifyIPCModule paramQQNotifyIPCModule, int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("allowed", paramBoolean);
    this.b.callbackResult(this.a, EIPCResult.createResult(0, localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifyIPCModule.1
 * JD-Core Version:    0.7.0.1
 */