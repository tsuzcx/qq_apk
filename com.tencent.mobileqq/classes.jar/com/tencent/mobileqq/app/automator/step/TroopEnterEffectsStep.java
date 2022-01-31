package com.tencent.mobileqq.app.automator.step;

import azrf;
import azrh;
import azrw;
import bbjn;
import bbqp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class TroopEnterEffectsStep
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "TroopEnterEffectsStep: doStep");
    }
    long l = bbjn.f(this.a.app.getApplication(), this.a.app.getCurrentAccountUin());
    azrf localazrf = ((azrw)this.a.app.getManager(231)).a();
    if ((l == 0L) || (localazrf.a == null) || ((System.currentTimeMillis() - l) / 1000L > localazrf.a.a))
    {
      ((bbqp)this.a.app.a(71)).a(2L, 0L);
      return 2;
    }
    return 7;
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.TroopEnterEffectsStep
 * JD-Core Version:    0.7.0.1
 */