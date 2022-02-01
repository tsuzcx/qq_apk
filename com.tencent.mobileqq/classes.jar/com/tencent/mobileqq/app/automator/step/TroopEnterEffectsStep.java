package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IRequestTroopEnterEffectInfoCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig.EffectInfo;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

public class TroopEnterEffectsStep
  extends AsyncStep
  implements IRequestTroopEnterEffectInfoCallback
{
  protected int doStep()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "TroopEnterEffectsStep: doStep");
    }
    long l = SharedPreUtils.c(this.mAutomator.a.getApplication(), this.mAutomator.a.getCurrentAccountUin());
    TroopEnterEffectConfig localTroopEnterEffectConfig = ((ITroopEnterEffectService)this.mAutomator.a.getRuntimeService(ITroopEnterEffectService.class, "all")).getTroopEnterEffectConfig();
    if ((l != 0L) && (localTroopEnterEffectConfig.a != null) && ((System.currentTimeMillis() - l) / 1000L <= localTroopEnterEffectConfig.a.a)) {
      return 7;
    }
    ((IApolloExtensionHandler)this.mAutomator.a.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(2L, 0L);
    return 2;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.TroopEnterEffectsStep
 * JD-Core Version:    0.7.0.1
 */