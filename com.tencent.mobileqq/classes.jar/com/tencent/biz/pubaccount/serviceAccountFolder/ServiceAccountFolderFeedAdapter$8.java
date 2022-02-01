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
    ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).removeMsgID(ServiceAccountFolderFeedAdapter.a(this.this$0), this.jdField_a_of_type_JavaLangString);
    Object localObject = (IPublicAccountDataManager)ServiceAccountFolderFeedAdapter.a(this.this$0).getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      ((IPublicAccountDataManager)localObject).delPublicAccountInfoCache(this.jdField_a_of_type_JavaLangString);
      ((IPublicAccountDataManager)localObject).delPublicAccountInfo(this.jdField_a_of_type_JavaLangString);
      IPublicAccountDetail localIPublicAccountDetail = ((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.jdField_a_of_type_JavaLangString);
      if (localIPublicAccountDetail != null)
      {
        ((IPublicAccountDataManager)localObject).delAccountDetailInfoCache(this.jdField_a_of_type_JavaLangString);
        localObject = ServiceAccountFolderFeedAdapter.a(this.this$0).getEntityManagerFactory().createEntityManager();
        ((EntityManager)localObject).remove(localIPublicAccountDetail.getEntity());
        ((EntityManager)localObject).close();
      }
    }
    ServiceAccountFolderFeedAdapter.a(this.this$0).getMessageFacade().a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, 1008);
    RecentUtil.b(ServiceAccountFolderFeedAdapter.a(this.this$0), this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.8
 * JD-Core Version:    0.7.0.1
 */