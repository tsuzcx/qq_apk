package com.tencent.hippy.qq.app;

import androidx.annotation.NonNull;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

class TKDApiProvider$NativeModule
{
  private Class<? extends HippyNativeModuleBase> moduleClass;
  private HippyNativeModuleBase moduleInstance;
  
  public TKDApiProvider$NativeModule(@NonNull Class<? extends HippyNativeModuleBase> paramClass, @NonNull HippyNativeModuleBase paramHippyNativeModuleBase)
  {
    this.moduleClass = paramClass;
    this.moduleInstance = paramHippyNativeModuleBase;
  }
  
  public Class<? extends HippyNativeModuleBase> getModuleClass()
  {
    return this.moduleClass;
  }
  
  public HippyNativeModuleBase getModuleInstance()
  {
    return this.moduleInstance;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.app.TKDApiProvider.NativeModule
 * JD-Core Version:    0.7.0.1
 */