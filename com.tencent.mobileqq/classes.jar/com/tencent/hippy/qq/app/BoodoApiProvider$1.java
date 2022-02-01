package com.tencent.hippy.qq.app;

import com.tencent.hippy.qq.module.boodo.BoodoModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class BoodoApiProvider$1
  implements Provider<HippyNativeModuleBase>
{
  BoodoApiProvider$1(BoodoApiProvider paramBoodoApiProvider, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase get()
  {
    return new BoodoModule(this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.app.BoodoApiProvider.1
 * JD-Core Version:    0.7.0.1
 */