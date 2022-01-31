package com.tencent.mobileqq.activity;

import aloz;
import android.content.Intent;
import android.os.Handler;
import bdbx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopMemberListActivity$1
  implements Runnable
{
  TroopMemberListActivity$1(TroopMemberListActivity paramTroopMemberListActivity, Intent paramIntent, aloz paramaloz, TroopManager paramTroopManager) {}
  
  public void run()
  {
    boolean bool2 = false;
    ??? = "";
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
          this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.this$0.jdField_b_of_type_JavaLangString);
          ??? = this.this$0;
          if ((this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop())) {
            break label508;
          }
        }
      }
      label508:
      for (boolean bool1 = true;; bool1 = false) {
        for (;;)
        {
          ((TroopMemberListActivity)???).jdField_b_of_type_Boolean = bool1;
          if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
          {
            if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) {
              this.this$0.e = this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin;
            }
            if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator != null) {
              this.this$0.f = this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator;
            }
            ??? = this.this$0;
            if ((this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin == null) || (!this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin.equals(this.this$0.app.getCurrentAccountUin())))
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
          if ((i != 0) && (this.this$0.jdField_a_of_type_Aecg != null)) {
            this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
          }
          return;
          if ((i & 0x2) == 0) {
            break;
          }
          Object localObject2 = bdbx.a().a(this.this$0.app, this.this$0.jdField_b_of_type_JavaLangString, (String)???);
          if ((localObject2 == null) || (this.jdField_a_of_type_Aloz == null)) {
            break;
          }
          this.this$0.a((String)???);
          synchronized (this.this$0)
          {
            localObject2 = this.this$0.a((TroopMemberInfo)localObject2, this.jdField_a_of_type_Aloz);
            this.this$0.jdField_a_of_type_JavaUtilList.add(localObject2);
          }
        }
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.1
 * JD-Core Version:    0.7.0.1
 */