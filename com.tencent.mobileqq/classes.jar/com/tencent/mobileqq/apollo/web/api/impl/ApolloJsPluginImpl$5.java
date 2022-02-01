package com.tencent.mobileqq.apollo.web.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

class ApolloJsPluginImpl$5
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloJsPluginImpl$5(ApolloJsPluginImpl paramApolloJsPluginImpl, String paramString, ApolloWebAvatarParam paramApolloWebAvatarParam, AtomicInteger paramAtomicInteger, ArrayList paramArrayList) {}
  
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
    paramArrayOfInt = new ArrayList();
    paramArrayOfInt.add(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam);
    paramString.runOnUiThread(new ApolloJsPluginImpl.5.1(this, paramArrayOfInt));
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == this.jdField_a_of_type_JavaUtilArrayList.size()) {
      this.jdField_a_of_type_ComTencentMobileqqApolloWebApiImplApolloJsPluginImpl.callbackOk(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.5
 * JD-Core Version:    0.7.0.1
 */