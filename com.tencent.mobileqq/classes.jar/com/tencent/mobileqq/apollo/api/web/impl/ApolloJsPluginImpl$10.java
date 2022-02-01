package com.tencent.mobileqq.apollo.api.web.impl;

import android.app.Activity;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

class ApolloJsPluginImpl$10
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloJsPluginImpl$10(ApolloJsPluginImpl paramApolloJsPluginImpl, ApolloWebAvatarParam paramApolloWebAvatarParam, AtomicInteger paramAtomicInteger, ArrayList paramArrayList, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds.length == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds = ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId);
    }
    paramString = new ArrayList();
    paramString.add(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam);
    paramArrayOfInt = ApolloJsPluginImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl);
    if (paramArrayOfInt != null) {
      paramArrayOfInt.runOnUiThread(new ApolloJsPluginImpl.10.1(this, paramString));
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == this.jdField_a_of_type_JavaUtilArrayList.size()) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackOk(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.10
 * JD-Core Version:    0.7.0.1
 */