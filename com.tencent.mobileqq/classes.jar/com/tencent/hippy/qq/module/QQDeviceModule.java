package com.tencent.hippy.qq.module;

import biam;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;

@HippyNativeModule(name="QQDeviceModule")
public class QQDeviceModule
  extends QQBaseModule
{
  static final String CLASSNAME = "QQDeviceModule";
  
  public QQDeviceModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="getClientInfo")
  public void getClientInfo(Promise paramPromise)
  {
    String str = biam.a(BaseApplicationImpl.getContext());
    paramPromise.resolve("{\"qqVersion\":\"" + str + "\",\"qqBuild\":\"" + "4810" + "\"}");
  }
  
  @HippyMethod(name="getDeviceInfo")
  public void getDeviceInfo(Promise paramPromise)
  {
    paramPromise.resolve(SensorAPIJavaScript.getDeviceInfoEx("QQDeviceModule"));
  }
  
  @HippyMethod(name="getNetworkType")
  public void getNetworkType(Promise paramPromise)
  {
    paramPromise.resolve(Integer.valueOf(HttpUtil.getNetWorkType()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQDeviceModule
 * JD-Core Version:    0.7.0.1
 */