package com.tencent.mobileqq.apollo.res.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager.ApolloUserDressInfoListener;
import java.util.concurrent.atomic.AtomicInteger;

class ApolloResManagerImpl$5
  implements IApolloResDownloader.OnFaceDataDownloadListener
{
  ApolloResManagerImpl$5(ApolloResManagerImpl paramApolloResManagerImpl, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AppInterface paramAppInterface, AtomicInteger paramAtomicInteger3, String paramString, IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    }
    this.b.getAndIncrement();
    IApolloDaoManagerService localIApolloDaoManagerService = (IApolloDaoManagerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    ApolloResManagerImpl.access$700(this.jdField_a_of_type_ComTencentMobileqqApolloResApiImplApolloResManagerImpl, this.b, this.c, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, localIApolloDaoManagerService, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloResApiIApolloResManager$ApolloUserDressInfoListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */