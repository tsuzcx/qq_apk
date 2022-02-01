package com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.skin.entity.BaseResData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class AdMaterialResManager$6
  extends DownloadListener
{
  AdMaterialResManager$6(AdMaterialResManager paramAdMaterialResManager, BaseResData paramBaseResData, String paramString1, String paramString2) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    int i = 0;
    while (i < AdMaterialResManager.i(this.d).size())
    {
      ((DownloadListener)AdMaterialResManager.j(this.d).get(i)).onCancel(paramDownloadTask);
      i += 1;
    }
    String str = paramDownloadTask.b().getString("resId");
    HashMap localHashMap = AdMaterialResManager.k(this.d);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    localHashMap.remove(localStringBuilder.toString());
    super.onCancel(paramDownloadTask);
    this.d.a("onCancel", paramDownloadTask);
    QLog.d("readinjoy", 2, "mDownloader onCancel");
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Object localObject1 = paramDownloadTask.b();
    String str = ((Bundle)localObject1).getString("resId");
    if (AdMaterialResManager.a(this.d, this.a, paramDownloadTask, this.b)) {
      return;
    }
    localObject1 = ((Bundle)localObject1).getString("prefix");
    if (paramDownloadTask.c == 0)
    {
      if (!AdMaterialResManager.a(this.d, this.b, (String)localObject1, this.a, str, paramDownloadTask)) {}
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("downloadGuide failed: id = ");
      ((StringBuilder)localObject2).append(str);
      QLog.d("AdMaterialResManager", 2, ((StringBuilder)localObject2).toString());
      if ((this.a instanceof MaterialData)) {
        FileUtils.deleteDirectory(this.d.a((String)localObject1, str));
      }
    }
    Object localObject2 = AdMaterialResManager.d(this.d);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    ((HashMap)localObject2).remove(localStringBuilder.toString());
    this.d.a((String)localObject1, this.a);
    int i = 0;
    while (i < AdMaterialResManager.e(this.d).size())
    {
      ((DownloadListener)AdMaterialResManager.f(this.d).get(i)).onDone(paramDownloadTask);
      i += 1;
    }
    this.d.a("onDone", paramDownloadTask);
    i = paramDownloadTask.c;
    long l1 = paramDownloadTask.B;
    long l2 = paramDownloadTask.A;
    this.d.a(new String[] { String.valueOf(i), str, String.valueOf(l1 - l2) });
    QLog.d("readinjoy", 2, "mDownloader downLoadFinish");
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    int i = 0;
    while (i < AdMaterialResManager.l(this.d).size())
    {
      ((DownloadListener)AdMaterialResManager.m(this.d).get(i)).onProgress(paramDownloadTask);
      i += 1;
    }
    super.onProgress(paramDownloadTask);
    this.d.a("onProgress", paramDownloadTask);
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    int i = 0;
    while (i < AdMaterialResManager.g(this.d).size())
    {
      ((DownloadListener)AdMaterialResManager.h(this.d).get(i)).onStart(paramDownloadTask);
      i += 1;
    }
    if (((this.a instanceof MaterialData)) && (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime() != null)) {
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).onResDownloadStart(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime(), (MaterialData)this.a);
    }
    this.d.a("onStart", paramDownloadTask);
    QLog.d("readinjoy", 2, "mDownloader onStart");
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager.6
 * JD-Core Version:    0.7.0.1
 */