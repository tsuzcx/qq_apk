package com.tencent.mobileqq.apollo.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.game.api.IApolloGameManager;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.res.api.IApolloSoLoader;
import com.tencent.mobileqq.apollo.utils.api.IApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GetApolloContentUpdateStatus
  extends AsyncStep
{
  protected int doStep()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[GetApolloContentUpdateStatus]system time");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append(",last update time:");
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (IApolloManagerService)this.mAutomator.k.getRuntimeService(IApolloManagerService.class, "all");
    String str = this.mAutomator.k.getCurrentUin();
    Object localObject2 = this.mAutomator.k.getApp().getSharedPreferences("mobileQQ", 0);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("last_pull_apollo_content_update_time");
    ((StringBuilder)localObject3).append(str);
    long l = ((SharedPreferences)localObject2).getLong(((StringBuilder)localObject3).toString(), 0L);
    if (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(str, this.mAutomator.k) == 0)
    {
      ((ApolloExtensionHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(str, 1073741824, "cmshow asyncStep");
      QLog.i("QQInitHandler", 1, "sava doStep cmshow asyncStep getUserApolloInfo RECOMMEND_ACTION");
    }
    localObject3 = (ApolloExtensionHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    ApolloContentUpdateHandler localApolloContentUpdateHandler = (ApolloContentUpdateHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.APOLLO_CONTENT_UPDATE_HANDLER);
    if ((System.currentTimeMillis() - l <= 21600000L) && (System.currentTimeMillis() >= l))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("system time");
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        ((StringBuilder)localObject2).append(",last update time:");
        ((StringBuilder)localObject2).append(l);
        QLog.d("QQInitHandler", 2, ((StringBuilder)localObject2).toString());
      }
      if (((IApolloManagerService)localObject1).isApolloSupport(this.mAutomator.k.getApp())) {
        ApolloResManagerFacade.a.a(Scene.AIO).a(false, "login check file", 1);
      } else if (FileUtil.d("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/action/action_v730.json")) {
        ApolloUtilImpl.checkJsonParse(this.mAutomator.k);
      }
    }
    else
    {
      if (localObject3 != null)
      {
        ((ApolloExtensionHandler)localObject3).a(str, 2147483648L, "cmshow asyncStep");
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Long.valueOf(Long.parseLong(str)));
        ((ApolloExtensionHandler)localObject3).a(localArrayList, "cmshow asyncStep");
      }
      if (localApolloContentUpdateHandler != null)
      {
        localApolloContentUpdateHandler.a(null);
        localObject2 = ((SharedPreferences)localObject2).edit();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("last_pull_apollo_content_update_time");
        ((StringBuilder)localObject3).append(str);
        ((SharedPreferences.Editor)localObject2).putLong(((StringBuilder)localObject3).toString(), System.currentTimeMillis()).commit();
      }
    }
    int i = 0;
    localObject2 = (IApolloGameManager)this.mAutomator.k.getRuntimeService(IApolloGameManager.class, "all");
    ((IApolloGameManager)localObject2).resetReqUsrGameList();
    ((IApolloGameManager)localObject2).reqUsrGameList();
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "get game list on login.");
    }
    ((IApolloSoLoader)QRoute.api(IApolloSoLoader.class)).apiLoadSo("login");
    ((IApolloManagerService)localObject1).setUinForReload(str);
    if (((IApolloManagerService)localObject1).isApolloSupport(this.mAutomator.k.getApp())) {
      ((IApolloManagerService)localObject1).requestTianshuAdv();
    }
    ApolloResManagerFacade.a.a(this.mAutomator.k);
    localObject1 = Scene.values();
    int j = localObject1.length;
    while (i < j)
    {
      str = localObject1[i];
      if ((str != Scene.WEB_STORE_OR_GAME) && (str != Scene.MAKE_UP_3D))
      {
        if (CMShowPlatform.a.b(str))
        {
          CMShowPlatform.a.a(str);
          break;
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("scene ： ");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" is tools, continue");
        QLog.d("QQInitHandler", 2, ((StringBuilder)localObject2).toString());
      }
      i += 1;
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.GetApolloContentUpdateStatus
 * JD-Core Version:    0.7.0.1
 */