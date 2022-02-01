package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.config.AbsTroopMemberListHandlerProcessor;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelUtils;
import friendlist.stTroopMemberInfo;

public class TroopMemberLevelProcessor
  extends AbsTroopMemberListHandlerProcessor
{
  public void a(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    if (paramstTroopMemberInfo == null) {
      return;
    }
    paramTroopMemberInfo.realLevel = ((int)paramstTroopMemberInfo.dwMemberLevel);
    paramTroopMemberInfo.newRealLevel = TroopMemberLevelUtils.a(paramstTroopMemberInfo.vecGroupHonor);
    paramTroopMemberInfo.level = ((int)paramstTroopMemberInfo.dwTitleId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopMemberLevelProcessor
 * JD-Core Version:    0.7.0.1
 */