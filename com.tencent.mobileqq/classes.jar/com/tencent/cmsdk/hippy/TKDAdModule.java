package com.tencent.cmsdk.hippy;

import com.tencent.cmsdk.hippy.api.ITKDAdModule;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

@HippyNativeModule(name="TKDAdModule")
public class TKDAdModule
  extends HippyNativeModuleBase
{
  public static String TAG = "TKDAdModule";
  
  public TKDAdModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    TKDAdHippy.getInstance().getTKDAdModule().init(paramHippyEngineContext);
  }
  
  @HippyMethod(name="mmaOnExpose")
  public void MMAOnExpose(String paramString, int paramInt)
  {
    TKDAdHippy.getInstance().getTKDAdModule().MMAOnExpose(paramString, paramInt);
  }
  
  @HippyMethod(name="getAccountInfo")
  public void getAccountInfo(Promise paramPromise)
  {
    TKDAdHippy.getInstance().getTKDAdModule().getAccountInfo(paramPromise);
  }
  
  @HippyMethod(name="getAppPkgInfo")
  public void getAppPkgInfo(String paramString, Promise paramPromise)
  {
    TKDAdHippy.getInstance().getTKDAdModule().getAppPkgInfo(paramString, paramPromise);
  }
  
  @HippyMethod(name="getDeviceInfo")
  public void getDeviceInfo(Promise paramPromise)
  {
    TKDAdHippy.getInstance().getTKDAdModule().getDeviceInfo(paramPromise);
  }
  
  @HippyMethod(name="getEnv")
  public void getEnv(Promise paramPromise)
  {
    TKDAdHippy.getInstance().getTKDAdModule().getEnv(paramPromise);
  }
  
  @HippyMethod(name="goBack")
  public void goBack(String paramString, Promise paramPromise)
  {
    TKDAdHippy.getInstance().getTKDAdModule().goBack(paramString, paramPromise);
  }
  
  @HippyMethod(name="isSupportQQMiniGame")
  public void isSupportQQMiniGame(Promise paramPromise)
  {
    TKDAdHippy.getInstance().getTKDAdModule().isSupportQQMiniGame(paramPromise);
  }
  
  @HippyMethod(name="loadUrl")
  public void loadUrl(String paramString, HippyMap paramHippyMap)
  {
    TKDAdHippy.getInstance().getTKDAdModule().loadUrl(paramString, paramHippyMap);
  }
  
  @HippyMethod(name="openQQMiniGameByLink")
  public void openQQMiniGameByLink(HippyMap paramHippyMap, Promise paramPromise)
  {
    TKDAdHippy.getInstance().getTKDAdModule().openQQMiniGameByLink(paramHippyMap, paramPromise);
  }
  
  @HippyMethod(name="runApp")
  public void runApp(String paramString)
  {
    TKDAdHippy.getInstance().getTKDAdModule().runApp(paramString);
  }
  
  @HippyMethod(name="sendWupRequest")
  public void sendWupRequest(HippyMap paramHippyMap, Promise paramPromise)
  {
    TKDAdHippy.getInstance().getTKDAdModule().sendWupRequest(paramHippyMap, paramPromise);
  }
  
  @HippyMethod(name="setTitle")
  public void setTitle(HippyMap paramHippyMap, Promise paramPromise)
  {
    TKDAdHippy.getInstance().getTKDAdModule().setTitle(paramHippyMap, paramPromise);
  }
  
  @HippyMethod(name="showToast")
  public void showToast(String paramString1, String paramString2, int paramInt, String paramString3, Promise paramPromise)
  {
    TKDAdHippy.getInstance().getTKDAdModule().showToast(paramString1, paramString2, paramInt, paramString3, paramPromise);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.cmsdk.hippy.TKDAdModule
 * JD-Core Version:    0.7.0.1
 */