import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.NotificationDeleteReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import mqq.app.MSFServlet;

public class bbxc
  extends bbxe
{
  private aqhm jdField_a_of_type_Aqhm = new bbxd(this);
  private QQNotificationManager jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  public boolean a;
  private int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  
  public bbxc(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2)
  {
    paramIntent.putExtra("param_notifyid", 275);
    paramIntent = PendingIntent.getActivity(BaseApplication.getContext(), 0, paramIntent, 134217728);
    NotificationCompat.Builder localBuilder = NotificationFactory.createNotificationCompatBuilder("CHANNEL_ID_HIDE_BADGE").setSmallIcon(2130841392).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis());
    localBuilder.setContentTitle(paramString1).setContentText(paramString2).setContentIntent(paramIntent);
    if (paramBitmap != null) {
      localBuilder.setLargeIcon(paramBitmap);
    }
    return localBuilder.build();
  }
  
  private Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
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
        break label571;
      }
      if (anhk.u.equals(paramIntent.getStringExtra("uin"))) {
        break label857;
      }
      if (!paramIntent.getBooleanExtra("activepull_push_flag", false)) {
        break label555;
      }
      i = 2130841393;
      str = "CHANNEL_ID_SHOW_BADGE";
      localObject2 = localObject1;
      localObject1 = str;
    }
    for (;;)
    {
      label167:
      boolean bool2 = paramIntent.getBooleanExtra("key_notifycation_oneway_message", false);
      int j = i;
      if (bool2)
      {
        j = i;
        if (k == 1010) {
          j = 2130845433;
        }
      }
      if ((bool2) && ((k == 1001) || (k == 10002)))
      {
        i = 1;
        label225:
        if (i != 0) {
          j = 2130840354;
        }
        if (paramIntent.getBooleanExtra("qav_notify_flag", false)) {
          j = 2130842092;
        }
        if ((k != 1037) && (k != 1045) && (k != 1044)) {
          break label803;
        }
        paramIntent = "CHANNEL_ID_LIMIT_CHAT";
        label275:
        paramIntent = NotificationFactory.createNotificationCompatBuilder(paramIntent).setSmallIcon(j).setAutoCancel(true).setWhen(System.currentTimeMillis()).setTicker(paramString1);
        if ((k != 1030) && (k != 1035) && (k != 1041) && (k != 1042) && (bool1)) {
          paramIntent.setOngoing(true);
        }
        if (bghv.a(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          Calendar.getInstance().get(11);
          paramIntent.setLights(-16711936, 2000, 2000);
        }
        if (!this.c) {
          break label827;
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
        label555:
        i = 2130841741;
        localObject2 = localObject1;
        localObject1 = "CHANNEL_ID_SHOW_BADGE";
        break label167;
        label571:
        if (k == 1030)
        {
          i = paramIntent.getIntExtra("campus_notice_id", 100);
          paramBitmap = bggl.a(BaseApplication.getContext().getResources(), 2130840337);
          localObject2 = PendingIntent.getActivity(BaseApplication.getContext(), i, paramIntent, 268435456);
          if (QLog.isColorLevel()) {
            QLog.d("CampusNoticeManager", 2, new Object[] { "buildNotification UIN_TYPE_CAMPUS_NOTICE url :", paramIntent.getStringExtra("url") });
          }
          i = 2130841392;
          localObject1 = "CHANNEL_ID_SHOW_BADGE";
          break label167;
        }
        if ((k != 1035) && (k != 1041) && (k != 1042)) {
          break label857;
        }
        i = paramIntent.getIntExtra("param_notifyid", 100);
        paramBitmap = BaseApplication.getContext();
        j = 2130841392;
        str = "CHANNEL_ID_OTHER";
        Bitmap localBitmap = bggl.a(paramBitmap.getResources(), 2130840337);
        PendingIntent localPendingIntent = PendingIntent.getActivity(BaseApplication.getContext(), i, paramIntent, 268435456);
        localObject1 = str;
        i = j;
        localObject2 = localPendingIntent;
        paramBitmap = localBitmap;
        if (!QLog.isColorLevel()) {
          break label167;
        }
        QLog.d("PushNoticeManager", 2, new Object[] { "buildNotification UIN_TYPE_PUSH_NOTICE url :", paramIntent.getStringExtra("url") });
        localObject1 = str;
        i = j;
        localObject2 = localPendingIntent;
        paramBitmap = localBitmap;
        break label167;
        i = 0;
        break label225;
        label803:
        paramIntent = (Intent)localObject1;
        if (k != 1) {
          break label275;
        }
        paramIntent = (Intent)localObject1;
        if (!SdkInfoUtil.isAndroidQ()) {
          break label275;
        }
        paramIntent = (Intent)localObject1;
        break label275;
        label827:
        paramIntent.setContentTitle(paramString2).setContentText(paramString3).setContentIntent((PendingIntent)localObject2);
        if (paramBitmap != null) {
          paramIntent.setLargeIcon(paramBitmap);
        }
      }
      label857:
      i = 2130841393;
      localObject2 = localObject1;
      localObject1 = "CHANNEL_ID_SHOW_BADGE";
    }
  }
  
  private PendingIntent a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uin");
    int i = paramIntent.getIntExtra("param_notifyid", 0);
    paramIntent = new Intent(BaseApplication.getContext(), NotificationDeleteReceiver.class);
    paramIntent.putExtra("uin", str);
    paramIntent.putExtra("param_notifyid", i);
    return PendingIntent.getBroadcast(BaseApplication.getContext(), 0, paramIntent, 268435456);
  }
  
  private void a(boolean paramBoolean) {}
  
  private void b(ToServiceMsg paramToServiceMsg)
  {
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("cmds");
    if (arrayOfString.length != 3) {
      return;
    }
    Bitmap localBitmap = (Bitmap)paramToServiceMsg.extraData.getParcelable("bitmap");
    paramToServiceMsg = a((Intent)paramToServiceMsg.extraData.getParcelable("intent"), localBitmap, arrayOfString[1], arrayOfString[2]);
    paramToServiceMsg.flags = 34;
    b();
    QLog.i("MobileQQService", 1, "showNotCancelNotification nf=" + paramToServiceMsg);
    a(275, paramToServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
  }
  
  private void c(ToServiceMsg paramToServiceMsg)
  {
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("cmds");
    if (arrayOfString.length != 3) {
      return;
    }
    Intent localIntent = (Intent)paramToServiceMsg.extraData.getParcelable("intent");
    Bitmap localBitmap = (Bitmap)paramToServiceMsg.extraData.getParcelable("bitmap");
    boolean bool = localIntent.getBooleanExtra("key_notifycation_oneway_message", false);
    Object localObject1;
    int j;
    String str;
    int i;
    if (!bgvi.e)
    {
      paramToServiceMsg = bgvf.a().a(localIntent, localBitmap, arrayOfString[0], arrayOfString[1], arrayOfString[2], this.c, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramToServiceMsg.deleteIntent = a(localIntent);
      b();
      localObject1 = localIntent.getStringExtra("param_fromuin");
      j = localIntent.getIntExtra("uintype", -1);
      str = localIntent.getStringExtra("KEY_FRIEND_UIN");
      if (j != -1) {
        break label389;
      }
      i = localIntent.getIntExtra("param_uinType", -1);
      label155:
      if (!SettingCloneUtil.readValue(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), BaseApplication.getContext().getString(2131717429), "qqsetting_notify_showcontent_key", true)) {
        break label1245;
      }
      if (j != 1008) {
        break label394;
      }
      if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.showMsgNotification", 267);
      }
      a(267, paramToServiceMsg, (String)localObject1, i);
    }
    for (;;)
    {
      paramToServiceMsg = new Intent("com.tencent.msg.newmessage");
      paramToServiceMsg.setPackage("com.tencent.mobileqq");
      paramToServiceMsg.putExtra("cmds", arrayOfString);
      paramToServiceMsg.putExtra("intent", localIntent);
      paramToServiceMsg.putExtra("type", 0);
      paramToServiceMsg.putExtra("bitmap", localBitmap);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramToServiceMsg);
      return;
      if (bgvi.m)
      {
        localObject1 = a(localIntent, null, arrayOfString[0], arrayOfString[1], arrayOfString[2]);
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a("icon");
        paramToServiceMsg = (ToServiceMsg)localObject1;
        if (i <= 0) {
          break;
        }
        paramToServiceMsg = (ToServiceMsg)localObject1;
        if (((Notification)localObject1).contentView == null) {
          break;
        }
        ((Notification)localObject1).contentView.setImageViewBitmap(i, localBitmap);
        paramToServiceMsg = (ToServiceMsg)localObject1;
        break;
      }
      paramToServiceMsg = a(localIntent, localBitmap, arrayOfString[0], arrayOfString[1], arrayOfString[2]);
      break;
      label389:
      i = j;
      break label155;
      label394:
      if ((bool) && (j == 1010))
      {
        if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
          this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.showMsgNotification", 272);
        }
        a(272, paramToServiceMsg, (String)localObject1, i);
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQService", 2, "entry show_NOTIFY_ID_DATE_UNREAD notify");
        }
      }
      else if (((bool) && (j == 1001)) || (j == 10002))
      {
        if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
          this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.showMsgNotification", 268);
        }
        a(268, paramToServiceMsg, (String)localObject1, i);
        if (QLog.isColorLevel()) {
          QLog.d("MobileQQService", 2, "entry show_NOTIFY_ID_LBS_FRIEND_UNREAD notify");
        }
      }
      else if (localIntent.getBooleanExtra("qav_notify_flag", false))
      {
        if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
          this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.showMsgNotification", 236);
        }
        a(236, paramToServiceMsg, (String)localObject1, i);
      }
      else if (j == 3001)
      {
        if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
          this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.showMsgNotification", 271);
        }
        a(271, paramToServiceMsg, (String)localObject1, i);
      }
      else if ((j == 1037) || (j == 1044) || (j == 1045))
      {
        if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null)
        {
          this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.showMsgNotification", 275);
          this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.showMsgNotification", 266);
        }
        a(266, paramToServiceMsg, (String)localObject1, i);
      }
      else if (localIntent.getBooleanExtra("activepull_push_flag", false))
      {
        if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
          this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.showMsgNotification", 269);
        }
        a(269, paramToServiceMsg, (String)localObject1, i);
      }
      else if (j == 1030)
      {
        str = localIntent.getStringExtra("campus_notice_tag");
        j = localIntent.getIntExtra("campus_notice_id", 0);
        Object localObject2 = new bcso();
        ((bcso)localObject2).e = "0X800923F";
        ((bcso)localObject2).d = "Android系统通知曝光";
        if (QLog.isColorLevel()) {
          QLog.d("CampusNoticeManager", 2, new Object[] { "notification url :", localIntent.getStringExtra("url") });
        }
        bcsn.a(localIntent.getStringExtra("url"), (bcso)localObject2);
        bcsn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (bcso)localObject2);
        localObject2 = (aqbo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(240);
        a(str, j, paramToServiceMsg, (String)localObject1, i);
        if (QLog.isColorLevel()) {
          QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "show campus_notice [%d, %s]", new Object[] { Integer.valueOf(j), str }));
        }
      }
      else if ((j == 1035) || (j == 1041) || (j == 1042))
      {
        str = localIntent.getStringExtra("push_notice_tag");
        j = localIntent.getIntExtra("param_notifyid", 0);
        awhi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localIntent.getStringExtra("push_notice_service_id"), localIntent.getStringExtra("push_notice_content_id"), localIntent.getStringExtra("url"), "0X800923F", "Android系统通知曝光");
        if (QLog.isColorLevel()) {
          QLog.d("PushNoticeManager", 2, new Object[] { "notification url :", localIntent.getStringExtra("url") });
        }
        a(str, j, paramToServiceMsg, (String)localObject1, i);
        if (Build.VERSION.SDK_INT >= 19) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.t();
        }
        if (QLog.isColorLevel()) {
          QLog.d("PushNoticeManager", 2, String.format(Locale.getDefault(), "show push_notice [%d, %s]", new Object[] { Integer.valueOf(j), str }));
        }
      }
      else if (j == 7225)
      {
        a(localIntent.getStringExtra("push_notice_tag"), localIntent.getIntExtra("param_notifyid", 0), paramToServiceMsg, (String)localObject1, i);
      }
      else
      {
        if ((j == 0) && (localIntent.getBooleanExtra("key_reactive_push_tip", false))) {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A1BE", "0X800A1BE", 2, 0, "", "", "", "");
        }
        if ((bkgt.a(j)) && (bkgt.a(str)))
        {
          j = localIntent.getIntExtra("param_notifyid", 0);
          a(275);
          a(j, paramToServiceMsg, (String)localObject1, i);
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null)
          {
            this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.showMsgNotification", 265);
            this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.showMsgNotification", 275);
          }
          a(265, paramToServiceMsg, (String)localObject1, i);
          continue;
          label1245:
          if (localIntent.getBooleanExtra("qav_notify_flag", false))
          {
            if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
              this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.showMsgNotification", 236);
            }
            a(236, paramToServiceMsg, (String)localObject1, i);
          }
          else if (j == 1030)
          {
            str = localIntent.getStringExtra("campus_notice_tag");
            j = localIntent.getIntExtra("campus_notice_id", 0);
            if (QLog.isColorLevel()) {
              QLog.d("MobileQQService", 2, String.format(Locale.getDefault(), "show campus_notice [%d, %s]", new Object[] { Integer.valueOf(j), str }));
            }
            a(str, j, paramToServiceMsg, (String)localObject1, i);
          }
          else if ((j == 1035) || (j == 1041) || (j == 1042))
          {
            str = localIntent.getStringExtra("push_notice_tag");
            j = localIntent.getIntExtra("param_notifyid", 0);
            awhi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localIntent.getStringExtra("push_notice_service_id"), localIntent.getStringExtra("push_notice_content_id"), localIntent.getStringExtra("url"), "0X800923F", "Android系统通知曝光");
            if (QLog.isColorLevel()) {
              QLog.d("MobileQQService", 2, String.format(Locale.getDefault(), "show push_notice [%d, %s]", new Object[] { Integer.valueOf(j), str }));
            }
            a(str, j, paramToServiceMsg, (String)localObject1, i);
            if (Build.VERSION.SDK_INT >= 19) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.t();
            }
          }
          else if ((j == 1037) || (j == 1045) || (j == 1044))
          {
            if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
              this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.showMsgNotification", 266);
            }
            a(266, paramToServiceMsg, (String)localObject1, i);
          }
          else
          {
            if ((j == 0) && (localIntent.getBooleanExtra("key_reactive_push_tip", false))) {
              bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A1BE", "0X800A1BE", 2, 0, "", "", "", "");
            }
            if ((bkgt.a(j)) && (bkgt.a(str)))
            {
              j = localIntent.getIntExtra("param_notifyid", 0);
              a(275);
              a(j, paramToServiceMsg, (String)localObject1, i);
            }
            else
            {
              if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null)
              {
                this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.showMsgNotification", 265);
                this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.showMsgNotification", 275);
              }
              a(265, paramToServiceMsg, (String)localObject1, i);
            }
          }
        }
      }
    }
  }
  
  public AppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  protected void a()
  {
    try
    {
      super.a();
      a(new bnos(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new bcbm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new bbxx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new bbzi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new bbyk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new bcbt());
      bcbo localbcbo = new bcbo();
      a(localbcbo);
      localbcbo.a(this.jdField_a_of_type_Aqhm);
      a(new bbxr());
      a(new bcby());
      a(new bbxw());
      a(new bbxj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new bbxo());
      a(new bbxq());
      a(new nkh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      a(new bcbq());
      a(new bcbr());
      a(new bbxn());
      a(new bcbp());
      a(new bccc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
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
  
  protected void a(FromServiceMsg paramFromServiceMsg)
  {
    awhd.a().a(paramFromServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    b(paramToServiceMsg, this.jdField_a_of_type_Aqhm, aqho.class);
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, aqhm paramaqhm, Class<? extends MSFServlet> paramClass)
  {
    if (paramToServiceMsg == null) {}
    do
    {
      return;
      paramClass = paramToServiceMsg.getServiceCmd();
      if (!"CMD_SHOW_NOTIFIYCATION".equals(paramClass)) {
        break;
      }
      if (!((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).a())
      {
        c(paramToServiceMsg);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MobileQQService", 2, "pcm blocked msg notification");
    return;
    if ("CMD_IDLE_NOTIFIYCATION".equals(paramClass))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.D();
      b(paramToServiceMsg);
      return;
    }
    if ("CMD_STOP_NOTIFIYCATION".equals(paramClass))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.D();
      a(275);
      return;
    }
    if ("CMD_CANCLE_NOTIFIYCATION".equals(paramClass))
    {
      b(275);
      return;
    }
    super.a(paramToServiceMsg, paramaqhm, aqho.class);
  }
  
  void a(String paramString1, int paramInt1, Notification paramNotification, String paramString2, int paramInt2)
  {
    int k = 0;
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {}
    int j;
    for (;;)
    {
      try
      {
        QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        azwe localazwe = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (localazwe == null) {
          break label305;
        }
        i = localazwe.a();
        if (localQQMessageFacade == null) {
          break label299;
        }
        j = localQQMessageFacade.b();
        if (!TextUtils.isEmpty(paramString1)) {
          break label362;
        }
        if (paramInt1 == 265) {
          break;
        }
        if ((paramInt1 < 512) || (paramInt1 > 522)) {
          break label355;
        }
      }
      catch (Throwable paramString1)
      {
        if (!QLog.isColorLevel()) {
          break label354;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("BadgeUtilImpl", 2, "startForegroundCompat changeMI6Badge count=" + i);
      }
      if (bkfm.a(BaseApplicationImpl.getApplication().getApplicationContext())) {
        bkfm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), i, paramNotification);
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
        break label354;
      }
      QLog.i("MobileQQService", 2, "startForegroundCompat. id=" + paramInt1 + ", mNM=" + this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager);
      return;
      label292:
      i = j;
      continue;
      label299:
      j = 0;
      continue;
      label305:
      i = 0;
    }
    int i = j;
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
        break label292;
      }
      i = k;
      break;
      label354:
      return;
      label355:
      if (paramInt1 != 236) {
        label362:
        i = 1;
      }
    }
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    if (!paramBoolean)
    {
      if (paramFromServiceMsg.getResultCode() == 2008)
      {
        paramFromServiceMsg = BaseActivity.sTopActivity;
        paramToServiceMsg = paramFromServiceMsg;
        if (paramFromServiceMsg == null) {
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
        }
        paramFromServiceMsg = new Intent(paramToServiceMsg, NotificationActivity.class);
        paramFromServiceMsg.setFlags(872415232);
        paramFromServiceMsg.putExtra("type", 2);
        paramToServiceMsg.startActivity(paramFromServiceMsg);
        return;
      }
      if ((paramException == null) && ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013)) && ("ProfileService.CheckUpdateReq".equals(paramFromServiceMsg.getServiceCmd()))) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a();
      }
    }
    super.a(paramBoolean, paramToServiceMsg, paramFromServiceMsg, paramException);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager == null) && (this.jdField_b_of_type_Int < 3)) {}
    try
    {
      this.c = bgln.a();
      a(true);
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
  
  void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("MobileQQService.cancelNotification", paramInt);
    }
  }
  
  public void c()
  {
    a(false);
    a(275);
    if (QLog.isColorLevel()) {
      QLog.i("MobileQQService", 2, "MobileQQService has destroyed.");
    }
    this.jdField_a_of_type_Aqhm = null;
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbxc
 * JD-Core Version:    0.7.0.1
 */