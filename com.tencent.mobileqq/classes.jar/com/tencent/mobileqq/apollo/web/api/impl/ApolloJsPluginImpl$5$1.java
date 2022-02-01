package com.tencent.mobileqq.apollo.web.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.apollo.store.ApolloViewController;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Vector;

class ApolloJsPluginImpl$5$1
  implements Runnable
{
  ApolloJsPluginImpl$5$1(ApolloJsPluginImpl.5 param5, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (!ApolloJsPluginImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl$5.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl).contains(this.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl$5.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId))
    {
      QLog.e("[cmshow]ApolloJsPlugin", 1, new Object[] { "[IPC_APOLLO_CHECK_AVATAR_RES] onDownLoadFinish, initAvatar abort, apolloId is detroyed, id=", this.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl$5.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId });
      return;
    }
    Activity localActivity = ApolloJsPluginImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl$5.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl);
    if ((localActivity instanceof IApolloActivityJsCallBack))
    {
      ((IApolloActivityJsCallBack)localActivity).a(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    if (ApolloJsPluginImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl$5.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl) != null) {
      ApolloJsPluginImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl$5.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl).a(this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.5.1
 * JD-Core Version:    0.7.0.1
 */