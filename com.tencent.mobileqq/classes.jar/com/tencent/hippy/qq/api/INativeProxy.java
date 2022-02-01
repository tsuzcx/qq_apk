package com.tencent.hippy.qq.api;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/hippy/qq/api/INativeProxy;", "", "callNativeMethod", "", "module", "", "method", "readable", "callback", "registerNativeMethod", "reactJsCallBack", "unRegisterNativeMethod", "hippy-api_release"}, k=1, mv={1, 1, 16})
public abstract interface INativeProxy
{
  public abstract void callNativeMethod(@Nullable String paramString1, @Nullable String paramString2, @Nullable Object paramObject1, @Nullable Object paramObject2);
  
  public abstract void registerNativeMethod(@Nullable String paramString1, @Nullable String paramString2, @Nullable Object paramObject);
  
  public abstract void unRegisterNativeMethod(@Nullable String paramString1, @Nullable String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.api.INativeProxy
 * JD-Core Version:    0.7.0.1
 */