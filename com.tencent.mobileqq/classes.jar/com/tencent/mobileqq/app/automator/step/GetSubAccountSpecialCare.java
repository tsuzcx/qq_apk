package com.tencent.mobileqq.app.automator.step;

import azyl;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class GetSubAccountSpecialCare
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "GetSubAccountSpecialCare step...");
    }
    if ((this.b == 95) && ((azyl.b(this.a.app, true)) || (azyl.c(this.a.app, true)))) {
      azyl.a(this.a.app, false);
    }
    azyl.b(this.a.app, true, null);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSubAccountSpecialCare
 * JD-Core Version:    0.7.0.1
 */