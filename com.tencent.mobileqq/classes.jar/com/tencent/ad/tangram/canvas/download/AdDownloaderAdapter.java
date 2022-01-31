package com.tencent.ad.tangram.canvas.download;

import android.support.annotation.Keep;
import android.util.Pair;

@Keep
public abstract interface AdDownloaderAdapter
  extends IAdDownloader
{
  public abstract IAdDownloader getDownloader();
  
  public abstract int getProgress(Object paramObject);
  
  public abstract boolean isCurrentPkgTask(Pair<String, String> paramPair, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.download.AdDownloaderAdapter
 * JD-Core Version:    0.7.0.1
 */