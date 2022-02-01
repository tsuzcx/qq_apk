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
import mqq.util.LogUtil;

public class QAVNotification
{
  static QAVNotification l;
  Notification a = null;
  QQNotificationManager b = null;
  NotificationStyleDiscover c;
  RemoteViews d = null;
  VideoAppInterface e = null;
  Context f = null;
  boolean g = false;
  QAVNotification.NotifyData h = null;
  Map<String, QAVNotification.NotifyData> i = new LinkedHashMap();
  final QAVNotification.NotifyData j = new QAVNotification.NotifyData(this, null);
  int k = 0;
  
  private QAVNotification(VideoAppInterface paramVideoAppInterface)
  {
    this.e = paramVideoAppInterface;
    if (this.f == null) {
      this.f = this.e.getApplication().getApplicationContext();
    }
    this.c = new NotificationStyleDiscover(this.f);
  }
  
  private Notification a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, int paramInt, Bitmap paramBitmap, PendingIntent paramPendingIntent, List<QAVNotification.NotificationAction> paramList)
  {
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(this.f);
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
        localBuilder.addAction(paramString2.a, paramString2.b, paramString2.c);
      }
    }
    if (paramBoolean2)
    {
      localBuilder.setPriority(2);
      localBuilder.setFullScreenIntent(paramPendingIntent, true);
      localBuilder.setVibrate(TraeHelper.p);
    }
    else
    {
      localBuilder.setPriority(0);
      localBuilder.setFullScreenIntent(null, false);
      localBuilder.setVibrate(null);
    }
    this.a = localBuilder.build();
    paramString1 = this.a;
    paramString1.flags |= 0x2;
    paramString1 = this.a;
    paramString1.flags |= 0x20;
    if ((AVUtil.b()) && (paramBoolean2))
    {
      paramString1 = this.a;
      paramString1.flags &= 0xFFFFFFF7;
      paramString1 = this.a;
      paramString1.flags |= 0x4;
      paramString1 = this.a;
      paramString1.flags = (0x1 | paramString1.flags);
    }
    else
    {
      paramString1 = this.a;
      paramString1.flags |= 0x8;
      paramString1 = this.a;
      paramString1.flags &= 0xFFFFFFFB;
      paramString1 = this.a;
      paramString1.flags &= 0xFFFFFFFE;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      if (paramBoolean2)
      {
        paramString1 = this.a;
        paramString1.category = "call";
        paramString1.flags |= 0x80;
      }
      else
      {
        paramString1 = this.a;
        paramString1.category = null;
        paramString1.flags &= 0xFFFFFF7F;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("useDefaultStyle flags: ");
      paramString1.append(this.a.flags);
      QLog.i("QAVNotification", 2, paramString1.toString());
    }
    return this.a;
  }
  
  public static QAVNotification a(VideoAppInterface paramVideoAppInterface)
  {
    if ((l == null) && (paramVideoAppInterface != null)) {
      try
      {
        if (l == null) {
          l = new QAVNotification(paramVideoAppInterface);
        }
      }
      finally {}
    }
    return l;
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
      int m = paramNotifyData.f;
      if ((m != 40) && (m != 45) && (m != 61)) {
        switch (m)
        {
        default: 
          return null;
        }
      }
      localArrayList = new ArrayList(2);
      paramIntent = new Intent(paramIntent);
      paramIntent.setAction("com.tencent.qav.notify.accept");
      paramIntent.putExtra("session_id", paramNotifyData.a);
      localArrayList.add(new QAVNotification.NotificationAction(2130843120, HardCodeUtil.a(2131906694), PendingIntent.getActivity(this.f, 0, paramIntent, 134217728)));
      paramIntent = new Intent("com.tencent.qav.notify.refuse");
      paramIntent.putExtra("uin", this.e.getCurrentAccountUin());
      paramIntent.putExtra("session_id", paramNotifyData.a);
      paramIntent.putExtra("notify_type", paramNotifyData.f);
      paramIntent.putExtra("uinType", paramNotifyData.g);
      localArrayList.add(new QAVNotification.NotificationAction(2130843122, HardCodeUtil.a(2131906693), PendingIntent.getBroadcast(this.f, 0, paramIntent, 134217728)));
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
    boolean bool1 = f(paramNotifyData.a);
    boolean bool2 = e(paramNotifyData.a);
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
    paramBoolean2 = AVUtil.b(this.e.getCurrentAccountUin());
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateNotification avCallBtnState[");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ((StringBuilder)localObject1).append("]");
      QLog.w("QAVNotification", 2, ((StringBuilder)localObject1).toString());
    }
    if ((!paramBoolean2) && (TextUtils.isEmpty(paramString)) && (!b(paramNotifyData))) {
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
    if ((!paramBoolean2) && (TextUtils.isEmpty(paramString)) && (!b(paramNotifyData))) {
      return;
    }
    int n = paramNotifyData.f;
    int m = 2130843136;
    switch (n)
    {
    default: 
      switch (n)
      {
      default: 
        switch (n)
        {
        default: 
          localObject1 = "";
          localObject2 = null;
          m = 0;
          paramString = "";
          localObject3 = null;
          break;
        case 63: 
          paramString = new Intent(this.f, AVActivity.class);
          paramString.putExtra("GroupId", paramNotifyData.d);
          paramString.putExtra("Type", 2);
          paramString.putExtra("sessionType", 3);
          paramString.putExtra("uinType", paramNotifyData.g);
          paramString.putExtra("sessionType", paramNotifyData.h);
          localObject1 = paramNotifyData.b;
          localObject2 = this.f.getString(2131893457);
          localObject3 = paramNotifyData.c;
          break;
        case 62: 
          paramString = new Intent(this.f, AVActivity.class);
          paramString.putExtra("GroupId", paramNotifyData.d);
          paramString.putExtra("Type", 2);
          paramString.putExtra("sessionType", 3);
          paramString.putExtra("uinType", paramNotifyData.g);
          paramString.putExtra("sessionType", paramNotifyData.h);
          localObject1 = paramNotifyData.b;
          localObject2 = this.f.getString(2131893451);
          localObject3 = paramNotifyData.c;
          break;
        case 61: 
          localObject2 = QAVNotificationUtil.a(this.f, paramNotifyData.a);
          paramString = paramNotifyData.b;
          if (TextUtils.isEmpty(paramNotifyData.e)) {
            localObject1 = this.f.getString(2131893427);
          } else {
            localObject1 = String.format(this.f.getString(2131893428), new Object[] { a(paramNotifyData.e, 7) });
          }
          localObject3 = paramNotifyData.c;
        }
        break;
      case 57: 
        localObject2 = QAVNotificationUtil.b(this.f, paramNotifyData.a);
        paramString = paramNotifyData.b;
        if (TextUtils.isEmpty(paramNotifyData.e)) {
          localObject1 = this.f.getString(2131893427);
        } else {
          localObject1 = String.format(this.f.getString(2131893428), new Object[] { a(paramNotifyData.e, 7) });
        }
        localObject3 = paramNotifyData.c;
        break;
      case 56: 
        localObject2 = QAVNotificationUtil.b(this.f, paramNotifyData.a);
        paramString = paramNotifyData.b;
        localObject1 = this.f.getString(2131917886);
        localObject3 = paramNotifyData.c;
        break;
      case 55: 
        localObject2 = QAVNotificationUtil.b(this.f, paramNotifyData.a);
        paramString = paramNotifyData.b;
        localObject1 = this.f.getString(2131887106);
        localObject3 = paramNotifyData.c;
      }
      break;
    case 48: 
      localObject3 = new Intent(this.f, AVActivity.class);
      ((Intent)localObject3).putExtra("isDoubleVideoMeeting", true);
      ((Intent)localObject3).putExtra("sessionType", paramNotifyData.h);
      ((Intent)localObject3).putExtra("GroupId", paramNotifyData.d);
      paramString = paramNotifyData.b;
      if (paramNotifyData.h == 4) {
        localObject1 = this.f.getString(2131893457);
      } else {
        localObject1 = this.f.getString(2131893451);
      }
      localObject2 = paramNotifyData.c;
      break;
    case 47: 
      paramString = new Intent(this.f, AVActivity.class);
      paramString.putExtra("sessionType", paramNotifyData.h);
      paramString.putExtra("GroupId", paramNotifyData.d);
      localObject1 = paramNotifyData.b;
      localObject2 = this.f.getString(2131893451);
      localObject3 = paramNotifyData.c;
      break;
    case 46: 
      paramString = new Intent(this.f, AVActivity.class);
      paramString.putExtra("sessionType", paramNotifyData.h);
      paramString.putExtra("GroupId", paramNotifyData.d);
      localObject1 = paramNotifyData.b;
      localObject2 = this.f.getString(2131893108);
      localObject3 = paramNotifyData.c;
      break;
    case 45: 
      localObject2 = new Intent(this.f, VideoInviteActivity.class);
      ((Intent)localObject2).addFlags(4194304);
      ((Intent)localObject2).addFlags(262144);
      paramString = paramNotifyData.b;
      localObject1 = this.f.getString(2131893456);
      localObject3 = paramNotifyData.c;
      break;
    case 44: 
      paramString = new Intent(this.f, AVActivity.class);
      paramString.putExtra("GroupId", paramNotifyData.d);
      paramString.putExtra("Type", 2);
      paramString.putExtra("sessionType", 3);
      paramString.putExtra("uinType", paramNotifyData.g);
      paramString.putExtra("sessionType", paramNotifyData.h);
      localObject1 = paramNotifyData.b;
      localObject2 = this.f.getString(2131893318);
      localObject3 = paramNotifyData.c;
      localObject4 = localObject3;
      localObject3 = paramString;
      paramString = (String)localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
      break;
    case 43: 
      localObject3 = new Intent(this.f, GaInviteDialogActivity.class);
      ((Intent)localObject3).putExtra("sessionType", paramNotifyData.h);
      ((Intent)localObject3).putExtra("uinType", paramNotifyData.g);
      BaseGaInvite.a((Intent)localObject3, "updateNotification");
      localObject4 = paramNotifyData.b;
      if (TextUtils.isEmpty(paramNotifyData.e)) {
        paramString = this.f.getString(2131893427);
      } else {
        paramString = String.format(this.f.getString(2131893428), new Object[] { a(paramNotifyData.e, 7) });
      }
      localObject2 = paramNotifyData.c;
      localObject1 = paramString;
      paramString = (String)localObject4;
      break;
    case 42: 
      localObject3 = new Intent(this.f, AVActivity.class);
      ((Intent)localObject3).putExtra("sessionType", paramNotifyData.h);
      ((Intent)localObject3).putExtra("uin", paramNotifyData.d);
      paramString = paramNotifyData.b;
      localObject1 = this.f.getString(2131893457);
      localObject2 = paramNotifyData.c;
      break;
    case 41: 
      localObject3 = new Intent(this.f, AVActivity.class);
      ((Intent)localObject3).putExtra("sessionType", paramNotifyData.h);
      ((Intent)localObject3).putExtra("uin", paramNotifyData.d);
      paramString = paramNotifyData.b;
      localObject1 = this.f.getString(2131893108);
      localObject2 = paramNotifyData.c;
      m = 2130843321;
      break;
    }
    Object localObject2 = new Intent(this.f, VideoInviteActivity.class);
    paramString = paramNotifyData.b;
    Object localObject1 = this.f.getString(2131917886);
    Object localObject3 = paramNotifyData.c;
    m = 2130843321;
    Object localObject4 = localObject2;
    localObject2 = localObject3;
    localObject3 = localObject4;
    n = SessionInfo.n;
    if (localObject3 != null)
    {
      ((Intent)localObject3).putExtra("MultiAVType", n);
      ((Intent)localObject3).putExtra("Fromwhere", "AVNotification");
      ((Intent)localObject3).addFlags(4194304);
      ((Intent)localObject3).addFlags(262144);
      ((Intent)localObject3).putExtra("param_notifyid", 235);
      ((Intent)localObject3).putExtra("fullscreen", paramBoolean3);
      if ((paramNotifyData.f != 40) && (paramNotifyData.f != 45) && (paramNotifyData.f != 43)) {
        ((Intent)localObject3).addFlags(268435456);
      }
      localObject4 = PendingIntent.getActivity(this.f, 0, (Intent)localObject3, 134217728);
    }
    else
    {
      localObject4 = null;
    }
    String str = paramString;
    if (n == 2) {
      str = paramString.replace(this.f.getString(2131917338), this.f.getString(2131917339));
    }
    if (n == 2) {
      paramString = ((String)localObject1).replace(this.f.getString(2131917338), this.f.getString(2131917339));
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
      localStringBuilder.append(paramNotifyData.d);
      localStringBuilder.append(", sessionId: ");
      localStringBuilder.append(paramNotifyData.a);
      localStringBuilder.append(", name: ");
      localStringBuilder.append(paramNotifyData.b);
      localStringBuilder.append(", type: ");
      localStringBuilder.append(paramNotifyData.f);
      localStringBuilder.append(", avType: ");
      localStringBuilder.append(n);
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
      paramString = a(paramBoolean1, paramBoolean3, str, paramString, m, (Bitmap)localObject2, (PendingIntent)localObject4, (List)localObject3);
      if (Build.VERSION.SDK_INT >= 26) {
        QQNotificationManager.addChannelIfNeed(paramString, "CHANNEL_ID_SHOW_BADGE");
      }
      if (paramBoolean1) {
        this.e.a(true, paramString);
      }
      if (this.b == null) {
        this.b = QQNotificationManager.getInstance();
      }
      this.b.notify("QAVNotification", 235, paramString);
      paramNotifyData.i = false;
      QAVNotification.NotifyData.b(this.j, paramNotifyData);
      this.h = paramNotifyData;
      this.g = true;
      return;
    }
    catch (Throwable paramNotifyData)
    {
      QLog.e("QAVNotification", 1, "updateNotification fail.", paramNotifyData);
    }
  }
  
  private QAVNotification.NotifyData b(String paramString, int paramInt)
  {
    SessionInfo localSessionInfo = SessionMgr.a().d(paramString);
    Object localObject;
    if (localSessionInfo != null)
    {
      localObject = new QAVNotification.NotifyData(this, null);
      ((QAVNotification.NotifyData)localObject).a = paramString;
      ((QAVNotification.NotifyData)localObject).h = paramInt;
      if ((localSessionInfo.g != 1) && (localSessionInfo.g != 2))
      {
        String str;
        if (localSessionInfo.am)
        {
          str = String.valueOf(localSessionInfo.aN);
          ((QAVNotification.NotifyData)localObject).b = this.e.a(localSessionInfo.p, str, null);
          ((QAVNotification.NotifyData)localObject).c = this.e.a(localSessionInfo.p, str, null, true, true);
          ((QAVNotification.NotifyData)localObject).f = 48;
        }
        else
        {
          str = String.valueOf(localSessionInfo.aN);
          ((QAVNotification.NotifyData)localObject).b = this.e.a(localSessionInfo.p, str, null);
          ((QAVNotification.NotifyData)localObject).c = this.e.a(localSessionInfo.p, str, null, true, true);
          if (localSessionInfo.g == 3) {
            ((QAVNotification.NotifyData)localObject).f = 62;
          } else {
            ((QAVNotification.NotifyData)localObject).f = 63;
          }
        }
      }
      else
      {
        ((QAVNotification.NotifyData)localObject).b = this.e.a(localSessionInfo.p, localSessionInfo.s, localSessionInfo.u);
        ((QAVNotification.NotifyData)localObject).c = this.e.a(localSessionInfo.p, localSessionInfo.s, null, true, true);
        if (localSessionInfo.g == 1) {
          ((QAVNotification.NotifyData)localObject).f = 47;
        } else {
          ((QAVNotification.NotifyData)localObject).f = 42;
        }
      }
      this.i.put(paramString, localObject);
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
  
  private boolean b(QAVNotification.NotifyData paramNotifyData)
  {
    boolean bool;
    if (((this.k == 2) && (!a())) || ((a()) && (QAVNotification.NotifyData.a(this.j, paramNotifyData)))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNeedNotificationAnyWay, flag[");
      localStringBuilder.append(this.k);
      localStringBuilder.append("], active[");
      localStringBuilder.append(a());
      localStringBuilder.append("], come[");
      localStringBuilder.append(paramNotifyData);
      localStringBuilder.append("], last[");
      localStringBuilder.append(this.j);
      localStringBuilder.append("], need[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.i("QAVNotification", 4, localStringBuilder.toString());
    }
    return bool;
  }
  
  private boolean d(String paramString)
  {
    QAVNotification.NotifyData localNotifyData = this.h;
    if (localNotifyData != null)
    {
      if (!this.g) {
        return false;
      }
      if (TextUtils.equals(paramString, localNotifyData.a)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean e(String paramString)
  {
    paramString = SessionMgr.a().d(paramString);
    if (paramString != null) {
      return paramString.a(this.e) ^ true;
    }
    return false;
  }
  
  private boolean f(String paramString)
  {
    paramString = SessionMgr.a().d(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isSessionIdVisible sessionInfo.sessionStatus = ");
        localStringBuilder.append(paramString.e);
        QLog.d("QAVNotification", 2, localStringBuilder.toString());
      }
      bool1 = bool2;
      if (paramString.e != 3) {
        bool1 = true;
      }
    }
    return bool1;
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
    this.k = paramInt;
  }
  
  public void a(QAVNotification.NotifyData paramNotifyData)
  {
    if (paramNotifyData == null) {
      return;
    }
    SessionInfo localSessionInfo = SessionMgr.a().d(paramNotifyData.a);
    if (localSessionInfo == null) {
      return;
    }
    int m = paramNotifyData.f;
    if (localSessionInfo.am)
    {
      if (localSessionInfo.l()) {}
      for (;;)
      {
        m = 48;
        break;
        if (!localSessionInfo.k()) {
          break;
        }
        paramNotifyData.h = localSessionInfo.g;
      }
    }
    if (localSessionInfo.p())
    {
      if (localSessionInfo.k()) {
        if (localSessionInfo.g == 3) {
          m = 62;
        } else {
          m = 63;
        }
      }
    }
    else if (localSessionInfo.j()) {
      if (localSessionInfo.g == 1) {
        m = 47;
      } else {
        m = 42;
      }
    }
    if (paramNotifyData.f != m)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkAndUpdateNotifyData, pre[");
        localStringBuilder.append(paramNotifyData.f);
        localStringBuilder.append("], cur[");
        localStringBuilder.append(m);
        localStringBuilder.append("], info[");
        localStringBuilder.append(localSessionInfo);
        localStringBuilder.append("]");
        QLog.i("QAVNotification", 2, localStringBuilder.toString());
      }
      paramNotifyData.f = m;
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
        localStringBuilder.append(this.g);
        localStringBuilder.append(", sessionId:");
        localStringBuilder.append(paramString);
        QLog.d("QAVNotification", 2, localStringBuilder.toString(), new Throwable());
      }
      if (d(paramString))
      {
        if (this.b != null) {
          this.b.cancel("QAVNotification", 235);
        }
        this.i.remove(paramString);
        this.h = null;
        this.g = false;
        QAVNotification.NotifyData.b(this.j, null);
        if (!this.i.isEmpty())
        {
          paramString = this.i.values().iterator();
          if (paramString.hasNext()) {
            a((QAVNotification.NotifyData)paramString.next(), true);
          }
        }
        else
        {
          a(0);
          this.e.a(false, null);
        }
      }
      else
      {
        this.i.remove(paramString);
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      Object localObject3 = (QAVNotification.NotifyData)this.i.get(paramString1);
      Object localObject1 = localObject3;
      Object localObject2;
      if (localObject3 == null)
      {
        int m = this.k;
        localObject1 = localObject3;
        if (m == 2) {
          try
          {
            localObject1 = b(paramString1, paramInt);
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            QLog.i("QAVNotification", 1, "updateNotification exception", localThrowable);
            localObject2 = localObject3;
          }
        }
      }
      boolean bool1 = f(paramString1);
      boolean bool2 = d(paramString1);
      boolean bool3 = this.e.b().g();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("updateNotification, sessionId[");
        ((StringBuilder)localObject3).append(paramString1);
        ((StringBuilder)localObject3).append("], mIsActive[");
        ((StringBuilder)localObject3).append(this.g);
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
        bool3 = b(localObject2);
        if (!bool3) {
          return;
        }
      }
      if ((bool1) && (localObject2 != null))
      {
        if (!bool2)
        {
          bool1 = b(localObject2);
          if (!bool1) {
            return;
          }
        }
        if (((this.g) && (this.a != null)) || (b(localObject2))) {
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
      boolean bool1 = this.e.b().k().h();
      boolean bool2 = this.e.b().g();
      boolean bool3 = d(paramString1);
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
          localObject = this.h;
          ((QAVNotification.NotifyData)localObject).a = paramString1;
          ((QAVNotification.NotifyData)localObject).c = paramBitmap;
          ((QAVNotification.NotifyData)localObject).f = paramInt1;
          ((QAVNotification.NotifyData)localObject).d = paramString3;
          ((QAVNotification.NotifyData)localObject).b = paramString2;
          ((QAVNotification.NotifyData)localObject).g = paramInt2;
          ((QAVNotification.NotifyData)localObject).h = paramInt3;
          ((QAVNotification.NotifyData)localObject).e = paramString4;
          a((QAVNotification.NotifyData)localObject, false);
        }
        else
        {
          paramString2 = new QAVNotification.NotifyData(this, paramString1, paramString2, paramBitmap, paramString3, paramInt1, paramInt2, paramInt3, null);
          this.i.put(paramString1, paramString2);
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
      boolean bool1 = this.e.b().g();
      boolean bool2 = d(paramString1);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addInviteNotification, sessionId[");
      ((StringBuilder)localObject).append(LogUtil.getSafePrintUin(paramString1));
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
          localObject = this.h;
          ((QAVNotification.NotifyData)localObject).a = paramString1;
          ((QAVNotification.NotifyData)localObject).c = paramBitmap;
          ((QAVNotification.NotifyData)localObject).f = paramInt1;
          ((QAVNotification.NotifyData)localObject).d = paramString3;
          ((QAVNotification.NotifyData)localObject).g = paramInt2;
          ((QAVNotification.NotifyData)localObject).h = paramInt3;
          ((QAVNotification.NotifyData)localObject).b = paramString2;
          ((QAVNotification.NotifyData)localObject).e = null;
          if (paramBoolean) {
            a((QAVNotification.NotifyData)localObject, true, null, true);
          } else {
            a((QAVNotification.NotifyData)localObject, false, null, true);
          }
        }
        else
        {
          paramString2 = new QAVNotification.NotifyData(this, paramString1, paramString2, paramBitmap, paramString3, paramInt1, paramInt2, paramInt3, null);
          this.i.put(paramString1, paramString2);
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
        boolean bool3 = this.e.b().g();
        boolean bool4 = d(paramString1);
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
              localObject = this.h;
              ((QAVNotification.NotifyData)localObject).a = paramString1;
              ((QAVNotification.NotifyData)localObject).c = paramBitmap;
              ((QAVNotification.NotifyData)localObject).f = paramInt1;
              ((QAVNotification.NotifyData)localObject).d = paramString3;
              ((QAVNotification.NotifyData)localObject).g = paramInt2;
              ((QAVNotification.NotifyData)localObject).h = paramInt3;
              ((QAVNotification.NotifyData)localObject).b = paramString2;
              ((QAVNotification.NotifyData)localObject).e = paramString4;
              if (paramBoolean) {
                a((QAVNotification.NotifyData)localObject, true, null, true, true);
              } else {
                a((QAVNotification.NotifyData)localObject, false, null, true, true);
              }
            }
            else
            {
              paramString2 = new QAVNotification.NotifyData(this, paramString1, paramString2, paramBitmap, paramString3, paramInt1, paramInt2, paramInt3, paramString4);
              this.i.put(paramString1, paramString2);
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
    return this.g;
  }
  
  public void b()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cancelNotificationEx mIsActive: ");
        localStringBuilder.append(this.g);
        QLog.d("QAVNotification", 2, localStringBuilder.toString(), new Throwable());
      }
      if (this.g)
      {
        if (this.b != null) {
          this.b.cancel("QAVNotification", 235);
        }
        this.e.a(false, null);
        this.h = null;
        this.g = false;
        this.i.clear();
        this.b = null;
        this.a = null;
        this.d = null;
      }
      return;
    }
    finally {}
  }
  
  public boolean b(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hideNotification mIsActive: ");
        localStringBuilder.append(this.g);
        localStringBuilder.append(", sessionId:");
        localStringBuilder.append(paramString);
        QLog.d("QAVNotification", 2, localStringBuilder.toString());
      }
      if (d(paramString))
      {
        this.h.i = true;
        if (this.b != null) {
          this.b.cancel("QAVNotification", 235);
        }
        this.h = null;
        this.g = false;
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public boolean c(String paramString)
  {
    try
    {
      QAVNotification.NotifyData localNotifyData = (QAVNotification.NotifyData)this.i.get(paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reshowNotification, sessionId[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], mIsActive[");
        localStringBuilder.append(this.g);
        localStringBuilder.append("], data[");
        localStringBuilder.append(localNotifyData);
        localStringBuilder.append("]");
        QLog.w("QAVNotification", 1, localStringBuilder.toString());
      }
      if ((localNotifyData != null) && (localNotifyData.i) && (!this.g))
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