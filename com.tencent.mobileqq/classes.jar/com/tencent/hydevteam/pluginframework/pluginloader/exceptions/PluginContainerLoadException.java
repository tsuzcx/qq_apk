package com.tencent.hydevteam.pluginframework.pluginloader.exceptions;

import com.tencent.hydevteam.common.annotation.API;

@API
public class PluginContainerLoadException
  extends Exception
{
  public PluginContainerLoadException(String paramString)
  {
    super(paramString);
  }
  
  public PluginContainerLoadException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public PluginContainerLoadException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginloader.exceptions.PluginContainerLoadException
 * JD-Core Version:    0.7.0.1
 */