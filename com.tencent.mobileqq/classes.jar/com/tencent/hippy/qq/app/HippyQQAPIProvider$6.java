package com.tencent.hippy.qq.app;

import com.tencent.cmsdk.hippy.TKDAdHippy;
import com.tencent.cmsdk.hippy.TKDAdModule;
import com.tencent.cmsdk.hippy.api.ITKDAdModule;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class HippyQQAPIProvider$6
  implements Provider<HippyNativeModuleBase>
{
  HippyQQAPIProvider$6(HippyQQAPIProvider paramHippyQQAPIProvider, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase get()
  {
    TKDAdHippy.getInstance().setITkdAdModule((ITKDAdModule)((IRIJAdService)QRoute.api(IRIJAdService.class)).createTKDAdModule());
    return new TKDAdModule(this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQAPIProvider.6
 * JD-Core Version:    0.7.0.1
 */