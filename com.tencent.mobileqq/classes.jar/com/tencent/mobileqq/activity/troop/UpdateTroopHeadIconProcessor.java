package com.tencent.mobileqq.activity.troop;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.config.AbsTroopInfoServiceProcessor;
import com.tencent.mobileqq.troop.avatar.api.ITroopAvatarService;
import mqq.app.MobileQQ;

public class UpdateTroopHeadIconProcessor
  extends AbsTroopInfoServiceProcessor
{
  public void a(String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localQQAppInterface != null) {
      ((ITroopAvatarService)localQQAppInterface.getRuntimeService(ITroopAvatarService.class, "")).updateGroupIcon(paramString, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.UpdateTroopHeadIconProcessor
 * JD-Core Version:    0.7.0.1
 */