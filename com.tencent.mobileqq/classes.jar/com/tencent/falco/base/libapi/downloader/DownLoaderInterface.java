package com.tencent.falco.base.libapi.downloader;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface DownLoaderInterface
  extends ServiceBaseInterface
{
  public abstract void cancel(String paramString);
  
  public abstract void init(DownLoaderInterface.DownLoaderComponentAdapter paramDownLoaderComponentAdapter);
  
  public abstract void pause(String paramString);
  
  public abstract void resume(String paramString);
  
  public abstract void start(String paramString1, String paramString2, int paramInt1, int paramInt2, IDownLoaderListener paramIDownLoaderListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.downloader.DownLoaderInterface
 * JD-Core Version:    0.7.0.1
 */