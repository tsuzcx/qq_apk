package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.ITimiGameApi;

public class TimiGameLoginResumeStep
  extends AsyncStep
{
  protected int doStep()
  {
    boolean bool;
    if (this.mStepId == 119) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TimiGameLoginResumeStep, isLoginOrReconnect = ");
      localStringBuilder.append(bool);
      QLog.d("QQInitHandler", 2, localStringBuilder.toString());
    }
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).doWhenQQLogin(bool);
    return super.doStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.TimiGameLoginResumeStep
 * JD-Core Version:    0.7.0.1
 */