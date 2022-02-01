package com.tencent.common.wormhole.provider;

import com.tencent.common.wormhole.module.EventObserverModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class WormholeAPIProvider$1
  implements Provider<HippyNativeModuleBase>
{
  WormholeAPIProvider$1(WormholeAPIProvider paramWormholeAPIProvider, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase a()
  {
    return new EventObserverModule(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.wormhole.provider.WormholeAPIProvider.1
 * JD-Core Version:    0.7.0.1
 */