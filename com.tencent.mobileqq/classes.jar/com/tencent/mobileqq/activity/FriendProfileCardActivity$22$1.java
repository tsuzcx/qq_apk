package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.qphone.base.util.QLog;

class FriendProfileCardActivity$22$1
  implements Runnable
{
  FriendProfileCardActivity$22$1(FriendProfileCardActivity.22 param22, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$22.a.d != null) {
      try
      {
        if ("profile_btn_config".equals(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$22.a.a(true);
          return;
        }
        if (("profile_switch_config".equals(this.jdField_a_of_type_JavaLangString)) && (FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$22.a) != null))
        {
          FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$22.a).notifyCardUpdate();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("FriendProfileCardActivity", 1, "onConfigUpdate fail.", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.22.1
 * JD-Core Version:    0.7.0.1
 */