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
        if (!AdvertisementCoverPreloadManager.b(this.a).contains(str)) {
          break label119;
        }
        AdvertisementCoverPreloadManager.b(this.a).remove(str);
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(delete) url:" + str);
        }
      }
      label119:
      do
      {
        AdvertisementCoverPreloadManager.a(this.a, null);
        AdvertisementCoverPreloadManager.a(this.a);
        return;
        AdvertisementCoverPreloadManager.a(this.a).add(str);
        AdvertisementCoverPreloadManager.b(this.a).add(str);
      } while (!QLog.isColorLevel());
      QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadFailed(retry) url:" + str);
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
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementCoverPreloadManager", 2, "onFileDownloadSucceed url:" + str);
      }
      AdvertisementCoverPreloadManager.a(this.a, null);
      AdvertisementCoverPreloadManager.a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementCoverPreloadManager.1
 * JD-Core Version:    0.7.0.1
 */