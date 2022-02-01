package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.LoginFailedHelper.FrozenDialogCallback;
import com.tencent.mobileqq.app.QQAppInterface;

class AddAccountActivity$4$2
  implements LoginFailedHelper.FrozenDialogCallback
{
  AddAccountActivity$4$2(AddAccountActivity.4 param4) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    AddAccountActivity.access$202(this.a.a, paramBoolean);
    if (paramBoolean) {
      this.a.a.app.unRegistObserver(AddAccountActivity.access$300(this.a.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity.4.2
 * JD-Core Version:    0.7.0.1
 */