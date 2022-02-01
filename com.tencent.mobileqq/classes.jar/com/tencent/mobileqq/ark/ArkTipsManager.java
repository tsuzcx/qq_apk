package com.tencent.mobileqq.ark;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.helper.ArkHelper;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.tips.ArkTipsBar;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ArkInfoBannerProcessor;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ProcessUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import mqq.app.AppRuntime;

public class ArkTipsManager
{
  private static volatile ArkTipsManager a;
  private boolean b = false;
  private MessageObserver c = new ArkTipsManager.1(this);
  private long d = -1L;
  private WeakReference<ArkAioContainerWrapper> e = null;
  private ArkTipsManager.ArkTip f;
  private WeakReference<AIOContext> g;
  private WeakReference<QQAppInterface> h;
  
  public static String a(MessageForArkApp paramMessageForArkApp)
  {
    if ((paramMessageForArkApp != null) && (paramMessageForArkApp.ark_app_message != null) && (!TextUtils.isEmpty(paramMessageForArkApp.ark_app_message.appDesc)))
    {
      String str = paramMessageForArkApp.ark_app_message.appDesc;
      paramMessageForArkApp = str;
      if (str.length() > 4) {
        paramMessageForArkApp = str.substring(0, 4);
      }
      return paramMessageForArkApp;
    }
    return "";
  }
  
