package com.tencent.ad.tangram.canvas.download;

import android.support.annotation.Keep;
import java.lang.ref.WeakReference;

@Keep
public enum AdDownloadTask
{
  INSTANCE;
  
  private WeakReference<AdDownloadTaskAdapter> adapter;
  
  private AdDownloadTask() {}
  
  private static AdDownloadTaskAdapter getAdapter()
  {
    if (INSTANCE.adapter != null) {
      return (AdDownloadTaskAdapter)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static Object getDownloadTask()
  {
    AdDownloadTaskAdapter localAdDownloadTaskAdapter = getAdapter();
    if (localAdDownloadTaskAdapter != null) {
      return localAdDownloadTaskAdapter.getDownloadTask();
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdDownloadTaskAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
  
  public static void setDownloadTask(Object paramObject)
  {
    AdDownloadTaskAdapter localAdDownloadTaskAdapter = getAdapter();
    if (localAdDownloadTaskAdapter != null) {
      localAdDownloadTaskAdapter.setDownloadTask(paramObject);
    }
  }
  
  public static void setDownloadUrl(String paramString)
  {
    AdDownloadTaskAdapter localAdDownloadTaskAdapter = getAdapter();
    if (localAdDownloadTaskAdapter != null) {
      localAdDownloadTaskAdapter.setDownloadUrl(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.download.AdDownloadTask
 * JD-Core Version:    0.7.0.1
 */