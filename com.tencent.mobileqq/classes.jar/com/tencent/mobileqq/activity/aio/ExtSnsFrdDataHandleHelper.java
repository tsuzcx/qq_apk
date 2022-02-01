package com.tencent.mobileqq.activity.aio;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.PushMsg0x210C7Info;
import com.tencent.mobileqq.app.utils.ExtensionInfoLogUtils;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarSwitcher;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherParser;
import com.tencent.mobileqq.listentogether.ListenTogetherAIOStatusHelper;
import com.tencent.mobileqq.location.LocationMessageUtil;
import com.tencent.mobileqq.location.LocationShareServiceHolder;
import com.tencent.mobileqq.mutualmark.MutualMarkDataS2CHandleHelper;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.mutualmark.alienation.MutualMarkAlienationHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50.ExtSnsFrdData;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;

public class ExtSnsFrdDataHandleHelper
{
  private static int a(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd50.ExtSnsFrdData paramExtSnsFrdData)
  {
    LocationShareServiceHolder.a(paramQQAppInterface);
    boolean bool4;
    boolean bool5;
    boolean bool6;
    if ((paramFriends != null) && (paramFriends.isFriend()))
    {
      if (paramExtSnsFrdData.bytes_music_switch.has()) {
        bool1 = ListenTogetherAIOStatusHelper.a(paramExtSnsFrdData.bytes_music_switch.get().toByteArray());
      } else {
        bool1 = false;
      }
      if (paramExtSnsFrdData.bytes_ksing_switch.has()) {
        bool2 = SingTogetherParser.a(paramExtSnsFrdData.bytes_ksing_switch.get().toByteArray());
      } else {
        bool2 = false;
      }
      if (paramExtSnsFrdData.bytes_lbs_share.has()) {
        bool3 = LocationMessageUtil.a(paramExtSnsFrdData.bytes_lbs_share);
      } else {
        bool3 = false;
      }
      bool4 = bool1;
      bool5 = bool2;
      bool6 = bool3;
      if (paramExtSnsFrdData.bytes_aio_quick_app.has())
      {
        bool7 = C2CShortcutBarSwitcher.a(paramExtSnsFrdData.bytes_aio_quick_app);
        break label169;
      }
    }
    else
    {
      bool4 = false;
      bool5 = false;
      bool6 = false;
    }
    boolean bool7 = false;
    boolean bool3 = bool6;
    boolean bool2 = bool5;
    boolean bool1 = bool4;
    label169:
    if (paramExtensionInfo.isTogetherBusinessOpen(16777216) != bool2)
    {
      paramExtensionInfo.setTogetherBusiness(bool2, 16777216);
      j = 1;
    }
    else
    {
      j = 0;
    }
    int i = j;
    if (paramExtensionInfo.isListenTogetherOpen != bool1)
    {
      paramExtensionInfo.isListenTogetherOpen = bool1;
      i = j | 0x1;
    }
    if (paramExtensionInfo.isSharingLocation == 1) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    if (bool4 != bool3)
    {
      if (bool3) {
        j = 1;
      } else {
        j = 0;
      }
      paramExtensionInfo.isSharingLocation = j;
      if (paramExtensionInfo.isSharingLocation == 1) {
        bool4 = true;
      } else {
        bool4 = false;
      }
      LocationMessageUtil.a(paramQQAppInterface, 0, paramString, bool4);
      if (QLog.isColorLevel()) {
        QLog.d("ExtSnsFrdDataHandlerHelper", 2, new Object[] { "handleExtSnsFrdData: invoked. update ei & msg data ", " isSharingLbs: ", Boolean.valueOf(bool3) });
      }
      j = i | 0x1;
    }
    else
    {
      j = i;
    }
    i = j;
    if (paramExtensionInfo.isAioShortcutBarOpen != bool7)
    {
      paramExtensionInfo.isAioShortcutBarOpen = bool7;
      i = j | 0x1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleExtSnsFrdData friendUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" newIsOpen:");
      localStringBuilder.append(bool1);
      localStringBuilder.append(" oldIsOpen");
      localStringBuilder.append(paramExtensionInfo.isListenTogetherOpen);
      localStringBuilder.append(" is_sing_together=");
      localStringBuilder.append(bool2);
      localStringBuilder.append(" isSharingLocation: ");
      localStringBuilder.append(paramExtensionInfo.isSharingLocation);
      localStringBuilder.append(" isAioShortcutBarOpen: ");
      localStringBuilder.append(paramExtensionInfo.isAioShortcutBarOpen);
      localStringBuilder.append(" friend:");
      if (paramFriends != null) {
        paramExtensionInfo = Boolean.valueOf(paramFriends.isFriend());
      } else {
        paramExtensionInfo = "null";
      }
      localStringBuilder.append(paramExtensionInfo);
      QLog.d("ExtSnsFrdDataHandlerHelper", 1, localStringBuilder.toString());
    }
    int j = i;
    if (paramFriends != null) {
      if (paramExtSnsFrdData.bytes_mutualmark_alienation.has())
      {
        MutualMarkAlienationHelper.a(paramQQAppInterface, paramFriendsManager, paramFriends, paramString, paramExtSnsFrdData.bytes_mutualmark_alienation.get().toByteArray(), false);
        i |= 0x2;
        j = i;
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("handleExtSnsFrdData friendUin:");
          paramQQAppInterface.append(paramString);
          paramQQAppInterface.append(" relationIconFlag");
          paramQQAppInterface.append(paramFriends.relationIconFlag);
          QLog.d("ExtSnsFrdDataHandlerHelper", 1, paramQQAppInterface.toString());
          return i;
        }
      }
      else
      {
        j = i;
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("handleExtSnsFrdData ExtSnsFrdData  friendUin:");
          paramQQAppInterface.append(paramString);
          paramQQAppInterface.append(" doesn't has bytes_mutualmark_alienation");
          QLog.e("ExtSnsFrdDataHandlerHelper", 2, paramQQAppInterface.toString());
          j = i;
        }
      }
    }
    return j;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if (paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) {
      if (paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int != 10)
      {
        if (MutualMarkUtils.b(paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int)) {
          MutualMarkDataS2CHandleHelper.a(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
        }
      }
      else {
        MutualMarkAlienationHelper.a(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ArrayOfByte, true);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, String paramString, Oidb_0xd50.ExtSnsFrdData paramExtSnsFrdData)
  {
    if (paramFriends != null) {
      if (paramExtSnsFrdData.bytes_mutualmark_alienation.has())
      {
        paramExtSnsFrdData = paramExtSnsFrdData.bytes_mutualmark_alienation.get().toByteArray();
        MutualMarkAlienationHelper.a(paramQQAppInterface, (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER), paramFriends, paramString, paramExtSnsFrdData, false);
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("handleMutualMarExtSnsFrdData friendUin:");
          paramQQAppInterface.append(paramString);
          paramQQAppInterface.append(" relationIconFlag");
          paramQQAppInterface.append(paramFriends.relationIconFlag);
          QLog.d("ExtSnsFrdDataHandlerHelper", 1, paramQQAppInterface.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("handleMutualMarExtSnsFrdData ExtSnsFrdData  friendUin:");
        paramQQAppInterface.append(paramString);
        paramQQAppInterface.append(" doesn't has bytes_mutualmark_alienation");
        QLog.e("ExtSnsFrdDataHandlerHelper", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Oidb_0xd50.ExtSnsFrdData paramExtSnsFrdData)
  {
    if (paramExtSnsFrdData == null) {
      return;
    }
    long l = paramExtSnsFrdData.frd_uin.get();
    if (l <= 0L) {
      return;
    }
    String str = String.valueOf(l);
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2 = localFriendsManager.a(str);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ExtensionInfo();
      ((ExtensionInfo)localObject1).uin = str;
    }
    localObject2 = localFriendsManager.e(str);
    int i = a(paramQQAppInterface, localFriendsManager, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramExtSnsFrdData);
    if ((localObject1 != null) && ((i & 0x1) != 0)) {
      localFriendsManager.a((ExtensionInfo)localObject1);
    }
    if ((localObject2 != null) && ((i & 0x2) != 0))
    {
      localFriendsManager.a((Friends)localObject2);
      paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, str);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("handleGet0x5e0ExtSnsFrdData uin:");
      paramQQAppInterface.append(str);
      paramQQAppInterface.append(" changeType:");
      paramQQAppInterface.append(i);
      QLog.d("ExtSnsFrdDataHandlerHelper", 1, paramQQAppInterface.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if ((paramQQAppInterface != null) && (paramRelationalChainChange != null))
    {
      if (paramPushMsg0x210C7Info == null) {
        return;
      }
      ExtSnsRelationChainChangePushInfo localExtSnsRelationChainChangePushInfo = ExtSnsRelationChainChangePushInfo.a(paramRelationalChainChange, paramPushMsg0x210C7Info.a);
      if (TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString))
      {
        if (TextUtils.isEmpty(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString)) {
          return;
        }
        FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Friends localFriends = localFriendsManager.e(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
        Object localObject = localFriendsManager.a(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
        ExtensionInfoLogUtils.a("ExtSnsFrdDataHandlerHelper", "decodeC2CMsgPkgSubMsgType0xc7 before fm.getExtensionInfo，friendUin:", (ExtensionInfo)localObject);
        paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject;
        if (localObject == null)
        {
          paramRelationalChainChange = new ExtensionInfo();
          paramRelationalChainChange.uin = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decodeC2CMsgPkgSubMsgType0xc7 msginfo:");
        ((StringBuilder)localObject).append(paramPushMsg0x210C7Info);
        ((StringBuilder)localObject).append("changePushInfo:");
        ((StringBuilder)localObject).append(localExtSnsRelationChainChangePushInfo);
        QLog.i("ExtSnsFrdDataHandlerHelper", 1, ((StringBuilder)localObject).toString());
        int i = localExtSnsRelationChainChangePushInfo.jdField_a_of_type_Int;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 50000)
              {
                switch (i)
                {
                default: 
                  switch (i)
                  {
                  default: 
                    return;
                  case 11002: 
                    k(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
                    return;
                  case 11001: 
                    j(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
                    return;
                  }
                  i(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
                  return;
                case 10005: 
                  h(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
                  return;
                case 10004: 
                  g(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
                  return;
                case 10003: 
                  f(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
                  return;
                case 10002: 
                  e(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
                  return;
                }
                d(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
                return;
              }
              l(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
              return;
            }
            c(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
            return;
          }
          b(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
          return;
        }
        a(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd50.ExtSnsFrdData paramExtSnsFrdData)
  {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool5;
    boolean bool4;
    if (paramBoolean)
    {
      if (paramExtSnsFrdData.bytes_music_switch.has()) {
        bool1 = ListenTogetherAIOStatusHelper.a(paramExtSnsFrdData.bytes_music_switch.get().toByteArray());
      } else {
        bool1 = false;
      }
      if (paramExtSnsFrdData.bytes_ksing_switch.has()) {
        bool2 = SingTogetherParser.a(paramExtSnsFrdData.bytes_ksing_switch.get().toByteArray());
      } else {
        bool2 = false;
      }
      if (paramExtSnsFrdData.bytes_lbs_share.has()) {
        bool3 = LocationMessageUtil.a(paramExtSnsFrdData.bytes_lbs_share);
      } else {
        bool3 = false;
      }
      if (paramExtSnsFrdData.bytes_aio_quick_app.has())
      {
        bool5 = C2CShortcutBarSwitcher.a(paramExtSnsFrdData.bytes_aio_quick_app);
        bool4 = bool1;
        bool1 = bool5;
      }
      else
      {
        bool5 = false;
        bool4 = bool1;
        bool1 = bool5;
      }
    }
    else
    {
      bool1 = false;
      bool4 = false;
      bool2 = false;
      bool3 = false;
    }
    if (paramExtensionInfo.isTogetherBusinessOpen(16777216) != bool2) {
      paramExtensionInfo.setTogetherBusiness(bool2, 16777216);
    }
    if (paramExtensionInfo.isListenTogetherOpen != bool4) {
      paramExtensionInfo.isListenTogetherOpen = bool4;
    }
    if (paramExtensionInfo.isSharingLocation == 1) {
      bool5 = true;
    } else {
      bool5 = false;
    }
    if (bool5 != bool3)
    {
      int i;
      if (bool3) {
        i = 1;
      } else {
        i = 0;
      }
      paramExtensionInfo.isSharingLocation = i;
      if (paramExtensionInfo.isSharingLocation == 1) {
        bool5 = true;
      } else {
        bool5 = false;
      }
      LocationMessageUtil.a(paramQQAppInterface, 0, paramString, bool5);
      if (QLog.isColorLevel()) {
        QLog.d("ExtSnsFrdDataHandlerHelper", 2, new Object[] { "handleExtSnsFrdDataForListenTogether: invoked. update ei & msg data ", " isSharingLbs: ", Boolean.valueOf(bool3) });
      }
    }
    if (paramExtensionInfo.isAioShortcutBarOpen != bool1) {
      paramExtensionInfo.isAioShortcutBarOpen = bool1;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("handleExtSnsFrdDataForListenTogether friendUin:");
      paramQQAppInterface.append(paramString);
      paramQQAppInterface.append(" newIsOpen:");
      paramQQAppInterface.append(bool4);
      paramQQAppInterface.append(" oldIsOpen");
      paramQQAppInterface.append(paramExtensionInfo.isListenTogetherOpen);
      paramQQAppInterface.append(" is_sing_together=");
      paramQQAppInterface.append(bool2);
      paramQQAppInterface.append(" isSharingLocation: ");
      paramQQAppInterface.append(paramExtensionInfo.isSharingLocation);
      paramQQAppInterface.append(" isAioShortcutBarOpen: ");
      paramQQAppInterface.append(paramExtensionInfo.isAioShortcutBarOpen);
      paramQQAppInterface.append(" friend:");
      paramQQAppInterface.append(paramBoolean);
      QLog.d("ExtSnsFrdDataHandlerHelper", 1, paramQQAppInterface.toString());
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if (paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null)
    {
      int i = paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
      if (MutualMarkUtils.b(paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int)) {
        MutualMarkDataS2CHandleHelper.b(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      }
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if (paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) {
      if (paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int != 10)
      {
        if (MutualMarkUtils.b(paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int)) {
          MutualMarkDataS2CHandleHelper.c(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
        }
      }
      else {
        MutualMarkAlienationHelper.a(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ArrayOfByte, true);
      }
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if (paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null)
    {
      int i = paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
      if (MutualMarkUtils.b(paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int)) {
        MutualMarkDataS2CHandleHelper.d(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      }
    }
  }
  
  public static void e(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if (paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null)
    {
      int i = paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
      if (MutualMarkUtils.b(paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int)) {
        MutualMarkDataS2CHandleHelper.e(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      }
    }
  }
  
  public static void f(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if (paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null)
    {
      int i = paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
      if (MutualMarkUtils.b(paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int)) {
        MutualMarkDataS2CHandleHelper.f(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      }
    }
  }
  
  public static void g(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if (paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null)
    {
      int i = paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
      if (MutualMarkUtils.b(paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int)) {
        MutualMarkDataS2CHandleHelper.g(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      }
    }
  }
  
  public static void h(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if (paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null)
    {
      int i = paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int;
      if (MutualMarkUtils.b(paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int)) {
        MutualMarkDataS2CHandleHelper.h(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      }
    }
  }
  
  public static void i(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if ((paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) || (paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaUtilArrayList != null)) {
      MutualMarkDataS2CHandleHelper.i(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
    }
  }
  
  public static void j(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if ((paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) || (paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaUtilArrayList != null)) {
      MutualMarkDataS2CHandleHelper.j(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
    }
  }
  
  public static void k(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if ((paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) || (paramExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaUtilArrayList != null)) {
      MutualMarkDataS2CHandleHelper.k(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
    }
  }
  
  public static void l(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if (paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) {
      MutualMarkDataS2CHandleHelper.l(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ExtSnsFrdDataHandleHelper
 * JD-Core Version:    0.7.0.1
 */