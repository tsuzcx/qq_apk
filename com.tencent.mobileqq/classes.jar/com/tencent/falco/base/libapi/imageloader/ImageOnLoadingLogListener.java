package com.tencent.falco.base.libapi.imageloader;

public abstract interface ImageOnLoadingLogListener
{
  public abstract void onLoadingCancelled(String paramString);
  
  public abstract void onLoadingComplete(String paramString);
  
  public abstract void onLoadingFailed(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.imageloader.ImageOnLoadingLogListener
 * JD-Core Version:    0.7.0.1
 */