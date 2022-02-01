package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.troop.troopconfig.api.ITroopConfigHandler;

public class GetTroopConfig
  extends AsyncStep
{
  protected int doStep()
  {
    if (this.mAutomator.k != null) {
      ((ITroopConfigHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.TROOP_CONFIG_HANDLER)).b();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetTroopConfig
 * JD-Core Version:    0.7.0.1
 */