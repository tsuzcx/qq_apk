package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;

class AddFriendVerifyActivity$5$1
  implements Runnable
{
  AddFriendVerifyActivity$5$1(AddFriendVerifyActivity.5 param5, String paramString) {}
  
  public void run()
  {
    if (AddFriendVerifyActivity.f(this.b.this$0).isShown())
    {
      TextView localTextView = AddFriendVerifyActivity.f(this.b.this$0);
      String str;
      if (TextUtils.isEmpty(this.b.a)) {
        str = this.a;
      } else {
        str = this.b.a;
      }
      localTextView.setText(str);
      if (AppSetting.e)
      {
        localTextView = AddFriendVerifyActivity.f(this.b.this$0);
        if (TextUtils.isEmpty(this.b.a)) {
          str = this.a;
        } else {
          str = this.b.a;
        }
        localTextView.setContentDescription(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.5.1
 * JD-Core Version:    0.7.0.1
 */