  private void a(Bitmap paramBitmap, Context paramContext)
  {
    if ((this.f != null) && (paramContext != null))
    {
      paramBitmap = new BitmapDrawable(paramContext.getResources(), paramBitmap);
      if (this.f.j != null)
      {
        paramContext = (TipsBar)this.f.j.get();
        if (paramContext != null) {
          paramContext.setTipsIcon(paramBitmap);
        }
        ReportController.a((AppRuntime)this.h.get(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 4, 0, "", "", "", "");
      }
      if (this.f.k != null)
      {
        paramContext = (ArkTipsBar)this.f.k.get();
        if (paramContext != null) {
          paramContext.a(paramBitmap);
        }
      }
    }
  }
  
  private void a(MessageForArkApp paramMessageForArkApp, boolean paramBoolean)
  {
    if (paramMessageForArkApp != null)
    {
      if (paramMessageForArkApp.arkContainer != null)
      {
        paramMessageForArkApp.arkContainer.b();
        if (paramBoolean) {
          paramMessageForArkApp.arkContainer.doOnEvent(2);
        }
      }
      Object localObject;
      if (paramMessageForArkApp.mExtendMsgArkAppList != null)
      {
        localObject = paramMessageForArkApp.mExtendMsgArkAppList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageForArkApp localMessageForArkApp = (MessageForArkApp)((Iterator)localObject).next();
          if ((localMessageForArkApp != null) && (localMessageForArkApp.arkContainer != null))
          {
            localMessageForArkApp.arkContainer.b();
            localMessageForArkApp.arkContainer.doOnEvent(2);
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("msg container has dettached:");
        ((StringBuilder)localObject).append(paramMessageForArkApp.uniseq);
        ((StringBuilder)localObject).append(",destroy:");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(",c=");
        ((StringBuilder)localObject).append(paramMessageForArkApp.arkContainer);
        QLog.i("ArkTipsManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void a(String paramString)
  {
    boolean bool1 = QLog.isColorLevel();
    int i = 2;
    if (bool1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showMainTip : ref null= :");
      WeakReference localWeakReference = this.h;
      boolean bool2 = true;
      if (localWeakReference == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(", isHide=");
      if (paramString == null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject).append(bool1);
      QLog.d("ArkTipsManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.h;
    if ((localObject != null) && ((QQAppInterface)((WeakReference)localObject).get() != null))
    {
      localObject = Message.obtain();
      ((Message)localObject).obj = paramString;
      paramString = BannerManager.a();
      int j = ArkInfoBannerProcessor.a;
      if (((Message)localObject).obj == null) {
        i = 0;
      }
      paramString.a(j, i, (Message)localObject);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    ArkTipsManager.ArkTip localArkTip = this.f;
    if ((localArkTip != null) && (localArkTip.b != null) && (this.f.b.equals(paramString1)))
    {
      paramString1 = this.g;
      if (paramString1 != null)
      {
        paramString1 = (AIOContext)paramString1.get();
        if (paramString1 != null)
        {
          paramString1 = ((ArkHelper)paramString1.a(110)).a(paramString2, this.f.c);
          this.f.k = new WeakReference(paramString1);
        }
      }
    }
  }
  
  public static ArkTipsManager b()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ArkTipsManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void b(MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp != null)
    {
      if (paramMessageForArkApp.arkContainer != null) {
        paramMessageForArkApp.arkContainer.a();
      }
      Object localObject;
      if (paramMessageForArkApp.mExtendMsgArkAppList != null)
      {
        localObject = paramMessageForArkApp.mExtendMsgArkAppList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageForArkApp localMessageForArkApp = (MessageForArkApp)((Iterator)localObject).next();
          if ((localMessageForArkApp != null) && (localMessageForArkApp.arkContainer != null)) {
            localMessageForArkApp.arkContainer.a();
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("msg container has attached:");
        ((StringBuilder)localObject).append(paramMessageForArkApp.uniseq);
        ((StringBuilder)localObject).append(",c=");
        ((StringBuilder)localObject).append(paramMessageForArkApp.arkContainer);
        QLog.i("ArkTipsManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void h()
  {
    a(null);
  }
  
  public MessageForArkApp a()
  {
    ArkTipsManager.ArkTip localArkTip = this.f;
    if (localArkTip != null) {
      return localArkTip.i;
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("useq=");
      localStringBuilder.append(paramLong);
      Object localObject;
      if (this.f == null)
      {
        localObject = "";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<>");
        ((StringBuilder)localObject).append(this.f.a);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(this.f.g);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.d("ArkTipsManager", 2, localStringBuilder.toString());
    }
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkTipsManager.4(this, paramLong));
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Object localObject = this.f;
    if ((localObject != null) && (paramActivity != null))
    {
      if (paramQQAppInterface == null) {
        return;
      }
      int i = ((ArkTipsManager.ArkTip)localObject).e;
      localObject = this.f.b;
      String str = this.f.f;
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("need_jump_to_msg", true);
      localBundle.putLong("searched_timeorseq", this.f.c);
      RecentUtil.a(paramActivity, paramQQAppInterface, (String)localObject, i, str, false, localBundle);
    }
  }
  
  public void a(Context paramContext)
  {
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    localObject = ((ArkTipsManager.ArkTip)localObject).h;
    String str = this.f.i.ark_app_message.appView;
    if (ArkAppMgr.getInstance().getAppPathFromLocal((String)localObject) != null)
    {
      ArkAppCacheMgr.getAppIcon((String)localObject, new ArkTipsManager.2(this, paramContext));
      return;
    }
    ArkAppMgr.getInstance().getAppPathByName((String)localObject, "0.0.0.1", new ArkTipsManager.3(this, (String)localObject, paramContext));
  }
  
  public void a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if (paramAppInterface == null) {
      return;
    }
    if (!ProcessUtil.a(paramAppInterface.getApp()))
    {
      QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
      NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramAppInterface.getApp());
      Intent localIntent = new Intent();
      localIntent.putExtra("param_notifyid", 239);
      localBuilder.setSmallIcon(2130842312).setWhen(System.currentTimeMillis()).setContentTitle(paramString1).setContentText(paramString2).setContentIntent(PendingIntent.getActivity(paramAppInterface.getApp(), 0, localIntent, 0));
      paramAppInterface = localBuilder.build();
      paramAppInterface.flags = 16;
      localQQNotificationManager.notify("ArkTipsManager", 239, paramAppInterface);
    }
  }
  
  public void a(AIOContext paramAIOContext)
  {
    this.g = new WeakReference(paramAIOContext);
    if (this.f != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "onEnterAIO");
      }
      a(paramAIOContext.O().b, this.f.d);
    }
  }
  
  public void a(ArkAioContainerWrapper paramArkAioContainerWrapper, SessionInfo paramSessionInfo, MessageForArkApp paramMessageForArkApp, String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramSessionInfo != null)
    {
      if (paramMessageForArkApp == null) {
        return;
      }
      long l1;
      if ((paramMessageForArkApp.istroop != 1) && (paramMessageForArkApp.istroop != 3000)) {
        l1 = paramMessageForArkApp.time;
      } else {
        l1 = paramMessageForArkApp.shmsgseq;
      }
      long l3 = paramMessageForArkApp.uniseq;
      if (l3 == this.d)
      {
        if (QLog.isColorLevel())
        {
          paramArkAioContainerWrapper = new StringBuilder();
          paramArkAioContainerWrapper.append("showTip deleting:");
          paramArkAioContainerWrapper.append(l3);
          QLog.i("ArkTipsManager", 2, paramArkAioContainerWrapper.toString());
        }
        return;
      }
      String str1 = paramSessionInfo.b;
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showTip sessUin:");
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append(",first Show ? ");
        boolean bool;
        if (this.f == null) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", msg=");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("ArkTipsManager", 2, ((StringBuilder)localObject).toString());
      }
      if (str1 == null) {
        return;
      }
      String str2 = paramSessionInfo.e;
      this.h = new WeakReference(paramQQAppInterface);
      if (paramMessageForArkApp.ark_app_message != null) {
        localObject = paramMessageForArkApp.ark_app_message.appName;
      } else {
        localObject = "";
      }
      ArkTipsManager.ArkTip localArkTip = this.f;
      if (localArkTip == null)
      {
        this.f = new ArkTipsManager.ArkTip(paramArkAioContainerWrapper, str1, l1, l3, str2, paramSessionInfo.a, (String)localObject, paramMessageForArkApp);
      }
      else
      {
        if (localArkTip.a == paramArkAioContainerWrapper)
        {
          long l4 = this.f.c;
          l2 = l1;
          if (l2 == l4)
          {
            l1 = l2;
            break label431;
          }
        }
        if ((this.f.a != paramArkAioContainerWrapper) && (this.f.a != null)) {
          if (!str1.equals(this.f.b)) {
            a(this.f.i, true);
          } else {
            a(this.f.i, false);
          }
        }
        localArkTip = this.f;
        int i = paramSessionInfo.a;
        long l2 = l1;
        localArkTip.a(paramArkAioContainerWrapper, str1, l1, l3, str2, i, (String)localObject, paramMessageForArkApp);
        l1 = l2;
      }
      label431:
      paramSessionInfo = paramQQAppInterface;
      if (paramSessionInfo != null) {
        paramSessionInfo.addObserver(this.c);
      }
      if (QLog.isColorLevel())
      {
        paramSessionInfo = new StringBuilder();
        paramSessionInfo.append("showTip view:");
        paramSessionInfo.append(paramArkAioContainerWrapper);
        paramSessionInfo.append("msgID ? ");
        paramSessionInfo.append(l1);
        QLog.i("ArkTipsManager", 2, paramSessionInfo.toString());
      }
      b(paramMessageForArkApp);
      this.f.d = paramString;
      a(str1, paramString);
      a(paramString);
      if (paramMessageForArkApp.ark_app_message != null) {
        ArkAppDataReport.a(paramQQAppInterface, paramMessageForArkApp.ark_app_message.appName, "AIOStatusBarShow", 0, 0, 0L, 0L, 0L, "", "");
      }
      this.b = true;
    }
  }
  
  public void a(ArkAppContainer paramArkAppContainer, SessionInfo paramSessionInfo, String paramString)
  {
    if (this.b)
    {
      Object localObject = this.f;
      if ((localObject != null) && (paramString != null))
      {
        if (paramArkAppContainer != ((ArkTipsManager.ArkTip)localObject).a) {
          return;
        }
        localObject = this.e;
        if ((localObject != null) && (((WeakReference)localObject).get() == paramArkAppContainer)) {
          return;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateCurrentTip : sessionInfo:");
          if (paramSessionInfo == null) {
            localObject = "";
          } else {
            localObject = paramSessionInfo.b;
          }
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(",tar:");
          localStringBuilder.append(this.f.b);
          localStringBuilder.append(",c=");
          localStringBuilder.append(paramArkAppContainer);
          QLog.d("ArkTipsManager", 2, localStringBuilder.toString());
        }
        this.f.d = paramString;
        a(paramString);
        if ((paramSessionInfo != null) && (paramSessionInfo.b != null) && (paramSessionInfo.b.equals(this.f.b)) && (paramSessionInfo.a == this.f.e)) {
          a(this.f.b, paramString);
        }
      }
    }
  }
  
  public TipsBar b(Context paramContext)
  {
    TipsBar localTipsBar = new TipsBar(paramContext);
    ArkTipsManager.ArkTip localArkTip = this.f;
    if ((localArkTip != null) && (localArkTip.d != null))
    {
      localArkTip.j = new WeakReference(localTipsBar);
      localTipsBar.setTipsText(localArkTip.d);
    }
    a(paramContext);
    return localTipsBar;
  }
  
  public void b(AIOContext paramAIOContext)
  {
    WeakReference localWeakReference = this.g;
    if ((localWeakReference != null) && (localWeakReference.get() == paramAIOContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "onExitAIO");
      }
      this.g = null;
    }
  }
  
  public boolean b(long paramLong)
  {
    ArkTipsManager.ArkTip localArkTip = this.f;
    boolean bool = false;
    if (localArkTip == null) {
      return false;
    }
    if (localArkTip.g == paramLong) {
      bool = true;
    }
    return bool;
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public void d()
  {
    Object localObject = this.f;
    if ((localObject != null) && (!TextUtils.isEmpty(((ArkTipsManager.ArkTip)localObject).h)))
    {
      localObject = this.h;
      if (localObject != null)
      {
        ArkAppDataReport.a((QQAppInterface)((WeakReference)localObject).get(), this.f.h, "AIOStatusBarClick", 0, 0, 0L, 0L, 0L, "", "");
        ReportController.a((AppRuntime)this.h.get(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 4, 0, "", "", "", "");
      }
    }
  }
  
  public void e()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideTips : mCurrentTip :");
      boolean bool;
      if (this.f == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("ArkTipsManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.f != null)
    {
      localObject = this.h;
      if (localObject != null)
      {
        localObject = (QQAppInterface)((WeakReference)localObject).get();
        if (localObject != null) {
          ((QQAppInterface)localObject).removeObserver(this.c);
        }
      }
      this.f = null;
      localObject = this.g;
      if (localObject != null)
      {
        localObject = (AIOContext)((WeakReference)localObject).get();
        if (localObject != null) {
          ((ArkHelper)((AIOContext)localObject).a(110)).a(null, -1L);
        }
      }
      h();
      this.b = false;
      this.h = null;
    }
  }
  
  public ArkAioContainerWrapper f()
  {
    ArkTipsManager.ArkTip localArkTip = this.f;
    if (localArkTip == null) {
      return null;
    }
    return localArkTip.a;
  }
  
  public void g()
  {
    if (this.f != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "onEnterConversation");
      }
      a(this.f.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTipsManager
 * JD-Core Version:    0.7.0.1
 */