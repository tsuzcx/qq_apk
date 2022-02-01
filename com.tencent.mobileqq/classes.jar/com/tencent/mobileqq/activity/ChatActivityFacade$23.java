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
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSendFromLocal()) {
        ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq));
      }
      Object localObject = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgData);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
      if ((localObject instanceof StructMsgForImageShare))
      {
        StructMsgForImageShare.resendAndUploadImageShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, (StructMsgForImageShare)localObject);
        return;
      }
      if (((localObject instanceof AbsShareMsg)) && (ForwardUtils.a(((AbsShareMsg)localObject).forwardType, ((AbsStructMsg)localObject).mMsgServiceID)))
      {
        AbsShareMsg.resendSdkShareMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, (AbsShareMsg)localObject);
        return;
      }
      localObject = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)localObject, null, true);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("ChatActivityFacade", 1, "resendStructMessage error :", localRuntimeException);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.23
 * JD-Core Version:    0.7.0.1
 */