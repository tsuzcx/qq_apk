package com.tencent.comic.api;

import com.tencent.comic.api.hippy.IBoodoHippyApiBuilder;
import com.tencent.comic.api.hippy.IComicHippyBackEventInterceptor;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;

@QAPI(process={"all"})
public abstract interface IQQComicHippyUtil
  extends QRouteApi
{
  public abstract HippyAPIProvider createHippyAPIProvider();
  
  public abstract HippyCustomViewCreator createHippyCustomViewCreator();
  
  public abstract Class getComicModuleClass();
  
  public abstract IComicHippyBackEventInterceptor getHippyBackEventInterceptor();
  
  public abstract Class getHippyFragmentClass();
  
  public abstract HippyNativeModuleBase getHippyQQComicModule(HippyEngineContext paramHippyEngineContext);
  
  public abstract Class<? extends HippyNativeModuleBase> getHippyQQComicModuleClass();
  
  public abstract boolean isBoodoModule(String paramString);
  
  public abstract boolean isRuntimeReady();
  
  public abstract void setHippyApiBuilder(IBoodoHippyApiBuilder paramIBoodoHippyApiBuilder);
  
  public abstract void setHippyBackEventInterceptor(IComicHippyBackEventInterceptor paramIComicHippyBackEventInterceptor);
  
  public abstract void setRuntimeReady(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.comic.api.IQQComicHippyUtil
 * JD-Core Version:    0.7.0.1
 */