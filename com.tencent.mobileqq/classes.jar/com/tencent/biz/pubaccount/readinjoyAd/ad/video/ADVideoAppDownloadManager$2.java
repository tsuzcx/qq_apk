package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.appstore.dl.DownloadProxy;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

class ADVideoAppDownloadManager$2
  implements Runnable
{
  public void run()
  {
    Object localObject1 = this.a.d;
    String str1 = this.a.a;
    String str2 = this.a.e;
    Object localObject2;
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      if ((TextUtils.isEmpty(this.a.c)) && (!TextUtils.isEmpty(this.a.b)))
      {
        localObject2 = this.a;
        ((ADVideoAppDownloadData)localObject2).c = ADVideoAppDownloadManager.a(this.this$0, ((ADVideoAppDownloadData)localObject2).b, 1);
      }
      localObject2 = this.a.c;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ADVideoAppDownloadManager", 2, "downloadUrl null");
        }
        return;
      }
      Object localObject3 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VideoDownloadUrl : ");
      localStringBuilder.append((String)localObject2);
      ((IRIJAdLogService)localObject3).d("ADVideoAppDownloadManager", localStringBuilder.toString());
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString(DownloadConstants.f, (String)localObject1);
      ((Bundle)localObject3).putString(DownloadConstants.b, str1);
      ((Bundle)localObject3).putString(DownloadConstants.j, (String)localObject2);
      ((Bundle)localObject3).putString(DownloadConstants.l, str2);
      ((Bundle)localObject3).putInt(DownloadConstants.k, 2);
      ((Bundle)localObject3).putInt(DownloadConstants.G, 0);
      ((Bundle)localObject3).putBoolean(DownloadConstants.y, false);
      ((Bundle)localObject3).putInt(DownloadConstants.J, 0);
      ((Bundle)localObject3).putBoolean(DownloadConstants.z, true);
      ((Bundle)localObject3).putBoolean(DownloadConstants.h, true);
      ((Bundle)localObject3).putBoolean(DownloadConstants.s, false);
      ((Bundle)localObject3).putBoolean(DownloadConstants.L, false);
      if (!TextUtils.isEmpty(this.a.h)) {
        ((Bundle)localObject3).putString(DownloadConstants.i, this.a.h);
      }
      ((Bundle)localObject3).putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startRealDownload pkg:");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(", appid:");
        localStringBuilder.append(str1);
        localStringBuilder.append(", name:");
        localStringBuilder.append(str2);
        localStringBuilder.append(", url:");
        localStringBuilder.append((String)localObject2);
        QLog.d("ADVideoAppDownloadManager", 2, localStringBuilder.toString());
      }
      this.this$0.a.remove(this.a);
      this.this$0.a.add(this.a);
      localObject1 = (Activity)this.b.get();
      if ((localObject1 != null) && (!((Activity)localObject1).isFinishing()))
      {
        DownloadProxy.a().a((Activity)localObject1, (Bundle)localObject3, "biz_src_feeds_kandianads", null, 0);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ADVideoAppDownloadManager", 2, "ac=null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startRealDownload packageName:");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", appid:");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(", appName:");
      ((StringBuilder)localObject2).append(str2);
      QLog.d("ADVideoAppDownloadManager", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */