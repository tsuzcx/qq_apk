package com.tencent.gdtad.adapter;

import android.util.Pair;
import com.tencent.ad.tangram.downloader.IAdDownloader.Callback;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GdtDownloadListener
  implements IAdDownloader.Callback, DownloadListener
{
  private WeakReference<AdAppDownloadManager> a;
  
  public AdAppDownloadManager a()
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return (AdAppDownloadManager)this.a.get();
    }
    return null;
  }
  
  public void a(AdAppDownloadManager paramAdAppDownloadManager)
  {
    this.a = new WeakReference(paramAdAppDownloadManager);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    paramString2 = DownloadManagerV2.a().c(paramString2);
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (paramString2 != null)) {
      ((AdAppDownloadManager)this.a.get()).onDownloadStatusChanged(6, 0, new Pair(paramString2.d, paramString2.e), paramString1);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (paramDownloadInfo != null)) {
      ((AdAppDownloadManager)this.a.get()).onDownloadStatusChanged(4, paramDownloadInfo.f, new Pair(paramDownloadInfo.d, paramDownloadInfo.e), paramDownloadInfo.c);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    paramString = this.a;
    if ((paramString != null) && (paramString.get() != null) && (paramDownloadInfo != null)) {
      ((AdAppDownloadManager)this.a.get()).onDownloadStatusChanged(5, paramDownloadInfo.f, new Pair(paramDownloadInfo.d, paramDownloadInfo.e), paramDownloadInfo.c);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (paramDownloadInfo != null)) {
      ((AdAppDownloadManager)this.a.get()).onDownloadStatusChanged(3, paramDownloadInfo.f, new Pair(paramDownloadInfo.d, paramDownloadInfo.e), paramDownloadInfo.c);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (paramDownloadInfo != null)) {
      ((AdAppDownloadManager)this.a.get()).onDownloadStatusChanged(2, paramDownloadInfo.f, new Pair(paramDownloadInfo.d, paramDownloadInfo.e), paramDownloadInfo.c);
    }
  }
  
  public void onDownloadProgressUpdate(List<Object> paramList, List<Pair<String, String>> paramList1) {}
  
  public void onDownloadStatusChanged(int paramInt1, int paramInt2, Pair<String, String> paramPair, String paramString) {}
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((WeakReference)localObject).get() != null) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return;
      }
      localObject = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (localDownloadInfo == null) {
          break;
        }
        localArrayList.add(new Pair(localDownloadInfo.d, localDownloadInfo.e));
        ((List)localObject).add(localDownloadInfo);
      }
      if (localArrayList.size() != 0)
      {
        if (((List)localObject).size() == 0) {
          return;
        }
        ((AdAppDownloadManager)this.a.get()).onDownloadProgressUpdate((List)localObject, localArrayList);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo) {}
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    paramString2 = DownloadManagerV2.a().c(paramString2);
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null) && (paramString2 != null)) {
      ((AdAppDownloadManager)this.a.get()).onDownloadStatusChanged(7, 0, new Pair(paramString2.d, paramString2.e), paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtDownloadListener
 * JD-Core Version:    0.7.0.1
 */