package com.tencent.hippy.qq.module;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

@HippyNativeModule(name="comic")
public class HippyQQComicModule
  extends HippyNativeModuleBase
{
  static final String CLASSNAME = "comic";
  private QQComicModule mComicModule = new QQComicModule();
  
  public HippyQQComicModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="getChapterList")
  public void getChapterList(String paramString, Promise paramPromise)
  {
    this.mComicModule.getChapterList(paramString, paramPromise);
  }
  
  @HippyMethod(name="getPictureList")
  public void getPictureList(String paramString1, String paramString2, Promise paramPromise)
  {
    this.mComicModule.getPictureList(paramString1, paramString2, paramPromise);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.HippyQQComicModule
 * JD-Core Version:    0.7.0.1
 */