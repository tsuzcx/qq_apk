package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_action/download_action/AdAppDownloadUtil;", "", "()V", "TAG", "", "coverStateToAdState", "", "state", "getAppDownloadState", "", "downloadData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "callback", "Landroid/webkit/ValueCallback;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_action/download_action/AdAppDownloadUtil$DownloadStateInfo;", "getDownloadInfo", "Lcom/tencent/open/downloadnew/DownloadInfo;", "getDownloadInfoByPkgName", "packageName", "getDownloadInfoByUrl", "url", "isAppInstalled", "", "pkgName", "isPackageExistByDownloadInfo", "info", "DownloadStateInfo", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AdAppDownloadUtil
{
  public static final AdAppDownloadUtil a = new AdAppDownloadUtil();
  
  public final int a(int paramInt)
  {
    int i = 4;
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4) {
          return 0;
        }
        return 5;
      }
    }
    else {
      i = 3;
    }
    return i;
  }
  
  @Nullable
  public final DownloadInfo a(@Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    if (paramADVideoAppDownloadData == null) {
      return null;
    }
    String str = paramADVideoAppDownloadData.c;
    paramADVideoAppDownloadData = paramADVideoAppDownloadData.d;
    return b(str);
  }
  
  public final boolean a(@Nullable DownloadInfo paramDownloadInfo)
  {
    boolean bool2 = false;
    if (paramDownloadInfo == null) {
      return false;
    }
    paramDownloadInfo = paramDownloadInfo.q;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty((CharSequence)paramDownloadInfo))
    {
      bool1 = bool2;
      if (new File(paramDownloadInfo).exists()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean a(@Nullable String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppInstall((Context)BaseApplicationImpl.getContext(), paramString);
  }
  
  @Nullable
  public final DownloadInfo b(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return DownloadManagerV2.a().b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdAppDownloadUtil
 * JD-Core Version:    0.7.0.1
 */