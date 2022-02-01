package com.tencent.biz.richframework.delegate;

import android.app.Application;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface IApplicationDelegate
{
  public abstract String getAccountId();
  
  public abstract Application getApplication();
  
  public abstract ConcurrentHashMap<Class, Class> getClassImplMap();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.delegate.IApplicationDelegate
 * JD-Core Version:    0.7.0.1
 */