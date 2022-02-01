package com.tencent.gdtad.adapter;

import android.util.Pair;
import com.tencent.ad.tangram.downloader.IAdDownloader.Callback;
import com.tencent.ad.tangram.preorder.AdAppPreOrderManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GdtPreDownloadListenerAdapter
  implements IAdDownloader.Callback, DownloadListener
{
  HashMap<String, GdtPreDownloadListenerAdapter> a = new HashMap();
  
  private void a(int paramInt1, int paramInt2, Pair<String, String> paramPair, String paramString, int paramInt3)
  {
    AdAppPreOrderManager.INSTANCE.onDownloadStatusChanged(paramInt1, (String)paramPair.first, paramInt3);
  }
  
  public void installSucceed(String paramString1, String paramString2) {}
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    onDownloadStatusChanged(11, paramDownloadInfo.f, new Pair(paramDownloadInfo.d, paramDownloadInfo.e), paramDownloadInfo.c);
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    a(11, paramDownloadInfo.f, new Pair(paramDownloadInfo.d, paramDownloadInfo.e), paramDownloadInfo.c, paramInt1);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    onDownloadStatusChanged(10, paramDownloadInfo.f, new Pair(paramDownloadInfo.d, paramDownloadInfo.e), paramDownloadInfo.c);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    onDownloadStatusChanged(9, paramDownloadInfo.f, new Pair(paramDownloadInfo.d, paramDownloadInfo.e), paramDownloadInfo.c);
  }
  
  public void onDownloadProgressUpdate(List<Object> paramList, List<Pair<String, String>> paramList1)
  {
    AdAppPreOrderManager.INSTANCE.onDownloadProgressUpdate(paramList, paramList1);
  }
  
  public void onDownloadStatusChanged(int paramInt1, int paramInt2, Pair<String, String> paramPair, String paramString)
  {
    a(paramInt1, paramInt2, paramPair, paramString, -2147483648);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      if (localDownloadInfo == null) {
        break;
      }
      localArrayList2.add(new Pair(localDownloadInfo.d, localDownloadInfo.e));
      localArrayList1.add(localDownloadInfo);
    }
    if (localArrayList2.size() != 0)
    {
      if (localArrayList1.size() == 0) {
        return;
      }
      onDownloadProgressUpdate(localArrayList1, localArrayList2);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo) {}
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtPreDownloadListenerAdapter
 * JD-Core Version:    0.7.0.1
 */