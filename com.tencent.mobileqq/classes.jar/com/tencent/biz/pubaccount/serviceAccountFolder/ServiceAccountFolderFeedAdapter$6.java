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
    ServiceAccountFolderFeedAdapter.b(this.b, this.a);
    StructLongMessageDownloadProcessor.deleteTask(ServiceAccountFolderFeedAdapter.a(this.b), this.a.b);
    ((TroopBindPublicAccountMgr)ServiceAccountFolderFeedAdapter.a(this.b).getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.a.b);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("do unfollow->uin:");
      paramObject.append(this.a.b);
      paramObject.append(", success:");
      paramObject.append(String.valueOf(paramBoolean));
      QLog.d("ServiceAccountFolderFeedAdapter", 2, paramObject.toString());
    }
    if ((ServiceAccountFolderFeedAdapter.b(this.b) != null) && (ServiceAccountFolderFeedAdapter.b(this.b).isResume())) {
      ServiceAccountFolderFeedAdapter.b(this.b).b(false);
    }
  }
  
  public void b(Object paramObject)
  {
    ServiceAccountFolderFeedAdapter.c(this.b);
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.6
 * JD-Core Version:    0.7.0.1
 */