package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.app.asyncdb.BaseCacheManager;
import mqq.app.AppRuntime;

public abstract interface ManagerFactory
{
  public abstract BaseCacheManager getCacheManager(AppRuntime paramAppRuntime);
  
  public abstract BaseProxyManager getProxyManager(AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.ManagerFactory
 * JD-Core Version:    0.7.0.1
 */