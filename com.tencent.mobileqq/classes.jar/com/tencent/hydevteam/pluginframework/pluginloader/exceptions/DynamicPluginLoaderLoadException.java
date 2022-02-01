package com.tencent.hydevteam.pluginframework.pluginloader.exceptions;

import com.tencent.hydevteam.common.annotation.API;

@API
public class DynamicPluginLoaderLoadException
  extends Exception
{
  public DynamicPluginLoaderLoadException(String paramString)
  {
    super(paramString);
  }
  
  public DynamicPluginLoaderLoadException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginloader.exceptions.DynamicPluginLoaderLoadException
 * JD-Core Version:    0.7.0.1
 */