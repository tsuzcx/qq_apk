package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import armm;
import java.util.ArrayList;

public class AddFriendVerifyActivity$StartRecommendPageTask
  implements Runnable
{
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private String jdField_a_of_type_JavaLangString;
  
  public AddFriendVerifyActivity$StartRecommendPageTask(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString)
  {
    if (paramAddFriendVerifyActivity.getIntent().getIntExtra("friend_setting", 0) != 0) {
      i = 1;
    }
    this.jdField_a_of_type_JavaLangString = (paramString + "?_wv=1031&troopUin=" + paramAddFriendVerifyActivity.jdField_a_of_type_JavaLangString + "&isVerify=" + i);
  }
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.this$0.d))
    {
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add("admin.qun.qq.com");
      armm.a("closeJoinWebView", null, (ArrayList)localObject, null);
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("start_recomend_page");
    this.this$0.sendBroadcast((Intent)localObject);
    localObject = new Intent(this.this$0, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("hide_left_button", true);
    ((Intent)localObject).putExtra("show_right_close_button", true);
    ((Intent)localObject).putExtra("finish_animation_up_down", true);
    this.this$0.startActivity((Intent)localObject);
    this.this$0.overridePendingTransition(2130771997, 2130771990);
    AddFriendVerifyActivity.a(this.this$0, false);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.StartRecommendPageTask
 * JD-Core Version:    0.7.0.1
 */