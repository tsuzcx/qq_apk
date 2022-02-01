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
  private static volatile ArkTipsManager jdField_a_of_type_ComTencentMobileqqArkArkTipsManager;
  private long jdField_a_of_type_Long = -1L;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ArkTipsManager.1(this);
  private ArkTipsManager.ArkTip jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip;
  private WeakReference<ArkAioContainerWrapper> jdField_a_of_type_JavaLangRefWeakReference = null;
  private boolean jdField_a_of_type_Boolean = false;
  private WeakReference<AIOContext> b;
  private WeakReference<QQAppInterface> c;
  
  public static ArkTipsManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArkArkTipsManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqArkArkTipsManager == null) {
          jdField_a_of_type_ComTencentMobileqqArkArkTipsManager = new ArkTipsManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqArkArkTipsManager;
  }
  
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
    if ((this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip != null) && (paramContext != null))
    {
      paramBitmap = new BitmapDrawable(paramContext.getResources(), paramBitmap);
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        paramContext = (TipsBar)this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramContext != null) {
          paramContext.setTipsIcon(paramBitmap);
        }
        ReportController.a((AppRuntime)this.c.get(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 4, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_b_of_type_JavaLangRefWeakReference != null)
      {
        paramContext = (ArkTipsBar)this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_b_of_type_JavaLangRefWeakReference.get();
        if (paramContext != null) {
          paramContext.a(paramBitmap);
        }
      }
    }
  }
  
  private void a(MessageForArkApp paramMessageForArkApp)
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
      WeakReference localWeakReference = this.c;
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
    Object localObject = this.c;
    if ((localObject != null) && ((QQAppInterface)((WeakReference)localObject).get() != null))
    {
      localObject = Message.obtain();
      ((Message)localObject).obj = paramString;
      paramString = BannerManager.a();
      int j = ArkInfoBannerProcessor.jdField_a_of_type_Int;
      if (((Message)localObject).obj == null) {
        i = 0;
      }
      paramString.a(j, i, (Message)localObject);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    ArkTipsManager.ArkTip localArkTip = this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip;
    if ((localArkTip != null) && (localArkTip.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_JavaLangString.equals(paramString1)))
    {
      paramString1 = this.jdField_b_of_type_JavaLangRefWeakReference;
      if (paramString1 != null)
      {
        paramString1 = (AIOContext)paramString1.get();
        if (paramString1 != null)
        {
          paramString1 = ((ArkHelper)paramString1.a(110)).a(paramString2, this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_Long);
          this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramString1);
        }
      }
    }
  }
  
  private void d()
  {
    a(null);
  }
  
  public ArkAioContainerWrapper a()
  {
    ArkTipsManager.ArkTip localArkTip = this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip;
    if (localArkTip == null) {
      return null;
    }
    return localArkTip.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper;
  }
  
  public TipsBar a(Context paramContext)
  {
    TipsBar localTipsBar = new TipsBar(paramContext);
    ArkTipsManager.ArkTip localArkTip = this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip;
    if ((localArkTip != null) && (localArkTip.jdField_b_of_type_JavaLangString != null))
    {
      localArkTip.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localTipsBar);
      localTipsBar.setTipsText(localArkTip.jdField_b_of_type_JavaLangString);
    }
    a(paramContext);
    return localTipsBar;
  }
  
  public MessageForArkApp a()
  {
    ArkTipsManager.ArkTip localArkTip = this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip;
    if (localArkTip != null) {
      return localArkTip.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp;
    }
    return null;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip;
    if ((localObject != null) && (!TextUtils.isEmpty(((ArkTipsManager.ArkTip)localObject).d)))
    {
      localObject = this.c;
      if (localObject != null)
      {
        ArkAppDataReport.a((QQAppInterface)((WeakReference)localObject).get(), this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.d, "AIOStatusBarClick", 0, 0, 0L, 0L, 0L, "", "");
        ReportController.a((AppRuntime)this.c.get(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 4, 0, "", "", "", "");
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("useq=");
      localStringBuilder.append(paramLong);
      Object localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip == null)
      {
        localObject = "";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<>");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_b_of_type_Long);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.d("ArkTipsManager", 2, localStringBuilder.toString());
    }
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkTipsManager.4(this, paramLong));
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip;
    if ((localObject != null) && (paramActivity != null))
    {
      if (paramQQAppInterface == null) {
        return;
      }
      int i = ((ArkTipsManager.ArkTip)localObject).jdField_a_of_type_Int;
      localObject = this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_JavaLangString;
      String str = this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.c;
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("need_jump_to_msg", true);
      localBundle.putLong("searched_timeorseq", this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_Long);
      RecentUtil.a(paramActivity, paramQQAppInterface, (String)localObject, i, str, false, localBundle);
    }
  }
  
  public void a(Context paramContext)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip;
    if (localObject == null) {
      return;
    }
    localObject = ((ArkTipsManager.ArkTip)localObject).d;
    String str = this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.appView;
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
      localBuilder.setSmallIcon(2130841470).setWhen(System.currentTimeMillis()).setContentTitle(paramString1).setContentText(paramString2).setContentIntent(PendingIntent.getActivity(paramAppInterface.getApp(), 0, localIntent, 0));
      paramAppInterface = localBuilder.build();
      paramAppInterface.flags = 16;
      localQQNotificationManager.notify("ArkTipsManager", 239, paramAppInterface);
    }
  }
  
  public void a(AIOContext paramAIOContext)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramAIOContext);
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "onEnterAIO");
      }
      a(paramAIOContext.a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_b_of_type_JavaLangString);
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
      if (l3 == this.jdField_a_of_type_Long)
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
      String str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showTip sessUin:");
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append(",first Show ? ");
        boolean bool;
        if (this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip == null) {
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
      String str2 = paramSessionInfo.d;
      this.c = new WeakReference(paramQQAppInterface);
      if (paramMessageForArkApp.ark_app_message != null) {
        localObject = paramMessageForArkApp.ark_app_message.appName;
      } else {
        localObject = "";
      }
      ArkTipsManager.ArkTip localArkTip = this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip;
      if (localArkTip == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip = new ArkTipsManager.ArkTip(paramArkAioContainerWrapper, str1, l1, l3, str2, paramSessionInfo.jdField_a_of_type_Int, (String)localObject, paramMessageForArkApp);
      }
      else
      {
        if (localArkTip.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper == paramArkAioContainerWrapper)
        {
          long l4 = this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_Long;
          l2 = l1;
          if (l2 == l4)
          {
            l1 = l2;
            break label431;
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper != paramArkAioContainerWrapper) && (this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper != null)) {
          if (!str1.equals(this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_JavaLangString)) {
            a(this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp, true);
          } else {
            a(this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp, false);
          }
        }
        localArkTip = this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip;
        int i = paramSessionInfo.jdField_a_of_type_Int;
        long l2 = l1;
        localArkTip.a(paramArkAioContainerWrapper, str1, l1, l3, str2, i, (String)localObject, paramMessageForArkApp);
        l1 = l2;
      }
      label431:
      paramSessionInfo = paramQQAppInterface;
      if (paramSessionInfo != null) {
        paramSessionInfo.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
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
      a(paramMessageForArkApp);
      this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_b_of_type_JavaLangString = paramString;
      a(str1, paramString);
      a(paramString);
      if (paramMessageForArkApp.ark_app_message != null) {
        ArkAppDataReport.a(paramQQAppInterface, paramMessageForArkApp.ark_app_message.appName, "AIOStatusBarShow", 0, 0, 0L, 0L, 0L, "", "");
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(ArkAppContainer paramArkAppContainer, SessionInfo paramSessionInfo, String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip;
      if ((localObject != null) && (paramString != null))
      {
        if (paramArkAppContainer != ((ArkTipsManager.ArkTip)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper) {
          return;
        }
        localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
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
            localObject = paramSessionInfo.jdField_a_of_type_JavaLangString;
          }
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(",tar:");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(",c=");
          localStringBuilder.append(paramArkAppContainer);
          QLog.d("ArkTipsManager", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_b_of_type_JavaLangString = paramString;
        a(paramString);
        if ((paramSessionInfo != null) && (paramSessionInfo.jdField_a_of_type_JavaLangString != null) && (paramSessionInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_JavaLangString)) && (paramSessionInfo.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_Int)) {
          a(this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_a_of_type_JavaLangString, paramString);
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(long paramLong)
  {
    ArkTipsManager.ArkTip localArkTip = this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip;
    boolean bool = false;
    if (localArkTip == null) {
      return false;
    }
    if (localArkTip.jdField_b_of_type_Long == paramLong) {
      bool = true;
    }
    return bool;
  }
  
  public void b()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideTips : mCurrentTip :");
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("ArkTipsManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip != null)
    {
      localObject = this.c;
      if (localObject != null)
      {
        localObject = (QQAppInterface)((WeakReference)localObject).get();
        if (localObject != null) {
          ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip = null;
      localObject = this.jdField_b_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        localObject = (AIOContext)((WeakReference)localObject).get();
        if (localObject != null) {
          ((ArkHelper)((AIOContext)localObject).a(110)).a(null, -1L);
        }
      }
      d();
      this.jdField_a_of_type_Boolean = false;
      this.c = null;
    }
  }
  
  public void b(AIOContext paramAIOContext)
  {
    WeakReference localWeakReference = this.jdField_b_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() == paramAIOContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "onExitAIO");
      }
      this.jdField_b_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "onEnterConversation");
      }
      a(this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager$ArkTip.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTipsManager
 * JD-Core Version:    0.7.0.1
 */