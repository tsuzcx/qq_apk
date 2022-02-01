package com.tencent.common.wormhole.provider;

import com.tencent.common.wormhole.controllers.HippyWormholeContainerController;
import com.tencent.common.wormhole.controllers.HippyWormholeController;
import com.tencent.common.wormhole.controllers.HippyWormholeSession;
import com.tencent.common.wormhole.controllers.TKDWormholeController;
import com.tencent.common.wormhole.module.EventObserverModule;
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

public class WormholeAPIProvider
  implements HippyAPIProvider
{
  public List<Class<? extends HippyViewController>> getControllers()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(HippyWormholeContainerController.class);
    localArrayList.add(HippyWormholeSession.class);
    localArrayList.add(TKDWormholeController.class);
    localArrayList.add(HippyWormholeController.class);
    return localArrayList;
  }
  
  public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules()
  {
    return null;
  }
  
  public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext paramHippyEngineContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(EventObserverModule.class, new WormholeAPIProvider.1(this, paramHippyEngineContext));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.wormhole.provider.WormholeAPIProvider
 * JD-Core Version:    0.7.0.1
 */