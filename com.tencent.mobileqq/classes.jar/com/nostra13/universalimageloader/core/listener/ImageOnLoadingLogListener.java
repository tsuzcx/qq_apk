package com.nostra13.universalimageloader.core.listener;

import com.nostra13.universalimageloader.core.assist.FailReason;

public abstract interface ImageOnLoadingLogListener
{
  public abstract void onLoadingCancelled(String paramString);
  
  public abstract void onLoadingComplete(String paramString);
  
  public abstract void onLoadingFailed(String paramString, FailReason paramFailReason);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.listener.ImageOnLoadingLogListener
 * JD-Core Version:    0.7.0.1
 */