package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import axrm;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

class JumpActivity$4
  implements Runnable
{
  JumpActivity$4(JumpActivity paramJumpActivity, Intent paramIntent, Bundle paramBundle) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_AndroidContentIntent.getType();
    Uri localUri = this.jdField_a_of_type_AndroidContentIntent.getData();
    axrm.a(this.this$0.app.getApplication().getApplicationContext(), this.this$0.app.getCurrentAccountUin(), "dl_open_via_qq");
    Intent localIntent = new Intent(this.this$0, ForwardRecentActivity.class);
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
      this.this$0.startActivity(localIntent);
      this.this$0.finish();
      return;
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("not_forward", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity.4
 * JD-Core Version:    0.7.0.1
 */