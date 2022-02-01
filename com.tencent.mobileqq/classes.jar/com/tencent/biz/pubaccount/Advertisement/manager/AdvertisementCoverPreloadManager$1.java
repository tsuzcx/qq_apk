package com.tencent.biz.pubaccount.Advertisement.manager;

import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class AdvertisementCoverPreloadManager$1
  implements URLDrawable.DownloadListener
{
  AdvertisementCoverPreloadManager$1(AdvertisementCoverPreloadManager paramAdvertisementCoverPreloadManager) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    synchronized ()
    {
      String str = (String)AdvertisementCoverPreloadManager.a(this.a).get(0);
      AdvertisementCoverPreloadManager.a(this.a).remove(0);
      if (AdvertisementCoverPreloadManager.b(this.a) != null)
      {
        StringBuilder localStringBuilder;
        if (AdvertisementCoverPreloadManager.b(this.a).contains(str))
        {
          AdvertisementCoverPreloadManager.b(this.a).remove(str);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onFileDownloadFailed(delete) url:");
            localStringBuilder.append(str);
            QLog.d("AdvertisementCoverPreloadManager", 2, localStringBuilder.toString());
          }
        }
        else
        {
          AdvertisementCoverPreloadManager.a(this.a).add(str);
          AdvertisementCoverPreloadManager.b(this.a).add(str);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onFileDownloadFailed(retry) url:");
            localStringBuilder.append(str);
            QLog.d("AdvertisementCoverPreloadManager", 2, localStringBuilder.toString());
          }
        }
      }
      AdvertisementCoverPreloadManager.a(this.a, null);
      AdvertisementCoverPreloadManager.a(this.a);
      return;
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    synchronized ()
    {
      String str = (String)AdvertisementCoverPreloadManager.a(this.a).get(0);
      AdvertisementCoverPreloadManager.a(this.a).remove(0);
      if ((AdvertisementCoverPreloadManager.b(this.a) != null) && (AdvertisementCoverPreloadManager.b(this.a).contains(str))) {
        AdvertisementCoverPreloadManager.b(this.a).remove(str);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onFileDownloadSucceed url:");
        localStringBuilder.append(str);
        QLog.d("AdvertisementCoverPreloadManager", 2, localStringBuilder.toString());
      }
      AdvertisementCoverPreloadManager.a(this.a, null);
      AdvertisementCoverPreloadManager.a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementCoverPreloadManager.1
 * JD-Core Version:    0.7.0.1
 */