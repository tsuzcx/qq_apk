package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.qphone.base.util.QLog;

public class GetSubAccountSpecialCare
  extends AsyncStep
{
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "GetSubAccountSpecialCare step...");
    }
    if ((this.b == 95) && ((SubAccountControll.b(this.a.b, true)) || (SubAccountControll.c(this.a.b, true)))) {
      SubAccountControll.a(this.a.b, false);
    }
    SubAccountControll.b(this.a.b, true, null);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSubAccountSpecialCare
 * JD-Core Version:    0.7.0.1
 */