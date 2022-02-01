package com.tencent.ad.tangram.canvas.download;

import android.support.annotation.Keep;
import android.util.Pair;
import java.util.List;

@Keep
public abstract interface IAdDownloader$Callback
{
  public abstract void onDownloadProgressUpdate(List<Object> paramList, List<Pair<String, String>> paramList1);
  
  public abstract void onDownloadStatusChanged(int paramInt1, int paramInt2, Pair<String, String> paramPair, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.download.IAdDownloader.Callback
 * JD-Core Version:    0.7.0.1
 */