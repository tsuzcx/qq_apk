package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.utils.FileUtils;
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
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onInitState: " + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    }
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("startService", Long.valueOf(SystemClock.uptimeMillis() - StartupDirector.e));
    this.a.jdField_a_of_type_AndroidContentSharedPreferences = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("acc_info" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ThemeUtil.initTheme((QQAppInterface)localObject);
    try
    {
      ((QQAppInterface)localObject).addManager(true, this.a.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PREF_PLUGIN_DELAY_TIME", -1L));
      bool = false;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        boolean bool;
        ((QQAppInterface)localObject).addManager(true);
        try
        {
          this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("PREF_PLUGIN_DELAY_TIME", 0L).apply();
          bool = true;
        }
        catch (Throwable localThrowable2)
        {
          bool = true;
        }
      }
    }
    SubAccountControll.a((QQAppInterface)localObject);
    ((QQAppInterface)localObject).initFaceSettingCache();
    ((IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).onActiveAccount();
    UnifiedMonitor.a().a();
    OpenApiManager.getInstance().onRuntimeActive((QQAppInterface)localObject);
    if (TroopNotificationUtils.a(((QQAppInterface)localObject).getCurrentAccountUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "addSystemMsgSeq:0");
      }
      ((QQAppInterface)localObject).getMsgCache().e("last_group_seq", 0L);
      ((QQAppInterface)localObject).getMsgCache().e("last_group_suspicious_seq", 0L);
      TroopNotificationUtils.a(((QQAppInterface)localObject).getCurrentAccountUin(), false);
      ((QQAppInterface)localObject).getMsgCache().e("last_friend_seq_47", 0L);
    }
    if (AnonymousChatHelper.a != null) {
      AnonymousChatHelper.a().a();
    }
    if ((((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER) instanceof WerewolvesHandler)) {
      ((WerewolvesHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a();
    }
    localObject = new File(AppConstants.SDCARD_PATH);
    if (!FileUtils.a(AppConstants.SDCARD_PATH)) {
      ((File)localObject).mkdirs();
    }
    CleanCache.a(AppConstants.SDCARD_PATH);
    QLog.d("QQInitHandler", 2, new Object[] { "pluginManageDelayTime=", Long.valueOf(this.a.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PREF_PLUGIN_DELAY_TIME", -1L)), " hasCrashInAddManager=", Boolean.valueOf(bool) });
    return 7;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ActiveAccount
 * JD-Core Version:    0.7.0.1
 */