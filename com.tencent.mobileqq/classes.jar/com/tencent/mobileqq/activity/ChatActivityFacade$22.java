package com.tencent.mobileqq.activity;

import arxo;
import awbi;
import axvo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public final class ChatActivityFacade$22
  implements Runnable
{
  public ChatActivityFacade$22(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, long paramLong) {}
  
  public void run()
  {
    try
    {
      MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
      if ((localMessageRecord != null) && (localMessageRecord.isSendFromLocal())) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, localMessageRecord.uniseq));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
      localMessageRecord = awbi.a(localMessageRecord);
      if ((localMessageRecord != null) && (localMessageRecord.msgtype == -1051))
      {
        arxo localarxo = (arxo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(166);
        localMessageRecord.extStr = null;
        localarxo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, null, true);
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