import android.app.KeyguardManager;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import org.jetbrains.annotations.Nullable;

public class anto
{
  private final int jdField_a_of_type_Int;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final boolean jdField_a_of_type_Boolean;
  private final boolean b;
  
  public anto(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
    if (QLog.isColorLevel())
    {
      if ((paramQQAppInterface.isBackground_Pause) || (paramQQAppInterface.isBackground_Stop)) {
        bool = true;
      }
      QLog.d("ReceivedMsgNotificationHelper", 2, new Object[] { "receivedMsgNotification ", "size is:", Integer.valueOf(paramInt), "isRunBackground :", Boolean.valueOf(bool), " needSoundVibrationsTip: ", Boolean.valueOf(paramBoolean1), " isOnline: ", Boolean.valueOf(paramBoolean2) });
    }
  }
  
  private boolean b(QQMessageFacade paramQQMessageFacade, QQMessageFacade.Message paramMessage)
  {
    if ((1008 == paramMessage.istroop) && ("2747277822".equals(paramMessage.frienduin)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceivedMsgNotificationHelper", 2, "receive gamecenter push message " + this.jdField_a_of_type_Int);
      }
      ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(1, paramQQMessageFacade.a("2747277822", 1008, this.jdField_a_of_type_Int));
    }
    return 1036 == paramMessage.istroop;
  }
  
  private boolean j(QQMessageFacade.Message paramMessage)
  {
    return vhk.a(paramMessage);
  }
  
