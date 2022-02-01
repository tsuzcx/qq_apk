package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.config.AbsTroopListHandlerProcessor;

public class RingUpdateTroopListProcessor
  extends AbsTroopListHandlerProcessor
{
  public void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      MessageNotificationSettingManager.a((QQAppInterface)paramAppInterface).a((int)paramTroopInfo.udwCmdUinRingtoneID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.RingUpdateTroopListProcessor
 * JD-Core Version:    0.7.0.1
 */