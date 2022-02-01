package com.tencent.biz.pubaccount.serviceAccountFolder;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.qphone.base.util.QLog;

class ServiceAccountFolderFeedAdapter$6
  extends NewPublicAccountObserver.ResponseResultListener
{
  ServiceAccountFolderFeedAdapter$6(ServiceAccountFolderFeedAdapter paramServiceAccountFolderFeedAdapter, ServiceAccountFolderFeed paramServiceAccountFolderFeed) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow success");
    }
    ServiceAccountFolderFeedAdapter.b(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter, this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed);
    StructLongMessageDownloadProcessor.deleteTask(ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter), this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.a);
    ((TroopBindPublicAccountMgr)ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter).getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.a);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("do unfollow->uin:");
      paramObject.append(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.a);
      paramObject.append(", success:");
      paramObject.append(String.valueOf(paramBoolean));
      QLog.d("ServiceAccountFolderFeedAdapter", 2, paramObject.toString());
    }
    if ((ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter) != null) && (ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter).isResume())) {
      ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter).b(false);
    }
  }
  
  public void b(Object paramObject)
  {
    ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter);
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.6
 * JD-Core Version:    0.7.0.1
 */