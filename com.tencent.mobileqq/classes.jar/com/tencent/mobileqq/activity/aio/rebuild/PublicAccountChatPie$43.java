package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountManager.refuseAcceptDone;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;

class PublicAccountChatPie$43
  implements IPublicAccountManager.refuseAcceptDone
{
  PublicAccountChatPie$43(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void a(boolean paramBoolean)
  {
    this.a.bz();
    if (!paramBoolean)
    {
      this.a.t(2131892951);
      return;
    }
    EntityManager localEntityManager = this.a.d.getEntityManagerFactory().createEntityManager();
    IPublicAccountDetail localIPublicAccountDetail = (IPublicAccountDetail)localEntityManager.find(((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetail.class), this.a.ah.b);
    if (localIPublicAccountDetail != null) {
      localEntityManager.remove(localIPublicAccountDetail.getEntity());
    }
    localEntityManager.close();
    this.a.d.getMessageFacade().c(this.a.ah.b, 1008);
    this.a.L();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.43
 * JD-Core Version:    0.7.0.1
 */