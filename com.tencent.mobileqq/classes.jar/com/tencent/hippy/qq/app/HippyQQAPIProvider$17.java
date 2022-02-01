package com.tencent.hippy.qq.app;

import com.tencent.gdtad.hippy.GdtTangramModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class HippyQQAPIProvider$17
  implements Provider<HippyNativeModuleBase>
{
  HippyQQAPIProvider$17(HippyQQAPIProvider paramHippyQQAPIProvider, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase get()
  {
    return new GdtTangramModule(this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQAPIProvider.17
 * JD-Core Version:    0.7.0.1
 */