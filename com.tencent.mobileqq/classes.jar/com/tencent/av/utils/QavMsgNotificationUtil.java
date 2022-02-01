package com.tencent.av.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.MessageNotificationGenerator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.dating.MsgBoxUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.managers.MsgPushReportHelper;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.IAssociatedAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class QavMsgNotificationUtil
{
  private static Intent a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramInt == 1)
    {
      if (paramBoolean) {
        return a(paramQQAppInterface, paramQQAppInterface.getApp(), paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord);
      }
      if ((paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1020) && (paramMessageRecord.istroop != 1004)) {
        return a(paramQQAppInterface, paramQQAppInterface.getApp(), paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord);
      }
      Intent localIntent = new Intent(paramQQAppInterface.getApp(), SplashActivity.class);
      localIntent.putExtra("tab_index", FrameControllerUtil.a);
      localIntent.putExtra("conversation_index", 1);
      localIntent.setFlags(335544320);
      localIntent.putExtra("uinname", paramQQAppInterface.getTroopDisscussMemberNick(paramMessageRecord.frienduin, paramString, paramMessageRecord.istroop, true));
      paramQQAppInterface = localIntent;
    }
    else
    {
      paramMessageRecord = new Intent(paramQQAppInterface.getApp(), SplashActivity.class);
      paramMessageRecord.putExtra("tab_index", FrameControllerUtil.a);
      paramMessageRecord.putExtra("conversation_index", 1);
      paramMessageRecord.setFlags(335544320);
      paramMessageRecord.putExtra("uinname", paramQQAppInterface.getApp().getString(2131694524));
      paramQQAppInterface = paramMessageRecord;
    }
    return paramQQAppInterface;
  }
  
  public static Intent a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(paramString))
    {
      paramString = paramContext.getString(2131693135);
      paramContext = new Intent(paramContext, MsgBoxListActivity.class);
      paramQQAppInterface = AppConstants.LBS_HELLO_UIN;
      if (!MsgBoxUtil.b(paramMessageRecord)) {
        paramQQAppInterface = AppConstants.NEARBY_LBS_HELLO_UIN;
      }
      paramContext.putExtra("uin", paramQQAppInterface);
      paramContext.putExtra("uintype", 1001);
      paramQQAppInterface = paramString;
    }
    else if (String.valueOf(AppConstants.FRIEND_SYSTEM_MSG_UIN).equals(paramString))
    {
      paramQQAppInterface = paramContext.getString(2131719404);
      paramContext = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getNewFriendJumpIntent(paramContext);
      paramContext.putExtra("from", "from_notification");
      paramContext.putExtra("EntranceId", 1);
    }
    else if (String.valueOf(AppConstants.TROOP_SYSTEM_MSG_UIN).equals(paramString))
    {
      paramQQAppInterface = paramContext.getString(2131719404);
      paramContext = new Intent(paramContext, QPublicFragmentActivity.class);
      paramContext.putExtra("public_fragment_class", ((ILaunchTroopSysMsgUIUtilApi)QRoute.api(ILaunchTroopSysMsgUIUtilApi.class)).getFragmentNameForLaunch());
      paramContext.putExtra("_key_mode", 1);
      paramContext.putExtra("key_tab_mode", 2);
    }
    else if (String.valueOf(AppConstants.QQBROADCAST_MSG_UIN).equals(paramString))
    {
      paramString = new Intent(paramContext, QQBroadcastActivity.class);
      paramQQAppInterface = paramContext.getString(2131719403);
      paramContext = paramString;
    }
    else if (String.valueOf(AppConstants.VOTE_MSG_UIN).equals(paramString))
    {
      paramString = paramContext.getString(2131719404);
      paramContext = new Intent(paramContext, VisitorsActivity.class);
      paramContext.putExtra("votersOnly", true);
      paramContext.putExtra("toUin", Long.valueOf(paramQQAppInterface.getCurrentAccountUin()));
      paramQQAppInterface = paramString;
    }
    else if (String.valueOf(AppConstants.DATALINE_PC_UIN).equals(paramString))
    {
      paramString = new Intent(paramContext, LiteActivity.class);
      paramString.putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
      paramQQAppInterface = paramContext.getString(2131693779);
      paramContext = paramString;
    }
    else if (String.valueOf(AppConstants.DATALINE_IPAD_UIN).equals(paramString))
    {
      paramString = new Intent(paramContext, LiteActivity.class);
      paramString.putExtra("targetUin", AppConstants.DATALINE_IPAD_UIN);
      paramQQAppInterface = paramContext.getString(2131693780);
      paramContext = paramString;
    }
    else
    {
      Object localObject = new Intent(paramQQAppInterface.getApp(), SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", FrameControllerUtil.a);
      ((Intent)localObject).putExtra("conversation_index", 1);
      ((Intent)localObject).setFlags(335544320);
      if (paramInt == 7000)
      {
        paramMessageRecord = paramContext.getString(2131719304);
        ((Intent)localObject).setClass(paramContext, ((IAssociatedAccountApi)QRoute.api(IAssociatedAccountApi.class)).getAssociatedAccountActivity());
        ((Intent)localObject).putExtra("subAccount", paramString);
        paramQQAppInterface = (ISubAccountService)paramQQAppInterface.getRuntimeService(ISubAccountService.class, "");
        if (paramQQAppInterface != null) {
          paramQQAppInterface = paramQQAppInterface.getLatestUinNick(paramString);
        } else {
          paramQQAppInterface = paramString;
        }
        ((Intent)localObject).putExtra("subAccountLatestNick", paramQQAppInterface);
        ((Intent)localObject).putExtra("finishAIO", true);
        paramQQAppInterface = paramMessageRecord;
        paramContext = (Context)localObject;
      }
      else
      {
        if (paramInt != 1009) {
          break label544;
        }
        paramQQAppInterface = paramContext.getString(2131718365);
        paramContext = (Context)localObject;
      }
      for (;;)
      {
        break;
        label544:
        if (String.valueOf(1787740092L).equals(paramString))
        {
          paramQQAppInterface = paramContext.getString(2131690087);
          paramContext = (Context)localObject;
        }
        else if (paramInt == 1024)
        {
          ((Intent)localObject).setClass(paramContext, SplashActivity.class);
          paramContext = AIOUtils.a((Intent)localObject, null);
          paramContext.putExtra("chat_subType", 1);
          paramQQAppInterface = ContactUtils.a(paramQQAppInterface, paramString, paramInt);
        }
        else if ((paramInt != 1001) && (paramInt != 1010) && (paramInt != 10002))
        {
          if (paramInt == 1032)
          {
            paramQQAppInterface = paramContext.getString(2131698706);
            paramContext = new Intent(paramContext, MsgBoxListActivity.class);
            paramString = AppConstants.CONFESS_UIN;
            paramContext.putExtra("uin", paramString);
            paramContext.putExtra("uintype", paramInt);
          }
          else
          {
            paramQQAppInterface = ContactUtils.a(paramQQAppInterface, paramString, paramInt);
            paramContext = (Context)localObject;
          }
        }
        else
        {
          localObject = paramContext.getString(2131699038);
          paramContext = new Intent(paramContext, MsgBoxListActivity.class);
          paramQQAppInterface = AppConstants.LBS_HELLO_UIN;
          if (!MsgBoxUtil.b(paramMessageRecord)) {
            paramQQAppInterface = AppConstants.NEARBY_LBS_HELLO_UIN;
          }
          paramContext.putExtra("uin", paramQQAppInterface);
          paramContext.putExtra("uintype", paramInt);
          paramQQAppInterface = (QQAppInterface)localObject;
        }
      }
      paramContext.putExtra("uin", paramString);
      paramContext.putExtra("uintype", paramInt);
    }
    paramContext.putExtra("uinname", paramQQAppInterface);
    return paramContext;
  }
  
  private static Bitmap a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean, MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt == 1) {
      if (paramBoolean)
      {
        paramQQAppInterface = (DiscussionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
        localObject1 = localObject2;
        if (paramQQAppInterface != null) {
          return paramQQAppInterface.a(paramMessageRecord.frienduin, true);
        }
      }
      else
      {
        if (AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(paramMessageRecord.frienduin)) {
          return paramQQAppInterface.getFaceBitmap(paramString, true);
        }
        if ((paramMessageRecord.istroop != 1001) && (paramMessageRecord.istroop != 10002) && (paramMessageRecord.istroop != 1010)) {
          return paramQQAppInterface.getFaceBitmap(paramMessageRecord.frienduin, true);
        }
        localObject1 = paramQQAppInterface.getStrangerFaceBitmap(paramMessageRecord.frienduin, 200);
      }
    }
    return localObject1;
  }
  
  private static String a(QQAppInterface paramQQAppInterface, QCallFacade paramQCallFacade, String paramString, int paramInt)
  {
    int i = paramQCallFacade.a();
    paramQCallFacade = paramString;
    if (i > 1)
    {
      paramQCallFacade = paramString;
      if (paramInt == 1)
      {
        if (i > 100)
        {
          paramQCallFacade = new StringBuilder();
          paramQCallFacade.append(paramString);
          paramQCallFacade.append(" (");
          paramQCallFacade.append(paramQQAppInterface.getApp().getString(2131694511));
          paramQCallFacade.append(")");
          return paramQCallFacade.toString();
        }
        paramQCallFacade = new StringBuilder();
        paramQCallFacade.append(paramString);
        paramQCallFacade.append(" (");
        paramQCallFacade.append(i);
        paramQCallFacade.append(paramQQAppInterface.getApp().getString(2131694448));
        paramQCallFacade.append(")");
        paramQCallFacade = paramQCallFacade.toString();
      }
    }
    return paramQCallFacade;
  }
  
  private static String a(MessageRecord paramMessageRecord, QCallFacade paramQCallFacade)
  {
    String str2 = paramMessageRecord.senderuin;
    String str1;
    if (paramMessageRecord.msgtype != -2016)
    {
      str1 = str2;
      if (paramMessageRecord.msgtype != -4008) {}
    }
    else
    {
      paramMessageRecord = paramQCallFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      str1 = str2;
      if (paramMessageRecord != null) {
        str1 = paramMessageRecord.senderUin;
      }
    }
    return str1;
  }
  
  @Nullable
  private static String a(MessageRecord paramMessageRecord, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (paramMessageRecord.istroop == 1008)
    {
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append(paramString2);
      paramMessageRecord.append(paramString3);
      paramString2 = paramMessageRecord.toString();
    }
    else if (paramMessageRecord.istroop != 7000)
    {
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append(paramString2);
      paramMessageRecord.append(paramString1);
      paramString2 = paramMessageRecord.toString();
    }
    if (!paramBoolean) {
      paramString2 = null;
    }
    return paramString2;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("receivedMsgNotification , size is:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",isOnline is:");
      localStringBuilder.append(paramBoolean2);
      QLog.d("QavMsgNotificationUtil", 2, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      if (paramMessageRecord == null) {
        return;
      }
      if (a(paramQQAppInterface.getCurrentAccountUin(), paramMessageRecord)) {
        return;
      }
      if (b(paramQQAppInterface, paramMessageRecord)) {
        return;
      }
      if (a(paramQQAppInterface, paramMessageRecord)) {
        return;
      }
      if (UserguideActivity.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavMsgNotificationUtil", 2, "receivedMsgNotification , showUserGuide");
        }
        return;
      }
      if (GuardManager.a != null) {
        GuardManager.a.b(0, null);
      }
      boolean bool = ((KeyguardManager)paramQQAppInterface.getApp().getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
      if (b(paramMessageRecord)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isBackground_Pause:");
        localStringBuilder.append(paramQQAppInterface.isBackgroundPause);
        QLog.d("QavMsgNotificationUtil", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isBackground_Stop:");
        localStringBuilder.append(paramQQAppInterface.isBackgroundStop);
        QLog.d("QavMsgNotificationUtil", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isScreenLocked:");
        localStringBuilder.append(bool);
        QLog.d("QavMsgNotificationUtil", 2, localStringBuilder.toString());
      }
      if (((paramQQAppInterface.isBackgroundPause) || (paramQQAppInterface.isBackgroundStop) || (bool)) && ((paramMessageRecord.istroop == 6000) || (paramQQAppInterface.userActiveStatus == 0) || (((paramMessageRecord.istroop != 1001) && (paramMessageRecord.istroop != 10002)) || ((paramMessageRecord.msgtype == -3001) || (paramMessageRecord.istroop == 1008))))) {
        a(paramQQAppInterface, paramMessageRecord, paramBoolean1, paramBoolean2);
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    boolean bool = NoDisturbUtil.a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showInComingMsg ,isFinished=");
      ((StringBuilder)localObject1).append(paramQQAppInterface.isFinished);
      ((StringBuilder)localObject1).append(", isCanDisturb=");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(", needTicker=");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(", message=");
      ((StringBuilder)localObject1).append(paramMessageRecord);
      QLog.d("QavMsgNotificationUtil", 2, ((StringBuilder)localObject1).toString());
    }
    if (!paramQQAppInterface.isFinished)
    {
      if (!bool) {
        return;
      }
      QCallFacade localQCallFacade = (QCallFacade)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      if (localQCallFacade == null) {
        return;
      }
      Object localObject3 = a(paramMessageRecord, localQCallFacade);
      int i = localQCallFacade.b();
      if (i == 0) {
        return;
      }
      bool = a(paramMessageRecord);
      Intent localIntent = a(paramQQAppInterface, i, bool, paramMessageRecord, (String)localObject3);
      Object localObject4 = a(paramQQAppInterface, i, bool, paramMessageRecord, (String)localObject3);
      Object localObject5 = "";
      if ((i == 1) && (bool)) {
        localObject2 = ContactUtils.a(paramQQAppInterface, (String)localObject3, 0);
      } else {
        localObject2 = "";
      }
      localIntent.putExtra("key_notification_click_action", true);
      Object localObject6 = localIntent.getStringExtra("uinname");
      if (localObject6 != null)
      {
        localObject1 = localObject6;
        if (!"".equals(localObject6)) {}
      }
      else
      {
        localObject1 = localIntent.getStringExtra("uin");
      }
      if (localObject2 != null)
      {
        localObject6 = localObject2;
        if (!"".equals(localObject2)) {}
      }
      else
      {
        localObject6 = localObject3;
      }
      String str = localQCallFacade.a((String)localObject6, bool);
      int j = paramMessageRecord.istroop;
      if (j != 1008) {
        if (j != 1010) {
          if (j != 3000) {
            if (j != 7000)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(": ");
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject3 = localObject2;
              localObject2 = localObject4;
            }
          }
        }
      }
      label752:
      do
      {
        do
        {
          localObject5 = str;
          localObject4 = localObject3;
          localObject3 = localObject5;
          break label925;
          localObject4 = localIntent.getStringExtra("subAccountLatestNick");
          localObject2 = localObject3;
          if (localObject4 != null) {
            if (((String)localObject4).length() == 0) {
              localObject2 = localObject3;
            } else {
              localObject2 = localObject4;
            }
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append("-");
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(":");
          ((StringBuilder)localObject3).append(str);
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject2);
          ((StringBuilder)localObject4).append(":");
          ((StringBuilder)localObject4).append(str);
          localObject4 = ((StringBuilder)localObject4).toString();
          localObject2 = null;
          break label752;
          localObject2 = ContactUtils.a(paramQQAppInterface, (String)localObject3, 0);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("(");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append("):");
          localObject2 = ((StringBuilder)localObject3).toString();
          break;
          if (i > 1)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(": ");
            localObject2 = ((StringBuilder)localObject2).toString();
            break;
          }
          localObject2 = ContactUtils.g(paramQQAppInterface, paramMessageRecord.frienduin);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("(");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append("):");
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append((String)localObject2);
          ((StringBuilder)localObject5).append(": ");
          ((StringBuilder)localObject5).append(str);
          localObject5 = ((StringBuilder)localObject5).toString();
          localObject2 = localObject4;
          localObject4 = localObject5;
          localObject5 = localObject4;
          localObject4 = localObject3;
          localObject3 = localObject5;
          break label925;
          localObject6 = SkinUtils.a(paramQQAppInterface.getApp().getResources().getDrawable(2130840424));
          localObject4 = XMLMessageUtils.a(paramMessageRecord);
          localObject2 = localObject6;
          localObject3 = localObject5;
        } while (localObject4 == null);
        localObject2 = localObject6;
        localObject3 = localObject5;
      } while (((PAMessage)localObject4).items.isEmpty());
      Object localObject2 = ((PAMessage.Item)((PAMessage)localObject4).items.get(0)).title;
      if ((((PAMessage.Item)((PAMessage)localObject4).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList != null))
      {
        localObject3 = (String)((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList.get(0);
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      localObject3 = localObject2;
      localObject4 = localObject5;
      localObject2 = localObject6;
      label925:
      localObject4 = a(paramMessageRecord, paramBoolean, str, (String)localObject4, (String)localObject3);
      localObject1 = a(paramQQAppInterface, localQCallFacade, (String)localObject1, i);
      a(paramMessageRecord, localIntent);
      a(paramQQAppInterface, paramMessageRecord, paramBoolean, localIntent, bool);
      MessageNotificationGenerator.a(paramQQAppInterface, paramMessageRecord, new NotificationElement(localIntent, (String)localObject4, (String)localObject1, (String)localObject3, (Bitmap)localObject2), "CMD_SHOW_NOTIFIYCATION");
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean1, Intent paramIntent, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramMessageRecord.istroop != 6000) && (paramMessageRecord.istroop != 1009))
    {
      if (paramMessageRecord.frienduin.equals(AppConstants.RECOMMEND_CONTACT_UIN)) {
        return;
      }
      if (QQUtils.a(paramQQAppInterface.getApp()))
      {
        QQLSRecentManager localQQLSRecentManager = (QQLSRecentManager)paramQQAppInterface.getManager(QQManagerFactory.QQLS_DATA_MANAGER);
        paramBoolean1 = SettingCloneUtil.readValue(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.getApp().getString(2131693837), "qqsetting_lock_screen_whenexit_key", true);
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, String.format("videochatting start lsActivity from appinterface  showInComingMsgForQAV, lockScreenMsgWhenExit[%s]", new Object[] { Boolean.valueOf(paramBoolean1) }));
        }
        if (paramBoolean1)
        {
          if (paramBoolean2)
          {
            localQQLSRecentManager.a(paramQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.istroop, true, MsgPushReportHelper.a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramIntent));
            return;
          }
          localQQLSRecentManager.a(paramQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.istroop, false, MsgPushReportHelper.a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramIntent));
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramQQAppInterface.isShowMsgContent()) {
      a(paramQQAppInterface, paramMessageRecord, true);
    } else {
      b(paramQQAppInterface, paramMessageRecord, true);
    }
    int j = 0;
    int i = j;
    if (paramQQAppInterface.userActiveStatus == 0)
    {
      i = j;
      if (paramBoolean1) {
        i = 1;
      }
    }
    if (paramMessageRecord.istroop != 1001)
    {
      j = i;
      if (paramMessageRecord.istroop != 10002) {}
    }
    else
    {
      j = i;
      if (paramMessageRecord.msgtype == -3001) {
        j = 1;
      }
    }
    i = j;
    if (paramMessageRecord.istroop == 1008) {
      if ((paramMessageRecord.extStr == null) || ((paramMessageRecord.extLong & 0x1) != 0) || (!paramMessageRecord.extStr.contains("lockDisplay")))
      {
        i = j;
        if (paramMessageRecord.extStr != null)
        {
          i = j;
          if ((paramMessageRecord.extLong & 0x1) == 1)
          {
            i = j;
            if (!paramMessageRecord.getExtInfoFromExtStr("lockDisplay").equals("true")) {}
          }
        }
      }
      else
      {
        i = j;
        if (paramBoolean1) {
          i = 1;
        }
      }
    }
    j = i;
    if (paramMessageRecord.istroop == 1008)
    {
      j = i;
      if (AppConstants.REMINDER_UIN.equals(paramMessageRecord.senderuin)) {
        j = 1;
      }
    }
    if (j != 0) {
      paramQQAppInterface.vibratorAndAudio(paramMessageRecord, paramBoolean2, true);
    }
  }
  
  private static void a(MessageRecord paramMessageRecord, Intent paramIntent)
  {
    if ((paramMessageRecord.msgtype != -2016) && (paramMessageRecord.msgtype != -4008))
    {
      if (paramMessageRecord.msgtype == -2009)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QavMsgNotificationUtil", 2, "AVNotify:MSG_TYPE_MEDIA_VIDEO");
        }
        paramIntent.putExtra("qav_notify_flag", true);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("QavMsgNotificationUtil", 2, "AVNotify:MSG_TYPE_MULTI_VIDEO");
      }
      if (paramMessageRecord.istroop == 3000)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QavMsgNotificationUtil", 2, "AVNotify:UIN_TYPE_DISCUSSION");
        }
        paramIntent.putExtra("qav_notify_flag", true);
      }
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((String.valueOf(AppConstants.NEW_KANDIAN_UIN).equals(paramMessageRecord.frienduin)) && (1008 == paramMessageRecord.istroop)) {
      return true;
    }
    return (String.valueOf(AppConstants.KANDIAN_MERGE_UIN).equals(paramMessageRecord.frienduin)) && (7220 == paramMessageRecord.istroop) && (!((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).needKanDianNotification(paramMessageRecord));
  }
  
  private static boolean a(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord.msgtype == -2016) || (paramMessageRecord.msgtype == -4008)) && (paramMessageRecord.istroop == 3000);
  }
  
  private static boolean a(String paramString, MessageRecord paramMessageRecord)
  {
    if ((1000 != paramMessageRecord.istroop) && (1020 != paramMessageRecord.istroop))
    {
      if ((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(paramString)) && (paramMessageRecord.msgtype != -4008))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavMsgNotificationUtil", 2, "receivedMsgNotification ,self message");
        }
        return true;
      }
    }
    else if ((paramMessageRecord.frienduin != null) && (paramMessageRecord.frienduin.equalsIgnoreCase(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavMsgNotificationUtil", 2, "receivedMsgNotification , stranger  self message");
      }
      return true;
    }
    return false;
  }
  
  private static void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((!paramQQAppInterface.isFinished) && (NoDisturbUtil.a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface)))
    {
      Object localObject = (QCallFacade)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      if (localObject == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("notification", 4, String.format("showQavNotificationNoPreview fail 2, message:%s", new Object[] { paramMessageRecord }));
        }
        return;
      }
      int i = ((QCallFacade)localObject).b();
      if (i == 0) {
        return;
      }
      Intent localIntent;
      if (i == 1)
      {
        if (((paramMessageRecord.msgtype == -2016) || (paramMessageRecord.msgtype == -4008)) && (paramMessageRecord.istroop == 3000)) {}
        for (localIntent = a(paramQQAppInterface, paramQQAppInterface.getApp(), paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord);; localIntent = a(paramQQAppInterface, paramQQAppInterface.getApp(), paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord))
        {
          break label281;
          if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1020) || (paramMessageRecord.istroop == 1004)) {
            break;
          }
        }
        localIntent = new Intent(paramQQAppInterface.getApp(), SplashActivity.class);
        localIntent.putExtra("tab_index", FrameControllerUtil.a);
        localIntent.putExtra("conversation_index", 1);
        localIntent.setFlags(335544320);
      }
      else
      {
        localIntent = new Intent(paramQQAppInterface.getApp(), SplashActivity.class);
        localIntent.putExtra("tab_index", FrameControllerUtil.a);
        localIntent.putExtra("conversation_index", 1);
        localIntent.setFlags(335544320);
      }
      label281:
      localIntent.putExtra("key_notification_click_action", true);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramQQAppInterface.getApp().getString(2131694529));
      int j = ((QCallFacade)localObject).a();
      if (j == 0) {
        return;
      }
      if (j > 1000)
      {
        localStringBuffer.append(paramQQAppInterface.getApp().getString(2131694509));
      }
      else
      {
        localStringBuffer.append(j);
        localStringBuffer.append(paramQQAppInterface.getApp().getString(2131694512));
      }
      localObject = null;
      if (paramBoolean) {
        localObject = localStringBuffer.toString();
      }
      StringBuilder localStringBuilder;
      if (paramMessageRecord.msgtype == -2016)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("AVNotify:MSG_TYPE_MULTI_VIDEO, count:");
          localStringBuilder.append(i);
          QLog.e("notification", 2, localStringBuilder.toString());
        }
        if (paramMessageRecord.istroop == 3000)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("AVNotify:UIN_TYPE_DISCUSSION, count:");
            localStringBuilder.append(i);
            QLog.e("notification", 2, localStringBuilder.toString());
          }
          localIntent.putExtra("qav_notify_flag", true);
        }
      }
      else if (paramMessageRecord.msgtype == -2009)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("AVNotify:MSG_TYPE_MEDIA_VIDEO, count:");
          localStringBuilder.append(i);
          QLog.e("notification", 2, localStringBuilder.toString());
        }
        localIntent.putExtra("qav_notify_flag", true);
      }
      MessageNotificationGenerator.a(paramQQAppInterface, paramMessageRecord, new NotificationElement(localIntent, (String)localObject, paramQQAppInterface.getApp().getResources().getString(2131694524), localStringBuffer.toString(), null), "CMD_SHOW_NOTIFIYCATION");
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("notification", 4, String.format("showQavNotificationNoPreview fail 1, message:%s", new Object[] { paramMessageRecord }));
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.senderuin != null) && (1008 == paramMessageRecord.istroop) && (TroopBarAssistantManager.a().a(paramQQAppInterface, paramMessageRecord.senderuin, paramMessageRecord.istroop))) {
      return true;
    }
    if (paramMessageRecord.istroop == 1008) {
      if (paramMessageRecord.extStr != null)
      {
        if (((paramMessageRecord.extLong & 0x1) == 0) && (!paramMessageRecord.extStr.contains("lockDisplay"))) {
          return true;
        }
        if ((paramMessageRecord.extStr != null) && (((paramMessageRecord.extLong & 0x1) != 1) || (paramMessageRecord.getExtInfoFromExtStr("lockDisplay").equals("true")))) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  private static boolean b(MessageRecord paramMessageRecord)
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (ActivityManager.RunningTaskInfo)((List)localObject).get(0);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("locking activity:");
        localStringBuilder.append(((ActivityManager.RunningTaskInfo)localObject).topActivity.getClassName());
        QLog.d("QavMsgNotificationUtil", 2, localStringBuilder.toString());
      }
      localObject = ((ActivityManager.RunningTaskInfo)localObject).topActivity.getClassName();
      if ((((String)localObject).equals("com.tencent.av.ui.VideoInviteLock")) || (((String)localObject).equals("com.tencent.av.gaudio.GaInviteLockActivity")) || (((String)localObject).equals("com.tencent.av.ui.AVActivity")))
      {
        i = 1;
        break label135;
      }
    }
    int i = 0;
    label135:
    int j;
    if ((paramMessageRecord.msgtype == -2016) && (paramMessageRecord.istroop == 3000)) {
      j = 1;
    } else {
      j = 0;
    }
    return (i != 0) && (j != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.QavMsgNotificationUtil
 * JD-Core Version:    0.7.0.1
 */