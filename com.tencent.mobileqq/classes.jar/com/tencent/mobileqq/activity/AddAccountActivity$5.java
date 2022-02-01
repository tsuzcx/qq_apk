package com.tencent.mobileqq.activity;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.QQAppInterface;

final class AddAccountActivity$5
  implements Runnable
{
  AddAccountActivity$5(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    RecentDataListManager.a().a(this.a, BaseApplicationImpl.sApplication, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity.5
 * JD-Core Version:    0.7.0.1
 */