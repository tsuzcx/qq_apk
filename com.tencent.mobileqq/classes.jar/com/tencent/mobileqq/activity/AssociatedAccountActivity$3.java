package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;

class AssociatedAccountActivity$3
  implements Runnable
{
  AssociatedAccountActivity$3(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshAllData isFinishing() = ");
      localStringBuilder.append(this.this$0.isFinishing());
      QLog.d("AssociatedAccountActivity", 2, localStringBuilder.toString());
    }
    if (this.this$0.isFinishing()) {
      return;
    }
    this.this$0.loadAccountList();
    this.this$0.loadItemDataList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.3
 * JD-Core Version:    0.7.0.1
 */