package com.tencent.mobileqq.activity;

import android.app.Activity;
import bflj;
import com.tencent.mobileqq.app.QQAppInterface;
import yyi;

final class DiscussionInfoCardActivity$17
  implements Runnable
{
  DiscussionInfoCardActivity$17(String paramString1, Activity paramActivity, String paramString2, String paramString3, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = "temp_discuss_link_share_" + this.jdField_a_of_type_JavaLangString + ".png";
    str = yyi.a(this.jdField_a_of_type_AndroidAppActivity, str, bflj.a(this.b, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new DiscussionInfoCardActivity.17.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.17
 * JD-Core Version:    0.7.0.1
 */