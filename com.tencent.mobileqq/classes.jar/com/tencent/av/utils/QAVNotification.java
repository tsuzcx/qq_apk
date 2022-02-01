package com.tencent.av.utils;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.GaInviteDialogActivity;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class QAVNotification
{
  static QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification;
  int jdField_a_of_type_Int = 0;
  Notification jdField_a_of_type_AndroidAppNotification = null;
  Context jdField_a_of_type_AndroidContentContext = null;
  RemoteViews jdField_a_of_type_AndroidWidgetRemoteViews = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  NotificationStyleDiscover jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover;
  QAVNotification.NotifyData jdField_a_of_type_ComTencentAvUtilsQAVNotification$NotifyData = null;
  QQNotificationManager jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = null;
  Map<String, QAVNotification.NotifyData> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  boolean jdField_a_of_type_Boolean = false;
  final QAVNotification.NotifyData b = new QAVNotification.NotifyData(this, null);
  
  private QAVNotification(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext();
    }
    this.jdField_a_of_type_ComTencentAvUtilsNotificationStyleDiscover = new NotificationStyleDiscover(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private Notification a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, int paramInt, Bitmap paramBitmap, PendingIntent paramPendingIntent, List<QAVNotification.NotificationAction> paramList)
  {
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(this.jdField_a_of_type_AndroidContentContext);
    localBuilder.setSmallIcon(paramInt);
    localBuilder.setContentTitle(paramString1);
    localBuilder.setContentText(paramString2);
    localBuilder.setWhen(System.currentTimeMillis());
    localBuilder.setLargeIcon(paramBitmap);
    localBuilder.setContentIntent(paramPendingIntent);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (QAVNotification.NotificationAction)paramString1.next();
        localBuilder.addAction(paramString2.jdField_a_of_type_Int, paramString2.jdField_a_of_type_JavaLangString, paramString2.jdField_a_of_type_AndroidAppPendingIntent);
      }
    }
    if (paramBoolean2)
    {
      localBuilder.setPriority(2);
      localBuilder.setFullScreenIntent(paramPendingIntent, true);
      localBuilder.setVibrate(TraeHelper.a);
    }
    else
    {
      localBuilder.setPriority(0);
      localBuilder.setFullScreenIntent(null, false);
      localBuilder.setVibrate(null);
    }
    this.jdField_a_of_type_AndroidAppNotification = localBuilder.build();
    paramString1 = this.jdField_a_of_type_AndroidAppNotification;
    paramString1.flags |= 0x2;
    paramString1 = this.jdField_a_of_type_AndroidAppNotification;
    paramString1.flags |= 0x20;
    if ((AVUtil.b()) && (paramBoolean2))
    {
      paramString1 = this.jdField_a_of_type_AndroidAppNotification;
      paramString1.flags &= 0xFFFFFFF7;
      paramString1 = this.jdField_a_of_type_AndroidAppNotification;
      paramString1.flags |= 0x4;
      paramString1 = this.jdField_a_of_type_AndroidAppNotification;
      paramString1.flags = (0x1 | paramString1.flags);
    }
    else
    {
      paramString1 = this.jdField_a_of_type_AndroidAppNotification;
      paramString1.flags |= 0x8;
      paramString1 = this.jdField_a_of_type_AndroidAppNotification;
      paramString1.flags &= 0xFFFFFFFB;
      paramString1 = this.jdField_a_of_type_AndroidAppNotification;
      paramString1.flags &= 0xFFFFFFFE;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      if (paramBoolean2)
      {
        paramString1 = this.jdField_a_of_type_AndroidAppNotification;
        paramString1.category = "call";
        paramString1.flags |= 0x80;
      }
      else
      {
        paramString1 = this.jdField_a_of_type_AndroidAppNotification;
        paramString1.category = null;
        paramString1.flags &= 0xFFFFFF7F;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("useDefaultStyle flags: ");
      paramString1.append(this.jdField_a_of_type_AndroidAppNotification.flags);
      QLog.i("QAVNotification", 2, paramString1.toString());
    }
    return this.jdField_a_of_type_AndroidAppNotification;
  }
  
  private QAVNotification.NotifyData a(String paramString, int paramInt)
  {
    SessionInfo localSessionInfo = SessionMgr.a().c(paramString);
    Object localObject;
    if (localSessionInfo != null)
    {
      localObject = new QAVNotification.NotifyData(this, null);
      ((QAVNotification.NotifyData)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((QAVNotification.NotifyData)localObject).jdField_c_of_type_Int = paramInt;
      if ((localSessionInfo.d != 1) && (localSessionInfo.d != 2))
      {
        String str;
        if (localSessionInfo.y)
        {
          str = String.valueOf(localSessionInfo.f);
          ((QAVNotification.NotifyData)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(localSessionInfo.k, str, null);
          ((QAVNotification.NotifyData)localObject).jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(localSessionInfo.k, str, null, true, true);
          ((QAVNotification.NotifyData)localObject).jdField_a_of_type_Int = 48;
        }
        else
        {
          str = String.valueOf(localSessionInfo.f);
          ((QAVNotification.NotifyData)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(localSessionInfo.k, str, null);
          ((QAVNotification.NotifyData)localObject).jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(localSessionInfo.k, str, null, true, true);
          if (localSessionInfo.d == 3) {
            ((QAVNotification.NotifyData)localObject).jdField_a_of_type_Int = 62;
          } else {
            ((QAVNotification.NotifyData)localObject).jdField_a_of_type_Int = 63;
          }
        }
      }
      else
      {
        ((QAVNotification.NotifyData)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(localSessionInfo.k, localSessionInfo.jdField_c_of_type_JavaLangString, localSessionInfo.e);
        ((QAVNotification.NotifyData)localObject).jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(localSessionInfo.k, localSessionInfo.jdField_c_of_type_JavaLangString, null, true, true);
        if (localSessionInfo.d == 1) {
          ((QAVNotification.NotifyData)localObject).jdField_a_of_type_Int = 47;
        } else {
          ((QAVNotification.NotifyData)localObject).jdField_a_of_type_Int = 42;
        }
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("createNotifyData, we create one data, data[");
        paramString.append(localObject);
        paramString.append("]");
        QLog.i("QAVNotification", 2, paramString.toString());
      }
      return localObject;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createNotifyData, no sessionInfo, id[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.i("QAVNotification", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public static QAVNotification a(VideoAppInterface paramVideoAppInterface)
  {
    if ((jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) && (paramVideoAppInterface != null)) {
      try
      {
        if (jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
          jdField_a_of_type_ComTencentAvUtilsQAVNotification = new QAVNotification(paramVideoAppInterface);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvUtilsQAVNotification;
  }
  
  private String a(String paramString, int paramInt)
  {
    Object localObject1;
    if (paramString == null) {
      localObject1 = "";
    } else {
      localObject1 = paramString;
    }
    Object localObject2 = localObject1;
    if (((String)localObject1).length() >= paramInt)
    {
      localObject2 = localObject1;
      if (paramInt > 0)
      {
        localObject1 = paramString.toCharArray();
        paramString = String.valueOf(localObject1[0]);
        paramInt = 1;
        while (paramInt < 5)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(String.valueOf(localObject1[paramInt]));
          paramString = ((StringBuilder)localObject2).toString();
          paramInt += 1;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("...");
        localObject2 = ((StringBuilder)localObject1).toString();
      }
    }
    return localObject2;
  }
  
  private ArrayList<QAVNotification.NotificationAction> a(QAVNotification.NotifyData paramNotifyData, Intent paramIntent)
  {
    ArrayList localArrayList = null;
    if (paramNotifyData != null)
    {
      if (paramIntent == null) {
        return null;
      }
      int i = paramNotifyData.jdField_a_of_type_Int;
      if ((i != 40) && (i != 45) && (i != 61)) {
        switch (i)
        {
        default: 
          return null;
        }
      }
      localArrayList = new ArrayList(2);
      paramIntent = new Intent(paramIntent);
      paramIntent.setAction("com.tencent.qav.notify.accept");
      paramIntent.putExtra("session_id", paramNotifyData.jdField_a_of_type_JavaLangString);
      localArrayList.add(new QAVNotification.NotificationAction(2130842185, HardCodeUtil.a(2131708926), PendingIntent.getActivity(this.jdField_a_of_type_AndroidContentContext, 0, paramIntent, 134217728)));
      paramIntent = new Intent("com.tencent.qav.notify.refuse");
      paramIntent.putExtra("uin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      paramIntent.putExtra("session_id", paramNotifyData.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("notify_type", paramNotifyData.jdField_a_of_type_Int);
      paramIntent.putExtra("uinType", paramNotifyData.jdField_b_of_type_Int);
      localArrayList.add(new QAVNotification.NotificationAction(2130842187, HardCodeUtil.a(2131708925), PendingIntent.getBroadcast(this.jdField_a_of_type_AndroidContentContext, 0, paramIntent, 134217728)));
    }
    return localArrayList;
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAVNotification", 2, "cancelNotificationForce", new Throwable());
    }
    QQNotificationManager.getInstance().cancel("QAVNotification", 235);
  }
  
  private void a(QAVNotification.NotifyData paramNotifyData, boolean paramBoolean)
  {
    a(paramNotifyData, paramBoolean, null, false);
  }
  
  private void a(QAVNotification.NotifyData paramNotifyData, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    a(paramNotifyData, paramBoolean1, paramString, paramBoolean2, false);
  }
  
  private void a(QAVNotification.NotifyData paramNotifyData, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool1 = e(paramNotifyData.jdField_a_of_type_JavaLangString);
    boolean bool2 = d(paramNotifyData.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(200);
      ((StringBuilder)localObject1).append("updateNotification, data=");
      ((StringBuilder)localObject1).append(paramNotifyData);
      ((StringBuilder)localObject1).append(", create=");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(", time=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", invite=");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ((StringBuilder)localObject1).append(", fullScreen=");
      ((StringBuilder)localObject1).append(paramBoolean3);
      ((StringBuilder)localObject1).append(", isSessionCanNotify=");
      ((StringBuilder)localObject1).append(bool2);
      QLog.d("QAVNotification", 2, ((StringBuilder)localObject1).toString());
    }
    if (((!paramBoolean2) && (!bool1)) || (!bool2)) {
      return;
    }
    if (!TextUtils.isEmpty(paramString)) {
      a(paramNotifyData);
    }
    paramBoolean2 = AVUtil.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateNotification avCallBtnState[");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ((StringBuilder)localObject1).append("]");
      QLog.w("QAVNotification", 2, ((StringBuilder)localObject1).toString());
    }
    if ((!paramBoolean2) && (TextUtils.isEmpty(paramString)) && (!a(paramNotifyData))) {
      return;
    }
    paramBoolean2 = TraeHelper.a(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateNotification canDisturb[");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ((StringBuilder)localObject1).append("]");
      QLog.w("QAVNotification", 2, ((StringBuilder)localObject1).toString());
    }
    if ((!paramBoolean2) && (TextUtils.isEmpty(paramString)) && (!a(paramNotifyData))) {
      return;
    }
    int j = paramNotifyData.jdField_a_of_type_Int;
    int i = 2130842201;
    switch (j)
    {
    default: 
      switch (j)
      {
      default: 
        switch (j)
        {
        default: 
          localObject1 = "";
          localObject2 = null;
          i = 0;
          paramString = "";
          localObject3 = null;
          break;
        case 63: 
          paramString = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
          paramString.putExtra("GroupId", paramNotifyData.jdField_c_of_type_JavaLangString);
          paramString.putExtra("Type", 2);
          paramString.putExtra("sessionType", 3);
          paramString.putExtra("uinType", paramNotifyData.jdField_b_of_type_Int);
          paramString.putExtra("sessionType", paramNotifyData.jdField_c_of_type_Int);
          localObject1 = paramNotifyData.jdField_b_of_type_JavaLangString;
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131695698);
          localObject3 = paramNotifyData.jdField_a_of_type_AndroidGraphicsBitmap;
          break;
        case 62: 
          paramString = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
          paramString.putExtra("GroupId", paramNotifyData.jdField_c_of_type_JavaLangString);
          paramString.putExtra("Type", 2);
          paramString.putExtra("sessionType", 3);
          paramString.putExtra("uinType", paramNotifyData.jdField_b_of_type_Int);
          paramString.putExtra("sessionType", paramNotifyData.jdField_c_of_type_Int);
          localObject1 = paramNotifyData.jdField_b_of_type_JavaLangString;
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131695692);
          localObject3 = paramNotifyData.jdField_a_of_type_AndroidGraphicsBitmap;
          break;
        case 61: 
          localObject2 = QAVNotificationUtil.a(this.jdField_a_of_type_AndroidContentContext, paramNotifyData.jdField_a_of_type_JavaLangString);
          paramString = paramNotifyData.jdField_b_of_type_JavaLangString;
          if (TextUtils.isEmpty(paramNotifyData.d)) {
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131695668);
          } else {
            localObject1 = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131695669), new Object[] { a(paramNotifyData.d, 7) });
          }
          localObject3 = paramNotifyData.jdField_a_of_type_AndroidGraphicsBitmap;
        }
        break;
      case 57: 
        localObject2 = QAVNotificationUtil.b(this.jdField_a_of_type_AndroidContentContext, paramNotifyData.jdField_a_of_type_JavaLangString);
        paramString = paramNotifyData.jdField_b_of_type_JavaLangString;
        if (TextUtils.isEmpty(paramNotifyData.d)) {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131695668);
        } else {
          localObject1 = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131695669), new Object[] { a(paramNotifyData.d, 7) });
        }
        localObject3 = paramNotifyData.jdField_a_of_type_AndroidGraphicsBitmap;
        break;
      case 56: 
        localObject2 = QAVNotificationUtil.b(this.jdField_a_of_type_AndroidContentContext, paramNotifyData.jdField_a_of_type_JavaLangString);
        paramString = paramNotifyData.jdField_b_of_type_JavaLangString;
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131720251);
        localObject3 = paramNotifyData.jdField_a_of_type_AndroidGraphicsBitmap;
        break;
      case 55: 
        localObject2 = QAVNotificationUtil.b(this.jdField_a_of_type_AndroidContentContext, paramNotifyData.jdField_a_of_type_JavaLangString);
        paramString = paramNotifyData.jdField_b_of_type_JavaLangString;
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131690206);
        localObject3 = paramNotifyData.jdField_a_of_type_AndroidGraphicsBitmap;
      }
      break;
    case 48: 
      localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      ((Intent)localObject3).putExtra("isDoubleVideoMeeting", true);
      ((Intent)localObject3).putExtra("sessionType", paramNotifyData.jdField_c_of_type_Int);
      ((Intent)localObject3).putExtra("GroupId", paramNotifyData.jdField_c_of_type_JavaLangString);
      paramString = paramNotifyData.jdField_b_of_type_JavaLangString;
      if (paramNotifyData.jdField_c_of_type_Int == 4) {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131695698);
      } else {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131695692);
      }
      localObject2 = paramNotifyData.jdField_a_of_type_AndroidGraphicsBitmap;
      break;
    case 47: 
      paramString = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      paramString.putExtra("sessionType", paramNotifyData.jdField_c_of_type_Int);
      paramString.putExtra("GroupId", paramNotifyData.jdField_c_of_type_JavaLangString);
      localObject1 = paramNotifyData.jdField_b_of_type_JavaLangString;
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131695692);
      localObject3 = paramNotifyData.jdField_a_of_type_AndroidGraphicsBitmap;
      break;
    case 46: 
      paramString = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      paramString.putExtra("sessionType", paramNotifyData.jdField_c_of_type_Int);
      paramString.putExtra("GroupId", paramNotifyData.jdField_c_of_type_JavaLangString);
      localObject1 = paramNotifyData.jdField_b_of_type_JavaLangString;
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131695367);
      localObject3 = paramNotifyData.jdField_a_of_type_AndroidGraphicsBitmap;
      break;
    case 45: 
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, VideoInviteActivity.class);
      ((Intent)localObject2).addFlags(4194304);
      ((Intent)localObject2).addFlags(262144);
      paramString = paramNotifyData.jdField_b_of_type_JavaLangString;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131695697);
      localObject3 = paramNotifyData.jdField_a_of_type_AndroidGraphicsBitmap;
      break;
    case 44: 
      paramString = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      paramString.putExtra("GroupId", paramNotifyData.jdField_c_of_type_JavaLangString);
      paramString.putExtra("Type", 2);
      paramString.putExtra("sessionType", 3);
      paramString.putExtra("uinType", paramNotifyData.jdField_b_of_type_Int);
      paramString.putExtra("sessionType", paramNotifyData.jdField_c_of_type_Int);
      localObject1 = paramNotifyData.jdField_b_of_type_JavaLangString;
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131695559);
      localObject3 = paramNotifyData.jdField_a_of_type_AndroidGraphicsBitmap;
      localObject4 = localObject3;
      localObject3 = paramString;
      paramString = (String)localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
      break;
    case 43: 
      localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, GaInviteDialogActivity.class);
      ((Intent)localObject3).putExtra("sessionType", paramNotifyData.jdField_c_of_type_Int);
      ((Intent)localObject3).putExtra("uinType", paramNotifyData.jdField_b_of_type_Int);
      BaseGaInvite.a((Intent)localObject3, "updateNotification");
      localObject4 = paramNotifyData.jdField_b_of_type_JavaLangString;
      if (TextUtils.isEmpty(paramNotifyData.d)) {
        paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131695668);
      } else {
        paramString = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131695669), new Object[] { a(paramNotifyData.d, 7) });
      }
      localObject2 = paramNotifyData.jdField_a_of_type_AndroidGraphicsBitmap;
      localObject1 = paramString;
      paramString = (String)localObject4;
      break;
    case 42: 
      localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      ((Intent)localObject3).putExtra("sessionType", paramNotifyData.jdField_c_of_type_Int);
      ((Intent)localObject3).putExtra("uin", paramNotifyData.jdField_c_of_type_JavaLangString);
      paramString = paramNotifyData.jdField_b_of_type_JavaLangString;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131695698);
      localObject2 = paramNotifyData.jdField_a_of_type_AndroidGraphicsBitmap;
      break;
    case 41: 
      localObject3 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
      ((Intent)localObject3).putExtra("sessionType", paramNotifyData.jdField_c_of_type_Int);
      ((Intent)localObject3).putExtra("uin", paramNotifyData.jdField_c_of_type_JavaLangString);
      paramString = paramNotifyData.jdField_b_of_type_JavaLangString;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131695367);
      localObject2 = paramNotifyData.jdField_a_of_type_AndroidGraphicsBitmap;
      i = 2130842375;
      break;
    }
    Object localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, VideoInviteActivity.class);
    paramString = paramNotifyData.jdField_b_of_type_JavaLangString;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131720251);
    Object localObject3 = paramNotifyData.jdField_a_of_type_AndroidGraphicsBitmap;
    i = 2130842375;
    Object localObject4 = localObject2;
    localObject2 = localObject3;
    localObject3 = localObject4;
    j = SessionInfo.i;
    if (localObject3 != null)
    {
      ((Intent)localObject3).putExtra("MultiAVType", j);
      ((Intent)localObject3).putExtra("Fromwhere", "AVNotification");
      ((Intent)localObject3).addFlags(4194304);
      ((Intent)localObject3).addFlags(262144);
      ((Intent)localObject3).putExtra("param_notifyid", 235);
      ((Intent)localObject3).putExtra("fullscreen", paramBoolean3);
      if ((paramNotifyData.jdField_a_of_type_Int != 40) && (paramNotifyData.jdField_a_of_type_Int != 45) && (paramNotifyData.jdField_a_of_type_Int != 43)) {
        ((Intent)localObject3).addFlags(268435456);
      }
      localObject4 = PendingIntent.getActivity(this.jdField_a_of_type_AndroidContentContext, 0, (Intent)localObject3, 134217728);
    }
    else
    {
      localObject4 = null;
    }
    String str = paramString;
    if (j == 2) {
      str = paramString.replace(this.jdField_a_of_type_AndroidContentContext.getString(2131719735), this.jdField_a_of_type_AndroidContentContext.getString(2131719736));
    }
    if (j == 2) {
      paramString = ((String)localObject1).replace(this.jdField_a_of_type_AndroidContentContext.getString(2131719735), this.jdField_a_of_type_AndroidContentContext.getString(2131719736));
    } else {
      paramString = (String)localObject1;
    }
    localObject3 = a(paramNotifyData, (Intent)localObject3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(300);
      localStringBuilder.append("updateNotification title: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", state: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", id: ");
      localStringBuilder.append(paramNotifyData.jdField_c_of_type_JavaLangString);
      localStringBuilder.append(", sessionId: ");
      localStringBuilder.append(paramNotifyData.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", name: ");
      localStringBuilder.append(paramNotifyData.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(", type: ");
      localStringBuilder.append(paramNotifyData.jdField_a_of_type_Int);
      localStringBuilder.append(", avType: ");
      localStringBuilder.append(j);
      localStringBuilder.append(", actions: ");
      if (localObject3 == null) {
        localObject1 = "null";
      } else {
        localObject1 = Integer.valueOf(((ArrayList)localObject3).size());
      }
      localStringBuilder.append(localObject1);
      localStringBuilder.append(", time: ");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("QAVNotification", 2, localStringBuilder.toString());
    }
    try
    {
      paramString = a(paramBoolean1, paramBoolean3, str, paramString, i, (Bitmap)localObject2, (PendingIntent)localObject4, (List)localObject3);
      if (Build.VERSION.SDK_INT >= 26) {
        QQNotificationManager.addChannelIfNeed(paramString, "CHANNEL_ID_SHOW_BADGE");
      }
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(true, paramString);
      }
      if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager == null) {
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
      }
      this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("QAVNotification", 235, paramString);
      paramNotifyData.jdField_a_of_type_Boolean = false;
      QAVNotification.NotifyData.a(this.b, paramNotifyData);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification$NotifyData = paramNotifyData;
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Throwable paramNotifyData)
    {
      QLog.e("QAVNotification", 1, "updateNotification fail.", paramNotifyData);
    }
  }
  
  private boolean a(QAVNotification.NotifyData paramNotifyData)
  {
    boolean bool;
    if (((this.jdField_a_of_type_Int == 2) && (!a())) || ((a()) && (QAVNotification.NotifyData.a(this.b, paramNotifyData)))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNeedNotificationAnyWay, flag[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("], active[");
      localStringBuilder.append(a());
      localStringBuilder.append("], come[");
      localStringBuilder.append(paramNotifyData);
      localStringBuilder.append("], last[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("], need[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.i("QAVNotification", 4, localStringBuilder.toString());
    }
    return bool;
  }
  
  private boolean c(String paramString)
  {
    QAVNotification.NotifyData localNotifyData = this.jdField_a_of_type_ComTencentAvUtilsQAVNotification$NotifyData;
    if (localNotifyData != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return false;
      }
      if (TextUtils.equals(paramString, localNotifyData.jdField_a_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean d(String paramString)
  {
    paramString = SessionMgr.a().c(paramString);
    if (paramString != null) {
      return paramString.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface) ^ true;
    }
    return false;
  }
  
  private boolean e(String paramString)
  {
    paramString = SessionMgr.a().c(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isSessionIdVisible sessionInfo.sessionStatus = ");
        localStringBuilder.append(paramString.jdField_c_of_type_Int);
        QLog.d("QAVNotification", 2, localStringBuilder.toString());
      }
      bool1 = bool2;
      if (paramString.jdField_c_of_type_Int != 3) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cancelNotificationEx mIsActive: ");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        QLog.d("QAVNotification", 2, localStringBuilder.toString(), new Throwable());
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
          this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("QAVNotification", 235);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(false, null);
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification$NotifyData = null;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilMap.clear();
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = null;
        this.jdField_a_of_type_AndroidAppNotification = null;
        this.jdField_a_of_type_AndroidWidgetRemoteViews = null;
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateFlag, flag[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i("QAVNotification", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(QAVNotification.NotifyData paramNotifyData)
  {
    if (paramNotifyData == null) {
      return;
    }
    SessionInfo localSessionInfo = SessionMgr.a().c(paramNotifyData.jdField_a_of_type_JavaLangString);
    if (localSessionInfo == null) {
      return;
    }
    int i = paramNotifyData.jdField_a_of_type_Int;
    if (localSessionInfo.y)
    {
      if (localSessionInfo.l()) {}
      for (;;)
      {
        i = 48;
        break;
        if (!localSessionInfo.k()) {
          break;
        }
        paramNotifyData.jdField_c_of_type_Int = localSessionInfo.d;
      }
    }
    if (localSessionInfo.p())
    {
      if (localSessionInfo.k()) {
        if (localSessionInfo.d == 3) {
          i = 62;
        } else {
          i = 63;
        }
      }
    }
    else if (localSessionInfo.j()) {
      if (localSessionInfo.d == 1) {
        i = 47;
      } else {
        i = 42;
      }
    }
    if (paramNotifyData.jdField_a_of_type_Int != i)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkAndUpdateNotifyData, pre[");
        localStringBuilder.append(paramNotifyData.jdField_a_of_type_Int);
        localStringBuilder.append("], cur[");
        localStringBuilder.append(i);
        localStringBuilder.append("], info[");
        localStringBuilder.append(localSessionInfo);
        localStringBuilder.append("]");
        QLog.i("QAVNotification", 2, localStringBuilder.toString());
      }
      paramNotifyData.jdField_a_of_type_Int = i;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cancelNotification mIsActive: ");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        localStringBuilder.append(", sessionId:");
        localStringBuilder.append(paramString);
        QLog.d("QAVNotification", 2, localStringBuilder.toString(), new Throwable());
      }
      if (c(paramString))
      {
        if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
          this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("QAVNotification", 235);
        }
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification$NotifyData = null;
        this.jdField_a_of_type_Boolean = false;
        QAVNotification.NotifyData.a(this.b, null);
        if (!this.jdField_a_of_type_JavaUtilMap.isEmpty())
        {
          paramString = this.jdField_a_of_type_JavaUtilMap.values().iterator();
          if (paramString.hasNext()) {
            a((QAVNotification.NotifyData)paramString.next(), true);
          }
        }
        else
        {
          a(0);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(false, null);
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      Object localObject3 = (QAVNotification.NotifyData)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
      Object localObject1 = localObject3;
      Object localObject2;
      if (localObject3 == null)
      {
        int i = this.jdField_a_of_type_Int;
        localObject1 = localObject3;
        if (i == 2) {
          try
          {
            localObject1 = a(paramString1, paramInt);
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            QLog.i("QAVNotification", 1, "updateNotification exception", localThrowable);
            localObject2 = localObject3;
          }
        }
      }
      boolean bool1 = e(paramString1);
      boolean bool2 = c(paramString1);
      boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().c();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("updateNotification, sessionId[");
        ((StringBuilder)localObject3).append(paramString1);
        ((StringBuilder)localObject3).append("], mIsActive[");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_Boolean);
        ((StringBuilder)localObject3).append("], SessionType[");
        ((StringBuilder)localObject3).append(paramInt);
        ((StringBuilder)localObject3).append("], isSessionIdVisible[");
        ((StringBuilder)localObject3).append(bool1);
        ((StringBuilder)localObject3).append("], isActiveSession[");
        ((StringBuilder)localObject3).append(bool2);
        ((StringBuilder)localObject3).append("], isGameMode[");
        ((StringBuilder)localObject3).append(bool3);
        ((StringBuilder)localObject3).append("], time[");
        ((StringBuilder)localObject3).append(paramString2);
        ((StringBuilder)localObject3).append("], data[");
        ((StringBuilder)localObject3).append(localObject2);
        ((StringBuilder)localObject3).append("]");
        QLog.w("QAVNotification", 2, ((StringBuilder)localObject3).toString());
      }
      if (bool3)
      {
        bool3 = a(localObject2);
        if (!bool3) {
          return;
        }
      }
      if ((bool1) && (localObject2 != null))
      {
        if (!bool2)
        {
          bool1 = a(localObject2);
          if (!bool1) {
            return;
          }
        }
        if (((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppNotification != null)) || (a(localObject2))) {
          a(localObject2, true, paramString2, false);
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      a(paramString1, paramString2, paramBitmap, paramString3, paramInt1, paramInt2, paramInt3, null);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    try
    {
      boolean bool1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().h();
      boolean bool2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().c();
      boolean bool3 = c(paramString1);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addNotification, sessionId[");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append("], name[");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append("], id[");
        ((StringBuilder)localObject).append(paramString3);
        ((StringBuilder)localObject).append("], type[");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("], uinType[");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append("], sessionType[");
        ((StringBuilder)localObject).append(paramInt3);
        ((StringBuilder)localObject).append("], isActiveSession[");
        ((StringBuilder)localObject).append(bool3);
        ((StringBuilder)localObject).append("], isBeInviting[");
        ((StringBuilder)localObject).append(bool1);
        ((StringBuilder)localObject).append("], isGameMode[");
        ((StringBuilder)localObject).append(bool2);
        ((StringBuilder)localObject).append("]");
        QLog.w("QAVNotification", 2, ((StringBuilder)localObject).toString());
      }
      if ((bool1) && (bool2)) {
        return;
      }
      if (!TextUtils.isEmpty(paramString1)) {
        if (bool3)
        {
          localObject = this.jdField_a_of_type_ComTencentAvUtilsQAVNotification$NotifyData;
          ((QAVNotification.NotifyData)localObject).jdField_a_of_type_JavaLangString = paramString1;
          ((QAVNotification.NotifyData)localObject).jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
          ((QAVNotification.NotifyData)localObject).jdField_a_of_type_Int = paramInt1;
          ((QAVNotification.NotifyData)localObject).jdField_c_of_type_JavaLangString = paramString3;
          ((QAVNotification.NotifyData)localObject).jdField_b_of_type_JavaLangString = paramString2;
          ((QAVNotification.NotifyData)localObject).jdField_b_of_type_Int = paramInt2;
          ((QAVNotification.NotifyData)localObject).jdField_c_of_type_Int = paramInt3;
          ((QAVNotification.NotifyData)localObject).d = paramString4;
          a((QAVNotification.NotifyData)localObject, false);
        }
        else
        {
          paramString2 = new QAVNotification.NotifyData(this, paramString1, paramString2, paramBitmap, paramString3, paramInt1, paramInt2, paramInt3, null);
          this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
          a(paramString2, true);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      boolean bool1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().c();
      boolean bool2 = c(paramString1);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addInviteNotification, sessionId[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("], name[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("], id[");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append("], type[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], uinType[");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("], sessionType[");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append("], isActiveSession[");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append("], isGameMode[");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("]");
      QLog.w("QAVNotification", 1, ((StringBuilder)localObject).toString());
      if (bool1) {
        return;
      }
      if (!TextUtils.isEmpty(paramString1)) {
        if (bool2)
        {
          localObject = this.jdField_a_of_type_ComTencentAvUtilsQAVNotification$NotifyData;
          ((QAVNotification.NotifyData)localObject).jdField_a_of_type_JavaLangString = paramString1;
          ((QAVNotification.NotifyData)localObject).jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
          ((QAVNotification.NotifyData)localObject).jdField_a_of_type_Int = paramInt1;
          ((QAVNotification.NotifyData)localObject).jdField_c_of_type_JavaLangString = paramString3;
          ((QAVNotification.NotifyData)localObject).jdField_b_of_type_Int = paramInt2;
          ((QAVNotification.NotifyData)localObject).jdField_c_of_type_Int = paramInt3;
          ((QAVNotification.NotifyData)localObject).jdField_b_of_type_JavaLangString = paramString2;
          ((QAVNotification.NotifyData)localObject).d = null;
          if (paramBoolean) {
            a((QAVNotification.NotifyData)localObject, true, null, true);
          } else {
            a((QAVNotification.NotifyData)localObject, false, null, true);
          }
        }
        else
        {
          paramString2 = new QAVNotification.NotifyData(this, paramString1, paramString2, paramBitmap, paramString3, paramInt1, paramInt2, paramInt3, null);
          this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
          a(paramString2, true, null, true);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    for (;;)
    {
      boolean bool2;
      try
      {
        boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().c();
        boolean bool4 = c(paramString1);
        bool1 = true;
        QLog.d("QAVNotification", 1, String.format("addFullScreenInviteNotification isGameMode=%s isActiveSession=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4) }));
        bool2 = bool3 ^ true;
        if ((!bool2) && (AVUtil.b()))
        {
          Object localObject;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("addFullScreenInviteNotification needNotify[");
            ((StringBuilder)localObject).append(bool1);
            ((StringBuilder)localObject).append("], isGameMode[");
            ((StringBuilder)localObject).append(bool3);
            ((StringBuilder)localObject).append("], isUseCompatMode[");
            ((StringBuilder)localObject).append(AVUtil.b());
            ((StringBuilder)localObject).append("]");
            QLog.i("QAVNotification", 2, ((StringBuilder)localObject).toString());
          }
          if ((bool1) && (!TextUtils.isEmpty(paramString1))) {
            if (bool4)
            {
              localObject = this.jdField_a_of_type_ComTencentAvUtilsQAVNotification$NotifyData;
              ((QAVNotification.NotifyData)localObject).jdField_a_of_type_JavaLangString = paramString1;
              ((QAVNotification.NotifyData)localObject).jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
              ((QAVNotification.NotifyData)localObject).jdField_a_of_type_Int = paramInt1;
              ((QAVNotification.NotifyData)localObject).jdField_c_of_type_JavaLangString = paramString3;
              ((QAVNotification.NotifyData)localObject).jdField_b_of_type_Int = paramInt2;
              ((QAVNotification.NotifyData)localObject).jdField_c_of_type_Int = paramInt3;
              ((QAVNotification.NotifyData)localObject).jdField_b_of_type_JavaLangString = paramString2;
              ((QAVNotification.NotifyData)localObject).d = paramString4;
              if (paramBoolean) {
                a((QAVNotification.NotifyData)localObject, true, null, true, true);
              } else {
                a((QAVNotification.NotifyData)localObject, false, null, true, true);
              }
            }
            else
            {
              paramString2 = new QAVNotification.NotifyData(this, paramString1, paramString2, paramBitmap, paramString3, paramInt1, paramInt2, paramInt3, paramString4);
              this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
              a(paramString2, true, null, true, true);
            }
          }
          return;
        }
      }
      finally {}
      boolean bool1 = bool2;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hideNotification mIsActive: ");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        localStringBuilder.append(", sessionId:");
        localStringBuilder.append(paramString);
        QLog.d("QAVNotification", 2, localStringBuilder.toString());
      }
      if (c(paramString))
      {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification$NotifyData.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
          this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("QAVNotification", 235);
        }
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification$NotifyData = null;
        this.jdField_a_of_type_Boolean = false;
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public boolean b(String paramString)
  {
    try
    {
      QAVNotification.NotifyData localNotifyData = (QAVNotification.NotifyData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reshowNotification, sessionId[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], mIsActive[");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        localStringBuilder.append("], data[");
        localStringBuilder.append(localNotifyData);
        localStringBuilder.append("]");
        QLog.w("QAVNotification", 1, localStringBuilder.toString());
      }
      if ((localNotifyData != null) && (localNotifyData.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
      {
        a(localNotifyData, true);
        return true;
      }
      return false;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.QAVNotification
 * JD-Core Version:    0.7.0.1
 */