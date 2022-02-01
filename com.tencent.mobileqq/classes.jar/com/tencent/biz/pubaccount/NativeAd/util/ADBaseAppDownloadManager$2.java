package com.tencent.biz.pubaccount.NativeAd.util;

import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

class ADBaseAppDownloadManager$2
  implements Runnable
{
  ADBaseAppDownloadManager$2(ADBaseAppDownloadManager paramADBaseAppDownloadManager, DownloadInfo paramDownloadInfo, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.c.size() == 0) {
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ADBaseAppDownloadManager", "notifyState error : empty downloads");
      }
      Object localObject1 = this.this$0.c.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        ADVideoAppDownloadData localADVideoAppDownloadData = (ADVideoAppDownloadData)((Iterator)localObject1).next();
        localObject2 = localADVideoAppDownloadData.d;
        if ((localObject2 != null) && (localADVideoAppDownloadData.a != null))
        {
          if (localADVideoAppDownloadData.d.equals(this.a.e))
          {
            localADVideoAppDownloadData.f = this.b;
            localADVideoAppDownloadData.g = this.a.t;
            localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("notifyState success : progress = ");
            ((StringBuilder)localObject2).append(this.a.t);
            ((StringBuilder)localObject2).append(" packageName = ");
            ((StringBuilder)localObject2).append(localADVideoAppDownloadData.d);
            ((StringBuilder)localObject2).append(" appId = ");
            ((StringBuilder)localObject2).append(localADVideoAppDownloadData.a);
            ((IRIJAdLogService)localObject1).d("ADBaseAppDownloadManager", ((StringBuilder)localObject2).toString());
            if (localADVideoAppDownloadData.k != null)
            {
              localADVideoAppDownloadData.k.downloadState = this.b;
              localADVideoAppDownloadData.k.progress = this.a.t;
            }
            if (localADVideoAppDownloadData.p != null)
            {
              localADVideoAppDownloadData.p.G = this.b;
              localADVideoAppDownloadData.p.H = this.a.t;
            }
            if (localADVideoAppDownloadData.o != null)
            {
              localADVideoAppDownloadData.o.ap = this.b;
              localADVideoAppDownloadData.o.ao = this.a.t;
            }
            localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("progress ");
            ((StringBuilder)localObject2).append(this.a.t);
            ((IRIJAdLogService)localObject1).d("ADBaseAppDownloadManager", ((StringBuilder)localObject2).toString());
            this.this$0.a(localADVideoAppDownloadData, this.b, this.a.t);
          }
        }
        else
        {
          localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("notifyState error : packageName = ");
          localStringBuilder.append(localADVideoAppDownloadData.d);
          localStringBuilder.append(" appId = ");
          localStringBuilder.append(localADVideoAppDownloadData.a);
          ((IRIJAdLogService)localObject2).d("ADBaseAppDownloadManager", localStringBuilder.toString());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("notifyState error ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      ((IRIJAdLogService)localObject1).d("ADBaseAppDownloadManager", ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */