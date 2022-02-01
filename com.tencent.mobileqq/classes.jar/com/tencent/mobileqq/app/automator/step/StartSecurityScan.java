package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class StartSecurityScan
  extends AsyncStep
{
  protected int doStep()
  {
    if (this.mAutomator.a.isNeedSecurityScan()) {
      this.mAutomator.a.startSecurityScan();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.StartSecurityScan
 * JD-Core Version:    0.7.0.1
 */