package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.qqproxy.GdtQQReminderUtil;
import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderSwitchObserver.QQReminderSwitchListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class QQReminderAMSHelper
{
  static void a(AcsMsg paramAcsMsg)
  {
    if (!b(paramAcsMsg)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[QQNotify]QQReminderAMSHelper", 1, "call AMS report");
    }
    GdtQQReminderUtil.a(paramAcsMsg.msg_id, paramAcsMsg.mn_reserved);
  }
  
  public static void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[QQNotify]QQReminderAMSHelper", 1, "addQQReminderMsg is call");
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localAppRuntime instanceof QQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[QQNotify]QQReminderAMSHelper", 1, "changeQQReminderSwitch: QQAppInterface is null");
        }
        return;
      }
      ((IQQReminderDataService)localAppRuntime.getRuntimeService(IQQReminderDataService.class, "")).doNotifyByPush(b(paramBundle));
      return;
    }
    QIPCClientHelper.getInstance().callServer("QQNotifyIPCModule", "add_msg", paramBundle, null);
  }
  
  public static void a(WeakReference<QQReminderSwitchObserver.QQReminderSwitchListener> paramWeakReference)
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[QQNotify]QQReminderAMSHelper", 1, "changeQQReminderSwitch: QQAppInterface is null");
        }
        return;
      }
      if (a())
      {
        QQReminderSwitchObserver.QQReminderSwitchListener localQQReminderSwitchListener = (QQReminderSwitchObserver.QQReminderSwitchListener)paramWeakReference.get();
        if (localQQReminderSwitchListener != null)
        {
          localQQReminderSwitchListener.a(true);
          return;
        }
      }
      localObject = (ActivateFriendsManager)((AppRuntime)localObject).getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
      ((ActivateFriendsManager)localObject).a(paramWeakReference);
      ((ActivateFriendsManager)localObject).a(true, true);
      return;
    }
    QIPCClientHelper.getInstance().callServer("QQNotifyIPCModule", "switch", null, new QQReminderAMSHelper.IPCListenerWrapper(paramWeakReference));
  }
  
  static void a(WeakReference<Activity> paramWeakReference, AcsMsg paramAcsMsg, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[QQNotify]QQReminderAMSHelper", 1, "QQNotify AMS notify click");
    }
    GdtQQReminderUtil.a(paramWeakReference, paramAcsMsg.msg_id, paramAcsMsg.mn_reserved, paramString);
  }
  
  public static boolean a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[QQNotify]QQReminderAMSHelper", 1, "changeQQReminderSwitch: QQAppInterface is null");
      }
      return false;
    }
    return ((ActivateFriendsManager)localAppRuntime.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).a(true);
  }
  
  public static boolean a(String paramString)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      Object localObject2 = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pref_act_frd");
      localObject1 = (QQAppInterface)localObject1;
      localStringBuilder.append(((QQAppInterface)localObject1).getCurrentAccountUin());
      localObject2 = ((BaseApplicationImpl)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(((QQAppInterface)localObject1).getCurrentAccountUin());
      return ((SharedPreferences)localObject2).getBoolean(localStringBuilder.toString(), false);
    }
    return true;
  }
  
  private static AcsMsg b(Bundle paramBundle)
  {
    AcsMsg localAcsMsg = new AcsMsg();
    localAcsMsg.busi_id = paramBundle.getString("busi_id");
    localAcsMsg.msg_id = paramBundle.getString("msg_id");
    localAcsMsg.content = paramBundle.getString("content");
    localAcsMsg.btn_text = paramBundle.getString("btn_text");
    localAcsMsg.title = paramBundle.getString("title");
    localAcsMsg.mn_reserved = paramBundle.getString("mn_reserved");
    localAcsMsg.notice_time = paramBundle.getLong("notice_time");
    localAcsMsg.banner_type = paramBundle.getInt("banner_type");
    localAcsMsg.banner_url = paramBundle.getString("banner_url");
    return localAcsMsg;
  }
  
  public static boolean b(AcsMsg paramAcsMsg)
  {
    return (paramAcsMsg != null) && ("bf15cdd9f2aa2b578f3af4c3e433f077".equals(paramAcsMsg.busi_id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQReminderAMSHelper
 * JD-Core Version:    0.7.0.1
 */