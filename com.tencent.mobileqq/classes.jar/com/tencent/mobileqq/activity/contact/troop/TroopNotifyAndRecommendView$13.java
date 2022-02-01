package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.util.TroopReportor;

class TroopNotifyAndRecommendView$13
  implements TroopNotifyHelper.OnTroopSafeDialogClickConfirm
{
  TroopNotifyAndRecommendView$13(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      NotificationAdapter.ViewHolder localViewHolder = (NotificationAdapter.ViewHolder)paramVarArgs[0];
      String str1 = (String)paramVarArgs[1];
      String str2 = (String)paramVarArgs[2];
      paramVarArgs = (String)paramVarArgs[3];
      TroopRequestActivity.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, localViewHolder.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationUtils$TroopPrivilegeCallback);
      TroopReportor.a("Grp_contacts_news", "notice", "agree_invite", 0, 0, new String[] { str1, str2, paramVarArgs, "0" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.13
 * JD-Core Version:    0.7.0.1
 */