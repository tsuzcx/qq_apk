package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;

class AssociatedAccountActivity$2
  implements Runnable
{
  AssociatedAccountActivity$2(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "refreshAllData isFinishing() = " + this.this$0.isFinishing());
    }
    if (this.this$0.isFinishing()) {
      return;
    }
    AssociatedAccountActivity.a(this.this$0);
    AssociatedAccountActivity.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.2
 * JD-Core Version:    0.7.0.1
 */