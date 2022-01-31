package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.qqprotect.qsec.QSecFramework;

public class StartQSecLogic
  extends AsyncStep
{
  protected int a()
  {
    if (this.b == 102) {
      QSecFramework.a().a();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.StartQSecLogic
 * JD-Core Version:    0.7.0.1
 */