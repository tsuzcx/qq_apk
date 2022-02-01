package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.config.AbsTroopMemberListHandlerProcessor;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.ColorNickManager.ColorNickNameData;
import friendlist.stTroopMemberInfo;

public class TroopMemberColorNickProcessor
  extends AbsTroopMemberListHandlerProcessor
{
  public void a(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    if (paramstTroopMemberInfo == null) {
      return;
    }
    d(paramTroopMemberInfo, paramstTroopMemberInfo);
  }
  
  public void b(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    if (paramstTroopMemberInfo == null) {
      return;
    }
    c(paramTroopMemberInfo, paramstTroopMemberInfo);
    d(paramTroopMemberInfo, paramstTroopMemberInfo);
  }
  
  public void c(TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    paramstTroopMemberInfo = ColorNickManager.a(paramstTroopMemberInfo.vecName);
    if (TextUtils.isEmpty(paramstTroopMemberInfo))
    {
      paramTroopMemberInfo.pyFirst_troopnick = "";
      paramTroopMemberInfo.pyAll_troopnick = "";
      return;
    }
    if (!paramstTroopMemberInfo.equals(paramTroopMemberInfo.troopnick))
    {
      paramTroopMemberInfo.pyFirst_troopnick = ChnToSpell.b(paramstTroopMemberInfo, 2);
      paramTroopMemberInfo.pyAll_troopnick = ChnToSpell.b(paramstTroopMemberInfo, 1);
      return;
    }
    if (TextUtils.isEmpty(paramTroopMemberInfo.pyFirst_troopnick)) {
      paramTroopMemberInfo.pyFirst_troopnick = ChnToSpell.b(paramstTroopMemberInfo, 2);
    }
    if (TextUtils.isEmpty(paramTroopMemberInfo.pyAll_troopnick)) {
      paramTroopMemberInfo.pyAll_troopnick = ChnToSpell.b(paramstTroopMemberInfo, 1);
    }
  }
  
  public void d(TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    if (paramstTroopMemberInfo.cRichCardNameVer != 1)
    {
      paramTroopMemberInfo.troopColorNick = ColorNickManager.a(paramstTroopMemberInfo.vecName);
      paramTroopMemberInfo.troopnick = ColorNickManager.b(paramTroopMemberInfo.troopColorNick);
      return;
    }
    ColorNickManager.ColorNickNameData localColorNickNameData = ColorNickManager.d(paramstTroopMemberInfo.vecName);
    if (localColorNickNameData.a == null) {
      paramstTroopMemberInfo = "";
    } else {
      paramstTroopMemberInfo = localColorNickNameData.a;
    }
    paramTroopMemberInfo.troopColorNick = paramstTroopMemberInfo;
    paramTroopMemberInfo.troopColorNickId = localColorNickNameData.b;
    paramTroopMemberInfo.troopnick = ColorNickManager.b(paramTroopMemberInfo.troopColorNick);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopMemberColorNickProcessor
 * JD-Core Version:    0.7.0.1
 */