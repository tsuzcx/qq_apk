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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.registerproxy.IGuildRegisterProxyMsgHandler;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
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
import mqq.os.MqqHandler;

public class ActiveAccount
  extends AsyncStep
{
  private void a()
  {
    IGPSService localIGPSService = (IGPSService)this.mAutomator.k.getRuntimeService(IGPSService.class, "");
    int i = ((IGuildRegisterProxyMsgHandler)this.mAutomator.k.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildRegisterProxyMsgHandlerName())).d();
    localIGPSService.startGProSdk(this.mAutomator.k.getAccount(), i);
  }
  
  protected int doStep()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onInitState: ");
      ((StringBuilder)localObject).append(this.mAutomator.k.getAccount());
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
    }
    a();
    this.mAutomator.a = System.currentTimeMillis();
    this.mAutomator.j.put("startService", Long.valueOf(SystemClock.uptimeMillis() - StartupDirector.l));
    localObject = this.mAutomator;
    BaseApplication localBaseApplication = this.mAutomator.k.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("acc_info");
    localStringBuilder.append(this.mAutomator.k.getAccount());
    ((Automator)localObject).d = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    localObject = this.mAutomator.k;
    ThemeUtil.initTheme((AppRuntime)localObject);
    try
    {
      ((QQAppInterface)localObject).addManager(true, this.mAutomator.d.getLong("PREF_PLUGIN_DELAY_TIME", -1L));
      bool = false;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        this.mAutomator.d.edit().putLong("PREF_PLUGIN_DELAY_TIME", 0L).apply();
        boolean bool = true;
        ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).initAllData((AppInterface)localObject);
        ThreadManager.getSubThreadHandler().post(new ActiveAccount.1(this, (QQAppInterface)localObject));
        ((IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).onActiveAccount();
        UnifiedMonitor.a().b();
        OpenApiManager.getInstance().onRuntimeActive((QQAppInterface)localObject);
        if (!TroopNotificationUtils.a(((QQAppInterface)localObject).getCurrentAccountUin())) {
          break label345;
        }
        if (!QLog.isColorLevel()) {
          break label305;
        }
        QLog.d("QQInitHandler", 2, "addSystemMsgSeq:0");
        ((QQAppInterface)localObject).getMsgCache().e("last_group_seq", 0L);
        ((QQAppInterface)localObject).getMsgCache().e("last_group_suspicious_seq", 0L);
        TroopNotificationUtils.a(((QQAppInterface)localObject).getCurrentAccountUin(), false);
        ((QQAppInterface)localObject).getMsgCache().e("last_friend_seq_47", 0L);
        if (AnonymousChatHelper.k == null) {
          break label357;
        }
        AnonymousChatHelper.a().b();
        if (!(((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER) instanceof WerewolvesHandler)) {
          break label383;
        }
        ((WerewolvesHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a();
        localObject = new File(AppConstants.SDCARD_PATH);
        if (FileUtils.fileExists(AppConstants.SDCARD_PATH)) {
          break label408;
        }
        ((File)localObject).mkdirs();
        CleanCache.a(AppConstants.SDCARD_PATH);
        QLog.d("QQInitHandler", 2, new Object[] { "pluginManageDelayTime=", Long.valueOf(this.mAutomator.d.getLong("PREF_PLUGIN_DELAY_TIME", -1L)), " hasCrashInAddManager=", Boolean.valueOf(bool) });
        return 7;
        localThrowable1 = localThrowable1;
      }
      catch (Throwable localThrowable2)
      {
        break label215;
      }
    }
    ((QQAppInterface)localObject).addManager(true);
  }
  
  public void onCreate() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ActiveAccount
 * JD-Core Version:    0.7.0.1
 */