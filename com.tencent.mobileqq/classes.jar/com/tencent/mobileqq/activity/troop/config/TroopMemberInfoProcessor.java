package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.troop.api.config.AbsTroopHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.IGetTroopMemberInfoObserver;
import com.tencent.mobileqq.troop.api.config.IParseTroopMemberInfoObserver;
import com.tencent.mobileqq.troop.honor.util.TroopHonorUtils;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.ColorNickManager.ColorNickNameData;
import friendlist.stTroopMemberInfo;
import friendlist.stTroopRemarkInfo;
import java.util.ArrayList;
import tencent.im.group.group_member_info.MemberInfo;

public class TroopMemberInfoProcessor
  extends AbsTroopHandlerProcessor
  implements IGetTroopMemberInfoObserver, IParseTroopMemberInfoObserver
{
  @NonNull
  public String a()
  {
    return "TroopMemberInfoProcessor";
  }
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString, long paramLong)
  {
    if (((QQAppInterface)paramAppInterface).getWritableDatabase() != null) {
      ((QQAppInterface)paramAppInterface).getWritableDatabase().delete(new TroopMemberInfo().getTableName(), "troopuin=? and memberuin<>? and memberuin<>? and datetime<?", new String[] { paramString, "1000000", "10000", String.valueOf(paramLong) });
    }
  }
  
  public void a(@NonNull TroopInfo paramTroopInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    if (paramstTroopMemberInfo == null) {
      return;
    }
    paramTroopInfo.myHonorList = TroopHonorUtils.a(paramstTroopMemberInfo.vecGroupHonor);
    paramTroopInfo.myHonorRichFlag = paramstTroopMemberInfo.cRichFlag;
  }
  
  public void a(@NonNull TroopMemberCard paramTroopMemberCard, group_member_info.MemberInfo paramMemberInfo)
  {
    if (paramTroopMemberCard == null) {
      return;
    }
    paramTroopMemberCard.honorList = TroopHonorUtils.a(paramMemberInfo.bytes_group_honor.get().toByteArray());
  }
  
  public void a(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    if (paramstTroopMemberInfo == null) {
      return;
    }
    paramTroopMemberInfo.honorList = TroopHonorUtils.a(paramstTroopMemberInfo.vecGroupHonor);
  }
  
  public void a(stTroopMemberInfo paramstTroopMemberInfo, TroopMemberInfo paramTroopMemberInfo)
  {
    paramstTroopMemberInfo = ColorNickManager.a(paramstTroopMemberInfo.vecName);
    if (TextUtils.isEmpty(paramstTroopMemberInfo))
    {
      paramTroopMemberInfo.pyFirst_troopnick = "";
      paramTroopMemberInfo.pyAll_troopnick = "";
    }
    do
    {
      return;
      if (!paramstTroopMemberInfo.equals(paramTroopMemberInfo.troopnick))
      {
        paramTroopMemberInfo.pyFirst_troopnick = ChnToSpell.a(paramstTroopMemberInfo, 2);
        paramTroopMemberInfo.pyAll_troopnick = ChnToSpell.a(paramstTroopMemberInfo, 1);
        return;
      }
      if (TextUtils.isEmpty(paramTroopMemberInfo.pyFirst_troopnick)) {
        paramTroopMemberInfo.pyFirst_troopnick = ChnToSpell.a(paramstTroopMemberInfo, 2);
      }
    } while (!TextUtils.isEmpty(paramTroopMemberInfo.pyAll_troopnick));
    paramTroopMemberInfo.pyAll_troopnick = ChnToSpell.a(paramstTroopMemberInfo, 1);
  }
  
  public Object[] a(@NonNull AppInterface paramAppInterface, String paramString, ArrayList<stTroopRemarkInfo> paramArrayList)
  {
    return DBUtils.a().a((QQAppInterface)paramAppInterface, paramString, paramArrayList);
  }
  
  public void b(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    if (paramstTroopMemberInfo == null) {
      return;
    }
    paramTroopMemberInfo.realLevel = ((int)paramstTroopMemberInfo.dwMemberLevel);
    paramTroopMemberInfo.newRealLevel = TroopMemberLevelUtils.a(paramstTroopMemberInfo.vecGroupHonor);
    paramTroopMemberInfo.level = ((int)paramstTroopMemberInfo.dwTitleId);
  }
  
  public void b(stTroopMemberInfo paramstTroopMemberInfo, TroopMemberInfo paramTroopMemberInfo)
  {
    switch (paramstTroopMemberInfo.cRichCardNameVer)
    {
    default: 
      paramTroopMemberInfo.troopColorNick = ColorNickManager.a(paramstTroopMemberInfo.vecName);
      paramTroopMemberInfo.troopnick = ColorNickManager.b(paramTroopMemberInfo.troopColorNick);
      return;
    }
    ColorNickManager.ColorNickNameData localColorNickNameData = ColorNickManager.a(paramstTroopMemberInfo.vecName);
    if (localColorNickNameData.jdField_a_of_type_JavaLangString == null) {}
    for (paramstTroopMemberInfo = "";; paramstTroopMemberInfo = localColorNickNameData.jdField_a_of_type_JavaLangString)
    {
      paramTroopMemberInfo.troopColorNick = paramstTroopMemberInfo;
      paramTroopMemberInfo.troopColorNickId = localColorNickNameData.jdField_a_of_type_Int;
      paramTroopMemberInfo.troopnick = ColorNickManager.b(paramTroopMemberInfo.troopColorNick);
      return;
    }
  }
  
  public void c(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopMemberInfoProcessor
 * JD-Core Version:    0.7.0.1
 */