package com.tencent.mobileqq.apollo.api.web.impl;

import android.app.Activity;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;

class ApolloJsPluginImpl$9
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloJsPluginImpl$9(ApolloJsPluginImpl paramApolloJsPluginImpl, ApolloWebAvatarParam paramApolloWebAvatarParam, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds.length == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds = ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId);
      }
      paramString = ApolloJsPluginImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl);
      if (paramString != null) {
        paramString.runOnUiThread(new ApolloJsPluginImpl.9.1(this));
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_JavaLangString, HardCodeUtil.a(2131700524));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.9
 * JD-Core Version:    0.7.0.1
 */