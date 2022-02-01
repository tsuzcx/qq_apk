package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class TroopInviteStatusFragment$3
  implements Runnable
{
  TroopInviteStatusFragment$3(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
      localIntent.putExtra("uin", this.this$0.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", this.this$0.b);
      localIntent.putExtra("troop_uin", this.this$0.jdField_a_of_type_JavaLangString);
      this.this$0.startActivity(localIntent);
      this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment.3
 * JD-Core Version:    0.7.0.1
 */