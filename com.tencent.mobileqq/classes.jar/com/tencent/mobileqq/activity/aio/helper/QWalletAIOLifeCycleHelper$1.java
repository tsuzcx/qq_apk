package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class QWalletAIOLifeCycleHelper$1
  extends MessageObserver
{
  QWalletAIOLifeCycleHelper$1(QWalletAIOLifeCycleHelper paramQWalletAIOLifeCycleHelper) {}
  
  public void onNotifyUpdateSelfMsgSeqAndTime(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mr == null:");
      boolean bool;
      if (paramMessageRecord == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("addQQWalletTips  onNotifyUpdateSelfMsgSeqAndTime", 2, localStringBuilder.toString());
    }
    if (paramMessageRecord == null) {
      return;
    }
    if (((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000)) && (paramMessageRecord.msgtype == -1000)) {
      this.a.a(paramMessageRecord);
    }
  }
  
  public void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isSuccess:");
      paramString.append(paramBoolean);
      QLog.d("addQQWalletTips  onSendResult", 2, paramString.toString());
    }
    if (paramBoolean)
    {
      paramString = QWalletAIOLifeCycleHelper.b(this.a).getMessageProxy(QWalletAIOLifeCycleHelper.a(this.a).a).c(QWalletAIOLifeCycleHelper.a(this.a).b, QWalletAIOLifeCycleHelper.a(this.a).a, paramLong);
      if (paramString == null) {
        return;
      }
      if ((paramString.istroop == 0) && (paramString.msgtype == -1000)) {
        this.a.a(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper.1
 * JD-Core Version:    0.7.0.1
 */