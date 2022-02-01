package com.tencent.mobileqq.app.parser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import aoud;
import bdlq;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

public final class JumpActivityHelper$3
  implements Runnable
{
  public JumpActivityHelper$3(JumpActivity paramJumpActivity, Intent paramIntent, Bundle paramBundle) {}
  
  public void run()
  {
    aoud.e(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity);
    String str = this.jdField_a_of_type_AndroidContentIntent.getType();
    Uri localUri = this.jdField_a_of_type_AndroidContentIntent.getData();
    bdlq.a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.app.getCurrentAccountUin(), "dl_open_via_qq");
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, ForwardRecentActivity.class);
    if ((str != null) && (str.startsWith("image"))) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_AndroidOsBundle.putParcelable("android.intent.extra.STREAM", localUri);
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      localIntent.putExtra("isFromShare", true);
      localIntent.putExtra("forward_type", i);
      localIntent.putExtra("forward_from_jump", true);
      localIntent.setData(localUri);
      localIntent.putExtra("sendMultiple", false);
      this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.startActivity(localIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
      return;
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("not_forward", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.JumpActivityHelper.3
 * JD-Core Version:    0.7.0.1
 */