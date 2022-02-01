package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class AddFriendVerifyActivity$35
  implements Runnable
{
  AddFriendVerifyActivity$35(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void run()
  {
    if (this.this$0.E != null)
    {
      if (!this.this$0.E.isShowing()) {
        this.this$0.E.show();
      }
      return;
    }
    Object localObject = this.this$0;
    ((AddFriendVerifyActivity)localObject).E = DialogUtil.a((Context)localObject, 230);
    this.this$0.E.setMessage(2131892143);
    localObject = new AddFriendVerifyActivity.35.1(this);
    this.this$0.E.setPositiveButton(2131888010, (DialogInterface.OnClickListener)localObject);
    if (!this.this$0.E.isShowing()) {
      this.this$0.E.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.35
 * JD-Core Version:    0.7.0.1
 */