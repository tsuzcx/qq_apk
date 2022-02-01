package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

class PublicAccountUtilImpl$9$1
  implements Runnable
{
  PublicAccountUtilImpl$9$1(PublicAccountUtilImpl.9 param9, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse) {}
  
  public void run()
  {
    Object localObject1 = new AccountDetail(this.a);
    Object localObject2 = this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()).createEntityManager();
    if (localObject2 != null) {
      ((EntityManager)localObject2).persistOrReplace((Entity)localObject1);
    }
    if ((this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      localObject2 = (PublicAccountHandler)((QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface).getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
      if (localObject2 != null) {
        ((PublicAccountHandler)localObject2).a(localObject1);
      }
    }
    if (this.this$0.jdField_a_of_type_Int >= 0)
    {
      localObject2 = null;
      if (!(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        break label152;
      }
      localObject1 = (QQAppInterface)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface;
    }
    for (;;)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent((AppInterface)localObject1, this.this$0.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_Int);
      return;
      label152:
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
      localObject1 = localObject2;
      if (localAppRuntime != null)
      {
        localObject1 = localObject2;
        if ((localAppRuntime instanceof QQAppInterface)) {
          localObject1 = (QQAppInterface)localAppRuntime;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.9.1
 * JD-Core Version:    0.7.0.1
 */