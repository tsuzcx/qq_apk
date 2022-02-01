package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

final class MessageSvcPbGetGroupMsg$1
  implements Runnable
{
  MessageSvcPbGetGroupMsg$1(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive,cost:");
      localStringBuilder.append(System.currentTimeMillis() - BaseMessageManagerForTroopAndDisc.a);
      QLog.d("Q.msg.MessageHandler.trooptroop_pull_msg", 2, localStringBuilder.toString());
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg, this.jdField_a_of_type_JavaLangObject, false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgResp_PB exception ! ", localException);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.l(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.MessageSvcPbGetGroupMsg.1
 * JD-Core Version:    0.7.0.1
 */