package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopMemberListActivity$1
  implements Runnable
{
  TroopMemberListActivity$1(TroopMemberListActivity paramTroopMemberListActivity, Intent paramIntent, FriendsManager paramFriendsManager, TroopManager paramTroopManager) {}
  
  public void run()
  {
    boolean bool2 = false;
    int i;
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("memberOperationFlag", 0);
      ??? = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("memberOperateUin");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "onActivityResult, REQUEST_CODE_SHOW_MEMBER_CARD, optFlg=" + i + ", optUin=" + (String)???);
      }
      if ((i & 0x1) != 0)
      {
        this.this$0.a((String)???);
        if (((i & 0x4) != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null))
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.this$0.jdField_b_of_type_JavaLangString);
          ??? = this.this$0;
          if ((this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (!this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop())) {
            break label511;
          }
        }
      }
      label511:
      for (boolean bool1 = true;; bool1 = false) {
        for (;;)
        {
          ((TroopMemberListActivity)???).jdField_b_of_type_Boolean = bool1;
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
          {
            if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin != null) {
              this.this$0.e = this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin;
            }
            if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator != null) {
              this.this$0.f = this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.Administrator;
            }
            ??? = this.this$0;
            if ((this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin == null) || (!this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin.equals(this.this$0.app.getCurrentAccountUin())))
            {
              bool1 = bool2;
              if (this.this$0.f != null)
              {
                bool1 = bool2;
                if (!this.this$0.f.contains(this.this$0.app.getCurrentAccountUin())) {}
              }
            }
            else
            {
              bool1 = true;
            }
            ((TroopMemberListActivity)???).jdField_a_of_type_Boolean = bool1;
            if (QLog.isColorLevel()) {
              QLog.d("TroopMemberListActivityget_troop_member", 2, "onActivityResult, REQUEST_CODE_SHOW_MEMBER_CARD, admins:" + this.this$0.f + " owner:" + this.this$0.e);
            }
          }
          if ((i != 0) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null)) {
            this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
          }
          return;
          if ((i & 0x2) == 0) {
            break;
          }
          Object localObject2 = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(this.this$0.app, this.this$0.jdField_b_of_type_JavaLangString, (String)???);
          if ((localObject2 == null) || (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager == null)) {
            break;
          }
          this.this$0.a((String)???);
          synchronized (this.this$0)
          {
            localObject2 = this.this$0.a((TroopMemberInfo)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager);
            this.this$0.jdField_a_of_type_JavaUtilList.add(localObject2);
          }
        }
      }
      ??? = "";
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.1
 * JD-Core Version:    0.7.0.1
 */