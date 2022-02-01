package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatManager;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatSettingFragment;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.fileassistant.top.FileAssistTopHandler;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateResult;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateItem;

public class FriendsStatusUtil
{
  public static int a(Context paramContext)
  {
    int i = SettingCloneUtil.readValueForInt(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
    int j = (int)NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("canDisturb curServerTime = [");
      paramContext.append(j);
      paramContext.append("] isNoDisturbMode=");
      paramContext.append(i);
      QLog.d("FriendsStatusUtil", 4, paramContext.toString());
    }
    if (j > i) {
      return 0;
    }
    return i - j;
  }
  
  public static void a(int paramInt, boolean paramBoolean1, List<FriendsStatusUtil.UpdateFriendStatusItem> paramList, List<oidb_0x5d6.SnsUpateResult> paramList1, QQAppInterface paramQQAppInterface, boolean paramBoolean2)
  {
    if (paramInt == 18)
    {
      a(paramBoolean1, paramList, paramList1, paramQQAppInterface);
      return;
    }
    if (paramInt == 19) {
      a(paramBoolean1, paramList, paramList1, paramQQAppInterface, paramBoolean2);
    }
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
    if (paramUpdateFriendStatusItem.jdField_a_of_type_Int == 18)
    {
      if (a(paramQQAppInterface, paramUpdateFriendStatusItem, paramExtensionInfo))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendsStatusUtil", 4, "handlePush differ from db");
        }
        a(paramQQAppInterface, paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString, 0, paramUpdateFriendStatusItem.a(), false, true, paramExtensionInfo);
      }
    }
    else if (paramUpdateFriendStatusItem.jdField_a_of_type_Int == 19)
    {
      if (b(paramQQAppInterface, paramUpdateFriendStatusItem, paramExtensionInfo))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendsStatusUtil", 4, "handlePush differ from db");
        }
        b(paramQQAppInterface, paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString, 0, paramUpdateFriendStatusItem.a(), false, true, paramExtensionInfo);
      }
    }
    else if (paramUpdateFriendStatusItem.jdField_a_of_type_Int == 21)
    {
      if (paramUpdateFriendStatusItem.b == 13581)
      {
        boolean bool;
        if (paramUpdateFriendStatusItem.a() != null) {
          bool = true;
        } else {
          bool = false;
        }
        if (a(paramQQAppInterface, bool, paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString, paramExtensionInfo)) {
          a(paramQQAppInterface);
        }
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
        if (paramUpdateFriendStatusItem.b == 13580)
        {
          FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          int i = (int)paramUpdateFriendStatusItem.a();
          paramQQAppInterface = paramExtensionInfo;
          if (paramExtensionInfo == null)
          {
            paramExtensionInfo = localFriendsManager.a(String.valueOf(paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString));
            paramQQAppInterface = paramExtensionInfo;
            if (paramExtensionInfo == null)
            {
              paramQQAppInterface = new ExtensionInfo();
              paramQQAppInterface.uin = String.valueOf(paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString);
              QLog.d("FriendsStatusUtil", 1, new Object[] { "handlePush: invoked. ", "create db entity ringId: ", Integer.valueOf(i) });
            }
          }
          paramQQAppInterface.friendRingId = i;
          localFriendsManager.a(paramQQAppInterface);
          if (QLog.isColorLevel())
          {
            paramUpdateFriendStatusItem = new StringBuilder();
            paramUpdateFriendStatusItem.append(" extensionInfo: ");
            paramUpdateFriendStatusItem.append(paramQQAppInterface.uin);
            QLog.d("FriendsStatusUtil", 2, new Object[] { "handleC2COnlinePush: invoked. UPDATE_SNS_TYPE_RING_ID", " ringId: ", Integer.valueOf(i), paramUpdateFriendStatusItem.toString() });
            return;
          }
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("FriendsStatusUtil", 1, "handlePush: failed. ", paramQQAppInterface);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = HardCodeUtil.a(2131705040);
    paramString = new UniteGrayTipParam(paramString, paramQQAppInterface.getCurrentAccountUin(), (String)localObject, 0, -5023, 655393, 0L);
    localObject = new Bundle();
    ((Bundle)localObject).putString("textColor", "#40A0FF");
    ((Bundle)localObject).putInt("key_action", 43);
    paramString.a(0, 6, (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramString);
    UniteGrayTipMsgUtil.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800A012", "0X800A012", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getProxyManager().a();
    paramString = paramQQAppInterface.a(paramString, paramInt);
    if (paramString != null)
    {
      paramString.opTime = NetConnInfoCenter.getServerTime();
      paramString.lastmsgtime = 0L;
      paramString.lastmsgdrafttime = 0L;
    }
    paramQQAppInterface.b(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = HiddenChatManager.a(paramQQAppInterface);
    boolean bool;
    if (paramInt2 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((HiddenChatManager)localObject).a(paramString, paramInt1, bool);
    localObject = paramQQAppInterface.getProxyManager().a();
    RecentUser localRecentUser = ((RecentUserProxy)localObject).b(paramString, paramInt1);
    if (localRecentUser == null)
    {
      QLog.d("FriendsStatusUtil", 1, new Object[] { "recentuserHiddenFlag is null, uin:", MobileQQ.getShortUinStr(paramString), " type:", Integer.valueOf(paramInt1), " state=", Integer.valueOf(paramInt2) });
      if (paramInt2 == 1)
      {
        localRecentUser = new RecentUser(paramString, paramInt1);
        localRecentUser.isHiddenChat = paramInt2;
        paramQQAppInterface = paramQQAppInterface.getMessageFacade().getLastMessage(paramString, paramInt1);
        if (paramQQAppInterface != null)
        {
          localRecentUser.lastmsgtime = paramQQAppInterface.time;
        }
        else
        {
          localRecentUser.lastmsgtime = 0L;
          localRecentUser.lastmsgdrafttime = 0L;
        }
        if (localRecentUser.lastmsgtime == 0L)
        {
          paramQQAppInterface = RecentDataListManager.a(localRecentUser.uin, localRecentUser.getType());
          RecentDataListManager.a().a(paramQQAppInterface);
        }
        ((RecentUserProxy)localObject).b(localRecentUser);
      }
    }
    else
    {
      QLog.d("FriendsStatusUtil", 1, new Object[] { "recentuserHiddenFlag not null, uin:", MobileQQ.getShortUinStr(paramString), " type:", Integer.valueOf(paramInt1), " state=", Integer.valueOf(paramInt2) });
      localRecentUser.isHiddenChat = paramInt2;
      if (a(paramQQAppInterface, localRecentUser, paramInt2))
      {
        ((RecentUserProxy)localObject).a(localRecentUser);
        return;
      }
      ((RecentUserProxy)localObject).b(localRecentUser);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.getProxyManager().a();
    RecentUser localRecentUser = paramQQAppInterface.b(paramString, paramInt);
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
        paramQQAppInterface.b(paramString);
      }
    }
    else
    {
      localRecentUser.showUpTime = paramLong;
      localRecentUser.opTime = Math.max(localRecentUser.opTime, localRecentUser.showUpTime);
      paramQQAppInterface.b(localRecentUser);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramQQAppInterface, paramString, paramInt, paramLong, paramBoolean1, paramBoolean2, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, @Nullable ExtensionInfo paramExtensionInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTopPosition top: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" uin: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" userType: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" needUpdateDataBase");
      ((StringBuilder)localObject).append(paramBoolean1);
      QLog.d("FriendsStatusUtil", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13578, 18, 0L);
    ((FriendsStatusUtil.UpdateFriendStatusItem)localObject).a(paramLong);
    if (paramBoolean1) {
      a(paramQQAppInterface, (FriendsStatusUtil.UpdateFriendStatusItem)localObject, paramExtensionInfo);
    }
    if (paramBoolean2)
    {
      a(paramQQAppInterface);
      b(paramQQAppInterface, paramString);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, @Nullable ExtensionInfo paramExtensionInfo, boolean paramBoolean3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTopPosition operateTime: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" uin: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" userType: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" needSend");
      ((StringBuilder)localObject).append(paramBoolean1);
      QLog.d("FriendsStatusUtil", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (!((FriendsManager)localObject).b(paramString)) {
      return;
    }
    if (paramExtensionInfo == null) {
      paramExtensionInfo = ((FriendsManager)localObject).a(paramString);
    }
    long l;
    if (paramExtensionInfo != null) {
      l = paramExtensionInfo.openDoNotDisturbTime;
    } else {
      l = 0L;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isOpenDoNotDisturb uin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("FriendsStatusUtil", 4, ((StringBuilder)localObject).toString());
    }
    localObject = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13579, 19, l);
    ((FriendsStatusUtil.UpdateFriendStatusItem)localObject).b(paramLong);
    if ((!b(paramQQAppInterface, (FriendsStatusUtil.UpdateFriendStatusItem)localObject, paramExtensionInfo)) && (QLog.isColorLevel())) {
      QLog.d("FriendsStatusUtil", 2, "saveFriendDoNotDisturbToDataBase=false");
    }
    paramInt = 0;
    if ((!paramBoolean1) && (paramBoolean3))
    {
      paramExtensionInfo = new Intent("action_donot_disturb_resp");
      paramExtensionInfo.putExtra("key_uin", paramString);
      if (paramLong != 0L) {
        paramBoolean3 = true;
      } else {
        paramBoolean3 = false;
      }
      paramExtensionInfo.putExtra("key_swtich", paramBoolean3);
      BaseApplicationImpl.getContext().sendBroadcast(paramExtensionInfo);
      paramBoolean3 = false;
    }
    a(paramQQAppInterface);
    if (paramBoolean2)
    {
      if (paramLong != 0L) {
        paramBoolean2 = true;
      } else {
        paramBoolean2 = false;
      }
      a(paramBoolean2, paramString, paramQQAppInterface);
    }
    if (paramLong != 0L) {
      paramInt = 1;
    }
    b(paramQQAppInterface, paramString, paramInt);
    if (paramBoolean1)
    {
      paramString = new ArrayList(1);
      paramString.add(localObject);
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).create0x5d6RequestPackage(((FriendsStatusUtil.UpdateFriendStatusItem)localObject).jdField_a_of_type_Int, paramString, "OidbSvc.0x5d6_19", paramBoolean3);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (!NetworkUtil.isNetworkAvailable(null)) {
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
    ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).create0x5d6RequestPackage(paramString.jdField_a_of_type_Int, localArrayList, "OidbSvc.0x5d6_18", false);
  }
  
  public static void a(Map<String, Boolean> paramMap, QQAppInterface paramQQAppInterface)
  {
    paramMap = paramMap.entrySet().iterator();
    int i = 0;
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (a(paramQQAppInterface, ((Boolean)localEntry.getValue()).booleanValue(), (String)localEntry.getKey(), null)) {
        i = 1;
      }
    }
    if (i != 0) {
      a(paramQQAppInterface);
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramBoolean) {
      localObject = HardCodeUtil.a(2131705038);
    } else {
      localObject = HardCodeUtil.a(2131705041);
    }
    Object localObject = new UniteGrayTipParam(paramString, paramQQAppInterface.getCurrentAccountUin(), (String)localObject, 0, -5023, 655385, 0L);
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject);
    UniteGrayTipMsgUtil.a(paramQQAppInterface, localMessageForUniteGrayTip);
    if (QLog.isColorLevel()) {
      QLog.d("FriendsStatusUtil", 2, new Object[] { "isOpen=", Boolean.valueOf(paramBoolean), "friendUin=", paramString });
    }
  }
  
  private static void a(boolean paramBoolean, List<FriendsStatusUtil.UpdateFriendStatusItem> paramList, List<oidb_0x5d6.SnsUpateResult> paramList1, QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleTopPosition successFromServer: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("FriendsStatusUtil", 2, ((StringBuilder)localObject).toString());
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
    int i = 0;
    paramList1 = paramList1.iterator();
    if (paramList1.hasNext())
    {
      localObject = (oidb_0x5d6.SnsUpateResult)paramList1.next();
      Iterator localIterator = paramList.iterator();
      int j = i;
      for (;;)
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        FriendsStatusUtil.UpdateFriendStatusItem localUpdateFriendStatusItem = (FriendsStatusUtil.UpdateFriendStatusItem)localIterator.next();
        if (((oidb_0x5d6.SnsUpateResult)localObject).uint64_uin.get() == Long.parseLong(localUpdateFriendStatusItem.jdField_a_of_type_JavaLangString))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleTopPosition uin: ");
            localStringBuilder.append(localUpdateFriendStatusItem.jdField_a_of_type_JavaLangString);
            localStringBuilder.append(" result: ");
            localStringBuilder.append(((oidb_0x5d6.SnsUpateResult)localObject).uint32_result.get());
            QLog.d("FriendsStatusUtil", 2, localStringBuilder.toString());
          }
          if (((oidb_0x5d6.SnsUpateResult)localObject).uint32_result.get() != 0)
          {
            j = 1;
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleDoNotDisturb successFromServer: ");
      ((StringBuilder)localObject).append(paramBoolean1);
      QLog.d("FriendsStatusUtil", 2, ((StringBuilder)localObject).toString());
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
      return;
    }
    paramList1 = paramList1.iterator();
    int i = 0;
    if (paramList1.hasNext())
    {
      localObject = (oidb_0x5d6.SnsUpateResult)paramList1.next();
      Iterator localIterator = paramList.iterator();
      int j = i;
      for (;;)
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        FriendsStatusUtil.UpdateFriendStatusItem localUpdateFriendStatusItem = (FriendsStatusUtil.UpdateFriendStatusItem)localIterator.next();
        if (((oidb_0x5d6.SnsUpateResult)localObject).uint64_uin.get() == Long.parseLong(localUpdateFriendStatusItem.jdField_a_of_type_JavaLangString))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleDoNotDisturb uin: ");
            localStringBuilder.append(localUpdateFriendStatusItem.jdField_a_of_type_JavaLangString);
            localStringBuilder.append(" result: ");
            localStringBuilder.append(((oidb_0x5d6.SnsUpateResult)localObject).uint32_result.get());
            QLog.d("FriendsStatusUtil", 2, localStringBuilder.toString());
          }
          if (((oidb_0x5d6.SnsUpateResult)localObject).uint32_result.get() != 0)
          {
            if (localUpdateFriendStatusItem.a() > 0L) {
              localUpdateFriendStatusItem.b(0L);
            } else {
              localUpdateFriendStatusItem.b(localUpdateFriendStatusItem.jdField_a_of_type_Long);
            }
            a(paramQQAppInterface, localUpdateFriendStatusItem.jdField_a_of_type_JavaLangString, 0, localUpdateFriendStatusItem.a(), false, false, null, paramBoolean2);
            j = 1;
          }
          else
          {
            if (localUpdateFriendStatusItem.a() != 0L) {
              paramBoolean1 = true;
            } else {
              paramBoolean1 = false;
            }
            a(paramBoolean1, localUpdateFriendStatusItem.jdField_a_of_type_JavaLangString, paramQQAppInterface);
          }
        }
      }
    }
    if (i != 0)
    {
      a(paramQQAppInterface);
      paramQQAppInterface.runOnUiThread(new FriendsStatusUtil.4());
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return NoDisturbUtil.a(paramContext);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface)
  {
    return ((FileAssistTopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FILE_ASSIST_TOP)).a();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, FriendsStatusUtil.UpdateFriendStatusItem paramUpdateFriendStatusItem, @Nullable ExtensionInfo paramExtensionInfo)
  {
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ExtensionInfo localExtensionInfo = paramExtensionInfo;
    if (paramExtensionInfo == null)
    {
      paramExtensionInfo = localFriendsManager.a(String.valueOf(paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString));
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
    if (QLog.isColorLevel())
    {
      paramExtensionInfo = new StringBuilder();
      paramExtensionInfo.append("saveTopPositionToDataBase DB TOP=");
      paramExtensionInfo.append(localExtensionInfo.topPositionTime);
      paramExtensionInfo.append(" update top=");
      paramExtensionInfo.append(l);
      paramExtensionInfo.append(" uin=");
      paramExtensionInfo.append(paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString);
      QLog.d("FriendsStatusUtil", 4, paramExtensionInfo.toString());
    }
    if (l == -1L) {
      return false;
    }
    if (localExtensionInfo.topPositionTime != l)
    {
      localExtensionInfo.topPositionTime = l;
      localFriendsManager.a(localExtensionInfo);
      a(paramQQAppInterface, paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString, 0, l);
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    Object localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((paramRecentUser.getType() == 0) && (((FriendsManager)localObject).b(paramRecentUser.uin)))
    {
      paramQQAppInterface = ((FriendsManager)localObject).a(String.valueOf(paramRecentUser.uin));
      if ((paramQQAppInterface != null) && (paramQQAppInterface.topPositionTime != paramRecentUser.showUpTime) && (paramQQAppInterface.topPositionTime != -1L))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder("checkNeedTopPosition uin=");
          ((StringBuilder)localObject).append(paramRecentUser.uin);
          ((StringBuilder)localObject).append(" showupTime");
          ((StringBuilder)localObject).append(paramRecentUser.showUpTime);
          ((StringBuilder)localObject).append(" topPosition");
          ((StringBuilder)localObject).append(paramQQAppInterface.topPositionTime);
        }
        if (paramQQAppInterface.topPositionTime != paramRecentUser.showUpTime) {
          paramRecentUser.showUpTime = paramQQAppInterface.topPositionTime;
        }
      }
      else
      {
        return paramRecentUser.showUpTime > 0L;
      }
    }
    else if ((AppConstants.FILE_ASSISTANT_UIN.equals(paramRecentUser.uin)) && (a(paramQQAppInterface)) && (paramRecentUser.showUpTime == 0L))
    {
      paramRecentUser.showUpTime = (System.currentTimeMillis() / 1000L);
    }
    return paramRecentUser.showUpTime > 0L;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, int paramInt)
  {
    com.tencent.imcore.message.Message localMessage = paramQQAppInterface.getMessageFacade().getLastMessage(paramRecentUser.uin, paramRecentUser.getType());
    int i;
    if ((localMessage != null) && (localMessage.msgtype != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (paramInt == 1)
    {
      if (i != 0)
      {
        paramRecentUser.lastmsgdrafttime = 0L;
        paramRecentUser.lastmsgtime = 0L;
      }
      return false;
    }
    if (paramRecentUser.showUpTime > 0L) {
      return false;
    }
    if (i != 0) {
      return true;
    }
    if (paramRecentUser.getType() == 1)
    {
      paramInt = paramQQAppInterface.getTroopMask(paramRecentUser.uin);
      if ((paramInt == 2) || (paramInt == 3)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject = paramQQAppInterface.getProxyManager().a();
    if ((paramString != null) && (paramString.length() != 0) && (localObject != null))
    {
      localObject = ((RecentUserProxy)localObject).b(paramString, paramInt);
      if (localObject != null)
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("isChatAtTop result is: ");
          paramQQAppInterface.append(((RecentUser)localObject).showUpTime);
          QLog.d("FriendsStatusUtil", 2, paramQQAppInterface.toString());
        }
        return ((RecentUser)localObject).showUpTime > 0L;
      }
      paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(String.valueOf(paramString));
      if (paramQQAppInterface != null)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("isChatAtTop extensionInfo is: ");
          paramString.append(paramQQAppInterface.topPositionTime);
          QLog.d("FriendsStatusUtil", 2, paramString.toString());
        }
        return paramQQAppInterface.topPositionTime > 0L;
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendsStatusUtil", 2, "isChatAtTop params error, return false.");
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (!NetworkUtil.isNetworkAvailable(null)) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setChatAtTop top: ");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(" uin: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" userType: ");
        localStringBuilder.append(paramInt);
        QLog.d("FriendsStatusUtil", 2, localStringBuilder.toString());
      }
      a(paramQQAppInterface, paramString, paramBoolean);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendsStatusUtil", 2, "setChatAtTop params error, return false.");
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString, @Nullable ExtensionInfo paramExtensionInfo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString, @Nullable ExtensionInfo paramExtensionInfo)
  {
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramExtensionInfo == null)
    {
      paramExtensionInfo = localFriendsManager.a(String.valueOf(paramString));
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
    else
    {
      paramQQAppInterface = paramExtensionInfo;
    }
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length < 2) {
        return false;
      }
      byte b = paramArrayOfByte[1];
      int i;
      if ((b & 0x1) == 0) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if ((b & 0x2) == 0) {
        j = 1;
      } else {
        j = 0;
      }
      int k;
      if ((b & 0x4) == 0) {
        k = 1;
      } else {
        k = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendsStatusUtil", 2, new Object[] { "saveNotificationFlagSwitchToExtensionInfo: invoked. ", " byte1: ", Byte.valueOf(b), " uin: ", paramString });
      }
      i ^= 0x1;
      j ^= 0x1;
      k ^= 0x1;
      if (QLog.isColorLevel()) {
        QLog.d("FriendsStatusUtil", 2, new Object[] { "saveNotificationFlagSwitchToExtensionInfo: invoked. ", " messageEnablePreviewValue: ", Integer.valueOf(i), " messageEnableVibrateValue: ", Integer.valueOf(j), " messageEnableSoundValue: ", Integer.valueOf(k) });
      }
      if ((paramQQAppInterface.messageEnablePreviewNew == i) && (paramQQAppInterface.messageEnableVibrateNew == j) && (paramQQAppInterface.messageEnableSoundNew == k)) {
        return false;
      }
      paramQQAppInterface.messageEnablePreviewNew = i;
      paramQQAppInterface.messageEnableVibrateNew = j;
      paramQQAppInterface.messageEnableSoundNew = k;
      localFriendsManager.a(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("FriendsStatusUtil", 2, new Object[] { "saveNotificationFlagSwitchToExtensionInfo: invoked. switch changed. ", " messageEnableSoundValue: ", Integer.valueOf(k) });
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(@NonNull String paramString, AppInterface paramAppInterface)
  {
    paramAppInterface = (FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    boolean bool2 = paramAppInterface.b(paramString);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    paramString = paramAppInterface.a(paramString);
    if (paramString == null) {
      return false;
    }
    if (paramString.openDoNotDisturbTime > 0L) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean a(SubMsgType0x27.SnsUpdateItem paramSnsUpdateItem, QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramSnsUpdateItem.uint32_update_sns_type.get() == 13578)
    {
      paramString = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13578, 18);
      if (!paramSnsUpdateItem.bytes_value.has()) {
        paramString.a(null);
      } else {
        paramString.a(paramSnsUpdateItem.bytes_value.get().toByteArray());
      }
      a(paramQQAppInterface, paramString, null);
      return true;
    }
    if (paramSnsUpdateItem.uint32_update_sns_type.get() == 13581)
    {
      paramString = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13581, 21);
      if ((paramSnsUpdateItem.bytes_value.has()) && (paramSnsUpdateItem.bytes_value.get().toByteArray().length != 0)) {
        paramString.a(paramSnsUpdateItem.bytes_value.get().toByteArray());
      } else {
        paramString.a(null);
      }
      a(paramQQAppInterface, paramString, null);
      return true;
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handelFriendStatusPush: invoked. from online push  snsItem: ");
        localStringBuilder.append(paramSnsUpdateItem);
        QLog.i("FriendsStatusUtil", 2, localStringBuilder.toString());
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
      android.os.Message localMessage = new android.os.Message();
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
      android.os.Message localMessage = new android.os.Message();
      localMessage.what = 36;
      localMessage.obj = paramString;
      localMessage.arg1 = paramInt;
      ((MqqHandler)localObject).sendMessage(localMessage);
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(ProfileCardMoreActivity.class);
    if (paramQQAppInterface != null)
    {
      localObject = new android.os.Message();
      ((android.os.Message)localObject).what = 36;
      ((android.os.Message)localObject).obj = paramString;
      ((android.os.Message)localObject).arg1 = paramInt;
      paramQQAppInterface.sendMessage((android.os.Message)localObject);
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
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    paramQQAppInterface = paramExtensionInfo;
    if (paramExtensionInfo == null)
    {
      paramExtensionInfo = localFriendsManager.a(String.valueOf(paramUpdateFriendStatusItem.jdField_a_of_type_JavaLangString));
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
      localFriendsManager.a(paramQQAppInterface);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.FriendsStatusUtil
 * JD-Core Version:    0.7.0.1
 */