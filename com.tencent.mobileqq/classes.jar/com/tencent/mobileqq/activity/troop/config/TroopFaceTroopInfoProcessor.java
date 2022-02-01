package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.api.config.AbsTroopInfoHandlerProcessor;
import com.tencent.mobileqq.troop.avatar.api.ITroopAvatarService;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public class TroopFaceTroopInfoProcessor
  extends AbsTroopInfoHandlerProcessor
{
  public void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    int i;
    if (paramGroupInfo.uint32_is_conf_group.get() == 1) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramGroupInfo.uint32_is_modify_conf_group_face.get() == 1) {
      j = 1;
    } else {
      j = 0;
    }
    int k = paramGroupInfo.uint32_group_member_num.get();
    if ((i != 0) && (j == 0) && (k > 1)) {
      ((ITroopAvatarService)paramAppInterface.getRuntimeService(ITroopAvatarService.class, "")).updateGroupIcon(paramTroopInfo.troopuin, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopFaceTroopInfoProcessor
 * JD-Core Version:    0.7.0.1
 */