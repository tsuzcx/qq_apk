package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.qqprotect.qsec.QSecFramework;

public class StartQSecLogic
  extends AsyncStep
{
  protected int doStep()
  {
    if (this.mStepId == 102) {
      QSecFramework.c().d();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.StartQSecLogic
 * JD-Core Version:    0.7.0.1
 */