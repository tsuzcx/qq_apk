package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import mqq.os.MqqHandler;

class ADVideoAppDownloadManager$3
  implements ITMAssistantDownloadClientListener
{
  ADVideoAppDownloadManager$3(ADVideoAppDownloadManager paramADVideoAppDownloadManager) {}
  
  public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2) {}
  
  public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    ThreadManager.getSubThreadHandler().post(new ADVideoAppDownloadManager.3.1(this, paramString1, paramInt1));
  }
  
  public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient)
  {
    QLog.e("ADVideoAppDownloadManager", 1, "[UniformDL] ABSdkdownload service invalid ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager.3
 * JD-Core Version:    0.7.0.1
 */