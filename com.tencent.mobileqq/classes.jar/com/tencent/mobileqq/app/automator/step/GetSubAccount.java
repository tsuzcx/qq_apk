package com.tencent.mobileqq.app.automator.step;

import bada;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class GetSubAccount
  extends AsyncStep
{
  public int a()
  {
    bada localbada = (bada)this.a.app.getManager(28);
    if (localbada != null) {
      localbada.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "subaccount onGetSubAccountBind start int QQInitHandler...");
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSubAccount
 * JD-Core Version:    0.7.0.1
 */