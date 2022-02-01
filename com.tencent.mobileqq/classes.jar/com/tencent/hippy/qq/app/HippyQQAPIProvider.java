package com.tencent.hippy.qq.app;

import com.tencent.hippy.qq.module.HippyQQBridgeModule;
import com.tencent.hippy.qq.module.HippyQQCacheModule;
import com.tencent.hippy.qq.module.HippyQQComicModule;
import com.tencent.hippy.qq.module.HippyQQHttpModule;
import com.tencent.hippy.qq.module.HippyQQReportModule;
import com.tencent.hippy.qq.view.video.HippyQQVideoViewController;
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

public class HippyQQAPIProvider
  implements HippyAPIProvider
{
  public List<Class<? extends HippyViewController>> getControllers()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(HippyQQVideoViewController.class);
    return localArrayList;
  }
  
  public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules()
  {
    return null;
  }
  
  public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext paramHippyEngineContext)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(HippyQQReportModule.class, new HippyQQAPIProvider.1(this, paramHippyEngineContext));
    localHashMap.put(HippyQQCacheModule.class, new HippyQQAPIProvider.2(this, paramHippyEngineContext));
    localHashMap.put(HippyQQBridgeModule.class, new HippyQQAPIProvider.3(this, paramHippyEngineContext));
    localHashMap.put(HippyQQComicModule.class, new HippyQQAPIProvider.4(this, paramHippyEngineContext));
    localHashMap.put(HippyQQHttpModule.class, new HippyQQAPIProvider.5(this, paramHippyEngineContext));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQAPIProvider
 * JD-Core Version:    0.7.0.1
 */