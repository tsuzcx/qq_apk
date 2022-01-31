package com.tencent.mobileqq.app.automator.step;

import azrh;
import azrj;
import azry;
import bbkb;
import bbrd;
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
    long l = bbkb.f(this.a.app.getApplication(), this.a.app.getCurrentAccountUin());
    azrh localazrh = ((azry)this.a.app.getManager(231)).a();
    if ((l == 0L) || (localazrh.a == null) || ((System.currentTimeMillis() - l) / 1000L > localazrh.a.a))
    {
      ((bbrd)this.a.app.a(71)).a(2L, 0L);
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