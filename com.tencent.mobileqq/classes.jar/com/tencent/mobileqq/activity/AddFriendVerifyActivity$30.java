package com.tencent.mobileqq.activity;

import adgo;
import bhdj;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class AddFriendVerifyActivity$30
  implements Runnable
{
  AddFriendVerifyActivity$30(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
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
      this.this$0.a = bhdj.a(this.this$0, 230);
      this.this$0.a.setMessage(2131719600);
      adgo localadgo = new adgo(this);
      this.this$0.a.setPositiveButton(2131691037, localadgo);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.30
 * JD-Core Version:    0.7.0.1
 */