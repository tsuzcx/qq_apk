package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mqp.app.sec.ScConfigManager;

public class CheckSafeCenterConfig
  extends AsyncStep
{
  protected int doStep()
  {
    if (this.mStepId == 97) {
      ScConfigManager.a().a(this.mAutomator.k, "SecCenterConfig");
    } else if (this.mStepId == 98) {
      ScConfigManager.a().a(this.mAutomator.k, "SecCenterConfig", true);
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckSafeCenterConfig
 * JD-Core Version:    0.7.0.1
 */