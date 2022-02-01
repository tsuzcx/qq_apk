package com.tencent.hippy.qq.app;

import com.tencent.hippy.qq.module.tkd.TKDAccountModule;
import com.tencent.hippy.qq.module.tkd.TKDAlertModule;
import com.tencent.hippy.qq.module.tkd.TKDDebugModule;
import com.tencent.hippy.qq.module.tkd.TKDDeviceModule;
import com.tencent.hippy.qq.module.tkd.TKDNativeProxyModule;
import com.tencent.hippy.qq.module.tkd.TKDSearchStatModule;
import com.tencent.hippy.qq.module.tkd.TKDToastModule;
import com.tencent.hippy.qq.module.tkd.TKDWupModule;
import com.tencent.hippy.qq.view.tkd.doublescrollview.HippyTKDDoubleScrollViewController;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDGifImageViewController;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDImageViewController;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewController;
import com.tencent.hippy.qq.view.tkd.text.HippyTKDTextViewController;
import com.tencent.hippy.qq.view.tkd.view.HippyTKDViewGroupController;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TKDApiProvider
  implements HippyAPIProvider
{
  public List<Class<? extends HippyViewController>> getControllers()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(HippyTKDListViewController.class);
    localArrayList.add(HippyTKDDoubleScrollViewController.class);
    localArrayList.add(HippyTKDTextViewController.class);
    localArrayList.add(HippyTKDViewGroupController.class);
    localArrayList.add(HippyTKDImageViewController.class);
    localArrayList.add(HippyTKDGifImageViewController.class);
    return localArrayList;
  }
  
  public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules()
  {
    return null;
  }
  
  public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext paramHippyEngineContext)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = new ArrayList();
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDToastModule.class, new TKDToastModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDNativeProxyModule.class, new TKDNativeProxyModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDDeviceModule.class, new TKDDeviceModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDWupModule.class, new TKDWupModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDSearchStatModule.class, new TKDSearchStatModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDAccountModule.class, new TKDAccountModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDAlertModule.class, new TKDAlertModule(paramHippyEngineContext)));
    ((List)localObject).add(new TKDApiProvider.NativeModule(TKDDebugModule.class, new TKDDebugModule(paramHippyEngineContext)));
    paramHippyEngineContext = ((List)localObject).iterator();
    while (paramHippyEngineContext.hasNext())
    {
      localObject = (TKDApiProvider.NativeModule)paramHippyEngineContext.next();
      localHashMap.put(((TKDApiProvider.NativeModule)localObject).getModuleClass(), new TKDApiProvider.1(this, (TKDApiProvider.NativeModule)localObject));
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.app.TKDApiProvider
 * JD-Core Version:    0.7.0.1
 */