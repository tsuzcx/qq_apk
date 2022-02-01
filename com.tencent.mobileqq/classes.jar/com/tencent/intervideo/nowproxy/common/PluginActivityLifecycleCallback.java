package com.tencent.intervideo.nowproxy.common;

public abstract interface PluginActivityLifecycleCallback
{
  public abstract void onActivityCreated(String paramString);
  
  public abstract void onActivityDestroyed(String paramString);
  
  public abstract void onActivityPaused(String paramString);
  
  public abstract void onActivityResumed(String paramString);
  
  public abstract void onActivitySaveInstanceState(String paramString);
  
  public abstract void onActivityStarted(String paramString);
  
  public abstract void onActivityStopped(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.PluginActivityLifecycleCallback
 * JD-Core Version:    0.7.0.1
 */