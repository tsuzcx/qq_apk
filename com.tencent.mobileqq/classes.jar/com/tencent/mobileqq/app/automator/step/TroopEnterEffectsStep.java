package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler.IRequestTroopEnterEffectInfoCallback;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectConfig;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectConfig.EffectInfo;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;

public class TroopEnterEffectsStep
  extends AsyncStep
  implements TroopHandler.IRequestTroopEnterEffectInfoCallback
{
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "TroopEnterEffectsStep: doStep");
    }
    long l = SharedPreUtils.g(this.a.b.getApplication(), this.a.b.getCurrentAccountUin());
    TroopEnterEffectConfig localTroopEnterEffectConfig = ((TroopEnterEffectManager)this.a.b.getManager(230)).a();
    if ((l == 0L) || (localTroopEnterEffectConfig.a == null) || ((System.currentTimeMillis() - l) / 1000L > localTroopEnterEffectConfig.a.a))
    {
      ((VasExtensionHandler)this.a.b.a(71)).a(2L, 0L);
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