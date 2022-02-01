package com.tencent.mobileqq.apollo.aio;

import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class ApolloResponseManager$1$1
  implements Runnable
{
  ApolloResponseManager$1$1(ApolloResponseManager.1 param1, ApolloActionData paramApolloActionData) {}
  
  public void run()
  {
    if (ApolloResponseManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioApolloResponseManager$1.a) == null) {
      return;
    }
    ((ApolloResManagerImpl)ApolloResponseManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloAioApolloResponseManager$1.a).getRuntimeService(IApolloResManager.class, "all")).downloadApolloRes(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ApolloResponseManager.1.1
 * JD-Core Version:    0.7.0.1
 */