package com.tencent.hippy.qq.module;

import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;

@HippyNativeModule(name="QQEventModule")
public class QQEventModule
  extends QQBaseModule
{
  static final String CLASSNAME = "QQEventModule";
  
  public QQEventModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="dispatchEvent")
  public void dispatchEvent(String paramString1, String paramString2, HippyMap paramHippyMap)
  {
    HippyQQEngine.dispatchEvent(paramString1, paramString2, paramHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQEventModule
 * JD-Core Version:    0.7.0.1
 */