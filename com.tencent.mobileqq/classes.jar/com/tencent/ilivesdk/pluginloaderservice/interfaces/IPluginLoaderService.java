package com.tencent.ilivesdk.pluginloaderservice.interfaces;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface IPluginLoaderService
  extends ServiceBaseInterface
{
  public abstract <T> void a(Class<T> paramClass, String paramString, ClassLoaderListener paramClassLoaderListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.interfaces.IPluginLoaderService
 * JD-Core Version:    0.7.0.1
 */