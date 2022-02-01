package com.tencent.gdtad.hippy;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class GdtApiProvider$1
  implements Provider<HippyNativeModuleBase>
{
  GdtApiProvider$1(GdtApiProvider paramGdtApiProvider, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase get()
  {
    return new GdtTangramModule(this.val$hippyEngineContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.hippy.GdtApiProvider.1
 * JD-Core Version:    0.7.0.1
 */