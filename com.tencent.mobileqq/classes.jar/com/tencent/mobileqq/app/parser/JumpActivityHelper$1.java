package com.tencent.mobileqq.app.parser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;

final class JumpActivityHelper$1
  implements Runnable
{
  JumpActivityHelper$1(JumpActivity paramJumpActivity, Intent paramIntent, Bundle paramBundle) {}
  
  public void run()
  {
    JumpActivityHelper.c(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity);
    String str = this.jdField_a_of_type_AndroidContentIntent.getType();
    Uri localUri = this.jdField_a_of_type_AndroidContentIntent.getData();
    Intent localIntent = new Intent();
    int i;
    if ((str != null) && (str.startsWith("image")))
    {
      i = 1;
    }
    else
    {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("not_forward", true);
      i = 0;
    }
    this.jdField_a_of_type_AndroidOsBundle.putParcelable("android.intent.extra.STREAM", localUri);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtra("forward_type", i);
    localIntent.putExtra("forward_from_jump", true);
    localIntent.setData(localUri);
    localIntent.putExtra("sendMultiple", false);
    RouteUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity, localIntent, "/base/forwardRecent");
    this.jdField_a_of_type_ComTencentMobileqqActivityJumpActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.JumpActivityHelper.1
 * JD-Core Version:    0.7.0.1
 */