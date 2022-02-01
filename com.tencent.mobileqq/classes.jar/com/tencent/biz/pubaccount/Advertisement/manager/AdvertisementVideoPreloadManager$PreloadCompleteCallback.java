package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;
import java.lang.ref.WeakReference;

class AdvertisementVideoPreloadManager$PreloadCompleteCallback
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private AdvertisementVideoPreloadManager$PreloadCompleteCallback(AdvertisementVideoPreloadManager paramAdvertisementVideoPreloadManager) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    synchronized (AdvertisementVideoPreloadManager.a(this.a))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onPreloadComplete vid:");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(", detail:");
      ((StringBuilder)localObject2).append(paramString2);
      AdvertisementVideoPreloadManager.c(((StringBuilder)localObject2).toString());
      paramString2 = new File(AdvertisementVideoPreloadManager.b(paramString1));
      if (paramString2.exists()) {
        paramString2.renameTo(new File(AdvertisementVideoPreloadManager.a(paramString1)));
      }
      ReportController.a(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", AdvertisementVideoPreloadManager.a(this.a).mVideoVid, String.valueOf(AdvertisementVideoPreloadManager.a(this.a).mSource));
      paramString2 = "";
      localObject2 = (QQAppInterface)AdvertisementVideoPreloadManager.a(this.a).get();
      if (localObject2 != null) {
        paramString2 = ((QQAppInterface)localObject2).getCurrentAccountUin();
      }
      AdvertisementStatistics.b(paramString2, paramString1);
      AdvertisementVideoPreloadManager.a(this.a, AdvertisementVideoPreloadManager.a(this.a));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager.PreloadCompleteCallback
 * JD-Core Version:    0.7.0.1
 */