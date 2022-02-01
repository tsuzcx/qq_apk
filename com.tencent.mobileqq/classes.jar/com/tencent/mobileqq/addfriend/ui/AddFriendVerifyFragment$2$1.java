package com.tencent.mobileqq.addfriend.ui;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;

class AddFriendVerifyFragment$2$1
  implements Runnable
{
  AddFriendVerifyFragment$2$1(AddFriendVerifyFragment.2 param2, String paramString) {}
  
  public void run()
  {
    if (AddFriendVerifyFragment.b(this.b.this$0).isShown())
    {
      TextView localTextView = AddFriendVerifyFragment.b(this.b.this$0);
      String str;
      if (TextUtils.isEmpty(this.b.a)) {
        str = this.a;
      } else {
        str = this.b.a;
      }
      localTextView.setText(str);
      if (AppSetting.e)
      {
        localTextView = AddFriendVerifyFragment.b(this.b.this$0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.ui.AddFriendVerifyFragment.2.1
 * JD-Core Version:    0.7.0.1
 */