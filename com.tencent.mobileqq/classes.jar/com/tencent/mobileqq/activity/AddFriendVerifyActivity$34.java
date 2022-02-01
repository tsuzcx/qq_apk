package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class AddFriendVerifyActivity$34
  implements Runnable
{
  AddFriendVerifyActivity$34(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void run()
  {
    if (this.this$0.a != null) {
      if (!this.this$0.a.isShowing()) {
        this.this$0.a.show();
      }
    }
    do
    {
      return;
      this.this$0.a = DialogUtil.a(this.this$0, 230);
      this.this$0.a.setMessage(2131720178);
      AddFriendVerifyActivity.34.1 local1 = new AddFriendVerifyActivity.34.1(this);
      this.this$0.a.setPositiveButton(2131691144, local1);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.34
 * JD-Core Version:    0.7.0.1
 */