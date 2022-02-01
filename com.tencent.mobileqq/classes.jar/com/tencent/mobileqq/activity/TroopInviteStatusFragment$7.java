package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper.OnTroopSafeDialogClickConfirm;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.widget.QQProgressDialog;

class TroopInviteStatusFragment$7
  implements TroopNotifyHelper.OnTroopSafeDialogClickConfirm
{
  TroopInviteStatusFragment$7(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  public void a(Object... paramVarArgs)
  {
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).requestTroopPrivilege(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, null, this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationUtilsTroopNotificationUtils$TroopPrivilegeCallback);
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131718766);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment.7
 * JD-Core Version:    0.7.0.1
 */