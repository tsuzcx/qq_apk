package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRecommendAdHelper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdDialogUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebRecommendAdService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdDownloadUtil;", "", "()V", "doGameDownload", "", "view", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "data", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "doNormalAppDownload", "doSoftAppDownload", "isAmsAppAd", "adData", "isAppInstalled", "packageName", "", "isShowOuterDownloadProgress", "advertisementInfo", "openApp", "context", "Landroid/app/Activity;", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJAdDownloadUtil
{
  public static final RIJAdDownloadUtil a = new RIJAdDownloadUtil();
  
  private final boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdvertisementInfo != null)
    {
      AdvertisementExtInfo localAdvertisementExtInfo = paramAdvertisementInfo.mAdvertisementExtInfo;
      int i;
      if (localAdvertisementExtInfo != null) {
        i = localAdvertisementExtInfo.j;
      } else {
        i = 0;
      }
      bool1 = bool2;
      if (i == 32)
      {
        bool1 = bool2;
        if (paramAdvertisementInfo.mAdProductType == 12) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final boolean a(@Nullable Activity paramActivity, @Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramActivity == null) {
      return false;
    }
    if (b(paramAdvertisementInfo)) {
      return ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).openAppFromGdtApi((Context)paramActivity, paramAdvertisementInfo, null, 2, true);
    }
    if (paramAdvertisementInfo != null) {
      paramAdvertisementInfo = paramAdvertisementInfo.getPackageName();
    } else {
      paramAdvertisementInfo = null;
    }
    if (!TextUtils.isEmpty((CharSequence)paramAdvertisementInfo)) {
      return ReadInJoyAdUtils.a((Context)paramActivity, paramAdvertisementInfo);
    }
    return false;
  }
  
  public final boolean a(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = false;
    if (paramAdvertisementInfo == null) {
      return false;
    }
    if (((RIJAdDownloadExKt.c(paramAdvertisementInfo)) && (RIJAdDownloadExKt.a(paramAdvertisementInfo))) || (RIJAdDownloadExKt.d(paramAdvertisementInfo)) || (RIJAdDownloadExKt.e(paramAdvertisementInfo)) || (RIJAdDownloadExKt.f(paramAdvertisementInfo)) || (RIJAdDownloadExKt.g(paramAdvertisementInfo))) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean a(@NotNull RIJDownloadView paramRIJDownloadView, @Nullable AdvertisementInfo paramAdvertisementInfo, @Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJDownloadView, "view");
    if (NetworkUtil.isWifiConnected((Context)BaseApplicationImpl.getContext()))
    {
      FastWebRecommendAdHelper.a(paramRIJDownloadView.getContext(), paramAdvertisementInfo, true, 8);
      return false;
    }
    paramADVideoAppDownloadData = paramRIJDownloadView.getContext();
    boolean bool;
    if (paramAdvertisementInfo != null) {
      bool = paramAdvertisementInfo.isBottomAd;
    } else {
      bool = false;
    }
    ReadInJoyAdDialogUtil.a(paramADVideoAppDownloadData, paramAdvertisementInfo, true, bool, (DialogInterface.OnClickListener)new RIJAdDownloadUtil.doGameDownload.1(paramAdvertisementInfo, paramRIJDownloadView));
    return false;
  }
  
  public final boolean a(@Nullable String paramString)
  {
    boolean bool = PackageUtil.a((Context)BaseApplicationImpl.getContext(), paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isAppInstalled = ");
    localStringBuilder.append(bool);
    localStringBuilder.append("  packageName = ");
    localStringBuilder.append(paramString);
    QLog.d("AD_DOWNLOAD_TAG", 1, localStringBuilder.toString());
    return bool;
  }
  
  public final boolean b(@NotNull RIJDownloadView paramRIJDownloadView, @Nullable AdvertisementInfo paramAdvertisementInfo, @Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJDownloadView, "view");
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mChannelID != 3)) {
      ((IRIJFastWebRecommendAdService)QRoute.api(IRIJFastWebRecommendAdService.class)).onAdJump(paramRIJDownloadView.getContext(), paramAdvertisementInfo, true, 8);
    }
    return false;
  }
  
  public final boolean c(@NotNull RIJDownloadView paramRIJDownloadView, @Nullable AdvertisementInfo paramAdvertisementInfo, @Nullable ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJDownloadView, "view");
    ((IRIJFastWebRecommendAdService)QRoute.api(IRIJFastWebRecommendAdService.class)).onAdJump(paramRIJDownloadView.getContext(), paramAdvertisementInfo, true, 8);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadUtil
 * JD-Core Version:    0.7.0.1
 */