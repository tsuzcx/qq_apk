package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util;

import android.content.Context;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.GameCenterDownloadEngine;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.IDownloadEngine;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.YYBDownloadEngine;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.mobileqq.utils.PackageUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"checkRealState", "", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "convertToWadlParams", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlParams;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "getDownloadEngine", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/engine/IDownloadEngine;", "getPackageName", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "isDownloadAd", "", "isGameDownloadAd", "isGameGiftAd", "isGameSubscribeAd", "isNormalAppDownloadAd", "isShowDownloadProgress", "isSoftDownloadAd", "kandian_ad_feature_impl_release"}, k=2, mv={1, 1, 16})
public final class RIJAdDownloadExKt
{
  @NotNull
  public static final IDownloadEngine a(@NotNull ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    Intrinsics.checkParameterIsNotNull(paramADVideoAppDownloadData, "$this$getDownloadEngine");
    if (paramADVideoAppDownloadData.l) {
      return (IDownloadEngine)GameCenterDownloadEngine.a;
    }
    return (IDownloadEngine)YYBDownloadEngine.a;
  }
  
  public static final void a(@NotNull AdDownloadInfo paramAdDownloadInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAdDownloadInfo, "$this$checkRealState");
    if (PackageUtil.a((Context)BaseApplicationImpl.getContext(), paramAdDownloadInfo.a()))
    {
      paramAdDownloadInfo.a(1);
      paramAdDownloadInfo.b(100);
      return;
    }
    if (paramAdDownloadInfo.g() != null)
    {
      File localFile = new File(paramAdDownloadInfo.g());
      if ((localFile.exists()) && (localFile.isFile()))
      {
        paramAdDownloadInfo.a(5);
        paramAdDownloadInfo.b(100);
        return;
      }
    }
    if (paramAdDownloadInfo.b() == 5)
    {
      if (ADBaseAppDownloadManager.a((Context)BaseApplicationImpl.getContext(), paramAdDownloadInfo.a()))
      {
        paramAdDownloadInfo.a(5);
        paramAdDownloadInfo.b(100);
        return;
      }
      paramAdDownloadInfo.a(0);
      paramAdDownloadInfo.b(0);
      return;
    }
    if ((paramAdDownloadInfo.c() == 0) && (paramAdDownloadInfo.b() != 0))
    {
      paramAdDownloadInfo.a(0);
      return;
    }
    if (paramAdDownloadInfo.c() == 100)
    {
      if (PackageUtil.a((Context)BaseApplicationImpl.getContext(), paramAdDownloadInfo.a()))
      {
        paramAdDownloadInfo.a(1);
        return;
      }
      paramAdDownloadInfo.a(5);
    }
  }
  
  public static final boolean a(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null) {
      return ReadInJoyAdSwitchUtil.d(paramAdvertisementInfo);
    }
    return false;
  }
  
  @NotNull
  public static final WadlParams b(@NotNull ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    Intrinsics.checkParameterIsNotNull(paramADVideoAppDownloadData, "$this$convertToWadlParams");
    WadlParams localWadlParams = new WadlParams(paramADVideoAppDownloadData.a, paramADVideoAppDownloadData.d);
    localWadlParams.d = 7;
    localWadlParams.c = 2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramADVideoAppDownloadData.i);
    localStringBuilder.append("@");
    localStringBuilder.append(paramADVideoAppDownloadData.j);
    localWadlParams.y = localStringBuilder.toString();
    localWadlParams.k = paramADVideoAppDownloadData.c;
    localWadlParams.u = paramADVideoAppDownloadData.e;
    localWadlParams.A = "biz_src_feeds_kandianads";
    localWadlParams.w = "qq_vas_game";
    return localWadlParams;
  }
  
  public static final boolean b(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdvertisementInfo != null) {
      if ((!c(paramAdvertisementInfo)) && (!d(paramAdvertisementInfo)))
      {
        bool1 = bool2;
        if (!e(paramAdvertisementInfo)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static final boolean c(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdvertisementInfo != null)
    {
      bool1 = bool2;
      if (paramAdvertisementInfo.mAdProductType == 12) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static final boolean d(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdvertisementInfo != null)
    {
      bool1 = bool2;
      if (paramAdvertisementInfo.mAdvertisementSoftInfo != null)
      {
        bool1 = bool2;
        if (paramAdvertisementInfo.mAdvertisementSoftInfo.q == 1)
        {
          bool1 = bool2;
          if (paramAdvertisementInfo.mSoftAdType == 2) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static final boolean e(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdvertisementInfo != null)
    {
      bool1 = bool2;
      if (paramAdvertisementInfo.gameAdComData != null)
      {
        bool1 = bool2;
        if (paramAdvertisementInfo.mSoftAdType == 1)
        {
          bool1 = bool2;
          if (paramAdvertisementInfo.gameAdComData.t != null)
          {
            bool1 = bool2;
            if (Intrinsics.areEqual(paramAdvertisementInfo.gameAdComData.t, "2")) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static final boolean f(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdvertisementInfo != null)
    {
      bool1 = bool2;
      if (paramAdvertisementInfo.gameAdComData != null)
      {
        bool1 = bool2;
        if (paramAdvertisementInfo.mSoftAdType == 1)
        {
          bool1 = bool2;
          if (paramAdvertisementInfo.gameAdComData.t != null)
          {
            bool1 = bool2;
            if (Intrinsics.areEqual(paramAdvertisementInfo.gameAdComData.t, "1")) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static final boolean g(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdvertisementInfo != null)
    {
      bool1 = bool2;
      if (paramAdvertisementInfo.gameAdComData != null)
      {
        bool1 = bool2;
        if (paramAdvertisementInfo.mSoftAdType == 1)
        {
          bool1 = bool2;
          if (paramAdvertisementInfo.gameAdComData.t != null)
          {
            bool1 = bool2;
            if (Intrinsics.areEqual(paramAdvertisementInfo.gameAdComData.t, "3")) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadExKt
 * JD-Core Version:    0.7.0.1
 */