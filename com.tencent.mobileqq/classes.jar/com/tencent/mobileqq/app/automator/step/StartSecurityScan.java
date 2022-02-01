package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class StartSecurityScan
  extends AsyncStep
{
  protected int doStep()
  {
    if (this.mAutomator.k.isNeedSecurityScan()) {
      this.mAutomator.k.startSecurityScan();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.StartSecurityScan
 * JD-Core Version:    0.7.0.1
 */