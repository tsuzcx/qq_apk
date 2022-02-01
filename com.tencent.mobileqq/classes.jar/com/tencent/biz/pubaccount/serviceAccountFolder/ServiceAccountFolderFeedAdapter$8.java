package com.tencent.biz.pubaccount.serviceAccountFolder;

import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AccountDetail;
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
    Object localObject = (PublicAccountDataManager)ServiceAccountFolderFeedAdapter.a(this.this$0).getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null)
    {
      ((PublicAccountDataManager)localObject).c(this.jdField_a_of_type_JavaLangString);
      ((PublicAccountDataManager)localObject).b(this.jdField_a_of_type_JavaLangString);
      AccountDetail localAccountDetail = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localAccountDetail != null)
      {
        ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_JavaLangString);
        localObject = ServiceAccountFolderFeedAdapter.a(this.this$0).getEntityManagerFactory().createEntityManager();
        ((EntityManager)localObject).remove(localAccountDetail);
        ((EntityManager)localObject).close();
      }
    }
    ServiceAccountFolderFeedAdapter.a(this.this$0).getMessageFacade().a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, 1008);
    RecentUtil.b(ServiceAccountFolderFeedAdapter.a(this.this$0), this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.8
 * JD-Core Version:    0.7.0.1
 */