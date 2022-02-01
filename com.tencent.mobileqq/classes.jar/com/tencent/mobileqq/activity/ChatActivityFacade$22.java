package com.tencent.mobileqq.activity;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;

final class ChatActivityFacade$22
  implements Runnable
{
  ChatActivityFacade$22(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, long paramLong) {}
  
  public void run()
  {
    try
    {
      MessageRecord localMessageRecord = this.a.getMessageFacade().a(this.b.b, this.b.a, this.c);
      if ((localMessageRecord != null) && (localMessageRecord.isSendFromLocal())) {
        ((ITransFileController)this.a.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(localMessageRecord.frienduin, localMessageRecord.uniseq));
      }
      this.a.getMessageFacade().h(this.b.b, this.b.a, this.c);
      localMessageRecord = MessageRecordFactory.a(localMessageRecord);
      this.a.getMessageFacade().a(localMessageRecord, null, true);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("ChatActivityFacade", 1, "resendTextMessage error :", localRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.22
 * JD-Core Version:    0.7.0.1
 */