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
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.a + ", success:" + String.valueOf(paramBoolean));
    }
    if ((ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter) != null) && (ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter).isResume())) {
      ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter).b(false);
    }
    if (!paramBoolean) {
      ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter);
    }
    for (;;)
    {
      return;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.UnFollowResponse localUnFollowResponse = new mobileqq_mp.UnFollowResponse();
          localUnFollowResponse.mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)localUnFollowResponse.ret_info.get()).ret_code.get() == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow success");
            }
            ServiceAccountFolderFeedAdapter.b(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter, this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed);
            StructLongMessageDownloadProcessor.deleteTask(ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter), this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.a);
            ((TroopBindPublicAccountMgr)ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter).getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.a);
            return;
          }
          ServiceAccountFolderFeedAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeedAdapter);
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeedAdapter.5
 * JD-Core Version:    0.7.0.1
 */