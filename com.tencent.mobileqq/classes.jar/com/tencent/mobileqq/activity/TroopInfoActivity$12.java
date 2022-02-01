package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.text.TextUtils;
import anwd;
import bgao;
import bgap;
import bglf;
import bglj;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class TroopInfoActivity$12
  implements Runnable
{
  TroopInfoActivity$12(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.troopinfo", 2, "init mTroopInfoData == null");
      }
      return;
    }
    if (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))
    {
      localObject1 = bglf.j(this.this$0.app, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)))
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick = ((String)localObject1);
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
    }
    else
    {
      label109:
      if (this.this$0.jdField_a_of_type_Anwd != null)
      {
        if ((this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 2) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 101) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 102) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 103) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 104) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 105) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 106) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 112) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 113)) {
          break label712;
        }
        this.this$0.jdField_a_of_type_Anwd.a(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
      }
    }
    label607:
    while (!this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
    {
      this.this$0.app.d(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "init(),getTroopMemberCard,getMutiTroopInfo,refreshTroopFace");
      }
      localObject1 = bgap.a(BaseApplication.getContext()).a(this.this$0, Long.toString(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt));
      if (localObject1 != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass = ((bgao)localObject1).a();
      }
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      if (this.this$0.jdField_a_of_type_Anwd == null) {
        break;
      }
      this.this$0.jdField_a_of_type_Anwd.g(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.this$0.jdField_a_of_type_Anwd.a(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 115) {
        break;
      }
      this.this$0.jdField_a_of_type_Anwd.i(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      return;
      str = null;
      Object localObject2 = bglj.a().a(this.this$0.app, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      if (localObject2 == null)
      {
        localObject2 = bglj.a().a(this.this$0.app, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
        localObject1 = str;
        if (localObject2 != null)
        {
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject2).friendnick)) {
            break label607;
          }
          localObject1 = ((TroopMemberInfo)localObject2).friendnick;
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label671;
        }
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick = ((String)localObject1);
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        break;
        localObject1 = str;
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).troopnick))
        {
          localObject1 = ((TroopMemberInfo)localObject2).troopnick;
          continue;
          if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject2).nick))
          {
            localObject1 = ((TroopMemberCardInfo)localObject2).nick;
          }
          else
          {
            localObject1 = str;
            if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject2).name)) {
              localObject1 = ((TroopMemberCardInfo)localObject2).name;
            }
          }
        }
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
        break label109;
      }
      this.this$0.c = true;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      break label109;
    }
    label671:
    label712:
    Object localObject1 = this.this$0.jdField_a_of_type_Anwd;
    String str = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 28) {}
    for (boolean bool = true;; bool = false)
    {
      ((anwd)localObject1).b(str, bool);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.12
 * JD-Core Version:    0.7.0.1
 */