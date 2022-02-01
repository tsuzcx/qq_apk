package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.text.TextUtils;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.List;

class ADVideoAppDownloadManager$3$1
  implements Runnable
{
  ADVideoAppDownloadManager$3$1(ADVideoAppDownloadManager.3 param3, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = this.c.a.a.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ADVideoAppDownloadData localADVideoAppDownloadData = (ADVideoAppDownloadData)((Iterator)localObject1).next();
      Object localObject2 = localADVideoAppDownloadData.c;
      int j = this.c.a.d(localADVideoAppDownloadData);
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(this.a)) && (((String)localObject2).equals(this.a)) && ((j == 0) || (j == 4) || (j == 3)))
      {
        localObject2 = DownloadManagerV2.a().g((String)localObject2);
        int i = 0;
        if (localObject2 != null) {
          i = (int)((float)((TMAssistantDownloadTaskInfo)localObject2).mReceiveDataLen / (float)((TMAssistantDownloadTaskInfo)localObject2).mTotalDataLen * 100.0F);
        }
        if ((j == 3) && (this.b == 3))
        {
          this.c.a.c(localADVideoAppDownloadData);
          localObject1 = new DownloadInfo();
          ((DownloadInfo)localObject1).e = localADVideoAppDownloadData.d;
          ((DownloadInfo)localObject1).t = i;
          ((DownloadInfo)localObject1).c = localADVideoAppDownloadData.a;
          ADVideoAppDownloadManager.a(this.c.a).a = true;
          ADVideoAppDownloadManager.a(this.c.a).a();
          this.c.a.a((DownloadInfo)localObject1, 4);
          return;
        }
        if (j == 4)
        {
          j = this.b;
          if ((j == 2) || (j == 1))
          {
            this.c.a.b(localADVideoAppDownloadData);
            localObject1 = new DownloadInfo();
            ((DownloadInfo)localObject1).e = localADVideoAppDownloadData.d;
            ((DownloadInfo)localObject1).t = i;
            ((DownloadInfo)localObject1).c = localADVideoAppDownloadData.a;
            ADVideoAppDownloadManager.a(this.c.a).a = true;
            ADVideoAppDownloadManager.a(this.c.a).a();
            this.c.a.a((DownloadInfo)localObject1, 3);
            return;
          }
        }
        if (this.b == 4)
        {
          localObject1 = new DownloadInfo();
          ((DownloadInfo)localObject1).e = localADVideoAppDownloadData.d;
          ((DownloadInfo)localObject1).t = 100;
          ((DownloadInfo)localObject1).c = localADVideoAppDownloadData.a;
          ADVideoAppDownloadManager.a(this.c.a).a = true;
          ADVideoAppDownloadManager.a(this.c.a).a();
          this.c.a.a((DownloadInfo)localObject1, 5);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager.3.1
 * JD-Core Version:    0.7.0.1
 */