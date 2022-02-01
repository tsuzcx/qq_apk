package com.tencent.mobileqq.apollo.res.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloUserDressInfoListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class ApolloResManagerImpl$2
  implements Runnable
{
  ApolloResManagerImpl$2(ApolloResManagerImpl paramApolloResManagerImpl, String paramString, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener) {}
  
  public void run()
  {
    ApolloExtensionHandler localApolloExtensionHandler = (ApolloExtensionHandler)ApolloResManagerImpl.access$200(this.this$0).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(this.jdField_a_of_type_JavaLangString)))
    {
      ApolloBaseInfo localApolloBaseInfo = ((IApolloDaoManagerService)ApolloResManagerImpl.access$200(this.this$0).getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(this.jdField_a_of_type_JavaLangString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getApolloDressInfo sync : ");
      if (localApolloBaseInfo == null) {
        localObject = null;
      } else {
        localObject = localApolloBaseInfo.toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.d("[cmshow]cm_res", 1, localStringBuilder.toString());
      if (localApolloBaseInfo != null)
      {
        localObject = this.this$0;
        if (ApolloResManagerImpl.access$300((ApolloResManagerImpl)localObject, localApolloBaseInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResManager$ApolloUserDressInfoListener, ApolloResManagerImpl.access$200((ApolloResManagerImpl)localObject), false)) {
          return;
        }
      }
    }
    if (localApolloExtensionHandler == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResManager$ApolloUserDressInfoListener.a(null, "VasExtensionHandler is null", -5004);
      return;
    }
    if (ApolloResManagerImpl.access$400(this.this$0) != null) {
      localApolloExtensionHandler.b(ApolloResManagerImpl.access$400(this.this$0));
    }
    localObject = this.this$0;
    ApolloResManagerImpl.access$402((ApolloResManagerImpl)localObject, ApolloResManagerImpl.access$500((ApolloResManagerImpl)localObject, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResManager$ApolloUserDressInfoListener, ApolloResManagerImpl.access$200((ApolloResManagerImpl)localObject)));
    localApolloExtensionHandler.a(ApolloResManagerImpl.access$400(this.this$0));
    localApolloExtensionHandler.b(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */