package com.tencent.mobileqq.apollo.ipc.business;

import com.tencent.mobileqq.apollo.ipc.annotation.ServletImpl;

@ServletImpl(a=EngineConfigLoaderImpl.class)
public abstract interface IEngineConfigLoader
{
  public abstract void initConfig(IEngineConfigLoader.IConfigCallback paramIConfigCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.IEngineConfigLoader
 * JD-Core Version:    0.7.0.1
 */