package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.qphone.base.util.QLog;
import zqo;

public class GetBigEmoticonStep
  extends AsyncStep
{
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GetBigEmoticonStep", 2, "doStep begins");
    }
    ThreadManager.post(new zqo(this), 5, null, false);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetBigEmoticonStep
 * JD-Core Version:    0.7.0.1
 */