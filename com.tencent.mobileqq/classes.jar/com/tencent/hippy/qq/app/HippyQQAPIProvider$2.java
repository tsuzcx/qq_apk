package com.tencent.hippy.qq.app;

import com.tencent.hippy.qq.module.HippyQQCacheModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class HippyQQAPIProvider$2
  implements Provider<HippyNativeModuleBase>
{
  HippyQQAPIProvider$2(HippyQQAPIProvider paramHippyQQAPIProvider, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase get()
  {
    return new HippyQQCacheModule(this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQAPIProvider.2
 * JD-Core Version:    0.7.0.1
 */