package com.tencent.av.utils;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.GaInviteDialogActivity;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteFull;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kit;
import mqq.app.MobileQQ;

public class QAVNotification
{
  static QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification;
  Notification jdField_a_of_type_AndroidAppNotification = null;
  Context jdField_a_of_type_AndroidContentContext = null;
  RemoteViews jdField_a_of_type_AndroidWidgetRemoteViews = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  NotificationStyleDiscover jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover;
  QNotificationManager jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager = null;
  Map jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  kit jdField_a_of_type_Kit = null;
  boolean jdField_a_of_type_Boolean = false;
  
  private QAVNotification(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext();
    }
    this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover = new NotificationStyleDiscover(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public static QAVNotification a(VideoAppInterface paramVideoAppInterface)
  {
    if ((jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) && (paramVideoAppInterface != null)) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
        jdField_a_of_type_ComTencentAvUtilsQAVNotification = new QAVNotification(paramVideoAppInterface);
      }
      return jdField_a_of_type_ComTencentAvUtilsQAVNotification;
    }
    finally {}
  }
  
  @TargetApi(16)
  private void a(int paramInt, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewTextSize(paramInt, 2, paramFloat);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRemoteViews.setFloat(paramInt, "setTextSize", paramFloat);
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAVNotification", 2, "cancelNotificationForce");
    }
    new QNotificationManager(paramContext).cancel("QAVNotification", 2130840368);
  }
  
  private void a(kit paramkit, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QAVNotification", 1, "updateNotification, type[" + paramkit.jdField_a_of_type_Int + "], name[" + paramkit.jdField_b_of_type_JavaLangString + "], bCreate[" + paramBoolean + "]");
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().p()) || (!c(paramkit.jdField_a_of_type_JavaLangString))) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidAppNotification == null)
      {
        this.jdField_a_of_type_AndroidAppNotification = new Notification();
        this.jdField_a_of_type_AndroidAppNotification.when = System.currentTimeMillis();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager = new QNotificationManager(this.jdField_a_of_type_AndroidContentContext);
      }
      if (this.jdField_a_of_type_AndroidWidgetRemoteViews == null) {
        this.jdField_a_of_type_AndroidWidgetRemoteViews = new RemoteViews(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 2130969370);
      }
    } while ((paramkit.jdField_b_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager == null) || (this.jdField_a_of_type_AndroidAppNotification == null) || (this.jdField_a_of_type_AndroidWidgetRemoteViews == null));
    String str = paramkit.jdField_b_of_type_JavaLangString;
    int j = str.length();
    int i;
    if (j >= 7)
    {
      localObject1 = paramkit.jdField_b_of_type_JavaLangString.toCharArray();
      str = String.valueOf(localObject1[0]);
      i = 1;
      while (i < 5)
      {
        str = str + String.valueOf(localObject1[i]);
        i += 1;
      }
      str = str + "...";
    }
    Object localObject1 = "";
    Object localObject2;
    label399:
    label496:
    Object localObject3;
    switch (paramkit.jdField_a_of_type_Int)
    {
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    default: 
      str = "";
      localObject2 = null;
    case 48: 
    case 40: 
    case 41: 
    case 42: 
    case 45: 
    case 46: 
    case 47: 
      for (;;)
      {
        i = SessionInfo.X;
        if ((localObject2 == null) || (!paramBoolean)) {
          break label2521;
        }
        ((Intent)localObject2).putExtra("MultiAVType", i);
        ((Intent)localObject2).putExtra("Fromwhere", "AVNotification");
        ((Intent)localObject2).addFlags(4194304);
        ((Intent)localObject2).addFlags(262144);
        if ((paramkit.jdField_a_of_type_Int != 40) && (paramkit.jdField_a_of_type_Int != 45) && (paramkit.jdField_a_of_type_Int != 43)) {
          ((Intent)localObject2).addFlags(268435456);
        }
        localObject2 = PendingIntent.getActivity(this.jdField_a_of_type_AndroidContentContext, 0, (Intent)localObject2, 134217728);
        if (this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.b() > 0.0F) {
          a(2131366311, this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.b());
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.a() > 0.0F) {
          a(2131366313, this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover.a());
        }
        localObject3 = localObject1;
        if (localObject1 != null)
        {
          localObject3 = localObject1;
          if (i == 2)
          {
            localObject1 = ((String)localObject1).replace(this.jdField_a_of_type_AndroidContentContext.getString(2131433846), this.jdField_a_of_type_AndroidContentContext.getString(2131433848));
            localObject3 = localObject1;
            if (this.jdField_a_of_type_AndroidAppNotification.tickerText != null)
            {
              this.jdField_a_of_type_AndroidAppNotification.tickerText = this.jdField_a_of_type_AndroidAppNotification.tickerText.toString().replace(this.jdField_a_of_type_AndroidContentContext.getString(2131433846), this.jdField_a_of_type_AndroidContentContext.getString(2131433848));
              localObject3 = localObject1;
            }
          }
        }
        localObject1 = str;
        if (str != null)
        {
          localObject1 = str;
          if (i == 2) {
            localObject1 = str.replace(this.jdField_a_of_type_AndroidContentContext.getString(2131433846), this.jdField_a_of_type_AndroidContentContext.getString(2131433848));
          }
        }
        if (QLog.isColorLevel()) {
          QLog.w("QAVNotification", 1, "updateNotification, title[" + (String)localObject3 + "], state[" + (String)localObject1 + "], id[" + paramkit.jdField_c_of_type_JavaLangString + "], sessionId[" + paramkit.jdField_a_of_type_JavaLangString + "], name[" + paramkit.jdField_b_of_type_JavaLangString + "], type[" + paramkit.jdField_a_of_type_Int + "], avtype[" + i + "]");
        }
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131366311, paramkit.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131366313, (CharSequence)localObject1);
        if (paramBoolean) {}
        try
        {
          if (paramkit.jdField_a_of_type_AndroidGraphicsBitmap != null) {
            this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewBitmap(2131366310, paramkit.jdField_a_of_type_AndroidGraphicsBitmap);
          }
          this.jdField_a_of_type_AndroidAppNotification.flags = 2;
          this.jdField_a_of_type_AndroidAppNotification.contentView = this.jdField_a_of_type_AndroidWidgetRemoteViews;
          this.jdField_a_of_type_AndroidAppNotification.contentIntent = ((PendingIntent)localObject2);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(true, this.jdField_a_of_type_AndroidAppNotification);
          this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.notify("QAVNotification", 2130840368, this.jdField_a_of_type_AndroidAppNotification);
          this.jdField_a_of_type_Kit = paramkit;
          paramkit.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Boolean = true;
          return;
        }
        catch (Throwable paramkit) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QAVNotification", 2, "updateNotification", paramkit);
        return;
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
        ((Intent)localObject2).putExtra("isDoubleVideoMeeting", true);
        ((Intent)localObject2).putExtra("sessionType", paramkit.jdField_c_of_type_Int);
        ((Intent)localObject2).putExtra("GroupId", paramkit.jdField_c_of_type_JavaLangString);
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131429024);
        this.jdField_a_of_type_AndroidAppNotification.tickerText = str;
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131366312, 2130840368);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130840368;
        localObject1 = str;
        continue;
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, VideoInviteFull.class);
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131428843);
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131428952);
        this.jdField_a_of_type_AndroidAppNotification.tickerText = str;
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131366312, 2130840368);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130840368;
        continue;
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
        ((Intent)localObject2).putExtra("sessionType", paramkit.jdField_c_of_type_Int);
        ((Intent)localObject2).putExtra("uin", paramkit.jdField_c_of_type_JavaLangString);
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131428843);
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131429104);
        this.jdField_a_of_type_AndroidAppNotification.tickerText = str;
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131366312, 2130840368);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130840368;
        continue;
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
        ((Intent)localObject2).putExtra("sessionType", paramkit.jdField_c_of_type_Int);
        ((Intent)localObject2).putExtra("uin", paramkit.jdField_c_of_type_JavaLangString);
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131429024);
        this.jdField_a_of_type_AndroidAppNotification.tickerText = str;
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131366312, 2130840368);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130840368;
        localObject1 = str;
        continue;
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, VideoInviteFull.class);
        ((Intent)localObject2).addFlags(4194304);
        ((Intent)localObject2).addFlags(262144);
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131429064);
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131428889);
        this.jdField_a_of_type_AndroidAppNotification.tickerText = str;
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131366312, 2130840237);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130840237;
        continue;
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
        ((Intent)localObject2).putExtra("sessionType", paramkit.jdField_c_of_type_Int);
        ((Intent)localObject2).putExtra("GroupId", paramkit.jdField_c_of_type_JavaLangString);
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131429064);
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131429104);
        this.jdField_a_of_type_AndroidAppNotification.tickerText = str;
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131366312, 2130840237);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130840237;
        continue;
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
        ((Intent)localObject2).putExtra("sessionType", paramkit.jdField_c_of_type_Int);
        ((Intent)localObject2).putExtra("GroupId", paramkit.jdField_c_of_type_JavaLangString);
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131429025);
        this.jdField_a_of_type_AndroidAppNotification.tickerText = str;
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131366312, 2130840237);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130840237;
        localObject1 = str;
      }
    case 43: 
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131428959);
      localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131428907);
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, GaInviteDialogActivity.class);
      ((Intent)localObject2).putExtra("sessionType", paramkit.jdField_c_of_type_Int);
      ((Intent)localObject2).putExtra("uinType", paramkit.jdField_b_of_type_Int);
      BaseGaInvite.a((Intent)localObject2, "updateNotification");
      if (j >= 7) {
        this.jdField_a_of_type_AndroidAppNotification.tickerText = (str + (String)localObject3);
      }
      for (str = str + (String)localObject3;; str = paramkit.jdField_b_of_type_JavaLangString + (String)localObject3)
      {
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131366312, 2130840237);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130840237;
        break;
        this.jdField_a_of_type_AndroidAppNotification.tickerText = (paramkit.jdField_b_of_type_JavaLangString + (String)localObject3);
      }
    case 44: 
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      ((Intent)localObject2).putExtra("GroupId", paramkit.jdField_c_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("Type", 2);
      ((Intent)localObject2).putExtra("sessionType", 3);
      ((Intent)localObject2).putExtra("uinType", paramkit.jdField_b_of_type_Int);
      ((Intent)localObject2).putExtra("sessionType", paramkit.jdField_c_of_type_Int);
      if (paramkit.jdField_b_of_type_Int == 3000) {
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131429125);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppNotification.tickerText = str;
      this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131366312, 2130840237);
      this.jdField_a_of_type_AndroidAppNotification.icon = 2130840237;
      localObject1 = str;
      break label399;
      if (paramkit.jdField_b_of_type_Int == 1)
      {
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131429125);
        continue;
        if (paramkit.jdField_c_of_type_Int == 3)
        {
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, GuildMultiActivity.class);
          ((Intent)localObject2).putExtra("sessionType", paramkit.jdField_c_of_type_Int);
          ((Intent)localObject2).putExtra("GroupId", paramkit.jdField_c_of_type_JavaLangString);
          ((Intent)localObject2).putExtra("uinType", paramkit.jdField_b_of_type_Int);
          this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131366310, 2130840253);
          if ((paramkit.jdField_a_of_type_Int != 58) && (paramkit.jdField_a_of_type_Int != 59)) {
            break label2137;
          }
          i = 1;
          label2055:
          if (i == 0) {
            break label2142;
          }
        }
        label2137:
        label2142:
        for (i = 2131429364;; i = 2131429360)
        {
          str = this.jdField_a_of_type_AndroidContentContext.getString(i);
          this.jdField_a_of_type_AndroidAppNotification.tickerText = str;
          this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131366312, 2130840237);
          this.jdField_a_of_type_AndroidAppNotification.icon = 2130840237;
          localObject1 = str;
          break label399;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("QAVNotification", 2, "FLAG_GUILD_CHATTING with wrong notifaction argument");
          str = "";
          localObject2 = null;
          break label399;
          i = 0;
          break label2055;
        }
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, MultiIncomingCallsActivity.class);
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131429064);
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131428889);
        this.jdField_a_of_type_AndroidAppNotification.tickerText = str;
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131366312, 2130840237);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130840237;
        break label399;
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, MultiIncomingCallsActivity.class);
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131428843);
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131428952);
        this.jdField_a_of_type_AndroidAppNotification.tickerText = str;
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131366312, 2130840368);
        this.jdField_a_of_type_AndroidAppNotification.icon = 2130840368;
        break label399;
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, MultiIncomingCallsActivity.class);
        if (paramkit.jdField_b_of_type_Int == 3000)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131428958);
          label2335:
          ((Intent)localObject2).putExtra("sessionType", paramkit.jdField_c_of_type_Int);
          localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131428907);
          if (j < 7) {
            break label2465;
          }
          this.jdField_a_of_type_AndroidAppNotification.tickerText = (str + (String)localObject3);
        }
        for (str = str + (String)localObject3;; str = paramkit.jdField_b_of_type_JavaLangString + (String)localObject3)
        {
          this.jdField_a_of_type_AndroidWidgetRemoteViews.setImageViewResource(2131366312, 2130840237);
          this.jdField_a_of_type_AndroidAppNotification.icon = 2130840237;
          break;
          if (paramkit.jdField_b_of_type_Int != 1) {
            break label2335;
          }
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131428959);
          break label2335;
          label2465:
          this.jdField_a_of_type_AndroidAppNotification.tickerText = (paramkit.jdField_b_of_type_JavaLangString + (String)localObject3);
        }
        label2521:
        localObject2 = null;
        break label496;
      }
      str = "";
    }
  }
  
  private boolean d(String paramString)
  {
    if ((this.jdField_a_of_type_Kit == null) || (!this.jdField_a_of_type_Boolean)) {}
    while (!TextUtils.equals(paramString, this.jdField_a_of_type_Kit.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    return true;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAVNotification", 2, "cancelNotificationEx mIsActive: " + this.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.cancel("QAVNotification", 2130840368);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(false, null);
        this.jdField_a_of_type_Kit = null;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilMap.clear();
        this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager = null;
        this.jdField_a_of_type_AndroidAppNotification = null;
        this.jdField_a_of_type_AndroidWidgetRemoteViews = null;
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QAVNotification", 2, "cancelNotification mIsActive: " + this.jdField_a_of_type_Boolean + ", sessionId:" + paramString);
        }
        if (d(paramString))
        {
          this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.cancel("QAVNotification", 2130840368);
          this.jdField_a_of_type_JavaUtilMap.remove(paramString);
          this.jdField_a_of_type_Kit = null;
          this.jdField_a_of_type_Boolean = false;
          if (!this.jdField_a_of_type_JavaUtilMap.isEmpty())
          {
            paramString = this.jdField_a_of_type_JavaUtilMap.values().iterator();
            if (paramString.hasNext()) {
              a((kit)paramString.next(), true);
            }
            return;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(false, null);
          continue;
        }
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      }
      finally {}
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QAVNotification", 2, String.format("updateNotification, sessionId[%s] mIsActive[%s], SessionType[%s], time[%s]", new Object[] { paramString1, Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(paramInt), paramString2 }));
        }
        if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().p())
        {
          boolean bool = c(paramString1);
          if (bool) {}
        }
        else
        {
          return;
        }
        if (!d(paramString1))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QAVNotification", 2, "session : " + paramString1 + " is not active");
          continue;
        }
        paramString1 = SessionMgr.a().a(paramString1);
      }
      finally {}
      if (((paramString1 == null) || (paramString1.a.jdField_b_of_type_Int != 4)) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppNotification != null))
      {
        this.jdField_a_of_type_AndroidWidgetRemoteViews = new RemoteViews(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 2130969370);
        this.jdField_a_of_type_AndroidAppNotification.contentView = this.jdField_a_of_type_AndroidWidgetRemoteViews;
        if (this.jdField_a_of_type_Kit.jdField_b_of_type_Int != 1011) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131366313, paramString2);
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.notify("QAVNotification", 2130840368, this.jdField_a_of_type_AndroidAppNotification);
        }
        catch (Exception paramString1) {}
        if (QLog.isColorLevel()) {
          QLog.d("QAVNotification", 2, "notify Notification ", paramString1);
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetRemoteViews.setTextViewText(2131366313, paramString2);
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager.notify("QAVNotification", 2130840368, this.jdField_a_of_type_AndroidAppNotification);
        }
        catch (Exception paramString1) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QAVNotification", 2, "notify Notification", paramString1);
      break;
      paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131429025);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = paramString1;
      continue;
      paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131429024);
      this.jdField_a_of_type_AndroidAppNotification.tickerText = paramString1;
      continue;
      switch (paramInt)
      {
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAVNotification", 2, "changeNotificationSessionId " + paramString1 + " to " + paramString2);
      }
      kit localkit = (kit)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
      if (localkit != null)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramString1);
        this.jdField_a_of_type_JavaUtilMap.put(paramString2, localkit);
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QAVNotification", 2, "addNotification sessionId: " + paramString1 + ", name: " + paramString2 + ", id: " + paramString3 + ", type: " + paramInt1 + ", uinType:" + paramInt2 + ", sessionType:" + paramInt3);
        }
        boolean bool = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().p();
        if (bool) {
          return;
        }
        if (((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d()) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a())) || (TextUtils.isEmpty(paramString1))) {
          continue;
        }
        if (d(paramString1))
        {
          paramString2 = this.jdField_a_of_type_Kit;
          paramString2.jdField_a_of_type_JavaLangString = paramString1;
          paramString2.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
          paramString2.jdField_a_of_type_Int = paramInt1;
          paramString2.jdField_c_of_type_JavaLangString = paramString3;
          paramString2.jdField_b_of_type_Int = paramInt2;
          paramString2.jdField_c_of_type_Int = paramInt3;
          a(paramString2, false);
          continue;
        }
        paramString2 = new kit(this, paramString1, paramString2, paramBitmap, paramString3, paramInt1, paramInt2, paramInt3);
      }
      finally {}
      this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
      a(paramString2, true);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +42 -> 49
    //   10: ldc 95
    //   12: iconst_2
    //   13: new 114	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 503
    //   23: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 32	com/tencent/av/utils/QAVNotification:jdField_a_of_type_Boolean	Z
    //   30: invokevirtual 139	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   33: ldc_w 393
    //   36: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_1
    //   40: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: aload_1
    //   51: invokespecial 395	com/tencent/av/utils/QAVNotification:d	(Ljava/lang/String;)Z
    //   54: ifeq +36 -> 90
    //   57: aload_0
    //   58: getfield 34	com/tencent/av/utils/QAVNotification:jdField_a_of_type_Kit	Lkit;
    //   61: iconst_1
    //   62: putfield 305	kit:jdField_a_of_type_Boolean	Z
    //   65: aload_0
    //   66: getfield 24	com/tencent/av/utils/QAVNotification:jdField_a_of_type_ComTencentMobileqqMsfSdkQNotificationManager	Lcom/tencent/mobileqq/msf/sdk/QNotificationManager;
    //   69: ldc 95
    //   71: ldc 105
    //   73: invokevirtual 109	com/tencent/mobileqq/msf/sdk/QNotificationManager:cancel	(Ljava/lang/String;I)V
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 34	com/tencent/av/utils/QAVNotification:jdField_a_of_type_Kit	Lkit;
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 32	com/tencent/av/utils/QAVNotification:jdField_a_of_type_Boolean	Z
    //   86: aload_0
    //   87: monitorexit
    //   88: iload_2
    //   89: ireturn
    //   90: iconst_0
    //   91: istore_2
    //   92: goto -6 -> 86
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	QAVNotification
    //   0	100	1	paramString	String
    //   1	91	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	49	95	finally
    //   49	86	95	finally
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 95
    //   10: iconst_2
    //   11: new 114	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 505
    //   21: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: getfield 39	com/tencent/av/utils/QAVNotification:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   38: aload_1
    //   39: invokeinterface 471 2 0
    //   44: checkcast 123	kit
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +29 -> 78
    //   52: aload_1
    //   53: getfield 305	kit:jdField_a_of_type_Boolean	Z
    //   56: ifeq +22 -> 78
    //   59: aload_0
    //   60: getfield 32	com/tencent/av/utils/QAVNotification:jdField_a_of_type_Boolean	Z
    //   63: ifne +15 -> 78
    //   66: aload_0
    //   67: aload_1
    //   68: iconst_1
    //   69: invokespecial 423	com/tencent/av/utils/QAVNotification:a	(Lkit;Z)V
    //   72: iconst_1
    //   73: istore_2
    //   74: aload_0
    //   75: monitorexit
    //   76: iload_2
    //   77: ireturn
    //   78: iconst_0
    //   79: istore_2
    //   80: goto -6 -> 74
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	QAVNotification
    //   0	88	1	paramString	String
    //   73	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	34	83	finally
    //   34	48	83	finally
    //   52	72	83	finally
  }
  
  boolean c(String paramString)
  {
    boolean bool2 = false;
    paramString = SessionMgr.a().a(paramString);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAVNotification", 2, "isSessionIdVisible sessionInfo.sessionStatus = " + paramString.jdField_c_of_type_Int);
      }
      bool1 = bool2;
      if (paramString.jdField_c_of_type_Int != 3) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.utils.QAVNotification
 * JD-Core Version:    0.7.0.1
 */