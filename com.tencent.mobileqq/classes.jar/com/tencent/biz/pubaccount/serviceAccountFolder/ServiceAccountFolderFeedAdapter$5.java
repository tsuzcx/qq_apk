package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class ServiceAccountFolderFeedAdapter$5
  implements BusinessObserver
{
  ServiceAccountFolderFeedAdapter$5(ServiceAccountFolderFeedAdapter paramServiceAccountFolderFeedAdapter, ServiceAccountFolderFeed paramServiceAccountFolderFeed) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("do unfollow->uin:");
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append(", success:");
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean));
      QLog.d("ServiceAccountFolderFeedAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((ServiceAccountFolderFeedAdapter.b(this.b) != null) && (ServiceAccountFolderFeedAdapter.b(this.b).isResume())) {
      ServiceAccountFolderFeedAdapter.b(this.b).b(false);
    }
    if (!paramBoolean)
    {
      ServiceAccountFolderFeedAdapter.c(this.b);
      return;
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        localObject = new mobileqq_mp.UnFollowResponse();
        ((mobileqq_mp.UnFollowResponse)localObject).mergeFrom(paramBundle);
        if (((mobileqq_mp.RetInfo)((mobileqq_mp.UnFollowResponse)localObject).ret_info.get()).ret_code.get() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow success");
          }
          ServiceAccountFolderFeedAdapter.b(this.b, this.a);
          StructLongMessageDownloadProcessor.deleteTask(ServiceAccountFolderFeedAdapter.a(this.b), this.a.b);
          ((TroopBindPublicAccountMgr)ServiceAccountFolderFeedAdapter.a(this.b).getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.a.b);
          return;
        }
        ServiceAccountFolderFeedAdapter.c(this.b);
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.5
 * JD-Core Version:    0.7.0.1
 */