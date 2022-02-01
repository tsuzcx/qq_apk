package com.tencent.mobileqq.activity.activateFriend;

import android.os.Bundle;
import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderSwitchObserver.QQReminderSwitchListener;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;

public class QQReminderAMSHelper$IPCListenerWrapper
  implements QQReminderSwitchObserver.QQReminderSwitchListener, EIPCResultCallback
{
  private WeakReference<QQReminderSwitchObserver.QQReminderSwitchListener> a;
  
  QQReminderAMSHelper$IPCListenerWrapper(WeakReference<QQReminderSwitchObserver.QQReminderSwitchListener> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void a(boolean paramBoolean)
  {
    QQReminderSwitchObserver.QQReminderSwitchListener localQQReminderSwitchListener = (QQReminderSwitchObserver.QQReminderSwitchListener)this.a.get();
    if (localQQReminderSwitchListener != null) {
      localQQReminderSwitchListener.a(paramBoolean);
    }
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.code == 0)) {
      paramEIPCResult = paramEIPCResult.data;
    } else {
      paramEIPCResult = null;
    }
    boolean bool = false;
    if (paramEIPCResult != null) {
      bool = paramEIPCResult.getBoolean("allowed");
    }
    a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQReminderAMSHelper.IPCListenerWrapper
 * JD-Core Version:    0.7.0.1
 */