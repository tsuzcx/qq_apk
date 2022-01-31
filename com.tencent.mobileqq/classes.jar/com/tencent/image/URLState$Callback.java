package com.tencent.image;

public abstract interface URLState$Callback
{
  public abstract void onFileDownloadFailed(int paramInt);
  
  public abstract void onFileDownloadStarted();
  
  public abstract void onFileDownloadSucceed(long paramLong);
  
  public abstract void onFileDownloaded(URLState paramURLState);
  
  public abstract void onLoadCanceled(URLState paramURLState);
  
  public abstract void onLoadFailed(URLState paramURLState, Throwable paramThrowable);
  
  public abstract void onLoadStarted(URLState paramURLState);
  
  public abstract void onLoadSuccessed(URLState paramURLState);
  
  public abstract void onUpdateProgress(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.URLState.Callback
 * JD-Core Version:    0.7.0.1
 */