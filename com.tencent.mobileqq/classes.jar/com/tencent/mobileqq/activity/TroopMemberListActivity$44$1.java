package com.tencent.mobileqq.activity;

import java.util.List;

class TroopMemberListActivity$44$1
  implements Runnable
{
  TroopMemberListActivity$44$1(TroopMemberListActivity.44 param44, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$44.a.isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$44.a.mAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$44.a.mAdapter.c = this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$44.a.mAdapter.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.44.1
 * JD-Core Version:    0.7.0.1
 */