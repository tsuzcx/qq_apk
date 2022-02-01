package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event;

import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class DownloadCallbackHandler$DownloadCallbackProxy<T extends DownloadListener,  extends WadlProxyServiceCallBackInterface>
  implements WadlProxyServiceCallBackInterface, DownloadListener
{
  private WeakReference<T> a;
  
  public DownloadCallbackHandler$DownloadCallbackProxy(T paramT)
  {
    if (paramT == null) {
      return;
    }
    this.a = new WeakReference(paramT);
  }
  
  public void a(WadlResult paramWadlResult)
  {
    try
    {
      if ((this.a != null) && (this.a.get() != null)) {
        ((WadlProxyServiceCallBackInterface)this.a.get()).a(paramWadlResult);
      }
      return;
    }
    catch (Throwable paramWadlResult) {}
  }
  
  public void a(ArrayList<WadlResult> paramArrayList)
  {
    try
    {
      if ((this.a != null) && (this.a.get() != null)) {
        ((WadlProxyServiceCallBackInterface)this.a.get()).a(paramArrayList);
      }
      return;
    }
    catch (Throwable paramArrayList) {}
  }
  
  public void b(ArrayList<WadlResult> paramArrayList)
  {
    try
    {
      if ((this.a != null) && (this.a.get() != null)) {
        ((WadlProxyServiceCallBackInterface)this.a.get()).b(paramArrayList);
      }
      return;
    }
    catch (Throwable paramArrayList) {}
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    try
    {
      if ((this.a != null) && (this.a.get() != null)) {
        ((DownloadListener)this.a.get()).installSucceed(paramString1, paramString2);
      }
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    try
    {
      if ((this.a != null) && (this.a.get() != null)) {
        ((DownloadListener)this.a.get()).onDownloadCancel(paramDownloadInfo);
      }
      return;
    }
    catch (Throwable paramDownloadInfo) {}
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      if ((this.a != null) && (this.a.get() != null)) {
        ((DownloadListener)this.a.get()).onDownloadError(paramDownloadInfo, paramInt1, paramString, paramInt2);
      }
      return;
    }
    catch (Throwable paramDownloadInfo) {}
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    try
    {
      if ((this.a != null) && (this.a.get() != null)) {
        ((DownloadListener)this.a.get()).onDownloadFinish(paramDownloadInfo);
      }
      return;
    }
    catch (Throwable paramDownloadInfo) {}
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    try
    {
      if ((this.a != null) && (this.a.get() != null)) {
        ((DownloadListener)this.a.get()).onDownloadPause(paramDownloadInfo);
      }
      return;
    }
    catch (Throwable paramDownloadInfo) {}
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    try
    {
      if ((this.a != null) && (this.a.get() != null)) {
        ((DownloadListener)this.a.get()).onDownloadUpdate(paramList);
      }
      return;
    }
    catch (Throwable paramList) {}
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    try
    {
      if ((this.a != null) && (this.a.get() != null)) {
        ((DownloadListener)this.a.get()).onDownloadWait(paramDownloadInfo);
      }
      return;
    }
    catch (Throwable paramDownloadInfo) {}
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    try
    {
      if ((this.a != null) && (this.a.get() != null)) {
        ((DownloadListener)this.a.get()).packageReplaced(paramString1, paramString2);
      }
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    try
    {
      if ((this.a != null) && (this.a.get() != null)) {
        ((DownloadListener)this.a.get()).uninstallSucceed(paramString1, paramString2);
      }
      return;
    }
    catch (Throwable paramString1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.DownloadCallbackHandler.DownloadCallbackProxy
 * JD-Core Version:    0.7.0.1
 */