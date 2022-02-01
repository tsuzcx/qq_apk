package com.tencent.mobileqq.apollo.api.uitls.impl;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;

class ApolloUtilImpl$1
  implements Runnable
{
  ApolloUtilImpl$1(ApolloUtilImpl paramApolloUtilImpl, MessageForApollo paramMessageForApollo, QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.hasPlayed = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.mApolloMessage.isPlayed = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.msgData = MessagePkgUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.mApolloMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.uniseq, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.msgData);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl.1
 * JD-Core Version:    0.7.0.1
 */