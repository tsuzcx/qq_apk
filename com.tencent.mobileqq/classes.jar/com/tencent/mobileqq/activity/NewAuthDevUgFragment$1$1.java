package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;

class NewAuthDevUgFragment$1$1
  implements Runnable
{
  NewAuthDevUgFragment$1$1(NewAuthDevUgFragment.1 param1) {}
  
  public void run()
  {
    if (this.a.a.getQBaseActivity() == null)
    {
      QLog.d("NewAuthDevUgFragment", 1, "activity is null");
      return;
    }
    this.a.a.getQBaseActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NewAuthDevUgFragment.1.1
 * JD-Core Version:    0.7.0.1
 */