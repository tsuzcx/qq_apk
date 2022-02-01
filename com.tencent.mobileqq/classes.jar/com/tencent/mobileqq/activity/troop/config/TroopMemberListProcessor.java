package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.config.AbsTroopMemberListHandlerProcessor;
import com.tencent.mobileqq.troop.avatar.api.ITroopAvatarService;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.qphone.base.util.QLog;
import friendlist.stTroopMemberInfo;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x787.oidb_0x787.MemberLevelInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class TroopMemberListProcessor
  extends AbsTroopMemberListHandlerProcessor
{
  public static long a = -1L;
  public static ArrayList<Long> a;
  
  public void a(long paramLong, List<oidb_0x899.memberlist> paramList)
  {
    if (jdField_a_of_type_Long == paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListProcessor", 2, "get members by playtogeter");
      }
      Object localObject = jdField_a_of_type_JavaUtilArrayList;
      if (localObject == null) {
        jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      } else {
        ((ArrayList)localObject).clear();
      }
      if (paramList != null)
      {
        int i = 0;
        while (i < paramList.size())
        {
          localObject = (oidb_0x899.memberlist)paramList.get(i);
          if (((oidb_0x899.memberlist)localObject).uint64_member_uin.has()) {
            jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get()));
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo, ArrayList<String> paramArrayList)
  {
    if (paramTroopInfo != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetMemberListForHeadBatch uin = ");
        localStringBuilder.append(paramTroopInfo.troopuin);
        QLog.i("TroopMemberListProcessor", 2, localStringBuilder.toString());
      }
      paramTroopInfo.updateHeadMemberList(GroupIconHelper.a(GroupIconHelper.a(paramArrayList, paramTroopInfo), false));
      paramAppInterface = ((ITroopAvatarService)paramAppInterface.getRuntimeService(ITroopAvatarService.class, "")).getGroupIconHelper();
      if (paramAppInterface != null) {
        paramAppInterface.c(paramTroopInfo.troopuin);
      }
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString, long paramLong)
  {
    paramAppInterface = (QQAppInterface)paramAppInterface;
    if (paramAppInterface.getWritableDatabase() != null) {
      paramAppInterface.getWritableDatabase().delete(new TroopMemberInfo().getTableName(), "troopuin=? and memberuin<>? and memberuin<>? and datetime<?", new String[] { paramString, "1000000", "10000", String.valueOf(paramLong) });
    }
  }
  
  public void a(@NonNull TroopMemberCard paramTroopMemberCard, oidb_0x787.MemberLevelInfo paramMemberLevelInfo)
  {
    if (paramMemberLevelInfo != null)
    {
      if (!paramMemberLevelInfo.str_name.has()) {
        return;
      }
      paramTroopMemberCard.colorCard = ColorNickManager.a(paramMemberLevelInfo.str_name.get());
    }
  }
  
  public void a(@NonNull TroopMemberCardInfo paramTroopMemberCardInfo, stTroopMemberInfo paramstTroopMemberInfo)
  {
    if (paramstTroopMemberInfo != null)
    {
      if (paramstTroopMemberInfo.vecName == null) {
        return;
      }
      paramTroopMemberCardInfo.name = ColorNickManager.a(paramstTroopMemberInfo.vecName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopMemberListProcessor
 * JD-Core Version:    0.7.0.1
 */