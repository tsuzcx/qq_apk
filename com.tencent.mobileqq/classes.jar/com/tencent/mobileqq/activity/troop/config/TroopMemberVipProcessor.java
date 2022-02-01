package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.config.AbsTroopMemberListHandlerProcessor;
import com.tencent.mobileqq.utils.VipUtils;
import friendlist.stTroopMemberInfo;

public class TroopMemberVipProcessor
  extends AbsTroopMemberListHandlerProcessor
{
  public void a(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    if (paramstTroopMemberInfo == null) {
      return;
    }
    paramTroopMemberInfo.mVipType = ((int)paramstTroopMemberInfo.dwVipType);
    paramTroopMemberInfo.mVipLevel = VipUtils.c((int)paramstTroopMemberInfo.dwVipLevel);
    paramTroopMemberInfo.mVipTemplateId = ((int)paramstTroopMemberInfo.dwNameplate);
    paramTroopMemberInfo.mBigClubVipType = ((int)paramstTroopMemberInfo.dwBigClubFlag);
    paramTroopMemberInfo.mBigClubVipLevel = ((int)paramstTroopMemberInfo.dwBigClubLevel);
    paramTroopMemberInfo.mBigClubTemplateId = ((int)paramstTroopMemberInfo.dwNameplate);
    paramTroopMemberInfo.qqVipInfo = 0;
    paramTroopMemberInfo.superQqInfo = 0;
    paramTroopMemberInfo.superVipInfo = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopMemberVipProcessor
 * JD-Core Version:    0.7.0.1
 */