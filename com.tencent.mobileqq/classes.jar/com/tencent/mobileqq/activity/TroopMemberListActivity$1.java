package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopMemberListActivity$1
  implements Runnable
{
  TroopMemberListActivity$1(TroopMemberListActivity paramTroopMemberListActivity, Intent paramIntent, IFriendDataService paramIFriendDataService, ITroopInfoService paramITroopInfoService) {}
  
  public void run()
  {
    ??? = this.jdField_a_of_type_AndroidContentIntent;
    boolean bool2 = false;
    int i;
    if (??? != null)
    {
      i = ((Intent)???).getIntExtra("memberOperationFlag", 0);
      ??? = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("memberOperateUin");
    }
    else
    {
      ??? = "";
      i = 0;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onActivityResult, REQUEST_CODE_SHOW_MEMBER_CARD, optFlg=");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(", optUin=");
      ((StringBuilder)localObject2).append((String)???);
      QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject2).toString());
    }
    if ((i & 0x1) != 0)
    {
      this.this$0.removeItem((String)???);
    }
    else if ((i & 0x2) != 0)
    {
      localObject2 = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(this.this$0.app, this.this$0.mTroopUin, (String)???);
      if ((localObject2 != null) && (this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService != null))
      {
        this.this$0.removeItem((String)???);
        synchronized (this.this$0)
        {
          localObject2 = this.this$0.convertTroopMemberInfo((TroopMemberInfo)localObject2, this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService);
          this.this$0.mListData.add(localObject2);
        }
      }
    }
    if ((i & 0x4) != 0)
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopInfoService;
      if (??? != null)
      {
        TroopMemberListActivity localTroopMemberListActivity = this.this$0;
        localTroopMemberListActivity.mTroopInfo = ((ITroopInfoService)???).findTroopInfo(localTroopMemberListActivity.mTroopUin);
        ??? = this.this$0;
        boolean bool1;
        if ((((TroopMemberListActivity)???).mTroopInfo != null) && (this.this$0.mTroopInfo.isHomeworkTroop())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((TroopMemberListActivity)???).mIsHomeworkTroop = bool1;
        if (this.this$0.mTroopInfo != null)
        {
          if (this.this$0.mTroopInfo.troopowneruin != null)
          {
            ??? = this.this$0;
            ((TroopMemberListActivity)???).mTroopOwnerUin = ((TroopMemberListActivity)???).mTroopInfo.troopowneruin;
          }
          if (this.this$0.mTroopInfo.Administrator != null)
          {
            ??? = this.this$0;
            ((TroopMemberListActivity)???).mTroopAdminUins = ((TroopMemberListActivity)???).mTroopInfo.Administrator;
          }
          ??? = this.this$0;
          if ((((TroopMemberListActivity)???).mTroopInfo.troopowneruin == null) || (!this.this$0.mTroopInfo.troopowneruin.equals(this.this$0.app.getCurrentAccountUin())))
          {
            bool1 = bool2;
            if (this.this$0.mTroopAdminUins != null)
            {
              bool1 = bool2;
              if (!this.this$0.mTroopAdminUins.contains(this.this$0.app.getCurrentAccountUin())) {}
            }
          }
          else
          {
            bool1 = true;
          }
          ((TroopMemberListActivity)???).mIsTroopAdmin = bool1;
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("onActivityResult, REQUEST_CODE_SHOW_MEMBER_CARD, admins:");
            ((StringBuilder)???).append(this.this$0.mTroopAdminUins);
            ((StringBuilder)???).append(" owner:");
            ((StringBuilder)???).append(this.this$0.mTroopOwnerUin);
            QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)???).toString());
          }
        }
      }
    }
    if ((i != 0) && (this.this$0.mAdapter != null)) {
      this.this$0.mHandler.sendEmptyMessage(9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.1
 * JD-Core Version:    0.7.0.1
 */