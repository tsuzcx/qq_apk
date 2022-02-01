package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.UnifiedMonitor;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class ActiveAccount
  extends AsyncStep
{
  protected int doStep()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onInitState: ");
      ((StringBuilder)localObject).append(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
    }
    this.mAutomator.jdField_a_of_type_Long = System.currentTimeMillis();
    this.mAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("startService", Long.valueOf(SystemClock.uptimeMillis() - StartupDirector.e));
    localObject = this.mAutomator;
    BaseApplication localBaseApplication = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("acc_info");
    localStringBuilder.append(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    ((Automator)localObject).jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    localObject = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ThemeUtil.initTheme((AppRuntime)localObject);
    try
    {
      ((QQAppInterface)localObject).addManager(true, this.mAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PREF_PLUGIN_DELAY_TIME", -1L));
      bool = false;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        this.mAutomator.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("PREF_PLUGIN_DELAY_TIME", 0L).apply();
        boolean bool = true;
        ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).initAllData((AppInterface)localObject);
        ((QQAppInterface)localObject).initFaceSettingCache();
        ((IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).onActiveAccount();
        UnifiedMonitor.a().a();
        OpenApiManager.getInstance().onRuntimeActive((QQAppInterface)localObject);
        if (!TroopNotificationUtils.a(((QQAppInterface)localObject).getCurrentAccountUin())) {
          break label327;
        }
        if (!QLog.isColorLevel()) {
          break label289;
        }
        QLog.d("QQInitHandler", 2, "addSystemMsgSeq:0");
        ((QQAppInterface)localObject).getMsgCache().e("last_group_seq", 0L);
        ((QQAppInterface)localObject).getMsgCache().e("last_group_suspicious_seq", 0L);
        TroopNotificationUtils.a(((QQAppInterface)localObject).getCurrentAccountUin(), false);
        ((QQAppInterface)localObject).getMsgCache().e("last_friend_seq_47", 0L);
        if (AnonymousChatHelper.a == null) {
          break label339;
        }
        AnonymousChatHelper.a().a();
        if (!(((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER) instanceof WerewolvesHandler)) {
          break label365;
        }
        ((WerewolvesHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a();
        localObject = new File(AppConstants.SDCARD_PATH);
        if (FileUtils.fileExists(AppConstants.SDCARD_PATH)) {
          break label390;
        }
        ((File)localObject).mkdirs();
        CleanCache.a(AppConstants.SDCARD_PATH);
        QLog.d("QQInitHandler", 2, new Object[] { "pluginManageDelayTime=", Long.valueOf(this.mAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PREF_PLUGIN_DELAY_TIME", -1L)), " hasCrashInAddManager=", Boolean.valueOf(bool) });
        return 7;
        localThrowable1 = localThrowable1;
      }
      catch (Throwable localThrowable2)
      {
        break label211;
      }
    }
    ((QQAppInterface)localObject).addManager(true);
  }
  
  public void onCreate() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ActiveAccount
 * JD-Core Version:    0.7.0.1
 */