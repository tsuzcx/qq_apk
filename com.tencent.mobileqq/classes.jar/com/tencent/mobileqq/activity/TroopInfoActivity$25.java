package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.text.TextUtils;
import bhdf;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

class TroopInfoActivity$25
  implements Runnable
{
  TroopInfoActivity$25(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    Object localObject1 = ContactUtils.getFriendDisplayName(this.this$0.app, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick = ((String)localObject1);
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "mTroopInfoData.troopOwnerNick = " + this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick);
      }
      return;
      Object localObject2 = null;
      Object localObject3 = bhdf.a().a(this.this$0.app, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      if (localObject3 == null)
      {
        localObject3 = bhdf.a().a(this.this$0.app, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          if (TextUtils.isEmpty(((TroopMemberInfo)localObject3).friendnick)) {
            break label237;
          }
          localObject1 = ((TroopMemberInfo)localObject3).friendnick;
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label295;
        }
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick = ((String)localObject1);
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        break;
        label237:
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject3).troopnick))
        {
          localObject1 = ((TroopMemberInfo)localObject3).troopnick;
          continue;
          if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject3).nick))
          {
            localObject1 = ((TroopMemberCardInfo)localObject3).nick;
          }
          else
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject3).name)) {
              localObject1 = ((TroopMemberCardInfo)localObject3).name;
            }
          }
        }
      }
      label295:
      if ((!this.this$0.c) && (this.this$0.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null))
      {
        this.this$0.c = true;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getFriendInfo(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.25
 * JD-Core Version:    0.7.0.1
 */