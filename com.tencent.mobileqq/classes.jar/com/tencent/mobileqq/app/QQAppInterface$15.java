package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QQAppInterface$15
  extends Handler
{
  QQAppInterface$15(QQAppInterface paramQQAppInterface, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = (QQAppInterface)((WeakReference)paramMessage.obj).get();
      if (paramMessage != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQAppInterface", 2, "getOnlineFriend app is null");
    return;
    long l1 = QQAppInterface.sNextGetOnlineFriendDelay;
    long l3 = SystemClock.uptimeMillis();
    long l2 = Math.abs(l3 - this.this$0.sLastGetOnlineFriendTime);
    if ((!"0".equals(paramMessage.getCurrentAccountUin())) && (l2 >= QQAppInterface.sNextGetOnlineFriendDelay))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, "getOnlineFriend");
      }
      this.this$0.sLastGetOnlineFriendTime = l3;
      FriendListHandler localFriendListHandler = (FriendListHandler)paramMessage.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (localFriendListHandler != null) {
        localFriendListHandler.getOnlineFriend(paramMessage.getCurrentAccountUin(), (byte)0);
      }
    }
    if (l2 < QQAppInterface.sNextGetOnlineFriendDelay) {
      l1 = QQAppInterface.sNextGetOnlineFriendDelay - l2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, "getOnlineFriend send next msg " + l1);
    }
    paramMessage = this.this$0.sGetOnlineFriendHandler.obtainMessage(0, new WeakReference(paramMessage));
    this.this$0.sGetOnlineFriendHandler.sendMessageDelayed(paramMessage, l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.15
 * JD-Core Version:    0.7.0.1
 */