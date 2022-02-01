package com.tencent.mobileqq.apollo.utils;

import anwz;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForApollo;

final class ApolloUtil$1
  implements Runnable
{
  ApolloUtil$1(MessageForApollo paramMessageForApollo, QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.hasPlayed = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.mApolloMessage.isPlayed = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.msgData = anwz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.mApolloMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForApollo.msgData);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloUtil.1
 * JD-Core Version:    0.7.0.1
 */