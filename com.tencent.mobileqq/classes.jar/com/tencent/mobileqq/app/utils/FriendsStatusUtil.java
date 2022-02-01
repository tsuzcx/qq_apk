package com.tencent.mobileqq.app.utils;

import albs;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import anmw;
import anni;
import aoen;
import aong;
import auxc;
import auxd;
import bcst;
import bgnt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatSettingFragment;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateResult;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateItem;

public class FriendsStatusUtil
{
  public static int a(Context paramContext)
  {
    int i = SettingCloneUtil.readValueForInt(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
    int j = (int)NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel()) {
      QLog.d("FriendsStatusUtil", 4, "canDisturb curServerTime=" + j + " isNoDisturbMode=" + i);
    }
    if (j > i) {
      return 0;
    }
    return i - j;
  }
  
  public static void a(int paramInt, boolean paramBoolean1, List<FriendsStatusUtil.UpdateFriendStatusItem> paramList, List<oidb_0x5d6.SnsUpateResult> paramList1, QQAppInterface paramQQAppInterface, boolean paramBoolean2)
  {
    if (paramInt == 18) {
      a(paramBoolean1, paramList, paramList1, paramQQAppInterface);
    }
    while (paramInt != 19) {
      return;
    }
    a(paramBoolean1, paramList, paramList1, paramQQAppInterface, paramBoolean2);
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    MqqHandler localMqqHandler = paramQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(HiddenChatSettingFragment.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FriendsStatusUtil.UpdateFriendStatusItem paramUpdateFriendStatusItem, @Nullable ExtensionInfo paramExtensionInfo)
  {
    if (paramUpdateFriendStatusItem.jdField_a_of_type_Int == 18) {
      if (a(paramQQAppInterface, paramUpdateFriendStatusItem, paramExtensionInfo))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendsStatusUtil", 4, "handlePush differ from db");
        }
        a(paramQQAppInterface, paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString, 0, paramUpdateFriendStatusItem.a(), false, true, paramExtensionInfo);
      }
    }
    do
    {
      do
      {
        return;
        if (paramUpdateFriendStatusItem.jdField_a_of_type_Int != 19) {
          break;
        }
      } while (!b(paramQQAppInterface, paramUpdateFriendStatusItem, paramExtensionInfo));
      if (QLog.isColorLevel()) {
        QLog.d("FriendsStatusUtil", 4, "handlePush differ from db");
      }
      b(paramQQAppInterface, paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString, 0, paramUpdateFriendStatusItem.a(), false, true, paramExtensionInfo);
      return;
    } while (paramUpdateFriendStatusItem.jdField_a_of_type_Int != 21);
    if (paramUpdateFriendStatusItem.b == 13581) {
      if (paramUpdateFriendStatusItem.a() == null) {
        break label384;
      }
    }
    label384:
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        if (a(paramQQAppInterface, bool, paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString, paramExtensionInfo)) {
          a(paramQQAppInterface);
        }
        if (paramUpdateFriendStatusItem.b == 13582)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendsStatusUtil", 2, new Object[] { "handleC2COnlinePush: invoked. NotificationSettings switch, inc update NotificationSettings ", " item.update_sns_type: ", Integer.valueOf(paramUpdateFriendStatusItem.b) });
          }
          a(paramQQAppInterface, paramUpdateFriendStatusItem.a(), paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString, paramExtensionInfo);
        }
        try
        {
          if (paramUpdateFriendStatusItem.b != 13580) {
            break;
          }
          anmw localanmw = (anmw)paramQQAppInterface.getManager(51);
          int i = (int)paramUpdateFriendStatusItem.a();
          paramQQAppInterface = paramExtensionInfo;
          if (paramExtensionInfo == null)
          {
            paramExtensionInfo = localanmw.a(String.valueOf(paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString));
            paramQQAppInterface = paramExtensionInfo;
            if (paramExtensionInfo == null)
            {
              paramQQAppInterface = new ExtensionInfo();
              paramQQAppInterface.uin = String.valueOf(paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString);
              QLog.d("FriendsStatusUtil", 1, new Object[] { "handlePush: invoked. ", "create db entity ringId: ", Integer.valueOf(i) });
            }
          }
          paramQQAppInterface.friendRingId = i;
          localanmw.a(paramQQAppInterface);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("FriendsStatusUtil", 2, new Object[] { "handleC2COnlinePush: invoked. UPDATE_SNS_TYPE_RING_ID", " ringId: ", Integer.valueOf(i), " extensionInfo: " + paramQQAppInterface.uin });
          return;
        }
        catch (Throwable paramQQAppInterface)
        {
          QLog.e("FriendsStatusUtil", 1, "handlePush: failed. ", paramQQAppInterface);
          return;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = anni.a(2131703729);
    paramString = new auxc(paramString, paramQQAppInterface.getCurrentAccountUin(), (String)localObject, 0, -5023, 655393, 0L);
    localObject = new Bundle();
    ((Bundle)localObject).putString("textColor", "#40A0FF");
    ((Bundle)localObject).putInt("key_action", 43);
    paramString.a(0, 6, (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramString);
    auxd.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
    bcst.b(paramQQAppInterface, "dc00898", "", "", "0X800A012", "0X800A012", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.a().a();
    paramString = (RecentUser)paramQQAppInterface.findRecentUserByUin(paramString, paramInt);
    if (paramString != null)
    {
      paramString.opTime = NetConnInfoCenter.getServerTime();
      paramString.lastmsgtime = 0L;
      paramString.lastmsgdrafttime = 0L;
    }
    paramQQAppInterface.saveRecentUser(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = aoen.a(paramQQAppInterface);
    boolean bool;
    RecentUser localRecentUser;
    if (paramInt2 == 1)
    {
      bool = true;
      ((aoen)localObject).a(paramString, paramInt1, bool);
      localObject = paramQQAppInterface.a().a();
      localRecentUser = (RecentUser)((aong)localObject).findRecentUser(paramString, paramInt1);
      if (localRecentUser != null) {
        break label193;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendsStatusUtil", 2, new Object[] { "recentuserHiddenFlag is null, uin:", paramString, " type:", Integer.valueOf(paramInt1) });
      }
      if (paramInt2 == 1)
      {
        localRecentUser = new RecentUser(paramString, paramInt1);
        localRecentUser.isHiddenChat = paramInt2;
        paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramInt1);
        if (paramQQAppInterface == null) {
          break label178;
        }
        localRecentUser.lastmsgtime = paramQQAppInterface.time;
        label133:
        if (localRecentUser.lastmsgtime == 0L)
        {
          paramQQAppInterface = albs.a(localRecentUser.uin, localRecentUser.getType());
          albs.a().a(paramQQAppInterface);
        }
        ((aong)localObject).saveRecentUser(localRecentUser);
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label178:
      localRecentUser.lastmsgtime = 0L;
      localRecentUser.lastmsgdrafttime = 0L;
      break label133;
      label193:
      localRecentUser.isHiddenChat = paramInt2;
      if (a(paramQQAppInterface, localRecentUser, paramInt2)) {
        ((aong)localObject).delRecentUser(localRecentUser);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("FriendsStatusUtil", 2, new Object[] { "recentuserHiddenFlag not null, uin:", paramString, " type:", Integer.valueOf(paramInt1) });
        return;
        ((aong)localObject).saveRecentUser(localRecentUser);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.a().a();
    RecentUser localRecentUser = (RecentUser)paramQQAppInterface.findRecentUser(paramString, paramInt);
    if (localRecentUser == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendsStatusUtil", 2, new Object[] { "recentuser is null, uin:", paramString });
      }
      if (paramLong > 0L)
      {
        paramString = new RecentUser(paramString, paramInt);
        paramString.showUpTime = paramLong;
        paramString.opTime = paramLong;
        paramQQAppInterface.saveRecentUser(paramString);
      }
      return;
    }
    localRecentUser.showUpTime = paramLong;
    localRecentUser.opTime = Math.max(localRecentUser.opTime, localRecentUser.showUpTime);
    paramQQAppInterface.saveRecentUser(localRecentUser);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramQQAppInterface, paramString, paramInt, paramLong, paramBoolean1, paramBoolean2, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, @Nullable ExtensionInfo paramExtensionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendsStatusUtil", 4, "setTopPosition top: " + paramLong + " uin: " + paramString + " userType: " + paramInt + " needUpdateDataBase" + paramBoolean1);
    }
    FriendsStatusUtil.UpdateFriendStatusItem localUpdateFriendStatusItem = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13578, 18, 0L);
    localUpdateFriendStatusItem.a(paramLong);
    if (paramBoolean1) {
      a(paramQQAppInterface, localUpdateFriendStatusItem, paramExtensionInfo);
    }
    if (paramBoolean2)
    {
      a(paramQQAppInterface);
      b(paramQQAppInterface, paramString);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, @Nullable ExtensionInfo paramExtensionInfo, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendsStatusUtil", 4, "setTopPosition operateTime: " + paramLong + " uin: " + paramString + " userType: " + paramInt + " needSend" + paramBoolean1);
    }
    anmw localanmw = (anmw)paramQQAppInterface.getManager(51);
    if (!localanmw.b(paramString)) {
      return;
    }
    long l = 0L;
    Object localObject = paramExtensionInfo;
    if (paramExtensionInfo == null) {
      localObject = localanmw.a(paramString);
    }
    if (localObject != null) {
      l = ((ExtensionInfo)localObject).openDoNotDisturbTime;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendsStatusUtil", 4, "isOpenDoNotDisturb uin=" + paramString);
    }
    paramExtensionInfo = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13579, 19, l);
    paramExtensionInfo.b(paramLong);
    if ((!b(paramQQAppInterface, paramExtensionInfo, (ExtensionInfo)localObject)) && (QLog.isColorLevel())) {
      QLog.d("FriendsStatusUtil", 2, "saveFriendDoNotDisturbToDataBase=false");
    }
    boolean bool = paramBoolean3;
    if (!paramBoolean1)
    {
      bool = paramBoolean3;
      if (paramBoolean3)
      {
        bool = false;
        localObject = new Intent("action_donot_disturb_resp");
        ((Intent)localObject).putExtra("key_uin", paramString);
        if (paramLong == 0L) {
          break label351;
        }
        paramBoolean3 = true;
        label249:
        ((Intent)localObject).putExtra("key_swtich", paramBoolean3);
        BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
      }
    }
    a(paramQQAppInterface);
    if (paramBoolean2)
    {
      if (paramLong != 0L)
      {
        paramBoolean2 = true;
        label286:
        a(paramBoolean2, paramString, paramQQAppInterface);
      }
    }
    else {
      if (paramLong == 0L) {
        break label363;
      }
    }
    label351:
    label363:
    for (paramInt = 1;; paramInt = 0)
    {
      b(paramQQAppInterface, paramString, paramInt);
      if (!paramBoolean1) {
        break;
      }
      paramString = new ArrayList(1);
      paramString.add(paramExtensionInfo);
      ((FriendListHandler)paramQQAppInterface.a(1)).a(paramExtensionInfo.jdField_a_of_type_Int, paramString, "OidbSvc.0x5d6_19", bool);
      return;
      paramBoolean3 = false;
      break label249;
      paramBoolean2 = false;
      break label286;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (!bgnt.g(null)) {
      return;
    }
    long l = 0L;
    if (paramBoolean) {
      l = NetConnInfoCenter.getServerTime();
    }
    paramString = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13578, 18);
    paramString.a(l);
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramString);
    ((FriendListHandler)paramQQAppInterface.a(1)).a(paramString.jdField_a_of_type_Int, localArrayList, "OidbSvc.0x5d6_18", false);
  }
  
  public static void a(Map<String, Boolean> paramMap, QQAppInterface paramQQAppInterface)
  {
    paramMap = paramMap.entrySet().iterator();
    int i = 0;
    if (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (!a(paramQQAppInterface, ((Boolean)localEntry.getValue()).booleanValue(), (String)localEntry.getKey(), null)) {
        break label76;
      }
      i = 1;
    }
    label76:
    for (;;)
    {
      break;
      if (i != 0) {
        a(paramQQAppInterface);
      }
      return;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramBoolean) {}
    for (Object localObject = anni.a(2131703727);; localObject = anni.a(2131703730))
    {
      localObject = new auxc(paramString, paramQQAppInterface.getCurrentAccountUin(), (String)localObject, 0, -5023, 655385, 0L);
      MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
      localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, (auxc)localObject);
      auxd.a(paramQQAppInterface, localMessageForUniteGrayTip);
      if (QLog.isColorLevel()) {
        QLog.d("FriendsStatusUtil", 2, new Object[] { "isOpen=", Boolean.valueOf(paramBoolean), "friendUin=", paramString });
      }
      return;
    }
  }
  
  private static void a(boolean paramBoolean, List<FriendsStatusUtil.UpdateFriendStatusItem> paramList, List<oidb_0x5d6.SnsUpateResult> paramList1, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendsStatusUtil", 2, "handleTopPosition successFromServer: " + paramBoolean);
    }
    if (!paramBoolean)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        b(paramQQAppInterface, ((FriendsStatusUtil.UpdateFriendStatusItem)paramList.next()).jdField_a_of_type_JavaLangString);
      }
      paramQQAppInterface.runOnUiThread(new FriendsStatusUtil.1());
      return;
    }
    paramList1 = paramList1.iterator();
    int i = 0;
    while (paramList1.hasNext())
    {
      oidb_0x5d6.SnsUpateResult localSnsUpateResult = (oidb_0x5d6.SnsUpateResult)paramList1.next();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        FriendsStatusUtil.UpdateFriendStatusItem localUpdateFriendStatusItem = (FriendsStatusUtil.UpdateFriendStatusItem)localIterator.next();
        if (localSnsUpateResult.uint64_uin.get() == Long.parseLong(localUpdateFriendStatusItem.jdField_a_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendsStatusUtil", 2, "handleTopPosition uin: " + localUpdateFriendStatusItem.jdField_a_of_type_JavaLangString + " result: " + localSnsUpateResult.uint32_result.get());
          }
          if (localSnsUpateResult.uint32_result.get() != 0)
          {
            i = 1;
          }
          else
          {
            a(paramQQAppInterface, localUpdateFriendStatusItem.jdField_a_of_type_JavaLangString, 0, localUpdateFriendStatusItem.a(), true, false);
            b(paramQQAppInterface, localUpdateFriendStatusItem.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
    if (i != 0) {
      paramQQAppInterface.runOnUiThread(new FriendsStatusUtil.2());
    }
    a(paramQQAppInterface);
  }
  
  private static void a(boolean paramBoolean1, List<FriendsStatusUtil.UpdateFriendStatusItem> paramList, List<oidb_0x5d6.SnsUpateResult> paramList1, QQAppInterface paramQQAppInterface, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendsStatusUtil", 2, "handleDoNotDisturb successFromServer: " + paramBoolean1);
    }
    if (!paramBoolean1)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramList1 = (FriendsStatusUtil.UpdateFriendStatusItem)paramList.next();
        a(paramQQAppInterface, paramList1.jdField_a_of_type_JavaLangString, 0, paramList1.jdField_a_of_type_Long, false, false, null, paramBoolean2);
      }
      a(paramQQAppInterface);
      paramQQAppInterface.runOnUiThread(new FriendsStatusUtil.3());
    }
    int i;
    do
    {
      return;
      paramList1 = paramList1.iterator();
      i = 0;
      while (paramList1.hasNext())
      {
        oidb_0x5d6.SnsUpateResult localSnsUpateResult = (oidb_0x5d6.SnsUpateResult)paramList1.next();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          FriendsStatusUtil.UpdateFriendStatusItem localUpdateFriendStatusItem = (FriendsStatusUtil.UpdateFriendStatusItem)localIterator.next();
          if (localSnsUpateResult.uint64_uin.get() == Long.parseLong(localUpdateFriendStatusItem.jdField_a_of_type_JavaLangString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendsStatusUtil", 2, "handleDoNotDisturb uin: " + localUpdateFriendStatusItem.jdField_a_of_type_JavaLangString + " result: " + localSnsUpateResult.uint32_result.get());
            }
            if (localSnsUpateResult.uint32_result.get() != 0)
            {
              if (localUpdateFriendStatusItem.a() > 0L) {
                localUpdateFriendStatusItem.b(0L);
              }
              for (;;)
              {
                a(paramQQAppInterface, localUpdateFriendStatusItem.jdField_a_of_type_JavaLangString, 0, localUpdateFriendStatusItem.a(), false, false, null, paramBoolean2);
                i = 1;
                break;
                localUpdateFriendStatusItem.b(localUpdateFriendStatusItem.jdField_a_of_type_Long);
              }
            }
            if (localUpdateFriendStatusItem.a() != 0L) {}
            for (paramBoolean1 = true;; paramBoolean1 = false)
            {
              a(paramBoolean1, localUpdateFriendStatusItem.jdField_a_of_type_JavaLangString, paramQQAppInterface);
              break;
            }
          }
        }
      }
    } while (i == 0);
    a(paramQQAppInterface);
    paramQQAppInterface.runOnUiThread(new FriendsStatusUtil.4());
  }
  
  public static boolean a(Context paramContext)
  {
    int i = SettingCloneUtil.readValueForInt(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
    int j = (int)NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel()) {
      QLog.d("FriendsStatusUtil", 4, "canDisturb curServerTime=" + j + " isNoDisturbMode=" + i);
    }
    return j <= i;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, FriendsStatusUtil.UpdateFriendStatusItem paramUpdateFriendStatusItem, @Nullable ExtensionInfo paramExtensionInfo)
  {
    anmw localanmw = (anmw)paramQQAppInterface.getManager(51);
    ExtensionInfo localExtensionInfo = paramExtensionInfo;
    if (paramExtensionInfo == null)
    {
      paramExtensionInfo = localanmw.a(String.valueOf(paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString));
      localExtensionInfo = paramExtensionInfo;
      if (paramExtensionInfo == null)
      {
        paramExtensionInfo = new ExtensionInfo();
        paramExtensionInfo.uin = String.valueOf(paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString);
        localExtensionInfo = paramExtensionInfo;
        if (QLog.isColorLevel())
        {
          QLog.d("FriendsStatusUtil", 4, "saveTopPositionToDataBase new create");
          localExtensionInfo = paramExtensionInfo;
        }
      }
    }
    long l = paramUpdateFriendStatusItem.a();
    if (QLog.isColorLevel()) {
      QLog.d("FriendsStatusUtil", 4, "saveTopPositionToDataBase DB TOP=" + localExtensionInfo.topPositionTime + " update top=" + l + " uin=" + paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString);
    }
    if (l == -1L) {
      return false;
    }
    if (localExtensionInfo.topPositionTime != l)
    {
      localExtensionInfo.topPositionTime = l;
      localanmw.a(localExtensionInfo);
      a(paramQQAppInterface, paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString, 0, l);
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    boolean bool = true;
    paramQQAppInterface = (anmw)paramQQAppInterface.getManager(51);
    if ((paramRecentUser.getType() == 0) && (paramQQAppInterface.b(paramRecentUser.uin)))
    {
      paramQQAppInterface = paramQQAppInterface.a(String.valueOf(paramRecentUser.uin));
      if ((paramQQAppInterface == null) || (paramQQAppInterface.topPositionTime == paramRecentUser.showUpTime) || (paramQQAppInterface.topPositionTime == -1L)) {
        return paramRecentUser.showUpTime > 0L;
      }
      if (QLog.isColorLevel()) {
        new StringBuilder("checkNeedTopPosition uin=").append(paramRecentUser.uin).append(" showupTime").append(paramRecentUser.showUpTime).append(" topPosition").append(paramQQAppInterface.topPositionTime);
      }
      if (paramQQAppInterface.topPositionTime != paramRecentUser.showUpTime) {
        paramRecentUser.showUpTime = paramQQAppInterface.topPositionTime;
      }
    }
    if (paramRecentUser.showUpTime > 0L) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, int paramInt)
  {
    QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(paramRecentUser.uin, paramRecentUser.getType());
    int i;
    if ((localMessage == null) || (localMessage.msgtype == 0))
    {
      i = 1;
      if (paramInt != 1) {
        break label58;
      }
      if (i != 0)
      {
        paramRecentUser.lastmsgdrafttime = 0L;
        paramRecentUser.lastmsgtime = 0L;
      }
    }
    label58:
    do
    {
      do
      {
        do
        {
          return false;
          i = 0;
          break;
        } while (paramRecentUser.showUpTime > 0L);
        if (i != 0) {
          return true;
        }
      } while (paramRecentUser.getType() != 1);
      paramInt = paramQQAppInterface.b(paramRecentUser.uin);
    } while ((paramInt != 2) && (paramInt != 3));
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool = true;
    Object localObject = paramQQAppInterface.a().a();
    if ((paramString == null) || (paramString.length() == 0) || (localObject == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("FriendsStatusUtil", 2, "isChatAtTop params error, return false.");
      }
    }
    do
    {
      return false;
      localObject = (RecentUser)((aong)localObject).findRecentUser(paramString, paramInt);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendsStatusUtil", 2, "isChatAtTop result is: " + ((RecentUser)localObject).showUpTime);
        }
        if (((RecentUser)localObject).showUpTime > 0L) {}
        for (bool = true;; bool = false) {
          return bool;
        }
      }
      paramQQAppInterface = ((anmw)paramQQAppInterface.getManager(51)).a(String.valueOf(paramString));
    } while (paramQQAppInterface == null);
    if (QLog.isColorLevel()) {
      QLog.d("FriendsStatusUtil", 2, "isChatAtTop extensionInfo is: " + paramQQAppInterface.topPositionTime);
    }
    if (paramQQAppInterface.topPositionTime > 0L) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("FriendsStatusUtil", 2, "setChatAtTop params error, return false.");
      }
    }
    while (!bgnt.g(null)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendsStatusUtil", 2, "setChatAtTop top: " + paramBoolean + " uin: " + paramString + " userType: " + paramInt);
    }
    a(paramQQAppInterface, paramString, paramBoolean);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString, @Nullable ExtensionInfo paramExtensionInfo)
  {
    anmw localanmw = (anmw)paramQQAppInterface.getManager(51);
    ExtensionInfo localExtensionInfo = paramExtensionInfo;
    if (paramExtensionInfo == null)
    {
      paramExtensionInfo = localanmw.a(String.valueOf(paramString));
      localExtensionInfo = paramExtensionInfo;
      if (paramExtensionInfo == null)
      {
        paramExtensionInfo = new ExtensionInfo();
        paramExtensionInfo.uin = String.valueOf(paramString);
        localExtensionInfo = paramExtensionInfo;
        if (QLog.isColorLevel())
        {
          QLog.d("tag_hidden_chat", 4, "saveSwitchToExtensionInfo new create ");
          localExtensionInfo = paramExtensionInfo;
        }
      }
    }
    if (paramBoolean) {}
    for (int i = 1; localExtensionInfo.hiddenChatSwitch != i; i = 0)
    {
      localExtensionInfo.hiddenChatSwitch = i;
      localanmw.a(localExtensionInfo);
      a(paramQQAppInterface, paramString, 0, i);
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString, @Nullable ExtensionInfo paramExtensionInfo)
  {
    anmw localanmw = (anmw)paramQQAppInterface.getManager(51);
    paramQQAppInterface = paramExtensionInfo;
    if (paramExtensionInfo == null)
    {
      paramExtensionInfo = localanmw.a(String.valueOf(paramString));
      paramQQAppInterface = paramExtensionInfo;
      if (paramExtensionInfo == null)
      {
        paramExtensionInfo = new ExtensionInfo();
        paramExtensionInfo.uin = String.valueOf(paramString);
        paramQQAppInterface = paramExtensionInfo;
        if (QLog.isColorLevel())
        {
          QLog.d("tag_msg_notification", 4, "saveSwitchToExtensionInfo new create ");
          paramQQAppInterface = paramExtensionInfo;
        }
      }
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 2)) {
      return false;
    }
    byte b = paramArrayOfByte[1];
    int j;
    int k;
    if ((b & 0x1) == 0)
    {
      j = 1;
      if ((b & 0x2) != 0) {
        break label347;
      }
      k = 1;
      label106:
      if ((b & 0x4) != 0) {
        break label353;
      }
      i = 1;
      label116:
      if (QLog.isColorLevel()) {
        QLog.d("FriendsStatusUtil", 2, new Object[] { "saveNotificationFlagSwitchToExtensionInfo: invoked. ", " byte1: ", Byte.valueOf(b), " uin: ", paramString });
      }
      if (j == 0) {
        break label359;
      }
      j = 0;
      label170:
      if (k == 0) {
        break label365;
      }
      k = 0;
      label178:
      if (i == 0) {
        break label371;
      }
    }
    label347:
    label353:
    label359:
    label365:
    label371:
    for (int i = 0;; i = 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendsStatusUtil", 2, new Object[] { "saveNotificationFlagSwitchToExtensionInfo: invoked. ", " messageEnablePreviewValue: ", Integer.valueOf(j), " messageEnableVibrateValue: ", Integer.valueOf(k), " messageEnableSoundValue: ", Integer.valueOf(i) });
      }
      if ((paramQQAppInterface.messageEnablePreviewNew == j) && (paramQQAppInterface.messageEnableVibrateNew == k) && (paramQQAppInterface.messageEnableSoundNew == i)) {
        break label377;
      }
      paramQQAppInterface.messageEnablePreviewNew = j;
      paramQQAppInterface.messageEnableVibrateNew = k;
      paramQQAppInterface.messageEnableSoundNew = i;
      localanmw.a(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("FriendsStatusUtil", 2, new Object[] { "saveNotificationFlagSwitchToExtensionInfo: invoked. switch changed. ", " messageEnableSoundValue: ", Integer.valueOf(i) });
      }
      return true;
      j = 0;
      break;
      k = 0;
      break label106;
      i = 0;
      break label116;
      j = 1;
      break label170;
      k = 1;
      break label178;
    }
    label377:
    return false;
  }
  
  public static boolean a(@NonNull String paramString, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (anmw)paramQQAppInterface.getManager(51);
    if (!paramQQAppInterface.b(paramString)) {}
    do
    {
      return false;
      paramString = paramQQAppInterface.a(paramString);
    } while (paramString == null);
    if (paramString.openDoNotDisturbTime > 0L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(SubMsgType0x27.SnsUpdateItem paramSnsUpdateItem, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramSnsUpdateItem.uint32_update_sns_type.get() == 13578)
    {
      paramString = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13578, 18);
      if (!paramSnsUpdateItem.bytes_value.has()) {
        paramString.a(null);
      }
      for (;;)
      {
        a(paramQQAppInterface, paramString, null);
        return true;
        paramString.a(paramSnsUpdateItem.bytes_value.get().toByteArray());
      }
    }
    if (paramSnsUpdateItem.uint32_update_sns_type.get() == 13581)
    {
      paramString = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13581, 21);
      if ((!paramSnsUpdateItem.bytes_value.has()) || (paramSnsUpdateItem.bytes_value.get().toByteArray().length == 0)) {
        paramString.a(null);
      }
      for (;;)
      {
        a(paramQQAppInterface, paramString, null);
        return true;
        paramString.a(paramSnsUpdateItem.bytes_value.get().toByteArray());
      }
    }
    if (paramSnsUpdateItem.uint32_update_sns_type.get() == 13579)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendsStatusUtil", 2, "免打扰在线push");
      }
      paramString = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13579, 19);
      paramString.b(paramSnsUpdateItem.bytes_value.get().toByteArray());
      a(paramQQAppInterface, paramString, null);
      return true;
    }
    if (paramSnsUpdateItem.uint32_update_sns_type.get() == 13582)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendsStatusUtil", 2, "handelFriendStatusPush: invoked. from online push  snsItem: " + paramSnsUpdateItem);
      }
      paramString = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13582, 21);
      paramString.b(paramSnsUpdateItem.bytes_value.get().toByteArray());
      a(paramQQAppInterface, paramString, null);
      return true;
    }
    if (paramSnsUpdateItem.uint32_update_sns_type.get() == 13580)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendsStatusUtil", 2, "handelFriendStatusPush: invoked. from online push  UPDATE_SNS_TYPE_RING_ID");
      }
      paramString = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13580, 21);
      paramString.b(paramSnsUpdateItem.bytes_value.get().toByteArray());
      a(paramQQAppInterface, paramString, null);
      return true;
    }
    return false;
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getHandler(ChatSettingActivity.class);
    if (paramQQAppInterface != null)
    {
      Message localMessage = new Message();
      localMessage.what = 35;
      localMessage.obj = paramString;
      paramQQAppInterface.sendMessage(localMessage);
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject = paramQQAppInterface.getHandler(ChatSettingActivity.class);
    if (localObject != null)
    {
      Message localMessage = new Message();
      localMessage.what = 36;
      localMessage.obj = paramString;
      localMessage.arg1 = paramInt;
      ((MqqHandler)localObject).sendMessage(localMessage);
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(ProfileCardMoreActivity.class);
    if (paramQQAppInterface != null)
    {
      localObject = new Message();
      ((Message)localObject).what = 36;
      ((Message)localObject).obj = paramString;
      ((Message)localObject).arg1 = paramInt;
      paramQQAppInterface.sendMessage((Message)localObject);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    b(paramQQAppInterface, paramString, paramInt, paramLong, paramBoolean1, paramBoolean2, null);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, @Nullable ExtensionInfo paramExtensionInfo)
  {
    a(paramQQAppInterface, paramString, paramInt, paramLong, paramBoolean1, paramBoolean2, paramExtensionInfo, false);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, FriendsStatusUtil.UpdateFriendStatusItem paramUpdateFriendStatusItem, @Nullable ExtensionInfo paramExtensionInfo)
  {
    anmw localanmw = (anmw)paramQQAppInterface.getManager(51);
    paramQQAppInterface = paramExtensionInfo;
    if (paramExtensionInfo == null)
    {
      paramExtensionInfo = localanmw.a(String.valueOf(paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString));
      paramQQAppInterface = paramExtensionInfo;
      if (paramExtensionInfo == null)
      {
        paramExtensionInfo = new ExtensionInfo();
        paramExtensionInfo.uin = String.valueOf(paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString);
        paramQQAppInterface = paramExtensionInfo;
        if (QLog.isColorLevel())
        {
          QLog.d("FriendsStatusUtil", 4, "saveFriendDoNotDisturbToDataBase new create");
          paramQQAppInterface = paramExtensionInfo;
        }
      }
    }
    long l = paramUpdateFriendStatusItem.a();
    if (QLog.isColorLevel()) {
      QLog.d("FriendsStatusUtil", 4, new Object[] { "saveFriendDoNotDisturbToDataBase DB openDoNotDisturbTime=", Long.valueOf(paramQQAppInterface.openDoNotDisturbTime), " update time=", Long.valueOf(l), " uin=", paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString });
    }
    if (paramQQAppInterface.openDoNotDisturbTime != l)
    {
      paramQQAppInterface.openDoNotDisturbTime = l;
      localanmw.a(paramQQAppInterface);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.FriendsStatusUtil
 * JD-Core Version:    0.7.0.1
 */