package com.tencent.comic.hippy.api;

import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class HippyApiProviderWrapper
  implements HippyAPIProvider
{
  protected HippyAPIProvider mProviderImp;
  
  public List<Class<? extends HippyViewController>> getControllers()
  {
    initProviderImp();
    Object localObject1 = this.mProviderImp;
    if (localObject1 != null) {
      localObject1 = ((HippyAPIProvider)localObject1).getControllers();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new ArrayList();
    }
    return localObject2;
  }
  
  public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules()
  {
    initProviderImp();
    HippyAPIProvider localHippyAPIProvider = this.mProviderImp;
    if (localHippyAPIProvider != null) {
      return localHippyAPIProvider.getJavaScriptModules();
    }
    return null;
  }
  
  public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext paramHippyEngineContext)
  {
    initProviderImp();
    HippyAPIProvider localHippyAPIProvider = this.mProviderImp;
    if (localHippyAPIProvider != null) {
      return localHippyAPIProvider.getNativeModules(paramHippyEngineContext);
    }
    return null;
  }
  
  protected abstract void initProviderImp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.hippy.api.HippyApiProviderWrapper
 * JD-Core Version:    0.7.0.1
 */