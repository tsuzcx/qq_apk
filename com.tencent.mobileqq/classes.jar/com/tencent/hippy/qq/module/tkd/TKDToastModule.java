package com.tencent.hippy.qq.module.tkd;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.UIThreadUtils;

@HippyNativeModule(name="TKDToastModule")
public class TKDToastModule
  extends HippyNativeModuleBase
{
  public TKDToastModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private int getIconType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  @HippyMethod(name="show")
  public void show(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, Promise paramPromise)
  {
    UIThreadUtils.runOnUiThread(new TKDToastModule.1(this, paramInt2, paramString1, paramInt1, paramPromise));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDToastModule
 * JD-Core Version:    0.7.0.1
 */