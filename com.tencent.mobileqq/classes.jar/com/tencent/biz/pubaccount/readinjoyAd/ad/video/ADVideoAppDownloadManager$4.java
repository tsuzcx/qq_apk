package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdDownloadUtil;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

class ADVideoAppDownloadManager$4
  implements Runnable
{
  public void run()
  {
    ADVideoAppDownloadData localADVideoAppDownloadData = ADVideoAppDownloadManager.b(this.this$0);
    if (localADVideoAppDownloadData == null) {
      return;
    }
    int j = localADVideoAppDownloadData.f;
    if (AdDownloadUtil.a(localADVideoAppDownloadData))
    {
      localADVideoAppDownloadData.f = 1;
      localObject = this.this$0;
      ((ADVideoAppDownloadManager)localObject).a(ADVideoAppDownloadManager.a((ADVideoAppDownloadManager)localObject, localADVideoAppDownloadData, 100), localADVideoAppDownloadData.f);
      return;
    }
    Object localObject = localADVideoAppDownloadData.c;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.this$0.a(null, 0);
      return;
    }
    localObject = DownloadManagerV2.a().g((String)localObject);
    if (localObject != null)
    {
      int i = (int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen * 100.0F);
      if ((j != 5) && (j != 0))
      {
        if ((j == 4) || (j == 3))
        {
          int k = ((TMAssistantDownloadTaskInfo)localObject).mState;
          if ((j == 3) && (k == 3))
          {
            this.this$0.c(localADVideoAppDownloadData);
            localObject = new DownloadInfo();
            ((DownloadInfo)localObject).e = localADVideoAppDownloadData.d;
            ((DownloadInfo)localObject).t = i;
            ((DownloadInfo)localObject).c = localADVideoAppDownloadData.a;
            this.this$0.a((DownloadInfo)localObject, 4);
            return;
          }
          if ((j == 4) && (k == 2))
          {
            localObject = new DownloadInfo();
            ((DownloadInfo)localObject).c = localADVideoAppDownloadData.a;
            ((DownloadInfo)localObject).e = localADVideoAppDownloadData.d;
            ((DownloadInfo)localObject).t = i;
            this.this$0.a((DownloadInfo)localObject, 3);
            return;
          }
          if ((j == 4) && (k == 3))
          {
            localObject = new DownloadInfo();
            ((DownloadInfo)localObject).e = localADVideoAppDownloadData.d;
            ((DownloadInfo)localObject).t = i;
            ((DownloadInfo)localObject).c = localADVideoAppDownloadData.a;
            this.this$0.a((DownloadInfo)localObject, 4);
            return;
          }
          if ((j == 4) && (k == 1))
          {
            localObject = new DownloadInfo();
            ((DownloadInfo)localObject).c = localADVideoAppDownloadData.a;
            ((DownloadInfo)localObject).e = localADVideoAppDownloadData.d;
            ((DownloadInfo)localObject).t = i;
            this.this$0.a((DownloadInfo)localObject, 3);
            return;
          }
          if (k == 4)
          {
            localObject = new DownloadInfo();
            ((DownloadInfo)localObject).c = localADVideoAppDownloadData.a;
            ((DownloadInfo)localObject).e = localADVideoAppDownloadData.d;
            ((DownloadInfo)localObject).t = 100;
            ADVideoAppDownloadManager.a(this.this$0).a = true;
            ADVideoAppDownloadManager.a(this.this$0).a();
            this.this$0.a((DownloadInfo)localObject, 5);
          }
        }
      }
      else
      {
        j = ((TMAssistantDownloadTaskInfo)localObject).mState;
        if ((j != 2) && (j != 1))
        {
          if (j == 3) {
            localADVideoAppDownloadData.f = 4;
          } else if (j == 4) {
            localADVideoAppDownloadData.f = 5;
          } else {
            localADVideoAppDownloadData.f = 0;
          }
        }
        else {
          localADVideoAppDownloadData.f = 3;
        }
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).e = localADVideoAppDownloadData.d;
        ((DownloadInfo)localObject).t = i;
        ((DownloadInfo)localObject).c = localADVideoAppDownloadData.a;
        ADVideoAppDownloadManager.a(this.this$0).a = true;
        ADVideoAppDownloadManager.a(this.this$0).a();
        if (ADVideoAppDownloadManager.b(this.this$0) != null) {
          ADVideoAppDownloadManager.b(this.this$0).g = i;
        }
        this.this$0.a((DownloadInfo)localObject, localADVideoAppDownloadData.f);
      }
    }
    else
    {
      this.this$0.a(null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager.4
 * JD-Core Version:    0.7.0.1
 */