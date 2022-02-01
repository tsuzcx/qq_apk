package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.app.QQAppInterface;

class ApolloResponseManagerImpl$1$1
  implements Runnable
{
  ApolloResponseManagerImpl$1$1(ApolloResponseManagerImpl.1 param1, ApolloActionData paramApolloActionData) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloResponseManagerImpl$1.a.mApp == null) {
      return;
    }
    ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloResponseManagerImpl$1.a.mApp.getRuntimeService(IApolloManagerService.class, "all")).downloadApolloRes(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloActionData, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloResponseManagerImpl.1.1
 * JD-Core Version:    0.7.0.1
 */