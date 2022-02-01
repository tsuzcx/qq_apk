package com.tencent.hippy.qq.app;

import com.tencent.hippy.qq.module.QQWebDataModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class HippyQQAPIProvider$19
  implements Provider<HippyNativeModuleBase>
{
  HippyQQAPIProvider$19(HippyQQAPIProvider paramHippyQQAPIProvider, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase get()
  {
    return new QQWebDataModule(this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQAPIProvider.19
 * JD-Core Version:    0.7.0.1
 */