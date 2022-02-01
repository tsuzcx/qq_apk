package com.tencent.hippy.qq.app;

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
    List localList = null;
    if (this.mProviderImp != null) {
      localList = this.mProviderImp.getControllers();
    }
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    return localObject;
  }
  
  public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules()
  {
    initProviderImp();
    if (this.mProviderImp != null) {
      return this.mProviderImp.getJavaScriptModules();
    }
    return null;
  }
  
  public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext paramHippyEngineContext)
  {
    initProviderImp();
    if (this.mProviderImp != null) {
      return this.mProviderImp.getNativeModules(paramHippyEngineContext);
    }
    return null;
  }
  
  protected abstract void initProviderImp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyApiProviderWrapper
 * JD-Core Version:    0.7.0.1
 */