package com.tencent.hippy.qq.app;

import com.tencent.hippy.qq.module.gamecenter.QQGameCenterModule;
import com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoViewController;
import com.tencent.mobileqq.gamecenter.hippy.view.GpImageViewController;
import com.tencent.mobileqq.gamecenter.hippy.view.GpTextViewController;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameCenterApiProvider
  implements HippyAPIProvider
{
  public List<Class<? extends HippyViewController>> getControllers()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(GameCenterVideoViewController.class);
    localArrayList.add(GpImageViewController.class);
    localArrayList.add(GpTextViewController.class);
    return localArrayList;
  }
  
  public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules()
  {
    return null;
  }
  
  public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext paramHippyEngineContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(QQGameCenterModule.class, new GameCenterApiProvider.1(this, paramHippyEngineContext));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.app.GameCenterApiProvider
 * JD-Core Version:    0.7.0.1
 */