  private boolean k(QQMessageFacade.Message paramMessage)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessage)) && (!paramMessage.needNotification()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceivedMsgNotificationHelper", 2, "receivedMsgNotification , isTroopMark");
      }
      return true;
    }
    return false;
  }
  
  private boolean l(QQMessageFacade.Message paramMessage)
  {
    return (1008 == paramMessage.istroop) && (paramMessage.senderuin != null) && (twi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.senderuin, paramMessage.istroop));
  }
  
  private boolean m(QQMessageFacade.Message paramMessage)
  {
    return acwh.c(paramMessage.senderuin);
  }
  
  private boolean n(QQMessageFacade.Message paramMessage)
  {
    return paramMessage.msgtype == -2058;
  }
  
  private boolean o(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.istroop == 1008)
    {
      int i;
      if ((paramMessage.extStr == null) || (((paramMessage.extLong & 0x1) == 0) && (!paramMessage.extStr.contains("lockDisplay"))))
      {
        i = 1;
        if ((paramMessage.extStr != null) && (((paramMessage.extLong & 0x1) != 1) || (paramMessage.getExtInfoFromExtStr("lockDisplay").equals("true")))) {
          break label95;
        }
      }
      label95:
      for (int j = 1;; j = 0)
      {
        if ((i == 0) && (j == 0)) {
          break label100;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.E();
        return true;
        i = 0;
        break;
      }
    }
    label100:
    return false;
  }
  
  private boolean p(QQMessageFacade.Message paramMessage)
  {
    return (avsr.b(paramMessage)) && (avsr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage));
  }
  
  private boolean q(QQMessageFacade.Message paramMessage)
  {
    if (TextUtils.equals(paramMessage.getExtInfoFromExtStr("msg_in_box"), "msg_in_box"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceivedMsgNotificationHelper", 2, "receivedMsgNotification, not show message InMsgBox");
      }
      return true;
    }
    return false;
  }
  
  private boolean r(QQMessageFacade.Message paramMessage)
  {
    if ((1008 == paramMessage.istroop) && ((anhk.az.equals(paramMessage.frienduin)) || (anhk.ay.equals(paramMessage.frienduin)))) {
      if (QLog.isColorLevel()) {
        QLog.d("ReceivedMsgNotificationHelper", 2, "receivedMsgNotification, not show newKandian");
      }
    }
    do
    {
      return true;
      if ((7220 != paramMessage.istroop) || (!anhk.aA.equals(paramMessage.frienduin)) || (pha.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReceivedMsgNotificationHelper", 2, "receivedMsgNotification, not show mergeKandian");
    return true;
    return false;
  }
  
  public Intent a(QQMessageFacade.Message paramMessage, Intent paramIntent)
  {
    anlq localanlq = anlq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool2 = ((KeyguardManager)BaseApplicationImpl.context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    boolean bool3 = aybz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((bool3) || (bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Intent localIntent = paramIntent;
      if (localanlq != null)
      {
        localIntent = paramIntent;
        if (g(paramMessage))
        {
          localIntent = paramIntent;
          if (!bool1)
          {
            paramIntent = bglf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin, paramMessage.istroop);
            localIntent = localanlq.b(paramMessage.istroop, paramMessage.frienduin, paramIntent, 28);
            aypy.a("0X800AFCD", localanlq.a(paramMessage.istroop));
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReceivedMsgNotificationHelper", 2, new Object[] { "getMiniAioIntentIfNeed: invoked. ", " appBackgroundOrLocked: ", Boolean.valueOf(bool1), " isScreenLocked: ", Boolean.valueOf(bool2), " app.isBackground_Stop: ", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop), " isAppBackground: ", Boolean.valueOf(bool3), " foregroundNotifyManager: ", localanlq });
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
      localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
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
        QLog.d("ReceivedMsgNotificationHelper", 2, "receivedMsgNotification, online status is dnd");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.E();
      return true;
    }
    return false;
  }
  
  boolean a(QQMessageFacade.Message paramMessage)
  {
    if ((1000 == paramMessage.istroop) || (1020 == paramMessage.istroop))
    {
      if ((paramMessage.frienduin == null) || (!paramMessage.frienduin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break label102;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReceivedMsgNotificationHelper", 2, "receivedMsgNotification , stranger  self message");
      }
    }
    do
    {
      return true;
      if ((paramMessage.senderuin == null) || (!paramMessage.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReceivedMsgNotificationHelper", 2, "receivedMsgNotification ,self message");
    return true;
    label102:
    return false;
  }
  
  public boolean a(QQMessageFacade paramQQMessageFacade, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage == null) {}
    while ((a(paramMessage)) || (k(paramMessage)) || (b(paramQQMessageFacade, paramMessage)) || (l(paramMessage)) || (m(paramMessage)) || (n(paramMessage)) || (o(paramMessage)) || (p(paramMessage)) || (q(paramMessage)) || (r(paramMessage)) || (a()) || (a(this.b, paramMessage)) || (b(paramMessage)) || (j(paramMessage))) {
      return true;
    }
    return false;
  }
  
  boolean a(boolean paramBoolean, QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.istroop == 1038)
    {
      int i = ((akxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(315)).a(paramMessage);
      if (QLog.isColorLevel()) {
        QLog.d("ReceivedMsgNotificationHelper", 2, "receivedMsgNotification, not show message because unreadFlag is " + i);
      }
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(paramMessage, paramBoolean);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.E();
      }
      return true;
    }
    return false;
  }
  
  boolean b(QQMessageFacade.Message paramMessage)
  {
    if ((FriendsStatusUtil.a(paramMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (aglw.a(paramMessage.frienduin, paramMessage.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {}
    do
    {
      return true;
      if (!UserguideActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReceivedMsgNotificationHelper", 2, "receivedMsgNotification , showUserGuide");
    return true;
    if (aiyr.a(paramMessage))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReceivedMsgNotificationHelper", 2, "receivedMsgNotification , isSuspiciousSysMsg");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.E();
      return true;
    }
    return false;
  }
  
  public boolean c(QQMessageFacade.Message paramMessage)
  {
    if (paramMessage.istroop == 9002) {
      if ((paramMessage.msgData != null) && (paramMessage.msgData.length > 0))
      {
        anyr localanyr = (anyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(85);
        if (!localanyr.a(paramMessage.msgData)) {
          return true;
        }
        if (localanyr.b(paramMessage.msgData)) {
          paramMessage.counter += this.jdField_a_of_type_Int;
        }
      }
    }
    for (;;)
    {
      return false;
      paramMessage.counter += this.jdField_a_of_type_Int;
      continue;
      if ((paramMessage.istroop == 7220) || (anhk.aR.equals(paramMessage.frienduin))) {
        paramMessage.counter = 1;
      } else if ((anhk.M.equals(paramMessage.frienduin)) || (anhk.ax.equals(paramMessage.frienduin))) {
        paramMessage.counter = this.jdField_a_of_type_Int;
      } else {
        paramMessage.counter += this.jdField_a_of_type_Int;
      }
    }
  }
  
  public boolean d(QQMessageFacade.Message paramMessage)
  {
    return (paramMessage.msgtype == -1013) || (paramMessage.msgtype == -2030) || (paramMessage.msgtype == -1047) || (paramMessage.msgtype == -1019) || (paramMessage.msgtype == -1018);
  }
  
  public boolean e(QQMessageFacade.Message paramMessage)
  {
    return (paramMessage.istroop == 6000) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_Int == 0) || (((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002)) && (paramMessage.msgtype == -3001));
  }
  
  public boolean f(QQMessageFacade.Message paramMessage)
  {
    return (paramMessage.istroop == 6000) || (((paramMessage.istroop != 1001) && (paramMessage.istroop != 10002)) || ((paramMessage.msgtype == -3001) || (paramMessage.istroop == 1008) || (paramMessage.istroop == 9002) || (paramMessage.istroop == 7225)));
  }
  
  public boolean g(QQMessageFacade.Message paramMessage)
  {
    anlq localanlq = anlq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return (localanlq != null) && (localanlq.a(paramMessage));
  }
  
  public boolean h(QQMessageFacade.Message paramMessage)
  {
    return (paramMessage.istroop == 6000) || (((paramMessage.istroop != 1001) && (paramMessage.istroop != 10002)) || ((paramMessage.msgtype == -3001) || (paramMessage.istroop == 1008) || (paramMessage.istroop == 9002)));
  }
  
  public boolean i(QQMessageFacade.Message paramMessage)
  {
    boolean bool2 = true;
    anlq localanlq = anlq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool1 = bool2;
    if (localanlq != null)
    {
      bool1 = bool2;
      if (localanlq.a(paramMessage.istroop))
      {
        bool1 = bool2;
        if (localanlq.a(paramMessage.frienduin))
        {
          bool1 = bool2;
          if (!localanlq.a())
          {
            QLog.d("ReceivedMsgNotificationHelper", 1, new Object[] { "[foreground] [process] subProcFgPushEnabled: invoked. ", " isSubProcessBackgroundStop: ", Boolean.valueOf(false) });
            bool1 = localanlq.b();
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anto
 * JD-Core Version:    0.7.0.1
 */