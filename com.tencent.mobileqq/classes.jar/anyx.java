import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.chat.QCircleChatUtil;
import java.util.List;
import mqq.app.AppRuntime.Status;
import org.jetbrains.annotations.Nullable;

public class anyx
{
  private final int jdField_a_of_type_Int;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final boolean jdField_a_of_type_Boolean;
  
  public anyx(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
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
  
  public static boolean a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    boolean bool1 = bgzw.a(localBaseApplication.getApplicationContext(), paramQQAppInterface);
    boolean bool2 = FriendsStatusUtil.a(paramMessage.frienduin, paramQQAppInterface);
    boolean bool3 = agij.a(paramMessage.frienduin, paramMessage.istroop, paramQQAppInterface);
    boolean bool4 = awxj.a(paramQQAppInterface).a(paramMessage);
    boolean bool5 = bgzw.b(localBaseApplication.getApplicationContext(), paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "currentAppSettingStateNeedNotification ,isFinished=" + paramQQAppInterface.isFinished + ", isCanDisturb=" + bool1 + ", newMsgNotificationEnabled=" + bool4 + ", message=" + paramMessage);
    }
    if ((paramQQAppInterface.isFinished) || (!bool1) || (bool2) || (bool3) || (!bool4) || (bool5)) {
      return false;
    }
    if (bhbx.b(paramMessage.frienduin))
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
  
