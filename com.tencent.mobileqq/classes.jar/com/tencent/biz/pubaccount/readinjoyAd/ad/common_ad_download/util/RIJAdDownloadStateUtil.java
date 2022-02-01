package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util;

import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdDownloadStateUtil;", "", "()V", "convertToDownloadState", "", "status", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlResult;", "convertYYBStateToAdState", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJAdDownloadStateUtil
{
  public static final RIJAdDownloadStateUtil a = new RIJAdDownloadStateUtil();
  
  public final int a(int paramInt)
  {
    int j = 1;
    int i = j;
    if (paramInt != 13)
    {
      if (paramInt != 30) {
        i = j;
      }
      switch (paramInt)
      {
      case 1: 
      default: 
        return 0;
      case 4: 
      case 5: 
        return 5;
      case 3: 
        return 4;
      case 2: 
        return 3;
        i = 6;
      }
    }
    return i;
  }
  
  public final int a(@NotNull WadlResult paramWadlResult)
  {
    Intrinsics.checkParameterIsNotNull(paramWadlResult, "status");
    int k = paramWadlResult.d;
    int j = 1;
    if (k != 0)
    {
      if (k == 4) {
        break label72;
      }
      if (k == 5) {
        break label70;
      }
      if (k == 6) {
        break label68;
      }
      if (k != 7)
      {
        i = j;
        if (k == 9) {
          return i;
        }
        i = j;
        if (k == 10) {
          return i;
        }
      }
    }
    else
    {
      return 0;
    }
    return 6;
    label68:
    return 5;
    label70:
    return 4;
    label72:
    int i = 3;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadStateUtil
 * JD-Core Version:    0.7.0.1
 */