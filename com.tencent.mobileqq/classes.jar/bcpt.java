import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.NotificationDeleteReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import mqq.app.MSFServlet;
import org.jetbrains.annotations.Nullable;

public class bcpt
  extends bcpv
{
  private aqtc jdField_a_of_type_Aqtc = new bcpu(this);
  private QQNotificationManager jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Map<Integer, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  public boolean a;
  private int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  
  public bcpt(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    f();
  }
  
  private int a(int paramInt1, QQMessageFacade paramQQMessageFacade, int paramInt2)
  {
    if ((!CommonBadgeUtilImpl.isMIUI6()) || (paramQQMessageFacade == null)) {}
    do
    {
      return paramInt2;
      paramQQMessageFacade = (NotificationManager)BaseApplicationImpl.getContext().getSystemService("notification");
    } while ((Build.VERSION.SDK_INT < 23) || (paramQQMessageFacade == null));
    paramQQMessageFacade = paramQQMessageFacade.getActiveNotifications();
    int i = 0;
    if ((paramQQMessageFacade != null) && (i < paramQQMessageFacade.length))
    {
      Object localObject = paramQQMessageFacade[i];
      Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(localObject.getId()));
      if (localInteger == null) {}
      for (;;)
      {
        i += 1;
        break;
        QLog.i("MobileQQService", 1, "getUnreadMIUI() minus activeUnRead with: id = [" + localObject.getId() + "], activeUnRead = [" + localInteger + "], unread = [" + paramInt2 + "]");
        paramInt2 -= localInteger.intValue();
      }
    }
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    return paramInt2;
  }
  
  private int a(Intent paramIntent, int paramInt)
  {
    int i = paramInt;
    if (paramInt == -1) {
      i = paramIntent.getIntExtra("param_uinType", -1);
    }
    return i;
  }
  
  private Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2)
  {
    paramIntent.putExtra("param_notifyid", 275);
    paramIntent = PendingIntent.getActivity(BaseApplication.getContext(), 0, paramIntent, 134217728);
    NotificationCompat.Builder localBuilder = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_HIDE_BADGE").setSmallIcon(2130841444).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis());
    localBuilder.setContentTitle(paramString1).setContentText(paramString2).setContentIntent(paramIntent);
    if (paramBitmap != null) {
      localBuilder.setLargeIcon(paramBitmap);
    }
    return localBuilder.build();
  }
  
  private Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isOpenNoClearNotification();
    int i = paramIntent.getIntExtra("param_notifyid", 0);
    Object localObject1;
    int k;
    String str;
    Object localObject2;
    if ((i >= 512) && (i <= 522))
    {
      localObject1 = PendingIntent.getActivity(BaseApplication.getContext(), i, paramIntent, 134217728);
      if (QLog.isColorLevel()) {
        QLog.i("MobileQQService", 2, "buildNotification by getActivity. contentIntent=" + localObject1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CampusNoticeManager", 2, new Object[] { "buildNotification url :", paramIntent.getStringExtra("url") });
      }
      k = paramIntent.getIntExtra("uintype", -1);
      if (k != 1008) {
        break label584;
      }
      if (AppConstants.REMINDER_UIN.equals(paramIntent.getStringExtra("uin"))) {
        break label871;
      }
      if (!paramIntent.getBooleanExtra("activepull_push_flag", false)) {
        break label567;
      }
      i = 2130841445;
      str = "CHANNEL_ID_SHOW_BADGE";
      localObject2 = localObject1;
      localObject1 = str;
    }
    for (;;)
    {
      label169:
      boolean bool2 = paramIntent.getBooleanExtra("key_notifycation_oneway_message", false);
      int j = i;
      if (bool2)
      {
        j = i;
        if (k == 1010) {
          j = 2130845412;
        }
      }
      if ((bool2) && ((k == 1001) || (k == 10002)))
      {
        i = 1;
        label229:
        if (i != 0) {
          j = 2130840439;
        }
        if (paramIntent.getBooleanExtra("qav_notify_flag", false)) {
          j = 2130842160;
        }
        if ((k != 1037) && (k != 1045) && (k != 1044)) {
          break label817;
        }
        paramIntent = "CHANNEL_ID_LIMIT_CHAT";
        label283:
        paramIntent = NotificationFactory.createNotificationCompatBuilder(paramIntent).setSmallIcon(j).setAutoCancel(true).setWhen(System.currentTimeMillis()).setTicker(paramString1);
        if ((k != 1030) && (k != 1035) && (k != 1041) && (k != 1042) && (bool1)) {
          paramIntent.setOngoing(true);
        }
        if (bgzx.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          Calendar.getInstance().get(11);
          paramIntent.setLights(-16711936, 2000, 2000);
        }
        if (!this.c) {
          break label841;
        }
        if (paramBitmap != null) {
          paramIntent.setLargeIcon(paramBitmap);
        }
        paramIntent.setContentTitle(paramString2).setContentText(paramString3).setContentIntent((PendingIntent)localObject2);
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_b_of_type_Boolean = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "_" + "heads_up_notify_switch", true);
          if (QLog.isColorLevel()) {
            QLog.i("MobileQQService", 2, "notify init priority flag, " + this.jdField_b_of_type_Boolean);
          }
        }
        if ((Build.VERSION.SDK_INT >= 24) || (this.jdField_b_of_type_Boolean)) {
          paramIntent.setPriority(1).setVibrate(new long[0]);
        }
        return paramIntent.build();
        localObject1 = PendingIntent.getActivity(BaseApplication.getContext(), 0, paramIntent, 268435456);
        break;
        label567:
        i = 2130841803;
        localObject2 = localObject1;
        localObject1 = "CHANNEL_ID_SHOW_BADGE";
        break label169;
        label584:
        if (k == 1030)
        {
          i = paramIntent.getIntExtra("campus_notice_id", 100);
          paramBitmap = bgyo.a(BaseApplication.getContext().getResources(), 2130840422);
          localObject2 = PendingIntent.getActivity(BaseApplication.getContext(), i, paramIntent, 268435456);
          if (QLog.isColorLevel()) {
            QLog.d("CampusNoticeManager", 2, new Object[] { "buildNotification UIN_TYPE_CAMPUS_NOTICE url :", paramIntent.getStringExtra("url") });
          }
          i = 2130841444;
          localObject1 = "CHANNEL_ID_SHOW_BADGE";
          break label169;
        }
        if ((k != 1035) && (k != 1041) && (k != 1042)) {
          break label871;
        }
        i = paramIntent.getIntExtra("param_notifyid", 100);
        paramBitmap = BaseApplication.getContext();
        j = 2130841444;
        str = "CHANNEL_ID_OTHER";
        Bitmap localBitmap = bgyo.a(paramBitmap.getResources(), 2130840422);
        PendingIntent localPendingIntent = PendingIntent.getActivity(BaseApplication.getContext(), i, paramIntent, 268435456);
        localObject1 = str;
        i = j;
        localObject2 = localPendingIntent;
        paramBitmap = localBitmap;
        if (!QLog.isColorLevel()) {
          break label169;
        }
        QLog.d("PushNoticeManager", 2, new Object[] { "buildNotification UIN_TYPE_PUSH_NOTICE url :", paramIntent.getStringExtra("url") });
        localObject1 = str;
        i = j;
        localObject2 = localPendingIntent;
        paramBitmap = localBitmap;
        break label169;
        i = 0;
        break label229;
        label817:
        paramIntent = (Intent)localObject1;
        if (k != 1) {
          break label283;
        }
        paramIntent = (Intent)localObject1;
        if (!SdkInfoUtil.isAndroidQ()) {
          break label283;
        }
        paramIntent = (Intent)localObject1;
        break label283;
        label841:
        paramIntent.setContentTitle(paramString2).setContentText(paramString3).setContentIntent((PendingIntent)localObject2);
        if (paramBitmap != null) {
          paramIntent.setLargeIcon(paramBitmap);
        }
      }
      label871:
      i = 2130841445;
      localObject2 = localObject1;
      localObject1 = "CHANNEL_ID_SHOW_BADGE";
    }
  }
  
  private void a(Intent paramIntent, Notification paramNotification)
  {
    String str = paramIntent.getStringExtra("param_fromuin");
    int i = paramIntent.getIntExtra("uintype", -1);
    int j = a(paramIntent, i);
    if (paramIntent.getBooleanExtra("qav_notify_flag", false))
    {
      a(paramIntent, paramNotification, 236);
      return;
    }
    if (i == 1030)
    {
      a(paramIntent, paramNotification, str, j);
      return;
    }
    if ((i == 1035) || (i == 1041) || (i == 1042))
    {
      c(paramIntent, paramNotification);
      return;
    }
    a(paramIntent, i);
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.showMsgNotification", 275);
    }
    a(paramIntent, paramNotification, 265);
  }
  
  private void a(Intent paramIntent, Notification paramNotification, String paramString, int paramInt)
  {
    paramIntent.getStringExtra("campus_notice_tag");
    a(paramIntent, paramNotification, paramIntent.getIntExtra("campus_notice_id", 0));
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("CMD_SHOW_NOTIFIYCATION".equals(str))
    {
      if (!((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a()) {
        d(paramToServiceMsg);
      }
      for (;;)
      {
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQService", 2, "pcm blocked msg notification");
        }
      }
    }
    if ("CMD_IDLE_NOTIFIYCATION".equals(str))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearMsgCounter();
      c(paramToServiceMsg);
      return true;
    }
    if ("CMD_STOP_NOTIFIYCATION".equals(str))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearMsgCounter();
      a(275);
      return true;
    }
    if ("CMD_CANCLE_NOTIFIYCATION".equals(str))
    {
      b(275);
      return true;
    }
    return false;
  }
  
  private void b(Intent paramIntent, Notification paramNotification)
  {
    String str1 = paramIntent.getStringExtra("param_fromuin");
    int i = paramIntent.getIntExtra("uintype", -1);
    String str2 = paramIntent.getStringExtra("KEY_FRIEND_UIN");
    int j = a(paramIntent, i);
    boolean bool = paramIntent.getBooleanExtra("key_notifycation_oneway_message", false);
    if ((bool) && (i == 1010)) {
      a(paramIntent, paramNotification, 272);
    }
    do
    {
      return;
      if (((bool) && (i == 1001)) || (i == 10002))
      {
        a(paramIntent, paramNotification, 268);
        return;
      }
      if (i == 1030)
      {
        a(paramIntent, paramNotification, str1, j);
        paramNotification = new bdkv();
        paramNotification.e = "0X800923F";
        paramNotification.d = "Android系统通知曝光";
        bdku.a(paramIntent.getStringExtra("url"), paramNotification);
        bdku.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramNotification);
        return;
      }
      if ((i == 1035) || (i == 1041) || (i == 1042))
      {
        c(paramIntent, paramNotification);
        return;
      }
      if (paramIntent.getBooleanExtra("activepull_push_flag", false))
      {
        a(paramIntent, paramNotification, 269);
        return;
      }
      if (i == 3001)
      {
        a(paramIntent, paramNotification, 271);
        return;
      }
      if (paramIntent.getBooleanExtra("qav_notify_flag", false))
      {
        a(paramIntent, paramNotification, 236);
        return;
      }
      a(paramIntent, i);
    } while (bkyy.a(i, str2));
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.showMsgNotification", 275);
    }
    a(paramIntent, paramNotification, 265);
  }
  
  private void c(Intent paramIntent, Notification paramNotification)
  {
    int i = paramIntent.getIntExtra("param_notifyid", 0);
    awtm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIntent.getStringExtra("push_notice_service_id"), paramIntent.getStringExtra("push_notice_content_id"), paramIntent.getStringExtra("url"), "0X800923F", "Android系统通知曝光");
    a(paramIntent, paramNotification, i);
    if (Build.VERSION.SDK_INT >= 19) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.vibratorAndAudio();
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg)
  {
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("cmds");
    if (arrayOfString.length != 3) {
      return;
    }
    Bitmap localBitmap = (Bitmap)paramToServiceMsg.extraData.getParcelable("bitmap");
    paramToServiceMsg = a((Intent)paramToServiceMsg.extraData.getParcelable("intent"), localBitmap, arrayOfString[1], arrayOfString[2]);
    paramToServiceMsg.flags = 34;
    f();
    QLog.i("MobileQQService", 1, "showNotCancelNotification nf=" + paramToServiceMsg);
    a(275, paramToServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0);
  }
  
  private void d(ToServiceMsg paramToServiceMsg)
  {
    Intent localIntent = (Intent)paramToServiceMsg.extraData.getParcelable("intent");
    paramToServiceMsg = a(paramToServiceMsg, localIntent);
    if (paramToServiceMsg == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isShowMsgContent())
    {
      b(localIntent, paramToServiceMsg);
      return;
    }
    a(localIntent, paramToServiceMsg);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager == null) && (this.jdField_b_of_type_Int < 3)) {}
    try
    {
      this.c = DeviceInfoUtil.isRubbishPhone4Notification();
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
      if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager == null) {
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
      }
      jdField_a_of_type_Int = Math.abs(this.jdField_a_of_type_JavaUtilRandom.nextInt());
      if (QLog.isColorLevel()) {
        QLog.i("MobileQQService", 2, "MobileQQService has created. mNM=" + this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager);
      }
      this.jdField_b_of_type_Int += 1;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQService", 2, "e = " + localException.toString());
        }
      }
    }
  }
  
  @Nullable
  Notification a(ToServiceMsg paramToServiceMsg, Intent paramIntent)
  {
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("cmds");
    if (arrayOfString.length != 3) {
      return null;
    }
    Bitmap localBitmap = (Bitmap)paramToServiceMsg.extraData.getParcelable("bitmap");
    if (!bhkn.e) {
      paramToServiceMsg = bhkk.a().a(paramIntent, localBitmap, arrayOfString[0], arrayOfString[1], arrayOfString[2], this.c, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      paramToServiceMsg.deleteIntent = a(paramIntent);
      f();
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isShowMsgContent();
      Object localObject = new Intent("com.tencent.msg.newmessage");
      ((Intent)localObject).setPackage("com.tencent.mobileqq");
      ((Intent)localObject).putExtra("cmds", arrayOfString);
      ((Intent)localObject).putExtra("intent", paramIntent);
      ((Intent)localObject).putExtra("type", 0);
      ((Intent)localObject).putExtra("bitmap", localBitmap);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast((Intent)localObject);
      nzg.a.a(bool, paramIntent);
      return paramToServiceMsg;
      if (bhkn.m)
      {
        localObject = a(paramIntent, null, arrayOfString[0], arrayOfString[1], arrayOfString[2]);
        int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAndroidInternalId("icon");
        paramToServiceMsg = (ToServiceMsg)localObject;
        if (i > 0)
        {
          paramToServiceMsg = (ToServiceMsg)localObject;
          if (((Notification)localObject).contentView != null)
          {
            ((Notification)localObject).contentView.setImageViewBitmap(i, localBitmap);
            paramToServiceMsg = (ToServiceMsg)localObject;
          }
        }
      }
      else
      {
        paramToServiceMsg = a(paramIntent, localBitmap, arrayOfString[0], arrayOfString[1], arrayOfString[2]);
      }
    }
  }
  
  public PendingIntent a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      String str = paramIntent.getStringExtra("uin");
      int i = paramIntent.getIntExtra("param_notifyid", 0);
      paramIntent = new Intent(BaseApplication.getContext(), NotificationDeleteReceiver.class);
      paramIntent.putExtra("uin", str);
      paramIntent.putExtra("param_notifyid", i);
      return PendingIntent.getBroadcast(BaseApplication.getContext(), 0, paramIntent, 268435456);
    }
    return null;
  }
  
  public AppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  QQNotificationManager a()
  {
    return this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager;
  }
  
  protected void a()
  {
    try
    {
      super.a();
      a(new bnjn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new bcui(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new bcqo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new bcsb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new bcrb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new bcup());
      bcuk localbcuk = new bcuk();
      a(localbcuk);
      localbcuk.a(this.jdField_a_of_type_Aqtc);
      a(new bcqi());
      a(new bcuu());
      a(new bcqn());
      a(new bcqa(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new bcqf());
      a(new bcqh());
      a(new nus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new bcum());
      a(new bcun());
      a(new bcqe());
      a(new bcul());
      a(new bcuy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      super.d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication() != null)) {}
    try
    {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.stopForegroundCompat", paramInt);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  void a(int paramInt1, Notification paramNotification, String paramString, int paramInt2)
  {
    a(null, paramInt1, paramNotification, paramString, paramInt2);
  }
  
  void a(Intent paramIntent, int paramInt)
  {
    if ((paramInt == 0) && (paramIntent.getBooleanExtra("key_reactive_push_tip", false))) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A1BE", "0X800A1BE", 2, 0, "", "", "", "");
    }
  }
  
  public void a(Intent paramIntent, Notification paramNotification, int paramInt)
  {
    String str = paramIntent.getStringExtra("param_fromuin");
    int i = paramIntent.getIntExtra("uintype", -1);
    int j = a(paramIntent, i);
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.showMsgNotification", paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[NotificationRebuild] MobileQQService", 2, new Object[] { "[notify] generateNotificationAfterCancel: invoked. ", " reportUinType: ", Integer.valueOf(j), " uinType: ", Integer.valueOf(i), " notifyId: ", Integer.valueOf(paramInt) });
    }
    a(paramInt, paramNotification, str, j);
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg)
  {
    awth.a().a(paramFromServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (!((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a())
    {
      localIntent = (Intent)paramToServiceMsg.extraData.getParcelable("intent");
      paramToServiceMsg = a(paramToServiceMsg, localIntent);
      if ((localIntent != null) && (paramToServiceMsg != null)) {}
    }
    while (!QLog.isColorLevel())
    {
      Intent localIntent;
      return;
      int j = localIntent.getIntExtra("KEY_NOTIFY_ID_FROM_PROCESSOR", -113);
      if (j != -113) {}
      for (int i = 1; i != 0; i = 0)
      {
        a(localIntent, paramToServiceMsg, j);
        return;
      }
      QQNotificationManager localQQNotificationManager = a();
      if (localQQNotificationManager != null) {
        localQQNotificationManager.cancel("MobileQQService.showMsgNotification", 275);
      }
      a(localIntent, localIntent.getIntExtra("uintype", -1));
      a(localIntent, paramToServiceMsg, 265);
      return;
    }
    QLog.d("MobileQQService", 2, "pcm blocked msg notification");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, aqtc paramaqtc, Class<? extends MSFServlet> paramClass)
  {
    if (paramToServiceMsg == null) {}
    while (a(paramToServiceMsg)) {
      return;
    }
    super.a(paramToServiceMsg, paramaqtc, aqte.class);
  }
  
  void a(String paramString1, int paramInt1, Notification paramNotification, String paramString2, int paramInt2)
  {
    int k = 0;
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {}
    int i;
    int j;
    for (;;)
    {
      try
      {
        QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
        bapk localbapk = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCallFacade();
        if (localbapk == null) {
          break label316;
        }
        i = localbapk.a();
        if (localQQMessageFacade == null) {
          break label310;
        }
        j = localQQMessageFacade.getUnreadMsgsNum();
        if (!TextUtils.isEmpty(paramString1)) {
          break label369;
        }
        if ((paramInt1 != 265) && ((paramInt1 < 512) || (paramInt1 > 522))) {
          break label362;
        }
        i = a(paramInt1, localQQMessageFacade, j);
      }
      catch (Throwable paramString1)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("BadgeUtilImpl", 2, "startForegroundCompat changeMI6Badge count=" + i);
      }
      if (bkxs.a(BaseApplicationImpl.getApplication().getApplicationContext())) {
        bkxs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), i, paramNotification);
      }
      if (!TextUtils.isEmpty(paramString1))
      {
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notifyUseTag("MobileQQService.startForegroundCompat", paramString1, paramNotification, this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.createNotifyBundle(paramInt1, paramString2, paramInt2));
        return;
      }
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("MobileQQService.startForegroundCompat", paramNotification, this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.createNotifyBundle(paramInt1, paramString2, paramInt2));
      return;
      QLog.i("MobileQQService", 2, "startForegroundCompat exception. id=" + paramInt1 + ", mNM=" + this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager, paramString1);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("MobileQQService", 2, "startForegroundCompat. id=" + paramInt1 + ", mNM=" + this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager);
      return;
      label303:
      i = j;
      continue;
      label310:
      j = 0;
      continue;
      label316:
      i = 0;
    }
    for (;;)
    {
      j = i;
      if (paramInt1 >= 482)
      {
        j = i;
        if (paramInt1 <= 511) {
          j = 0;
        }
      }
      if (paramInt1 != 266) {
        break label303;
      }
      i = k;
      break;
      return;
      label362:
      if (paramInt1 != 236) {
        label369:
        i = 1;
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    super.a(paramBoolean, paramToServiceMsg, paramFromServiceMsg, paramException);
  }
  
  public void b()
  {
    a(false);
    a(275);
    if (QLog.isColorLevel()) {
      QLog.i("MobileQQService", 2, "MobileQQService has destroyed.");
    }
    this.jdField_a_of_type_Aqtc = null;
    super.b();
  }
  
  void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.cancelNotification", paramInt);
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    b(paramToServiceMsg, this.jdField_a_of_type_Aqtc, aqte.class);
  }
  
  public void c()
  {
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcpt
 * JD-Core Version:    0.7.0.1
 */