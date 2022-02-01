package com.tencent.mobileqq.activity;

import aegr;
import azkz;
import com.tencent.qphone.base.util.QLog;

public class FriendProfileCardActivity$20$1
  implements Runnable
{
  public FriendProfileCardActivity$20$1(aegr paramaegr, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aegr.a.d != null) {
      try
      {
        if ("profile_btn_config".equals(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_Aegr.a.a(true);
          return;
        }
        if (("profile_switch_config".equals(this.jdField_a_of_type_JavaLangString)) && (FriendProfileCardActivity.a(this.jdField_a_of_type_Aegr.a) != null))
        {
          FriendProfileCardActivity.a(this.jdField_a_of_type_Aegr.a).b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.20.1
 * JD-Core Version:    0.7.0.1
 */