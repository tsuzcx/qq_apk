package com.tencent.image;

public abstract interface URLDrawableHandler
{
  public abstract void doCancel();
  
  public abstract boolean isCancelled();
  
  public abstract void onFileDownloadFailed(int paramInt);
  
  public abstract void onFileDownloadStarted();
  
  public abstract void onFileDownloadSucceed(long paramLong);
  
  public abstract void publishProgress(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.URLDrawableHandler
 * JD-Core Version:    0.7.0.1
 */