package com.tencent.biz.pubaccount.serviceAccountFolder;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;

class ServiceAccountFolderFeedAdapter$8
  implements Runnable
{
  ServiceAccountFolderFeedAdapter$8(ServiceAccountFolderFeedAdapter paramServiceAccountFolderFeedAdapter, String paramString, ServiceAccountFolderFeed paramServiceAccountFolderFeed) {}
  
  public void run()
  {
    ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).removeMsgID(ServiceAccountFolderFeedAdapter.a(this.this$0), this.a);
    Object localObject = (IPublicAccountDataManager)ServiceAccountFolderFeedAdapter.a(this.this$0).getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      ((IPublicAccountDataManager)localObject).delPublicAccountInfoCache(this.a);
      ((IPublicAccountDataManager)localObject).delPublicAccountInfo(this.a);
      IPublicAccountDetail localIPublicAccountDetail = ((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.a);
      if (localIPublicAccountDetail != null)
      {
        ((IPublicAccountDataManager)localObject).delAccountDetailInfoCache(this.a);
        localObject = ServiceAccountFolderFeedAdapter.a(this.this$0).getEntityManagerFactory().createEntityManager();
        ((EntityManager)localObject).remove(localIPublicAccountDetail.getEntity());
        ((EntityManager)localObject).close();
      }
    }
    ServiceAccountFolderFeedAdapter.a(this.this$0).getMessageFacade().c(this.b.b, 1008);
    RecentUtil.b(ServiceAccountFolderFeedAdapter.a(this.this$0), this.a, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.8
 * JD-Core Version:    0.7.0.1
 */