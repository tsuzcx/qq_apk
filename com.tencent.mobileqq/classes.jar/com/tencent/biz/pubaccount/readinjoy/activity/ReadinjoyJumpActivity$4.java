package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;

final class ReadinjoyJumpActivity$4
  implements Runnable
{
  ReadinjoyJumpActivity$4(long paramLong, Intent paramIntent, Context paramContext) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("jump_article_param_ids", this.jdField_a_of_type_Long);
    localIntent.putExtra("jump_activity_launch_from", this.jdField_a_of_type_AndroidContentIntent.getIntExtra("jump_activity_launch_from", 0));
    PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, localIntent, ReadinjoyJumpActivity.class);
    QLog.d("ReadinjoyJumpActivity", 2, "start activity!");
    ReadinjoyJumpActivity.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyJumpActivity.4
 * JD-Core Version:    0.7.0.1
 */