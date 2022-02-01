package com.tencent.mobileqq.apollo.api.res.impl;

import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
import java.util.concurrent.atomic.AtomicInteger;

class ApolloResManagerImpl$3
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloResManagerImpl$3(ApolloResManagerImpl paramApolloResManagerImpl, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, IApolloManagerService paramIApolloManagerService, String paramString, ApolloResManagerImpl.ApolloUserDressInfoListener paramApolloUserDressInfoListener) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    }
    this.b.getAndIncrement();
    ApolloResManagerImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResManagerImpl, this.b, this.c, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, this.jdField_a_of_type_ComTencentMobileqqApolloApiIApolloManagerService, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloApiResImplApolloResManagerImpl$ApolloUserDressInfoListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl.3
 * JD-Core Version:    0.7.0.1
 */