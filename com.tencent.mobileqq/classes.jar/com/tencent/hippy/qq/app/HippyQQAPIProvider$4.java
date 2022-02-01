package com.tencent.hippy.qq.app;

import com.tencent.comic.api.IQQComicHippyUtil;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class HippyQQAPIProvider$4
  implements Provider<HippyNativeModuleBase>
{
  HippyQQAPIProvider$4(HippyQQAPIProvider paramHippyQQAPIProvider, IQQComicHippyUtil paramIQQComicHippyUtil, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase get()
  {
    return this.val$comicHippyUtil.getHippyQQComicModule(this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQAPIProvider.4
 * JD-Core Version:    0.7.0.1
 */