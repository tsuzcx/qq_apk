package com.tencent.hydevteam.pluginframework.pluginloader;

import com.tencent.hydevteam.common.annotation.API;

@API
public class LoadPluginException
  extends Exception
{
  public LoadPluginException(String paramString)
  {
    super(paramString);
  }
  
  public LoadPluginException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public LoadPluginException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginloader.LoadPluginException
 * JD-Core Version:    0.7.0.1
 */