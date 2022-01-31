package com.tencent.ad.tangram.download;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Keep;

@Keep
public abstract interface IAdDownloader
{
  public abstract void activeDownloader();
  
  public abstract void doDownloadAction(Activity paramActivity, Bundle paramBundle, String paramString, int paramInt);
  
  public abstract Object getDownloadInfoByUrl(String paramString);
  
  public abstract void installDownload(Object paramObject);
  
  public abstract void registerListener(Object paramObject);
  
  public abstract void unregisterListener(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.download.IAdDownloader
 * JD-Core Version:    0.7.0.1
 */