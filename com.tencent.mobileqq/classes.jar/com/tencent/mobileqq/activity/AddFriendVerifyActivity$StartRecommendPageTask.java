package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import java.util.ArrayList;

class AddFriendVerifyActivity$StartRecommendPageTask
  implements Runnable
{
  private String a = null;
  private long b = System.currentTimeMillis();
  
  public AddFriendVerifyActivity$StartRecommendPageTask(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString)
  {
    Object localObject = paramAddFriendVerifyActivity.getIntent();
    int i = 0;
    if (((Intent)localObject).getIntExtra("friend_setting", 0) != 0) {
      i = 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("?_wv=1031&troopUin=");
    ((StringBuilder)localObject).append(paramAddFriendVerifyActivity.o);
    ((StringBuilder)localObject).append("&isVerify=");
    ((StringBuilder)localObject).append(i);
    this.a = ((StringBuilder)localObject).toString();
  }
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.this$0.x))
    {
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add("admin.qun.qq.com");
      EventApiPlugin.a("closeJoinWebView", null, (ArrayList)localObject, null);
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("start_recomend_page");
    this.this$0.sendBroadcast((Intent)localObject);
    localObject = new Intent(this.this$0, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.a);
    ((Intent)localObject).putExtra("hide_left_button", true);
    ((Intent)localObject).putExtra("show_right_close_button", true);
    ((Intent)localObject).putExtra("finish_animation_up_down", true);
    this.this$0.startActivity((Intent)localObject);
    this.this$0.overridePendingTransition(2130772014, 2130772007);
    AddFriendVerifyActivity.b(this.this$0, false);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.StartRecommendPageTask
 * JD-Core Version:    0.7.0.1
 */