package com.tencent.mobileqq.activity;

import acqe;
import bfur;
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
      this.this$0.a = bfur.a(this.this$0, 230);
      this.this$0.a.setMessage(2131719180);
      acqe localacqe = new acqe(this);
      this.this$0.a.setPositiveButton(2131690952, localacqe);
    } while (this.this$0.a.isShowing());
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.30
 * JD-Core Version:    0.7.0.1
 */