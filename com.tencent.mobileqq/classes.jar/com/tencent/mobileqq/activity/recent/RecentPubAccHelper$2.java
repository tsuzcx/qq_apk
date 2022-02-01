package com.tencent.mobileqq.activity.recent;

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

class RecentPubAccHelper$2
  implements BusinessObserver
{
  RecentPubAccHelper$2(RecentPubAccHelper paramRecentPubAccHelper, RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unfollow isSuccess:");
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean));
      ((StringBuilder)localObject).append(", uin: ");
      ((StringBuilder)localObject).append(this.a.getRecentUserUin());
      QLog.d("RecentPubAccHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean)
    {
      RecentPubAccHelper.a(this.c, 2131892951);
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
            QLog.d("RecentPubAccHelper", 2, "unfollow success");
          }
          RecentPubAccHelper.a(this.c, this.a, this.b);
          StructLongMessageDownloadProcessor.deleteTask(this.b, this.a.getRecentUserUin());
          ((TroopBindPublicAccountMgr)this.b.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.a.getRecentUserUin());
          RecentPubAccHelper.b(this.c, this.a, this.b);
        }
        else
        {
          RecentPubAccHelper.b(this.c, 2131892951);
        }
      }
    }
    catch (Exception paramBundle)
    {
      label219:
      break label219;
    }
    RecentPubAccHelper.a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPubAccHelper.2
 * JD-Core Version:    0.7.0.1
 */