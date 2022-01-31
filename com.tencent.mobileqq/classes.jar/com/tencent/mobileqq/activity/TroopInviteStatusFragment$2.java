package com.tencent.mobileqq.activity;

import akhp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;

class TroopInviteStatusFragment$2
  implements Runnable
{
  TroopInviteStatusFragment$2(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  public void run()
  {
    ((akhp)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.this$0.jdField_a_of_type_JavaLangString, this.this$0.c, this.this$0.jdField_a_of_type_Long);
    TroopManager localTroopManager = (TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localTroopManager != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localTroopManager.b(this.this$0.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment.2
 * JD-Core Version:    0.7.0.1
 */