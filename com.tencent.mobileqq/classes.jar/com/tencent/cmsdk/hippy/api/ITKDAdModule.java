package com.tencent.cmsdk.hippy.api;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;

public abstract interface ITKDAdModule
{
  public abstract void MMAOnExpose(String paramString, int paramInt);
  
  public abstract void getAccountInfo(Promise paramPromise);
  
  public abstract void getAppPkgInfo(String paramString, Promise paramPromise);
  
  public abstract void getDeviceInfo(Promise paramPromise);
  
  public abstract void getEnv(Promise paramPromise);
  
  public abstract void goBack(String paramString, Promise paramPromise);
  
  public abstract void init(HippyEngineContext paramHippyEngineContext);
  
  public abstract void isSupportQQMiniGame(Promise paramPromise);
  
  public abstract void loadUrl(String paramString, HippyMap paramHippyMap);
  
  public abstract void openQQMiniGameByLink(HippyMap paramHippyMap, Promise paramPromise);
  
  public abstract void runApp(String paramString);
  
  public abstract void sendWupRequest(HippyMap paramHippyMap, Promise paramPromise);
  
  public abstract void setTitle(HippyMap paramHippyMap, Promise paramPromise);
  
  public abstract void showToast(String paramString1, String paramString2, int paramInt, String paramString3, Promise paramPromise);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.cmsdk.hippy.api.ITKDAdModule
 * JD-Core Version:    0.7.0.1
 */