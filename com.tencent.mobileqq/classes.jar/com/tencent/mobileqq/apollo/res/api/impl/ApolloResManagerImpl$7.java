package com.tencent.mobileqq.apollo.res.api.impl;

import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloRoleInfoListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.qroute.QRoute;

class ApolloResManagerImpl$7
  implements Runnable
{
  ApolloResManagerImpl$7(ApolloResManagerImpl paramApolloResManagerImpl, int paramInt, IApolloResManager.ApolloRoleInfoListener paramApolloRoleInfoListener, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (CMResUtil.b(this.jdField_a_of_type_Int))
    {
      IApolloResManager.ApolloRoleInfoListener localApolloRoleInfoListener = this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResManager$ApolloRoleInfoListener;
      if (localApolloRoleInfoListener != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localApolloRoleInfoListener.a(localStringBuilder.toString(), "success", 0);
      }
    }
    else
    {
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, new ApolloResManagerImpl.7.1(this), this.jdField_a_of_type_Int, null, -1, -1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl.7
 * JD-Core Version:    0.7.0.1
 */