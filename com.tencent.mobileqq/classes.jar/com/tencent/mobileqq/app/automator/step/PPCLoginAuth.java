package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PPCLoginAuthHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.BaseApplication;

public class PPCLoginAuth
  extends AsyncStep
{
  protected int doStep()
  {
    SharedPreferences localSharedPreferences = this.mAutomator.a.getApp().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("lastPPCLoginAuthTime", 0L);
    if (System.currentTimeMillis() - l > 86400000L)
    {
      ((PPCLoginAuthHandler)this.mAutomator.a.getBusinessHandler(BusinessHandlerFactory.PPC_LOGIN_AUTH)).b();
      localSharedPreferences.edit().putLong("lastPPCLoginAuthTime", System.currentTimeMillis()).commit();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.PPCLoginAuth
 * JD-Core Version:    0.7.0.1
 */