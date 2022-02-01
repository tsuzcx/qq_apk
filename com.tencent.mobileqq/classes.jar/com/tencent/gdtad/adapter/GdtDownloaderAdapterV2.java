package com.tencent.gdtad.adapter;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.downloader.AdDownloaderAdapterV2;
import com.tencent.ad.tangram.downloader.AdDownloaderV2.Listener;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.dl.DownloadProxy;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class GdtDownloaderAdapterV2
  implements AdDownloaderAdapterV2
{
  private List<WeakReference<AdDownloaderV2.Listener>> a = new CopyOnWriteArrayList();
  private DownloadListener b = new GdtDownloaderAdapterV2.3(this);
  
  private void a(String paramString, int paramInt)
  {
    AdThreadManager.INSTANCE.post(new GdtDownloaderAdapterV2.1(this, paramString, paramInt), 0);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    AdThreadManager.INSTANCE.post(new GdtDownloaderAdapterV2.2(this, paramString, paramInt1, paramInt2), 0);
  }
  
  public int getProgressOnFileThread(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -2147483648;
    }
    paramString = DownloadManagerV2.a().b(paramString);
    if (paramString == null) {
      return -2147483648;
    }
    if ((paramString.a() != 2) && (paramString.a() != 3)) {
      return -2147483648;
    }
    return paramString.t;
  }
  
  public void init()
  {
    DownloadManagerV2.a().a(this.b);
  }
  
  public void installDownload(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = DownloadManagerV2.a().b(paramString);
      if (paramString != null) {}
    }
    else
    {
      GdtLog.d("GdtDownloaderAdapterV2", "installDownload error");
      return;
    }
    DownloadManagerV2.a().d(paramString);
  }
  
  public boolean isDownloadedOnFileThread(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = DownloadManagerV2.a().b(paramString);
      if ((paramString != null) && (!TextUtils.isEmpty(paramString.q))) {
        return new File(paramString.q).exists();
      }
    }
    return false;
  }
  
  public void pauseDownload(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      GdtLog.d("GdtDownloaderAdapterV2", "pauseDownload error");
      return;
    }
    DownloadManagerV2.a().e(paramString);
  }
  
  public void registerListener(WeakReference<AdDownloaderV2.Listener> paramWeakReference)
  {
    if (paramWeakReference != null)
    {
      if (paramWeakReference.get() == null) {
        return;
      }
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() == paramWeakReference.get())) {
          return;
        }
      }
      this.a.add(paramWeakReference);
    }
  }
  
  public void startDownload(String paramString, Ad paramAd, Bundle paramBundle)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramAd != null) && (paramAd.isValid()))
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putString("big_brother_source_key", "biz_src_ads");
      paramBundle = new Bundle();
      paramBundle.putString(DownloadConstants.f, paramAd.getAppPackageName());
      paramBundle.putString(DownloadConstants.b, paramAd.getAppId());
      paramBundle.putString(DownloadConstants.j, paramString);
      paramBundle.putString(DownloadConstants.l, paramAd.getAppName());
      paramBundle.putInt(DownloadConstants.k, 2);
      paramBundle.putInt(DownloadConstants.G, 0);
      paramBundle.putBoolean(DownloadConstants.y, false);
      paramBundle.putInt(DownloadConstants.J, 0);
      paramBundle.putBoolean(DownloadConstants.z, true);
      paramBundle.putBoolean(DownloadConstants.h, true);
      paramBundle.putBoolean(DownloadConstants.s, false);
      paramBundle.putBoolean(DownloadConstants.L, false);
      paramBundle.putString(DownloadConstants.i, paramAd.getVia());
      paramBundle.putInt("hideInstallSuccessPage", 1);
      paramBundle.putAll(localBundle);
      DownloadProxy.a().a(null, paramBundle, "biz_src_ads", null, 0);
      return;
    }
    GdtLog.d("GdtDownloaderAdapterV2", "startDownload error");
  }
  
  public void unregisterListener(WeakReference<AdDownloaderV2.Listener> paramWeakReference)
  {
    if (paramWeakReference != null)
    {
      if (paramWeakReference.get() == null) {
        return;
      }
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() == paramWeakReference.get())) {
          this.a.remove(localWeakReference);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtDownloaderAdapterV2
 * JD-Core Version:    0.7.0.1
 */