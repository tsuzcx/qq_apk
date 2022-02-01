package com.tencent.mobileqq.apollo.api.res.impl;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class ApolloResManagerImpl$1
  implements Runnable
{
  ApolloResManagerImpl$1(ApolloResManagerImpl paramApolloResManagerImpl, QQAppInterface paramQQAppInterface, String paramString, ApolloResManagerImpl.ApolloUserDressInfoListener paramApolloUserDressInfoListener) {}
  
  public void run()
  {
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    ApolloExtensionHandlerImpl localApolloExtensionHandlerImpl = (ApolloExtensionHandlerImpl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((!TextUtils.isEmpty(str)) && (str.equals(this.jdField_a_of_type_JavaLangString)) && (localIApolloManagerService != null))
    {
      ApolloBaseInfo localApolloBaseInfo = localIApolloManagerService.getApolloBaseInfo(this.jdField_a_of_type_JavaLangString);
      StringBuilder localStringBuilder = new StringBuilder().append("getApolloDressInfo sync : ");
      if (localApolloBaseInfo == null) {}
      for (str = null;; str = localApolloBaseInfo.toString())
      {
        QLog.d("cm_res", 1, str);
        if ((localApolloBaseInfo == null) || (!ApolloResManagerImpl.access$000(this.this$0, localIApolloManagerService, localApolloBaseInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResManagerImpl$ApolloUserDressInfoListener, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false))) {
          break;
        }
        return;
      }
    }
    if (localApolloExtensionHandlerImpl == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResManagerImpl$ApolloUserDressInfoListener.a(null, "VasExtensionHandler is null", -5004);
      return;
    }
    if (ApolloResManagerImpl.access$100(this.this$0) != null) {
      localApolloExtensionHandlerImpl.b(ApolloResManagerImpl.access$100(this.this$0));
    }
    ApolloResManagerImpl.access$102(this.this$0, ApolloResManagerImpl.access$200(this.this$0, localIApolloManagerService, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResManagerImpl$ApolloUserDressInfoListener, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    localApolloExtensionHandlerImpl.a(ApolloResManagerImpl.access$100(this.this$0));
    localApolloExtensionHandlerImpl.b(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */