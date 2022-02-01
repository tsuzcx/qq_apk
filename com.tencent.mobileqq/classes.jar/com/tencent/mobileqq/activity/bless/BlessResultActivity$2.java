package com.tencent.mobileqq.activity.bless;

import bckg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class BlessResultActivity$2
  implements Runnable
{
  BlessResultActivity$2(BlessResultActivity paramBlessResultActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "VideoRedbag, BlessResultActivity doOnResume, sendRealNameCheckReq");
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      bckg.a((QQAppInterface)localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessResultActivity.2
 * JD-Core Version:    0.7.0.1
 */