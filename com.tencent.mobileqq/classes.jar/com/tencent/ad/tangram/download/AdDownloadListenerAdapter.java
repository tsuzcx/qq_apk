package com.tencent.ad.tangram.download;

import android.support.annotation.Keep;
import java.util.List;

@Keep
public abstract interface AdDownloadListenerAdapter
{
  public abstract void installSucceed(String paramString1, String paramString2);
  
  public abstract void onAdDownloadCancel(Object paramObject);
  
  public abstract void onAdDownloadError(Object paramObject, int paramInt1, String paramString, int paramInt2);
  
  public abstract void onAdDownloadFinish(Object paramObject);
  
  public abstract void onAdDownloadPause(Object paramObject);
  
  public abstract void onAdDownloadUpdate(List<Object> paramList);
  
  public abstract void onAdDownloadWait(Object paramObject);
  
  public abstract void onDataChange(Object paramObject);
  
  public abstract void onViewDestroy();
  
  public abstract void packageReplaced(String paramString1, String paramString2);
  
  public abstract void uninstallSucceed(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.download.AdDownloadListenerAdapter
 * JD-Core Version:    0.7.0.1
 */