package com.tencent.comic.hippy.api;

import com.tencent.comic.hippy.module.QQGdtModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class BoodoApiProvider$2
  implements Provider<HippyNativeModuleBase>
{
  BoodoApiProvider$2(BoodoApiProvider paramBoodoApiProvider, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase get()
  {
    return new QQGdtModule(this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.hippy.api.BoodoApiProvider.2
 * JD-Core Version:    0.7.0.1
 */