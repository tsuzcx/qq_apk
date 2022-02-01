package com.tencent.hippy.qq.app;

import com.tencent.hippy.qq.module.HippyQQBridgeModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class HippyQQAPIProvider$3
  implements Provider<HippyNativeModuleBase>
{
  HippyQQAPIProvider$3(HippyQQAPIProvider paramHippyQQAPIProvider, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase get()
  {
    return new HippyQQBridgeModule(this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQAPIProvider.3
 * JD-Core Version:    0.7.0.1
 */