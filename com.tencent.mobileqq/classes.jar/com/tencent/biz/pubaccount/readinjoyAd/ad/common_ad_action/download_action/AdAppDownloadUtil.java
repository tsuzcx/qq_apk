package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_action/download_action/AdAppDownloadUtil;", "", "()V", "TAG", "", "coverStateToAdState", "", "state", "getAppDownloadState", "", "downloadData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "callback", "Landroid/webkit/ValueCallback;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_action/download_action/AdAppDownloadUtil$DownloadStateInfo;", "getDownloadInfo", "Lcom/tencent/open/downloadnew/DownloadInfo;", "getDownloadInfoByPkgName", "packageName", "getDownloadInfoByUrl", "url", "isAppInstalled", "", "pkgName", "isPackageExistByDownloadInfo", "info", "DownloadStateInfo", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AdAppDownloadUtil
{
  public static final AdAppDownloadUtil a = new AdAppDownloadUtil();
  
  public final int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 2: 
      return 3;
    case 3: 
      return 4;
    }
    return 5;
  }
  
  @Nullable
  public final DownloadInfo a(@Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData == null) {
      return null;
    }
    String str = paramADVideoAppDownloadData.c;
    paramADVideoAppDownloadData = paramADVideoAppDownloadData.d;
    return a(str);
  }
  
  @Nullable
  public final DownloadInfo a(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return DownloadManagerV2.a().b(paramString);
  }
  
  public final boolean a(@Nullable DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return false;
    }
    paramDownloadInfo = paramDownloadInfo.l;
    if ((!TextUtils.isEmpty((CharSequence)paramDownloadInfo)) && (new File(paramDownloadInfo).exists())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean a(@Nullable String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return NativeAdUtils.a((Context)BaseApplicationImpl.getContext(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdAppDownloadUtil
 * JD-Core Version:    0.7.0.1
 */