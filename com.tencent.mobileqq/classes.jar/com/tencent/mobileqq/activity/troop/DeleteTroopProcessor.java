package com.tencent.mobileqq.activity.troop;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.api.config.AbsTroopInfoServiceProcessor;
import mqq.app.MobileQQ;

public class DeleteTroopProcessor
  extends AbsTroopInfoServiceProcessor
{
  public void a(String paramString)
  {
    Object localObject = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null)
    {
      localObject = (TroopManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject != null) {
        ((TroopManager)localObject).a(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.DeleteTroopProcessor
 * JD-Core Version:    0.7.0.1
 */