  private boolean b(QQMessageFacade paramQQMessageFacade, QQMessageFacade.Message paramMessage)
  {
    if ((1008 == paramMessage.istroop) && ("2747277822".equals(paramMessage.frienduin)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "receive gamecenter push message " + this.jdField_a_of_type_Int);
      }
      ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(1, paramQQMessageFacade.getMessages("2747277822", 1008, this.jdField_a_of_type_Int));
    }
    return 1036 == paramMessage.istroop;
  }
  
  private boolean k(QQMessageFacade.Message paramMessage)
  {
    if (QCircleChatUtil.isQCircleChatMessage(paramMessage)) {
      return true;
    }
    return ((almg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(paramMessage.frienduin, paramMessage.istroop);
  }
  
  private boolean l(QQMessageFacade.Message paramMessage)
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
  
  private boolean m(QQMessageFacade.Message paramMessage)
  {
    return (1008 == paramMessage.istroop) && (paramMessage.senderuin != null) && (uqx.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.senderuin, paramMessage.istroop));
  }
  
  private boolean n(QQMessageFacade.Message paramMessage)
  {
    return acnh.c(paramMessage.senderuin);
  }
  
  private boolean o(QQMessageFacade.Message paramMessage)
  {
    return paramMessage.msgtype == -2058;
  }
  
  private boolean p(QQMessageFacade.Message paramMessage)
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
  
  private boolean q(QQMessageFacade.Message paramMessage)
  {
    if ((aweo.b(paramMessage)) && (aweo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage))) {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "isNeedForbidExtendFriendChatMessage return true for limit chat");
      }
    }
    do
    {
      return true;
      if ((!aweo.a(paramMessage)) || (!aweo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "isNeedForbidExtendFriendChatMessage return true for match chat");
    return true;
    return false;
  }
  
  private boolean r(QQMessageFacade.Message paramMessage)
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
  
  private boolean s(QQMessageFacade.Message paramMessage)
  {
    if ((1008 == paramMessage.istroop) && ((AppConstants.NEW_KANDIAN_UIN.equals(paramMessage.frienduin)) || (AppConstants.OLD_KANDIAN_UIN.equals(paramMessage.frienduin)))) {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage, not show newKandian");
      }
    }
    do
    {
      return true;
      if ((7220 != paramMessage.istroop) || (!AppConstants.KANDIAN_MERGE_UIN.equals(paramMessage.frienduin)) || (pkh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage, not show mergeKandian");
    return true;
    return false;
  }
  
  public Intent a(QQMessageFacade.Message paramMessage, Intent paramIntent)
  {
    anui localanui = anui.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool2 = ((KeyguardManager)BaseApplicationImpl.context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    boolean bool3 = ayof.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((bool3) || (bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Intent localIntent = paramIntent;
      if (localanui != null)
      {
        localIntent = paramIntent;
        if (h(paramMessage))
        {
          localIntent = paramIntent;
          if (!bool1)
          {
            paramIntent = ContactUtils.getNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin, paramMessage.istroop);
            localIntent = localanui.b(paramMessage.istroop, paramMessage.frienduin, paramIntent, 28);
            azcl.a("0X800AFCD", localanui.a(paramMessage.istroop));
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, new Object[] { "getMiniAioIntentIfNeed: invoked. ", " appBackgroundOrLocked: ", Boolean.valueOf(bool1), " isScreenLocked: ", Boolean.valueOf(bool2), " app.isBackgroundStop: ", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop), " isAppBackground: ", Boolean.valueOf(bool3), " foregroundNotifyManager: ", localanui });
      }
      return localIntent;
    }
  }
  
  @Nullable
  public QQMessageFacade a()
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
  
  public void a()
  {
    if (GuardManager.a != null) {
      GuardManager.a.b(0, null);
    }
  }
  
  public void a(QQMessageFacade.Message paramMessage)
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
  
  public boolean a(QQMessageFacade.Message paramMessage)
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
    if ((AppConstants.KANDIAN_LOCKSCREEN_INTERACT_MSG_UIN.equals(paramMessage.frienduin)) && (pkh.d()))
    {
      i = 1;
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop) && (!bool1) && (i == 0)) {
        break label319;
      }
      bool1 = true;
      anui localanui = anui.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((localanui == null) || (!localanui.a())) {
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
  
  public boolean a(QQMessageFacade paramQQMessageFacade, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {}
    while ((b(paramMessage)) || (l(paramMessage)) || (b(paramQQMessageFacade, paramMessage)) || (m(paramMessage)) || (n(paramMessage)) || (o(paramMessage)) || (p(paramMessage)) || (q(paramMessage)) || (r(paramMessage)) || (s(paramMessage)) || (a()) || (a(this.jdField_a_of_type_Boolean, paramMessage)) || (c(paramMessage)) || (k(paramMessage))) {
      return true;
    }
    return false;
  }
  
  boolean a(boolean paramBoolean, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.istroop == 1038)
    {
      int i = ((alcz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER)).a(paramMessage);
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
  
  boolean b(QQMessageFacade.Message paramMessage)
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
  
  boolean c(QQMessageFacade.Message paramMessage)
  {
    if ((FriendsStatusUtil.a(paramMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (agij.a(paramMessage.frienduin, paramMessage.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {}
    do
    {
      return true;
      if (!UserguideActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage , showUserGuide");
    return true;
    if (aizi.a(paramMessage))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotifiableChecker", 2, "handleReceivedMessage , isSuspiciousSysMsg");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.refreshAppBadge();
      return true;
    }
    return false;
  }
  
  public boolean d(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.istroop == 9002) {
      if ((paramMessage.msgData != null) && (paramMessage.msgData.length > 0))
      {
        aohe localaohe = (aohe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
        if (!localaohe.a(paramMessage.msgData)) {
          return true;
        }
        if (localaohe.b(paramMessage.msgData)) {
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
  
  public boolean e(QQMessageFacade.Message paramMessage)
  {
    return (paramMessage.msgtype == -1013) || (paramMessage.msgtype == -2030) || (paramMessage.msgtype == -1047) || (paramMessage.msgtype == -1019) || (paramMessage.msgtype == -1018);
  }
  
  public boolean f(QQMessageFacade.Message paramMessage)
  {
    return (paramMessage.istroop == 6000) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.userActiveStatus == 0) || (((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002)) && (paramMessage.msgtype == -3001));
  }
  
  boolean g(QQMessageFacade.Message paramMessage)
  {
    return (paramMessage.istroop == 6000) || (((paramMessage.istroop != 1001) && (paramMessage.istroop != 10002)) || ((paramMessage.msgtype == -3001) || (paramMessage.istroop == 1008) || (paramMessage.istroop == 9002) || (paramMessage.istroop == 7225)));
  }
  
  boolean h(QQMessageFacade.Message paramMessage)
  {
    anui localanui = anui.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return (localanui != null) && (localanui.a(paramMessage));
  }
  
  public boolean i(QQMessageFacade.Message paramMessage)
  {
    return (paramMessage.istroop == 6000) || (((paramMessage.istroop != 1001) && (paramMessage.istroop != 10002)) || ((paramMessage.msgtype == -3001) || (paramMessage.istroop == 1008) || (paramMessage.istroop == 9002)));
  }
  
  boolean j(QQMessageFacade.Message paramMessage)
  {
    boolean bool2 = true;
    anui localanui = anui.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool1 = bool2;
    if (localanui != null)
    {
      bool1 = bool2;
      if (localanui.a(paramMessage.istroop))
      {
        bool1 = bool2;
        if (localanui.a(paramMessage.frienduin))
        {
          bool1 = bool2;
          if (!localanui.a())
          {
            QLog.d("[NotificationRebuild] MessageNotifiableChecker", 1, new Object[] { "[foreground] [process] subProcFgPushEnabled: invoked. ", " isSubProcessBackgroundStop: ", Boolean.valueOf(false) });
            bool1 = localanui.b();
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyx
 * JD-Core Version:    0.7.0.1
 */