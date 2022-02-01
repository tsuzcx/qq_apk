package com.tencent.hippy.qq.app;

import com.tencent.cmsdk.hippy.TKDAdModule;
import com.tencent.comic.api.IQQComicHippyUtil;
import com.tencent.common.wormhole.controllers.HippyWormholeContainerController;
import com.tencent.common.wormhole.controllers.HippyWormholeController;
import com.tencent.common.wormhole.controllers.HippyWormholeSession;
import com.tencent.common.wormhole.module.EventObserverModule;
import com.tencent.gdtad.hippy.GdtTangramModule;
import com.tencent.hippy.qq.module.HippyQQBridgeModule;
import com.tencent.hippy.qq.module.HippyQQCacheModule;
import com.tencent.hippy.qq.module.HippyQQHttpModule;
import com.tencent.hippy.qq.module.HippyQQReportModule;
import com.tencent.hippy.qq.module.QQAppModule;
import com.tencent.hippy.qq.module.QQDataModule;
import com.tencent.hippy.qq.module.QQDebugModule;
import com.tencent.hippy.qq.module.QQDeviceModule;
import com.tencent.hippy.qq.module.QQEventModule;
import com.tencent.hippy.qq.module.QQHippyBundleModule;
import com.tencent.hippy.qq.module.QQJsbModule;
import com.tencent.hippy.qq.module.QQNavigatorModule;
import com.tencent.hippy.qq.module.QQOfflineModule;
import com.tencent.hippy.qq.module.QQPatchModule;
import com.tencent.hippy.qq.module.QQRedPointModule;
import com.tencent.hippy.qq.module.QQTreasureCardModule;
import com.tencent.hippy.qq.module.QQTroopNoticeModule;
import com.tencent.hippy.qq.module.QQUiModule;
import com.tencent.hippy.qq.module.QQWebDataModule;
import com.tencent.hippy.qq.view.boodo.CommonVideoViewController;
import com.tencent.hippy.qq.view.video.HippyQQVideoViewController;
import com.tencent.hippy.qq.view.viola.list.TkdListItemViewController;
import com.tencent.hippy.qq.view.viola.list.TkdListViewController;
import com.tencent.hippy.qq.view.viola.scroll.TkdScrollViewController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.hippy.view.HippyDTReportController;
import com.tencent.mobileqq.vas.hippy.view.HippyLottieViewController;
import com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallItemViewController;
import com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallViewController;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HippyQQAPIProvider
  implements HippyAPIProvider
{
  public List<Class<? extends HippyViewController>> getControllers()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(HippyQQVideoViewController.class);
    localArrayList.add(CommonVideoViewController.class);
    localArrayList.add(TkdListItemViewController.class);
    localArrayList.add(TkdListViewController.class);
    localArrayList.add(TkdScrollViewController.class);
    localArrayList.add(HippyLottieViewController.class);
    localArrayList.add(HippyDTReportController.class);
    localArrayList.add(HippyWormholeContainerController.class);
    localArrayList.add(HippyWormholeSession.class);
    localArrayList.add(HippyWormholeController.class);
    localArrayList.add(HippyWaterfallViewController.class);
    localArrayList.add(HippyWaterfallItemViewController.class);
    return localArrayList;
  }
  
  public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules()
  {
    return null;
  }
  
  public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext paramHippyEngineContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(HippyQQReportModule.class, new HippyQQAPIProvider.1(this, paramHippyEngineContext));
    localHashMap.put(HippyQQCacheModule.class, new HippyQQAPIProvider.2(this, paramHippyEngineContext));
    localHashMap.put(HippyQQBridgeModule.class, new HippyQQAPIProvider.3(this, paramHippyEngineContext));
    IQQComicHippyUtil localIQQComicHippyUtil = (IQQComicHippyUtil)QRoute.api(IQQComicHippyUtil.class);
    localHashMap.put(localIQQComicHippyUtil.getHippyQQComicModuleClass(), new HippyQQAPIProvider.4(this, localIQQComicHippyUtil, paramHippyEngineContext));
    localHashMap.put(HippyQQHttpModule.class, new HippyQQAPIProvider.5(this, paramHippyEngineContext));
    localHashMap.put(TKDAdModule.class, new HippyQQAPIProvider.6(this, paramHippyEngineContext));
    localHashMap.put(QQAppModule.class, new HippyQQAPIProvider.7(this, paramHippyEngineContext));
    localHashMap.put(QQDebugModule.class, new HippyQQAPIProvider.8(this, paramHippyEngineContext));
    localHashMap.put(QQPatchModule.class, new HippyQQAPIProvider.9(this, paramHippyEngineContext));
    localHashMap.put(QQDataModule.class, new HippyQQAPIProvider.10(this, paramHippyEngineContext));
    localHashMap.put(QQDeviceModule.class, new HippyQQAPIProvider.11(this, paramHippyEngineContext));
    localHashMap.put(QQEventModule.class, new HippyQQAPIProvider.12(this, paramHippyEngineContext));
    localHashMap.put(QQNavigatorModule.class, new HippyQQAPIProvider.13(this, paramHippyEngineContext));
    localHashMap.put(QQRedPointModule.class, new HippyQQAPIProvider.14(this, paramHippyEngineContext));
    localHashMap.put(QQTroopNoticeModule.class, new HippyQQAPIProvider.15(this, paramHippyEngineContext));
    localHashMap.put(QQUiModule.class, new HippyQQAPIProvider.16(this, paramHippyEngineContext));
    localHashMap.put(GdtTangramModule.class, new HippyQQAPIProvider.17(this, paramHippyEngineContext));
    localHashMap.put(QQOfflineModule.class, new HippyQQAPIProvider.18(this, paramHippyEngineContext));
    localHashMap.put(QQWebDataModule.class, new HippyQQAPIProvider.19(this, paramHippyEngineContext));
    localHashMap.put(QQTreasureCardModule.class, new HippyQQAPIProvider.20(this, paramHippyEngineContext));
    localHashMap.put(QQHippyBundleModule.class, new HippyQQAPIProvider.21(this, paramHippyEngineContext));
    localHashMap.put(QQJsbModule.class, new HippyQQAPIProvider.22(this, paramHippyEngineContext));
    localHashMap.put(EventObserverModule.class, new HippyQQAPIProvider.24(this, paramHippyEngineContext));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQAPIProvider
 * JD-Core Version:    0.7.0.1
 */