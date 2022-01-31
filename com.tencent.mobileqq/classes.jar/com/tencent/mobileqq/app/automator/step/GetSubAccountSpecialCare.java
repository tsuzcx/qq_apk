package com.tencent.mobileqq.app.automator.step;

import ayaq;
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
    if ((this.b == 95) && ((ayaq.b(this.a.app, true)) || (ayaq.c(this.a.app, true)))) {
      ayaq.a(this.a.app, false);
    }
    ayaq.b(this.a.app, true, null);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSubAccountSpecialCare
 * JD-Core Version:    0.7.0.1
 */