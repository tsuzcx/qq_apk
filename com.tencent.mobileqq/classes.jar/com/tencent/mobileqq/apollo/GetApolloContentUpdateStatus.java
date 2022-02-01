package com.tencent.mobileqq.apollo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.res.IApolloSoLoader;
import com.tencent.mobileqq.apollo.api.uitls.IApolloActionHelper;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.game.ApolloGameTool;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.microapp.apkg.UsedAppListManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GetApolloContentUpdateStatus
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "[GetApolloContentUpdateStatus]system time" + System.currentTimeMillis() + ",last update time:");
    }
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.a.a.getRuntimeService(IApolloManagerService.class, "all");
    SharedPreferences localSharedPreferences = this.a.a.getApp().getSharedPreferences("mobileQQ", 0);
    long l = localSharedPreferences.getLong("last_pull_apollo_content_update_time", 0L);
    if (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(this.a.a.getCurrentUin(), this.a.a) == 0)
    {
      ((ApolloExtensionHandlerImpl)this.a.a.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(this.a.a.getCurrentUin(), 1073741824, "cmshow asyncStep");
      QLog.i("QQInitHandler", 1, "sava doStep cmshow asyncStep getUserApolloInfo RECOMMEND_ACTION");
    }
    ApolloContentUpdateHandler localApolloContentUpdateHandler = (ApolloContentUpdateHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.APOLLO_CONTENT_UPDATE_HANDLER);
    if ((System.currentTimeMillis() - l > 21600000L) || (System.currentTimeMillis() < l)) {
      if (localApolloContentUpdateHandler != null)
      {
        localApolloContentUpdateHandler.a(null);
        localSharedPreferences.edit().putLong("last_pull_apollo_content_update_time", System.currentTimeMillis()).commit();
      }
    }
    for (;;)
    {
      ApolloGameManager.b();
      ((ApolloGameManager)this.a.a.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).e();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "get game list on login.");
      }
      if (localIApolloManagerService.isPlusWhiteList()) {
        ((UsedAppListManager)this.a.a.getManager(QQManagerFactory.USED_APP_LIST_MANAGER)).getUsedAppList();
      }
      ((IApolloSoLoader)QRoute.api(IApolloSoLoader.class)).apiLoadSo("login");
      localIApolloManagerService.setUinForReload(this.a.a.getCurrentAccountUin());
      ApolloGameTool.a(this.a.a);
      if (localIApolloManagerService.isApolloGameWhiteUser(this.a.a.getCurrentAccountUin())) {
        ((ApolloExtensionHandlerImpl)this.a.a.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).d();
      }
      if (localIApolloManagerService.isApolloFuncOpen(this.a.a.getApp())) {
        localIApolloManagerService.requestTianshuAdv();
      }
      return 7;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "system time" + System.currentTimeMillis() + ",last update time:" + l);
      }
      if (localIApolloManagerService.isApolloSupport(this.a.a.getApp())) {
        localIApolloManagerService.checkApolloPanelJsonCfg(false, "login check file", 1);
      } else if (FileUtil.a("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json")) {
        ApolloUtilImpl.checkJsonParse(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.GetApolloContentUpdateStatus
 * JD-Core Version:    0.7.0.1
 */