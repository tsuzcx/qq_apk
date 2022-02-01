package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.aio.qcircle.QCircleChatUtil;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.notification.modularize.OnlineModulePushReceiverKt;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.api.IAppBadgeService;
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
      boolean bool = false;
      if ((paramQQAppInterface.isBackgroundPause) || (paramQQAppInterface.isBackgroundStop)) {
        bool = true;
      }
      QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, new Object[] { "MessageNotifiableChecker ", "size is:", Integer.valueOf(paramInt), "isRunBackground :", Boolean.valueOf(bool), " needSoundVibrationsTip: ", Boolean.valueOf(paramBoolean1), " isOnline: ", Boolean.valueOf(paramBoolean2) });
    }
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    Object localObject = paramQQAppInterface.getApp();
    boolean bool1 = NoDisturbUtil.a(((BaseApplication)localObject).getApplicationContext(), paramQQAppInterface);
    boolean bool2 = FriendsStatusUtil.a(paramMessage.frienduin, paramQQAppInterface);
    boolean bool3 = HiddenChatHelper.a(paramMessage.frienduin, paramMessage.istroop, paramQQAppInterface);
    boolean bool4 = NewMsgNotificationManager.a(paramQQAppInterface).a(paramMessage);
    boolean bool5 = NoDisturbUtil.b(((BaseApplication)localObject).getApplicationContext(), paramQQAppInterface);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("currentAppSettingStateNeedNotification ,isFinished=");
      ((StringBuilder)localObject).append(paramQQAppInterface.isFinished);
      ((StringBuilder)localObject).append(", isCanDisturb=");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(", newMsgNotificationEnabled=");
      ((StringBuilder)localObject).append(bool4);
      ((StringBuilder)localObject).append(", message=");
      ((StringBuilder)localObject).append(paramMessage);
      QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, ((StringBuilder)localObject).toString());
    }
    if ((!paramQQAppInterface.isFinished) && (bool1) && (!bool2) && (!bool3) && (bool4))
    {
      if (bool5) {
        return false;
      }
      if (Utils.b(paramMessage.frienduin))
      {
        paramQQAppInterface = BaseApplicationImpl.getContext();
        paramMessage = ((ActivityManager)paramQQAppInterface.getSystemService("activity")).getRunningTasks(1);
        if ((paramMessage != null) && (paramMessage.size() > 0))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("BabyQ topActivity packageName: ");
            ((StringBuilder)localObject).append(((ActivityManager.RunningTaskInfo)paramMessage.get(0)).topActivity.getPackageName());
            QLog.d("QQAppInterface", 2, ((StringBuilder)localObject).toString());
          }
          if (paramQQAppInterface.getPackageName().equals(((ActivityManager.RunningTaskInfo)paramMessage.get(0)).topActivity.getPackageName())) {
            return false;
          }
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean b(QQMessageFacade paramQQMessageFacade, Message paramMessage)
  {
    if ((1008 == paramMessage.istroop) && ("2747277822".equals(paramMessage.frienduin)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("receive gamecenter push message ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, localStringBuilder.toString());
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
    if (((ITempMsgBoxManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).isBelongToFilterBox(paramMessage.frienduin, paramMessage.istroop)) {
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
      if ((paramMessage.extStr != null) && (((paramMessage.extLong & 0x1) != 0) || (paramMessage.extStr.contains("lockDisplay")))) {
        i = 0;
      } else {
        i = 1;
      }
      int j;
      if ((paramMessage.extStr != null) && (((paramMessage.extLong & 0x1) != 1) || (paramMessage.getExtInfoFromExtStr("lockDisplay").equals("true")))) {
        j = 0;
      } else {
        j = 1;
      }
      if ((i != 0) || (j != 0))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) {
          ((IAppBadgeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean q(Message paramMessage)
  {
    if ((((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).isExtendMatchChatMsg(paramMessage)) && (((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).checkInterceptMatchMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "isNeedForbidExtendFriendChatMessage return true for match chat");
      }
      return true;
    }
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
    if ((1008 == paramMessage.istroop) && ((AppConstants.NEW_KANDIAN_UIN.equals(paramMessage.frienduin)) || (AppConstants.OLD_KANDIAN_UIN.equals(paramMessage.frienduin))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage, not show newKandian");
      }
      return true;
    }
    if ((7220 == paramMessage.istroop) && (AppConstants.KANDIAN_MERGE_UIN.equals(paramMessage.frienduin)) && (!((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).needKanDianNotification(paramMessage)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage, not show mergeKandian");
      }
      return true;
    }
    return false;
  }
  
  public Intent a(Message paramMessage, Intent paramIntent)
  {
    ForegroundNotifyManager localForegroundNotifyManager = ForegroundNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool2 = ((KeyguardManager)BaseApplicationImpl.context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    boolean bool3 = OnlineModulePushReceiverKt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool1;
    if ((!bool3) && (!bool2)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    Intent localIntent = paramIntent;
    if (localForegroundNotifyManager != null)
    {
      localIntent = paramIntent;
      if (h(paramMessage))
      {
        localIntent = paramIntent;
        if (!bool1)
        {
          paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin, paramMessage.istroop);
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
  
  @Nullable
  QQMessageFacade a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return null;
    }
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (localQQMessageFacade == null) {
      return null;
    }
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
    int i;
    if (((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002)) && (paramMessage.msgtype == -3001)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      OpenAppClient.a(BaseApplication.context, paramMessage.action);
    }
  }
  
  boolean a()
  {
    if (((IOnlineStatusService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOnlineStatusService.class)).getOnlineStatus() == AppRuntime.Status.dnd)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage, online status is dnd");
      }
      ((IAppBadgeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
      return true;
    }
    return false;
  }
  
  boolean a(Message paramMessage)
  {
    boolean bool1 = ((KeyguardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("inKeyguardRestrictedInputMode", new Object[0]);
    int i;
    if ((AppConstants.KANDIAN_LOCKSCREEN_INTERACT_MSG_UIN.equals(paramMessage.frienduin)) && (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).needNotificationForeground())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop) && (!bool1) && (i == 0)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    ForegroundNotifyManager localForegroundNotifyManager = ForegroundNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localForegroundNotifyManager != null) && (localForegroundNotifyManager.a())) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.messageNotifiableChecker.g(paramMessage);
    boolean bool6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.messageNotifiableChecker.j(paramMessage);
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.messageNotifiableChecker.h(paramMessage)) && ((!bool1) || (i == 0))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if ((bool1) && ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.userActiveStatus == 0) || (bool5)) && (bool6)) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool4;
    if ((!bool2) && (!bool3)) {
      bool4 = false;
    } else {
      bool4 = true;
    }
    QLog.d("QQAppInterface", 1, new Object[] { "[notification] [foreground] [state] currentDeviceStateNeedNotification: invoked. ", " mainProcessBackground: ", Boolean.valueOf(bool1), " needNotificationMessage: ", Boolean.valueOf(bool5), " foregroundMessagePushEnabled: ", Boolean.valueOf(bool2), " mainProcBackgroundPushEnabled: ", Boolean.valueOf(bool3), " subProcFgPushEnabled: ", Boolean.valueOf(bool6), " needNotification: ", Boolean.valueOf(bool4) });
    return bool4;
  }
  
  boolean a(QQMessageFacade paramQQMessageFacade, Message paramMessage)
  {
    if (paramMessage == null) {
      return true;
    }
    if (b(paramMessage)) {
      return true;
    }
    if (l(paramMessage)) {
      return true;
    }
    if (b(paramQQMessageFacade, paramMessage)) {
      return true;
    }
    if (m(paramMessage)) {
      return true;
    }
    if (n(paramMessage)) {
      return true;
    }
    if (o(paramMessage)) {
      return true;
    }
    if (p(paramMessage)) {
      return true;
    }
    if (q(paramMessage)) {
      return true;
    }
    if (r(paramMessage)) {
      return true;
    }
    if (s(paramMessage)) {
      return true;
    }
    if (a()) {
      return true;
    }
    if (a(this.jdField_a_of_type_Boolean, paramMessage)) {
      return true;
    }
    if (c(paramMessage)) {
      return true;
    }
    return k(paramMessage);
  }
  
  boolean a(boolean paramBoolean, Message paramMessage)
  {
    if (paramMessage.istroop == 1038)
    {
      int i = ((AppletsFolderManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER)).a(paramMessage);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleReceivedMessage, not show message because unreadFlag is ");
        localStringBuilder.append(i);
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, localStringBuilder.toString());
      }
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.vibratorAndAudioForMsg(paramMessage, paramBoolean);
        ((IAppBadgeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
      }
      return true;
    }
    return false;
  }
  
  boolean b(Message paramMessage)
  {
    if ((1000 != paramMessage.istroop) && (1020 != paramMessage.istroop))
    {
      if ((paramMessage.senderuin != null) && (paramMessage.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage ,self message");
        }
        return true;
      }
    }
    else if ((paramMessage.frienduin != null) && (paramMessage.frienduin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage , stranger  self message");
      }
      return true;
    }
    return false;
  }
  
  boolean c(Message paramMessage)
  {
    if (!FriendsStatusUtil.a(paramMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if (HiddenChatHelper.a(paramMessage.frienduin, paramMessage.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        return true;
      }
      if (UserguideActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage , showUserGuide");
        }
        return true;
      }
      if (((INewFriendApi)QRoute.api(INewFriendApi.class)).isSuspiciousSysMsg(paramMessage))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage , isSuspiciousSysMsg");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) {
          ((IAppBadgeService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
        }
        return true;
      }
      return false;
    }
    return true;
  }
  
  boolean d(Message paramMessage)
  {
    if (paramMessage.istroop == 9002)
    {
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
      else
      {
        paramMessage.counter += this.jdField_a_of_type_Int;
      }
    }
    else if ((paramMessage.istroop != 7220) && (!AppConstants.KANDIAN_DAILY_UIN.equals(paramMessage.frienduin)))
    {
      if ((!AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(paramMessage.frienduin)) && (!AppConstants.MAYKNOW_RECOMMEND_UIN.equals(paramMessage.frienduin))) {
        paramMessage.counter += this.jdField_a_of_type_Int;
      } else {
        paramMessage.counter = this.jdField_a_of_type_Int;
      }
    }
    else {
      paramMessage.counter = 1;
    }
    return false;
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
    return (paramMessage.istroop == 6000) || (((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002)) && ((paramMessage.msgtype == -3001) || (paramMessage.istroop == 1008) || (paramMessage.istroop == 9002) || (paramMessage.istroop == 7225)));
  }
  
  boolean h(Message paramMessage)
  {
    ForegroundNotifyManager localForegroundNotifyManager = ForegroundNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return (localForegroundNotifyManager != null) && (localForegroundNotifyManager.a(paramMessage));
  }
  
  boolean i(Message paramMessage)
  {
    return (paramMessage.istroop == 6000) || (((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002)) && ((paramMessage.msgtype == -3001) || (paramMessage.istroop == 1008) || (paramMessage.istroop == 9002)));
  }
  
  boolean j(Message paramMessage)
  {
    ForegroundNotifyManager localForegroundNotifyManager = ForegroundNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localForegroundNotifyManager != null) && (!localForegroundNotifyManager.a()))
    {
      if ((localForegroundNotifyManager.a(paramMessage.istroop)) && (localForegroundNotifyManager.a(paramMessage.frienduin)))
      {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 1, new Object[] { "[foreground] [process] subProcFgPushEnabled: invoked. ", " isSubProcessBackgroundStop: ", Boolean.valueOf(false) });
        return localForegroundNotifyManager.b();
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageNotifiableChecker
 * JD-Core Version:    0.7.0.1
 */