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
    if (this.this$0.a != null)
    {
      if (!this.this$0.a.isShowing()) {
        this.this$0.a.show();
      }
      return;
    }
    Object localObject = this.this$0;
    ((AddFriendVerifyActivity)localObject).a = DialogUtil.a((Context)localObject, 230);
    this.this$0.a.setMessage(2131694463);
    localObject = new AddFriendVerifyActivity.35.1(this);
    this.this$0.a.setPositiveButton(2131691064, (DialogInterface.OnClickListener)localObject);
    if (!this.this$0.a.isShowing()) {
      this.this$0.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.35
 * JD-Core Version:    0.7.0.1
 */