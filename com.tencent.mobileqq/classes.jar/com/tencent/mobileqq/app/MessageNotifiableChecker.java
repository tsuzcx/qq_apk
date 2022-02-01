package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.aio.qcircle.QCircleChatUtil;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxManager;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager;
import com.tencent.mobileqq.notification.modularize.OnlineModulePushReceiverKt;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime.Status;
import org.jetbrains.annotations.Nullable;

public class MessageNotifiableChecker
{
  private final int jdField_a_of_type_Int;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final boolean jdField_a_of_type_Boolean;
  
  public MessageNotifiableChecker(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    if (QLog.isColorLevel())
    {
      if ((paramQQAppInterface.isBackgroundPause) || (paramQQAppInterface.isBackgroundStop)) {
        bool = true;
      }
      QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, new Object[] { "MessageNotifiableChecker ", "size is:", Integer.valueOf(paramInt), "isRunBackground :", Boolean.valueOf(bool), " needSoundVibrationsTip: ", Boolean.valueOf(paramBoolean1), " isOnline: ", Boolean.valueOf(paramBoolean2) });
    }
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    boolean bool1 = NoDisturbUtil.a(localBaseApplication.getApplicationContext(), paramQQAppInterface);
    boolean bool2 = FriendsStatusUtil.a(paramMessage.frienduin, paramQQAppInterface);
    boolean bool3 = HiddenChatHelper.a(paramMessage.frienduin, paramMessage.istroop, paramQQAppInterface);
    boolean bool4 = NewMsgNotificationManager.a(paramQQAppInterface).a(paramMessage);
    boolean bool5 = NoDisturbUtil.b(localBaseApplication.getApplicationContext(), paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "currentAppSettingStateNeedNotification ,isFinished=" + paramQQAppInterface.isFinished + ", isCanDisturb=" + bool1 + ", newMsgNotificationEnabled=" + bool4 + ", message=" + paramMessage);
    }
    if ((paramQQAppInterface.isFinished) || (!bool1) || (bool2) || (bool3) || (!bool4) || (bool5)) {
      return false;
    }
    if (Utils.b(paramMessage.frienduin))
    {
      paramQQAppInterface = BaseApplicationImpl.getContext();
      paramMessage = ((ActivityManager)paramQQAppInterface.getSystemService("activity")).getRunningTasks(1);
      if ((paramMessage != null) && (paramMessage.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQAppInterface", 2, "BabyQ topActivity packageName: " + ((ActivityManager.RunningTaskInfo)paramMessage.get(0)).topActivity.getPackageName());
        }
        if (paramQQAppInterface.getPackageName().equals(((ActivityManager.RunningTaskInfo)paramMessage.get(0)).topActivity.getPackageName())) {
          return false;
        }
      }
    }
    return true;
  }
  
  private boolean b(QQMessageFacade paramQQMessageFacade, Message paramMessage)
  {
    if ((1008 == paramMessage.istroop) && ("2747277822".equals(paramMessage.frienduin)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "receive gamecenter push message " + this.jdField_a_of_type_Int);
      }
      ((IApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(1, paramQQMessageFacade.a("2747277822", 1008, this.jdField_a_of_type_Int));
    }
    return 1036 == paramMessage.istroop;
  }
  
  private boolean k(Message paramMessage)
  {
    if (QCircleChatUtil.a(paramMessage)) {
      return true;
    }
    if (((TempMsgBoxManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(paramMessage.frienduin, paramMessage.istroop)) {
      return true;
    }
    return TextUtils.equals(paramMessage.frienduin, AppConstants.TROOP_SUSPICIOUS_MSG_UIN);
  }
  
  private boolean l(Message paramMessage)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isTroopMark(paramMessage)) && (!paramMessage.needNotification()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage , isTroopMark");
      }
      return true;
    }
    return false;
  }
  
  private boolean m(Message paramMessage)
  {
    return (1008 == paramMessage.istroop) && (paramMessage.senderuin != null) && (TroopBarAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.senderuin, paramMessage.istroop));
  }
  
  private boolean n(Message paramMessage)
  {
    return UinTypeUtil.d(paramMessage.senderuin);
  }
  
  private boolean o(Message paramMessage)
  {
    return paramMessage.msgtype == -2058;
  }
  
  private boolean p(Message paramMessage)
  {
    if (paramMessage.istroop == 1008)
    {
      int i;
      if ((paramMessage.extStr == null) || (((paramMessage.extLong & 0x1) == 0) && (!paramMessage.extStr.contains("lockDisplay"))))
      {
        i = 1;
        if ((paramMessage.extStr != null) && (((paramMessage.extLong & 0x1) != 1) || (paramMessage.getExtInfoFromExtStr("lockDisplay").equals("true")))) {
          break label98;
        }
      }
      label98:
      for (int j = 1;; j = 0)
      {
        if ((i == 0) && (j == 0)) {
          break label103;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.refreshAppBadge();
        return true;
        i = 0;
        break;
      }
    }
    label103:
    return false;
  }
  
  private boolean q(Message paramMessage)
  {
    if ((LimitChatUtil.b(paramMessage)) && (LimitChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage))) {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "isNeedForbidExtendFriendChatMessage return true for limit chat");
      }
    }
    do
    {
      return true;
      if ((!LimitChatUtil.a(paramMessage)) || (!LimitChatUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "isNeedForbidExtendFriendChatMessage return true for match chat");
    return true;
    return false;
  }
  
  private boolean r(Message paramMessage)
  {
    if (TextUtils.equals(paramMessage.getExtInfoFromExtStr("msg_in_box"), "msg_in_box"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage, not show message InMsgBox");
      }
      return true;
    }
    return false;
  }
  
  private boolean s(Message paramMessage)
  {
    if ((1008 == paramMessage.istroop) && ((AppConstants.NEW_KANDIAN_UIN.equals(paramMessage.frienduin)) || (AppConstants.OLD_KANDIAN_UIN.equals(paramMessage.frienduin)))) {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage, not show newKandian");
      }
    }
    do
    {
      return true;
      if ((7220 != paramMessage.istroop) || (!AppConstants.KANDIAN_MERGE_UIN.equals(paramMessage.frienduin)) || (ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage, not show mergeKandian");
    return true;
    return false;
  }
  
  public Intent a(Message paramMessage, Intent paramIntent)
  {
    ForegroundNotifyManager localForegroundNotifyManager = ForegroundNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool2 = ((KeyguardManager)BaseApplicationImpl.context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    boolean bool3 = OnlineModulePushReceiverKt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((bool3) || (bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Intent localIntent = paramIntent;
      if (localForegroundNotifyManager != null)
      {
        localIntent = paramIntent;
        if (h(paramMessage))
        {
          localIntent = paramIntent;
          if (!bool1)
          {
            paramIntent = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin, paramMessage.istroop);
            localIntent = localForegroundNotifyManager.b(paramMessage.istroop, paramMessage.frienduin, paramIntent, 28);
            ReportHelperKt.a("0X800AFCD", localForegroundNotifyManager.a(paramMessage.istroop));
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, new Object[] { "getMiniAioIntentIfNeed: invoked. ", " appBackgroundOrLocked: ", Boolean.valueOf(bool1), " isScreenLocked: ", Boolean.valueOf(bool2), " app.isBackgroundStop: ", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop), " isAppBackground: ", Boolean.valueOf(bool3), " foregroundNotifyManager: ", localForegroundNotifyManager });
      }
      return localIntent;
    }
  }
  
  @Nullable
  QQMessageFacade a()
  {
    if (this.jdField_a_of_type_Int == 0) {}
    QQMessageFacade localQQMessageFacade;
    do
    {
      return null;
      localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    } while (localQQMessageFacade == null);
    return localQQMessageFacade;
  }
  
  void a()
  {
    if (GuardManager.a != null) {
      GuardManager.a.b(0, null);
    }
  }
  
  void a(Message paramMessage)
  {
    if (((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002)) && (paramMessage.msgtype == -3001)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        OpenAppClient.a(BaseApplication.context, paramMessage.action);
      }
      return;
    }
  }
  
  boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus() == AppRuntime.Status.dnd)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage, online status is dnd");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.refreshAppBadge();
      return true;
    }
    return false;
  }
  
  boolean a(Message paramMessage)
  {
    boolean bool1 = ((KeyguardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("inKeyguardRestrictedInputMode", new Object[0]);
    int i;
    label89:
    label113:
    boolean bool5;
    boolean bool6;
    boolean bool2;
    label164:
    boolean bool3;
    if ((AppConstants.KANDIAN_LOCKSCREEN_INTERACT_MSG_UIN.equals(paramMessage.frienduin)) && (ReadInJoyUtils.d()))
    {
      i = 1;
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop) && (!bool1) && (i == 0)) {
        break label319;
      }
      bool1 = true;
      ForegroundNotifyManager localForegroundNotifyManager = ForegroundNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((localForegroundNotifyManager == null) || (!localForegroundNotifyManager.a())) {
        break label324;
      }
      i = 1;
      bool5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.messageNotifiableChecker.g(paramMessage);
      bool6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.messageNotifiableChecker.j(paramMessage);
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.messageNotifiableChecker.h(paramMessage)) || ((bool1) && (i != 0))) {
        break label329;
      }
      bool2 = true;
      if ((!bool1) || ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.userActiveStatus != 0) && (!bool5)) || (!bool6)) {
        break label335;
      }
      bool3 = true;
      label191:
      if ((!bool2) && (!bool3)) {
        break label341;
      }
    }
    label319:
    label324:
    label329:
    label335:
    label341:
    for (boolean bool4 = true;; bool4 = false)
    {
      QLog.d("QQAppInterface", 1, new Object[] { "[notification] [foreground] [state] currentDeviceStateNeedNotification: invoked. ", " mainProcessBackground: ", Boolean.valueOf(bool1), " needNotificationMessage: ", Boolean.valueOf(bool5), " foregroundMessagePushEnabled: ", Boolean.valueOf(bool2), " mainProcBackgroundPushEnabled: ", Boolean.valueOf(bool3), " subProcFgPushEnabled: ", Boolean.valueOf(bool6), " needNotification: ", Boolean.valueOf(bool4) });
      return bool4;
      i = 0;
      break;
      bool1 = false;
      break label89;
      i = 0;
      break label113;
      bool2 = false;
      break label164;
      bool3 = false;
      break label191;
    }
  }
  
  boolean a(QQMessageFacade paramQQMessageFacade, Message paramMessage)
  {
    if (paramMessage == null) {}
    while ((b(paramMessage)) || (l(paramMessage)) || (b(paramQQMessageFacade, paramMessage)) || (m(paramMessage)) || (n(paramMessage)) || (o(paramMessage)) || (p(paramMessage)) || (q(paramMessage)) || (r(paramMessage)) || (s(paramMessage)) || (a()) || (a(this.jdField_a_of_type_Boolean, paramMessage)) || (c(paramMessage)) || (k(paramMessage))) {
      return true;
    }
    return false;
  }
  
  boolean a(boolean paramBoolean, Message paramMessage)
  {
    if (paramMessage.istroop == 1038)
    {
      int i = ((AppletsFolderManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER)).a(paramMessage);
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage, not show message because unreadFlag is " + i);
      }
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.vibratorAndAudioForMsg(paramMessage, paramBoolean);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.refreshAppBadge();
      }
      return true;
    }
    return false;
  }
  
  boolean b(Message paramMessage)
  {
    if ((1000 == paramMessage.istroop) || (1020 == paramMessage.istroop))
    {
      if ((paramMessage.frienduin == null) || (!paramMessage.frienduin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break label102;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage , stranger  self message");
      }
    }
    do
    {
      return true;
      if ((paramMessage.senderuin == null) || (!paramMessage.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage ,self message");
    return true;
    label102:
    return false;
  }
  
  boolean c(Message paramMessage)
  {
    if ((FriendsStatusUtil.a(paramMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (HiddenChatHelper.a(paramMessage.frienduin, paramMessage.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {}
    do
    {
      return true;
      if (!UserguideActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage , showUserGuide");
    return true;
    if (NewFriendManager.a(paramMessage))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage , isSuspiciousSysMsg");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.refreshAppBadge();
      return true;
    }
    return false;
  }
  
  boolean d(Message paramMessage)
  {
    if (paramMessage.istroop == 9002) {
      if ((paramMessage.msgData != null) && (paramMessage.msgData.length > 0))
      {
        ActivateFriendsManager localActivateFriendsManager = (ActivateFriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
        if (!localActivateFriendsManager.a(paramMessage.msgData)) {
          return true;
        }
        if (localActivateFriendsManager.b(paramMessage.msgData)) {
          paramMessage.counter += this.jdField_a_of_type_Int;
        }
      }
    }
    for (;;)
    {
      return false;
      paramMessage.counter += this.jdField_a_of_type_Int;
      continue;
      if ((paramMessage.istroop == 7220) || (AppConstants.KANDIAN_DAILY_UIN.equals(paramMessage.frienduin))) {
        paramMessage.counter = 1;
      } else if ((AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(paramMessage.frienduin)) || (AppConstants.MAYKNOW_RECOMMEND_UIN.equals(paramMessage.frienduin))) {
        paramMessage.counter = this.jdField_a_of_type_Int;
      } else {
        paramMessage.counter += this.jdField_a_of_type_Int;
      }
    }
  }
  
  boolean e(Message paramMessage)
  {
    return (paramMessage.msgtype == -1013) || (paramMessage.msgtype == -2030) || (paramMessage.msgtype == -1047) || (paramMessage.msgtype == -1019) || (paramMessage.msgtype == -1018);
  }
  
  boolean f(Message paramMessage)
  {
    return (paramMessage.istroop == 6000) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.userActiveStatus == 0) || (((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002)) && (paramMessage.msgtype == -3001));
  }
  
  boolean g(Message paramMessage)
  {
    return (paramMessage.istroop == 6000) || (((paramMessage.istroop != 1001) && (paramMessage.istroop != 10002)) || ((paramMessage.msgtype == -3001) || (paramMessage.istroop == 1008) || (paramMessage.istroop == 9002) || (paramMessage.istroop == 7225)));
  }
  
  boolean h(Message paramMessage)
  {
    ForegroundNotifyManager localForegroundNotifyManager = ForegroundNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return (localForegroundNotifyManager != null) && (localForegroundNotifyManager.a(paramMessage));
  }
  
  boolean i(Message paramMessage)
  {
    return (paramMessage.istroop == 6000) || (((paramMessage.istroop != 1001) && (paramMessage.istroop != 10002)) || ((paramMessage.msgtype == -3001) || (paramMessage.istroop == 1008) || (paramMessage.istroop == 9002)));
  }
  
  boolean j(Message paramMessage)
  {
    boolean bool2 = false;
    ForegroundNotifyManager localForegroundNotifyManager = ForegroundNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localForegroundNotifyManager != null) && (!localForegroundNotifyManager.a()))
    {
      boolean bool1 = bool2;
      if (localForegroundNotifyManager.a(paramMessage.istroop))
      {
        bool1 = bool2;
        if (localForegroundNotifyManager.a(paramMessage.frienduin))
        {
          QLog.d("[NotificationRebuild] MessageNotifiableChecker", 1, new Object[] { "[foreground] [process] subProcFgPushEnabled: invoked. ", " isSubProcessBackgroundStop: ", Boolean.valueOf(false) });
          bool1 = localForegroundNotifyManager.b();
        }
      }
      return bool1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageNotifiableChecker
 * JD-Core Version:    0.7.0.1
 */