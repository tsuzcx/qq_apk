package com.tencent.hippy.qq.app;

import com.tencent.hippy.qq.module.gamecenter.GamePubAccountModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class GameCenterApiProvider$3
  implements Provider<HippyNativeModuleBase>
{
  GameCenterApiProvider$3(GameCenterApiProvider paramGameCenterApiProvider, HippyEngineContext paramHippyEngineContext) {}
  
  public HippyNativeModuleBase get()
  {
    return new GamePubAccountModule(this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.app.GameCenterApiProvider.3
 * JD-Core Version:    0.7.0.1
 */