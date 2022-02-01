package com.tencent.common.wormhole.module;

import com.tencent.common.wormhole.WormholeManager;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

@HippyNativeModule(name="EventObserver")
public class EventObserverModule
  extends HippyNativeModuleBase
{
  public EventObserverModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="postWormholeMessage")
  public void postWormholeMessage(HippyMap paramHippyMap)
  {
    if (WormholeManager.a().a(this.mContext))
    {
      WormholeManager.a().d(paramHippyMap);
      return;
    }
    WormholeManager.a().c(paramHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.wormhole.module.EventObserverModule
 * JD-Core Version:    0.7.0.1
 */