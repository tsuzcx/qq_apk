package com.tencent.ark;

public abstract interface ArkAppPreloader$PreloadAppCallback
{
  public abstract void beginAppload(String paramString, int paramInt);
  
  public abstract void onAppLoaded(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract void onReleaseAndReload(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkAppPreloader.PreloadAppCallback
 * JD-Core Version:    0.7.0.1
 */