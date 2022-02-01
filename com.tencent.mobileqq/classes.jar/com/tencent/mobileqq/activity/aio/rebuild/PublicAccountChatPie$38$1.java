package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;

class PublicAccountChatPie$38$1
  implements Runnable
{
  PublicAccountChatPie$38$1(PublicAccountChatPie.38 param38, mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse) {}
  
  public void run()
  {
    IPublicAccountDetail localIPublicAccountDetail = ((IPublicAccountDetail)QRoute.api(IPublicAccountDetail.class)).init(this.a);
    EntityManager localEntityManager = this.b.a.d.getEntityManagerFactory(this.b.a.d.getAccount()).createEntityManager();
    if (localEntityManager != null) {
      localEntityManager.persistOrReplace(localIPublicAccountDetail.getEntity());
    }
    this.b.a.cl = PublicAccountInfo.createPublicAccount(localIPublicAccountDetail, 0L);
    this.b.a.a(this.b.a.cl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.38.1
 * JD-Core Version:    0.7.0.1
 */