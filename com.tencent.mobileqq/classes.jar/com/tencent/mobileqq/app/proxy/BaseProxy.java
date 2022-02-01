package com.tencent.mobileqq.app.proxy;

import mqq.app.AppRuntime;

public abstract class BaseProxy
{
  protected AppRuntime app;
  protected BaseProxyManager proxyManager;
  
  public BaseProxy(AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager)
  {
    this.app = paramAppRuntime;
    this.proxyManager = paramBaseProxyManager;
  }
  
  public abstract void destroy();
  
  public abstract void init();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.BaseProxy
 * JD-Core Version:    0.7.0.1
 */