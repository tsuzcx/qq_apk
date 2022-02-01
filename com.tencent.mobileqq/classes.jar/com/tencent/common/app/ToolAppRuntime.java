package com.tencent.common.app;

import android.os.Bundle;
import com.tencent.comic.api.IQQComicService;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.flutter.channel.qqcircle.QCircleFlutterAppInterface;
import com.tencent.mobileqq.imaxad.ImaxAppInterface;
import com.tencent.mobileqq.kandian.biz.reward.api.IRIJAidlClient;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsAppInterfaceFactory;
import com.tencent.mobileqq.nearby.api.IFactoryApi;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.IliveAppInterface;
import cooperation.liveroom.LiveRoomHelper;
import cooperation.qqindividuality.QQIndividualityRuntimeHelper;
import cooperation.qqpim.QQPimPluginRuntimeHelper;
import cooperation.qwallet.plugin.IQWalletHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ToolAppRuntime
  extends ToolRuntimeBase
{
  private AppInterface a = null;
  
  public String getModuleId()
  {
    return "tool";
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    DtSdkInitStep.initDTSDK(0);
    ((IRIJAidlClient)QRoute.api(IRIJAidlClient.class)).bindService(getApplication());
  }
  
  public AppRuntime onGetSubRuntime(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ToolAppRuntime.onGetSubRuntime() moduleId ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("ToolAppRuntime", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    boolean bool1 = "module_nearby".equals(paramString);
    boolean bool2 = false;
    if (bool1) {
      localObject = (AppRuntime)((IFactoryApi)QRoute.api(IFactoryApi.class)).getNearbyAppInterface(localBaseApplicationImpl, MobileQQ.processName);
    }
    for (;;)
    {
      bool1 = true;
      break label460;
      if ("comic_plugin.apk".equals(paramString))
      {
        localObject = ((IQQComicService)getRuntimeService(IQQComicService.class, "tool")).createComicRuntime(localBaseApplicationImpl, MobileQQ.processName);
        bool1 = bool2;
        break label460;
      }
      if ("qqpim_plugin.apk".equals(paramString))
      {
        localObject = QQPimPluginRuntimeHelper.a(localBaseApplicationImpl, MobileQQ.processName);
      }
      else
      {
        if ("module_olympic".equals(paramString))
        {
          localObject = new OlympicToolAppInterface(localBaseApplicationImpl, MobileQQ.processName);
          bool1 = bool2;
          break label460;
        }
        if ("qwallet_plugin.apk".equals(paramString))
        {
          localObject = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).createQWalletAppInterface(localBaseApplicationImpl, MobileQQ.processName);
        }
        else
        {
          if ("qqindividuality_plugin.apk".equals(paramString))
          {
            localObject = QQIndividualityRuntimeHelper.a(localBaseApplicationImpl, MobileQQ.processName);
            bool1 = bool2;
            break label460;
          }
          if ("modular_web".equals(paramString))
          {
            localObject = new BrowserAppInterface(localBaseApplicationImpl, MobileQQ.processName);
          }
          else
          {
            if (!"module_videofeeds".equals(paramString)) {
              break;
            }
            localObject = ((IVideoFeedsAppInterfaceFactory)QRoute.api(IVideoFeedsAppInterfaceFactory.class)).create(localBaseApplicationImpl, MobileQQ.processName);
          }
        }
      }
    }
    if ("cmshowgame_module".equals(paramString))
    {
      localObject = ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).createGameAppInterface(localBaseApplicationImpl, MobileQQ.processName);
      bool1 = bool2;
    }
    else if ("imax".equals(paramString))
    {
      localObject = new ImaxAppInterface(localBaseApplicationImpl, MobileQQ.processName);
      bool1 = bool2;
    }
    else if ("peak".equals(paramString))
    {
      localObject = new PeakAppInterface(localBaseApplicationImpl, MobileQQ.processName);
      bool1 = bool2;
    }
    else if ("LiveRoomPlugin.apk".equals(paramString))
    {
      localObject = LiveRoomHelper.createLiveRoomRuntime(localBaseApplicationImpl, MobileQQ.processName);
      bool1 = bool2;
    }
    else if ("ilive_plugin".equals(paramString))
    {
      localObject = new IliveAppInterface(localBaseApplicationImpl, MobileQQ.processName);
      bool1 = bool2;
    }
    else
    {
      bool1 = bool2;
      if ("qcircle_flutter".equals(paramString))
      {
        localObject = new QCircleFlutterAppInterface(localBaseApplicationImpl, MobileQQ.processName);
        bool1 = bool2;
      }
    }
    label460:
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("moduleId needInitSkin =");
      paramString.append(bool1);
      paramString.append(", appInstance=");
      paramString.append(localObject);
      QLog.i("ToolAppRuntime", 2, paramString.toString());
    }
    if ((!InitSkin.c) && (bool1)) {
      InitSkin.a();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.app.ToolAppRuntime
 * JD-Core Version:    0.7.0.1
 */