package com.tencent.ad.tangram.canvas.download;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;

@Keep
public abstract interface IAdDownloader
{
  public abstract void doDownloadAction(Activity paramActivity, Bundle paramBundle, String paramString, int paramInt);
  
  public abstract int getCurrentPkgDownloadProgress(Context paramContext, String paramString1, String paramString2);
  
  public abstract Object getDownloadInfoByUrl(String paramString);
  
  public abstract void installDownload(Object paramObject);
  
  public abstract int isPkgDownloadPaused(Context paramContext, String paramString1, String paramString2);
  
  public abstract int isPkgDownloading(Context paramContext, String paramString1, String paramString2);
  
  public abstract boolean isPkgExist(Context paramContext, String paramString1, String paramString2);
  
  public abstract void pauseDownload(String paramString1, String paramString2);
  
  public abstract void registerListener(IAdDownloader.Callback paramCallback);
  
  public abstract void unregisterListener(IAdDownloader.Callback paramCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.download.IAdDownloader
 * JD-Core Version:    0.7.0.1
 */