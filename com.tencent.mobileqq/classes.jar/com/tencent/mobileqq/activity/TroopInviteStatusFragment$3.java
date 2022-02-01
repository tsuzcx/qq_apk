package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;

class TroopInviteStatusFragment$3
  implements Runnable
{
  TroopInviteStatusFragment$3(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (!this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()))
    {
      Intent localIntent = AIOUtils.a(new Intent(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class), null);
      localIntent.putExtra("uin", this.this$0.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", this.this$0.b);
      localIntent.putExtra("troop_uin", this.this$0.jdField_a_of_type_JavaLangString);
      this.this$0.startActivity(localIntent);
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment.3
 * JD-Core Version:    0.7.0.1
 */