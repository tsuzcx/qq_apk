package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.api.config.AbsTroopInfoHandlerProcessor;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public class RingUpdateTroopInfoProcessor
  extends AbsTroopInfoHandlerProcessor
{
  public void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (paramGroupInfo.uint32_cmduin_ringtone_id.has()) && (paramGroupInfo.uint32_cmduin_ringtone_id.get() != paramTroopInfo.udwCmdUinRingtoneID) && (paramGroupInfo.uint32_cmduin_ringtone_id.get() != 0)) {
      MessageNotificationSettingManager.a((QQAppInterface)paramAppInterface).a(paramGroupInfo.uint32_cmduin_ringtone_id.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.RingUpdateTroopInfoProcessor
 * JD-Core Version:    0.7.0.1
 */