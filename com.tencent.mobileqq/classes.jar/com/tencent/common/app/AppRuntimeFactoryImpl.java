package com.tencent.common.app;

import mqq.app.AppRuntime;

public class AppRuntimeFactoryImpl
  implements AppRuntimeFactory
{
  public AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    return paramBaseApplicationImpl.waitAppRuntime(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.app.AppRuntimeFactoryImpl
 * JD-Core Version:    0.7.0.1
 */