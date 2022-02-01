package com.tencent.mobileqq.apollo.web.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;

class ApolloJsPluginImpl$4
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloJsPluginImpl$4(ApolloJsPluginImpl paramApolloJsPluginImpl, String paramString, ApolloWebAvatarParam paramApolloWebAvatarParam, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl.callbackError(this.jdField_a_of_type_JavaLangString, HardCodeUtil.a(2131700665));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds.length == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds = ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId);
    }
    paramString = ApolloJsPluginImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl);
    if (paramString == null) {
      return;
    }
    paramString.runOnUiThread(new ApolloJsPluginImpl.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.4
 * JD-Core Version:    0.7.0.1
 */