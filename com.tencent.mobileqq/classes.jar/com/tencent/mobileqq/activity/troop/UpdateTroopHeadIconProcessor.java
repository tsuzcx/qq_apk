package com.tencent.mobileqq.activity.troop;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.troop.api.config.AbsTroopInfoServiceProcessor;
import mqq.app.MobileQQ;

public class UpdateTroopHeadIconProcessor
  extends AbsTroopInfoServiceProcessor
{
  public void a(String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localQQAppInterface != null) {
      ((TroopHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).f(paramString, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.UpdateTroopHeadIconProcessor
 * JD-Core Version:    0.7.0.1
 */