package com.tencent.hippy.qq.module.tkd;

import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class TKDNativeProxy
{
  private final Map<String, TKDJsCallBack> mjsCallbacks = new HashMap();
  
  @NotNull
  private String getMethodKey(String paramString1, String paramString2)
  {
    return paramString1 + paramString2;
  }
  
  void callNativeMethod(String paramString1, String paramString2, HippyMap paramHippyMap, Promise paramPromise)
  {
    TKDJsCallBack localTKDJsCallBack = (TKDJsCallBack)this.mjsCallbacks.get(getMethodKey(paramString1, paramString2));
    if (localTKDJsCallBack != null) {
      localTKDJsCallBack.onCallBack(paramHippyMap, paramPromise);
    }
    while (paramPromise == null) {
      return;
    }
    paramPromise.reject("there is no " + paramString1 + " native function " + paramString2);
  }
  
  public void registerNativeMethod(String paramString1, String paramString2, TKDJsCallBack paramTKDJsCallBack)
  {
    this.mjsCallbacks.put(getMethodKey(paramString1, paramString2), paramTKDJsCallBack);
  }
  
  public void unRegisterNativeMethod(String paramString1, String paramString2)
  {
    this.mjsCallbacks.remove(getMethodKey(paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDNativeProxy
 * JD-Core Version:    0.7.0.1
 */