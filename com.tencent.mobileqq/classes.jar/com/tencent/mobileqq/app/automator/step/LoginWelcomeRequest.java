package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import zny;

public class LoginWelcomeRequest
  extends AsyncStep
{
  protected int a()
  {
    ThreadManager.postImmediately(new zny(this), null, false);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.LoginWelcomeRequest
 * JD-Core Version:    0.7.0.1
 */