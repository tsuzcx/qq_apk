package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;

class TroopTransferActivity$17
  implements Runnable
{
  TroopTransferActivity$17(TroopTransferActivity paramTroopTransferActivity, Friends paramFriends, TroopTransferActivity.TroopMemberItem paramTroopMemberItem) {}
  
  public void run()
  {
    boolean bool2 = Utils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.j);
    boolean bool1 = true;
    Object localObject;
    if (!bool2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.j = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.m))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem;
        ((TroopTransferActivity.TroopMemberItem)localObject).k = ChnToSpell.a(((TroopTransferActivity.TroopMemberItem)localObject).m, 2);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem;
        ((TroopTransferActivity.TroopMemberItem)localObject).l = ChnToSpell.a(((TroopTransferActivity.TroopMemberItem)localObject).m, 1);
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem;
        ((TroopTransferActivity.TroopMemberItem)localObject).k = "";
        ((TroopTransferActivity.TroopMemberItem)localObject).l = "";
      }
    }
    if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.g))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.g = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.g))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem;
        ((TroopTransferActivity.TroopMemberItem)localObject).h = ChnToSpell.a(((TroopTransferActivity.TroopMemberItem)localObject).g, 2);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem;
        ((TroopTransferActivity.TroopMemberItem)localObject).i = ChnToSpell.a(((TroopTransferActivity.TroopMemberItem)localObject).g, 1);
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem;
        ((TroopTransferActivity.TroopMemberItem)localObject).h = "";
        ((TroopTransferActivity.TroopMemberItem)localObject).i = "";
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.j)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.j;
    } else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.m)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.m;
    } else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.g)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.g;
    } else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.a)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.a;
    } else {
      localObject = "";
    }
    if (!Utils.a(localObject, this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem.b))
    {
      TroopTransferActivity.TroopMemberItem localTroopMemberItem = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem;
      localTroopMemberItem.b = ((String)localObject);
      if (!TextUtils.isEmpty(localTroopMemberItem.b))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem;
        ((TroopTransferActivity.TroopMemberItem)localObject).c = ChnToSpell.a(((TroopTransferActivity.TroopMemberItem)localObject).b, 2);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem;
        ((TroopTransferActivity.TroopMemberItem)localObject).d = ChnToSpell.a(((TroopTransferActivity.TroopMemberItem)localObject).b, 1);
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem;
        ((TroopTransferActivity.TroopMemberItem)localObject).c = "";
        ((TroopTransferActivity.TroopMemberItem)localObject).d = "";
      }
    }
    else
    {
      bool1 = false;
    }
    this.this$0.a(bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.17
 * JD-Core Version:    0.7.0.1
 */