package com.tencent.mobileqq.apollo.api.web.impl;

import com.tencent.mobileqq.apollo.store.ApolloViewController;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

class ApolloJsPluginImpl$9$1
  implements Runnable
{
  ApolloJsPluginImpl$9$1(ApolloJsPluginImpl.9 param9) {}
  
  public void run()
  {
    if (ApolloJsPluginImpl.access$600(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl).contains(this.a.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId))
    {
      Object localObject = "";
      if (this.a.jdField_a_of_type_Int == 1) {
        if (ApolloJsPluginImpl.access$700(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl) != null) {
          localObject = ApolloJsPluginImpl.access$700(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl).a(1, true, this.a.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callJs(this.a.jdField_a_of_type_JavaLangString + "&&" + this.a.jdField_a_of_type_JavaLangString + "(" + (String)localObject + ");");
        return;
        localObject = "{\"result\":1, \"msg\": \"终端初始化错误\" }";
        continue;
        if (this.a.jdField_a_of_type_Int == 0)
        {
          localObject = ApolloJsPluginImpl.access$000(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl);
          if ((localObject instanceof IApolloActivityJsCallBack)) {
            localObject = ((IApolloActivityJsCallBack)localObject).a(ApolloJsPluginImpl.access$800(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl), this.a.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam);
          } else {
            localObject = "{\"result\":1, \"msg\": \"非商城页面\" }";
          }
        }
      }
    }
    QLog.e("ApolloJsPlugin", 1, new Object[] { "[IPC_APOLLO_CHECK_AVATAR_RES] onDownLoadFinish, initAvatar abort, apolloId is detroyed, id=", this.a.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.9.1
 * JD-Core Version:    0.7.0.1
 */