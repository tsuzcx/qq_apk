package com.tencent.comic.api.impl;

import com.tencent.comic.api.IQQComicHippyUtil;
import com.tencent.comic.api.hippy.IBoodoHippyApiBuilder;
import com.tencent.comic.api.hippy.IComicHippyBackEventInterceptor;
import com.tencent.comic.hippy.BoodoHippyBirdge;
import com.tencent.comic.hippy.VipComicHippyFragment;
import com.tencent.comic.hippy.api.BoodoApiProvider;
import com.tencent.comic.hippy.api.ComicHippyBackEventInterceptorProxy;
import com.tencent.comic.hippy.module.ComicModule;
import com.tencent.comic.hippy.module.HippyQQComicModule;
import com.tencent.comic.hippy.view.QQCustomViewCreator;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;

@Service(process={"all"})
public class QQComicHippyUtilImpl
  implements IQQComicHippyUtil
{
  public HippyAPIProvider createHippyAPIProvider()
  {
    return new BoodoApiProvider();
  }
  
  public HippyCustomViewCreator createHippyCustomViewCreator()
  {
    return new QQCustomViewCreator();
  }
  
  public Class getComicModuleClass()
  {
    return ComicModule.class;
  }
  
  public IComicHippyBackEventInterceptor getHippyBackEventInterceptor()
  {
    return ComicHippyBackEventInterceptorProxy.INSTANCE.mProxy;
  }
  
  public Class getHippyFragmentClass()
  {
    return VipComicHippyFragment.class;
  }
  
  public HippyNativeModuleBase getHippyQQComicModule(HippyEngineContext paramHippyEngineContext)
  {
    return new HippyQQComicModule(paramHippyEngineContext);
  }
  
  public Class<? extends HippyNativeModuleBase> getHippyQQComicModuleClass()
  {
    return HippyQQComicModule.class;
  }
  
  public boolean isBoodoModule(String paramString)
  {
    return BoodoHippyBirdge.isBoodoModule(paramString);
  }
  
  public boolean isRuntimeReady()
  {
    return BoodoHippyBirdge.sBoodoRuntimeReady;
  }
  
  public void setHippyApiBuilder(IBoodoHippyApiBuilder paramIBoodoHippyApiBuilder)
  {
    BoodoHippyBirdge.sHippyApiBuilder = paramIBoodoHippyApiBuilder;
  }
  
  public void setHippyBackEventInterceptor(IComicHippyBackEventInterceptor paramIComicHippyBackEventInterceptor)
  {
    ComicHippyBackEventInterceptorProxy.INSTANCE.mProxy = paramIComicHippyBackEventInterceptor;
  }
  
  public void setRuntimeReady(boolean paramBoolean)
  {
    BoodoHippyBirdge.sBoodoRuntimeReady = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.api.impl.QQComicHippyUtilImpl
 * JD-Core Version:    0.7.0.1
 */