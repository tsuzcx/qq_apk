package com.tencent.biz.common.offline.util;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.HashMap;

class OfflineDownloader$1
  implements ITMAssistantDownloadClientListener
{
  OfflineDownloader$1(OfflineDownloader paramOfflineDownloader) {}
  
  public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    if (paramTMAssistantDownloadClient == null) {
      return;
    }
    paramTMAssistantDownloadClient = (DownloadInfo)OfflineDownloader.a().get(paramString);
    if (paramTMAssistantDownloadClient != null)
    {
      if (paramTMAssistantDownloadClient.d == null) {
        return;
      }
      int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      paramTMAssistantDownloadClient.d.progress(i);
    }
  }
  
  public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("task onDownloadSDKTaskStateChanged + url = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", state = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", errorCode = ");
      localStringBuilder.append(paramInt2);
      QLog.d("OfflineDownload", 2, localStringBuilder.toString());
    }
    if (paramTMAssistantDownloadClient == null)
    {
      paramTMAssistantDownloadClient = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("client is null, ");
      localStringBuilder.append(paramString2);
      paramTMAssistantDownloadClient.a(null, paramString1, null, -1, localStringBuilder.toString());
      return;
    }
    paramString2 = (DownloadInfo)OfflineDownloader.a().get(paramString1);
    if ((paramString2 != null) && (paramString2.d != null))
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4)
          {
            if (paramInt1 != 5) {
              return;
            }
            this.a.a(paramString2.d, paramString1, paramString2.c, paramInt2, "offline zip download fail");
            try
            {
              this.a.a.cancelDownloadTask(paramString1);
              return;
            }
            catch (Exception paramTMAssistantDownloadClient)
            {
              if (!QLog.isDevelopLevel()) {
                break label308;
              }
            }
            QLog.d("OfflineDownload", 4, paramTMAssistantDownloadClient.toString());
          }
          else
          {
            this.a.a(paramTMAssistantDownloadClient, paramString2, paramString1);
          }
        }
        else if (QLog.isColorLevel())
        {
          paramTMAssistantDownloadClient = new StringBuilder();
          paramTMAssistantDownloadClient.append("task paused + url = ");
          paramTMAssistantDownloadClient.append(paramString1);
          QLog.d("OfflineDownload", 2, paramTMAssistantDownloadClient.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        paramTMAssistantDownloadClient = new StringBuilder();
        paramTMAssistantDownloadClient.append("task downloading + url = ");
        paramTMAssistantDownloadClient.append(paramString1);
        QLog.d("OfflineDownload", 2, paramTMAssistantDownloadClient.toString());
      }
      label308:
      return;
    }
    this.a.a(null, paramString1, null, -1, "download info is null or callback is null");
  }
  
  public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.util.OfflineDownloader.1
 * JD-Core Version:    0.7.0.1
 */