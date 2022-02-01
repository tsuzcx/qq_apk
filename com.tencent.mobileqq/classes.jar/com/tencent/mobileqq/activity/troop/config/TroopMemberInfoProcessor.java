package com.tencent.mobileqq.activity.troop.config;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.config.AbsTroopMemberInfoHandlerProcessor;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x787.oidb_0x787.MemberLevelInfo;

public class TroopMemberInfoProcessor
  extends AbsTroopMemberInfoHandlerProcessor
{
  private void a(@NonNull AppInterface paramAppInterface, ToServiceMsg paramToServiceMsg, Map<String, String> paramMap, oidb_0x787.MemberLevelInfo paramMemberLevelInfo)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    long l1 = Long.valueOf(paramToServiceMsg.extraData.getString("troopUin")).longValue();
    Object localObject = (FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    TroopManager localTroopManager = (TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    String str3 = String.valueOf(paramMemberLevelInfo.uint64_uin.get());
    if (QLog.isColorLevel())
    {
      localStringBuffer.append(" uin=");
      localStringBuffer.append(str3.substring(0, 4));
    }
    String str1 = ColorNickManager.a(paramMemberLevelInfo.str_name.get());
    String str2 = "";
    if ((str1 != null) && (str1.length() > 0))
    {
      int i = paramToServiceMsg.extraData.getInt(ContactUtils.jdField_a_of_type_JavaLangString, ContactUtils.jdField_a_of_type_Int);
      long l2 = paramToServiceMsg.extraData.getLong(ContactUtils.jdField_b_of_type_JavaLangString, 0L);
      if (i == ContactUtils.jdField_b_of_type_Int)
      {
        paramToServiceMsg = ((QQAppInterface)paramAppInterface).getMessageFacade();
        paramMemberLevelInfo = new StringBuilder();
        paramMemberLevelInfo.append(l1);
        paramMemberLevelInfo.append("");
        paramToServiceMsg = paramToServiceMsg.a(paramMemberLevelInfo.toString(), 1, l2);
        if ((paramToServiceMsg != null) && ((paramToServiceMsg instanceof MessageForUniteGrayTip))) {
          ((MessageForUniteGrayTip)paramToServiceMsg).updateUniteGrayTipMsg(paramAppInterface, "".concat(BaseApplicationImpl.getApplication().getString(2131694325)));
        }
      }
      paramMemberLevelInfo = ColorNickManager.b(str1);
      paramAppInterface = paramMemberLevelInfo;
      paramToServiceMsg = str2;
      if (QLog.isColorLevel())
      {
        localStringBuffer.append(" troopCard=");
        localStringBuffer.append(MessageRecordUtil.a(paramMemberLevelInfo));
        localStringBuffer.append(".troop.revoked_msg_get_troop_mem_card");
        localStringBuffer.append("|extraUpdateTarget:");
        localStringBuffer.append(i);
        localStringBuffer.append("|uniseq:");
        localStringBuffer.append(l2);
        paramAppInterface = paramMemberLevelInfo;
        paramToServiceMsg = str2;
      }
    }
    else
    {
      boolean bool = paramToServiceMsg.extraData.getBoolean("needRemark", false);
      if ((TextUtils.isEmpty("")) && (bool) && (localObject != null) && (((FriendsManager)localObject).b(str3)))
      {
        paramAppInterface = ((FriendsManager)localObject).e(str3);
        if (paramAppInterface != null)
        {
          localObject = paramAppInterface.getFriendNickWithoutUin();
          break label386;
        }
      }
      localObject = "";
      label386:
      paramMemberLevelInfo = paramMemberLevelInfo.bytes_nick_name.get().toByteArray();
      paramAppInterface = (AppInterface)localObject;
      paramToServiceMsg = str2;
      if (paramMemberLevelInfo != null)
      {
        paramAppInterface = (AppInterface)localObject;
        paramToServiceMsg = str2;
        if (paramMemberLevelInfo.length > 0)
        {
          paramAppInterface = (AppInterface)localObject;
          paramToServiceMsg = str2;
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            paramToServiceMsg = new String(paramMemberLevelInfo);
            if (QLog.isColorLevel())
            {
              localStringBuffer.append(" nick=");
              localStringBuffer.append(MessageRecordUtil.a(paramToServiceMsg));
            }
            paramAppInterface = paramToServiceMsg;
          }
        }
      }
    }
    paramMemberLevelInfo = paramAppInterface;
    if (TextUtils.isEmpty(paramAppInterface))
    {
      if (QLog.isColorLevel()) {
        localStringBuffer.append(" empty here");
      }
      paramMemberLevelInfo = "  ";
    }
    paramMap.put(str3, paramMemberLevelInfo);
    if (localTroopManager != null)
    {
      paramAppInterface = str1;
      if (TextUtils.isEmpty(str1)) {
        paramAppInterface = null;
      }
      if (TextUtils.isEmpty(paramToServiceMsg)) {
        paramToServiceMsg = null;
      }
      localTroopManager.a(String.valueOf(l1), str3, paramAppInterface, -100, paramToServiceMsg, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D);
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberInfoProcessor", 2, localStringBuffer.toString());
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, @NonNull ToServiceMsg paramToServiceMsg, @NonNull Map<String, String> paramMap, List<oidb_0x787.MemberLevelInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramAppInterface, paramToServiceMsg, paramMap, (oidb_0x787.MemberLevelInfo)paramList.next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopMemberInfoProcessor
 * JD-Core Version:    0.7.0.1
 */