package com.tencent.hippy.qq.module;

import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;

@HippyNativeModule(name="QQWebDataModule")
public class QQWebDataModule
  extends QQBaseModule
{
  static final String CLASSNAME = "QQWebDataModule";
  private final String METHOD_GET_UA = "getDefaultUserAgent";
  
  public QQWebDataModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="getDefaultUserAgent")
  public void getDefaultUserAgent(Promise paramPromise)
  {
    paramPromise.resolve(SwiftWebViewUtils.a(SwiftWebViewUtils.c(""), "", false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQWebDataModule
 * JD-Core Version:    0.7.0.1
 */