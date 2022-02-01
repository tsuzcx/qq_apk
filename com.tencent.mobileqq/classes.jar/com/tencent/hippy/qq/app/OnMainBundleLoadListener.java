package com.tencent.hippy.qq.app;

import com.tencent.mtt.hippy.HippyEngineContext;

public abstract interface OnMainBundleLoadListener
{
  public abstract void onDestroy(String paramString, HippyQQEngine paramHippyQQEngine);
  
  public abstract void onMainBundleLoadResult(int paramInt1, String paramString, HippyEngineContext paramHippyEngineContext, int paramInt2);
  
  public abstract void onStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.app.OnMainBundleLoadListener
 * JD-Core Version:    0.7.0.1
 */