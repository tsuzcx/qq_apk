package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedpointHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.qphone.base.util.QLog;

public class GetRedpointStep
  extends AsyncStep
{
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GetRedpointStep", 2, "GetRedpointStep");
    }
    ((RedpointHandler)this.a.b.a(87)).a(false, false);
    ((MedalWallMng)this.a.b.getManager(249)).a();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetRedpointStep
 * JD-Core Version:    0.7.0.1
 */