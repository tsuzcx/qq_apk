package com.tencent.mobileqq.app.automator.step;

import com.tencent.mezs.a;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class SignatureScan
  extends AsyncStep
{
  protected int doStep()
  {
    new a(this.mAutomator.k).a(false);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.SignatureScan
 * JD-Core Version:    0.7.0.1
 */