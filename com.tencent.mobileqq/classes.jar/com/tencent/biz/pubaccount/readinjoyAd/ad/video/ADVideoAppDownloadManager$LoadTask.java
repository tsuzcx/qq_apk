package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ADVideoAppDownloadManager$LoadTask
  implements Runnable
{
  private ADVideoAppDownloadData a;
  private int b;
  private WeakReference<ADVideoAppDownloadManager> c;
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ADVideoAppDownloadManager", 2, " mLoadAppJob running... ");
      }
      if (this.a != null)
      {
        localADVideoAppDownloadManager = (ADVideoAppDownloadManager)this.c.get();
        if (localADVideoAppDownloadManager == null) {
          return;
        }
        long l = System.currentTimeMillis();
        this.b += 1;
        ADVideoAppDownloadData localADVideoAppDownloadData = this.a;
        if (localADVideoAppDownloadData.a())
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("mLoadAppJob loader sucess!!! ");
            localStringBuilder.append(localADVideoAppDownloadData.c);
            QLog.d("ADVideoAppDownloadManager", 2, localStringBuilder.toString());
          }
          if ((ADVideoAppDownloadManager.b(localADVideoAppDownloadManager) != null) && (!TextUtils.isEmpty(ADVideoAppDownloadManager.b(localADVideoAppDownloadManager).d)) && (ADVideoAppDownloadManager.b(localADVideoAppDownloadManager).d.equals(localADVideoAppDownloadData.d))) {
            localADVideoAppDownloadManager.a(localADVideoAppDownloadData);
          }
          ADVideoAppDownloadManager.a(localADVideoAppDownloadManager, true, System.currentTimeMillis() - l);
        }
        else
        {
          QLog.d("ADVideoAppDownloadManager", 1, "mLoadAppJob loader failed!!!");
          ADVideoAppDownloadManager.a(localADVideoAppDownloadManager, false, System.currentTimeMillis() - l);
        }
      }
      ADVideoAppDownloadManager localADVideoAppDownloadManager = (ADVideoAppDownloadManager)this.c.get();
      if (localADVideoAppDownloadManager == null) {
        break label221;
      }
      ADVideoAppDownloadManager.a(localADVideoAppDownloadManager, false);
      return;
    }
    catch (Exception localException)
    {
      label207:
      label221:
      break label207;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ADVideoAppDownloadManager", 2, " mLoadAppJob exception");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager.LoadTask
 * JD-Core Version:    0.7.0.1
 */