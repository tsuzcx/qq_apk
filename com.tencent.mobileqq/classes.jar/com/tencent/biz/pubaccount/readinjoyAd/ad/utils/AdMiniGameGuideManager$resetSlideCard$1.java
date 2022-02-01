package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.content.Context;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AdMiniGameGuideManager$resetSlideCard$1
  implements Runnable
{
  AdMiniGameGuideManager$resetSlideCard$1(ViewBase paramViewBase, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase != null)
    {
      AdMiniGameGuideManager.a(AdMiniGameGuideManager.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase, 0.0F);
      AppRuntime localAppRuntime = ReadInJoyUtils.a();
      Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "ReadInJoyUtils.getAppRuntime()");
      NativeAdUtils.a((Context)localAppRuntime.getApplication(), (BaseArticleInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int, this.b, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager.resetSlideCard.1
 * JD-Core Version:    0.7.0.1
 */