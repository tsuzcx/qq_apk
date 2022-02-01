package com.tencent.biz.pubaccount.weishi_new.download;

import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.List;

public class WSDownloadListenerWrapper
  implements DownloadListener
{
  public void installSucceed(String paramString1, String paramString2) {}
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2) {}
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadUpdate(List<DownloadInfo> paramList) {}
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo) {}
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WSDownloadListenerWrapper
 * JD-Core Version:    0.7.0.1
 */