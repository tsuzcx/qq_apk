package com.tencent.mobileqq.activity;

import abyo;
import bdcd;
import bdfq;

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
      this.this$0.a = bdcd.a(this.this$0, 230);
      this.this$0.a.setMessage(2131721022);
      abyo localabyo = new abyo(this);
      this.this$0.a.setPositiveButton(2131691088, localabyo);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.30
 * JD-Core Version:    0.7.0.1
 */