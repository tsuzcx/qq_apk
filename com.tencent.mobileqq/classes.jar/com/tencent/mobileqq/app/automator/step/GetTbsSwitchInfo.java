package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import znv;

public class GetTbsSwitchInfo
  extends AsyncStep
{
  protected int a()
  {
    ThreadManager.post(new znv(this), 8, null, false);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetTbsSwitchInfo
 * JD-Core Version:    0.7.0.1
 */