package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
    Object localObject1 = new PublicAccountDetailImpl();
    ((PublicAccountDetailImpl)localObject1).init(this.a);
    Object localObject2 = this.this$0.b.getEntityManagerFactory(this.this$0.b.getAccount()).createEntityManager();
    if (localObject2 != null) {
      ((EntityManager)localObject2).persistOrReplace((Entity)localObject1);
    }
    if ((this.this$0.b instanceof AppInterface))
    {
      localObject2 = (PublicAccountHandlerImpl)this.this$0.b.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
      if (localObject2 != null) {
        ((PublicAccountHandlerImpl)localObject2).onFollowPublicAccount(localObject1);
      }
    }
    if (this.this$0.c >= 0)
    {
      localObject2 = null;
      if ((this.this$0.b instanceof AppInterface))
      {
        localObject1 = this.this$0.b;
      }
      else
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        localObject1 = localObject2;
        if (localAppRuntime != null)
        {
          localObject1 = localObject2;
          if ((localAppRuntime instanceof AppInterface)) {
            localObject1 = (AppInterface)localAppRuntime;
          }
        }
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent((AppInterface)localObject1, this.this$0.d, this.this$0.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.9.1
 * JD-Core Version:    0.7.0.1
 */