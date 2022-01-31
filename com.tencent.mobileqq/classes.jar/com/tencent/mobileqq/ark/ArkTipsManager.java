package com.tencent.mobileqq.ark;

import aare;
import aarf;
import aarg;
import aari;
import aarj;
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
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.tips.ArkTipsBar;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import mqq.os.MqqHandler;

public class ArkTipsManager
{
  private static volatile ArkTipsManager jdField_a_of_type_ComTencentMobileqqArkArkTipsManager;
  private long jdField_a_of_type_Long = -1L;
  private aarj jdField_a_of_type_Aarj;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new aare(this);
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private WeakReference b;
  private WeakReference c;
  
  public static ArkTipsManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArkArkTipsManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqArkArkTipsManager == null) {
        jdField_a_of_type_ComTencentMobileqqArkArkTipsManager = new ArkTipsManager();
      }
      return jdField_a_of_type_ComTencentMobileqqArkArkTipsManager;
    }
    finally {}
  }
  
  public static String a(MessageForArkApp paramMessageForArkApp)
  {
    if ((paramMessageForArkApp == null) || (paramMessageForArkApp.ark_app_message == null) || (TextUtils.isEmpty(paramMessageForArkApp.ark_app_message.appDesc))) {
      paramMessageForArkApp = "";
    }
    String str;
    do
    {
      return paramMessageForArkApp;
      str = paramMessageForArkApp.ark_app_message.appDesc;
      paramMessageForArkApp = str;
    } while (str.length() <= 4);
    return str.substring(0, 4);
  }
  
  private void a(Bitmap paramBitmap, Context paramContext)
  {
    if ((this.jdField_a_of_type_Aarj != null) && (paramContext != null))
    {
      paramBitmap = new BitmapDrawable(paramContext.getResources(), paramBitmap);
      if (this.jdField_a_of_type_Aarj.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        paramContext = (TipsBar)this.jdField_a_of_type_Aarj.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramContext != null) {
          paramContext.setTipsIcon(paramBitmap);
        }
      }
      if (this.jdField_a_of_type_Aarj.jdField_b_of_type_JavaLangRefWeakReference != null)
      {
        paramContext = (ArkTipsBar)this.jdField_a_of_type_Aarj.jdField_b_of_type_JavaLangRefWeakReference.get();
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
      if (paramMessageForArkApp.mExtendMsgArkAppList != null)
      {
        Iterator localIterator = paramMessageForArkApp.mExtendMsgArkAppList.iterator();
        while (localIterator.hasNext())
        {
          MessageForArkApp localMessageForArkApp = (MessageForArkApp)localIterator.next();
          if ((localMessageForArkApp != null) && (localMessageForArkApp.arkContainer != null)) {
            localMessageForArkApp.arkContainer.a();
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("ArkTipsManager", 2, "msg container has attached:" + paramMessageForArkApp.uniseq + ",c=" + paramMessageForArkApp.arkContainer);
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
      if (paramMessageForArkApp.mExtendMsgArkAppList != null)
      {
        Iterator localIterator = paramMessageForArkApp.mExtendMsgArkAppList.iterator();
        while (localIterator.hasNext())
        {
          MessageForArkApp localMessageForArkApp = (MessageForArkApp)localIterator.next();
          if ((localMessageForArkApp != null) && (localMessageForArkApp.arkContainer != null))
          {
            localMessageForArkApp.arkContainer.b();
            localMessageForArkApp.arkContainer.doOnEvent(2);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("ArkTipsManager", 2, "msg container has dettached:" + paramMessageForArkApp.uniseq + ",destroy:" + paramBoolean + ",c=" + paramMessageForArkApp.arkContainer);
      }
    }
  }
  
  private void a(String paramString)
  {
    boolean bool2 = true;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("showMainTip : ref null= :");
      if (this.c != null) {
        break label130;
      }
      bool1 = true;
      localObject = ((StringBuilder)localObject).append(bool1).append(", isHide=");
      if (paramString != null) {
        break label135;
      }
    }
    label130:
    label135:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("ArkTipsManager", 2, bool1);
      if (this.c != null)
      {
        localObject = (QQAppInterface)this.c.get();
        if (localObject != null)
        {
          localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
          Message localMessage = new Message();
          localMessage.what = 1052;
          localMessage.obj = paramString;
          ((MqqHandler)localObject).sendMessage(localMessage);
        }
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Aarj != null) && (this.jdField_a_of_type_Aarj.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Aarj.jdField_a_of_type_JavaLangString.equals(paramString1)) && (this.jdField_b_of_type_JavaLangRefWeakReference != null))
    {
      paramString1 = (BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if (paramString1 != null)
      {
        paramString1 = paramString1.a(paramString2, this.jdField_a_of_type_Aarj.jdField_a_of_type_Long);
        this.jdField_a_of_type_Aarj.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramString1);
      }
    }
  }
  
  private void d()
  {
    a(null);
  }
  
  public ArkAioContainerWrapper a()
  {
    if (this.jdField_a_of_type_Aarj == null) {
      return null;
    }
    return this.jdField_a_of_type_Aarj.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper;
  }
  
  public MessageForArkApp a()
  {
    if (this.jdField_a_of_type_Aarj != null) {
      return this.jdField_a_of_type_Aarj.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp;
    }
    return null;
  }
  
  public TipsBar a(Context paramContext)
  {
    TipsBar localTipsBar = new TipsBar(paramContext);
    aarj localaarj = this.jdField_a_of_type_Aarj;
    if ((localaarj != null) && (localaarj.jdField_b_of_type_JavaLangString != null))
    {
      localaarj.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localTipsBar);
      localTipsBar.setTipsText(localaarj.jdField_b_of_type_JavaLangString);
    }
    a(paramContext);
    return localTipsBar;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Aarj != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aarj.d)) && (this.c != null)) {
      ArkAppDataReport.i((QQAppInterface)this.c.get(), this.jdField_a_of_type_Aarj.d);
    }
  }
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("useq=").append(paramLong);
      if (this.jdField_a_of_type_Aarj != null) {
        break label66;
      }
    }
    label66:
    for (String str = "";; str = "<>" + this.jdField_a_of_type_Aarj.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper + "," + this.jdField_a_of_type_Aarj.jdField_b_of_type_Long)
    {
      QLog.d("ArkTipsManager", 2, str);
      ArkAppCenter.a().postToMainThread(new aari(this, paramLong));
      return;
    }
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_Aarj == null) || (paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    int i = this.jdField_a_of_type_Aarj.jdField_a_of_type_Int;
    String str1 = this.jdField_a_of_type_Aarj.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_Aarj.c;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("need_jump_to_msg", true);
    localBundle.putLong("searched_timeorseq", this.jdField_a_of_type_Aarj.jdField_a_of_type_Long);
    RecentUtil.a(paramActivity, paramQQAppInterface, str1, i, str2, false, localBundle);
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_Aarj == null) {
      return;
    }
    String str1 = this.jdField_a_of_type_Aarj.d;
    ArkLocalAppMgr localArkLocalAppMgr = ((ArkAppCenter)((QQAppInterface)this.c.get()).getManager(120)).a();
    String str2 = localArkLocalAppMgr.a(str1, null);
    if (str2 != null)
    {
      ArkAppCenter.a(str2, new aarf(this, paramContext));
      return;
    }
    localArkLocalAppMgr.a(str1, "0.0.0.1", null, new aarg(this, paramContext));
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    if (this.jdField_a_of_type_Aarj != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "onEnterAIO");
      }
      a(paramBaseChatPie.a(), this.jdField_a_of_type_Aarj.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void a(ArkAioContainerWrapper paramArkAioContainerWrapper, SessionInfo paramSessionInfo, MessageForArkApp paramMessageForArkApp, String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((paramSessionInfo == null) || (paramMessageForArkApp == null)) {}
    long l1;
    long l2;
    label92:
    String str1;
    Object localObject;
    boolean bool;
    do
    {
      return;
      if ((paramMessageForArkApp.istroop == 1) || (paramMessageForArkApp.istroop == 3000)) {}
      for (l1 = paramMessageForArkApp.shmsgseq;; l1 = paramMessageForArkApp.time)
      {
        l2 = paramMessageForArkApp.uniseq;
        if (l2 != this.jdField_a_of_type_Long) {
          break label92;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ArkTipsManager", 2, "showTip deleting:" + l2);
        return;
      }
      str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("showTip sessUin:").append(str1).append(",first Show ? ");
        if (this.jdField_a_of_type_Aarj != null) {
          break;
        }
        bool = true;
        QLog.i("ArkTipsManager", 2, bool + ", msg=" + paramString);
      }
    } while (str1 == null);
    String str2 = paramSessionInfo.d;
    this.c = new WeakReference(paramQQAppInterface);
    if (paramMessageForArkApp.ark_app_message != null)
    {
      localObject = paramMessageForArkApp.ark_app_message.appName;
      label207:
      if (this.jdField_a_of_type_Aarj != null) {
        break label364;
      }
      this.jdField_a_of_type_Aarj = new aarj(paramArkAioContainerWrapper, str1, l1, l2, str2, paramSessionInfo.jdField_a_of_type_Int, (String)localObject, paramMessageForArkApp);
    }
    label364:
    while ((this.jdField_a_of_type_Aarj.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper == paramArkAioContainerWrapper) && (l1 == this.jdField_a_of_type_Aarj.jdField_a_of_type_Long))
    {
      if (paramQQAppInterface != null) {
        paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ArkTipsManager", 2, "showTip view:" + paramArkAioContainerWrapper + "msgID ? " + l1);
      }
      a(paramMessageForArkApp);
      this.jdField_a_of_type_Aarj.jdField_b_of_type_JavaLangString = paramString;
      a(paramString);
      a(str1, paramString);
      if (paramMessageForArkApp.ark_app_message != null) {
        ArkAppDataReport.h(paramQQAppInterface, paramMessageForArkApp.ark_app_message.appName);
      }
      this.jdField_a_of_type_Boolean = true;
      return;
      bool = false;
      break;
      localObject = "";
      break label207;
    }
    if ((this.jdField_a_of_type_Aarj.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper != paramArkAioContainerWrapper) && (this.jdField_a_of_type_Aarj.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper != null))
    {
      if (str1.equals(this.jdField_a_of_type_Aarj.jdField_a_of_type_JavaLangString)) {
        break label462;
      }
      a(this.jdField_a_of_type_Aarj.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aarj.a(paramArkAioContainerWrapper, str1, l1, l2, str2, paramSessionInfo.jdField_a_of_type_Int, (String)localObject, paramMessageForArkApp);
      break;
      label462:
      a(this.jdField_a_of_type_Aarj.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp, false);
    }
  }
  
  public void a(ArkAppContainer paramArkAppContainer, SessionInfo paramSessionInfo, String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Aarj == null) || (paramString == null) || (paramArkAppContainer != this.jdField_a_of_type_Aarj.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper)) {
      break label29;
    }
    label29:
    while ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() == paramArkAppContainer)) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("updateCurrentTip : sessionInfo:");
      if (paramSessionInfo != null) {
        break label186;
      }
    }
    label186:
    for (String str = "";; str = paramSessionInfo.jdField_a_of_type_JavaLangString)
    {
      QLog.d("ArkTipsManager", 2, str + ",tar:" + this.jdField_a_of_type_Aarj.jdField_a_of_type_JavaLangString + ",c=" + paramArkAppContainer);
      this.jdField_a_of_type_Aarj.jdField_b_of_type_JavaLangString = paramString;
      a(paramString);
      if ((paramSessionInfo == null) || (paramSessionInfo.jdField_a_of_type_JavaLangString == null) || (!paramSessionInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Aarj.jdField_a_of_type_JavaLangString)) || (paramSessionInfo.jdField_a_of_type_Int != this.jdField_a_of_type_Aarj.jdField_a_of_type_Int)) {
        break;
      }
      a(this.jdField_a_of_type_Aarj.jdField_a_of_type_JavaLangString, paramString);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramQQAppInterface == null) {}
    while (paramQQAppInterface.isAppOnForeground(paramQQAppInterface.getApp())) {
      return;
    }
    QNotificationManager localQNotificationManager = new QNotificationManager(paramQQAppInterface.getApp());
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramQQAppInterface.getApp());
    localBuilder.setSmallIcon(2130839532).setWhen(System.currentTimeMillis()).setContentTitle(paramString1).setContentText(paramString2).setContentIntent(PendingIntent.getActivity(paramQQAppInterface.getApp(), 0, new Intent(), 0));
    paramQQAppInterface = localBuilder.build();
    paramQQAppInterface.flags = 16;
    localQNotificationManager.notify("ArkTipsManager", 211, paramQQAppInterface);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Aarj == null) {}
    while (this.jdField_a_of_type_Aarj.jdField_b_of_type_Long != paramLong) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("hideTips : mCurrentTip :");
      if (this.jdField_a_of_type_Aarj != null) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ArkTipsManager", 2, bool);
      if (this.jdField_a_of_type_Aarj != null)
      {
        if (this.c != null)
        {
          localObject = (QQAppInterface)this.c.get();
          if (localObject != null) {
            ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
          }
        }
        this.jdField_a_of_type_Aarj = null;
        if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
        {
          localObject = (BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get();
          if (localObject != null) {
            ((BaseChatPie)localObject).a(null, -1L);
          }
        }
        d();
        this.jdField_a_of_type_Boolean = false;
        this.c = null;
      }
      return;
    }
  }
  
  public void b(BaseChatPie paramBaseChatPie)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() == paramBaseChatPie))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "onExitAIO");
      }
      this.jdField_b_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aarj != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "onEnterConversation");
      }
      a(this.jdField_a_of_type_Aarj.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTipsManager
 * JD-Core Version:    0.7.0.1
 */