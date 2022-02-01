package com.tencent.ad.tangram.preorder;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.downloader.IAdDownloader.Callback;
import java.lang.ref.WeakReference;

@Keep
public enum AdAppPreOrderDownloadListener
{
  INSTANCE;
  
  private WeakReference<IAdDownloader.Callback> adapter;
  
  private AdAppPreOrderDownloadListener() {}
  
  public static IAdDownloader.Callback getAdapter()
  {
    WeakReference localWeakReference = INSTANCE.adapter;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return (IAdDownloader.Callback)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<IAdDownloader.Callback> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderDownloadListener
 * JD-Core Version:    0.7.0.1
 */