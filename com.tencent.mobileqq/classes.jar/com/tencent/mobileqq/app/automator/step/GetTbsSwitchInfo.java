package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.AsyncStep;

public class GetTbsSwitchInfo
  extends AsyncStep
{
  protected int doStep()
  {
    ThreadManagerV2.excute(new GetTbsSwitchInfo.1(this), 128, null, false);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetTbsSwitchInfo
 * JD-Core Version:    0.7.0.1
 */