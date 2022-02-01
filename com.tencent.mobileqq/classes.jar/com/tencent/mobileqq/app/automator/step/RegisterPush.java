package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import mqq.observer.AccountObserver;

public class RegisterPush
  extends AsyncStep
{
  private AccountObserver a;
  
  protected int doStep()
  {
    this.mAutomator.a.getMsgHandler().m();
    this.mAutomator.a.sendRegisterPush();
    return 2;
  }
  
  public void onCreate()
  {
    if (this.mStepId == 13) {
      this.mCountRetry = 0;
    } else {
      this.mCountRetry = 10;
    }
    this.a = new RegisterPush.MyAccountObserver(this, null);
    this.mAutomator.a.registObserver(this.a);
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.mAutomator.a.unRegistObserver(this.a);
      this.a = null;
    }
    if ((this.mStepId == 12) && (this.mResult == 6)) {
      this.mAutomator.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterPush
 * JD-Core Version:    0.7.0.1
 */