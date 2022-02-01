package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.hiddenchat.TroopStatusUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.api.config.AbsTroopInfoHandlerProcessor;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public class HiddenChatTroopInfoProcessor
  extends AbsTroopInfoHandlerProcessor
{
  public void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if (((paramAppInterface instanceof QQAppInterface)) && (paramGroupInfo.uint32_cmduin_flag_ex2.has()) && (paramGroupInfo.uint32_cmduin_flag_ex2.get() != paramTroopInfo.cmdUinFlagEx2))
    {
      int i;
      if (TroopInfo.isCmdUinFlagEx2Open(paramTroopInfo.cmdUinFlagEx2, 512) != TroopInfo.isCmdUinFlagEx2Open(paramGroupInfo.uint32_cmduin_flag_ex2.get(), 512)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        TroopStatusUtil.a((QQAppInterface)paramAppInterface, paramTroopInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.HiddenChatTroopInfoProcessor
 * JD-Core Version:    0.7.0.1
 */