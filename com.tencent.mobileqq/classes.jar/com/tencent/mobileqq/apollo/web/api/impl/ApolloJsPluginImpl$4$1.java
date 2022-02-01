package com.tencent.mobileqq.apollo.web.api.impl;

import com.tencent.mobileqq.apollo.store.ApolloViewController;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

class ApolloJsPluginImpl$4$1
  implements Runnable
{
  ApolloJsPluginImpl$4$1(ApolloJsPluginImpl.4 param4) {}
  
  public void run()
  {
    if (!ApolloJsPluginImpl.access$300(this.a.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl).contains(this.a.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId))
    {
      QLog.e("[cmshow]ApolloJsPlugin", 1, new Object[] { "[IPC_APOLLO_CHECK_AVATAR_RES] onDownLoadFinish, initAvatar abort, apolloId is detroyed, id=", this.a.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId });
      return;
    }
    Object localObject;
    if (this.a.jdField_a_of_type_Int == 1)
    {
      if (ApolloJsPluginImpl.access$400(this.a.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl) != null) {
        localObject = ApolloJsPluginImpl.access$400(this.a.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl).a(1, true, this.a.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam);
      } else {
        localObject = "{\"result\":1, \"msg\": \"终端初始化错误\" }";
      }
    }
    else if (this.a.jdField_a_of_type_Int == 0)
    {
      localObject = ApolloJsPluginImpl.access$100(this.a.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl);
      if ((localObject instanceof IApolloActivityJsCallBack)) {
        localObject = ((IApolloActivityJsCallBack)localObject).a(ApolloJsPluginImpl.access$500(this.a.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl), this.a.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam);
      } else {
        localObject = "{\"result\":1, \"msg\": \"非商城页面\" }";
      }
    }
    else
    {
      localObject = "";
    }
    ApolloJsPluginImpl localApolloJsPluginImpl = this.a.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("&&");
    localStringBuilder.append(this.a.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("(");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(");");
    localApolloJsPluginImpl.callJs(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.4.1
 * JD-Core Version:    0.7.0.1
 */