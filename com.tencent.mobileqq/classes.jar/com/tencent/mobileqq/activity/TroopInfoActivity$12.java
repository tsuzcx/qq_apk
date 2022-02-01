package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class TroopInfoActivity$12
  implements Runnable
{
  TroopInfoActivity$12(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.troopinfo", 2, "init mTroopInfoData == null");
      }
    }
    label296:
    do
    {
      do
      {
        return;
        if (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))
        {
          localObject = ContactUtils.j(this.this$0.app, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equals(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))) {
            break;
          }
          this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick = ((String)localObject);
          this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        }
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null)
        {
          if ((this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 2) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 101) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 102) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 103) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 104) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 105) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 106) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 112) || (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 113)) {
            break label706;
          }
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
          this.this$0.app.refreshTroopFace(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopinfo", 2, "init(),getTroopMemberCard,getMutiTroopInfo,refreshTroopFace");
        }
        localObject = GroupCatalogTool.a(BaseApplication.getContext()).a(this.this$0, Long.toString(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt));
        if (localObject != null) {
          this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopClass = ((GroupCatalogBean)localObject).a();
        }
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      } while (this.this$0.jdField_a_of_type_ComTencentMobileqqAppTroopHandler == null);
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.g(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    } while (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 115);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.i(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    return;
    Object localObject = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberCardInfo(this.this$0.app, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
    if (localObject == null)
    {
      localObject = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(this.this$0.app, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      if (localObject == null) {
        break label778;
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
          break label778;
        }
        localObject = ((TroopMemberInfo)localObject).troopnick;
        continue;
        if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject).nick))
        {
          localObject = ((TroopMemberCardInfo)localObject).nick;
          continue;
        }
        if (TextUtils.isEmpty(((TroopMemberCardInfo)localObject).name)) {
          break label778;
        }
        localObject = ((TroopMemberCardInfo)localObject).name;
        continue;
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
        break;
      }
      this.this$0.c = true;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getFriendInfo(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      break;
      label706:
      if (!this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break label296;
      }
      localObject = (TroopInfoHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
      String str = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 28) {}
      for (boolean bool = true;; bool = false)
      {
        ((TroopInfoHandler)localObject).a(str, bool);
        break;
      }
      label778:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.12
 * JD-Core Version:    0.7.0.1
 */