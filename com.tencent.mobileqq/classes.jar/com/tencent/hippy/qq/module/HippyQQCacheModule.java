package com.tencent.hippy.qq.module;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import org.json.JSONObject;

@HippyNativeModule(name="cache")
public class HippyQQCacheModule
  extends HippyNativeModuleBase
{
  static final String CLASSNAME = "cache";
  private QQCacheModule mCacheModule = new QQCacheModule();
  
  public HippyQQCacheModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="cacheBody")
  public void cacheBody(String paramString)
  {
    this.mCacheModule.cacheBody(paramString);
  }
  
  public void getItem(String paramString, Promise paramPromise)
  {
    this.mCacheModule.getItem(paramString, paramPromise);
  }
  
  @HippyMethod(name="multiGet")
  public void multiGet(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mCacheModule.multiGet(paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="multiRemove")
  public void multiRemove(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mCacheModule.multiRemove(paramHippyMap, "");
      return;
    }
  }
  
  @HippyMethod(name="multiSet")
  public void multiSet(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mCacheModule.multiSet(paramHippyMap, "");
      return;
    }
  }
  
  @HippyMethod(name="remove")
  public void remove(String paramString)
  {
    this.mCacheModule.remove(paramString);
  }
  
  @HippyMethod(name="setItem")
  public void setItem(String paramString1, String paramString2)
  {
    this.mCacheModule.setItem(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.HippyQQCacheModule
 * JD-Core Version:    0.7.0.1
 */