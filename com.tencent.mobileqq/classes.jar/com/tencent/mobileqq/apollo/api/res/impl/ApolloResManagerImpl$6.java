package com.tencent.mobileqq.apollo.api.res.impl;

import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;

class ApolloResManagerImpl$6
  implements Runnable
{
  ApolloResManagerImpl$6(ApolloResManagerImpl paramApolloResManagerImpl, int paramInt, ApolloResManagerImpl.ApolloRoleInfoListener paramApolloRoleInfoListener, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (ApolloUtilImpl.checkRoleRes(this.jdField_a_of_type_Int))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResManagerImpl$ApolloRoleInfoListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResManagerImpl$ApolloRoleInfoListener.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/" + this.jdField_a_of_type_Int, "success", 0);
      }
      return;
    }
    ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, new ApolloResManagerImpl.6.1(this), this.jdField_a_of_type_Int, null, -1, -1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl.6
 * JD-Core Version:    0.7.0.1
 */