package com.tencent.mobileqq.apollo.api.web.impl;

import android.app.Activity;
import com.tencent.mobileqq.apollo.store.ApolloViewController;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;
import java.util.ArrayList;
import java.util.Vector;

class ApolloJsPluginImpl$10$1
  implements Runnable
{
  ApolloJsPluginImpl$10$1(ApolloJsPluginImpl.10 param10, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (ApolloJsPluginImpl.access$600(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$10.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl).contains(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$10.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId))
    {
      Activity localActivity = ApolloJsPluginImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$10.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl);
      if (!(localActivity instanceof IApolloActivityJsCallBack)) {
        break label59;
      }
      ((IApolloActivityJsCallBack)localActivity).a(this.jdField_a_of_type_JavaUtilArrayList);
    }
    label59:
    while (ApolloJsPluginImpl.access$700(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$10.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl) == null) {
      return;
    }
    ApolloJsPluginImpl.access$700(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl$10.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl).a(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.10.1
 * JD-Core Version:    0.7.0.1
 */