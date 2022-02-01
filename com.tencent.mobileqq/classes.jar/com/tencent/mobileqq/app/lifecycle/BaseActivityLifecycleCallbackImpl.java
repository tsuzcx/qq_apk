package com.tencent.mobileqq.app.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.qfileJumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.identity.IAccountApi;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.managers.MsgPushReportHelper;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.crash.tools.ActivityLifeCycleInfoRecordHelper;
import com.tencent.qqperf.opt.clearmemory.MemoryConfigs;
import com.tencent.util.QQKRPUtil;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qlink.QlinkBridgeActivity;
import cooperation.qlink.QlinkShareJumpActivity;
import cooperation.qqfav.widget.QfavJumpActivity;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class BaseActivityLifecycleCallbackImpl
  implements BaseActivityLifecycleCallbacks
{
  private void a(QBaseActivity paramQBaseActivity)
  {
    String str = paramQBaseActivity.getCurrentAccountUinFromRuntime();
    ILoginRegisterApi localILoginRegisterApi = (ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class);
    if (((!QBaseActivity.mAppForground) || (("com.tencent.mobileqq".equals(BaseApplicationImpl.processName)) && (!QBaseActivity.isUnLockSuccess))) && (paramQBaseActivity.getCanLock()) && (str != null) && (GesturePWDUtils.getJumpLock(paramQBaseActivity, str)) && (!(paramQBaseActivity instanceof GesturePWDUnlockActivity)) && (!(paramQBaseActivity instanceof UserguideActivity)) && (!(paramQBaseActivity instanceof JumpActivity)) && (!(paramQBaseActivity instanceof qfileJumpActivity)) && (!(paramQBaseActivity instanceof QfavJumpActivity)) && (!localILoginRegisterApi.getLoginActivityClass().isInstance(paramQBaseActivity)) && (!(paramQBaseActivity instanceof QlinkBridgeActivity)) && (!(paramQBaseActivity instanceof QlinkShareJumpActivity))) {
      paramQBaseActivity.startUnlockActivity();
    } else if ((!QBaseActivity.mAppForground) && (paramQBaseActivity.isCanLock())) {
      paramQBaseActivity.checkUnlockForSpecial();
    } else if ((!QBaseActivity.mAppForground) && (!paramQBaseActivity.isCanLock())) {
      QBaseActivity.isUnLockSuccess = true;
    }
    if (((!QBaseActivity.mAppForground) || (((IAccountApi)QRoute.api(IAccountApi.class)).isIdentityFirstInit())) && (!TextUtils.isEmpty(str))) {
      ((IAccountApi)QRoute.api(IAccountApi.class)).onForegroundSwitch();
    }
    if ((!QBaseActivity.mAppForground) && (!(paramQBaseActivity instanceof JumpActivity)))
    {
      QBaseActivity.mAppForground = true;
      GesturePWDUtils.setAppForground(paramQBaseActivity, QBaseActivity.mAppForground);
    }
    paramQBaseActivity.setStopFlag(0);
    paramQBaseActivity.setCanLock(true);
  }
  
  private void b(QBaseActivity paramQBaseActivity)
  {
    Object localObject = BridgeHelper.a(paramQBaseActivity, paramQBaseActivity.getCurrentAccountUinFromRuntime()).a("buscard_registerNFC");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || ("true".equals(localObject)))
    {
      localObject = paramQBaseActivity.getNFCResumeRunnable();
      if (localObject == null) {}
    }
    try
    {
      ThreadManager.getSubThreadHandler().removeCallbacks((Runnable)localObject);
      localObject = new BaseActivityLifecycleCallbackImpl.2(this, paramQBaseActivity);
      paramQBaseActivity.setNFCResumeRunnable((Runnable)localObject);
      ThreadManager.getSubThreadHandler().post((Runnable)localObject);
      return;
    }
    catch (Throwable paramQBaseActivity)
    {
      label70:
      break label70;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("qqBaseActivity", 4, "registerNFCEvent failed");
    }
  }
  
  private void c(QBaseActivity paramQBaseActivity)
  {
    Object localObject = BridgeHelper.a(paramQBaseActivity, paramQBaseActivity.getCurrentAccountUinFromRuntime()).a("buscard_registerNFC");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || ("true".equals(localObject))) {}
    try
    {
      localObject = paramQBaseActivity.getNFCResumeRunnable();
      if (localObject != null) {
        ThreadManager.getSubThreadHandler().removeCallbacks((Runnable)localObject);
      }
      BaseActivityLifecycleCallbackImpl.3 local3 = new BaseActivityLifecycleCallbackImpl.3(this, paramQBaseActivity);
      paramQBaseActivity.setNFCResumeRunnable((Runnable)localObject);
      ThreadManager.getSubThreadHandler().post(local3);
      return;
    }
    catch (Throwable paramQBaseActivity)
    {
      label70:
      break label70;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("qqBaseActivity", 4, "disableNFCEvent failed");
    }
  }
  
  private void d(QBaseActivity paramQBaseActivity) {}
  
  private void e(QBaseActivity paramQBaseActivity) {}
  
  public void doOnActivityCreate(Activity paramActivity, Bundle paramBundle)
  {
    ActivityLifeCycleInfoRecordHelper.a(paramActivity);
    if ((paramActivity instanceof BaseActivity)) {
      ((BaseActivity)paramActivity).updateAppRuntime();
    }
  }
  
  public void doOnActivityDestroyed(Activity paramActivity)
  {
    if ((paramActivity instanceof QBaseActivity))
    {
      ActivityLifeCycleInfoRecordHelper.d(paramActivity);
      ((IAccountApi)QRoute.api(IAccountApi.class)).onActivityDestroy(paramActivity);
      QBaseActivity localQBaseActivity = (QBaseActivity)paramActivity;
      AppRuntime localAppRuntime = localQBaseActivity.getAppRuntime();
      if ((localAppRuntime instanceof AppInterface)) {
        ((AppInterface)localAppRuntime).removeHandler(paramActivity.getClass());
      }
      if ((MagnifierSDK.a().a().a > 0.0F) && (GlobalImageCache.a != null)) {
        GlobalImageCache.a.releaseLargeCache();
      }
      e(localQBaseActivity);
    }
  }
  
  public void doOnActivityOnStart(Activity paramActivity)
  {
    MsgPushReportHelper.a(paramActivity.getIntent());
  }
  
  public void doOnActivityPause(Activity paramActivity)
  {
    if ((paramActivity instanceof QBaseActivity))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(256);
        localStringBuilder.append("[");
        localStringBuilder.append(paramActivity.hashCode());
        localStringBuilder.append("]");
        localStringBuilder.append(paramActivity.getClass().getSimpleName());
        localStringBuilder.append(" onPause HeapAlloc=");
        localStringBuilder.append(Runtime.getRuntime().totalMemory() / 1024L);
        localStringBuilder.append(" KB HeapFree=");
        localStringBuilder.append(Runtime.getRuntime().freeMemory() / 1024L);
        localStringBuilder.append(" KB");
        QLog.d("qqBaseActivity", 2, localStringBuilder.toString());
      }
      c((QBaseActivity)paramActivity);
    }
  }
  
  public void doOnActivityPostCreated(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramActivity instanceof QBaseActivity))
    {
      paramActivity = (QBaseActivity)paramActivity;
      paramBundle = paramActivity.getAppRuntime();
      if ((paramBundle instanceof QQAppInterface)) {
        QQKRPUtil.a((QQAppInterface)paramBundle, paramActivity);
      }
      d(paramActivity);
    }
  }
  
  public void doOnActivityPostPaused(Activity paramActivity) {}
  
  public void doOnActivityPostResumed(Activity paramActivity) {}
  
  public void doOnActivityPreCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void doOnActivityPrePaused(Activity paramActivity)
  {
    ActivityLifeCycleInfoRecordHelper.c(paramActivity);
  }
  
  public void doOnActivityPreResumed(Activity paramActivity)
  {
    ActivityLifeCycleInfoRecordHelper.b(paramActivity);
  }
  
  public void doOnActivityResume(Activity paramActivity)
  {
    if ((paramActivity instanceof QBaseActivity))
    {
      if (!((ISafeBlockApi)QRoute.api(ISafeBlockApi.class)).isBlockNotifyActivity(paramActivity)) {
        EquipmentLockImpl.a().a();
      }
      if (EquipmentLockImpl.a == true) {
        EquipmentLockImpl.a().b();
      }
      QBaseActivity.mAppForground = GesturePWDUtils.getAppForground(paramActivity);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(256);
        localStringBuilder.append("[");
        localStringBuilder.append(hashCode());
        localStringBuilder.append("]");
        localStringBuilder.append(paramActivity.getClass().getSimpleName());
        localStringBuilder.append(" onQResume .mAppForground = ");
        localStringBuilder.append(QBaseActivity.mAppForground);
        localStringBuilder.append(",mCanLock=");
        localStringBuilder.append(((QBaseActivity)paramActivity).getCanLock());
        localStringBuilder.append(" HeapAlloc=");
        localStringBuilder.append(Runtime.getRuntime().totalMemory() / 1024L);
        localStringBuilder.append(" KB HeapFree=");
        localStringBuilder.append(Runtime.getRuntime().freeMemory() / 1024L);
        localStringBuilder.append(" KB HeapMax=");
        localStringBuilder.append(Runtime.getRuntime().maxMemory() / 1024L);
        localStringBuilder.append(" KB");
        QLog.d("qqBaseActivity", 2, localStringBuilder.toString());
      }
      if (QBaseActivity.mAppBackgroundTime > 0L) {
        ViewExposeUtil.a(SystemClock.elapsedRealtime() - QBaseActivity.mAppBackgroundTime);
      }
      QBaseActivity.mAppBackgroundTime = 0L;
      paramActivity = (QBaseActivity)paramActivity;
      a(paramActivity);
      if (GuardManager.a != null) {
        GuardManager.a.b(1, paramActivity.getPreProcess());
      }
      b(paramActivity);
    }
  }
  
  public void doOnActivityStopped(Activity paramActivity)
  {
    if ((paramActivity instanceof QBaseActivity))
    {
      paramActivity = (QBaseActivity)paramActivity;
      QBaseActivity.mAppForground = GesturePWDUtils.isAppOnForegroundByTasks(paramActivity, 2);
      if (!QBaseActivity.mAppForground)
      {
        GesturePWDUtils.setAppForground(paramActivity, QBaseActivity.mAppForground);
        QBaseActivity.isUnLockSuccess = false;
        QBaseActivity.mAppBackgroundTime = SystemClock.elapsedRealtime();
      }
    }
  }
  
  public void doOnNewIntent(Activity paramActivity, Intent paramIntent)
  {
    LocaleManager.b(paramActivity);
    if (26 <= Build.VERSION.SDK_INT) {
      FontSettingManager.resetFontIfNeeded(paramActivity, true, false);
    }
    if (paramIntent != null) {
      ActivityLifecycle.onNewIntent(paramActivity, paramIntent);
    }
  }
  
  public void doOnWindowFocusChanged(Activity paramActivity, boolean paramBoolean)
  {
    QBaseActivity localQBaseActivity;
    QQAppInterface localQQAppInterface;
    if ((paramActivity instanceof QBaseActivity))
    {
      localQBaseActivity = (QBaseActivity)paramActivity;
      paramActivity = localQBaseActivity.getAppRuntime();
      if ((paramActivity instanceof QQAppInterface))
      {
        localQQAppInterface = (QQAppInterface)paramActivity;
        if (!paramBoolean) {}
      }
    }
    try
    {
      boolean bool = AppSetting.c.equalsIgnoreCase("Xiaomi-MI 5");
      i = 2;
      if (bool)
      {
        Runnable localRunnable = localQBaseActivity.getRunnableRemoveNotification();
        paramActivity = localRunnable;
        if (localRunnable == null) {
          paramActivity = new BaseActivityLifecycleCallbackImpl.1(this, localQBaseActivity, localQQAppInterface);
        }
        ThreadManager.getUIHandler().postDelayed(paramActivity, 3000L);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("notification", 2, "BaseActivity doOnWindowFocusChanged removeNotification");
        }
        localQQAppInterface.removeNotification();
      }
      if ((!localQBaseActivity.isNeedInterruptDoMulitWindow()) || (localQBaseActivity.isAttachedToWindow()) || (!localQBaseActivity.isInMultiWindow())) {
        break label199;
      }
      bool = localQBaseActivity.isNeedStatusBarGone();
      if ((localQBaseActivity.getSystemBarComp() == null) || (localQBaseActivity.getSystemBarComp().isStatusBarVisible != bool)) {
        break label199;
      }
      if (!bool) {
        break label275;
      }
    }
    catch (Throwable paramActivity)
    {
      for (;;)
      {
        continue;
        int i = 0;
      }
    }
    localQBaseActivity.getSystemBarComp().setStatusBarVisible(i, 0);
    localQBaseActivity.setStatusBarVisibility(i);
    localQBaseActivity.doInMultiWindowModeStatusBarVisibilityChange(i);
    label199:
    localQBaseActivity.setAttachedToWindow(true);
    break label249;
    if (QLog.isDevelopLevel())
    {
      QLog.i("qqBaseActivity", 4, "doOnWindowFocusChanged failed");
      break label249;
      paramActivity = localQBaseActivity.getRunnableRemoveNotification();
      if (paramActivity != null)
      {
        ThreadManager.getUIHandler().removeCallbacks(paramActivity);
        localQBaseActivity.setRunnableRemoveNotification(null);
      }
    }
    label249:
    ((IKanDianMergeManager)localQQAppInterface.getRuntimeService(IKanDianMergeManager.class)).baseActivityFocusChange(paramBoolean, getClass());
  }
  
  public void onAccountChanged(Activity paramActivity)
  {
    if ((paramActivity instanceof QBaseActivity))
    {
      paramActivity = ((QBaseActivity)paramActivity).getAppRuntime();
      if ((paramActivity instanceof QQAppInterface)) {
        ((QQAppInterface)paramActivity).cancelSyncOnlineFriend(0L);
      }
    }
  }
  
  public void onMultiWindowModeChanged(Activity paramActivity, boolean paramBoolean)
  {
    if (((paramActivity instanceof QBaseActivity)) && (paramBoolean) && (QBaseActivity.sTopActivity == paramActivity) && (paramBoolean) && (Build.VERSION.SDK_INT >= 24))
    {
      AppRuntime localAppRuntime = ((QBaseActivity)paramActivity).getAppRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ReportController.a((QQAppInterface)localAppRuntime, "dc00898", "", "", "0X800859D", "0X800859D", 0, 0, "", "", "", "");
      }
      StatisticCollector.getInstance(paramActivity).collectPerformance(null, "MulitScreenMode", paramBoolean, 0L, 0L, null, null);
    }
  }
  
  public void onPostThemeChanged(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbackImpl
 * JD-Core Version:    0.7.0.1
 */