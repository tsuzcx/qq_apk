package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.qphone.base.util.QLog;

public class GetSecMsgConfigs
  extends AsyncStep
{
  protected int doStep()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "get SecMsgBaseInfo start in QQInitHandler...");
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSecMsgConfigs
 * JD-Core Version:    0.7.0.1
 */