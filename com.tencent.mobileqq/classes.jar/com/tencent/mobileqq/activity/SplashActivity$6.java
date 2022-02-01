package com.tencent.mobileqq.activity;

import bdcw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class SplashActivity$6
  implements Runnable
{
  SplashActivity$6(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashActivity", 2, "VideoRedbag, SplashActivity doOnResume, sendRealNameCheckReq");
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      bdcw.a((QQAppInterface)localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivity.6
 * JD-Core Version:    0.7.0.1
 */