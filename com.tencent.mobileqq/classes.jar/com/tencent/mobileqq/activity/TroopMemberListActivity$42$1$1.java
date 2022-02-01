package com.tencent.mobileqq.activity;

import android.os.Handler;
import java.util.List;

class TroopMemberListActivity$42$1$1
  implements Runnable
{
  TroopMemberListActivity$42$1$1(TroopMemberListActivity.42.1 param1, TroopMemberListActivity.ATroopMember paramATroopMember) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$42$1.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$42.a.removeItem(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$42$1.jdField_a_of_type_JavaLangString);
    synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$42$1.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$42.a)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$42$1.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$42.a.mListData.add(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ATroopMember);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$42$1.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$42.a.mHandler.sendEmptyMessage(9);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.42.1.1
 * JD-Core Version:    0.7.0.1
 */