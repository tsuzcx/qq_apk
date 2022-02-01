package com.tencent.kwstudio.office.debug;

public abstract interface Debugger$IDebugCallback
{
  public abstract void onCleanCache(String paramString, int paramInt);
  
  public abstract void onCleanPlugin(String paramString, int paramInt);
  
  public abstract void onUpgradePlugin(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.kwstudio.office.debug.Debugger.IDebugCallback
 * JD-Core Version:    0.7.0.1
 */