package com.tencent.mobileqq.activity;

import android.app.Activity;
import baui;
import com.tencent.mobileqq.app.QQAppInterface;
import wij;

final class DiscussionInfoCardActivity$18
  implements Runnable
{
  DiscussionInfoCardActivity$18(String paramString1, Activity paramActivity, String paramString2, String paramString3, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = "temp_discuss_link_share_" + this.jdField_a_of_type_JavaLangString + ".png";
    str = wij.a(this.jdField_a_of_type_AndroidAppActivity, str, baui.a(this.b, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new DiscussionInfoCardActivity.18.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.18
 * JD-Core Version:    0.7.0.1
 */