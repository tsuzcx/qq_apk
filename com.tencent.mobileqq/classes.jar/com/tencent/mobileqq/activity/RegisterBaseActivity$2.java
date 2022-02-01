package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class RegisterBaseActivity$2
  implements Runnable
{
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.this$0, 230);
    localQQCustomDialog.setTitle(this.a);
    localQQCustomDialog.setMessage(this.b);
    localQQCustomDialog.setPositiveButton(2131897869, new RegisterBaseActivity.2.1(this));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */