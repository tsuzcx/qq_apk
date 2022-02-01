package com.tencent.mobileqq.activity;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.abtest.ABTestController;

final class LoginActivity$2
  implements Runnable
{
  LoginActivity$2(String paramString) {}
  
  public void run()
  {
    ABTestController.a().a(BaseApplicationImpl.sApplication, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginActivity.2
 * JD-Core Version:    0.7.0.1
 */