package com.tencent.mobileqq.apollo.utils.api.impl;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class ApolloMessageUtilImpl$1
  implements Runnable
{
  ApolloMessageUtilImpl$1(MessageForApollo paramMessageForApollo, AppRuntime paramAppRuntime, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("do setReaded for ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloModelMessageForApollo);
        QLog.i("[cmshow]ApolloMessageUtilImpl", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloModelMessageForApollo.hasPlayed = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloModelMessageForApollo.mApolloMessage.isPlayed = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloModelMessageForApollo.msgData = MessagePkgUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloModelMessageForApollo.mApolloMessage);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloModelMessageForApollo.uniseq, this.jdField_a_of_type_ComTencentMobileqqApolloModelMessageForApollo.msgData);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloMessageUtilImpl", 1, "setReaded error.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloMessageUtilImpl.1
 * JD-Core Version:    0.7.0.1
 */