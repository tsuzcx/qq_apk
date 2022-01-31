package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mqp.app.sec.ScConfigManager;

public class CheckSafeCenterConfig
  extends AsyncStep
{
  protected int a()
  {
    if (this.b == 97) {
      ScConfigManager.a().a(this.a.b, "SecCenterConfig");
    }
    for (;;)
    {
      return 7;
      if (this.b == 98) {
        ScConfigManager.a().a(this.a.b, "SecCenterConfig", true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckSafeCenterConfig
 * JD-Core Version:    0.7.0.1
 */