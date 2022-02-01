package com.tencent.mobileqq.app.automator.step;

import bfkf;
import bfkh;
import bfkw;
import bhhr;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
    long l = bhhr.f(this.a.app.getApplication(), this.a.app.getCurrentAccountUin());
    bfkf localbfkf = ((bfkw)this.a.app.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER)).a();
    if ((l == 0L) || (localbfkf.a == null) || ((System.currentTimeMillis() - l) / 1000L > localbfkf.a.a))
    {
      ((VasExtensionHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(2L, 0L);
      return 2;
    }
    return 7;
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.TroopEnterEffectsStep
 * JD-Core Version:    0.7.0.1
 */