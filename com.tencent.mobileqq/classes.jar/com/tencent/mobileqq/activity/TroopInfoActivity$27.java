package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

class TroopInfoActivity$27
  implements Runnable
{
  TroopInfoActivity$27(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    Object localObject = ContactUtils.j(this.this$0.app, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick = ((String)localObject);
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "mTroopInfoData.troopOwnerNick = " + this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick);
      }
      return;
    }
    localObject = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberCardInfo(this.this$0.app, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
    if (localObject == null)
    {
      localObject = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(this.this$0.app, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      if (localObject == null) {
        break label352;
      }
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject).friendnick)) {
        localObject = ((TroopMemberInfo)localObject).friendnick;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick = ((String)localObject);
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        break;
        if (TextUtils.isEmpty(((TroopMemberInfo)localObject).troopnick)) {
          break label352;
        }
        localObject = ((TroopMemberInfo)localObject).troopnick;
        continue;
        if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject).nick))
        {
          localObject = ((TroopMemberCardInfo)localObject).nick;
          continue;
        }
        if (TextUtils.isEmpty(((TroopMemberCardInfo)localObject).name)) {
          break label352;
        }
        localObject = ((TroopMemberCardInfo)localObject).name;
        continue;
      }
      if ((this.this$0.c) || (this.this$0.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null)) {
        break;
      }
      this.this$0.c = true;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getFriendInfo(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      break;
      label352:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.27
 * JD-Core Version:    0.7.0.1
 */