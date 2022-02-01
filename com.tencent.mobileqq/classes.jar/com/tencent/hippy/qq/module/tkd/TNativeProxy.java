package com.tencent.hippy.qq.module.tkd;

import com.tencent.hippy.qq.api.INativeProxy;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class TNativeProxy
  implements INativeProxy
{
  private final Map<String, TJsCallBack> mjsCallbacks = new HashMap();
  
  @NotNull
  private String getMethodKey(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public void callNativeMethod(String paramString1, String paramString2, Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof HippyMap)) && ((paramObject2 instanceof Promise))) {
      callNativeMethodInternal(paramString1, paramString2, (HippyMap)paramObject1, (Promise)paramObject2);
    }
  }
  
  void callNativeMethodInternal(String paramString1, String paramString2, HippyMap paramHippyMap, Promise paramPromise)
  {
    TJsCallBack localTJsCallBack = (TJsCallBack)this.mjsCallbacks.get(getMethodKey(paramString1, paramString2));
    if (localTJsCallBack != null)
    {
      localTJsCallBack.onCallBack(paramHippyMap, paramPromise);
      return;
    }
    if (paramPromise != null)
    {
      paramHippyMap = new StringBuilder();
      paramHippyMap.append("there is no ");
      paramHippyMap.append(paramString1);
      paramHippyMap.append(" native function ");
      paramHippyMap.append(paramString2);
      paramPromise.reject(paramHippyMap.toString());
    }
  }
  
  public void registerNativeMethod(String paramString1, String paramString2, Object paramObject)
  {
    if ((paramObject instanceof TJsCallBack)) {
      registerNativeMethodInternal(paramString1, paramString2, (TJsCallBack)paramObject);
    }
  }
  
  public void registerNativeMethodInternal(String paramString1, String paramString2, TJsCallBack paramTJsCallBack)
  {
    this.mjsCallbacks.put(getMethodKey(paramString1, paramString2), paramTJsCallBack);
  }
  
  public void unRegisterNativeMethod(String paramString1, String paramString2)
  {
    this.mjsCallbacks.remove(getMethodKey(paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TNativeProxy
 * JD-Core Version:    0.7.0.1
 */