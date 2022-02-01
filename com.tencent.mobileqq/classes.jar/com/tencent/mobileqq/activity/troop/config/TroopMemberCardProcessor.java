package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.troop.api.config.AbsTroopMemberCardHandlerProcessor;
import com.tencent.mobileqq.troop.honor.util.TroopHonorUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.qphone.base.util.QLog;
import friendlist.stTroopRemarkInfo;
import java.util.ArrayList;
import tencent.im.group.group_member_info.MemberInfo;

public class TroopMemberCardProcessor
  extends AbsTroopMemberCardHandlerProcessor
{
  public void a(@NonNull TroopMemberCard paramTroopMemberCard, long paramLong, group_member_info.MemberInfo paramMemberInfo)
  {
    if (paramMemberInfo == null) {
      return;
    }
    if (paramMemberInfo.str_card.has())
    {
      paramTroopMemberCard.colorCard = ColorNickManager.a(paramMemberInfo.str_card.get());
      paramTroopMemberCard.colorCardId = ColorNickManager.c(paramMemberInfo.str_card.get().toByteArray());
      paramTroopMemberCard.card = ColorNickManager.b(paramTroopMemberCard.colorCard);
    }
    if (paramMemberInfo.bytes_group_honor.has())
    {
      paramTroopMemberCard.honorList = TroopHonorUtils.a(paramMemberInfo.bytes_group_honor.get().toByteArray());
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberCardProcessor", 2, String.format("handleGetTroopMemberCard troopUin: %s, memberUin: %s, honorList: %s", new Object[] { Long.valueOf(paramLong), Long.valueOf(paramTroopMemberCard.memberUin), paramTroopMemberCard.honorList }));
      }
    }
    else
    {
      paramTroopMemberCard.honorList = "";
    }
  }
  
  public void a(@NonNull TroopMemberInfo paramTroopMemberInfo, TroopMemberCard paramTroopMemberCard)
  {
    if (paramTroopMemberCard == null) {
      return;
    }
    String str = paramTroopMemberCard.colorCard;
    if (str == null) {
      paramTroopMemberCard = null;
    } else {
      paramTroopMemberCard = ColorNickManager.b(str);
    }
    if ((str != null) && (!str.equals(paramTroopMemberInfo.troopColorNick))) {
      paramTroopMemberInfo.troopColorNick = str;
    }
    if ((paramTroopMemberCard != null) && (!paramTroopMemberCard.equals(paramTroopMemberInfo.troopnick))) {
      paramTroopMemberInfo.troopnick = paramTroopMemberCard;
    }
  }
  
  public Object[] a(@NonNull AppInterface paramAppInterface, String paramString, ArrayList<stTroopRemarkInfo> paramArrayList)
  {
    return DBUtils.a().a((QQAppInterface)paramAppInterface, paramString, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopMemberCardProcessor
 * JD-Core Version:    0.7.0.1
 */