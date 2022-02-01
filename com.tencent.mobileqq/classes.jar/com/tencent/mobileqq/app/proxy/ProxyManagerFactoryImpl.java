package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class ProxyManagerFactoryImpl
  implements ManagerFactory
{
  private <T extends Manager> T a(AppRuntime paramAppRuntime, int paramInt)
  {
    try
    {
      paramAppRuntime = paramAppRuntime.getManager(paramInt);
      return paramAppRuntime;
    }
    catch (Throwable paramAppRuntime)
    {
      QLog.e("ProxyManagerFactoryImpl", 1, "Wrong type cast, confirm the return proxy type", paramAppRuntime);
    }
    return null;
  }
  
  public CacheManager a(AppRuntime paramAppRuntime)
  {
    return (CacheManager)a(paramAppRuntime, QQManagerFactory.CACHE_MANAGER);
  }
  
  public ProxyManager a(AppRuntime paramAppRuntime)
  {
    return (ProxyManager)a(paramAppRuntime, QQManagerFactory.PROXY_MANAGER);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.ProxyManagerFactoryImpl
 * JD-Core Version:    0.7.0.1
 */