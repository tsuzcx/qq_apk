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
    int j = 0;
    LocationShareServiceHolder.a(paramQQAppInterface);
    boolean bool7 = false;
    boolean bool2 = false;
    boolean bool8 = false;
    boolean bool1 = false;
    boolean bool9 = false;
    boolean bool3 = false;
    boolean bool6 = bool7;
    boolean bool5 = bool8;
    boolean bool4 = bool9;
    if (paramFriends != null)
    {
      bool6 = bool7;
      bool5 = bool8;
      bool4 = bool9;
      if (paramFriends.isFriend())
      {
        if (paramExtSnsFrdData.bytes_music_switch.has()) {
          bool2 = ListenTogetherAIOStatusHelper.a(paramExtSnsFrdData.bytes_music_switch.get().toByteArray());
        }
        if (paramExtSnsFrdData.bytes_ksing_switch.has()) {
          bool1 = SingTogetherParser.a(paramExtSnsFrdData.bytes_ksing_switch.get().toByteArray());
        }
        if (paramExtSnsFrdData.bytes_lbs_share.has()) {
          bool3 = LocationMessageUtil.a(paramExtSnsFrdData.bytes_lbs_share);
        }
        bool6 = bool2;
        bool5 = bool1;
        bool4 = bool3;
        if (paramExtSnsFrdData.bytes_aio_quick_app.has())
        {
          bool4 = C2CShortcutBarSwitcher.a(paramExtSnsFrdData.bytes_aio_quick_app);
          bool5 = bool1;
          bool1 = bool4;
        }
      }
    }
    for (;;)
    {
      if (paramExtensionInfo.isTogetherBusinessOpen(16777216) != bool5)
      {
        paramExtensionInfo.setTogetherBusiness(bool5, 16777216);
        j = 1;
      }
      int i = j;
      if (paramExtensionInfo.isListenTogetherOpen != bool2)
      {
        paramExtensionInfo.isListenTogetherOpen = bool2;
        i = j | 0x1;
      }
      if (paramExtensionInfo.isSharingLocation == 1)
      {
        bool4 = true;
        j = i;
        if (bool4 != bool3)
        {
          if (!bool3) {
            break label560;
          }
          j = 1;
          label254:
          paramExtensionInfo.isSharingLocation = j;
          if (paramExtensionInfo.isSharingLocation != 1) {
            break label566;
          }
          bool4 = true;
          label271:
          LocationMessageUtil.a(paramQQAppInterface, 0, paramString, bool4);
          if (QLog.isColorLevel()) {
            QLog.d("ExtSnsFrdDataHandlerHelper", 2, new Object[] { "handleExtSnsFrdData: invoked. update ei & msg data ", " isSharingLbs: ", Boolean.valueOf(bool3) });
          }
          j = i | 0x1;
        }
        if (paramExtensionInfo.isAioShortcutBarOpen == bool1) {
          break label622;
        }
        paramExtensionInfo.isAioShortcutBarOpen = bool1;
      }
      label439:
      label578:
      label622:
      for (i = j | 0x1;; i = j)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("handleExtSnsFrdData friendUin:").append(paramString).append(" newIsOpen:").append(bool2).append(" oldIsOpen").append(paramExtensionInfo.isListenTogetherOpen).append(" is_sing_together=").append(bool5).append(" isSharingLocation: ").append(paramExtensionInfo.isSharingLocation).append(" isAioShortcutBarOpen: ").append(paramExtensionInfo.isAioShortcutBarOpen).append(" friend:");
          if (paramFriends != null)
          {
            paramExtensionInfo = Boolean.valueOf(paramFriends.isFriend());
            QLog.d("ExtSnsFrdDataHandlerHelper", 1, paramExtensionInfo);
          }
        }
        else
        {
          j = i;
          if (paramFriends != null)
          {
            if (!paramExtSnsFrdData.bytes_mutualmark_alienation.has()) {
              break label578;
            }
            MutualMarkAlienationHelper.a(paramQQAppInterface, paramFriendsManager, paramFriends, paramString, paramExtSnsFrdData.bytes_mutualmark_alienation.get().toByteArray(), false);
            i |= 0x2;
            j = i;
            if (QLog.isColorLevel())
            {
              QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleExtSnsFrdData friendUin:" + paramString + " relationIconFlag" + paramFriends.relationIconFlag);
              j = i;
            }
          }
        }
        do
        {
          return j;
          bool4 = false;
          break;
          j = 0;
          break label254;
          bool4 = false;
          break label271;
          paramExtensionInfo = "null";
          break label439;
          j = i;
        } while (!QLog.isColorLevel());
        QLog.e("ExtSnsFrdDataHandlerHelper", 2, "handleExtSnsFrdData ExtSnsFrdData  friendUin:" + paramString + " doesn't has bytes_mutualmark_alienation");
        return i;
      }
      label560:
      label566:
      bool2 = bool6;
      bool1 = false;
      bool3 = bool4;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if (paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) {}
    switch (paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int)
    {
    default: 
      if (MutualMarkUtils.b(paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int)) {
        MutualMarkDataS2CHandleHelper.a(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      }
      return;
    }
    MutualMarkAlienationHelper.a(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ArrayOfByte, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, String paramString, Oidb_0xd50.ExtSnsFrdData paramExtSnsFrdData)
  {
    if (paramFriends != null)
    {
      if (!paramExtSnsFrdData.bytes_mutualmark_alienation.has()) {
        break label87;
      }
      paramExtSnsFrdData = paramExtSnsFrdData.bytes_mutualmark_alienation.get().toByteArray();
      MutualMarkAlienationHelper.a(paramQQAppInterface, (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER), paramFriends, paramString, paramExtSnsFrdData, false);
      if (QLog.isColorLevel()) {
        QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleMutualMarExtSnsFrdData friendUin:" + paramString + " relationIconFlag" + paramFriends.relationIconFlag);
      }
    }
    label87:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("ExtSnsFrdDataHandlerHelper", 2, "handleMutualMarExtSnsFrdData ExtSnsFrdData  friendUin:" + paramString + " doesn't has bytes_mutualmark_alienation");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Oidb_0xd50.ExtSnsFrdData paramExtSnsFrdData)
  {
    if (paramExtSnsFrdData == null) {}
    String str;
    int i;
    do
    {
      long l;
      do
      {
        return;
        l = paramExtSnsFrdData.frd_uin.get();
      } while (l <= 0L);
      str = String.valueOf(l);
      FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject2 = localFriendsManager.a(str);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = str;
      }
      localObject2 = localFriendsManager.e(str);
      i = a(paramQQAppInterface, localFriendsManager, (Friends)localObject2, (ExtensionInfo)localObject1, str, paramExtSnsFrdData);
      if ((localObject1 != null) && ((i & 0x1) != 0)) {
        localFriendsManager.a((ExtensionInfo)localObject1);
      }
      if ((localObject2 != null) && ((i & 0x2) != 0))
      {
        localFriendsManager.a((Friends)localObject2);
        paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleGet0x5e0ExtSnsFrdData uin:" + str + " changeType:" + i);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if ((paramQQAppInterface == null) || (paramRelationalChainChange == null) || (paramPushMsg0x210C7Info == null)) {}
    ExtSnsRelationChainChangePushInfo localExtSnsRelationChainChangePushInfo;
    do
    {
      return;
      localExtSnsRelationChainChangePushInfo = ExtSnsRelationChainChangePushInfo.a(paramRelationalChainChange, paramPushMsg0x210C7Info.a);
    } while ((!TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), localExtSnsRelationChainChangePushInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString)));
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Friends localFriends = localFriendsManager.e(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
    ExtensionInfo localExtensionInfo = localFriendsManager.a(localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString);
    ExtensionInfoLogUtils.a("ExtSnsFrdDataHandlerHelper", "decodeC2CMsgPkgSubMsgType0xc7 before fm.getExtensionInfo，friendUin:", localExtensionInfo);
    paramRelationalChainChange = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramRelationalChainChange = new ExtensionInfo();
      paramRelationalChainChange.uin = localExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString;
    }
    QLog.i("ExtSnsFrdDataHandlerHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 msginfo:" + paramPushMsg0x210C7Info + "changePushInfo:" + localExtSnsRelationChainChangePushInfo);
    switch (localExtSnsRelationChainChangePushInfo.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      return;
    case 2: 
      b(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      return;
    case 3: 
      c(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      return;
    case 10001: 
      d(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      return;
    case 10002: 
      e(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      return;
    case 10003: 
      f(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      return;
    case 10004: 
      g(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      return;
    case 10005: 
      h(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      return;
    case 11000: 
      i(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      return;
    case 11001: 
      j(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      return;
    case 11002: 
      k(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      return;
    }
    l(paramQQAppInterface, localFriendsManager, localFriends, paramRelationalChainChange, localExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, ExtensionInfo paramExtensionInfo, String paramString, Oidb_0xd50.ExtSnsFrdData paramExtSnsFrdData)
  {
    boolean bool1;
    boolean bool2;
    label58:
    boolean bool4;
    label79:
    boolean bool5;
    boolean bool3;
    if (paramBoolean) {
      if (paramExtSnsFrdData.bytes_music_switch.has())
      {
        bool1 = ListenTogetherAIOStatusHelper.a(paramExtSnsFrdData.bytes_music_switch.get().toByteArray());
        if (paramExtSnsFrdData.bytes_ksing_switch.has())
        {
          bool2 = SingTogetherParser.a(paramExtSnsFrdData.bytes_ksing_switch.get().toByteArray());
          if (paramExtSnsFrdData.bytes_lbs_share.has())
          {
            bool4 = LocationMessageUtil.a(paramExtSnsFrdData.bytes_lbs_share);
            if (paramExtSnsFrdData.bytes_aio_quick_app.has())
            {
              bool5 = C2CShortcutBarSwitcher.a(paramExtSnsFrdData.bytes_aio_quick_app);
              bool3 = bool1;
              bool1 = bool5;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (paramExtensionInfo.isTogetherBusinessOpen(16777216) != bool2) {
        paramExtensionInfo.setTogetherBusiness(bool2, 16777216);
      }
      if (paramExtensionInfo.isListenTogetherOpen != bool3) {
        paramExtensionInfo.isListenTogetherOpen = bool3;
      }
      int i;
      if (paramExtensionInfo.isSharingLocation == 1)
      {
        bool5 = true;
        if (bool5 != bool4)
        {
          if (!bool4) {
            break label347;
          }
          i = 1;
          label168:
          paramExtensionInfo.isSharingLocation = i;
          if (paramExtensionInfo.isSharingLocation != 1) {
            break label353;
          }
        }
      }
      label347:
      label353:
      for (bool5 = true;; bool5 = false)
      {
        LocationMessageUtil.a(paramQQAppInterface, 0, paramString, bool5);
        if (QLog.isColorLevel()) {
          QLog.d("ExtSnsFrdDataHandlerHelper", 2, new Object[] { "handleExtSnsFrdDataForListenTogether: invoked. update ei & msg data ", " isSharingLbs: ", Boolean.valueOf(bool4) });
        }
        if (paramExtensionInfo.isAioShortcutBarOpen != bool1) {
          paramExtensionInfo.isAioShortcutBarOpen = bool1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleExtSnsFrdDataForListenTogether friendUin:" + paramString + " newIsOpen:" + bool3 + " oldIsOpen" + paramExtensionInfo.isListenTogetherOpen + " is_sing_together=" + bool2 + " isSharingLocation: " + paramExtensionInfo.isSharingLocation + " isAioShortcutBarOpen: " + paramExtensionInfo.isAioShortcutBarOpen + " friend:" + paramBoolean);
        }
        return;
        bool5 = false;
        break;
        i = 0;
        break label168;
      }
      bool3 = bool1;
      bool1 = false;
      continue;
      bool4 = false;
      break label79;
      bool2 = false;
      break label58;
      bool1 = false;
      break;
      bool1 = false;
      bool4 = false;
      bool2 = false;
      bool3 = false;
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
    if (paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo != null) {}
    switch (paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int)
    {
    default: 
      if (MutualMarkUtils.b(paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_Int)) {
        MutualMarkDataS2CHandleHelper.c(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtensionInfo, paramExtSnsRelationChainChangePushInfo, paramPushMsg0x210C7Info);
      }
      return;
    }
    MutualMarkAlienationHelper.a(paramQQAppInterface, paramFriendsManager, paramFriends, paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_JavaLangString, paramExtSnsRelationChainChangePushInfo.jdField_b_of_type_ComTencentMobileqqActivityAioExtSnsRelationChainChangePushInfo$RelationalChainPushInfo.jdField_a_of_type_ArrayOfByte, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ExtSnsFrdDataHandleHelper
 * JD-Core Version:    0.7.0.1
 */