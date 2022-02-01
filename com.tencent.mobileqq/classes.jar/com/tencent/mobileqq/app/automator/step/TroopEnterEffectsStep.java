package com.tencent.mobileqq.app.automator.step;

import beuk;
import beum;
import bevb;
import bgsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;

public class TroopEnterEffectsStep
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "TroopEnterEffectsStep: doStep");
    }
    long l = bgsg.f(this.a.app.getApplication(), this.a.app.getCurrentAccountUin());
    beuk localbeuk = ((bevb)this.a.app.getManager(231)).a();
    if ((l == 0L) || (localbeuk.a == null) || ((System.currentTimeMillis() - l) / 1000L > localbeuk.a.a))
    {
      ((VasExtensionHandler)this.a.app.a(71)).a(2L, 0L);
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