package com.tencent.mobileqq.activity;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;

final class ChatActivityFacade$23
  implements Runnable
{
  ChatActivityFacade$23(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong) {}
  
  public void run()
  {
    try
    {
      if (this.a.isSendFromLocal()) {
        ((ITransFileController)this.b.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(this.a.frienduin, this.a.uniseq));
      }
      Object localObject = StructMsgFactory.a(this.a.msgData);
      this.b.getMessageFacade().h(this.c, this.d, this.e);
      if ((localObject instanceof StructMsgForImageShare))
      {
        StructMsgForImageShare.resendAndUploadImageShare(this.b, this.a, (StructMsgForImageShare)localObject);
        return;
      }
      if (((localObject instanceof AbsShareMsg)) && (ForwardUtils.a(((AbsShareMsg)localObject).forwardType, ((AbsStructMsg)localObject).mMsgServiceID)))
      {
        AbsShareMsg.resendSdkShareMessage(this.b, this.a, (AbsShareMsg)localObject);
        return;
      }
      localObject = MessageRecordFactory.a(this.a);
      this.b.getMessageFacade().a((MessageRecord)localObject, null, true);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("ChatActivityFacade", 1, "resendStructMessage error :", localRuntimeException);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.23
 * JD-Core Version:    0.7.0.1
 */