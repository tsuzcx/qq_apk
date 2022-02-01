package com.tencent.mobileqq.ark.api.module;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.tencent.ark.ark.Application;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.ArkCommonUtil;
import com.tencent.mobileqq.ark.module.ArkAppModuleBase;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

public abstract class ArkAppQQModuleBase
  extends ArkAppModuleBase
{
  protected ArkAppQQModuleBase(ark.Application paramApplication, int paramInt)
  {
    super(paramApplication, paramInt);
  }
  
  public static Activity a()
  {
    Object localObject = ArkAppModuleBase.b();
    if (localObject != null) {
      return localObject;
    }
    if (MobileQQ.sProcessId == 2)
    {
      localObject = BaseApplicationImpl.getApplication().getResumeActivity();
      if (localObject != null) {
        return (Activity)((WeakReference)localObject).get();
      }
    }
    return null;
  }
  
  public static SessionInfo a()
  {
    Object localObject2 = a();
    boolean bool = localObject2 instanceof BaseActivity;
    SessionInfo localSessionInfo = null;
    Object localObject1 = localSessionInfo;
    if (bool)
    {
      localObject2 = (BaseActivity)localObject2;
      localObject1 = (ChatFragment)((BaseActivity)localObject2).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject1 != null)
      {
        localObject2 = ((ChatFragment)localObject1).a();
        localObject1 = localSessionInfo;
        if (localObject2 != null)
        {
          localSessionInfo = ((BaseChatPie)localObject2).a();
          localObject1 = localSessionInfo;
          if (QLog.isColorLevel())
          {
            QLog.d("ArkApp.ArkAppModuleBase", 2, new Object[] { "multiAio.getTopChatSessionInfo form baseChatPie=", a(localSessionInfo) });
            return localSessionInfo;
          }
        }
      }
      else
      {
        localObject1 = localSessionInfo;
        if ((localObject2 instanceof MiniChatActivity))
        {
          localObject2 = ((MiniChatActivity)localObject2).a();
          localObject1 = localSessionInfo;
          if ((localObject2 instanceof MiniChatFragment))
          {
            localSessionInfo = ((MiniChatFragment)localObject2).a();
            localObject1 = localSessionInfo;
            if (QLog.isColorLevel())
            {
              QLog.d("ArkApp.ArkAppModuleBase", 2, new Object[] { "multiAio.getTopChatSessionInfo form miniChatPie=", a(localSessionInfo) });
              localObject1 = localSessionInfo;
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  protected static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static String a(SessionInfo paramSessionInfo)
  {
    return ArkCommonUtil.a(paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModuleBase
 * JD-Core Version:    0.7.0.1
 */