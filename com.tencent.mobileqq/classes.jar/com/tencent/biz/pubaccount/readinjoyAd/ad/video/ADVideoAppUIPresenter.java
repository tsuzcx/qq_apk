package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdDownloadUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

public class ADVideoAppUIPresenter
{
  public boolean a;
  
  private boolean c(DownloadInfo paramDownloadInfo, ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if ((paramDownloadInfo != null) && (paramADVideoAppDownloadData != null) && (!TextUtils.isEmpty(paramDownloadInfo.e)) && (!TextUtils.isEmpty(paramDownloadInfo.c)) && (!TextUtils.isEmpty(paramADVideoAppDownloadData.d)) && (!TextUtils.isEmpty(paramADVideoAppDownloadData.d))) {
      return paramDownloadInfo.e.equals(paramADVideoAppDownloadData.d);
    }
    return false;
  }
  
  private void d(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    AdDownloadUtil.a(paramADVideoAppDownloadData, new ADVideoAppUIPresenter.1(this, paramADVideoAppDownloadData));
  }
  
  public void a() {}
  
  void a(ADVideoAppDownloadData paramADVideoAppDownloadData) {}
  
  public void a(ADVideoAppDownloadData paramADVideoAppDownloadData, int paramInt) {}
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2, ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (c(paramDownloadInfo, paramADVideoAppDownloadData)) {
      paramADVideoAppDownloadData.f = 6;
    }
  }
  
  void a(DownloadInfo paramDownloadInfo, ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (c(paramDownloadInfo, paramADVideoAppDownloadData)) {
      c(paramADVideoAppDownloadData);
    }
  }
  
  public void a(String paramString1, String paramString2, ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (c(localDownloadInfo, paramADVideoAppDownloadData)) {
      a(paramADVideoAppDownloadData);
    }
  }
  
  void a(List<DownloadInfo> paramList, ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (c(localDownloadInfo, paramADVideoAppDownloadData))
        {
          paramADVideoAppDownloadData.f = 3;
          if ((TextUtils.isEmpty(paramADVideoAppDownloadData.c)) && (!TextUtils.isEmpty(localDownloadInfo.d))) {
            paramADVideoAppDownloadData.c = localDownloadInfo.d;
          }
          if (!this.a)
          {
            this.a = true;
            a();
          }
          a(paramADVideoAppDownloadData, localDownloadInfo.t);
        }
      }
    }
  }
  
  public void b(ADVideoAppDownloadData paramADVideoAppDownloadData) {}
  
  void b(DownloadInfo paramDownloadInfo, ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (c(paramDownloadInfo, paramADVideoAppDownloadData)) {
      b(paramADVideoAppDownloadData);
    }
  }
  
  public void b(String paramString1, String paramString2, ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (c(localDownloadInfo, paramADVideoAppDownloadData)) {
      d(paramADVideoAppDownloadData);
    }
  }
  
  void c(ADVideoAppDownloadData paramADVideoAppDownloadData) {}
  
  public void c(String paramString1, String paramString2, ADVideoAppDownloadData paramADVideoAppDownloadData) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppUIPresenter
 * JD-Core Version:    0.7.0.1
 */