package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJAdDownloadViewBase$Builder;", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase$IBuilder;", "()V", "build", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "context", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJAdDownloadViewBase$Builder
  implements ViewBase.IBuilder
{
  @NotNull
  public ViewBase build(@NotNull VafContext paramVafContext)
  {
    Intrinsics.checkParameterIsNotNull(paramVafContext, "context");
    return (ViewBase)new RIJAdDownloadViewBase(paramVafContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJAdDownloadViewBase.Builder
 * JD-Core Version:    0.7.0.1
 */