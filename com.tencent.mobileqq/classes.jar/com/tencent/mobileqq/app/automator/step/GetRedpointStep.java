package com.tencent.mobileqq.app.automator.step;

import alwx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.qphone.base.util.QLog;

public class GetRedpointStep
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GetRedpointStep", 2, "GetRedpointStep");
    }
    ((alwx)this.a.app.a(87)).a(false, false);
    ((MedalWallMng)this.a.app.getManager(250)).a();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetRedpointStep
 * JD-Core Version:    0.7.0.1
 */